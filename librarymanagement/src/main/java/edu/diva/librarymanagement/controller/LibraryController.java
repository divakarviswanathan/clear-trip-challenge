package edu.diva.librarymanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.diva.librarymanagement.exception.BookUnavailableException;
import edu.diva.librarymanagement.exception.LimitExceededException;
import edu.diva.librarymanagement.model.BookTransaction;
import edu.diva.librarymanagement.rest.entity.BookTransactionDTO;
import edu.diva.librarymanagement.service.LibraryService;
import edu.diva.librarymanagement.util.ObjectConverterUtil;

@RestController
@RequestMapping("v1/library")
public class LibraryController {

	private final Logger logger = LoggerFactory.getLogger(LibraryController.class);

	@Autowired
	private LibraryService libraryService;

	@Autowired
	private ObjectConverterUtil objectConverterUtil;

	@Value("${user.max.book.limit}")
	private int bookLimit;

	@RequestMapping(method = RequestMethod.POST)
	public String transactBook(@RequestBody BookTransactionDTO bookTransactionDTO)
			throws LimitExceededException, BookUnavailableException {
		logger.info("Entering new book transaction");
		BookTransaction bookTransaction = objectConverterUtil.convertFromTransactionDTO(bookTransactionDTO);
		libraryService.transactBook(bookTransaction);
		return "SUCCESS";
	}

}
