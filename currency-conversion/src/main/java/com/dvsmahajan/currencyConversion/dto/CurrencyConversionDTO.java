package com.dvsmahajan.currencyConversion.dto;

import java.math.BigDecimal;

public class CurrencyConversionDTO {
	  private Long id;
	  private String from;
	  private String to;
	  private BigDecimal conversionMultiple;
	  private BigDecimal quantity;
	  private Double totalCalculator;
	  private String environment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public Double getTotalCalculator() {
		return totalCalculator;
	}
	public void setTotalCalculator(Double totalCalculator) {
		this.totalCalculator = totalCalculator;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	@Override
	public String toString() {
		return "CurrencyConversionDTO [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", quantity=" + quantity + ", totalCalculator=" + totalCalculator
				+ ", environment=" + environment + "]";
	}

	public CurrencyConversionDTO() {
		super();
	}
	  
	  
	  
}
