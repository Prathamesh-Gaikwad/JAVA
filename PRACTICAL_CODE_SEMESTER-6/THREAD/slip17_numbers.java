import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class slip17_numbers implements ActionListener
{
	JFrame frame;
	
	Container cont;
	JButton button1;
	JButton button2;
	JTextField text;
	
	public slip17_numbers()
	{
		frame = new JFrame();
		
		cont = frame.getContentPane();
		
		text = new JTextField(500);
		text.setBounds(10, 10, 1000, 30);
		
		button1 = new JButton("START");
		button1.setBounds(20, 50, 100, 50);
		button1.addActionListener(this);
		
		cont.add(text);
		cont.add(button1);
		
		frame.setLayout(null);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(button1 == e.getSource())
			new MyThread();
	}
	
	class MyThread extends Thread
	{
		MyThread()
		{
			start();
		}
		
		public void run()
		{
			for(int i = 1; i <= 100; i++)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				text.setText(text.getText() + " " + i + "\n");
			}
		}
	}
	
	public static void main(String args[])
	{
		slip17_numbers object = new slip17_numbers();
	}
}

