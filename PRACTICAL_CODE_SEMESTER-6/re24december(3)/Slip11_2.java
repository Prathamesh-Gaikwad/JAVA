import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Slip11_2 extends JFrame implements ActionListener
{
	JButton b1;
	JButton b2;
	JTextField t1;
	Container c;
	
	Slip11_2()
	{
		c = getContentPane();
		
		b1 = new JButton("START");
		b1.setBounds(20, 50, 100, 50);
		b1.addActionListener(this);
		
		t1 = new JTextField(50);
		t1.setBounds(10, 10, 100, 30);
		
		c.add(t1);
		c.add(b1);
		
		setLayout(null);
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
			new MyThread();
	}
}

class MyThread extends Thread
{
	MyThread()
	{
		start();
	}
	
	public void run()
	{
		for(int i = 1; i < 100; i++)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){}
			
			t1.setText(t1.getText() + " " + i + "\n");
		}
	}
	
	public static void main(String args[])
	{
		new Slip11_2().show();
	}
}
