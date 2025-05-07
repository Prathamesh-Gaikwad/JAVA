//USER INTERFACE CLASSES...
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableModel;

//DATABASE CLASSES..
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//DATE PICKER
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import net.sourceforge.jdatepicker.impl.*;

//DATABASE USER-DEFINED CLASSES
import database.Database;

//COLLECTION CLASSES
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

//EXCEPTION
import javax.mail.MessagingException;

public class Registration implements ActionListener
{
	JFrame frame;
	JButton login;
	JButton register;
	
	Font font;
	Font textF;
	Font butF;
	
	//login
	JTextField userT;
	JPasswordField passT;
	
	//myRegistration
	JFrame regF;
	
	//textfields
	JTextField userR;
	JTextField mailR;
	JPasswordField passR;
	
	//button
	JButton regB;
	
	//Home 
	Home home;
	
	//login event
	static String userL;	
	
	//register reminder time
	JTextField min;
	JTextField hour;
	JRadioButton am;
	JRadioButton pm;
	ButtonGroup group;
	static String meridiem = "AM";
	
	Registration()
	{
		ImagePanel panel = new ImagePanel( new ImageIcon("/home/prathamesh/Documents/JAVA/PERSONAL_TASK_TRACKER/TASK_TRACKER/images/login.jpeg").getImage());
		panel.setBounds(0, 0, 750, 1000);

		font = new Font("Verdana", Font.BOLD, 40);		//25
		textF = new Font("Arial", Font.BOLD, 25);
		butF = new Font("Verdana", Font.BOLD, 18);

		frame = new JFrame();		
		
		JLabel head = new JLabel(" LOGIN \\ REGISTRATION ");		
		JLabel userName = new JLabel("USER NAME");
		JLabel password = new JLabel("PASSWORD");
		
		userT = new JTextField(30);
		passT = new JPasswordField(10);

		login = new JButton("LOGIN");
		register = new JButton("REGISTER");
				
		head.setBounds(1200, 200, 800, 50);
		head.setFont(font);
		
		userName.setBounds(1200, 330, 800, 30);
		userName.setFont(textF);
		userT.setFont(butF);
		userT.setBounds(1200, 360, 300, 40);
		
		password.setBounds(1200, 470, 800, 30);
		password.setFont(textF);
		passT.setFont(butF);
		passT.setBounds(1200, 500, 300, 40);
		
		login.setBounds(1200, 630, 160, 50);
		login.setFont(butF);
		
		register.setBounds(1500, 630, 160, 50);
		register.setFont(butF);
		
		login.addActionListener(this);
		register.addActionListener(this);
		
		frame.add(head);
		frame.add(userName);
		frame.add(userT);
		frame.add(password);
		frame.add(passT);
		frame.add(login);
		frame.add(register);
		
		frame.getContentPane().add(panel);
		frame.setBackground(Color.WHITE);
		frame.pack();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.pack();
		
		frame.setLayout(null);
		frame.setTitle("[-PERSONAL TASK MANAGER-]");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenSize.width-50,screenSize.height-50);
	}
	
	Registration(int param)
	{
	
	}
	
	void myRegistration()
	{
		ImagePanel panel = new ImagePanel( new ImageIcon("/home/prathamesh/Documents/JAVA/PERSONAL_TASK_TRACKER/TASK_TRACKER/images/registration.jpg").getImage());
		panel.setBounds(0, 0, 2000, 1200);

		regF = new JFrame("[-PERSONAL TASK MANAGER-]");
		
		JLabel headL = new JLabel("REGISTER");
		JLabel userL = new JLabel("USER NAME");
		JLabel mailL = new JLabel("GMAIL ADDRESS");
		JLabel passL = new JLabel("PASSWORD");
		JLabel remiL = new JLabel("SET REMINDER TIME");
		JLabel hourL = new JLabel("HOURS : ");
		JLabel minL = new JLabel("MINUTES : ");
		JLabel meriL = new JLabel("MERIDIEM : ");
		
		hour = new JTextField(10);
		min = new JTextField(10);
		
		am = new JRadioButton("AM");
		pm = new JRadioButton("PM");

		am.addActionListener(this);
		pm.addActionListener(this);

		group = new ButtonGroup();

		group.add(am);
		group.add(pm);

		userR = new JTextField(30);
		mailR = new JTextField(30);
		passR = new JPasswordField(30);
		
		regB = new JButton("[-REGISTER-]");
		
		headL.setBounds(1200, 100, 400, 50);
		headL.setFont(font);
		
		userL.setBounds(1100, 250, 400, 30);
		userL.setFont(textF);
		
		userR.setBounds(1100, 285, 400, 30);
		userR.setFont(butF);
		
		mailL.setBounds(1100, 370, 400, 30);
		mailL.setFont(textF);
		
		mailR.setBounds(1100, 405, 400, 30);
		mailR.setFont(butF);
		
		passL.setBounds(1100, 490, 200, 30);
		passL.setFont(textF);
		
		passR.setBounds(1100, 525, 400, 30);
		passR.setFont(butF);
		
		remiL.setBounds(1100, 580, 400, 30);
		remiL.setFont(textF);
		
		hourL.setBounds(1120, 615, 80, 24);
		//hourL.setFont();
		
		hour.setBounds(1210, 615, 30, 20);
		hour.setFont(butF);
		
		minL.setBounds(1250, 615, 80, 24);
		//minL.setFont();
		
		min.setBounds(1340, 615, 30, 20);
		min.setFont(butF);
		
		meriL.setBounds(1120, 649, 80, 24);
		//meriL.setFont();
		
		am.setBounds(1220, 649, 70, 24);
		am.setBackground(Color.cyan);
		
		pm.setBounds(1310, 649, 70, 24);
		pm.setBackground(Color.cyan);		
		
		regB.setBounds(1200, 710, 160, 30);
		regB.setFont(butF);

		regF.getContentPane().add(panel);
		//regF.pack();

		panel.add(headL);
		panel.add(userL);
		panel.add(userR);
		panel.add(mailL);
		panel.add(mailR);
		panel.add(passL);
		panel.add(passR);
		panel.add(remiL);
		panel.add(hourL);
		panel.add(hour);
		panel.add(minL);
		panel.add(min);
		panel.add(meriL);
		panel.add(am);
		panel.add(pm);
		panel.add(regB);
				
		userR.addActionListener(this);
		mailR.addActionListener(this);
		passR.addActionListener(this);		
		regB.addActionListener(this);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		regF.pack();
		
		regF.setLayout(null);
		regF.setVisible(true);
		regF.setLocationRelativeTo(null);
		regF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regF.setSize(screenSize.width-50,screenSize.height-50);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		//login button
		String passL;
		String sql2;
		String message;
		int messageType = -1;
		
		//regB button
		String sql1;
		String gmail;
		String userName;
		String password;
		int rowsInserted = 0;
		
		//database connection requirement 		
		ResultSet result;
		Connection conn = null;
		Statement insertStatement;
		PreparedStatement statement;		
		
		String user = "postgres";
		String pass = "Pratham@2002";		
		String dbURL = "jdbc:postgresql://localhost:5432/postgres";

		if(event.getSource() == am)
			Registration.meridiem = "AM";
		else if(event.getSource() == pm)
			Registration.meridiem = "PM";

		try
		{	
			//connection
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(dbURL, user, pass);
			
			if(register == event.getSource())
			{
				frame.setVisible(false);						
				myRegistration();
			}
				
			if(login == event.getSource())
			{
				userL = userT.getText();
				char passw[] = passT.getPassword();
				
				sql2 = "select Password from Users where UserName = ?";
				
				statement = conn.prepareStatement(sql2);
				
				statement.setString(1, userL);
				
				result = statement.executeQuery();
				
				if(result.next())
				{
					String data = result.getString(1);
					char original[] = data.toCharArray();
					if(Arrays.equals(original, passw))
					{
						message = "[-LOGIN SUCCESSFUL-]";
						messageType = JOptionPane.INFORMATION_MESSAGE;
						
						JOptionPane.showMessageDialog(frame, message, "[-PERSONAL TASK MANAGER (login)-]", messageType);
						
						frame.setVisible(false);
						home = new Home();
						Arrays.fill(original, '0');
						Arrays.fill(passw, '0');						
					}
					else
					{
							message = "[-INVALID LOGIN CREDINTIALS (please try again)-]";
							messageType = JOptionPane.ERROR_MESSAGE;
							
							JOptionPane.showMessageDialog(frame, message, "[-PERSONAL TASK MANAGER (login)-]", messageType);				
					}				
					
				}
				else
				{
						message = "[-INVALID LOGIN CREDINTIALS (please try again)-]";
						messageType = JOptionPane.ERROR_MESSAGE;
						
						JOptionPane.showMessageDialog(frame, message, "[-PERSONAL TASK MANAGER (login)-]", messageType);				
				}				
			}
			
			if(event.getSource() == regB)
			{
				int iMin;
				int iHour;
				String time;
				int count = 0;
				boolean flag = false;
				StringBuilder str;
				
				userName = userR.getText();
				gmail = mailR.getText();
				char passW[] = passR.getPassword();
				iHour = Integer.parseInt(hour.getText());
				iMin = Integer.parseInt(min.getText());
				
				flag = ValidCredintials(userName, gmail, passW, iHour, iMin, Registration.meridiem);
				
				if(flag)
				{
					/*try
					{
						SendMail mailer = new SendMail();
						flag = mailer.generateMail(userName, gmail, true);						
					}
					catch(Exception exception)
					{							
						messageType = JOptionPane.ERROR_MESSAGE;
						JOptionPane.showMessageDialog(regF, "CHECK YOUR INTERNET CONNECTIVE", "[-PERSONAL TASK MANAGER (registration)-]", messageType);							
						return;
					}*/
					
					time = iHour + "-" + iMin + "-" + Registration.meridiem;
					
					try
					{
						RegisterMail thread = new RegisterMail(userName, gmail);
						thread.start();
					}
					catch(Exception e)
					{}
					
					//insert into user table..
					sql1 = "INSERT INTO Users (UserName, Password, Gmail, reminder) VALUES (?, ?, ?, ?)";
					
					statement = conn.prepareStatement(sql1);
					
					statement.setString(1, userName);
					statement.setString(2, String.valueOf(passW));
					statement.setString(3, gmail);
					statement.setString(4, time);
					
					rowsInserted = statement.executeUpdate();
					
					/*SendMail mailer = new SendMail();
					flag = mailer.generateMail(userName, gmail);*/
					
					str = new StringBuilder();
					
					if(true)
					{	
						str.replace(0, str.length(), "[-REGISTRATION SUCCESSFUL-]");
						messageType = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog(frame, str.toString(), "[-PERSONAL TASK MANAGER (registration)-]", messageType);
						//registration done..
						regF.setVisible(false);
						frame.setVisible(true);						
					}
					else
					{
						str.replace(0, str.length(), "[-REGISTRATION FAILED-]");
						messageType = JOptionPane.ERROR_MESSAGE;
						JOptionPane.showMessageDialog(frame, str.toString(), "[-PERSONAL TASK MANAGER (registration)-]", messageType);				
					}
				}
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	        finally 
	        {
            		try 
            		{
                		if (conn != null && !conn.isClosed()) 
                    			conn.close();
		        } 
		        catch (SQLException exception) 
		        {
         		       exception.printStackTrace();
            		}
        	}            		
		
	}
	
	String getUserName()
	{
		return Registration.userL;
	}
	
	boolean ValidCredintials(String userName, String mail, char array[], int hour, int min, String meridiem)
	{
		int messageType = -1;
		boolean name = false;
		
		char arrName[] = userName.toCharArray();
		
		for(char ch : arrName)
		{
			if((65 <= ch && ch <= 90) || (97 <= ch && ch <= 122) || (48 <= ch && ch <= 57))
				name = true;
		}
		
		if(name)
		{
		    	String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
			
			boolean result = mail.matches(regex);
			
			if(result)
			{
				boolean upper = false;
				boolean smaller = false;
				boolean digit = false;
				
				if(8 > array.length)
				{
					messageType = JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog(regF, "PASSWORD MUST CONTAIN AT LEAST 8 CHARACTERS", "[-PERSONAL TASK MANAGER (registration)-]", messageType);
					return false;						
				}
				
				for(char ch : array)
				{
					if(65 <= ch && ch <= 90)
						upper = true;
					else if(97 <= ch && ch <= 122)
						smaller = true;
					else if(48 <= ch && ch <= 57)
						digit = true;
				}
				
				if(upper)
				{
					if(smaller)
					{
						if(digit)
						{
							if(hour < 1 || hour > 12 || min < 0 || min > 59)
							{
								messageType = JOptionPane.ERROR_MESSAGE;
								JOptionPane.showMessageDialog(regF, "[-PLEASE ENTER VALID TIME-]", "[-INVALID TIME-]", messageType);
								return false;				
							}

							if(((hour >= 1) && (hour < 12)) && ("PM" == Registration.meridiem))
							{
								hour = hour + 12;
								return true;
							}
							
							return true;
						}
						else
						{
							messageType = JOptionPane.ERROR_MESSAGE;
							JOptionPane.showMessageDialog(regF, "PASSWORD MUST CONTAIN ONE DIGIT", "[-PERSONAL TASK MANAGER (registration)-]", messageType);
							return false;														
						}
					}
					else
					{
						messageType = JOptionPane.ERROR_MESSAGE;
						JOptionPane.showMessageDialog(regF, "PASSWORD MUST CONTAIN ONE SMALLCASE LETTER", "[-PERSONAL TASK MANAGER (registration)-]", messageType);
						return false;								
					}				
				}
				else
				{
					messageType = JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog(regF, "PASSWORD MUST CONTAIN ONE UPPERCASE LETTER", "[-PERSONAL TASK MANAGER (registration)-]", messageType);
					return false;							
				}
			}
			else
			{
				messageType = JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog(regF, "ENTER VALID MAIL ADDRESS", "[-PERSONAL TASK MANAGER (registration)-]", messageType);
				return false;			
			}		
		}
		else
		{
			messageType = JOptionPane.ERROR_MESSAGE;
			JOptionPane.showMessageDialog(regF, "ENTER VALID USERNAME", "[-PERSONAL TASK MANAGER (registration)-]", messageType);
			return false;		
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Registration obj = new Registration();
		 UIManager um=new UIManager();
		 um.put("OptionPane.messageForeground",Color.WHITE);
		 um.put("OptionPane.buttonBackground",Color.CYAN);		 
		 um.put("OptionPane.background",Color.DARK_GRAY);
		 um.put("Panel.background",Color.DARK_GRAY);		
	}
}

class Home implements ActionListener
{
	JFrame frame;
	Container cont;
	
	Font textF;
	Font textF1;

	JLabel title;
	JLabel title1;
	JLabel title2;
	JLabel title3;
	JLabel title4;
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	
	//panel1
	JLabel total;
	JLabel compL;
	JLabel pendL;
	JLabel overd;
	
	static JLabel totalT;
	static JLabel compT;
	static JLabel pendT;
	static JLabel overdT;

	//panel2
	static JLabel taskJ;
	static JLabel dueJ;
	static JLabel statusL;
	static JLabel task1;
	static JLabel task2;
	static JLabel due1;
	static JLabel due2;
	static JLabel status1;
	static JLabel status2;
	
	//panel3
	JLabel remind;
	static JLabel remind1;
	static JLabel remind2;
	
	//panel4
	JButton newTB;
	JButton allT;
			
	//menu bar
	JMenuBar bar;
	
	//menus
	JMenu file;
	JMenu task;
	JMenu help;
	JMenu settings;
	JMenu tools;
	JMenuItem newT;
	JMenuItem openTL;
	JMenuItem saveTL;
	JMenuItem exit;
	JMenuItem viewT;
	JMenuItem viewCT;
	JMenuItem viewPT;
	JMenuItem addT;
	JMenuItem editT;
	JMenuItem userM;
	JMenuItem aboutTM;
	JMenuItem changeTh;
	JMenuItem setRT;
	JMenuItem configDb;
	JMenuItem backupTL;
	JMenuItem restoreTL;
	JMenuItem importCSV;
	
	//new task
	JTextField titleT;
	JTextArea descripT;
	JDatePickerImpl datePicker;
	JRadioButton comp;
	JRadioButton pend;
	JButton save;
	
	JFileChooser fileCh;
	
	//for new tasks status..
	static String status = "Pending";
	
	//DATABASE OBJECT
	Database dObj = new Database();
	
	//to receive userName from another class to multiple methods...	[selected from 963]
	Registration rObj = new Registration(1);
	
	//panel1 static fields.. to display...
	static int taskNo;
	static int compNo;
	static int pendNo;
	static int dueNo;
	
	//openFile
	JButton saveDB;
	LinkedList<Record> rList;
	
	//NEW TASK
	JFrame frameNT;
	
	JLabel warning1;
	JLabel warning2;
	JLabel warning3;
	
	Home()
	{
		frame = new JFrame("[-PERSONAL TASK MANAGER-]");
		
		cont = frame.getContentPane();
		
		bar = new JMenuBar();
		bar.setBackground(Color.BLACK);
		
		Font barF = new Font("Verdana", Font.BOLD, 16);

		file = new JMenu("FILE");
		newT = new JMenuItem("NEW TASK");
		openTL = new JMenuItem("OPEN TASK LIST");
		saveTL = new JMenuItem("SAVE TASK LIST");
		exit = new JMenuItem("EXIT");
		
		file.setFont(barF);
		file.setBackground(Color.BLACK);
		file.setForeground(Color.WHITE);

		newT.setFont(barF);
		newT.setBackground(Color.BLACK);
		newT.setForeground(Color.WHITE);

		openTL.setFont(barF);
		openTL.setBackground(Color.BLACK);
		openTL.setForeground(Color.WHITE);
		
		saveTL.setFont(barF);
		saveTL.setBackground(Color.BLACK);
		saveTL.setForeground(Color.WHITE);
		
		exit.setFont(barF);
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		
		task = new JMenu("TASK");
		viewT = new JMenuItem("VIEW TASK");
		viewCT = new JMenuItem("VIEW COMPLETED TASK");
		viewPT = new JMenuItem("VIEW PENDING TASK");
		addT = new JMenuItem("ADD NEW TASK");
		editT = new JMenuItem("EDIT TASK");

		task.setFont(barF);
		task.setBackground(Color.BLACK);
		task.setForeground(Color.WHITE);
		
		viewT.setFont(barF);
		viewT.setBackground(Color.BLACK);
		viewT.setForeground(Color.WHITE);

		viewCT.setFont(barF);
		viewCT.setBackground(Color.BLACK);
		viewCT.setForeground(Color.WHITE);

		viewPT.setFont(barF);
		viewPT.setBackground(Color.BLACK);
		viewPT.setForeground(Color.WHITE);

		addT.setFont(barF);
		addT.setBackground(Color.BLACK);
		addT.setForeground(Color.WHITE);

		editT.setFont(barF);
		editT.setBackground(Color.BLACK);
		editT.setForeground(Color.WHITE);
		
		help = new JMenu("HELP");
		userM = new JMenuItem("USER MANUAL");
		aboutTM = new JMenuItem("ABOUT TASK MANAGER");
		
		help.setFont(barF);
		help.setBackground(Color.BLACK);
		help.setForeground(Color.WHITE);

		userM.setFont(barF);
		userM.setBackground(Color.BLACK);
		userM.setForeground(Color.WHITE);

		aboutTM.setFont(barF);
		aboutTM.setBackground(Color.BLACK);
		aboutTM.setForeground(Color.WHITE);
		
		settings = new JMenu("SETTINGS");
		changeTh = new JMenuItem("CHANGE THEME");
		setRT = new JMenuItem("SET REMAINDER TIME");
		configDb = new JMenuItem("CONFIGURE DATABASE");

		settings.setFont(barF);
		settings.setBackground(Color.BLACK);
		settings.setForeground(Color.WHITE);

		changeTh.setFont(barF);
		changeTh.setBackground(Color.BLACK);
		changeTh.setForeground(Color.WHITE);

		setRT.setFont(barF);
		setRT.setBackground(Color.BLACK);
		setRT.setForeground(Color.WHITE);

		configDb.setFont(barF);
		configDb.setBackground(Color.BLACK);
		configDb.setForeground(Color.WHITE);
		
		tools = new JMenu("TOOLS");
		backupTL = new JMenuItem("BACKUP TASK LIST");
		restoreTL = new JMenuItem("RESTORE TASK LIST");
		importCSV = new JMenuItem("IMPORT TASK FROM CSV");

		tools.setFont(barF);
		tools.setBackground(Color.BLACK);
		tools.setForeground(Color.WHITE);
		
		backupTL.setFont(barF);
		backupTL.setBackground(Color.BLACK);
		backupTL.setForeground(Color.WHITE);

		restoreTL.setFont(barF);
		restoreTL.setBackground(Color.BLACK);
		restoreTL.setForeground(Color.WHITE);

		importCSV.setFont(barF);
		importCSV.setBackground(Color.BLACK);
		importCSV.setForeground(Color.WHITE);
		
		//file menu
		newT.addActionListener(this);
		openTL.addActionListener(this);
		saveTL.addActionListener(this);
		exit.addActionListener(this);
		
		frame.setJMenuBar(bar);
		
		bar.add(file);
		file.add(newT);
		file.add(openTL);
		file.add(saveTL);
		file.add(exit);
		
		//task menu
		task.addActionListener(this);
		viewT.addActionListener(this);
		viewCT.addActionListener(this);
		viewPT.addActionListener(this);
		addT.addActionListener(this);
		editT.addActionListener(this);
		
		bar.add(task);
		task.add(viewT);
		task.add(viewCT);
		task.add(viewPT);
		task.add(addT);
		task.add(editT);
		
		bar.add(help);
		help.add(userM);
		help.add(aboutTM);
		
		setRT.addActionListener(this);
		
		bar.add(settings);
		//settings.add(changeTh);
		settings.add(setRT);
		//settings.add(configDb);
		
		backupTL.addActionListener(this);
		restoreTL.addActionListener(this);
		importCSV.addActionListener(this);
		
		bar.add(tools);
		tools.add(backupTL);
		tools.add(restoreTL);
		tools.add(importCSV);
		
		Body();
		//test
		setRecentTasks();

		setTaskSum();
							
		frame.setLayout(null);
		frame.setVisible(true);
		//frame.setSize(1100, 920);				//680 * 500
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.pack();
		frame.setSize(screenSize.width-45,screenSize.height-45);

		//trial going
		setNotify();
		
		SendReminder sObj = new SendReminder();
		sObj.generateReminder();
	}
	
	Home(int param)
	{
	
	}
	
	void Body()
	{
		ImagePanel panel = new ImagePanel( new ImageIcon("/home/prathamesh/Documents/JAVA/PERSONAL_TASK_TRACKER/TASK_TRACKER/images/dashboard.jpg").getImage());
		panel.setBounds(0, 0, 2000, 1200);
	
		Font bodyF = new Font("Verdana", Font.BOLD, 40);
		Font bodyF1 = new Font("Verdana", Font.BOLD, 30);
		
		//used in 'newTask()'
		textF = new Font("Arial", Font.BOLD, 25);
		textF1 = new Font("Arial", Font.BOLD, 17);
	
		title = new JLabel("PERSONAL TASK MANAGER");
		
		title1 = new JLabel("[TASK SUMMARY]");
		title2 = new JLabel("[RECENT TASKS]");
		title3 = new JLabel("[NOTIFICATION]");
		title4 = new JLabel("[QUICK ACTIONS]");
		
		title.setBounds(600, 15, 650, 40);
		title.setFont(bodyF);
		title.setForeground(Color.BLACK);
		
		title1.setBounds(300, 115, 300, 30);
		title1.setFont(bodyF1);
		title1.setForeground(Color.BLACK);

		title2.setBounds(1210, 95, 300, 30);
		title2.setFont(bodyF1);		
		title2.setForeground(Color.BLACK);		
		
		title3.setBounds(1210, 350, 300, 30);
		title3.setFont(bodyF1);
		title3.setForeground(Color.BLACK);
		
		title4.setBounds(750, 650, 300, 30);
		title4.setFont(bodyF1);
		title4.setForeground(Color.BLACK);
		
		//panel1
		panel1 = new JPanel();

		panel1.setBounds(230, 170, 450, 430);
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
				
		total = new JLabel("TOTAL TASKS : ");
		compL = new JLabel("COMPLETED TASKS : ");
		pendL = new JLabel("PENDING TASKS : ");
		overd = new JLabel("OVERDUE TASKS : ");

		totalT = new JLabel("0");
		compT = new JLabel("0");
		pendT = new JLabel("0");
		overdT = new JLabel("0");
		
		total.setBounds(35, 55, 300, 30);
		total.setFont(textF);
		total.setForeground(Color.WHITE);
		totalT.setBounds(365, 55, 35, 30);
		//totalT.setEditable(false);
		totalT.setFont(textF);
		totalT.setForeground(Color.WHITE);

		compL.setBounds(35, 135, 300, 30);
		compL.setFont(textF);
		compL.setForeground(Color.WHITE);
		compT.setBounds(365, 135, 35, 30);
		//compT.setEditable(false);
		compT.setFont(textF);
		compT.setForeground(Color.WHITE);

		pendL.setBounds(35, 215, 300, 30);
		pendL.setFont(textF);
		pendL.setForeground(Color.WHITE);
		pendT.setBounds(365, 215, 35, 30);
		//pendT.setEditable(false);
		pendT.setFont(textF);
		pendT.setForeground(Color.WHITE);

		overd.setBounds(35, 295, 300, 30);
		overd.setFont(textF);
		overd.setForeground(Color.WHITE);
		overdT.setBounds(365, 295, 35, 30);
		//overdT.setEditable(false);
		overdT.setFont(textF);
		overdT.setForeground(Color.WHITE);
				
		panel1.add(total);
		panel1.add(totalT);
		panel1.add(compL);
		panel1.add(compT);
		panel1.add(pendL);
		panel1.add(pendT);
		panel1.add(overd);
		panel1.add(overdT);

		panel1.setLayout(null);
		panel1.setSize(440, 385);	//425
		panel1.setVisible(true);
		panel1.setBackground(Color.DARK_GRAY);
		//panel 2
		panel2 = new JPanel();

		panel2.setBounds(1070, 150, 1650, 450);
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));

		Home.taskJ = new JLabel("TASK TITLE");
		Home.dueJ = new JLabel("DUE DATE");
		Home.statusL = new JLabel("STATUS");
		Home.task1 = new JLabel("NO TASK NOW");
		Home.task2 = new JLabel("NO TASK NOW");
		Home.due1 = new JLabel("2024-12-9");
		Home.due2 = new JLabel("2024-12-9");
		Home.status1 = new JLabel("NO TASK");
		Home.status2 = new JLabel("NO TASK");

		Home.taskJ.setBounds(47, 25, 100, 30);
		Home.taskJ.setFont(textF1);
		Home.taskJ.setForeground(Color.WHITE);
	
		Home.dueJ.setBounds(247, 25, 100, 30);
		Home.dueJ.setFont(textF1);
		Home.dueJ.setForeground(Color.WHITE);
		
		Home.statusL.setBounds(447, 25, 100, 30);
		Home.statusL.setFont(textF1);
		Home.statusL.setForeground(Color.WHITE);
		
		Home.task1.setBounds(15, 75, 200, 30);
		Home.task1.setFont(textF1);
		Home.task1.setForeground(Color.WHITE);
		
		Home.task2.setBounds(15, 125, 200, 30);
		Home.task2.setFont(textF1);
		Home.task2.setForeground(Color.WHITE);
		
		Home.due1.setBounds(247, 75, 100, 30);
		Home.due1.setFont(textF1);
		Home.due1.setForeground(Color.WHITE);
		
		Home.due2.setBounds(247, 125, 100, 30);
		Home.due2.setFont(textF1);
		Home.due2.setForeground(Color.WHITE);
		
		Home.status1.setBounds(440, 75, 120, 30);
		Home.status1.setFont(textF1);
		Home.status1.setForeground(Color.WHITE);
		
		Home.status2.setBounds(440, 125, 120, 30);
		Home.status2.setFont(textF1);
		Home.status2.setForeground(Color.WHITE);
		
		panel2.add(Home.taskJ);
		panel2.add(Home.dueJ);
		panel2.add(Home.statusL);
		panel2.add(Home.task1);
		panel2.add(Home.task2);
		panel2.add(Home.due1);
		panel2.add(Home.due2);
		panel2.add(Home.status1);
		panel2.add(Home.status2);
		
		panel2.setLayout(null);
		panel2.setSize(555, 175);
		panel2.setVisible(true);
		panel2.setBackground(Color.DARK_GRAY);
		
		//panel3
		panel3 = new JPanel();
		
		panel3.setBounds(1070, 400, 1650, 450);
		panel3.setBorder(BorderFactory.createLineBorder(Color.black));
		
		remind = new JLabel("TASK REMINDERS : ");
		remind1 = new JLabel("--> NO TASK DEADLINES YET !!");
		remind2 = new JLabel("--> NO TASK DEADLINES YET !!");

		remind.setBounds(20, 30, 300, 30);
		remind.setFont(textF1);		
		remind.setForeground(Color.WHITE);		
		
		remind1.setBounds(25, 80, 540, 30);
		remind1.setFont(textF1);		
		remind1.setForeground(Color.WHITE);		

		remind2.setBounds(25, 120, 540, 30);
		remind2.setFont(textF1);				
		remind2.setForeground(Color.WHITE);				
		
		panel3.add(remind);
		panel3.add(remind1);
		panel3.add(remind2);
										
		panel3.setLayout(null);
		panel3.setSize(555, 175);
		panel3.setVisible(true);
		panel3.setBackground(Color.DARK_GRAY);
		
		//panel4
		panel4 = new JPanel();

		panel4.setBounds(620, 700, 550, 100);
		panel4.setBorder(BorderFactory.createLineBorder(Color.black));
		
		newTB = new JButton("[ADD NEW TASK]");
		allT = new JButton("[VIEW ALL TASK]");
		
		newTB.setBounds(60, 25, 190, 50);
		newTB.setFont(textF1);
		newTB.setBackground(Color.cyan);
		newTB.setForeground(Color.BLACK);
		
		allT.setBounds(300, 25, 190, 50);
		allT.setFont(textF1);
		allT.setBackground(Color.cyan);
		allT.setForeground(Color.BLACK);
		
		newTB.addActionListener(this);
		allT.addActionListener(this);
		
		panel4.add(newTB);
		panel4.add(allT);
			
		panel4.setLayout(null);
		panel4.setSize(550, 100);
		panel4.setVisible(true);
		panel4.setBackground(Color.DARK_GRAY);
		//container adding				
		panel.add(title);
		panel.add(title1);
		panel.add(title2);
		panel.add(title3);
		panel.add(title4);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		
		cont.add(panel);
	}

	void newTask()
	{
		ImagePanel panelI1 = new ImagePanel( new ImageIcon("/home/prathamesh/Documents/JAVA/PERSONAL_TASK_TRACKER/TASK_TRACKER/images/addTask.jpg").getImage());
		panelI1.setBounds(0, 0, 850, 1000);
		//panelI1.setBorder(BorderFactory.createLineBorder(Color.black));

		ImagePanel panelI2 = new ImagePanel( new ImageIcon("/home/prathamesh/Documents/JAVA/PERSONAL_TASK_TRACKER/TASK_TRACKER/images/TaskPanel.jpg").getImage());
		panelI2.setBounds(1100, 0, 550, 1000);
		//panelI2.setBorder(BorderFactory.createLineBorder(Color.black));

		frameNT = new JFrame("[PERSONAL TASK MANAGER]");
				
		Container cont = frameNT.getContentPane();

		Font textAdd1 = new Font("Arial", Font.BOLD, 24);
		Font textAdd2 = new Font("Arial", Font.BOLD, 17);
		Font textAdd3 = new Font("Verdana", Font.BOLD, 18);
		Font war = new Font("Arial", Font.BOLD, 10);

		JLabel title = new JLabel("1) TITLE : ");
		JLabel descrip = new JLabel("2) DESCRIPTION : ");
		JLabel date = new JLabel("3) DUE DATE : ");
		JLabel status = new JLabel("4) STATUS : ");
		
		warning1 = new JLabel();
		warning2 = new JLabel();
		warning3 = new JLabel();
		
		titleT = new JTextField(40);
		descripT = new JTextArea(3, 40);
		
		//datepicker
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		
		comp = new JRadioButton("COMPLETED");
		pend = new JRadioButton("PENDING");
		
		ButtonGroup group = new ButtonGroup();
		
		save = new JButton("[SAVE]");
		
		group.add(comp);
		group.add(pend);
		
		title.setBounds(1100, 210, 200, 30);
		title.setFont(textAdd1);
		
		descrip.setBounds(1100, 310, 250, 30);
		descrip.setFont(textAdd1);

		date.setBounds(1100, 460, 200, 30);
		date.setFont(textAdd1);
		
		status.setBounds(1100, 570, 200, 30);
		status.setFont(textAdd1);
				
		titleT.setBounds(1350, 210, 200, 30);
		titleT.setFont(textAdd3);
		warning1.setBounds(1350, 241, 300, 15);
		warning1.setFont(war);
		warning1.setForeground(Color.RED);
		
		descripT.requestFocus();
		descripT.setBounds(1350, 310, 350, 70);
		descripT.setBorder(BorderFactory.createLineBorder(Color.black));
		descripT.setFont(textAdd3);
		warning2.setBounds(1350, 381, 300, 15);
		warning2.setFont(war);
		warning2.setForeground(Color.RED);
		
		datePicker.setBounds(1350, 460, 200, 30);
		warning3.setBounds(1350, 491, 300, 15);
		warning3.setFont(war);
		warning3.setForeground(Color.RED);
		
		comp.setBounds(1350, 570, 180, 20);
		comp.setFont(textAdd2);
		comp.setBackground(Color.white);
		
		pend.setBounds(1600, 570, 180, 20);
		pend.setFont(textAdd2);
		pend.setBackground(Color.white);
		
		save.setBounds(1290, 720, 200, 30);
		save.setFont(textAdd1);
		
		titleT.addActionListener(this);
		//descripT.addActionListener(this);
		datePicker.addActionListener(this);
		comp.addActionListener(this);
		pend.addActionListener(this);
		save.addActionListener(this);
		
		panelI2.add(title);
		panelI2.add(descrip);
		panelI2.add(date);
		panelI2.add(status);
		panelI2.add(titleT);
		panelI2.add(warning1);
		panelI2.add(descripT);
		panelI2.add(warning2);
		panelI2.add(datePicker);
		panelI2.add(warning3);
		panelI2.add(comp);
		panelI2.add(pend);
		panelI2.add(save);
		
		cont.add(panelI1);
		cont.add(panelI2);

		panelI1.setLayout(null);
		panelI1.setSize(850, 1000);
		panelI1.setVisible(true);
		
		panelI2.setLayout(null);
		panelI2.setSize(550, 1000);
		panelI2.setVisible(true);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameNT.pack();
		
		frameNT.setLayout(null);
		frameNT.setVisible(true);
		frameNT.setLocationRelativeTo(null);
		frameNT.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameNT.setSize(screenSize.width-35,screenSize.height-35);
	}
	
	void viewAll()
	{
		int userID = 0;
		java.sql.Date date;
		String status = null;
		String descrip = null;
		String userName = null;
		
		Connection conn = null;
		ResultSet result = null;
		
		Font textRows = new Font("Verdana", Font.BOLD, 18);
		Font textHeader = new Font("Verdana", Font.BOLD, 20);

		String colName[] = {"TASK NO","TITLE", "DESCRIPTION", "DUE DATE", "STATUS"};
			
		JFrame frame = new JFrame("[VIEW ALL TASKS]");
									
		DefaultTableModel model = new DefaultTableModel()
		{
		   @Override
		   public boolean isCellEditable(int row, int column) 
		   {
		       return false;
		   }
		};						

		model.setColumnIdentifiers(colName);
		
		try
		{
			conn = dObj.connectDB();

			userName = rObj.getUserName();
			
			userID = dObj.getUserID(userName, conn);
			
			result = dObj.getRecords(userID, conn);	
			
			while(result.next())
			{
				userID = result.getInt(1);
				userName = result.getString(2);				//userName used as to receive title..
				descrip = result.getString(3);
				date = result.getDate(4);
				status = result.getString(5);
				
				Object obj[] = {userID, userName, descrip, date, status};
				
				model.addRow(obj);
			}
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		finally
		{
			try
			{
				if(conn != null && !conn.isClosed())
					conn.close();
			}
			catch(SQLException exception)
			{
				exception.printStackTrace();
				System.out.println(exception);			
			}
			finally
			{}
		}
		
		JTable table = new JTable();

		//table sudha.. setBounds la response karat nahi...		
		table.setFont(textRows);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		table.setRowHeight(table.getRowHeight() + 20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.BLACK);
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(textHeader);
      		
		JScrollPane scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frame.add(scroll);

		//layput null set kelyane.. table visible hot nahiyee.... so mhnun te add ch kela nahi mhne default layout dilay vatat..		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.pack();
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(screenSize.width-35,screenSize.height-35);
	}
	
	void compTask()
	{
		int userID = 0;
		java.sql.Date date;
		String status = null;
		String descrip = null;
		String userName = null;
		
		Connection conn = null;
		ResultSet result = null;
		
		Font textRows = new Font("Verdana", Font.BOLD, 18);
		Font textHeader = new Font("Verdana", Font.BOLD, 20);

		String colName[] = {"TASK NO", "TITLE", "DESCRIPTION", "DUE DATE", "STATUS"};
			
		JFrame frame = new JFrame("[VIEW ALL TASKS]");
									
		DefaultTableModel model = new DefaultTableModel();
						
		model.setColumnIdentifiers(colName);
		
		try
		{
			conn = dObj.connectDB();

			userName = rObj.getUserName();
			
			userID = dObj.getUserID(userName, conn);
			
			result = dObj.getCompRecords(userID, conn);	
			
			while(result.next())
			{
				userID = result.getInt(1);
				userName = result.getString(2);				//userName used as to receive title..
				descrip = result.getString(3);
				date = result.getDate(4);
				status = result.getString(5);
				
				Object obj[] = {userID, userName, descrip, date, status};
				
				model.addRow(obj);
			}
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		finally
		{
			try
			{
				if(conn != null && !conn.isClosed())
					conn.close();
			}
			catch(SQLException exception)
			{
				exception.printStackTrace();
				System.out.println(exception);			
			}
			finally
			{}
		}
		
		JTable table = new JTable();

		//table sudha.. setBounds la response karat nahi...		
		table.setFont(textRows);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		table.setRowHeight(table.getRowHeight() + 20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.BLACK);
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(textHeader);
		
		JScrollPane scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frame.add(scroll);

		//layput null set kelyane.. table visible hot nahiyee.... so mhnun te add ch kela nahi mhne default layout dilay vatat..		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.pack();
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(screenSize.width-35,screenSize.height-35);
	}
	
	void pendTask()
	{
		int userID = 0;
		java.sql.Date date;
		String status = null;
		String descrip = null;
		String userName = null;
		
		Connection conn = null;
		ResultSet result = null;
		
		Font textRows = new Font("Verdana", Font.BOLD, 18);
		Font textHeader = new Font("Verdana", Font.BOLD, 20);

		String colName[] = {"TASK NO", "TITLE", "DESCRIPTION", "DUE DATE", "STATUS"};
			
		JFrame frame = new JFrame("[VIEW ALL TASKS]");
									
		DefaultTableModel model = new DefaultTableModel();
						
		model.setColumnIdentifiers(colName);
		
		try
		{
			conn = dObj.connectDB();

			userName = rObj.getUserName();
			
			userID = dObj.getUserID(userName, conn);
			
			result = dObj.getPendRecords(userID, conn);	
			
			while(result.next())
			{
				userID = result.getInt(1);
				userName = result.getString(2);				//userName used as to receive title..
				descrip = result.getString(3);
				date = result.getDate(4);
				status = result.getString(5);
				
				Object obj[] = {userID, userName, descrip, date, status};
				
				model.addRow(obj);
			}
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		finally
		{
			try
			{
				if(conn != null && !conn.isClosed())
					conn.close();
			}
			catch(SQLException exception)
			{
				exception.printStackTrace();
				System.out.println(exception);			
			}
			finally
			{}
		}
		
		JTable table = new JTable();

		//table sudha.. setBounds la response karat nahi...		
		table.setFont(textRows);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		table.setRowHeight(table.getRowHeight() + 20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.BLACK);
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(textHeader);
		
		JScrollPane scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frame.add(scroll);

		//layput null set kelyane.. table visible hot nahiyee.... so mhnun te add ch kela nahi mhne default layout dilay vatat..		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.pack();
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(screenSize.width-35,screenSize.height-35);
	}
	
	void saveToFile(ResultSet result, String fileName)
	{
		int taskID;
		String title;
		String status;
		String descrip;
		StringBuilder str;
		
		FileWriter file;
		
		java.sql.Date date;
		try
		{		
			str = new StringBuilder();

			file = new FileWriter(fileName);
			
			while(result.next())
			{
				taskID = result.getInt(1);
				title = result.getString(2);				//userName used as to receive title..
				descrip = result.getString(3);
				date = result.getDate(4);
				status = result.getString(5);
				
				str.replace(0, str.length(), title + "," + date.toString() + "," + status + "," + descrip + ",\n");
				file.write(str.toString());				
			}			
			file.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}
	
	void openFile(String fileName)
	{
		int ch;
		int i = 0;
		StringBuilder str1;
		StringBuilder str2;
		StringBuilder str3;
		StringBuilder str4;
		
		File file;
		FileReader fRead;
		
		JFrame frame;
		JTable table;
		JScrollPane scroll;
		DefaultTableModel model;
		
		rList = new LinkedList<Record>();
		
		Font textRows = new Font("Verdana", Font.BOLD, 18);
		Font textHeader = new Font("Verdana", Font.BOLD, 20);

		String colName[] = {"TITLE", "DESCRIPTION", "DUE DATE", "STATUS"};
			
		frame = new JFrame("[FILE TASKS]");
		frame.setLayout(new BorderLayout());
		
		saveDB = new JButton("[ADD TO TRACKER]");
		saveDB.setFont(textRows);
		saveDB.setBackground(Color.cyan);
		saveDB.setForeground(Color.BLACK);
		saveDB.addActionListener(this);
							
		model = new DefaultTableModel();
						
		model.setColumnIdentifiers(colName);
		
		str1 = new StringBuilder();
		str2 = new StringBuilder();
		str3 = new StringBuilder();
		str4 = new StringBuilder();
				
		try
		{
			file = new File(fileName);

			fRead = new FileReader(file);
			
			ch = fRead.read();
			while(ch != -1)
			{
				str1.delete(0, str1.length());
				while(ch != ',')
				{
					str1.append((char)ch);
				
					ch = fRead.read();
				}
				
				ch = fRead.read();
				
				str2.delete(0, str2.length());
				while(ch != ',')
				{
					str2.append((char)ch);
				
					ch = fRead.read();						
				}

				ch = fRead.read();

				str3.delete(0, str3.length());
				while(ch != ',')
				{
					str3.append((char)ch);
				
					ch = fRead.read();						
				}

				ch = fRead.read();

				str4.delete(0, str4.length());
				while(ch != ',')
				{
					str4.append((char)ch);
				
					ch = fRead.read();						
				}

				ch = fRead.read();
				
				//System.out.println("\tTitle : " + str1 + "\n\tDate : " + str2 + "\n\tStatus : " + str3 + "\n\tDescrption : " + str4 + "\n\n");				
				Record records = new Record(str1.toString(), str4.toString(), str2.toString(), str3.toString());
				rList.add(records);

				Object obj[] = {str1.toString(), str4.toString(), str2.toString(), str3.toString()};					
				model.addRow(obj);
				
				if(ch == '\n')
					ch = fRead.read();
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}

		table = new JTable();

		//table sudha.. setBounds la response karat nahi...		
		table.setFont(textRows);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		table.setRowHeight(table.getRowHeight() + 20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.BLACK);
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(textHeader);
		
		scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(saveDB, BorderLayout.SOUTH);

		//layput null set kelyane.. table visible hot nahiyee.... so mhnun te add ch kela nahi mhne default layout dilay vatat..		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.pack();
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(screenSize.width-35,screenSize.height-35);
	}
	
	void saveTaskList()
	{
		File obj;

		int userID = 0;
		String userName;
		StringBuilder str;
		int selection = 0;
		int messageType = -1;

		Connection conn = null;
		ResultSet result = null;

		str = new StringBuilder();

		selection = fileCh.showSaveDialog(frame);
		
		if(selection == JFileChooser.APPROVE_OPTION) 
		{
			obj = fileCh.getSelectedFile();	
			
			try
			{
				conn = dObj.connectDB();

				userName = rObj.getUserName();
				
				userID = dObj.getUserID(userName, conn);
				
				result = dObj.getRecords(userID, conn);	
				
				if(obj.createNewFile())
				{
					saveToFile(result, obj.getAbsolutePath());
										
					str.replace(0, str.length(), "[-FILE SAVE SUCCESSFULLY-]");
					messageType = JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog(frame, str, "[-SAVE FILE-]", messageType);
				}
				else
				{
					str.replace(0, str.length(), "[-UNABLE TO SAVE FILE-]");
					messageType = JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog(frame, str, "[-SAVE FILE-]", messageType);
				}					
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				System.out.println(exception);
			}
			finally
			{
				try
				{
					if(conn != null && !conn.isClosed())
						conn.close();
				}
				catch(SQLException exception)
				{
					exception.printStackTrace();
					System.out.println(exception);			
				}
				finally
				{}
			}				
		}	
	}
	
	void restoreTaskList()
	{
		File obj;
		int retVal = 0;
		
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
				   return filename.endsWith(".txt");
			       }
			   }
			}
		);		
		retVal = fileCh.showOpenDialog(frame);
		
		if(JFileChooser.APPROVE_OPTION == retVal)
		{
			obj = fileCh.getSelectedFile();
			
			openFile(obj.getAbsolutePath());
		}	
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == comp)
			Home.status = "Completed";
		else if(event.getSource() == pend)
			Home.status = "Pending";
		
		fileCh = new CustomFileChooser();
		fileCh.setPreferredSize(new Dimension(700, 650));	
		fileCh.setCurrentDirectory(new File(System.getProperty("user.home")));

		if(event.getSource() == newT || event.getSource() == newTB)
		{
			newTask();
		}
		else if(event.getSource() == openTL)
		{
			restoreTaskList();
		}
		else if(event.getSource() == saveDB)
		{
			int count = 0;
			int userID = 0;
			String message;
			String userName;
			int rowInserted = 0;
			int messageType = -1;
			
			Connection conn = null;
			
			Iterator move;
			Record records;
			java.sql.Date sqlDate;
			java.util.Date utilDate;
			SimpleDateFormat format;
			
			try
			{
				conn = dObj.connectDB();

				userName = rObj.getUserName();
				
				userID = dObj.getUserID(userName, conn);
				
				move = rList.iterator();
				
				while(move.hasNext())
				{
					records = (Record)move.next();
					
					format = new SimpleDateFormat("yyyy-mm-dd");
					utilDate = format.parse(records.date);
					sqlDate = new java.sql.Date(utilDate.getTime());

					rowInserted = dObj.insertRecord(records.title, records.descrip, sqlDate, records.status, userID, conn);
				}

				if(rowInserted > 0)
				{
					message = "[-TASK SAVED SUCCESSFULLY-]";
					messageType = JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog(frame, message, "[-SAVE TASK-]", messageType);
										
					//recent tasks restore..
					//Home obj = new Home(10);
					
					setRecentTasks();
					setTaskSum();
					setNotify();
					//frame.setVisible(false);					
				}
				else
				{
					message = "[-UNABLE TO SAVE TASK-]";
					messageType = JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog(frame, message, "[-SAVE TASK-]", messageType);			
					//frame.setVisible(false);					
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				System.out.println(exception);
			}
		}
		else if(event.getSource() == saveTL)
		{	
			int no;
			try
			{
				String userName = rObj.getUserName();
				
				Connection conn = dObj.connectDB();
					
				no = dObj.getUserID(userName, conn);
				
				ResultSet result = dObj.getTaskCount(no, conn);
				
				result.next();
				
				no = result.getInt(1);
				
				if(0 < no)
					saveTaskList();
				else
					JOptionPane.showMessageDialog(frame, "NO TASKS YET", "[-UNABLE TO SAVE TASKS-]", JOptionPane.ERROR_MESSAGE);							
			}
			catch(Exception e)
			{}
		}
		else if(event.getSource() == exit)
		{
			System.exit(1);
		}
		else if(event.getSource() == save)
		{
			String message;
			int messageType = -1;
		
			java.sql.Date sqlDate;
			java.util.Date utilDate;			
			String sql1;
			String title;
			String descrip;
			String userName;
			int userID = 0;
			ResultSet result;
			int rowInserted;
			Connection conn = null;
			PreparedStatement statement;
			
			title = titleT.getText();
			descrip = descripT.getText();
			utilDate = (java.util.Date) datePicker.getModel().getValue();
			
			if(0 == title.length())
			{
				warning1.setText("Please Enter Task Title");
				warning2.setText("");
				warning3.setText("");
				
			}
			else if(0 == descrip.length())
			{	warning2.setText("Please Enter Task Description");				
				warning1.setText("");
				warning3.setText("");
			
			}
			else if(null == utilDate)
			{	
				warning3.setText("Please Enter Due Date");			
				warning1.setText("");
				warning2.setText("");
			}
			else
			{
				warning1.setText("");
				warning2.setText("");
				warning3.setText("");
				sqlDate = new java.sql.Date(utilDate.getTime());
				
				try
				{
					String dbURL = "jdbc:postgresql://localhost:5432/postgres";
					String user = "postgres";
					String pass = "Pratham@2002";
					conn = DriverManager.getConnection(dbURL, user, pass);

					sql1 = "select UserID from Users where UserName = ?;";
					
					statement = conn.prepareStatement(sql1);
					
					userName = rObj.getUserName();
					
					statement.setString(1, userName);
					
					result = statement.executeQuery();			
					
					if(result.next())
					{
						userID = result.getInt(1);			//receives UserID
					}

					sql1 = "insert into Tasks (Title, Description, DueDate, Status, UserID) values (?, ?, ?, ?, ?);";
					

					statement = conn.prepareStatement(sql1);

					//increment run time counts of task summary...
					if("Completed" == Home.status)
					{
						compNo++;
						String numStr = Integer.toString(Home.compNo);					
						compT.setText(numStr);
					}
					else if("Pending" == Home.status)
					{
						pendNo++;				
						String numStr = Integer.toString(Home.pendNo);						
						pendT.setText(numStr);
					}
					
					statement.setString(1, title);
					statement.setString(2, descrip);
					statement.setDate(3, sqlDate);				
					statement.setString(4, Home.status);
					statement.setInt(5, userID);
					
					rowInserted = statement.executeUpdate();
					
					if(rowInserted > 0)
					{
						message = "[-TASK SAVE SUCCESSFULLY-]";
						messageType = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog(frame, message, "[-SAVE TASK-]", messageType);
						
						//increment run time total tasks...
						Home.taskNo++;
						String numStr = Integer.toString(Home.taskNo);	//userName variable used as to set the text...					
						totalT.setText(numStr);
						
						//recent tasks restore..
						setRecentTasks();
						frameNT.setVisible(false);
					}
					else
					{
						message = "[-UNABLE TO SAVE TASK-]";
						messageType = JOptionPane.ERROR_MESSAGE;
						JOptionPane.showMessageDialog(frame, message, "[-SAVE TASK-]", messageType);			
						frameNT.setVisible(false);
					}
				}
				catch(SQLException exception)
				{
					exception.printStackTrace();
					System.out.println(exception);
				}
				finally
				{
					try
					{
						if(conn != null && !conn.isClosed())
							conn.close();
					}
					catch(SQLException exception)
					{
						exception.printStackTrace();
						System.out.println(exception);				
					}
				}
			}
		}
		else if(event.getSource() == viewT || event.getSource() == allT)
		{
			int no;
			try
			{
				String userName = rObj.getUserName();
				
				Connection conn = dObj.connectDB();
					
				no = dObj.getUserID(userName, conn);
				
				ResultSet result = dObj.getTaskCount(no, conn);
				
				result.next();
				
				no = result.getInt(1);
				
				if(0 < no)
					viewAll();
				else
					JOptionPane.showMessageDialog(frame, "NO TASKS YET", "[-UNABLE TO VIEW TASKS-]", JOptionPane.ERROR_MESSAGE);							
			}
			catch(Exception e)
			{}
		}
		else if(event.getSource() == viewCT)
		{
			int no;
			try
			{
				String userName = rObj.getUserName();
				
				Connection conn = dObj.connectDB();
					
				no = dObj.getUserID(userName, conn);
				
				ResultSet result = dObj.getTaskCount(no, conn);
				
				result.next();
				
				no = result.getInt(1);
				
				if(0 < no)
					compTask();
				else
					JOptionPane.showMessageDialog(frame, "NO TASKS YET", "[-UNABLE TO VIEW COMPLETED TASKS-]", JOptionPane.ERROR_MESSAGE);							
			}
			catch(Exception e)
			{}
		}
		else if(event.getSource() == viewPT)
		{
			int no;
			try
			{
				String userName = rObj.getUserName();
				
				Connection conn = dObj.connectDB();
					
				no = dObj.getUserID(userName, conn);
				
				ResultSet result = dObj.getTaskCount(no, conn);
				
				result.next();
				
				no = result.getInt(1);
				
				if(0 < no)
					pendTask();
				else
					JOptionPane.showMessageDialog(frame, "NO TASKS YET", "[-UNABLE TO VIEW PENDING TASKS-]", JOptionPane.ERROR_MESSAGE);							
			}
			catch(Exception e)
			{}
		}
		else if(event.getSource() == addT)
		{
			newTask();
		}
		else if(event.getSource() == editT)
		{
			int no;
			try
			{
				String userName = rObj.getUserName();
				
				Connection conn = dObj.connectDB();
					
				no = dObj.getUserID(userName, conn);
				
				ResultSet result = dObj.getTaskCount(no, conn);
				
				result.next();
				
				no = result.getInt(1);
				
				if(0 < no)
				{
					EditTask eObj = new EditTask();			
					eObj.edit();
				}
				else
					JOptionPane.showMessageDialog(frame, "NO TASKS YET", "[-UNABLE TO EDIT TASKS-]", JOptionPane.ERROR_MESSAGE);							
			}
			catch(Exception e)
			{}
		}
		else if(event.getSource() == setRT)
		{
			TimeSet tObj = new TimeSet();
			
			tObj.setTime(frame);
		}
		else if(event.getSource() == backupTL)
		{
			int no;
			try
			{
				String userName = rObj.getUserName();
				
				Connection conn = dObj.connectDB();
					
				no = dObj.getUserID(userName, conn);
				
				ResultSet result = dObj.getTaskCount(no, conn);
				
				result.next();
				
				no = result.getInt(1);
				
				if(0 < no)
					saveTaskList();
				else
					JOptionPane.showMessageDialog(frame, "NO TASKS YET", "[-UNABLE TO BACKUP TASKS-]", JOptionPane.ERROR_MESSAGE);							
			}
			catch(Exception e)
			{}
		}
		else if(event.getSource() == restoreTL)
		{
			restoreTaskList();
		}
		else if(event.getSource() == importCSV)
		{
			File obj;
			int retVal = 0;
			fileCh.setFileFilter(new javax.swing.filechooser.FileFilter() 
				{

				   public String getDescription() 
				   {
				       return "CSV File (*.csv)";
				   }

				   public boolean accept(File f) 
				   {
				       if (f.isDirectory()) 
					   return true;
				       else 
				       {
					   String filename = f.getName().toLowerCase();
					   return filename.endsWith(".csv");
				       }
				   }
				}
			);			
			retVal = fileCh.showOpenDialog(frame);
			
			if(JFileChooser.APPROVE_OPTION == retVal)
			{
				obj = fileCh.getSelectedFile();
				
				CsvBeanReaderTask cObj = new CsvBeanReaderTask();
				cObj.readCSVFile(obj.getAbsolutePath());
			}		
		}
	}
	
	void setTaskSum()
	{
		int userID = 0;
		String userName;
		Connection conn = null;
		ResultSet result = null;
		
		try
		{
			//total tasks...
			userName = rObj.getUserName();
			
			conn = dObj.connectDB();
				
			userID = dObj.getUserID(userName, conn);
			
			result = dObj.getTaskCount(userID, conn);
			
			result.next();
			
			Home.taskNo = result.getInt(1);
			
			userName = Integer.toString(Home.taskNo);	//userName variable used as to set the text...
			
			Home.totalT.setText(userName);
			
			//completed tasks...
			result = dObj.getCompTaskCount(userID, conn);
			
			result.next();
			
			Home.compNo = result.getInt(1);
			
			userName = Integer.toString(Home.compNo);	//userName variable used as to set the text...
			
			Home.compT.setText(userName);
			
			//pending tasks...
			result = dObj.getPendTaskCount(userID, conn);
			
			result.next();
			
			Home.pendNo = result.getInt(1);
			
			userName = Integer.toString(Home.pendNo);	//userName variable used as to set the text...
			
			Home.pendT.setText(userName);
			
			//overdue tasks..		
			result = dObj.getDueTaskCount(userID, conn);
			
			result.next();
			
			Home.dueNo = result.getInt(1);
			
			userName = Integer.toString(Home.dueNo);	//userName variable used as to set the text...
			
			Home.overdT.setText(userName);
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}
	
	void setNotify()
	{
		//DATABASE DECLARATION
		int userID = 0;
		java.sql.Date date;
		String strDate = null;		
		Connection conn = null;
		ResultSet result = null;
		
		//LINKEDLIS DECLARATION
		int size;
		DueTask tObj;
		String taskString = null;
		LinkedList<DueTask> linkL = new LinkedList<DueTask>();
		
		try
		{
			String userName = rObj.getUserName();
			
			conn = dObj.connectDB();
			
			userID = dObj.getUserID(userName, conn);
			
			result = dObj.getDueTasks(userID, conn);
		
			while(result.next())
			{
				date = result.getDate(2);	
				strDate = date.toString();
				
				tObj = new DueTask(result.getString(1), strDate);				
				
				linkL.add(tObj);
			}
			
			if(linkL.size() > 0)
			{
				tObj = linkL.get(0);				
				taskString = "--><Task> : [" + tObj.title + "] <Last Date> : [" + tObj.date + "].";
				Home.remind1.setText(taskString);
				
				if(linkL.size() == 2)
				{
					tObj = linkL.get(1);
					taskString = "--><Task> : [" + tObj.title + "] <Last Date> : [" + tObj.date + "].";
					Home.remind2.setText(taskString);
				}
				else
					Home.remind2.setText("--> NO TASK DEADLINES YET !!");					
			}
			else
			{
				Home.remind1.setText("--> NO TASK DEADLINES YET !!");
				Home.remind2.setText("--> NO TASK DEADLINES YET !!");
			}
			
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
	}
	
	void setRecentTasks()
	{
		//DATABASE DECLARATION
		int userID = 0;
		String status;
		java.sql.Date date;
		String strDate = null;		
		Connection conn = null;
		ResultSet result = null;

		try
		{
			String userName = rObj.getUserName();
			
			conn = dObj.connectDB();
			
			userID = dObj.getUserID(userName, conn);
			
			result = dObj.getRecentTasks(userID, conn);

			result.last();
			if(0 < result.getRow())
			{
				if(2 >= result.getRow())
				{	
					result.first();
								
					//record 1
					//result.next();
					userName = result.getString(1);			//userName variable used as title
					date = result.getDate(2);
					strDate = date.toString();
					status = result.getString(3);
								
					Home.task1.setText(userName);
					Home.due1.setText(strDate);
					Home.status1.setText(status);
					
					result.last();
					if(2 == result.getRow())
					{
						//record 2
						//result.next();
						userName = result.getString(1);			//userName variable used as title
						date = result.getDate(2);
						strDate = date.toString();
						status = result.getString(3);
									
						Home.task2.setText(userName);
						Home.due2.setText(strDate);
						Home.status2.setText(status);					
					}
				}
			}
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}		
	}
}

class DueTask
{
	String title;
	String date;
	
	DueTask(String strTitle, String strDate)
	{
		title = strTitle;
		date = strDate;
	}
}

class EditTask implements ActionListener
{
	JFrame frame;

	Font textF1;

	static String status = "...";

	JTextField taskNoT;
	JTextField titleT;
	JTextField descripT;
	JRadioButton comp;
	JRadioButton pend;
	JButton save;
	JButton search;
	JButton delete;
	UtilDateModel model;
	JDatePickerImpl datePicker;

	Database dObj = new Database();
	Registration rObj = new Registration(1);
	
	JLabel warningE1;
	
	void edit()
	{
		ImagePanel panel = new ImagePanel( new ImageIcon("/home/prathamesh/Documents/JAVA/PERSONAL_TASK_TRACKER/TASK_TRACKER/images/edit.jpg").getImage());
		panel.setBounds(0, 0, 850, 1000);

		ImagePanel panelWhite = new ImagePanel( new ImageIcon("/home/prathamesh/Documents/JAVA/PERSONAL_TASK_TRACKER/TASK_TRACKER/images/TaskPanel.jpg").getImage());
		panelWhite.setBounds(1100, 0, 550, 1000);

		frame = new JFrame("[PERSONAL TASK MANAGER]");
		textF1 = new Font("Arial", Font.BOLD, 17);
		Font textContent = new Font("Verdana", Font.BOLD, 18); 
		Font warE = new Font("Arial", Font.BOLD, 15);
		
		Container cont = frame.getContentPane();
		
		JLabel title = new JLabel("1) TITLE : ");
		JLabel descrip = new JLabel("2) DESCRIPTION : ");
		JLabel date = new JLabel("3) DUE DATE : ");
		JLabel status = new JLabel("4) STATUS : ");
		JLabel taskNo = new JLabel("ENTER TASK NO. : ");
		
		warningE1 = new JLabel();
		
		taskNoT = new JTextField(10);
		titleT = new JTextField(40);
		descripT = new JTextField(100);			//********
		
		//datepicker
		model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		
		comp = new JRadioButton("COMPLETED");
		pend = new JRadioButton("PENDING");
		
		ButtonGroup group = new ButtonGroup();
		
		save = new JButton("[SAVE]");
		search = new JButton("[SEARCH]");
		delete = new JButton("[DELETE]");
		
		group.add(comp);
		group.add(pend);
		
		taskNo.setBounds(1135, 150, 200, 30);
		taskNo.setFont(textF1);
		
		title.setBounds(1100, 250, 200, 30);
		title.setFont(textF1);
		
		descrip.setBounds(1100, 330, 200, 30);
		descrip.setFont(textF1);

		date.setBounds(1100, 440, 200, 30);
		date.setFont(textF1);
		
		status.setBounds(1100, 550, 200, 30);
		status.setFont(textF1);
		
		taskNoT.setBounds(1335, 150, 50, 30);
		taskNoT.setFont(textContent);
		
		titleT.setBounds(1350, 250, 200, 30);
		titleT.setFont(textContent);
		
		descripT.requestFocus();
		descripT.setBounds(1350, 330, 350, 30);
		descripT.setFont(textContent);
		
		datePicker.setBounds(1350, 440, 200, 30);
		
		comp.setBounds(1350, 550, 150, 20);
		comp.setFont(textF1);
		comp.setBackground(Color.white);
		
		pend.setBounds(1550, 550, 150, 20);
		pend.setFont(textF1);
		pend.setBackground(Color.white);
		
		search.setBounds(1535, 150, 150, 30);
		search.setFont(textF1);
		
		warningE1.setBounds(1300, 605, 300, 10);
		warningE1.setFont(warE);
		warningE1.setForeground(Color.RED);
		
		save.setBounds(1250, 700, 150, 30);
		save.setFont(textF1);

		delete.setBounds(1500, 700, 150, 30);
		delete.setFont(textF1);
		
		titleT.addActionListener(this);
		//descripT.addActionListener(this);
		datePicker.addActionListener(this);
		comp.addActionListener(this);
		pend.addActionListener(this);
		search.addActionListener(this);
		save.addActionListener(this);
		delete.addActionListener(this);
		
		panelWhite.add(taskNo);
		panelWhite.add(taskNoT);
		panelWhite.add(search);
		panelWhite.add(title);
		panelWhite.add(descrip);
		panelWhite.add(date);
		panelWhite.add(status);
		panelWhite.add(titleT);
		panelWhite.add(descripT);
		panelWhite.add(datePicker);
		panelWhite.add(comp);
		panelWhite.add(pend);
		panelWhite.add(warningE1);
		panelWhite.add(save);
		panelWhite.add(delete);

		panel.setLayout(null);
		panel.setSize(850, 1000);
		panel.setVisible(true);

		panelWhite.setLayout(null);
		panelWhite.setSize(850, 1000);
		panelWhite.setVisible(true);

		cont.add(panel);
		cont.add(panelWhite);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.pack();
				
		frame.setLayout(null);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(screenSize.width-35,screenSize.height-35);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		int day;
		int month;
		int year;
		
		int number;
		int userID;
		String container;
		java.sql.Date dDate;
		LocalDate localDate;
		Connection conn = null;
		ResultSet result = null;

		boolean flag = false;
		
		if(comp.isSelected())
			EditTask.status = "Completed";
		else if(pend.isSelected())
			EditTask.status = "Pending";
		/*
		if(event.getSource() == comp || event.getSource() == pend)
			flag = true;
		*/
		if(event.getSource() == search)
		{
			try
			{
				number = Integer.parseInt(taskNoT.getText());
				
				if(number <= 100)
					warningE1.setText("PLEASE ENTER CORRECT DETAILS");
				else
				{
					try
					{
						warningE1.setText("");
						
						String userName = rObj.getUserName();
						
						conn = dObj.connectDB();
						
						userID = dObj.getUserID(userName, conn);
						
						result = dObj.getIDRecords(number, userID, conn);
						
						result.next();
						
						container = result.getString(1);
						titleT.setText(container);

						container = result.getString(2);
						descripT.setText(container);

						dDate = result.getDate(3);
						
						localDate = dDate.toLocalDate();
						day = localDate.getDayOfMonth();
						month = localDate.getMonthValue();
						year = localDate.getYear();
						
						model.setDate(year, month-1, day);		//because in Java, the month number is zero-based
						model.setSelected(true);
						
						container = result.getString(4);				
						if(container.equals("Completed"))
							comp.setSelected(true);
						else if(container.equals("Pending"))
							pend.setSelected(true);
					}
					catch(SQLException exception)
					{
						warningE1.setText("PLEASE ENTER CORRECT DETAILS");
						//exception.printStackTrace();
						//System.out.println(exception);
					}
				}
			}
			catch(Exception e)
			{
				warningE1.setText("PLEASE ENTER CORRECT DETAILS");			
			}
		}
		else if(event.getSource() == save)
		{
			int taskID;
			
			String message;
			int messageType = -1;
		
			java.sql.Date sqlDate;
			java.util.Date utilDate;			
			String sql1;
			String title;
			String descrip;
			String userName;
			//ResultSet result;
			int rowInserted;
			//Connection conn = null;
			PreparedStatement statement;
			
			title = titleT.getText();
			
			descrip = descripT.getText();
			
			utilDate = (java.util.Date) datePicker.getModel().getValue();
			
			if((0 == title.length()) || (0 == descrip.length()) || (null == utilDate))
				warningE1.setText("PLEASE SEARCH THE CORRECT TASK??");
			else
			{
				sqlDate = new java.sql.Date(utilDate.getTime());
				
				try
				{
					warningE1.setText("");
					
					conn = dObj.connectDB();

					userName = rObj.getUserName();
					
					userID = dObj.getUserID(userName, conn);

					taskID = dObj.getTaskID(title, userID, conn);
					
					rowInserted  = dObj.setRecords(title, descrip, sqlDate, EditTask.status, taskID, userID, conn);
													
					if(rowInserted > 0)
					{
						message = "[-TASK UPDATED SUCCESSFULLY-]";
						messageType = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog(frame, message, "[-UPDATE TASK-]", messageType);
											
						//recent tasks restore..
						Home obj = new Home(10);
						
						obj.setRecentTasks();
						obj.setTaskSum();
						obj.setNotify();
						frame.setVisible(false);					
					}
					else
					{
						message = "[-UNABLE TO SAVE TASK-]";
						messageType = JOptionPane.ERROR_MESSAGE;
						JOptionPane.showMessageDialog(frame, message, "[-SAVE TASK-]", messageType);			
						frame.setVisible(false);					
					}
					/*
					//increment run time counts of task summary...
					if(flag == true && rowInserted > 0 && "Completed" == EditTask.status)
					{
						Home.compNo++;
						String numStr = Integer.toString(Home.compNo);					
						Home.compT.setText(numStr);
					}
					else if(flag = true && rowInserted > 0 && "Pending" == EditTask.status)
					{
						Home.pendNo++;				
						String numStr = Integer.toString(Home.pendNo);						
						Home.pendT.setText(numStr);
					}
					*/
				}
				catch(SQLException exception)
				{
					warningE1.setText("UNABLE TO GO FURTHER PLEASE TRY AGAIN");
					titleT.setText("");
					descripT.setText("");
					taskNoT.setText("");
					//exception.printStackTrace();
					//System.out.println(exception);
				}
				finally
				{
					try
					{
						if(conn != null && !conn.isClosed())
							conn.close();
					}
					catch(SQLException exception)
					{
						exception.printStackTrace();
						System.out.println(exception);				
					}
				}
			}
		}
		else if(event.getSource() == delete)
		{
			int taskID = -1;
			String title;
			String message;
			String userName;
			int rowsDeleted = 0;
			int messageType = -1;
			
			title = titleT.getText();
			
			if(0 == title.length())
				warningE1.setText("UNABLE TO DELETE : PLEASE CHECK YOUR TASK SEARCH???");
			else
			{			
				try
				{
					warningE1.setText("");
					
					conn = dObj.connectDB();

					userName = rObj.getUserName();
					
					userID = dObj.getUserID(userName, conn);

					taskID = dObj.getTaskID(title, userID, conn);

					rowsDeleted = dObj.removeRecord(taskID, userID, conn);
					
					if(rowsDeleted > 0)
					{
						message = "[-TASK DELETED SUCCESSFULLY-]";
						messageType = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog(frame, message, "[-DELETE TASK-]", messageType);
											
						//recent tasks restore..
						Home obj = new Home(10);
						
						obj.setRecentTasks();
						obj.setTaskSum();
						obj.setNotify();
						frame.setVisible(false);									
					}
					else
					{
						message = "[-UNABLE TO DELETE TASK-]";
						messageType = JOptionPane.ERROR_MESSAGE;
						JOptionPane.showMessageDialog(frame, message, "[-DELETE TASK-]", messageType);			
						frame.setVisible(false);									
					}
				}
				catch(SQLException exception)
				{
					if(-1 == taskID)
						warningE1.setText("UNABLE TO DELETE : PLEASE CHECK YOUR TASK SEARCH???");
					else
					{
						warningE1.setText("UNABLE TO GO FURTHER PLEASE TRY AGAIN");
						titleT.setText("");
						descripT.setText("");
						taskNoT.setText("");					
					}
					//exception.printStackTrace();
					//System.out.println(exception);
				}
				finally
				{
					try
					{
						if(conn != null && !conn.isClosed())
							conn.close();
					}
					catch(SQLException exception)
					{
						exception.printStackTrace();
						System.out.println(exception);				
					}
				}
			}
		}
		
	}	
}

class RegisterMail extends Thread
{
	String userName;
	String gmail;
	
	RegisterMail(String userName, String gmail)
	{
		this.userName = userName;
		this.gmail = gmail;
	}
	
	public void run()
	{
		try
		{
			SendMail mailer = new SendMail();
			mailer.generateMail(userName, gmail, true);						
		}
		catch(Exception exception)
		{							
			//messageType = JOptionPane.ERROR_MESSAGE;
			//JOptionPane.showMessageDialog(regF, "CHECK YOUR INTERNET CONNECTIVE", "[-PERSONAL TASK MANAGER (registration)-]", messageType);							
			return;
		}		
	}
}

