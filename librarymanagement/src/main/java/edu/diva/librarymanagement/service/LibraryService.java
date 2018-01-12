package edu.diva.librarymanagement.service;

import edu.diva.librarymanagement.exception.BookUnavailableException;
import edu.diva.librarymanagement.exception.LimitExceededException;
import edu.diva.librarymanagement.model.BookTransaction;

public interface LibraryService {

	void transactBook(BookTransaction bookTransaction) throws LimitExceededException, BookUnavailableException;
}
