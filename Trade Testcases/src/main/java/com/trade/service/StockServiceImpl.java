package com.trade.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.model.Stock;
import com.trade.repository.StockRepository;

@Service
@Transactional

public class StockServiceImpl implements StockService {
	@Autowired
	StockRepository repo;

	public Stock save(Stock stock) {

		if (stock != null) {

			return repo.save(stock);
		} else {
			return stock;
		}
	}

	public List<Stock> getStockList() {

		return (List<Stock>) repo.findAll();
	}

}
