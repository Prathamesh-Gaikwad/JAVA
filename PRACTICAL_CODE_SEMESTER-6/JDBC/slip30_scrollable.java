import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class slip30_scrollable
{
	public static void main(String args[])
	{
		String name;
		String position;
		short workinghr;
				
		Scanner scanner;
		Connection conn = null;
		ResultSet result = null;
		Statement statement = null;
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				result = statement.executeQuery("select * from employee;");
				
				while(result.next())
				{
					System.out.println("\n\tID : " + result.getInt(1));
					System.out.println("\n\tNAME : " + result.getString(2));
					System.out.println("\n\tPOSITION : " + result.getString(3));
					System.out.println("\n\tWORKING HOUR : " + result.getInt(4));
				}
				
				result.first();
				System.out.println("\n\tFirst Record : ");
				System.out.println("\n\tID : " + result.getInt(1));
				System.out.println("\n\tNAME : " + result.getString(2));
				System.out.println("\n\tPOSITION : " + result.getString(3));
				System.out.println("\n\tWORKING HOUR : " + result.getInt(4));

				result.last();
				System.out.println("\n\tLast Record : ");
				System.out.println("\n\tID : " + result.getInt(1));
				System.out.println("\n\tNAME : " + result.getString(2));
				System.out.println("\n\tPOSITION : " + result.getString(3));
				System.out.println("\n\tWORKING HOUR : " + result.getInt(4));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				statement.close();
				result.close();
				conn.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

