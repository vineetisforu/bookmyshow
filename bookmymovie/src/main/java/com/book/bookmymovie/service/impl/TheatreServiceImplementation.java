package com.book.bookmymovie.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookmymovie.model.Screen;
import com.book.bookmymovie.model.Theatre;
import com.book.bookmymovie.repository.ScreenRepository;
import com.book.bookmymovie.repository.TheatreRepository;
import com.book.bookmymovie.service.TheatreService;

@Service
public class TheatreServiceImplementation implements TheatreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TheatreServiceImplementation.class);
    
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ScreenRepository screenRepository;
    
	@Override
	public Theatre saveTheatre(HttpServletRequest request, Theatre theatre, List<Screen> screen) {
		// TODO Auto-generated method stub
		
		Theatre savedTheatre = theatreRepository.save(theatre);
		
		for (Screen sc : screen)
			sc.setTheatreId(savedTheatre.getId());
		
		screenRepository.saveAllAndFlush(screen);
		
		return savedTheatre;
	}

}
