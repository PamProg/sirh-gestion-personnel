package dev.sgp.exception;

public class NirDontMatchException extends Exception {

	
	/**
	 * 
	 */
	public NirDontMatchException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NirDontMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NirDontMatchException(String message) {
		super(message);
	}

	
}
