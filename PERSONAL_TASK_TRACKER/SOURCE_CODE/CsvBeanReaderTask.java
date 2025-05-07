//USER INTERFACE CLASSES...
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableModel;

//DATABASE USER-DEFINED CLASSES
import database.Database;

//COLLECTION CLASSES
import java.util.Iterator;
import java.util.LinkedList;

//FILE EXCEPTIONS
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

//CSV DEPENDENCIES
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

//DATABASE CLASSES..
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//DATE
import java.text.SimpleDateFormat;

public class CsvBeanReaderTask implements ActionListener
{
	static JFrame frame;
	static JButton save;
	static LinkedList<Record> rList;

	//DATABASE OBJECT
	Database dObj = new Database();
	
	//to receive userName from another class to multiple methods...	[selected from 963]
	Registration rObj = new Registration(1);
	
	Home hObj = new Home(1);
	
	public CsvBeanReaderTask()
	{
		save = new JButton("[ADD TO TRACKER]");
		save.addActionListener(this);
	}
	
	static void readCSVFile(String csvFileName) 
	{
		StringBuilder str1;
		StringBuilder str2;
		StringBuilder str3;
		java.util.Date date;
		java.sql.Date sqlDate;
		ICsvBeanReader beanReader = null;
		
		Font text;
		JTable table;
		JScrollPane scroll;
		DefaultTableModel model;

		rList = new LinkedList<Record>();
		
		text = new Font("Verdana", Font.BOLD, 18);
		Font textHeader = new Font("Verdana", Font.BOLD, 20);

		String colName[] = {"TITLE", "DESCRIPTION", "DUE DATE", "STATUS"};
			
		frame = new JFrame("[FILE TASKS]");
		frame.setLayout(new BorderLayout());
									
		model = new DefaultTableModel();
						
		model.setColumnIdentifiers(colName);

		save.setFont(text);
		save.setBackground(Color.cyan);
		save.setForeground(Color.BLACK);

		str1 = new StringBuilder();
		str2 = new StringBuilder();
		str3 = new StringBuilder();
		
		CellProcessor[] processors = new CellProcessor[] {
				new NotNull(), // title
				new NotNull(), // description
				new ParseDate("yyyy-MM-dd"), // dueDate
				new NotNull(), // status
		};

		try 
		{
			beanReader = new CsvBeanReader(new FileReader(csvFileName), CsvPreference.STANDARD_PREFERENCE);
			
			String[] header = beanReader.getHeader(true);
			
			Task bookBean = null;
			
			while ((bookBean = beanReader.read(Task.class, header, processors)) != null) 
			{
				/*System.out.printf("\n\t%-30s \n\t%-30s \n\t%tD \n\t%-30s", bookBean.getTitle(), bookBean.getDescrip(), bookBean.getDueDate(), bookBean.getStatus());*/
				
				str1.replace(0, str1.length(), bookBean.getTitle());

				str2.replace(0, str2.length(), bookBean.getDescrip());

				date = bookBean.getDueDate();
				sqlDate = new java.sql.Date(date.getTime());

				str3.replace(0, str3.length(), bookBean.getStatus());

				Record records = new Record(str1.toString(), str2.toString(), sqlDate.toString(), str3.toString());
				rList.add(records);

				Object obj[] = {str1.toString(), str2.toString(), sqlDate.toString(), str3.toString()};					
				model.addRow(obj);

				/*System.out.println("\n\t" + sqlDate);
				System.out.println();*/
			}
		} 
		catch (FileNotFoundException ex) 
		{
			System.err.println("Could not find the CSV file: " + ex);
		} 
		catch (IOException ex) 
		{
			System.err.println("Error reading the CSV file: " + ex);
		} 
		finally 
		{
			if (beanReader != null) 
			{
				try 
				{
					beanReader.close();
				} 
				catch (IOException ex) 
				{
					System.err.println("Error closing the reader: " + ex);
				}
			}
		}

		table = new JTable();

		//table sudha.. setBounds la response karat nahi...		
		table.setFont(text);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		table.setRowHeight(table.getRowHeight() + 20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.BLACK);
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(textHeader);
		
		scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(save, BorderLayout.SOUTH);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.pack();

		//layput null set kelyane.. table visible hot nahiyee.... so mhnun te add ch kela nahi mhne default layout dilay vatat..		
		frame.setSize(900, 150);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(screenSize.width-35,screenSize.height-35);
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == save)
		{
			int count = 0;
			int userID = 0;
			String message;
			String userName;
			int rowInserted = 0;
			int messageType = -1;
			
			Connection conn = null;
			
			Iterator move;
			Record records;
			java.sql.Date sqlDate;
			java.util.Date utilDate;
			SimpleDateFormat format;
			
			try
			{
				conn = dObj.connectDB();

				userName = rObj.getUserName();
				
				if(Registration.choice1Str.toString().equals("Employee"))
					userID = dObj.getUserID(userName, conn);			
				else
					userID = dObj.getUserID(userName, conn, true);				
				
				move = rList.iterator();
				
				while(move.hasNext())
				{
					records = (Record)move.next();
					
					format = new SimpleDateFormat("yyyy-mm-dd");
					utilDate = format.parse(records.date);
					sqlDate = new java.sql.Date(utilDate.getTime());

					if(Registration.choice1Str.toString().equals("Employee"))
						rowInserted = dObj.insertRecord(records.title, records.descrip, sqlDate, records.status, userID, conn, false);
					else
						rowInserted = dObj.insertRecord(records.title, records.descrip, sqlDate, records.status, userID, conn, true);
				}

				if(rowInserted > 0)
				{
					message = "[-TASK SAVED SUCCESSFULLY-]";
					messageType = JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog(frame, message, "[-SAVE TASK-]", messageType);
										
					//recent tasks restore..
					//Home obj = new Home(10);
					
					hObj.setRecentTasks();
					hObj.setTaskSum();
					hObj.setNotify();
					//frame.setVisible(false);					
				}
				else
				{
					message = "[-UNABLE TO SAVE TASK-]";
					messageType = JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog(frame, message, "[-SAVE TASK-]", messageType);			
					//frame.setVisible(false);					
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				System.out.println(exception);
			}
		
		}
	}
	
	/*public static void main(String[] args) 
	{
		String csvFileName = "task.csv";
		
		readCSVFile(csvFileName);
	}*/
}

