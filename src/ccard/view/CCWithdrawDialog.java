package ccard.view;
import java.awt.*;
import javax.swing.*;

import ccard.controller.CCard;
import controller.FinCo;

import view.*;

public class CCWithdrawDialog extends WithdrawDialog
{
   
    public CCWithdrawDialog(MainWindow parent, String aaccnr) {
		super(parent, aaccnr);
	}

	@Override
	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		try {
			parentframe.amountDeposit= Double.parseDouble(JTextField_AMT.getText());
			if (parentframe.amountDeposit < 0)
				throw new NumberFormatException();
			CCard.charge(accnr, parentframe.amountDeposit);
	        parentframe.proceedFromDialog=true;
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Please enter a valid amount","Error: Illegal value",JOptionPane.WARNING_MESSAGE);
		}
	}
}