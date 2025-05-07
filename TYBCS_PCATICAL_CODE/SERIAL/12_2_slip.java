import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Calculator extends JFrame implements ActionListener
{
	int operator;
	double result;
	double operand1;
	double operand2;
	JButton button[] = new JButton[18];
	JTextField textField;
	
	Calculator()
	{
		int i;
		
		textField = new JTextField(30);
		
		button[0] = new JButton("1");
		button[1] = new JButton("2");
		button[2] = new JButton("3");
		button[3] = new JButton("+");
		button[4] = new JButton("4");
		button[5] = new JButton("5");
		button[6] = new JButton("6");
		button[7] = new JButton("-");
		button[8] = new JButton("7");
		button[9] = new JButton("8");
		button[10] = new JButton("9");
		button[11] = new JButton("*");
		button[12] = new JButton("0");
		button[13] = new JButton(".");
		button[14] = new JButton("=");
		button[15] = new JButton("/");
		button[16] = new JButton("DELETE");
		button[17] = new JButton("CLEAR");
					
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		for(i = 0; i < 16; i++)
		{
			panel.add(button[i]);
		}
		
		setLayout(new FlowLayout());
		
		add(textField);
		add(panel);
		add(button[16]);
		add(button[17]);
		
		for(i = 0; i < 18; i++)
			button[i].addActionListener(this);
					
		setSize(250, 300);
		setVisible(true);
		setTitle("----------------[MY-CALCULATOR]----------------");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		int i;
		String string;
		
		if(event.getSource() == button[0])
			textField.setText(textField.getText().concat("1"));

		if(event.getSource() == button[1])
			textField.setText(textField.getText().concat("2"));

		if(event.getSource() == button[2])
			textField.setText(textField.getText().concat("3"));

		if(event.getSource() == button[4])
			textField.setText(textField.getText().concat("4"));

		if(event.getSource() == button[5])
			textField.setText(textField.getText().concat("5"));

		if(event.getSource() == button[6])
			textField.setText(textField.getText().concat("6"));

		if(event.getSource() == button[8])
			textField.setText(textField.getText().concat("7"));

		if(event.getSource() == button[9])
			textField.setText(textField.getText().concat("8"));

		if(event.getSource() == button[10])
			textField.setText(textField.getText().concat("9"));

		if(event.getSource() == button[12])
			textField.setText(textField.getText().concat("0"));

		if(event.getSource() == button[13])
			textField.setText(textField.getText().concat("."));
			
		if(event.getSource() == button[3])
		{
			operand1 = Double.parseDouble(textField.getText());
			operator = 1;
			textField.setText(" ");
		}		

		if(event.getSource() == button[7])
		{
			operand1 = Double.parseDouble(textField.getText());
			operator = 2;
			textField.setText(" ");
		}		

		if(event.getSource() == button[11])
		{
			operand1 = Double.parseDouble(textField.getText());
			operator = 3;
			textField.setText(" ");
		}		

		if(event.getSource() == button[15])
		{
			operand1 = Double.parseDouble(textField.getText());		
			operator = 4;
			textField.setText(" ");
		}
		
		if(event.getSource() == button[14])
		{
			operand2 = Double.parseDouble(textField.getText());
			
			switch(operator)
			{
				case 1 :
					result = operand1 + operand2;
					break;
					
				case 2 :
					result = operand1 - operand2;
					break;
					
				case 3 :
					result = operand1 * operand2;
					break;
				
				case 4 : 
					result = operand1 / operand2;
					break;
					
				default :
					result = 0.0d;
			}
			
			textField.setText(" " + result);
		}
		
		if(event.getSource() == button[17])
			textField.setText(" ");
			
		if(event.getSource() == button[16])
		{
			string = textField.getText();
			
			textField.setText(" ");
			
			for(i = 0; i < (string.length()-1); i++)
				textField.setText(textField.getText() + string.charAt(i));
		}
	}
	
	public static void main(String args[])
	{
		new Calculator();
	}
}

