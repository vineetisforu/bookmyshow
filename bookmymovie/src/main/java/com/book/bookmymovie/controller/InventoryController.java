package com.book.bookmymovie.controller;

import java.sql.SQLIntegrityConstraintViolationException;

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

import com.book.bookmymovie.model.Inventory;
import com.book.bookmymovie.model.User;
import com.book.bookmymovie.pojo.InventoryRequest;
import com.book.bookmymovie.service.InventoryService;
import com.book.bookmymovie.service.UserService;

@RestController
@RequestMapping("/api/v1/inventory")
@CrossOrigin
public class InventoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;

    @PostMapping("/create")
    public ResponseEntity<Inventory> saveUser(HttpServletRequest httpServletRequest, @RequestBody InventoryRequest inventoryRequest) throws InterruptedException, SQLIntegrityConstraintViolationException {
    
    	
    	Inventory inventory = inventoryService.saveInventory(httpServletRequest, inventoryRequest);
    	
    	return new ResponseEntity<>(inventory, HttpStatus.CREATED);
    }
	
}
