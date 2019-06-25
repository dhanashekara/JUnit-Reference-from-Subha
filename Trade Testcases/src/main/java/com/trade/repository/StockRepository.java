package com.trade.repository;

import org.springframework.data.repository.CrudRepository;

import com.trade.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{

}
