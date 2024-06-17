package com.book.bookmymovie.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookmymovie.pojo.BookingResponse;
import com.book.bookmymovie.service.BookingService;

@RestController
@RequestMapping("/api/v1/booking")
@CrossOrigin
public class BookingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	private BookingService bookingService;

    @GetMapping("/create")
    public ResponseEntity<BookingResponse> bookTicket(HttpServletRequest httpServletRequest, @RequestParam Map<String, String> params) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	int userId = Integer.parseInt(params.get("userId"));
    	int listingId = Integer.parseInt(params.get("listingId"));
    	List<String> seats = Arrays.asList(params.get("seats").split(","));
    	
    	BookingResponse bookingResponse = bookingService.bookTicket(httpServletRequest, userId, listingId, seats);
    	
    	return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
    }
	
    @GetMapping("/read")
    public ResponseEntity<BookingResponse> fetchBooking(HttpServletRequest httpServletRequest, @RequestParam Map<String, String> params) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	int userId = Integer.parseInt(params.get("userId"));
    	int bookingId = Integer.parseInt(params.get("bookingId"));
    	
    	BookingResponse bookingResponse = null;
    	
		try {
			bookingResponse = bookingService.fetchBooking(httpServletRequest, userId, bookingId);
			LOGGER.info(bookingResponse.toString());
			return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			LOGGER.error("Exception out ", e);
			return new ResponseEntity<>(bookingResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
    
    @GetMapping("/cancel")
    public ResponseEntity<BookingResponse> deleteBooking(HttpServletRequest httpServletRequest, @RequestParam Map<String, String> params) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	int userId = Integer.parseInt(params.get("userId"));
    	int bookingId = Integer.parseInt(params.get("bookingId"));
    	
    	BookingResponse bookingResponse = null;
    	
		try {
			bookingResponse = bookingService.deleteBooking(httpServletRequest, userId, bookingId);
			return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return new ResponseEntity<>(bookingResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
}
