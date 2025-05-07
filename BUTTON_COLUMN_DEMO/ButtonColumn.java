import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import database.Database;
/*
public class ButtonColumn extends JFrame
{
	public ButtonColumn()
	{
		setTitle("Button Column Example");
		
		//table data
		Object data[][] = {	{"1", "Man Utd", 2013, "21"},
					{"2", "Man City", 2014, "3"},
					{"3", "Chelsea", 2015, "7"}
				  };
				  
		String columnHeader[] = {"Position", "Team", "Last Year Won", "Trophies"};
		
		JTable table = new JTable(data, columnHeader);
		
		//set coustom renderer to Team column
		table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		
		//set coustom editor to Team column
		table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JTextField()));
		
		//scrollpane
		JScrollPane pane = new JScrollPane(table);
		getContentPane().add(pane);
		
		setSize(450, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[])
	{
		ButtonColumn bc = new ButtonColumn();
		
		bc.setVisible(true);
	}
}
*/
class ButtonRenderer extends JButton implements TableCellRenderer
{
	public ButtonRenderer()
	{
		//button properties
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col)
	{
		setText((obj == null) ? "":obj.toString());
		
		return this;
	}
}

class ButtonEditor extends DefaultCellEditor
{
	protected JButton btn;
	private String lbl;
	private static boolean clicked;
	
	public ButtonEditor(JTextField txt)
	{
		super(txt);
		
		btn = new JButton();
		
		btn.setOpaque(true);
		
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fireEditingStopped();	
			}		
		});
	}
	
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col)
	{
		//set text to button, set clicked to true, return the button object
		lbl = (obj == null) ? "" : obj.toString();
		btn.setText(lbl);
		ButtonEditor.clicked = true;
		return btn;
	}
	
	public Object getCellEditorValue()
	{
		if(ButtonEditor.clicked)
		{
			//show message
			JOptionPane.showMessageDialog(btn, lbl+" clicked");
		}
		
		//set it to false now that is clicked
		ButtonEditor.clicked = false;
		return new String(lbl);
	}
	
	public boolean stopCellEditing()
	{
		//set clicked to false first
		ButtonEditor.clicked = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped()
	{
		super.fireEditingStopped();
	}
}

class PendingTask
{
	Database dObj = new Database();

	void pendTask()
	{
		int userID = 0;
		java.sql.Date date;
		String status = null;
		String descrip = null;
		String userName = null;
		
		Connection conn = null;
		ResultSet result = null;
		
		Font text = new Font("Verdana", Font.BOLD, 10);

		String colName[] = {"EDIT","TITLE", "DESCRIPTION", "DUE DATE", "STATUS"};
			
		JFrame frame = new JFrame("[VIEW ALL TASKS]");
									
		DefaultTableModel model = new DefaultTableModel();
						
		model.setColumnIdentifiers(colName);
		
		try
		{
			conn = dObj.connectDB();
			
			userID = dObj.getUserID("Prathamesh", conn);
			
			result = dObj.getPendRecords(userID, conn);	
			
			while(result.next())
			{
				userName = result.getString(1);				//userName used as to receive title..
				descrip = result.getString(2);
				date = result.getDate(3);
				status = result.getString(4);
				
				Object obj[] = {"EDIT-->", userName, descrip, date, status};
				
				model.addRow(obj);
			}
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		finally
		{
			try
			{
				if(conn != null && !conn.isClosed())
					conn.close();
			}
			catch(SQLException exception)
			{
				exception.printStackTrace();
				System.out.println(exception);			
			}
			finally
			{}
		}
		
		JTable table = new JTable();

		//table sudha.. setBounds la response karat nahi...		
		table.setFont(text);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		//set coustom renderer to Team column
		table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());		
		//set coustom editor to Team column
		table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JTextField()));
		
		JScrollPane scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frame.add(scroll);

		//layput null set kelyane.. table visible hot nahiyee.... so mhnun te add ch kela nahi mhne default layout dilay vatat..		
		frame.setSize(900, 150);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	

	public static void main(String args[])
	{
		PendingTask bc = new PendingTask();
		
		bc.pendTask();
	}
}

class EditTask
{
	JTextField titleT;
	JTextArea descripT;
	JDatePickerImpl datePicker;
	JRadioButton comp;
	JRadioButton pend;
	JButton save;

	void newTask(String title)
	{
		JFrame frame = new JFrame("[PERSONAL TASK MANAGER]");
		
		Container cont = frame.getContentPane();
		
		JLabel title = new JLabel("1) TITLE : ");
		JLabel descrip = new JLabel("2) DESCRIPTION : ");
		JLabel date = new JLabel("3) DUE DATE : ");
		JLabel status = new JLabel("4) STATUS : ");
		
		titleT = new JTextField(40);
		descripT = new JTextArea(3, 40);
		
		//datepicker
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		
		comp = new JRadioButton("COMPLETED");
		pend = new JRadioButton("PENDING");
		
		ButtonGroup group = new ButtonGroup();
		
		save = new JButton("[SAVE]");
		
		group.add(comp);
		group.add(pend);
		
		title.setBounds(50, 50, 200, 30);
		title.setFont(textF1);
		
		descrip.setBounds(50, 130, 200, 30);
		descrip.setFont(textF1);

		date.setBounds(50, 240, 200, 30);
		date.setFont(textF1);
		
		status.setBounds(50, 350, 200, 30);
		status.setFont(textF1);
		
		titleT.setBounds(300, 50, 200, 30);

		descripT.setBounds(300, 130, 350, 70);
		
		datePicker.setBounds(300, 240, 200, 30);
		
		comp.setBounds(300, 350, 150, 20);
		comp.setFont(textF1);
		
		pend.setBounds(500, 350, 150, 20);
		pend.setFont(textF1);
		
		save.setBounds(240, 400, 200, 30);
		save.setFont(textF1);
		
		titleT.addActionListener(this);
		//descripT.addActionListener(this);
		datePicker.addActionListener(this);
		comp.addActionListener(this);
		pend.addActionListener(this);
		save.addActionListener(this);
		
		cont.add(title);
		cont.add(descrip);
		cont.add(date);
		cont.add(status);
		cont.add(titleT);
		cont.add(descripT);
		cont.add(datePicker);
		cont.add(comp);
		cont.add(pend);
		cont.add(save);
		
		frame.setLayout(null);
		frame.setSize(700, 500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
