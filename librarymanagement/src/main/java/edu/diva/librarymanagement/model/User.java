package edu.diva.librarymanagement.model;

import java.util.List;

/*@Entity
@Table(name = "user")*/
public class User {

	/*@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private Long userId;

	//@Column
	private String userName;

	//@Column
	private int maxLimit;

	//@Column
	private List<Book> borrowedBooks;

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public int getMaxLimit() {
		return maxLimit;
	}

	public List<Book> getBorrowedBooks() {
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

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

}
