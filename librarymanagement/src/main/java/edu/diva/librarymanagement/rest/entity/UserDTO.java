package edu.diva.librarymanagement.rest.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import edu.diva.librarymanagement.model.User;

public class UserDTO {

	private Long userId;

	@NotNull
	private String userName;
	private int maxLimit;
	private List<BookDTO> borrowedBooks;

	public UserDTO() {

	}

	public UserDTO(User user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.maxLimit = user.getMaxLimit();
		this.borrowedBooks = null; // books;

	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public int getMaxLimit() {
		return maxLimit;
	}

	public List<BookDTO> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}

	public void setBorrowedBooks(List<BookDTO> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

}
