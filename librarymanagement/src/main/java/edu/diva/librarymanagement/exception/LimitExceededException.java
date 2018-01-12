package edu.diva.librarymanagement.exception;

public class LimitExceededException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LimitExceededException() {
		super("User has exceeded book limit");
	}
}
