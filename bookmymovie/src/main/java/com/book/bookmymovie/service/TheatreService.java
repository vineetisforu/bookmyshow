package com.book.bookmymovie.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.book.bookmymovie.model.Screen;
import com.book.bookmymovie.model.Theatre;

public interface TheatreService {

	public Theatre saveTheatre(HttpServletRequest request, Theatre theatre, List<Screen> screen);
}
