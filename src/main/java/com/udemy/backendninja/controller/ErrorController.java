package com.udemy.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.udemy.backendninja.constants.ViewsConstant;

@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(Exception.class)
	public String showInternalError() {
		return ViewsConstant.SERVER_INTERNAL_ERROR;
	}
	
}
