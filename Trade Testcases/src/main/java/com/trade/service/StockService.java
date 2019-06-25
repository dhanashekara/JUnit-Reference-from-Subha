package com.trade.service;

import java.util.List;

import com.trade.model.Stock;

public interface StockService {

	Stock save(Stock stock);

	List<Stock> getStockList();

}
