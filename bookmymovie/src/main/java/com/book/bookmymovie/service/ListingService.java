package com.book.bookmymovie.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.book.bookmymovie.model.Listing;
import com.book.bookmymovie.pojo.SearchListing;

public interface ListingService {

	public Listing saveListing(HttpServletRequest request, Listing listing);
	public Listing readListing(HttpServletRequest request, int listingId);
	public List<SearchListing> readListingByCityAndMovie(HttpServletRequest request, String city, int movieId, String date);
	public List<SearchListing> readSeatWiseListing(HttpServletRequest request, int listingId, List<String> seats);
}
