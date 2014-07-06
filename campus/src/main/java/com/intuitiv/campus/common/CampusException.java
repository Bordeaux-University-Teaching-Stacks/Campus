package com.intuitiv.campus.common;

public class CampusException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut
	 */
	public CampusException() {
	}

	/**
	 * Constructeur.
	 * 
	 * @param message : le message d'erreur
	 */
	public CampusException(String message) {
		super(message);
	}

	/**
	 * Constructeur.
	 * 
	 * @param ex : l'exception
	 */
	public CampusException(Throwable ex) {
		super(ex);
	}

	/**
	 * Constructeur.
	 * 
	 * @param message : le message
	 * @param ex : l'exception
	 */
	public CampusException(String message, Throwable ex) {
		super(message, ex);
	}

}
