package com.book.bookmymovie.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookmymovie.model.Movie;
import com.book.bookmymovie.repository.MovieRepository;
import com.book.bookmymovie.service.MovieService;

@Service
public class MovieServiceImplementation implements MovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImplementation.class);
    
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public Movie saveMovie(HttpServletRequest request, Movie movie) {
		// TODO Auto-generated method stub
		Movie savedMovie = movieRepository.save(movie);
		return savedMovie;
	}

}
