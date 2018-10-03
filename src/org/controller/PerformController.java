package org.controller;

import org.model.Model;
import org.view.View;

public interface PerformController {
	
	public void performButtonAction(View view);
	
	public Model getModel();
	
	public void setModel(Model model);

}
