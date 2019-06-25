package com.trade.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StockTest {
	@InjectMocks
	Stock stock;
	
	public void testStock() {
		stock.setStockId(1);
		stock.setStockName("Infosys");
		 stock.getStockId();
		 
		 stock.getStockName();
	}
	
	
}
	 
