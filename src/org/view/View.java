package org.view;

import javax.swing.JFrame;

import org.model.Model;

public class View extends JFrame {
	
	private Model model;
	
	public View(Model model) {
		this.model = model;
	}
	
	public void displayView() {
		setVisible(true);
	}
	
	public void putDataToModel() {}
	
	public void getDataFromModel() {}
	
	public Model getModel() {
		return this.model;
	}

}
