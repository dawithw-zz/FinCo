package ccard.view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.FinCo;
import view.DepositDialog;
import view.MainWindow;
import view.WithdrawDialog;


public class CCWindow extends MainWindow{
	
	private CCWindow thisframe;
	CCAccountParameters param = new CCAccountParameters();
	public javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	public javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	
	public CCWindow() {
		super();
		thisframe = this;
		setTitle("Credit-card processing Application. Dawit");

		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
		
		// remove default table
		JScrollPane1.getViewport().remove(JTable1);
		
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        rowdata = new Object[7];
		
        // remove framework default buttons
        JPanel1.remove(JButton_PerAC);
		JPanel1.remove(JButton_CompAC);
		JScrollPane1.getViewport().add(JTable1);
		
		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240,20,192,33);
		JButton_Withdraw.setText("Charge");

		JButton_GenBill.setActionCommand("jbutton");

		SymAction lSymAction = new SymAction();
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
	}
	
	public class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			
		}
	}
	
	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		AddPersonalCCAccount ccac = new AddPersonalCCAccount(thisframe);
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();

		if (proceedFromDialog){
            // add row to table
            rowdata[0] = param.getCustomerName();
            rowdata[1] = param.getAccountNumber();
            rowdata[2] = param.getExpiryDate();
            rowdata[3] = param.getAccountType();
            rowdata[4] = "0.0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            proceedFromDialog=false;
        }

       
        
    }
	
	public void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 1);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    DepositDialog dep = new DepositDialog(myframe,accnr);
		    dep.setBounds(430, 15, 275, 140);
		    dep.show();
    		
		    if (proceedFromDialog){
			    // compute new amount
		    	String samount = (String)model.getValueAt(selection, 4);
		    	double currentamount = Double.parseDouble(samount);
		    	double newamount=currentamount+amountDeposit;
			    model.setValueAt(String.valueOf(newamount),selection, 4);
			    proceedFromDialog=false;
		    }
		}
	}
	
	public void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 1);

		    //Show the dialog for adding withdraw amount for the current mane
		    CCWithdrawDialog wd = new CCWithdrawDialog(myframe,accnr);
		    wd.setBounds(430, 15, 275, 140);
		    wd.show();
    		
		    if (proceedFromDialog){
		    	// compute new amount
		    	String samount = (String)model.getValueAt(selection, 4);
		    	double currentamount = Double.parseDouble(samount);
		    	double newamount=currentamount-amountDeposit;
		    	model.setValueAt(String.valueOf(newamount),selection, 4);
		    	if (newamount <0){
		    		JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
		    	}
		    	proceedFromDialog=false;
		    }
		}
		
		
	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{
		GenBillDialog billFrm = new GenBillDialog();
		billFrm.setBounds(450, 20, 400, 350);
		billFrm.show();   
	}
 }
