package com.example.awesomepizza.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PizzaNotFoundAdvice {
    
	@ResponseBody
	@ExceptionHandler(PizzaNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String pizzaNotFoundException(PizzaNotFoundException ex) {
		return ex.getMessage();
	}
}
