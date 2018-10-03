package org.view;

import javax.swing.JComboBox;
import javax.swing.JTable;

import org.model.Model;

public interface ModelConverter {
	
	public JTable convertToTable(Model model);
	
	public JComboBox convertToDropdown(Model model);

}
