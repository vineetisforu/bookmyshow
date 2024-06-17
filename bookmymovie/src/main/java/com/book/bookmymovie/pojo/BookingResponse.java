package com.book.bookmymovie.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class BookingResponse implements Serializable{

	private Integer id;
	private String theatreName;
	private String city;
	private String movieName;
	private LocalDateTime showTiming;
	private String screenId;
	private Integer totalPrice;
	private List<String> seatNames;
	private String status = "success";
	
	
	
	public BookingResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingResponse(Integer id, String theatreName, String city, String movieName, LocalDateTime showTiming,
			String screenId, Integer totalPrice, List<String> seatNames) {
		super();
		this.id = id;
		this.theatreName = theatreName;
		this.city = city;
		this.movieName = movieName;
		this.showTiming = showTiming;
		this.screenId = screenId;
		this.totalPrice = totalPrice;
		this.seatNames = seatNames;
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
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<String> getSeatNames() {
		return seatNames;
	}
	public void setSeatNames(List<String> seatNames) {
		this.seatNames = seatNames;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingResponse [id=" + id + ", theatreName=" + theatreName + ", city=" + city + ", movieName="
				+ movieName + ", showTiming=" + showTiming + ", screenId=" + screenId + ", totalPrice=" + totalPrice
				+ ", seatNames=" + seatNames + ", status=" + status + "]";
	}
	

	
	
}
