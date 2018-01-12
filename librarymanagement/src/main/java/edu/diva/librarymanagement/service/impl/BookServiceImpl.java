package edu.diva.librarymanagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.diva.librarymanagement.constants.BookAction;
import edu.diva.librarymanagement.constants.LibraryManagementConstants;
import edu.diva.librarymanagement.model.Book;
import edu.diva.librarymanagement.rest.entity.BookDTO;
import edu.diva.librarymanagement.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private List<Book> booksCollection = new ArrayList<>();
	private Map<Long, Book> bookMap = new HashMap<>();

	private AtomicLong bookIdGenerator = new AtomicLong(0);
	
	@Override
	public void addBook(Book book) {
		book.setBookId(bookIdGenerator.incrementAndGet());
		book.setBookAvailable(true);
		bookMap.put(book.getBookId(), book);
		this.booksCollection.add(book);
	}

	@Override
	public List<BookDTO> searchBookByNameAndAuthor(String bookName, String authorName) {
		List<BookDTO> bookLists = this.booksCollection.stream()
				.filter(book -> book.getBookName().toLowerCase().startsWith(bookName.toLowerCase())
						&& book.getAuthorName().toLowerCase().startsWith(authorName.toLowerCase()))
				.map(book -> new BookDTO(book)).collect(Collectors.toList());
		return bookLists;
	}

	@Override
	public boolean isBookAvailable(long bookId) {
		return bookMap.get(bookId).isBookAvailable();
	}

	@Override
	public void transactBook(long bookId, BookAction action) {
		Book book = this.bookMap.get(bookId);
		if (action.getCode() == LibraryManagementConstants.ACTION_BORROW) {
			book.setBookAvailable(false);
		} else {
			book.setBookAvailable(true);
		}

	}

	@Override
	public Book getBookById(long bookId) {
		return this.bookMap.get(bookId);
	}
}
