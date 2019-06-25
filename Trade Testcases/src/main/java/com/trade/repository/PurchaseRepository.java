package com.trade.repository;

import org.springframework.data.repository.CrudRepository;

import com.trade.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase,Long> {

}
