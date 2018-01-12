package edu.diva.librarymanagement.model;

import java.util.Date;

import edu.diva.librarymanagement.constants.BookAction;

public class BookTransaction {

	private Long userId;

	private Long bookId;

	private Date transactionDate;

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	private BookAction action;

	public BookTransaction() {

	}

	public Long getUserId() {
		return userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public BookAction getAction() {
		return action;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public void setAction(BookAction action) {
		this.action = action;
	}

}