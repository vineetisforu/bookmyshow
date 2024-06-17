package com.book.bookmymovie.service;

import javax.servlet.http.HttpServletRequest;

import com.book.bookmymovie.model.Inventory;
import com.book.bookmymovie.pojo.InventoryRequest;

public interface InventoryService {

	public Inventory saveInventory(HttpServletRequest request, InventoryRequest inventoryRequest);
}
