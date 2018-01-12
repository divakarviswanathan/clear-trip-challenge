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

import edu.diva.librarymanagement.model.User;
import edu.diva.librarymanagement.rest.entity.UserDTO;
import edu.diva.librarymanagement.service.UserService;
import edu.diva.librarymanagement.util.ObjectConverterUtil;

@RestController
@RequestMapping("v1/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ObjectConverterUtil objectConverterUtil;

	@Value("${user.max.book.limit}")
	private int bookLimit;

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@RequestBody UserDTO userDTO) {
		logger.info("Entering add user");
		User user = objectConverterUtil.convertFromUserDTO(userDTO, bookLimit);
		userService.addUser(user);
		return "SUCCESS";
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<UserDTO> searchUserByName(@RequestParam(required = true, value = "userName") String userName) {
		logger.info("Entering searching user by name");
		return userService.searchUserByName(userName);
	}

}
