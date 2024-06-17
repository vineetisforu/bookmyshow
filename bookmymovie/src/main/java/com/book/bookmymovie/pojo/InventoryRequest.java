package com.book.bookmymovie.pojo;

import java.util.Map;

public class InventoryRequest {
	
	private int listingId;
	private Map<String, Boolean> seatNameAvailability;
	
	public int getListingId() {
		return listingId;
	}
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
	public Map<String, Boolean> getSeatNameAvailability() {
		return seatNameAvailability;
	}
	public void setSeatNameAvailability(Map<String, Boolean> seatNameAvailability) {
		this.seatNameAvailability = seatNameAvailability;
	}
	
	

}
