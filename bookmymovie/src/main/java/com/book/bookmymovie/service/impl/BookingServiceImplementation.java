package com.book.bookmymovie.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookmymovie.controller.ListingController;
import com.book.bookmymovie.model.Booking;
import com.book.bookmymovie.model.BookingDetails;
import com.book.bookmymovie.model.Listing;
import com.book.bookmymovie.model.Movie;
import com.book.bookmymovie.model.Theatre;
import com.book.bookmymovie.pojo.BookingResponse;
import com.book.bookmymovie.pojo.SearchListing;
import com.book.bookmymovie.repository.BookingDetailsRepository;
import com.book.bookmymovie.repository.BookingRepository;
import com.book.bookmymovie.repository.InventoryDetailsRepository;
import com.book.bookmymovie.repository.ListingRepository;
import com.book.bookmymovie.repository.MovieRepository;
import com.book.bookmymovie.repository.TheatreRepository;
import com.book.bookmymovie.service.BookingService;
import com.book.bookmymovie.service.ListingService;

@Service
public class BookingServiceImplementation implements BookingService{

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImplementation.class);
	
	@Autowired
	ListingService listingService;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	BookingDetailsRepository bookingDetailsRepository;
	
	@Autowired
	InventoryDetailsRepository inventoryDetailsRepository;
	
	@Autowired
	ListingRepository listingRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Override
	public BookingResponse bookTicket(HttpServletRequest request, int userId, int listingId, List<String> seats) {
		// TODO Auto-generated method stub
		
		List<BookingDetails> bdList = new ArrayList<BookingDetails>();
		BookingResponse bookingResponse;
		List<String> bookedSeats = new ArrayList<String>();
		int totalPrice = 0;
		
		List<SearchListing> listing = listingService.readSeatWiseListing(request, listingId, seats);
		
		Booking booking = new Booking();
		booking.setUserId(userId);
		booking.setListingId(listingId);
		booking.setNoOfSeats(listing.size());
		
		Booking booked = bookingRepository.saveAndFlush(booking);
		
		for(SearchListing sl :listing) {

			BookingDetails bd = new BookingDetails();
			bd.setBookingId(booked.getId());
			bd.setUserId(userId);
			bd.setListingId(listingId);
			bd.setSeatName(sl.getSeatName());
			
			bdList.add(bd);
			
			bookedSeats.add(sl.getSeatName());
			totalPrice += sl.getPrice();
		}
		
		bookingDetailsRepository.saveAllAndFlush(bdList);
		
		
		
		for(String each : bookedSeats)
			inventoryDetailsRepository.updateSeatStatus(false, each, listingId);
		
		SearchListing singleListing = listing.get(0);
		
		bookingResponse = new BookingResponse(booked.getId(), singleListing.getTheatreName(), 
				singleListing.getCity(), singleListing.getMovieName(), singleListing.getShowTiming(), 
				singleListing.getScreenId(), totalPrice, bookedSeats);
		
				
		return bookingResponse;
	}



	@Override
	public BookingResponse fetchBooking(HttpServletRequest request, int userId, int bookingId) throws Exception {
		// TODO Auto-generated method stub
		
		List<BookingDetails> bookingDetails =  bookingDetailsRepository.getBookingDetails(bookingId);
		Booking booking = bookingRepository.getBooking(bookingId);
		
		LOGGER.info(bookingDetails.toString());
		
		List<String> seatList = new ArrayList<String>();
		
		for(BookingDetails bd : bookingDetails)
			seatList.add(bd.getSeatName());
		
		BookingResponse bookingResponse;
		
		if(booking.getUserId() != userId)
			throw new Exception("User Mismatched");
		
		Listing listing = listingRepository.getListing(booking.getListingId());
		
		Movie movie = movieRepository.getMovie(listing.getMovieId());
		
		Theatre theatre = theatreRepository.getTheatre(listing.getTheatreId());
		
		bookingResponse = new BookingResponse(bookingId, theatre.getName(), 
				theatre.getCity(), movie.getName(), listing.getShowTiming(), 
				listing.getScreenId(), 0, seatList);
		
		LOGGER.info(bookingResponse.toString());
		
		return bookingResponse;
	}



	@Override
	public BookingResponse deleteBooking(HttpServletRequest request, int userId, int bookingId) throws Exception {
		// TODO Auto-generated method stub
		List<BookingDetails> bookingDetails =  bookingDetailsRepository.getBookingDetails(bookingId);
		Booking booking = bookingRepository.getBooking(bookingId);
		
		booking.setBooked(false);
		bookingRepository.saveAndFlush(booking);
		
		List<String> seatList = new ArrayList<String>();
		
		for(BookingDetails bd : bookingDetails) {
			bd.setBooked(false);
			seatList.add(bd.getSeatName());
		}
		
		bookingDetailsRepository.saveAllAndFlush(bookingDetails);
		
		BookingResponse bookingResponse;
		
		if(booking.getUserId() != userId)
			throw new Exception("User Mismatched");
		
		Listing listing = listingRepository.getListing(booking.getListingId());
		
		Movie movie = movieRepository.getMovie(listing.getMovieId());
		
		Theatre theatre = theatreRepository.getTheatre(listing.getTheatreId());
		
		bookingResponse = new BookingResponse(bookingId, theatre.getName(), 
				theatre.getCity(), movie.getName(), null, 
				null, 0, null);
		
		bookingResponse.setStatus("cancelled");
		

		for(String each : seatList)
			inventoryDetailsRepository.updateSeatStatus(true, each, booking.getListingId());
		
		return bookingResponse;
	}

}
