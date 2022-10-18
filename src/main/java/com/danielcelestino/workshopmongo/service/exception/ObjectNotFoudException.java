package com.danielcelestino.workshopmongo.service.exception;

public class ObjectNotFoudException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoudException(String msg){
		super(msg);
	}

}
