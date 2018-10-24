package view;

import controller.FinCo;
import view.*;

public class BankAddCompanyAccountDialog extends AddCompanyAccountDialog{

	javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
	private MainWindow parentframe;
	
	public BankAddCompanyAccountDialog(MainWindow parent) {
		super(parent);
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,36,84,24);
	}
	
	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		parentframe.param.setAccountNumber(JTextField_ACNR.getText());
		parentframe.param.setCustomerName(JTextField_NAME.getText());
		parentframe.param.setStreetName(JTextField_STR.getText());
		parentframe.param.setCity(JTextField_CT.getText());
		parentframe.param.setZip(JTextField_ZIP.getText());
		parentframe.param.setState(JTextField_ST.getText());
		parentframe.param.setCustomerEmail(JTextField_EM.getText());
		parentframe.newaccount=true;
		FinCo.createCompanyAccount(parentframe.param);
		dispose();
		
       if (JRadioButton_Chk.isSelected())
           parentframe.param.setAccountType("Ch");
           else
           parentframe.param.setAccountType("S");
	   parentframe.newaccount=true;
	   dispose();
			 
	}

}
