package com.book.bookmymovie.service;

import javax.servlet.http.HttpServletRequest;

import com.book.bookmymovie.model.Movie;

public interface MovieService {

	public Movie saveMovie(HttpServletRequest request, Movie movie);
	
}
