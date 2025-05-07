import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;

public class DatabaseMetaDataDemo
{
	public static void main(String args[])
	{
		short size;
		StringBuilder name;
		StringBuilder type;
		
		Connection conn = null;
		ResultSet result = null;
		DatabaseMetaData meta = null;		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				meta = conn.getMetaData();
				
				name = new StringBuilder();
				type = new StringBuilder();

				System.out.println("\n\tDriver Name : " + meta.getDriverName());
				System.out.println("\n\tDriver Version : " + meta.getDriverVersion());
				System.out.println("\n\tUser Name : " + meta.getUserName());
				System.out.println("\n\tDatabase Product Name : " + meta.getDatabaseProductName());
				System.out.println("\n\tDatabase Product Version : " + meta.getDatabaseProductVersion());
				
				System.out.println("\n\t[TABLE DETAILS FROM DATABASE]");
				result = meta.getTables(null, null, "%", new String[]{"TABLE"});
				while(result.next())
				{
					name.replace(0, name.length(), result.getString("TABLE_NAME"));
					System.out.println("\n\t[NAME] : " + name.toString());
				}
				

				System.out.println("\n\t[COLUMNS FROM employee TABLE]");
				result = meta.getColumns(null, null, "employee", null);				
				while(result.next())
				{
					name.replace(0, name.length(), result.getString("COLUMN_NAME"));
					type.replace(0, type.length(), result.getString("TYPE_NAME"));
					size = (short)result.getInt("COLUMN_SIZE");
					
					System.out.println("\n\t[NAME] : " + name.toString() + " [TYPE] : " + type.toString() + " [SIZE] : " + size);
				}
								
				/*
				result = meta.getPrimaryKeys();

				result = meta.getImportedKeys();

				result = meta.getExportedKeys();

				result = meta.getProcedures();

				result = meta.getProcedureColumns();
				*/
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				conn.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

/*
	o/p:
	
	Driver Name : PostgreSQL JDBC Driver

	Driver Version : 42.7.4

	User Name : postgres

	Database Product Name : PostgreSQL

	Database Product Version : 16.6 (Ubuntu 16.6-1.pgdg24.04+1)

	[TABLE DETAILS FROM DATABASE]

	[NAME] : dates

	[NAME] : employee

	[NAME] : movie

	[NAME] : student

	[NAME] : tasks

	[NAME] : users

	[COLUMNS FROM employee TABLE]

	[NAME] : id [TYPE] : serial [SIZE] : 10

	[NAME] : name [TYPE] : varchar [SIZE] : 30

	[NAME] : position [TYPE] : varchar [SIZE] : 30

	[NAME] : workinghr [TYPE] : int4 [SIZE] : 10
*/

