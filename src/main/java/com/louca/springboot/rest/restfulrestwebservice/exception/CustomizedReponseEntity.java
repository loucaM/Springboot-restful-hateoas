package com.louca.springboot.rest.restfulrestwebservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice //Permet d'éhanger des choses entre controleurs
@RestController
public class CustomizedReponseEntity extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
//		ExceptionResponse eR = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//		
//		return new ResponseEntity<>(eR, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handlUserNotFound(Exception ex, WebRequest request) {
//		ExceptionResponse eR = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//		
//		return new ResponseEntity<>(eR, HttpStatus.NOT_FOUND);
//	}
}
