import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BackgroundImageJFrame extends JFrame
{
	JButton b1;
	JLabel l1;

	public BackgroundImageJFrame()
	{
		setTitle("Background Color for JFrame");
		setSize(1000,1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("registration1.jpeg"));
		add(background);
		background.setLayout(new FlowLayout());
		l1=new JLabel("Here is a button");
		b1=new JButton("I am a button");
		background.add(l1);
		background.add(b1);
	}
	public static void main(String args[])
	{
		new BackgroundImageJFrame();
	}
}
