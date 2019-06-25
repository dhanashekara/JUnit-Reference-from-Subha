package com.trade.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.controller.MainAppController;
import com.trade.model.Purchase;
import com.trade.repository.PurchaseRepository;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	PurchaseRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(MainAppController.class);

	public Purchase purchase(Purchase purchase) {
		
		
		long totalStockPrice = purchase.getQuantity()*purchase.getStockPrice();
		int fixedPrice = 500;
		if(totalStockPrice<500) {
			logger.info("inside if....");
			purchase.setDate(new Date());
			purchase.setTotalStockprice(totalStockPrice);
			long fees=(long) (totalStockPrice*(0.10/100));
			purchase.setFees(fees);
			long totalFees= totalStockPrice + fees;
			purchase.setTotalFees(totalFees);
			repo.save(purchase);
			return purchase;
		}
		
		else if(totalStockPrice>=fixedPrice)
		{
			logger.info("inside else if....");
			purchase.setDate(new Date());
			purchase.setTotalStockprice(totalStockPrice);
			long fees=(long) (totalStockPrice*(0.15/100));
			long totalFees= purchase.getTotalFees() + fees;
			purchase.setTotalFees(totalFees);
			repo.save(purchase);
			fixedPrice=fixedPrice+100;
			
		}
		else {
			
		}
		return purchase;
		
		
	}

}
