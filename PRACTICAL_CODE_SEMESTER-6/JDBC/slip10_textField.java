import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class slip10_textField implements ActionListener
{
	JFrame frame;
	JButton button;
	JTextField text1;
	JTextField text2;
	JTextField text3;
	Connection conn = null;
	
	public slip10_textField()
	{
		frame = new JFrame();
		
		try
		{
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		button = new JButton("Select");
		button.addActionListener(this);
		
		text1 = new JTextField();
		text1.setBounds(10, 10, 200, 30);
		text2 = new JTextField();
		text1.setBounds(10, 50, 200, 30);
		text3 = new JTextField();
		text1.setBounds(10, 100, 200, 30);
		
		frame.setLayout(new FlowLayout());
		
		frame.add(button);
		frame.add(text1);
		frame.add(text2);
		frame.add(text3);
		
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public ResultSet select()
	{
		ResultSet result = null;
		Statement statement = null;
		
		try
		{
			try
			{
				statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				result = statement.executeQuery("select * from employee;");
				
				if(result != null)
					return result;
			}
			catch(Exception ex1)
			{
				ex1.printStackTrace();
			}
			finally
			{
				//statement.close();
			}
		}
		catch(Exception ex2)
		{
			ex2.printStackTrace();
		}
		
		return null;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		ResultSet result = null;
		
		try
		{
			try
			{
				result = select();
				
				if(result != null)
				{
					result.first();
					
					text1.setText(" " + result.getInt(1));
					text2.setText(result.getString(2));
					text3.setText(result.getString(3));
				}
			}
			catch(Exception ex1)
			{
				ex1.printStackTrace();
			}
		}
		catch(Exception ex2)
		{
			ex2.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		slip10_textField object = new slip10_textField();
	}
}
