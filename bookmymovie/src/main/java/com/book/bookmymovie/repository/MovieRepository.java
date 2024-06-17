package com.book.bookmymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.bookmymovie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

	@Query(value = "select * from movie where id=?1", nativeQuery = true)
	public Movie getMovie(int movieId);
}
