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

import com.book.bookmymovie.model.Movie;
import com.book.bookmymovie.model.User;
import com.book.bookmymovie.service.MovieService;
import com.book.bookmymovie.service.UserService;

@RestController
@RequestMapping("/api/v1/movie")
@CrossOrigin
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;

    @PostMapping("/register")
    public ResponseEntity<Movie> saveMovie(HttpServletRequest httpServletRequest, @RequestBody Movie movieRequest) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	
    	Movie movie = movieService.saveMovie(httpServletRequest, movieRequest);
    	
    	return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
	
}
