//COLLECTION CLASSES
import java.util.LinkedList;

//DATABASE CLASSES
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

public class LinkedListDB
{
	public static void main(String args[])
	{
		//DATABASE DECLARATIONS
		String user = "postgres";
		String pass = "Pratham@2002";
		String dbURL = "jdbc:postgresql://localhost:5432/postgres";

		java.sql.Date date;
		String strDate = null;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		//LINKEDLIST DECLARATIONS
		LinkedList<DueTask> linkL = new LinkedList<DueTask>();
		
		try
		{
			conn = DriverManager.getConnection(dbURL, user, pass);

			String sql = "select Title, DueDate from Tasks where userID = 1 and duedate < ? and status = 'Pending';";
			
			statement = conn.prepareStatement(sql);
			
			//current date from system..
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());			
			
			statement.setDate(1, sqlDate);
			
			result = statement.executeQuery();
						
			while(result.next())
			{
				date = result.getDate(2);	
				strDate = date.toString();
				
				DueTask dObj = new DueTask(result.getString(1), strDate);
				
				linkL.add(dObj);
			}
						
			for(DueTask dObj : linkL)
			{
				System.out.println("\n\t[TITLE] : " + dObj.title + "\t[DATE] : " + dObj.date);
			}
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		
	}
}
