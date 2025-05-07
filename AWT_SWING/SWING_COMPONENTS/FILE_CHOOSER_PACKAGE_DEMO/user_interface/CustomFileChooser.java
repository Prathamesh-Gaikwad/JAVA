package user_interface;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.FileChooserUI;
import javax.accessibility.AccessibleContext;

public class CustomFileChooser extends JFileChooser
{
	Font font;
		
	public CustomFileChooser ()
	{
		super();
		font = new Font("Verdana",Font.BOLD,16);
		initComponent();
	}

	public CustomFileChooser (String currentDirPath)
	{
		super(currentDirPath);
		font = new Font("Verdana",Font.BOLD,16);
		initComponent();
	}

	public void initComponent()
	{
		Component c[] = getComponents();
		customizeUI(c);
		setFileChooserFont(c);
	}

	public void customizeUI(Component[] c)
	{
		int count = 1;
		
		for(int i=0;i<c.length;i++)
		{
			if(c[i] instanceof JPanel)
			{
				((JPanel)c[i]).setBackground(Color.DARK_GRAY);

				if(((JPanel)c[i]).getComponentCount() !=0)
				{
					customizeUI(((JPanel)c[i]).getComponents());
				}
			}
			
			if(c[i] instanceof JTextField)
			{
				//System.out.println("JTextField");
				((JTextField)c[i]).setBackground(Color.WHITE);
			}
			/*
			if(c[i] instanceof JToggleButton)
			{
				if(1 == count)
					count++;
				else
					c[i].setEnabled(true);
										
				System.out.println("JToggleButton");
			}
			
			if(c[i] instanceof JScrollPane)
			{
				System.out.println("JScrollPane");
			}
			*/
			
			if(c[i] instanceof JLabel)
			{
				c[i].setForeground(Color.WHITE);
			}
		}   
	}
	
	public void setFileChooserFont(Component[] comp)
	{
		for(int x = 0; x < comp.length; x++)
		{
			if(comp[x] instanceof Container) 
				setFileChooserFont(((Container)comp[x]).getComponents());

			try
			{
				comp[x].setFont(font);
			}
			catch(Exception e){}//do nothing
		}
	}

  	@Override
	protected JDialog createDialog(Component parent) throws HeadlessException 
	{
		FileChooserUI ui = getUI();
		String title = ui.getDialogTitle(this);
		putClientProperty(AccessibleContext.ACCESSIBLE_DESCRIPTION_PROPERTY, title);

		JDialog dialog;

		if (parent instanceof Frame) 
		{
			dialog = new JDialog((Frame)parent, title, true);
		}
		else 
		{
			dialog = new JDialog((Dialog)parent, title, true);
		}
		dialog.setComponentOrientation(this.getComponentOrientation());

		Container contentPane = dialog.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(this, BorderLayout.CENTER);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);


		dialog.pack();
		dialog.setLocationRelativeTo(parent);

		return dialog;
	}
}

