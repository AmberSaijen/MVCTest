package org.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.actions.DefaultActionListener;
import org.model.CurrencyModel;
import org.model.Model;

public class DefaultView extends View {
	
	
	JTextArea currencyTextArea;
	JTextArea amountTextArea;
	JTextField amountTextField;
	JTextArea resultTextArea;
	JTextField resultTextField;
	JButton calcButton;
	DefaultActionListener calcListener;
	JTable currencyTable;
	JComboBox currencyList;
	
	public DefaultView(Model model) {
		
		super(model);
		
		//Fill default view components
		currencyTextArea = new JTextArea("Currency: ");
		amountTextArea = new JTextArea("Amount: ");
		amountTextField = new JTextField(10);
		resultTextArea = new JTextArea("Result: ");
		resultTextField = new JTextField(10);
		
		//Button and action listener
		calcButton = new JButton("Calculate");
		calcListener = new DefaultActionListener();
		calcButton.addActionListener(calcListener);
		
		//Create table and dropdown from model
		ModelConverter modelConverter = new CurrencyModelConverter();
		currencyTable =  modelConverter.convertToTable(model);
		currencyList = modelConverter.convertToDropdown(model);
		
		//Set view layout for components
		JPanel ctrlPane = new JPanel();
		ctrlPane.add(currencyTextArea);
		ctrlPane.add(currencyList);
		ctrlPane.add(amountTextArea);
		ctrlPane.add(amountTextField);
		ctrlPane.add(calcButton);
		
		//Set view layout for table
		JPanel ctrlPane2 = new JPanel();
		JScrollPane tableScrollPane = new JScrollPane(currencyTable);
		tableScrollPane.setPreferredSize(new Dimension(700, 182));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), 
				"Currency rates", TitledBorder.CENTER, TitledBorder.TOP));
		ctrlPane2.add(tableScrollPane);
		ctrlPane2.add(resultTextArea);
		ctrlPane2.add(resultTextField);
		
		//Set layout of both
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, ctrlPane2);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);
		
		//Place it all on frame
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(splitPane);
		pack();
		setLocationRelativeTo(null);

	}

	@Override
	public void putDataToModel() {
		
		CurrencyModel curModel = (CurrencyModel)getModel();
		curModel.setCurrency((String)currencyList.getSelectedItem());
		curModel.setBynToExchange(Double.parseDouble(amountTextField.getText()));
	}

	@Override
	public void getDataFromModel() {
		
		CurrencyModel curModel = (CurrencyModel)getModel();
		double result = curModel.getExchangeResult();
		if(result < 0)
			resultTextField.setText("Calculation Error!");
		else
			resultTextField.setText(Double.toString(result));
	}
	
	
	
	

}
