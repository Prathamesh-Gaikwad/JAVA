import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class StringPlay extends JFrame implements ActionListener
{
	JButton button1;
	JButton button2;
	JTextField text1;
	JTextField text2;
	JTextField text3;
	
	StringPlay()
	{
		text1 = new JTextField(25);
		text2 = new JTextField(25);
		text3 = new JTextField(25);
		
		button1 = new JButton("[CONCAT]");
		button2 = new JButton("[REVERSE]");
		
		setLayout(new FlowLayout());
		
		add(text1);
		add(text2);
		add(button1);
		add(button2);
		add(text3);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		setSize(400, 400);
		setVisible(true);
		setTitle("~[STRING-OPERATION]~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == button1)
		{
			text3.setText(text1.getText() + text2.getText());
			text1.setText(" ");
			text2.setText(" ");			
		}
		
		if(event.getSource() == button2)
		{
			String str = text1.getText();
			StringBuffer string = new StringBuffer(str);
			
			text3.setText(" " + (string.reverse()));
			text1.setText(" ");
			text2.setText(" ");			
		}
	}
	
	public static void main(String args[])
	{
		new StringPlay();
	}
}

