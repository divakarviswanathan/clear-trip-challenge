package edu.diva.librarymanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.diva.librarymanagement.constants.LibraryManagementConstants;
import edu.diva.librarymanagement.exception.BookUnavailableException;
import edu.diva.librarymanagement.exception.LimitExceededException;
import edu.diva.librarymanagement.model.BookTransaction;
import edu.diva.librarymanagement.service.BookService;
import edu.diva.librarymanagement.service.LibraryService;
import edu.diva.librarymanagement.service.UserService;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	private List<BookTransaction> bookTransactionCollection = new ArrayList<>();

	@Override
	public void transactBook(BookTransaction bookTransaction) throws LimitExceededException, BookUnavailableException {
		if (bookTransaction.getAction().getCode() == LibraryManagementConstants.ACTION_BORROW) {
			if (userService.eligibleForBorrow(bookTransaction.getUserId())) {
				if (bookService.isBookAvailable(bookTransaction.getBookId())) {
					userService.transactBook(bookTransaction.getUserId(),
							bookService.getBookById(bookTransaction.getBookId()), bookTransaction.getAction());
					bookService.transactBook(bookTransaction.getBookId(), bookTransaction.getAction());
					this.bookTransactionCollection.add(bookTransaction);
				} else {
					throw new BookUnavailableException();
				}
			} else {
				throw new LimitExceededException();
			}
		} else {
			userService.transactBook(bookTransaction.getUserId(), bookService.getBookById(bookTransaction.getBookId()),
					bookTransaction.getAction());
			bookService.transactBook(bookTransaction.getBookId(), bookTransaction.getAction());
			this.bookTransactionCollection.add(bookTransaction);
		}


	}
}
