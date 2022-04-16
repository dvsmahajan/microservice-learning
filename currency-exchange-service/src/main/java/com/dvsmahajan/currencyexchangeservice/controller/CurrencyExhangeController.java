package com.dvsmahajan.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsmahajan.currencyexchangeservice.entity.CurrencyExchange;
import com.dvsmahajan.currencyexchangeservice.service.ICurrencyExchangeService;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExhangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private ICurrencyExchangeService iCurrencyExchangeService;
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable("from") String from ,@PathVariable("to") String to) {
		CurrencyExchange currencyExchange = iCurrencyExchangeService.getCurrencyExchangeByFromNTo(from,to);
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to find "+from+" to "+to);
		}
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
	
	@PostMapping("add")
	public CurrencyExchange addCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return iCurrencyExchangeService.addCurrencyExchage(currencyExchange);
	}
}
