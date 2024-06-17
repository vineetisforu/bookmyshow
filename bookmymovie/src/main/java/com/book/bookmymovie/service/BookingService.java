package com.book.bookmymovie.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.book.bookmymovie.pojo.BookingResponse;

public interface BookingService {

	
	public BookingResponse bookTicket(HttpServletRequest request, int userId, int listingId, List<String> seats);
	public BookingResponse fetchBooking(HttpServletRequest request, int userId, int bookingId) throws Exception;
	public BookingResponse deleteBooking(HttpServletRequest request, int userId, int bookingId) throws Exception;
	
}
