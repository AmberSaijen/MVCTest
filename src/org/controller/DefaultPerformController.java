package org.controller;

import org.model.CurrencyModel;
import org.model.Model;
import org.view.View;

public class DefaultPerformController implements PerformController {

	private Model model;
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public DefaultPerformController() {
		
	}
	public DefaultPerformController(Model model) {
		
		this.model = model;
	}
	
	@Override
	public void performButtonAction(View view) {
		
		CurrencyModel curModel = (CurrencyModel) view.getModel();
		double exchangeRate = fetchExchangeRate(curModel);
		curModel.setExchangeResult(curModel.getBynToExchange()*exchangeRate);

	}
	
	public double fetchExchangeRate(CurrencyModel model) {
		
		String currency = model.getCurrency();
		Object[][] modelData = model.getData();
		double rate = -1;
		for(int i = 0; i < modelData.length; i++)
			if(currency.compareTo(modelData[i][0].toString()) == 0)
				rate = Double.parseDouble(modelData[i][1].toString());
		return rate;
	}

}
