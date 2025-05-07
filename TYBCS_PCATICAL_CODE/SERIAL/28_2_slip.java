import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Temperature extends JFrame
{
	JTextField text1;
	JTextField text2;
	
	Temperature()
	{
		JLabel label1 = new JLabel("Celsius : ");
		JLabel label2 = new JLabel("Fahrenheit : ");
		
		text1 = new JTextField(20);
		text2 = new JTextField(20);
		
		setLayout(new GridLayout(2, 2));
		
		add(label1);
		add(text1);
		add(label2);
		add(text2);
		
		text1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					double celsius;
					double farenheit;
					String str = " ";

					celsius = Double.parseDouble(text1.getText());
					farenheit = (celsius * (9/5)) + 32;

					str = String.format("%.1f", farenheit);

					text2.setText(str);
				}			
			}
		);
		
		text2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					double celsius;
					double farenheit;
					String str = " ";
					
					farenheit = Double.parseDouble(text2.getText());
					celsius = (farenheit - 32.0d ) * (5.0d/9.0d);					
					str = String.format("%.1f", celsius);
					text1.setText(str);		
				}			
			}
		);
		
		setSize(400, 400);
		setVisible(true);
		setTitle("[SWING-TEMPERATURE-CONVERTER]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		new Temperature();
	}
}

