import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import net.sourceforge.jdatepicker.impl.*;

class DateDemo implements ActionListener
{
	JFrame frame;
	JButton button;
	Container cont;

	UtilDateModel model;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	
	DateDemo()
	{
		frame = new JFrame("Date insertion and selection in datbase");
		
		cont = frame.getContentPane();
		
		button = new JButton("OK");
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);

		datePicker.setBounds(100, 50, 200, 30);
		//datePicker.addActionListener(this);		

		button.setBounds(100, 200, 200, 30);
		button.addActionListener(this);
		
		cont.add(datePicker);
		cont.add(button);
		
		frame.setVisible(true);
		frame.setSize(400, 400);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		java.util.Date utilDate;
		java.sql.Date sqlDate;
		String sql1;
		String message;
		String userName;
		int rowInserted = 0;
		int messageType = -1;
				
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement statement = null;

		String user = "postgres";
		String pass = "Pratham@2002";
		String dbURL = "jdbc:postgresql://localhost:5432/postgres";
		
		if(event.getSource() == button)
		{
		
			utilDate = (java.util.Date) datePicker.getModel().getValue();	//first receive as util date
						
			sqlDate = new java.sql.Date(utilDate.getTime());		//then make it as sql date to insert into table
			
			try
			{
				conn = DriverManager.getConnection(dbURL, user, pass);

				sql1 = "insert into Dates (DueDate) values(?);";

				statement = conn.prepareStatement(sql1);
				
				statement.setDate(1, sqlDate);
		
				rowInserted = statement.executeUpdate();

				if(rowInserted > 0)
				{
					message = "[-TASK SAVE SUCCESSFULLY-]";
					messageType = JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog(frame, message, "[-SAVE TASK-]", messageType);
				}
				else
				{
					message = "[-UNABLE TO SAVE TASK-]";
					messageType = JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog(frame, message, "[-SAVE TASK-]", messageType);			
				}

				sql1 = "select DueDate from Dates;";
				
				statement = conn.prepareStatement(sql1);
				
				result = statement.executeQuery();			
				
				if(result.next())
					System.out.println("DueDate : " + result.getDate(1));
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
			}
		}
	}

	public static void main(String args[])
	{
		DateDemo obj = new DateDemo();		
	}
}

