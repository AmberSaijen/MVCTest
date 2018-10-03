package org.bundle;

import javax.swing.SwingUtilities;

import org.controller.InitController;
import org.controller.DefaultInitController;
import org.model.CurrencyModel;
import org.model.Model;
import org.view.DefaultView;
import org.view.View;

public class DefaultBundle {
	
	public static void main(String args[]) {
		
		Model currencyModel = new CurrencyModel();
		InitController defaultInitController = new DefaultInitController(currencyModel);
		defaultInitController.initModel();
		View view = new DefaultView(currencyModel);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					showGUI(view);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public static void showGUI(View view) throws Exception {
		view.displayView();
	}

}
