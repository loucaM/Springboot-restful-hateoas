package com.louca.springboot.rest.restfulrestwebservice.helloworld;



public class HelloWorldBean {
	
	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}
	
	
	public String getMessage() {
		return message;
	}

	public String setMessage(String message) {
		return String.format("HelloWorldBean message: %s", message);
	}
}
