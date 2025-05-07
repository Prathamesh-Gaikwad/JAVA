import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChoiceListJDBCDemo implements ActionListener
{
	static Choice choice;
	JFrame frame;
	JLabel label;
	JButton button;
	//JPanel panel;
	
	public ChoiceListJDBCDemo()
	{
		frame = new JFrame("MY CHOICE DEMO JDBC");
		
		choice = new Choice();
		
		label = new JLabel("SELECTED EMPLOYEE NAME DISPLAY HERE");
		
		button = new JButton("SUBMIT");
		
		//panel = new JPanel();
		
		fillChoice(choice);
		
		button.addActionListener(this);
		
		choice.setBounds(100, 100, 200, 40);
		label.setBounds(100, 300, 200, 40);
		button.setBounds(100, 400, 200, 40);
		
		frame.add(choice);
		frame.add(label);
		frame.add(button);
		
		frame.setLayout(null);
		frame.setSize(300,400);    
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		if(button == source)
		{
			label.setText(choice.getItem(choice.getSelectedIndex()));
		}
	}
	
	public void fillChoice(Choice choice)
	{
		Connection conn = null;
		ResultSet result = null;
		Statement statement = null;
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				statement = conn.createStatement();
				
				result = statement.executeQuery("select name from employee;");
				
				while(result.next())
					choice.add(result.getString("name"));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				statement.close();
				result.close();
				conn.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		ChoiceListJDBCDemo obj = new ChoiceListJDBCDemo();
	}
}

