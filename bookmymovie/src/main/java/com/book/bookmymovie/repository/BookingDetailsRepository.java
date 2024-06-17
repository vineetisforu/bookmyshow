package com.book.bookmymovie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.book.bookmymovie.model.Booking;
import com.book.bookmymovie.model.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer>{

	@Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update booking_details set is_booked = ?1  where booking_id=?2", nativeQuery = true)
    public Integer updateBookingDetailStatus(boolean status, int bookingId);
	
	
    @Query(value = "select * from booking_details where booking_id=?1", nativeQuery = true)
	public List<BookingDetails> getBookingDetails(int bookingId);
    
    
}
