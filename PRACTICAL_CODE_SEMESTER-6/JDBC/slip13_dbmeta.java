import java.sql.*;
import java.io.*;

public class slip13_dbmeta
{
	public static void main(String args[])
	{
		try
		{
			int size;
			String name;
			String type;
			ResultSet rs = null;
			Connection conn = null;
			DatabaseMetaData md = null;
			
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
			
			md = conn.getMetaData();
			
			System.out.println("DatabaseMetaData Information");
			System.out.println("============================");
			System.out.println("Product Name : " + md.getDatabaseProductName());
			System.out.println("Driver Version : " + md.getDriverVersion());
			System.out.println("Product Version : " + md.getDatabaseProductVersion());
			System.out.println("Driver Name : " + md.getDriverName());
			System.out.println("User Name : " + md.getUserName());
			System.out.println("Driver Minor Version : " + md.getDriverMinorVersion());
			
			rs = md.getTables(null, null, null, new String[]{"TABLE"});
			
			while(rs.next())
			{
				name = rs.getString("TABLE_NAME");
				System.out.println("Table : [" + name + "]");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
