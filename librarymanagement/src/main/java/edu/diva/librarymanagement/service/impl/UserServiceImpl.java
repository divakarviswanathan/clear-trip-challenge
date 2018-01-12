package edu.diva.librarymanagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.diva.librarymanagement.constants.BookAction;
import edu.diva.librarymanagement.constants.LibraryManagementConstants;
import edu.diva.librarymanagement.model.Book;
import edu.diva.librarymanagement.model.User;
import edu.diva.librarymanagement.rest.entity.UserDTO;
import edu.diva.librarymanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private List<User> usersCollection = new ArrayList<>();
	private Map<Long, User> userMap = new HashMap<>();

	private AtomicLong userIdGenerator = new AtomicLong(0);
	
	@Value("${user.max.book.limit}")
	private int bookLimit;

	@Override
	public void addUser(User user) {
		user.setUserId(userIdGenerator.incrementAndGet());
		user.setBorrowedBooks(new ArrayList<Book>());
		userMap.put(user.getUserId(), user);
		this.usersCollection.add(user);
	}

	@Override
	public List<UserDTO> searchUserByName(String userName) {
		List<UserDTO> userLists = this.usersCollection.stream()
				.filter(user -> user.getUserName().toLowerCase().startsWith(userName.toLowerCase()))
				.map(user -> new UserDTO(user)).collect(Collectors.toList());
		return userLists;
	}

	public void transactBook(long userId, Book book, BookAction action) {
		User user = this.userMap.get(userId);
		if(action.getCode() == LibraryManagementConstants.ACTION_BORROW) {
			user.getBorrowedBooks().add(book);
		} else {
			Iterator<Book> itr = (Iterator<Book>) user.getBorrowedBooks();
			while(itr.hasNext()) {
				if (itr.next().getBookId() == book.getBookId()) {
					itr.remove();
					break;
				}
			}
		}
		this.userMap.put(userId, user);
	}

	@Override
	public boolean eligibleForBorrow(long userId) {
		// TODO Auto-generated method stub
		User user = this.userMap.get(userId);
		return user.getBorrowedBooks().size() < bookLimit;
	}

}
