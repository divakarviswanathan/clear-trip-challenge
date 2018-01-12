package edu.diva.librarymanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.diva.librarymanagement.model.Book;
import edu.diva.librarymanagement.rest.entity.BookDTO;
import edu.diva.librarymanagement.service.BookService;
import edu.diva.librarymanagement.util.ObjectConverterUtil;

@RestController
@RequestMapping("v1/book")
public class BookController {

	private final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@Autowired
	private ObjectConverterUtil objectConverterUtil;

	@Value("${user.max.book.limit}")
	private int bookLimit;

	@RequestMapping(method = RequestMethod.POST)
	public String addBook(@RequestBody BookDTO bookDTO) {
		logger.info("Entering add book");
		Book book = objectConverterUtil.convertFromBookDTO(bookDTO);
		bookService.addBook(book);
		return "SUCCESS";
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<BookDTO> searchUserByName(@RequestParam(value = "bookName") String bookName,
			@RequestParam(value = "authorName") String authorName) {
		logger.info("Entering searching user by name");
		return bookService.searchBookByNameAndAuthor(bookName, authorName);
	}

}
