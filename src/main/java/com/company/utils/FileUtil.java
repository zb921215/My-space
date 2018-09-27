package com.company.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

    //上传文件
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 将上传的文件进行重命名
     * @param name
     * @return
     */
    public static String reName(String name) {
        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        Long random = (long) (Math.random() * now);
        String fileName = now + "" + random;
        if (name.indexOf(".") != -1) {
            fileName += name.substring(name.lastIndexOf("."));
        }
        return fileName;
    }

    public static void main(String[] args) {
        String a = reName("123.txt");
        System.out.print(a);
    }

}
