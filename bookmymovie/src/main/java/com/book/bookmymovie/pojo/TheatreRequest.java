package com.book.bookmymovie.pojo;

import java.util.List;
import java.util.Map;

public class TheatreRequest {

	private String name;
	private String city;
	private Map<String, List<String>> screen;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Map<String, List<String>> getScreen() {
		return screen;
	}
	public void setScreen(Map<String, List<String>> screen) {
		this.screen = screen;
	}
	
	
}
