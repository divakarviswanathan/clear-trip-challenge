package edu.diva.librarymanagement.service;

import java.util.List;

import edu.diva.librarymanagement.constants.BookAction;
import edu.diva.librarymanagement.model.Book;
import edu.diva.librarymanagement.rest.entity.BookDTO;

public interface BookService {

	void addBook(Book book);

	List<BookDTO> searchBookByNameAndAuthor(String bookName, String bookAuthor);

	boolean isBookAvailable(long bookId);

	void transactBook(long bookId, BookAction action);

	Book getBookById(long bookId);
}
