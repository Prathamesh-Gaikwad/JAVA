import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Division extends JFrame
{
	JButton button;
	JTextField text1;
	JTextField text2;
	JTextField text3;
	
	Division()
	{
		JLabel label1 = new JLabel("[ENTER NUMBER 1 : ]");
		JLabel label2 = new JLabel("[ENTER NUMBER 2 : ]");
		JLabel label3 = new JLabel("[RESULT : ]");
				
		button = new JButton("[DIVIDE]");
		
		text1 = new JTextField(20);
		text2 = new JTextField(20);
		text3 = new JTextField(20);
		
		//text3.setEditable(false);

		JPanel panel = new JPanel();		
		panel.setLayout(new GridLayout(3, 2, 5, 5));
		
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
		
		setLayout(new FlowLayout());
		
		add(panel);
		add(button);
		
		button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					int result;
					int number1;
					int number2;
					
					try
					{
						number1 = Integer.parseInt(text1.getText());
						number2 = Integer.parseInt(text2.getText());
						result = number1 / number2;
						
						text3.setText(String.valueOf(result));
					}
					catch(NumberFormatException exception)
					{
						JOptionPane.showMessageDialog(null, "[PLEASE ENTER VALID INTEGERS]", "~[INPUT-ERROR]~", JOptionPane.ERROR_MESSAGE);
					}
					catch(ArithmeticException exception)
					{
						JOptionPane.showMessageDialog(null, "[DIVIDE BY ZERO NOT ALLOWED]", "~[ARITHMETIC-ERROR]~", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		);
		
		setSize(400, 400);
		setVisible(true);
		setTitle("[DIVISION-OPERATION]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) throws Exception
	{
		new Division();
	}
}

