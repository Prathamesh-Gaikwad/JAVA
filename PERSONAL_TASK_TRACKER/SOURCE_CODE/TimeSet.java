import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import database.Database;

public class TimeSet
{
	private ConnectDialog dialog = null;
	
	Database dObj = new Database();	
	Registration rObj = new Registration(1);

	public TimeSet()
	{

	}
	
	void setTime(JFrame frame)
	{
		ConnectInfo transfer = new ConnectInfo(9, 0);
		
		if(dialog == null)
			dialog = new ConnectDialog(frame);
		
		if(dialog.showDialog(transfer))
		{
			String meridiem;
			int hourStr = transfer.hours;
			int minStr = transfer.minutes;
			int messageType;
			String str;
			
			int userID;
			int rowInserted;
			Connection conn = null;
			
			if(transfer.meridiem)
				meridiem = "AM";
			else
				meridiem = "PM";

			if(hourStr < 1 || hourStr > 12)
			{
				messageType = JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog(frame, "[-PLEASE ENTER VALID TIME-]", "[-INVALID TIME-]", messageType);
				return;				
			}

			if(hourStr >= 1 && hourStr < 12 && !transfer.meridiem)
				hourStr = hourStr + 12;
			
			str = hourStr + "-" + minStr + "-" + meridiem;
				
			try
			{
				String userName = rObj.getUserName();
				
				conn = dObj.connectDB();

				if(Registration.choice1Str.toString().equals("Employee"))
				{
					userID = dObj.getUserID(userName, conn);
					rowInserted = dObj.setTaskReminderTime(str, userID, conn, false);
				}
				else
				{	
					userID = dObj.getUserID(userName, conn, true);				
					rowInserted = dObj.setTaskReminderTime(str, userID, conn, true);
				}				
				
				if(rowInserted > 0)
				{
					messageType = JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog(frame, "[-TIME SET SUCCESSFULLY-]", "[-SET REMINDER TIME-]", messageType);			
				}
				else
				{
					messageType = JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog(frame, "[-UNABLE TO SET TIME PLEASE TRY AGAIN-]", "[-SET REMINDER TIME-]", messageType);
				}
			}
			catch(Exception e)
			{}			
		}	
	}	
}

class ConnectInfo
{
	public int hours;
	public int minutes;
	public boolean meridiem;
	
	public ConnectInfo(int hours, int minutes)
	{
		this.hours = hours;
		this.minutes = minutes;
	}
}

class ConnectDialog extends JDialog implements ActionListener
{
	private JLabel Hours;
	private JLabel Min;
	private JLabel Meri;
	private JTextField hour;
	private JTextField min;
	private JRadioButton am;
	private JRadioButton pm;
	private ButtonGroup group;
	private JButton ok;
	private JButton cancel;
	boolean flag;
	static boolean flag1;

	public ConnectDialog(JFrame parent)
	{
		super(parent, "Connect", true);
		
		Font font = new Font("Verdana", Font.BOLD, 14);
		Font textF = new Font("Arial", Font.BOLD, 12);
		
		Container contentPane = getContentPane();
		
		JPanel p1 = new JPanel();

		Hours = new JLabel("HOURS : ");
		Min = new JLabel("MINUTES : ");
		Meri = new JLabel("MERIDIEM : ");

		Hours.setForeground(Color.WHITE);		
		Min.setForeground(Color.WHITE);		
		Meri.setForeground(Color.WHITE);		
		
		Hours.setBounds(10, 10, 90, 20);
		Min.setBounds(150, 10, 90, 20);
		Meri.setBounds(10, 40, 90, 20);
		
		hour = new JTextField(10);
		min = new JTextField(10);

		hour.setBounds(110, 10, 30, 20);
		hour.setFont(textF);
		min.setBounds(250, 10, 30, 20);
		min.setFont(textF);
		
		am = new JRadioButton("AM");
		pm = new JRadioButton("PM");
		
		am.setBounds(110, 40, 70, 20);
		am.setBackground(Color.DARK_GRAY);
		am.setForeground(Color.WHITE);
		pm.setBounds(185, 40, 70, 20);
		pm.setBackground(Color.DARK_GRAY);
		pm.setForeground(Color.WHITE);

		am.addActionListener(this);
		pm.addActionListener(this);
		
		group = new ButtonGroup();

		group.add(am);
		group.add(pm);

		ok = new JButton("OK");
		cancel = new JButton("CANCEL");

		ok.setFont(font);
		ok.setBackground(Color.GREEN);
		ok.setForeground(Color.BLACK);
		cancel.setFont(font);
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.BLACK);

		ok.setBounds(70, 85, 80, 20);
		cancel.setBounds(180, 85, 90, 20);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		p1.add(Hours);
		p1.add(Min);
		p1.add(Meri);
		p1.add(hour);
		p1.add(min);
		p1.add(am);
		p1.add(pm);
		p1.add(ok);
		p1.add(cancel);
		
		p1.setLayout(null);
		p1.setBackground(Color.DARK_GRAY);
		
		contentPane.add(p1);
		setSize(360, 170);
		setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		
		if(source == am)
			flag1 = true;
		else if(source == pm)
			flag1 = false;

		
		if(source == ok)
		{
			flag = true;
			setVisible(false);
		}
		else if(source == cancel)
			setVisible(false);
	}
	
	public boolean showDialog(ConnectInfo transfer)
	{
		hour.setText("9");
		min.setText("00");
		
		flag = false;
		show();
		
		if(flag)
		{
			transfer.hours = Integer.parseInt(hour.getText());
			transfer.minutes = Integer.parseInt(min.getText());
			transfer.meridiem = flag1;
		}
		
		return flag;
	}
}

