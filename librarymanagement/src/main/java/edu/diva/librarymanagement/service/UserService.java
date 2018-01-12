package edu.diva.librarymanagement.service;

import java.util.List;

import edu.diva.librarymanagement.constants.BookAction;
import edu.diva.librarymanagement.model.Book;
import edu.diva.librarymanagement.model.User;
import edu.diva.librarymanagement.rest.entity.UserDTO;

public interface UserService {

	void addUser(User user);

	List<UserDTO> searchUserByName(String userName);

	boolean eligibleForBorrow(long userId);

	void transactBook(long userId, Book book, BookAction action);
}
