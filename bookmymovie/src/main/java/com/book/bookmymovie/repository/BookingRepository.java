package com.book.bookmymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.book.bookmymovie.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	@Query(value = "select * from booking where id=?1", nativeQuery = true)
	public Booking getBooking(int bookingId);
	
	@Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update booking set is_booked = ?1  where booking_id=?2", nativeQuery = true)
    public Integer updateBookingStatus(boolean status, int bookingId);

}
