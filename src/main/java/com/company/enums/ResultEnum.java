package com.company.enums;

public enum ResultEnum {
	/*0开头的代码是系统捕捉出来的异常。根据异常类型，设置返回值。*/
	NORMAL("000", "正常"),
	LOGIN_ERROR("001","登录失败"),
    NO_SESSION("002","未登录或登录超时！"),
    NO_MATCH("003","原密码输入错误！"),
    FILE_ERROR("004","上传失败！"),
	OTHER_EXCEPTION("099", "其他异常");
	/*Arithmetic("001","算术异常"),
	Nullpoint("002","空指针异常"),
	Database("003","数据库异常"),
	SQLServer("004","数据库服务异常"),
	
	Mybatis("006","Mybatis查询参数或返回值异常"),
	IndexOut("007","下标越界"),
	ClassNotFound("008","类不存在"),
	NumberFormat("009","字符串转数字异常"),
	IllegalArgument("010","参数不合法"),
	IllegalAccess("011","没有该类的访问权限"),
	ClassCast("012","数据类型转化异常"),
	FileNotFound("013","文件未找到"),
	Interrupted("014","线程被终止"),
	Io("015","输入或输出流异常"),
	EOF("016","文件已结束异常"),
	Badsql("017","SQL书写异常"),
	OTHER_EXCEPTION("099", "其他异常"),
	开头的状态码是后端根据逻抛出的异常状态码及信息
	Permission_Nodata("100","权限无数据"),
	Nopermission("101","无操作权限"),
	Noparam("102", "缺少参数"),
	ObjectIsNull("103","返回对象为null"),
	USER_NO_EXIST("005","用户不存在"),
	PASSWORD_ERROR("018","密码错误"),
	NOT_UNIQUE("019","页面编码重复")*/
	;
	
    private String status;
    private String message;

    ResultEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
