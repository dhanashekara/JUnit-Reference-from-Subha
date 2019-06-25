package com.trade.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.trade.model.Stock;
import com.trade.repository.StockRepository;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {
	@Mock
	StockRepository stockRepository;

	@InjectMocks
	StockServiceImpl stockServiceimpl;

	static List<Stock> expectedValue = null;

	@BeforeClass
	public static void setup() {
		expectedValue = new ArrayList<Stock>();
		Stock stock1 = new Stock(3, "check");
		expectedValue.add(stock1);
	}

	@Test
	public void testSave() {
		Stock stock = new Stock(1, "Infosys");
		Mockito.when(stockRepository.save(stock)).thenReturn(stock);
		Stock stock1 = stockRepository.save(stock);
		System.out.println("expect...." + stock.getStockName());
		System.out.println("act...." + stock1.getStockName());
		assertEquals(stock, stock1);
	}

	@Test
	public void testGetStockList() {
		System.out.println("size" + expectedValue.size());
		Mockito.when(stockRepository.findAll()).thenReturn(expectedValue);

		List<Stock> actualValue = stockServiceimpl.getStockList();
		Assert.assertEquals(expectedValue.size(), actualValue.size());
	}

}
