package com.dvsmahajan.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvsmahajan.currencyexchangeservice.entity.CurrencyExchange;
import com.dvsmahajan.currencyexchangeservice.repository.ICurrencyExchangeRepositoy;

@Service
public class CurrencyExchangeServiceImpl implements ICurrencyExchangeService{

	@Autowired
	private ICurrencyExchangeRepositoy iCurrencyExchangeRepositoy;
	
	
	@Override
	public CurrencyExchange addCurrencyExchage(CurrencyExchange currencyExchange) {
		return iCurrencyExchangeRepositoy.save(currencyExchange);
	}


	@Override
	public CurrencyExchange getCurrencyExchangeByFromNTo(String from, String to) {
		return iCurrencyExchangeRepositoy.findByFromAndTo(from,to);
	}

}
