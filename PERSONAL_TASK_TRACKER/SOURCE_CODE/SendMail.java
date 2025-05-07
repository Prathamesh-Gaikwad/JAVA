import java.util.Date;
import java.util.Properties;
 
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import database.Database;

public class SendMail 
{
	Database dObj = new Database();	
	Registration rObj = new Registration(1);
 
    public void sendPlainTextEmail(String host, String port, final String userName, final String password, String toAddress,String subject, String message) throws AddressException,MessagingException 
            {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); 
	properties.put("mail.smtp.socketFactory.port", "587");
	properties.put("mail.smtp.starttls.required", "true");
	properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() 
        {
            public PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new java.util.Date());
        // set plain text message
        msg.setText(message);
 
        // sends the e-mail
        Transport.send(msg);
 
    }

	String reminderMessage()
	{
		int i;
		int userID;
		String mail;
		String userName;
		ResultSet result;
		Connection conn = null;

		String strDate;
		StringBuilder str;
		java.sql.Date date;

		str = new StringBuilder();
				
		try
		{
			conn = dObj.connectDB();

			userName = rObj.getUserName();

			if(Registration.choice1Str.toString().equals("Employee"))
			{
				userID = dObj.getUserID(userName, conn);
				result = dObj.getOverDueTasks(userID, conn, false);
			}
			else
			{	
				userID = dObj.getUserID(userName, conn, true);				
				result = dObj.getOverDueTasks(userID, conn, true);
			}
												
			if(false == result.isBeforeFirst())
			{
				str.append("\n\t\tNO OVERDUE TASKS!!💫️\n\t\tCONGRATULATIONS!!🥳️\n\t\tACHIEVE NEW ACCOMPLISHMENTS!!!🦾️");
				return str.toString();
			}
			i = 1;
			while(result.next())
			{
				date = result.getDate(2);	
				strDate = date.toString();
				
				str.append("\t" + i + ") TASK : " + result.getString(1) + " LAST DATE : " + strDate + "\n");
				i++;
			}
		}
		catch(SQLException exception)
		{}
		
		return str.toString();
	}

    public boolean generateMail(String userName, String mailTo, boolean flag) throws Exception
    {
        // SMTP server information
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "pgaikwad.lab@gmail.com";
        String password = "jcxxhwpixjsselhx ";			//app password
 
        // outgoing message information
        //String mailTo = "prathamesh.b.g2002@gmail.com";
        String subject = "🟡️ Welcome To TaskTracker - [REGISTRATION CONFIRMATION]💻️";
        StringBuilder message = new StringBuilder();
        message.replace(0, message.length(), "Hello👋️,\n\nCongratulations!🥳️ You have successfully registered for TaskTracker📓️, your personalised task management tool.🖥️\n\nBelow are your account details :\n\n\t-->Username : " + userName + "\n\t-->Email : " + mailTo + "\n\nYour password has been set successfully. Please keep it confidential to ensure the security of your account.🔐️\n\nThank you 🤝️ for choosing TaskTracker. We hope you find our tool helpful 💁️ in managing your task and boosting your productivity!\n\n\nBest regards,\nTaskTracker Team");
        
        if(!flag)
        {
        	subject = "🔴️ TaskTracker - [OVERDUE TASK ALERT⏰️]";
        	message.replace(0, message.length(), "Dear " + userName + "🧑️,\n\nThis is a reminder⏰️ that the following tasks are overdue :\n\n");
        	message.append(reminderMessage());
        	message.append("\n\nPlease complete⏳️ the task and update the status at your earliest convenience.\n\n\nBest regards,\nTaskTracker Team");		
  	}
  	
        try 
        {
            sendPlainTextEmail(host, port, mailFrom, password, mailTo,
                    subject, message.toString());
            //System.out.println("Email sent.");
            return true;
        } 
        catch (Exception ex) 
        {
            //System.out.println("Failed to sent email.");
            //ex.printStackTrace();
            
            throw ex;
            
            //return false;
        }
    }
} 

