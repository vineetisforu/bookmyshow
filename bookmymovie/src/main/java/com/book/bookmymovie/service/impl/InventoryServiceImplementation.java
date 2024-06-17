package com.book.bookmymovie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookmymovie.model.Inventory;
import com.book.bookmymovie.model.InventoryDetails;
import com.book.bookmymovie.pojo.InventoryRequest;
import com.book.bookmymovie.repository.InventoryDetailsRepository;
import com.book.bookmymovie.repository.InventoryRepository;
import com.book.bookmymovie.service.InventoryService;

@Service
public class InventoryServiceImplementation implements InventoryService{

	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImplementation.class);
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private InventoryDetailsRepository inventoryDetailsRepository;
	
	@Override
	public Inventory saveInventory(HttpServletRequest request, InventoryRequest inventoryRequest) {
		// TODO Auto-generated method stub
		
		List<InventoryDetails> inventoryDetailsList = new ArrayList<InventoryDetails>();
		
		Map<String, Boolean> seatAvailabilityMapping =  inventoryRequest.getSeatNameAvailability();
		
		for(Entry<String, Boolean> kv : seatAvailabilityMapping.entrySet()) {
			
			InventoryDetails inventoryDetails = new InventoryDetails();
			inventoryDetails.setListingId(inventoryRequest.getListingId());
			inventoryDetails.setSeatName(kv.getKey());
			inventoryDetails.setAvailable(kv.getValue());
			
			inventoryDetailsList.add(inventoryDetails);
		}
		
		inventoryDetailsRepository.saveAllAndFlush(inventoryDetailsList);
		
		int availableSeatCount = inventoryDetailsRepository.getAvailableSeats(inventoryRequest.getListingId());
		
		Inventory inventory = new Inventory();
		inventory.setListingId(inventoryRequest.getListingId());
		inventory.setAvailableSeats(availableSeatCount);

		
		Inventory savedInventory = inventoryRepository.save(inventory);
		
		return savedInventory;
	}

}
