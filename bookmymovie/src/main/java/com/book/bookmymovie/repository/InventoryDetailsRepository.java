package com.book.bookmymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.book.bookmymovie.model.InventoryDetails;

public interface InventoryDetailsRepository extends JpaRepository<InventoryDetails, Integer>{
	
	@Query(value = "select count(*) from inventory_details where listing_id=?1 and available = true", nativeQuery = true)
    public Integer getAvailableSeats(int listingId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update inventory_details set available = ?1  where seat_name=?2 and listing_id=?3", nativeQuery = true)
    public Integer updateSeatStatus(boolean status, String seat, int listingId);
	
}
