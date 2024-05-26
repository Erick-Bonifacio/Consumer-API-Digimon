package com.digimonConsumer.demo.services.exceptions;

public class DigimonNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DigimonNotFoundException(String nameOrLevel) {
		super(nameOrLevel + " não encontrado!");
	}
	
}
