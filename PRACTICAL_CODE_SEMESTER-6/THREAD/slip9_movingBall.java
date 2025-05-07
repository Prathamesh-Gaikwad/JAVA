import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class slip9_movingBall extends JFrame
{
	private int y = 0;
	private boolean moving = false;
	
	public slip9_movingBall()
	{
		final BallPanel bPanel = new BallPanel();
		
		JButton start = new JButton("START");

		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				BallThread thread = new BallThread(bPanel);
				thread.start();
			}
		});

		setLayout(new BorderLayout());
		
		add(bPanel, BorderLayout.CENTER);
		add(start, BorderLayout.SOUTH);
		
		setVisible(true);
		
		setTitle("Moving Ball");
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class BallPanel extends JPanel
	{
		public void paintComponent(Graphics graphic)
		{
			super.paintComponent(graphic);
			
			graphic.setColor(Color.red);
			
			graphic.fillOval(180, y, 40, 40);
		}
	}

	class BallThread extends Thread
	{
		private BallPanel panel;
		
		public BallThread(BallPanel panel)
		{
			this.panel = panel;
		}
		
		public void run()
		{
			moving = true;
			
			while(moving)
			{
				y = y + 5;
				
				if(y > panel.getHeight())
					y = 0;
					
				panel.repaint();
				
				try
				{
					Thread.sleep(50);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}	
	}
	
	public static void main(String args[])
	{
		slip9_movingBall object = new slip9_movingBall();
	}
}
