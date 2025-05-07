import java.sql.*;

public class ResultSetmetaDataExample
{
	public static void main(String args[])
	{
		int colCount;
		int rowCount = 0;
		Statement st = null;
		ResultSet rs = null;
		Connection conn = null;
		ResultSetMetaData rsmd = null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college", "postgres", "123");
			
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM project");
			
			rsmd = rs.getMetaData();
			
			colCount = rsmd.getColumnCount();
			
			for(int i = 1; i <= colCount; i++)
			{
				System.out.println("Information About Column " + i);
				System.out.println("Name : " + rsmd.getColumnName(i));
				System.out.println("Data Type : " + rsmd.getColumnType(i) + " (" + rsmd.getColumnTypeName(i) + ")");
				System.out.print("Allows NULL : ");
				if(0 == rsmd.isNullable(i))
					System.out.println("false");
				else
					System.out.println("true");								
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
