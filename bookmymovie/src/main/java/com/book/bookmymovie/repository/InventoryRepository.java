package com.book.bookmymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.bookmymovie.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
