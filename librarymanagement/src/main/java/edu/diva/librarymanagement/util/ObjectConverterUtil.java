package edu.diva.librarymanagement.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import edu.diva.librarymanagement.constants.BookAction;
import edu.diva.librarymanagement.model.Book;
import edu.diva.librarymanagement.model.BookTransaction;
import edu.diva.librarymanagement.model.User;
import edu.diva.librarymanagement.rest.entity.BookDTO;
import edu.diva.librarymanagement.rest.entity.BookTransactionDTO;
import edu.diva.librarymanagement.rest.entity.UserDTO;

@Component
public class ObjectConverterUtil {

	public User convertFromUserDTO(UserDTO dto, int bookLimit) {
		User entity = new User();
		entity.setUserId(dto.getUserId());
		if (dto.getMaxLimit() <= 0) {
			entity.setMaxLimit(bookLimit);
		} else {
			entity.setMaxLimit(dto.getMaxLimit());
		}
		entity.setUserName(dto.getUserName());
		return entity;
	}

	public Book convertFromBookDTO(BookDTO dto) {
		Book entity = new Book();
		entity.setBookId(dto.getBookId());
		entity.setAuthorName(dto.getAuthorName());
		entity.setBookName(dto.getBookName());
		return entity;
	}

	public BookTransaction convertFromTransactionDTO(BookTransactionDTO dto) {
		BookTransaction entity = new BookTransaction();
		entity.setAction(BookAction.getActionByCode(dto.getAction()));
		entity.setBookId(dto.getBookId());
		entity.setUserId(dto.getUserId());
		entity.setTransactionDate(new Date());
		return entity;
	}
}
