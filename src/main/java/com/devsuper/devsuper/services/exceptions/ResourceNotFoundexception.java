package com.devsuper.devsuper.services.exceptions;

public class ResourceNotFoundexception extends RuntimeException{
	
	// criar a classe de Excessões para tratar os erros 400
	// extrends o RuntimeException para não precisar do Try cath
	
	public ResourceNotFoundexception(String msg) {
		super(msg);
	}

}
