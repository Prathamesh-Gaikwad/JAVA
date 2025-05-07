import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeSet extends JFrame implements ActionListener
{
	private JMenuItem exitItem;
	private JMenuItem connectItem;
	private ConnectDialog dialog = null;
	private static boolean mailSent;
	
	public TimeSet()
	{
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		}
		);
		
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("FILE");
		connectItem = new JMenuItem("CONNECT");
		exitItem = new JMenuItem("EXIT");
		
		file.add(connectItem);
		file.add(exitItem);
		bar.add(file);
		setJMenuBar(bar);
		
		connectItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		setTitle("SET REMINDER");
		setSize(700, 700);
		setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent event)
	{		
		Object source = event.getSource();		
		
		if(source == connectItem)
		{
			ConnectInfo transfer = new ConnectInfo(9, 0);
			
			if(dialog == null)
				dialog = new ConnectDialog(this);
			
			if(dialog.showDialog(transfer))
			{
				String meridiem;
				int hourStr = transfer.hours;
				int minStr = transfer.minutes;
				
				if(transfer.meridiem)
					meridiem = "AM";
				else
					meridiem = "PM";
					
				if(hourStr >= 1 && hourStr <= 12 && transfer.meridiem)					
				{
					if(minStr > 0 && minStr < 60)
						System.out.println("IT's Morning Time [Hours : " + hourStr + " Minutes : " + minStr + " Meridiem : " + meridiem + "]");
				}
				else if(hourStr >= 1 && hourStr < 12 && !transfer.meridiem)
				{
					hourStr = hourStr + 12;
					
					if(minStr > 0 && minStr < 60)
						System.out.println("It's Evening Time [Hours : " + hourStr + " Minutes : " + minStr + " Meridiem : " + meridiem + "]");
				}
				else if(12 == hourStr &&  !transfer.meridiem)
				{
					if(minStr > 0 && minStr < 60)
						System.out.println("It's 12 Noon [Hours : " + hourStr + " Minutes : " + minStr + " Meridiem : " + meridiem + "]");
				
				}
				else
				{
					int messageType = JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog(this, "[-PLEASE ENTER VALID TIME-]", "[-INVALID TIME-]", messageType);				
				}
				
				long diffL = difference(hourStr, minStr);				
				System.out.println("MILISecond : " + diffL);
				
				if(mailSent)
				{
					Reminder thread = new Reminder(diffL);
					thread.start();
				}								
			}
		}
		else if(source == exitItem)
			System.exit(0);
	}
	
	static long difference(int hour, int min)
	{
		//long differenceL = 00l;
		long newDiff = 0l;
		
		Date targetDate = new Date();

		targetDate.setHours(hour);
		targetDate.setMinutes(min);

		Date currentDate = new Date();
		
		SimpleDateFormat formatS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//System.out.println(formatS.format(targetDate));
		//System.out.println(formatS.format(currentDate));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime targetL = LocalDateTime.parse(formatS.format(targetDate), formatter);
		LocalDateTime currentL = LocalDateTime.parse(formatS.format(currentDate), formatter);
		
		newDiff = java.time.Duration.between(currentL, targetL).toMillis();
		//System.out.println("New Difference : " + newDiff);
		
		/*Calendar currentTime = Calendar.getInstance();
		Calendar targetTime = Calendar.getInstance();
		
		targetTime.set(Calendar.HOUR_OF_DAY, hour);
		targetTime.set(Calendar.MINUTE, min);
		targetTime.set(Calendar.SECOND, 0);
		
		System.out.println("Target : " + targetTime.getTimeInMillis());
		System.out.println("Current : " + currentTime.getTimeInMillis());
				
		if(targetTime.getTimeInMillis() < currentTime.getTimeInMillis())
		{
			System.out.println("Here");
			differenceL = currentTime.getTimeInMillis() - targetTime.getTimeInMillis();
			mailSent = true;
		}
		else
		{
			System.out.println("There");
			mailSent = false;
		}
		*/
		
		if(newDiff > 0l)
			mailSent = true;
		else
			mailSent = false;
			
		return newDiff;
	}
	
	public static void main(String args[])
	{
		JFrame frame = new TimeSet();
		frame.show();
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
		
		Font font = new Font("Verdana", Font.BOLD, 12);
		
		Container contentPane = getContentPane();
		
		JPanel p1 = new JPanel();

		Hours = new JLabel("HOURS : ");
		Min = new JLabel("MINUTES : ");
		Meri = new JLabel("MERIDIEM : ");
		
		Hours.setBounds(10, 10, 70, 20);
		Min.setBounds(130, 10, 70, 20);
		Meri.setBounds(10, 40, 70, 20);
		
		hour = new JTextField(10);
		min = new JTextField(10);

		hour.setBounds(90, 10, 30, 20);
		min.setBounds(210, 10, 30, 20);
		
		am = new JRadioButton("AM");
		pm = new JRadioButton("PM");
		
		am.setBounds(90, 40, 50, 20);
		pm.setBounds(145, 40, 50, 20);

		am.addActionListener(this);
		pm.addActionListener(this);
		
		group = new ButtonGroup();

		group.add(am);
		group.add(pm);

		ok = new JButton("OK");
		cancel = new JButton("CANCEL");

		ok.setFont(font);
		cancel.setFont(font);

		ok.setBounds(10, 85, 80, 20);
		cancel.setBounds(100, 85, 100, 20);
		
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
		
		contentPane.add(p1);
		setSize(360, 240);
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

class Reminder extends Thread
{	
	long diff;
	
	Reminder(long diff)
	{
		this.diff = diff;
	}
	
	public void run()
	{
		if(diff  != 0)
		{			
			try
			{
				System.out.println(diff);
				System.out.println("Thread Goes In Sleep Mode");
				Thread.sleep(diff);
				System.out.println("Thread Comes From Sleep Mode");
				System.out.println(diff);				
				SendMail mailer = new SendMail();
				mailer.generateMail("Prathamesh", "prathamesh.b.g2002@gmail.com", false);									
				System.out.println("Mail Sent");
			}
			catch(Exception exception)
			{}
		}
		else
		{
			try
			{
				SendMail mailer = new SendMail();
				mailer.generateMail("Prathamesh", "prathamesh.b.g2002@gmail.com", false);									
			}
			catch(Exception exception)
			{}		
		}
	}
}

