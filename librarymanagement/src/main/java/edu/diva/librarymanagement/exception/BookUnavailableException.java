package edu.diva.librarymanagement.exception;

public class BookUnavailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookUnavailableException() {
		super("Book is not available");
	}

}
