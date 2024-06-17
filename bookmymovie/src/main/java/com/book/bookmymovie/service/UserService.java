package com.book.bookmymovie.service;

import javax.servlet.http.HttpServletRequest;

import com.book.bookmymovie.model.User;

public interface UserService {

	public User saveUser(HttpServletRequest request, User user);
}
