package com.book.bookmymovie.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookmymovie.model.User;
import com.book.bookmymovie.repository.UserRepository;
import com.book.bookmymovie.service.UserService;

@Service
public class UserServiceImplementation implements UserService{

	
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplementation.class);
    
    @Autowired
    private UserRepository userRepository;
    
	@Override
	public User saveUser(HttpServletRequest request, User user) {
		// TODO Auto-generated method stub
		
		User response = userRepository.save(user);
		return response;
	}

}
