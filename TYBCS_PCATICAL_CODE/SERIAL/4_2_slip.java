import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class InvalidPasswordException extends Exception
{
	//user defined exception
}

class Login extends Frame implements ActionListener
{
	int count;
	Label name;
	Button back;
	Button login;
	Label password;
	TextField tName;
	TextField tPassword;
	
	Login()
	{
		count = 0;
		
		name = new Label("NAME");
		password = new Label("PASSWORD");

		back = new Button("BACK");
		login = new Button("LOGIN");
		
		tName = new TextField(20);
		tPassword = new TextField(20);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(name);
		add(tName);
		add(password);
		add(tPassword);
		add(login);
		add(back);
		
		login.addActionListener(this);
		back.addActionListener(this);
		
		setSize(250, 300);
		setVisible(true);
		setTitle("[LOGIN~]");
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String name;
		String password;
		
		try
		{
			if(event.getSource() == back)
				System.exit(0);
			else if(event.getSource() == login)
			{
				name = new String(tName.getText());
				password = new String(tPassword.getText());
				
				if(name.compareTo(password) == 0)
				{
					JOptionPane.showMessageDialog(null, "[LOGIN-SUCCESSFUL]", "--[LOGIN]--", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					throw new InvalidPasswordException();
				}
			}
		}
		catch(InvalidPasswordException exception)
		{
			count++;
			
			JOptionPane.showMessageDialog(null, "[LOGIN-FAILED]", "--[LOGIN]--", JOptionPane.ERROR_MESSAGE);
			
			tName.setText(" ");
			tPassword.setText(" ");
			
			tName.requestFocus();
			
			if(3 == count)
			{
				JOptionPane.showMessageDialog(null, "[PLEASE TRY AFTER SOME TIME]", "--[LOGIN]--", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}			
		}
	}
	
	public static void main(String args[])
	{
		Login loginPage = new Login();
	}
}

