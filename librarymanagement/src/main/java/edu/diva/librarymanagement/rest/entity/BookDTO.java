package edu.diva.librarymanagement.rest.entity;

import javax.validation.constraints.NotNull;

import edu.diva.librarymanagement.model.Book;

public class BookDTO {

	private Long bookId;

	@NotNull
	private String bookName;

	@NotNull
	private String authorName;

	public BookDTO() {

	}

	public BookDTO(Book book) {
		this.bookId = book.getBookId();
		this.bookName = book.getBookName();
		this.authorName = book.getAuthorName();
	}

	public Long getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
