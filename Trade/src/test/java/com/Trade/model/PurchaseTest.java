package com.trade.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseTest {
	@InjectMocks
	Purchase purchase;
	
	User user = new User(1,"user1");
	
	@Test
	public void testPurchase() {
		purchase.setStockName("Infosys");
		purchase.setDate(new Date());
		purchase.setFees(1000);
		purchase.setQuantity(100);
		purchase.setPurchaseId(1);
		purchase.setStockPrice(100);
		purchase.setUser(user);
		purchase.setTotalFees(1000);
		purchase.setTotalStockprice(5000);
		
		Date date = new Date();
		assertTrue(purchase.getUser() == user);
		assertTrue(purchase.getPurchaseId() == 1);
		assertTrue(purchase.getStockPrice() == 100);
		assertThat(date).isAfterOrEqualsTo(purchase.getDate());
		assertTrue(purchase.getQuantity() == 100);
		assertTrue(purchase.getStockName() == "Infosys");
		assertTrue(purchase.getFees() == 1000);
		assertTrue(purchase.getTotalStockprice() == 5000);
	}
//	@Test
//	public void TestUser() {
//		
//	}
//	@Test
//	public void testSetUser() {
//		purchase.setUser(user);
//		assertTrue(purchase.getUser() == user);
//	}
//	
//	@Test
//	public void testGetUser() {
//		purchase.setUser(user);
//		assertTrue(purchase.getUser() == user);
//	}
//	
//	@Test
//	public void testSetPurchaseId() {
//		purchase.setPurchaseId(1);
//		assertTrue(purchase.getPurchaseId() == 1);
//	}
//
//	@Test
//	public void testGetPurchaseId() {
//		purchase.setPurchaseId(1);
//		assertTrue(purchase.getPurchaseId() == 1);
//	}
//
//	@Test
//	public void testSetStockPrice() {
//		purchase.setStockPrice(100);
//		assertTrue(purchase.getStockPrice() == 100);
//	}
//
//	@Test
//	public void testGetStockPrice() {
//		purchase.setStockPrice(100);
//		assertTrue(purchase.getStockPrice() == 100);
//	}
//
//	@Test
//	public void testSetDate() {
//		purchase.setDate(new Date());
//		assertTrue(purchase.getDate().equals(new Date()));
//	}
//
//	@Test
//	public void testgetDate() {
//		purchase.setDate(new Date());
//		assertTrue(purchase.getDate().equals(new Date()));
//	}
//
//	@Test
//	public void testSetTotalStockprice() {
//		purchase.setTotalStockprice(1000);
//		assertTrue(purchase.getTotalStockprice() == 1000);
//	}
//
//	@Test
//	public void testGetTotalStockprice() {
//		purchase.setTotalStockprice(1000);
//		assertTrue(purchase.getTotalStockprice() == 1000);
//	}
//
//	@Test
//	public void testSetFees() {
//		purchase.setFees(100);
//		assertTrue(purchase.getFees() == 1000);
//	}
//
//	@Test
//	public void testGetFees() {
//		purchase.setFees(100);
//		assertTrue(purchase.getFees() == 1000);
//	}
//
//	@Test
//	public void testSetStockName() {
//		purchase.setStockName("Infosys");
//		assertTrue(purchase.getStockName() == "Infosys");
//	}
//
//	@Test
//	public void testGetStockName() {
//		purchase.setStockName("Infosys");
//		assertTrue(purchase.getStockName() == "Infosys");
//	}
//	@Test
//	public void testSetQuantity() {
//		purchase.setQuantity(100);
//		assertTrue(purchase.getQuantity() == 100);
//	}
//
//	@Test
//	public void testGetQuantity() {
//		purchase.setQuantity(100);
//		assertTrue(purchase.getQuantity() == 100);
//	}

}
