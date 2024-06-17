package com.book.bookmymovie.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookmymovie.model.User;
import com.book.bookmymovie.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(HttpServletRequest httpServletRequest, @RequestBody User userRequest) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	
    	User user = userService.saveUser(httpServletRequest, userRequest);
    	
    	return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
	
}
