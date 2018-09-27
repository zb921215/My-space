package com.company.utils;

import com.company.entity.JsonResult;
import com.company.enums.ResultEnum;
import com.company.exception.CustomException;

import java.util.List;

public class ResultUtil {

    public static JsonResult success(Object object) {
    	JsonResult result = new JsonResult(ResultEnum.NORMAL.getStatus(), ResultEnum.NORMAL.getMessage());
		result.setData(object);
        return result;
    }
    
    public static JsonResult success() {
        return success(null);
    }
    
    public static JsonResult successList(List<?> list,Long total) {
    	JsonResult result = new JsonResult(ResultEnum.NORMAL.getStatus(),ResultEnum.NORMAL.getMessage());
        result.setRows(list);
        result.setTotal(total);
        return result;
    }
    
    public static JsonResult successList() {
        return successList(null,0L);
    }

    public static JsonResult error(ResultEnum resultEnum) {
        JsonResult result = new JsonResult(resultEnum.getStatus(),resultEnum.getMessage());
        return result;
    }

    public static JsonResult error(CustomException manageException) {
        JsonResult result = new JsonResult(manageException.getStatus(),manageException.getMessage());
        return result;
    }

}
