import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class slip4_runnable implements Runnable
{
	Thread thread;
	
	int flag;
	JLabel label;
	JFrame frame;
	
	public slip4_runnable()
	{
		flag = 0;
		
		thread = new Thread(this);
		thread.start();
		
		frame = new JFrame();
		frame.setLayout(null);
				
		label = new JLabel("MULTITHREADING");
		label.setBounds(100, 100, 150, 40);
		
		frame.add(label);
		
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run()
	{
		try
		{
			if(0 == flag)
			{
				thread.sleep(1000);
				label.setText(" ");
				flag = 1;
			}
			else if(1 == flag)
			{
				thread.sleep(1000);
				label.setText("MULTITHREADING");
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
		slip4_runnable thread = new slip4_runnable();
	}
}

