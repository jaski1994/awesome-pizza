package com.example.awesomepizza.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OrdersNotFoundAdvice {
    
	@ResponseBody
	@ExceptionHandler(OrdersNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String ordersNotFoundException(OrdersNotFoundException ex) {
		return ex.getMessage();
	}
}
