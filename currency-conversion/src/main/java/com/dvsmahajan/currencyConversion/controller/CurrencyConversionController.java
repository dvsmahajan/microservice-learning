package com.dvsmahajan.currencyConversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dvsmahajan.currencyConversion.dto.CurrencyConversionDTO;
import com.dvsmahajan.currencyConversion.feign.ICurrencyExchangeProxy;

@RestController
@RequestMapping("currency-conversion")
public class CurrencyConversionController {
	
	@Autowired
	private ICurrencyExchangeProxy iCurrencyExchangeProxy;

	@GetMapping("from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConversionDTO currencyConversionFromToTo(@PathVariable String from , @PathVariable String to,@PathVariable BigDecimal qty) {
		CurrencyConversionDTO conversionDTO = new CurrencyConversionDTO();
		conversionDTO.setFrom(from);
		conversionDTO.setTo(to);
		conversionDTO.setQuantity(qty);
		
		HashMap<String , Object> urlParameters = new HashMap<>();
		urlParameters.put("from", from);
		urlParameters.put("to", to);
		ResponseEntity<CurrencyConversionDTO> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionDTO.class,urlParameters);
		
		CurrencyConversionDTO body = forEntity.getBody();
		conversionDTO.setEnvironment(body.getEnvironment());
		conversionDTO.setConversionMultiple(body.getConversionMultiple());
		conversionDTO.setTotalCalculator(qty.multiply(body.getConversionMultiple()).doubleValue());
		
		return conversionDTO;
	}
	
	
	
	@GetMapping("feign/from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConversionDTO feignCurrencyConversionFromToTo(@PathVariable String from , @PathVariable String to,@PathVariable BigDecimal qty) {
		CurrencyConversionDTO conversionDTO = new CurrencyConversionDTO();
		conversionDTO.setFrom(from);
		conversionDTO.setTo(to);
		conversionDTO.setQuantity(qty);
		
		CurrencyConversionDTO body = iCurrencyExchangeProxy.retriveExchangeValue(from, to);
		
		conversionDTO.setEnvironment(body.getEnvironment());
		conversionDTO.setConversionMultiple(body.getConversionMultiple());
		conversionDTO.setTotalCalculator(qty.multiply(body.getConversionMultiple()).doubleValue());
		
		return conversionDTO;
	}
}
