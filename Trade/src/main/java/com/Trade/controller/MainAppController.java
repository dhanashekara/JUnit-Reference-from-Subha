package com.Trade.controller;

import java.util.List;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Trade.model.Purchase;
import com.Trade.model.Stock;
import com.Trade.model.User;
import com.Trade.service.PurchaseService;
import com.Trade.service.StockService;
import com.Trade.service.UserService;



@RestController
public class MainAppController {
	private static final Logger logger = LoggerFactory.getLogger(MainAppController.class);
	
	@Autowired
	UserService userService;
	@Autowired
	StockService stockService;
	@Autowired
	PurchaseService purchaseService;
	@PostMapping("/addUser")
	public User message(@RequestBody User user) {
		logger.info("user added successfully");
		return userService.save(user);
		
	}
	
	@GetMapping("/listUser")
	public List<User> listUser() {
		logger.info("user added successfully");
		return userService.getUserList();
		
	}
	
	@PostMapping("/addStock")
	public Stock addStock(@RequestBody Stock stock) {
		logger.info("stock added successfully");
		return stockService.save(stock);
		
	}
	
	@GetMapping("/listStock/{userName}")
	public List<Stock> listStock(@PathVariable("userName") String userName) {
		List<User> user = userService.getUserList();
		for (User user2 : user) {
			if(user2.getUserName().equalsIgnoreCase(userName)){
				return stockService.getStockList();
			}
			else {
				return null;
			}
		}
		logger.info("stock listed successfully");
		return stockService.getStockList();
		
	}
	
	@PostMapping("/purchase/{id}")
	public  Purchase purchase(@PathVariable("id") int id,@RequestBody Purchase purchase){
		User user = userService.getUser(id);
		purchase.setUser(user);
		logger.info(purchase.getStockName());
		return purchaseService.purchase(purchase);
	}
	


	
}
