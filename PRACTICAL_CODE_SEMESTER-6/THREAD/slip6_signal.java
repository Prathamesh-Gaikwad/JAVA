import java.awt.*;
import javax.swing.*;

public class slip6_signal extends JFrame implements Runnable
{
	private int time;
	private int count;

	private Thread thread;
		
	public slip6_signal()
	{		
		time = 10;
		
		count = 0;
		
		thread = new Thread(this);
		thread.start();
		
		setTitle("TRAFFIC SIGNAL TIMER");
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				while(time >= 0)
				{
					repaint();
					Thread.sleep(1000);
					time--;
				}
				
				count = (count + 1) % 3;
				
				if(1 == count)
					time = 5;
				else
					time = 10;
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics graphic)
	{
		super.paint(graphic);
		
		graphic.setColor(Color.black);
		
		graphic.drawOval(70, 50, 50, 50);
		graphic.drawOval(70, 110, 50, 50);
		graphic.drawOval(70, 170, 50, 50);
		
		graphic.setColor(Color.black);
		graphic.drawString("Time : " + time, 85, 230);
		
		if(0 == count)
		{
			graphic.setColor(Color.green);
			graphic.fillOval(70, 110, 50, 50);
		}
		else if(1 == count)
		{
			graphic.setColor(Color.orange);
			graphic.fillOval(70, 170, 50, 50);			
		}
		else
		{
			graphic.setColor(Color.red);
			graphic.fillOval(70, 50, 50, 50);
		}
	}
	
	public static void main(String args[])
	{
		slip6_signal thread = new slip6_signal();
	}
}

