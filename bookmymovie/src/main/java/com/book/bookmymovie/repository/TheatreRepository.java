package com.book.bookmymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.bookmymovie.model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer>{

	@Query(value = "select * from theatre where id=?1", nativeQuery = true)
	public Theatre getTheatre(int theatreId);
}
