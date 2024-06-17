package com.book.bookmymovie.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class SearchListing implements Serializable{

	private Integer id;
	private String theatreName;
	private String city;
	private String movieName;
	private LocalDateTime showTiming;
	private String screenId;
	private Integer price;
	private String seatName;
	
	public SearchListing(Integer id, String theatreName, String city, String movieName, LocalDateTime showTiming, String screenId,
			Integer price, String seatName) {
		super();
		this.id = id;
		this.theatreName = theatreName;
		this.city = city;
		this.movieName = movieName;
		this.showTiming = showTiming;
		this.screenId = screenId;
		this.price = price;
		this.seatName = seatName;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalDateTime getShowTiming() {
		return showTiming;
	}
	public void setShowTiming(LocalDateTime showTiming) {
		this.showTiming = showTiming;
	}
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
		
}
