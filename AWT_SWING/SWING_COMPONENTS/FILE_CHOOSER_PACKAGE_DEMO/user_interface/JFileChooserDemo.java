//package user_interface;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JFileChooserDemo implements ActionListener
{
	JFrame frame;
	Container cont;
	
	JFileChooser fileCh;
	
	JButton but1;
	JButton but2;
	JButton but3;
	
	Font font;
	
	public JFileChooserDemo()
	{
		font = new Font("Verdana", Font.BOLD, 15);
		
		frame = new JFrame("[JFILE-CHOOSER-DEMO]");
		
		cont = frame.getContentPane();
		
		fileCh = new JFileChooser();
		fileCh.setFileFilter(new javax.swing.filechooser.FileFilter() 
			{

			   public String getDescription() 
			   {
			       return "TEXT File (*.txt)";
			   }

			   public boolean accept(File f) 
			   {
			       if (f.isDirectory()) 
				   return true;
			       else 
			       {
				   String filename = f.getName().toLowerCase();
				   return filename.endsWith(".txt");	// || filename.endsWith(".jpeg") ;
			       }
			   }
			}
		);

		//fileCh.setMultiSelectionEnabled(true);
		
		fileCh.setCurrentDirectory(new File(System.getProperty("user.home")));
		
		but1 = new JButton("[SHOW DIALOG]");
		but2 = new JButton("[SHOW OPEN DIALOG]");
		but3 = new JButton("[SHOW SAVE DIALOG]");
		
		but1.setBounds(100, 55, 200, 50);
		but1.setFont(font);

		but2.setBounds(100, 155, 200, 50);
		but2.setFont(font);

		but3.setBounds(100, 255, 200, 50);
		but3.setFont(font);
				
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		
		cont.add(but1);		
		cont.add(but2);
		cont.add(but3);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(700, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		int selection = 0;
		
		if(event.getSource() == but1)
		{
			fileCh.showDialog(frame, "[CHOOSE]");
		}
		else if(event.getSource() == but2)
		{
			int i = 0;
			int retVal = 0;
			StringBuilder str;
			
			retVal = fileCh.showOpenDialog(frame);
			
			if(JFileChooser.APPROVE_OPTION == retVal)
			{
				File selectedFiles = fileCh.getSelectedFile();
				
				str = new StringBuilder();
				
				str.replace(0, str.length(), selectedFiles.getName());
				
				JOptionPane.showMessageDialog(frame, str.toString());
			}
		}
		else if(event.getSource() == but3)
		{
			selection = fileCh.showSaveDialog(frame);
			
			if (selection == JFileChooser.APPROVE_OPTION) 
			{
			    File fileToSave = fileCh.getSelectedFile();
			    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
			}
		}
	}
	
	public static void main(String args[])
	{
		JFileChooserDemo obj = new JFileChooserDemo();
	}
}

