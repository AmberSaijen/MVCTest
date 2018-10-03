package org.controller;

import org.model.CurrencyModel;
import org.model.Model;

public class DefaultInitController implements InitController {

	private Model model;
	
	public DefaultInitController(Model model) {
		
		this.model = model;
	}
	
	@Override
	public void initModel() {
		
		CurrencyModel curModel = (CurrencyModel) model;
		curModel.setHeaders(InitModelData.TABLE_HEADER);
		curModel.setData(InitModelData.DATA);
		
	}


}
