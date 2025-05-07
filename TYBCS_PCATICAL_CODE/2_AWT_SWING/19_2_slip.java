import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ComboBoxDemo extends JFrame implements ActionListener
{
	JLabel label;
	JComboBox box;
	JButton button;
	JTextField text;	
	
	ComboBoxDemo()
	{
		String arr[] = {" ", "DATA SCIENCE", "WEB TECHNOLOGY", "JAVA", "PYTHON", "OPERATING SYSTEM"};
		
		label = new JLabel("SELECT SUBJECT : ");
		
		text = new JTextField(25);
		
		button = new JButton("ENTER");
		
		box = new JComboBox(arr);
		
		setLayout(new FlowLayout());
		
		add(text);
		add(label);
		add(box);
		add(button);
		
		button.addActionListener(this);
		
		setSize(500, 500);
		setVisible(true);
		setTitle("[JCOMBOBOX-DEMONSTRATION]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String string = " " + box.getItemAt(box.getSelectedIndex());
		
		if(event.getSource() == button)
		{
			text.setText(string);
		}
	}
	
	public static void main(String args[])
	{
		new ComboBoxDemo();
	}
}
/*
19_2_slip.java:8: warning: [rawtypes] found raw type: JComboBox
	JComboBox box;
	^
  missing type arguments for generic class JComboBox<E>
  where E is a type-variable:
    E extends Object declared in class JComboBox
19_2_slip.java:22: warning: [rawtypes] found raw type: JComboBox
		box = new JComboBox(arr);
		          ^
  missing type arguments for generic class JComboBox<E>
  where E is a type-variable:
    E extends Object declared in class JComboBox
19_2_slip.java:22: warning: [unchecked] unchecked call to JComboBox(E[]) as a member of the raw type JComboBox
		box = new JComboBox(arr);
		      ^
  where E is a type-variable:
    E extends Object declared in class JComboBox
19_2_slip.java:5: warning: [serial] serializable class ComboBoxDemo has no definition of serialVersionUID
class ComboBoxDemo extends JFrame implements ActionListener
^
4 warnings
*/
