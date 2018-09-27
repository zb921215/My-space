package com.company.exception;

import com.company.enums.ResultEnum;

public class CustomException extends RuntimeException{

    private String status;

    public CustomException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.status = resultEnum.getStatus();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
