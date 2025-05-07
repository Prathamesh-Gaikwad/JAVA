import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import database.Database;

class SelectDemo
{
	public static void main(String args[])
	{
		String sql1;
		String userName;
		
		String dbURL = "jdbc:postgresql://localhost:5432/Postgres";
		String user = "postgres";
		String pass = "Pratham@2002";
		
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Database dObj = new Database();
		
		try
		{
			conn = 	DriverManager.getConnection(dbURL, user, pass);	//dObj.connectDB();		//testing for packages...

			sql1 = "select UserID from Users where UserName = ?;";
			
			statement = conn.prepareStatement(sql1);
			
			statement.setString(1, "Prathamesh");
			
			result = statement.executeQuery();			
			
			if(result.next())
				System.out.println("UserID : " + result.getInt(1));
		}
		catch(SQLException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		finally
		{
			try
			{
				if(conn != null && !conn.isClosed())
					conn.close();
			}
			catch(SQLException exception)
			{
				exception.printStackTrace();
				System.out.println(exception);				
			}
		}
	}
}

