import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Student extends JFrame implements ActionListener
{
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JCheckBox box1;
	JCheckBox box2;
	JCheckBox box3;
	JTextField text1;
	JTextField text2;
	JRadioButton radio1;
	JRadioButton radio2;
	JRadioButton radio3;
	
	Student()
	{
		label1 = new JLabel("Your Name ");
		label2 = new JLabel("Your Class");
		label3 = new JLabel("Your Hobbies");
		
		box1 = new JCheckBox("Music");
		box2 = new JCheckBox("Dance");
		box3 = new JCheckBox("Sports");
		
		radio1 = new JRadioButton("FY");
		radio2 = new JRadioButton("SY");
		radio3 = new JRadioButton("TY");
		
		text1 = new JTextField(20);
		text2 = new JTextField(30);
		
		setLayout(new FlowLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4, 1));
		
		add(label1);
		add(text1);
				
		panel1.add(label2);
		panel1.add(radio1);
		panel1.add(radio2);
		panel1.add(radio3);

		add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 1));
		
		panel2.add(label3);
		panel2.add(box1);
		panel2.add(box2);
		panel2.add(box3);

		add(panel2);

		add(text2);
		
		text1.addActionListener(this);
		radio1.addActionListener(this);
		radio2.addActionListener(this);
		radio3.addActionListener(this);
		box1.addActionListener(this);
		box2.addActionListener(this);
		box3.addActionListener(this);	
				
		setSize(500, 500);
		setVisible(true);
		setTitle("[STUDENT-DETAILS]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String _class = " ";
		String hobbie = " ";
		String name = text1.getText();
		
		if(radio1.isSelected())
		{
			hobbie = radio1.getText();
		}

		if(radio2.isSelected())
		{
			hobbie = radio2.getText();		
		}

		if(radio3.isSelected())
		{
			hobbie = radio3.getText();		
		}

		if(box1.isSelected())
		{
			_class = box1.getText();
		}

		if(box2.isSelected())
		{
			_class = box2.getText();
		}

		if(box3.isSelected())
		{
			_class = box3.getText();
		}
		
		text2.setText(name + " " + hobbie + " " + _class);
	}
	
	public static void main(String args[])
	{
		new Student();
	}
}


