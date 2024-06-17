package com.book.bookmymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.bookmymovie.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
