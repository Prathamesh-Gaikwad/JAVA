import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class JDBCDemo
{
	public static void main(String agrs[])
	{
		String dbURL = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pass = "Pratham@2002";
		ResultSet result = null;
		
		Connection conn = null;
		try 
		{
			// Connect method #1
			//String dbURL1 = "jdbc:postgresql:ProductDB1?user=root&password=secret";
			//conn1 = DriverManager.getConnection(dbURL1);
			int rowsInserted = 0;
			int count = 0;
			
			Class.forName("org.postgresql.Driver");			
			conn = DriverManager.getConnection(dbURL, user, pass);
			
			//insert query demonstration..
			String sql1 = "INSERT INTO Student (sno, sname) VALUES (?, ?)";

			if (conn != null) 
				System.out.println("Connected to database #1");
			else
				System.out.println("connection failed");
		    

			PreparedStatement statement1 = conn.prepareStatement(sql1);
			
			statement1.setInt(1, 105);
			statement1.setString(2, "Makrand Anaspure");

			rowsInserted = statement1.executeUpdate();
			
			if (rowsInserted > 0) 
			{
				System.out.println("A new user was inserted successfully!");
			}
			
			//select query demonstration						
			String sql2 = "SELECT * FROM Student";
			 
			Statement statement2 = conn.createStatement();
			//ResultSet result = statement2.executeQuery(sql2);
			 			 
			while (result.next())
			{
			    int no = result.getInt(1);
			    String name = result.getString(2);
			    //String fullname = result.getString("fullname");
			    //String email = result.getString("email");
			 
			    String output = "User #%d: %s ";
			    System.out.println(String.format(output, no, name));
			}
			
		}
		catch (SQLException ex) 
		{
            		ex.printStackTrace();
            		
            		System.out.println("connection failed");
	        } 
	        finally 
	        {
            		try 
            		{
                		if (conn != null && !conn.isClosed()) 
                		{
                    			conn.close();
                		}
		         } 
		         catch (SQLException ex) 
		         {
         		       ex.printStackTrace();
            		 }
        	}            		
	}
}

