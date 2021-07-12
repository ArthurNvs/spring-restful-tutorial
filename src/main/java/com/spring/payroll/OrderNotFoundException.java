package com.spring.payroll;

public class OrderNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2889418453357471858L;
	
	OrderNotFoundException(Long id) {
		super("Could not find order " + id);
	}

}
