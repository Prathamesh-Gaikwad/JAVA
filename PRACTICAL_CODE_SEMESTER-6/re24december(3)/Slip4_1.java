import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Slip4_1 extends JFrame implements Runnable
{
	Thread thread;
	JLabel label;
	int flag;

	Slip4_1()
	{
		label = new JLabel("THIS IS MULTITHREADING");
		label.setBounds(100, 100, 150, 40);
		
		add(label);
		
		setSize(500, 500);
		setVisible(true);
		SetDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		thread = new Thread(this);
		
		thread.start();
		
		setLayout(null);
		
		flag = 0;
	}
	
	public void run()
	{
		try
		{
			if(flag == 0)
			{
				thread.sleep(20);
				label.setText(" ");
				flag = 1;
			}
			
			if(flag == 1)
			{
				thread.sleep(20);
				label.setText("THIS IS MULTITHREADING");
				flag = 0;				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		run();
	}
	
	public static void main(String args[])
	{
		new Slip4_1();
	}
}
