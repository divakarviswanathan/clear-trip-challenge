package edu.diva.librarymanagement.model;

/*@Entity
@Table(name = "book")*/
public class Book {

	/*@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private Long bookId;

	//@Column
	private String bookName;

	//@Column
	private String authorName;

	public boolean isBookAvailable() {
		return isBookAvailable;
	}

	public void setBookAvailable(boolean isBookAvailable) {
		this.isBookAvailable = isBookAvailable;
	}

	private boolean isBookAvailable;

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
