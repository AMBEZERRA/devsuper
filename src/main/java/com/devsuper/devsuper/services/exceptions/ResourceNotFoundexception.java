package com.devsuper.devsuper.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	// criar a classe de Excessões para tratar os erros 400
	// extrends o RuntimeException para não precisar do Try cath
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
