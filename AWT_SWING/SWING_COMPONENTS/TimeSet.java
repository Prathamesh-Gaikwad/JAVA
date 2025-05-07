import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

public class TimeSet extends JFrame implements ActionListener
{
	private JMenuItem exitItem;
	private JMenuItem connectItem;
	private ConnectDialog dialog = null;
	
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
			}
		}
		else if(source == exitItem)
			System.exit(0);
	}
	
	static long difference(int hour, int min)
	{
		Calendar currentTime = Calendar.getInstance();
		Calendar targetTime = Calendar.getInstance();
		
		targetTime.set(Calendar.HOUR_OF_DAY, hour);
		targetTime.set(Calendar.MINUTE, min);
		targetTime.set(Calendar.SECOND, 0);
		
		long differenceL = targetTime.getTimeInMillis() - targetTime.getTimeInMillis();
		
		return differenceL;
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
		if(diff)
		{
			Thread.sleep(diff);
			
			try
			{
				SendMail mailer = new SendMail();
				mailer.generateMail(userName, gmail, 0);									
			}
			catch(Exception exception)
			{}
		}
		else
		{
			try
			{
				SendMail mailer = new SendMail();
				mailer.generateMail(userName, gmail, 0);									
			}
			catch(Exception exception)
			{}		
		}
	}
}

