import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataNotFoundJDBCDemo
{
	public static void main(String args[])
	{
		Connection conn = null;
		ResultSet result = null;
		Statement statement = null;
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				statement = conn.createStatement();
				
				result = statement.executeQuery("select id from employee where name = 'Angrej';");
				
				if(result.next())
					System.out.println("\n\tID = " + result.getInt(1));
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

