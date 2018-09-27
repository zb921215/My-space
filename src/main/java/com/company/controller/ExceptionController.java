package com.company.controller;

import com.company.entity.JsonResult;
import com.company.enums.ResultEnum;
import com.company.exception.CustomException;
import com.company.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(value = {Exception.class})
	@ResponseBody
	public JsonResult handle(Exception e) {
		logger.info(e.getMessage());
		if(e instanceof CustomException){
			CustomException manageException = (CustomException) e;
			return ResultUtil.error(manageException);
		}else{
			return ResultUtil.error(ResultEnum.OTHER_EXCEPTION);
		}
	}

}
