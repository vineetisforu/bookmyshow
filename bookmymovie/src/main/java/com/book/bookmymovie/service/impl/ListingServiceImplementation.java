package com.book.bookmymovie.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookmymovie.model.Listing;
import com.book.bookmymovie.pojo.SearchListing;
import com.book.bookmymovie.repository.ListingRepository;
import com.book.bookmymovie.service.ListingService;

@Service
public class ListingServiceImplementation implements ListingService{

	private static final Logger LOGGER = LoggerFactory.getLogger(ListingServiceImplementation.class);
	
	@Autowired
	private ListingRepository listingRepository;
			
	@Override
	public Listing saveListing(HttpServletRequest request, Listing listing) {
		// TODO Auto-generated method stub
		
		Listing savedListing = listingRepository.save(listing);
		
		return savedListing;
	}

	@Override
	public Listing readListing(HttpServletRequest request, int listingId) {
		// TODO Auto-generated method stub
		
		Listing listing = listingRepository.getListing(listingId);
		return listing;
	}

	@Override
	public List<SearchListing> readListingByCityAndMovie(HttpServletRequest request, String city, int movieId, String date) {
		// TODO Auto-generated method stub
		
		List<SearchListing> searchListing =  listingRepository.getListingByCityAndMovie(city, movieId, date);
		return searchListing;
	}

	@Override
	public List<SearchListing> readSeatWiseListing(HttpServletRequest request, int listingId, List<String> seats) {
		// TODO Auto-generated method stub
		
		List<SearchListing> searchListing =  listingRepository.getSeatWiseListing(listingId, seats);
		
		LocalDateTime ldt = searchListing.get(0).getShowTiming();
		
		if(ldt.getHour() > 12) {
			
			for(int i =0;i<searchListing.size();i++) {
								
				SearchListing sl = searchListing.get(i);
				sl.setPrice((int)(sl.getPrice()*.80));
					
			}
			
		}
		else
		if(searchListing.size()>2) {
			
			for(int i =0;i<searchListing.size();i++) {
				
				if(i%2 == 0 && i!=0) {
					SearchListing sl = searchListing.get(i);
					sl.setPrice(sl.getPrice()/2);
					
				}
			}
		}
		
		return searchListing;
	}


	
	
	
}
