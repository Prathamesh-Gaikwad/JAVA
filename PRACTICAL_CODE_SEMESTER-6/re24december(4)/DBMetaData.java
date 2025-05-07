import java.sql.*;
import java.io.*;

public class DBMetaData
{
	public static void main(String args[])
	{
		try
		{
			int size;
			String name;
			String type;
			ResultSet rs = null;
			ResultSet rs1 = null;
			Connection conn = null;
			DatabaseMetaData md = null;
			
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college", "postgres", "123");
			
			md = conn.getMetaData();
			
			System.out.println("DatabaseMetaData Information");
			System.out.println("============================");
			System.out.println("Product Name : " + md.getDatabaseProductName());
			System.out.println("Driver Version : " + md.getDriverVersion());
			System.out.println("Product Version : " + md.getDatabaseProductVersion());
			System.out.println("Driver Name : " + md.getDriverName());
			System.out.println("User Name : " + md.getUserName());
			System.out.println("Driver Minor Version : " + md.getDriverMinorVersion());
			
			rs = md.getColumns(null, null, "project", null);
			
			while(rs.next())
			{
				name = rs.getString("COLUMN_NAME");
				type = rs.getString("TYPE_NAME");
				size = rs.getInt("COLUMN_SIZE");
				
				System.out.println("Column Name : [" + name + "] Type : [" + type + "] Size : [" + size + "]");
			}
			
			rs1 = md.getTables(null, null, null, new String[]{"TABLE"});
			
			while(rs1.next())
			{
				name = rs1.getString("TABLE_NAME");
				System.out.println("Table : [" + name + "]");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
