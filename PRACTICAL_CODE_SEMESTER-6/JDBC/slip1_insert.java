import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class slip1_insert implements ActionListener
{
	JFrame frame;

	JTextField id;
	JTextField name;
	JTextField position;
	JTextField workingHr;

	JButton Insert;
	JButton Reset;
		
	public slip1_insert()
	{
		frame = new JFrame();
		GridLayout layout = new GridLayout(5, 2, 0, 0);
		
		JLabel idL = new JLabel("EMPLOYEE ID : ");
		JLabel nameL = new JLabel("EMPLOYEE NAME : ");
		JLabel positionL = new JLabel("EMPLOYEE DESIGNATION : ");
		JLabel workingHrL = new JLabel("EMPLOYEE WORKING HOUR : ");
		
		id = new JTextField();
		name = new JTextField();
		position = new JTextField();
		workingHr = new JTextField();
		
		id.addActionListener(this);
		name.addActionListener(this);
		position.addActionListener(this);
		workingHr.addActionListener(this);

		Insert = new JButton("INSERT");
		Reset = new JButton("RESET");
		
		Insert.addActionListener(this);
		Reset.addActionListener(this);
		
		frame.setLayout(layout);
		
		frame.add(idL);
		frame.add(id);
		frame.add(nameL);
		frame.add(name);
		frame.add(positionL);
		frame.add(position);
		frame.add(workingHrL);
		frame.add(workingHr);
		frame.add(Insert);
		frame.add(Reset);
		
		frame.setTitle("EMPLOYEE REGISTRATION");
		frame.setSize(500, 250);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{		
		if(Insert == e.getSource())
		{
			short no;
			Connection conn = null;
			PreparedStatement statement = null;			

			try
			{
				try
				{
					conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
					statement = conn.prepareStatement("insert into employee values(?, ?, ?, ?);");
					
					statement.setInt(1, Integer.parseInt(id.getText()));
					statement.setString(2, name.getText());
					statement.setString(3, position.getText());
					statement.setInt(4, Integer.parseInt(workingHr.getText()));
					
					no = (short)statement.executeUpdate();
					
					if(no > 0)
						JOptionPane.showMessageDialog(frame, "RECORD INSERTED SUCCESSFULLY");
					else
						JOptionPane.showMessageDialog(frame, "ERROR IN INSERTION");
						
				}
				catch(Exception ex1)
				{
					ex1.printStackTrace();
				}
				finally
				{
					conn.close();
					statement.close();
				}
			}
			catch(Exception ex2)
			{
				ex2.printStackTrace();
			}
		}
		else if(Reset == e.getSource())
		{
			id.setText(" ");
			name.setText(" ");
			position.setText(" ");
			workingHr.setText(" ");
		}
	}
	
	public static void main(String args[])
	{
		slip1_insert object = new slip1_insert();
	}
}

