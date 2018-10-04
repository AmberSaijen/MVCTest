package org.actions;

import org.controller.DefaultPerformController;
import org.controller.PerformController;
import org.view.View;
import org.xml.sax.InputSource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JRootPane;

public class DefaultActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton)e.getSource();
		JRootPane root = button.getRootPane();
		View view = (View) root.getParent();
		String viewName = view.getClass().getName();
		
		view.putDataToModel();

		File propertyFile = Paths.get("resources\\ViewToController.properties").toFile();
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(propertyFile));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String controllerName = properties.get(viewName).toString();
		PerformController defaultPerformController = null;
		try {
			defaultPerformController = (PerformController) Class.forName(controllerName).newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		defaultPerformController.setModel(view.getModel());
		defaultPerformController.performButtonAction();
		view.getDataFromModel();
	}

}
