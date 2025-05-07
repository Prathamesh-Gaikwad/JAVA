import java.util.Scanner;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class slip7_insert_select
{
	Connection conn = null;

	public slip7_insert_select()
	{
		try
		{
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert(int id, String name, String position, int workingHr)
	{
		PreparedStatement statement = null;
		
		try
		{
			try
			{
				statement = conn.prepareStatement("insert into employee (id, name, position, workingHr) values (?, ?, ?, ?);");
				
				statement.setInt(1, id);
				statement.setString(2, name);
				statement.setString(3, position);
				statement.setInt(4, workingHr);
				
				statement.executeUpdate();
			}
			catch(Exception ex2)
			{
				ex2.printStackTrace();
			}
			finally
			{
				statement.close();
			}
		}
		catch(Exception ex1)
		{
			ex1.printStackTrace();
		}
	}
	
	public ResultSet select()
	{
		ResultSet result = null;
		Statement statement = null;
		
		try
		{
			try
			{
				statement = conn.createStatement();
				result = statement.executeQuery("select * from employee;");
				
				if(result != null)
					return result;
			}
			catch(Exception ex1)
			{
				ex1.printStackTrace();
			}
			finally
			{
				//statement.close();
			}
		}
		catch(Exception ex2)
		{
			ex2.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String args[])
	{
		int id = 0;
		int workingHr = 0;
		String name = null;
		String position = null;

		ResultSet result = null;
		
		int size;
		
		slip7_insert_select obj = new slip7_insert_select();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n\tTotal Employee Size : ");
		size = scanner.nextInt();
		
		for(int i = 0; i < size; i++)
		{
			System.out.print("\n\tEnter ID : ");
			id = scanner.nextInt();
			
			System.out.print("\n\tEnter NAME : ");
			name = scanner.next();
			
			System.out.print("\n\tEnter POSITION : ");
			position = scanner.next();
			
			System.out.print("\n\tEnter WORKING HOUR : ");
			workingHr = scanner.nextInt();
			
			obj.insert(id, name, position, workingHr);
		}
		
		System.out.println("\n\tEmployee Details : ");
		
		try
		{
			try
			{
				result = obj.select();
				
				if(result != null)
				{
					while(result.next())
					{
						System.out.println("\n\tID : " + result.getInt(1));
						System.out.println("\n\tNAME : " + result.getString(2));
						System.out.println("\n\tPOSITION : " + result.getString(3));
						System.out.println("\n\tWORKING HOUR : " + result.getInt(4));
					}
				}
			}
			catch(Exception ex1)
			{
				ex1.printStackTrace();
			}
			finally
			{
				if(result != null)
					result.close();
			}
		}
		catch(Exception ex2)
		{
			ex2.printStackTrace();
		}
	}
}

