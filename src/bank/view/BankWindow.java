package bank.view;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.FinCo;
import view.MainWindow;

public class BankWindow extends MainWindow{
	
	BankAccountParameters param = new BankAccountParameters();
	private BankWindow myframe;
	
	public BankWindow() {
		super();
		myframe = this;
		setTitle("Bank");
		model = new DefaultTableModel();
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        JTable1.setModel(model);
	}
	
	@Override
	public void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		BankAddPersonalAccountDialog pac = new BankAddPersonalAccountDialog(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (proceedFromDialog){
            // add row to table
            rowdata[0] = param.getAccountNumber();
            rowdata[1] = param.getCustomerName();
            rowdata[2] = param.getCity();
            rowdata[3] = "P";
            rowdata[4] = param.getAccountType();
            rowdata[5] = "0.0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            proceedFromDialog=false;
        }

       
        
    }

	@Override
	public void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/
		
		BankAddCompanyAccountDialog cac = new BankAddCompanyAccountDialog(myframe);
		cac.setBounds(450, 20, 300, 330);
		cac.show();
		
		if (proceedFromDialog){
            // add row to table
            rowdata[0] = param.getAccountNumber();
            rowdata[1] = param.getCustomerName();
            rowdata[2] = param.getCity();
            rowdata[3] = "C";
            rowdata[4] = param.getAccountType(); 
            rowdata[5] = "0.0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            proceedFromDialog=false;
        }

	}
}
