import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Slip20_2 extends JFrame implements Runnable
{
	private JLabel l1;
	private boolean isVisible = false;
	
	public Slip20_2()
	{
		ImageIcon ic = new ImageIcon("flower.jpg");
		
		l1 = new JLabel(ic);
				
		setLayout(new FlowLayout());
		add(l1);
				
		setTitle("BLINK IMAGE");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Thread t1 = new Thread(this);
		t1.start();
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				if(isVisible)
					l1.setVisible(false);
				else
					l1.setVisible(true);
				
				isVisible = !isVisible;
				Thread.sleep(500);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		new Slip20_2();
	}
}
