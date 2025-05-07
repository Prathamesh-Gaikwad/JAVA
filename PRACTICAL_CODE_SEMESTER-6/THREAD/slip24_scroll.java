import java.awt.*;
import javax.swing.*;

public class slip24_scroll extends JPanel implements Runnable
{
	private String text = "WELCOME TO JAVA";
	private int x = 0;
	
	public slip24_scroll()
	{
		new Thread(this).start();
	}
	
	public void paintComponent(Graphics graphic)
	{
		super.paintComponent(graphic);
		
		graphic.setFont(new Font("Arial", Font.BOLD, 24));
		
		graphic.drawString(text, x, 50);
	}
	
	public void run()
	{
		while(true)
		{
			x = x + 5;
			
			if(x > getWidth())
				x = text.length() * 10;
				
			repaint();
			
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[])
	{
		JFrame frame = new JFrame("SCROLLING TEXT");
		
		slip24_scroll thread = new slip24_scroll();
		
		frame.add(thread);
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

