import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class slip20_blink implements Runnable
{
	Thread thread;
	
	int flag;
	JLabel label;
	JFrame frame;
	
	public slip20_blink()
	{
		flag = 0;
		
		thread = new Thread(this);
		thread.start();
		
		frame = new JFrame();
		frame.setLayout(null);
		
		ImageIcon icon = new ImageIcon("flower.jpg");
			
		label = new JLabel(icon);
		label.setBounds(100, 100, 300, 200);
		
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
				label.setVisible(false);
				flag = 1;
			}
			else if(1 == flag)
			{
				thread.sleep(1000);
				label.setVisible(true);
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
		slip20_blink thread = new slip20_blink();
	}
}

