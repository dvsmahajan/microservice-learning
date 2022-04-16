package com.dvsmahajan.currencyConversion.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvsmahajan.currencyConversion.dto.CurrencyConversionDTO;

//@FeignClient(name =  "currency-exchange",url = "localhost:8000")
@FeignClient(name =  "currency-exchange")
public interface ICurrencyExchangeProxy {

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionDTO retriveExchangeValue(@PathVariable("from") String from ,@PathVariable("to") String to) ;
}
