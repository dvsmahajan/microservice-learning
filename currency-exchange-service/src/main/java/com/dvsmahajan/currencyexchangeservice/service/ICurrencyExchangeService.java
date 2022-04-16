package com.dvsmahajan.currencyexchangeservice.service;

import com.dvsmahajan.currencyexchangeservice.entity.CurrencyExchange;

public interface ICurrencyExchangeService {

	CurrencyExchange addCurrencyExchage(CurrencyExchange currencyExchange);

	CurrencyExchange getCurrencyExchangeByFromNTo(String from, String to);

}
