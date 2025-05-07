import java.util.Scanner;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class slip16_teacher
{
	Connection conn = null;

	public slip16_teacher()
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
	
	public void insert(int id, String name, String subject, String research)
	{
		PreparedStatement statement = null;
		
		try
		{
			try
			{
				statement = conn.prepareStatement("insert into teacher (no, name, subject, research_area) values (?, ?, ?, ?);");
				
				statement.setInt(1, id);
				statement.setString(2, name);
				statement.setString(3, subject);
				statement.setString(4, research);
				
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
				result = statement.executeQuery("select * from teacher where subject = 'Java';");
				
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
		String name = null;
		String subject = null;
		String research = null;

		ResultSet result = null;
		
		int size;
		
		slip16_teacher obj = new slip16_teacher();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n\tEnter Five Teacher Details : ");
		for(int i = 0; i < 5; i++)
		{
			System.out.print("\n\tEnter Teacher ID : ");
			id = scanner.nextInt();
			
			System.out.print("\n\tEnter Teacher NAME : ");
			name = scanner.next();
			
			System.out.print("\n\tEnter Teacher SUBJECT : ");
			subject = scanner.next();
			
			System.out.print("\n\tEnter Teacher RESEARCH_AREA : ");
			research = scanner.next();
			
			obj.insert(id, name, subject, research);
		}
		
		System.out.println("\n\tTEACHER Details : ");
		
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
						System.out.println("\n\tSUBJECT : " + result.getString(3));
						System.out.println("\n\tRESEARCH AREA : " + result.getString(4));
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

