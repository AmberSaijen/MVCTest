package org.model;

public class CurrencyModel extends Model {
	
	private String[] headers;
	private Object[][] data;
	private double bynToExchange = 0.0;
	private double exchangeResult = 0.0;
	private String currency = "";
	
	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public double getBynToExchange() {
		return bynToExchange;
	}


	public void setBynToExchange(double bynToExchange) {
		this.bynToExchange = bynToExchange;
	}


	public double getExchangeResult() {
		return exchangeResult;
	}


	public void setExchangeResult(double exchangeResult) {
		this.exchangeResult = exchangeResult;
	}


	public CurrencyModel() { super(); }
	

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}
	
	

}
