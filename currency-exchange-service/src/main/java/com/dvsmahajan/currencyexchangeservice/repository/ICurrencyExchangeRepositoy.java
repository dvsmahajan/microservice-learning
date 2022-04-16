package com.dvsmahajan.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvsmahajan.currencyexchangeservice.entity.CurrencyExchange;

public interface ICurrencyExchangeRepositoy extends JpaRepository<CurrencyExchange, Long>{

	CurrencyExchange findByFromAndTo(String from, String to);

}
