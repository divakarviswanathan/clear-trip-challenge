package edu.diva.librarymanagement.rest.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BookTransactionDTO {

	@NotNull
	private Long userId;

	@NotNull
	private Long bookId;

	private Date transactionDate;

	@NotNull
	private String action;

	public BookTransactionDTO() {

	}

	public Long getUserId() {
		return userId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getBookId() {
		return bookId;
	}

	public String getAction() {
		return action;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
