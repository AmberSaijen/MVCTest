package org.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.model.CurrencyModel;
import org.model.Model;

public class CurrencyModelConverter implements ModelConverter {

	@Override
	public JTable convertToTable(Model model) {

		CurrencyModel curModel = (CurrencyModel) model;
		JTable table = new JTable(curModel.getData(), curModel.getHeaders());
		return table;
	}

	@Override
	public JComboBox convertToDropdown(Model model) {
		
		List column = new ArrayList();
		CurrencyModel curModel = (CurrencyModel) model;
		Object[][] dataTab = curModel.getData();
		for (int i = 0; i < dataTab.length; i++)
			column.add(dataTab[i][0]);
		
		String[] curRates = Arrays.copyOf(column.toArray(), column.size(), String[].class);
		JComboBox dropdown = new JComboBox(curRates);
		return dropdown;
	}
	
	

}
