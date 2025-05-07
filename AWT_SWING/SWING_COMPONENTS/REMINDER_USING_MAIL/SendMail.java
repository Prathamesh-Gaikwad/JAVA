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
 
public class SendMail 
{
 
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
        msg.setSentDate(new Date());
        // set plain text message
        msg.setText(message);
 
        // sends the e-mail
        Transport.send(msg);
 
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
        String subject = "Welcome To TaskTracker - [REGISTRATION CONFIRMATION]";
        String message = "Hello,\n\nCongratulations! You have successfully registered for TaskTracker, your personalised task management tool.\n\nBelow are your account details :\n\n\t-->Username : " + userName + "\n\t-->Email : " + mailTo + "\n\nYour password has been set successfully. Please keep it confidential to ensure the security of your account.\n\nThank you for choosing TaskTracker. We hope you find our tool helpful in managing your task and boosting your productivity!\n\n\nBest regards,\nTaskTracker Team";
        
        if(!flag)
        	message = "IT'S OVERDUE MAIL";
  
        try 
        {
            sendPlainTextEmail(host, port, mailFrom, password, mailTo,
                    subject, message);
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

