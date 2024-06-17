package com.book.bookmymovie.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookmymovie.model.Listing;
import com.book.bookmymovie.pojo.SearchListing;
import com.book.bookmymovie.service.ListingService;
import com.book.bookmymovie.util.Utility;

@RestController
@RequestMapping("/api/v1/listing")
@CrossOrigin
public class ListingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ListingController.class);
	
	@Autowired
	private ListingService listingService;
	
//	@Autowired
//	private Utility utility;

    @PostMapping("/feed")
    public ResponseEntity<Listing> saveListing(HttpServletRequest httpServletRequest, @RequestBody Listing listingRequest) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	
    	Listing listing = listingService.saveListing(httpServletRequest, listingRequest);
    	
    	return new ResponseEntity<>(listing, HttpStatus.CREATED);
    }
    
    
    @PostMapping("/update")
    public ResponseEntity<Listing> updateListing(HttpServletRequest httpServletRequest, @RequestBody Listing listingRequest) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	Listing listing = listingService.readListing(httpServletRequest, listingRequest.getId());
    	Utility.copyNonNullProperties(listingRequest, listing);
    	Listing updatedListing = listingService.saveListing(httpServletRequest, listing);
    	
    	return new ResponseEntity<>(updatedListing, HttpStatus.OK);
    }
    
    
    @GetMapping("/search")
    public ResponseEntity<List<SearchListing>> searchListing(HttpServletRequest httpServletRequest, @RequestParam Map<String, String> params ) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	
    	String city = params.get("city");
    	int movieId = Integer.parseInt(params.get("movieId"));
    	String date = params.get("date");
    	
    	List<SearchListing> searchListing = listingService.readListingByCityAndMovie(httpServletRequest, city, movieId, date) ;
    	
    	return new ResponseEntity<>(searchListing, HttpStatus.OK);
    }
    
    @GetMapping("/offer")
    public ResponseEntity<List<SearchListing>> getSeatListing(HttpServletRequest httpServletRequest, @RequestParam Map<String, String> params ) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	
    	int listingId = Integer.parseInt(params.get("listingId"));
    	List<String> seats = Arrays.asList(params.get("seats").split(","));
    	
    	List<SearchListing> searchListing = listingService.readSeatWiseListing(httpServletRequest, listingId, seats) ;
    	
    	return new ResponseEntity<>(searchListing, HttpStatus.OK);
    }
	
}
