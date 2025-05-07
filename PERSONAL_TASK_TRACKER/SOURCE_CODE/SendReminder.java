import java.util.Date;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import database.Database;


public class SendReminder
{
	private static boolean mailSent;

	Database dObj = new Database();	
	Registration rObj = new Registration(1);

	void generateReminder()
	{
		int userID;
		ResultSet result;
		Connection conn = null;

		try
		{
			conn = dObj.connectDB();

			String userName = rObj.getUserName();
			
			if(Registration.choice1Str.toString().equals("Employee"))
			{
				userID = dObj.getUserID(userName, conn);
				result = dObj.getReminder(userID, conn, false);
			}
			else
			{	
				userID = dObj.getUserID(userName, conn, true);				
				result = dObj.getReminder(userID, conn, true);
			}
			
			if(result.next())
				userName = result.getString(1);
			else
				return;					//i.e. fail to retrieve reminder hence no mail going to sent...	
		
			String arr[] = userName.split("-");
			
			int hour = Integer.parseInt(arr[0]);
			int min = Integer.parseInt(arr[1]);
						
			long diffL = difference(hour, min);				
			
			if(mailSent)
			{
				Reminder thread = new Reminder(diffL);
				thread.start();
			}
		}
		catch(SQLException exception)
		{}
	}

	static long difference(int hour, int min)
	{
		long newDiff = 0l;
		
		Date targetDate = new Date();

		targetDate.setHours(hour);
		targetDate.setMinutes(min);

		Date currentDate = new Date();
		
		SimpleDateFormat formatS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime targetL = LocalDateTime.parse(formatS.format(targetDate), formatter);
		LocalDateTime currentL = LocalDateTime.parse(formatS.format(currentDate), formatter);
		
		newDiff = java.time.Duration.between(currentL, targetL).toMillis();
		
		if(newDiff > 0l)
			mailSent = true;
		else
			mailSent = false;
			
		return newDiff;
	}
}

class Reminder extends Thread
{	
	long diff;

	Database dObj = new Database();	
	Registration rObj = new Registration(1);
	
	Reminder(long diff)
	{
		this.diff = diff;
	}
	
	public void run()
	{
		int userID;
		ResultSet result;
		Connection conn = null;

		try
		{
			conn = dObj.connectDB();

			String userName = rObj.getUserName();
			
			if(Registration.choice1Str.toString().equals("Employee"))
			{
				userID = dObj.getUserID(userName, conn);
				result = dObj.getMail(userID, conn, false);
			}
			else
			{	
				userID = dObj.getUserID(userName, conn, true);				
				result = dObj.getMail(userID, conn, true);
			}
			
			if(result.next())
			{
				String mail = result.getString(1);

				if(diff  != 0)
				{			
					try
					{
						Thread.sleep(diff);
						SendMail mailer = new SendMail();
						mailer.generateMail(userName, mail, false);									
					}
					catch(Exception exception)
					{}
				}
				else
				{
					try
					{
						SendMail mailer = new SendMail();
						mailer.generateMail(userName, mail, false);									
					}
					catch(Exception exception)
					{}		
				}

			}
			else
				return;					//i.e. fail to retrieve gmail address hence no mail going to sent...			
		}
		catch(SQLException exception)
		{}	
	}
}

