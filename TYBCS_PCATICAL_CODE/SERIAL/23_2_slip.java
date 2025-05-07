import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.text.DecimalFormat;

class CurrencyConverter extends JFrame implements ActionListener
{
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JTextField text1;
	JTextField text2;
	JTextField text3;
	
	CurrencyConverter()
	{
		label1 = new JLabel("[SINGAPOR DOLLAR : ]");
		label2 = new JLabel("[US DOLLAR : ]");
		label3 = new JLabel("[EUROS : ]");
		
		text1 = new JTextField(25);
		text2 = new JTextField(25);
		text3 = new JTextField(25);
		
		setLayout(new GridLayout(3, 2, 5, 5));
		
		add(label1);
		add(text1);
		add(label2);
		add(text2);
		add(label3);
		add(text3);
		
		text1.addActionListener(this);
		
		setSize(500, 500);
		setVisible(true);
		setTitle("[CURRENCY-CONVERTER]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		double singapore = Double.parseDouble(text1.getText());
		double usDollar = singapore/1.41;
		double euros = singapore * 0.65;
		
		//DecimalFormat decimal = new DecimalFormat("#.00");
		//text2.setText(decimal.format(usDollar));
		//text3.setText(decimal.format(euros));
		
		String string = String.format("%.2f", usDollar);
		text2.setText(string);
		
		string = String.format("%.2f", euros);
		text3.setText(string);
	}
	
	public static void main(String args[])
	{
		new CurrencyConverter();
	}
}

