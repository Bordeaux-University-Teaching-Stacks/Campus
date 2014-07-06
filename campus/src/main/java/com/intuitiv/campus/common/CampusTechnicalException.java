package com.intuitiv.campus.common;


public class CampusTechnicalException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code;

	/**
	 * Constructeur par défaut.
	 */
	public CampusTechnicalException() {
		super();
		this.code = -1;
	}

	/**
	 * Constructeur.
	 * 
	 * @param message message associé à l'erreur.
	 */
	public CampusTechnicalException(String message) {
		super(message);
	}

	/**
	 * Constructeur.
	 * 
	 * @param code : le code de l'erreur
	 */
	public CampusTechnicalException(int code) {
		this.code = code;
	}

	/**
	 * Constructeur.
	 * 
	 * @param ex cause de l'exception
	 */
	public CampusTechnicalException(Throwable ex) {
		super(ex);
	}

	/**
	 * Constructeur.
	 * 
	 * @param message message associé à l'erreur.
	 * @param ex cause de l'exception
	 */
	public CampusTechnicalException(String message, Throwable ex) {
		super(message, ex);
	}

	/**
	 * Get the code.
	 * 
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

}
