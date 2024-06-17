package com.book.bookmymovie.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookmymovie.model.Screen;
import com.book.bookmymovie.model.Theatre;
import com.book.bookmymovie.model.User;
import com.book.bookmymovie.pojo.TheatreRequest;
import com.book.bookmymovie.service.TheatreService;
import com.book.bookmymovie.service.UserService;

@RestController
@RequestMapping("/api/v1/theatre")
@CrossOrigin
public class TheatreController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TheatreController.class);
	
	@Autowired
	private TheatreService theatreService;

    @PostMapping("/register")
    public ResponseEntity<Theatre> saveTheatre(HttpServletRequest httpServletRequest, @RequestBody TheatreRequest theatreRequest) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	Theatre theatre = new Theatre();
    	theatre.setName(theatreRequest.getName());
    	theatre.setCity(theatreRequest.getCity());
    	
    	List<Screen> list = new ArrayList<Screen>();
    	
    	Map<String, List<String>> screenMap = theatreRequest.getScreen();
    	
    	for(Entry<String, List<String>> kv : screenMap.entrySet()) {

    		List<String> seats = kv.getValue();
    		
    		for(String eachSeat : seats) {
	    		Screen screen = new Screen();
	    		screen.setScreenId(kv.getKey());
	    		screen.setSeatName(eachSeat);
	    		list.add(screen);
    		}
    		
    	}
    	
    	Theatre theatreResp = theatreService.saveTheatre(httpServletRequest, theatre, list);
    	
    	return new ResponseEntity<>(theatreResp, HttpStatus.CREATED);
    }
	
}
