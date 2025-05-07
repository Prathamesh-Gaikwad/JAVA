import java.util.Scanner;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class slip22_menu
{
	Connection conn = null;

	public slip22_menu()
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
	
	public int update(int id, String name, String position, int workingHr)
	{
		int result = 0;
		
		PreparedStatement statement = null;
		
		try
		{
			try
			{
				statement = conn.prepareStatement("update employee set name = ?, position = ?, workingHr = ? where id = ?;");

				statement.setString(1, name);
				statement.setString(2, position);
				statement.setInt(3, workingHr);
				statement.setInt(4, id);

				result = statement.executeUpdate();				
			}
			catch(Exception ex1)
			{
				ex1.printStackTrace();
			}
		}
		catch(Exception ex2)
		{
			ex2.printStackTrace();
		}
		
		return result;
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
	
	public void Display()
	{
		ResultSet result = null;
		
		try
		{
			try
			{
				result = select();
				
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
	
	public static void main(String args[])
	{
		int ch = 0;
		int id = 0;
		int workingHr = 0;
		String name = null;
		String position = null;
		
		int size;
		
		slip22_menu obj = new slip22_menu();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("----------MENU-------------");
			System.out.println("1).Insert");
			System.out.println("2).Update");
			System.out.println("3).Display");
			System.out.println("4).Exit");
			System.out.println("Enter Your Choice : ");
			ch = scanner.nextInt();
			
			if(4 == ch)
				break;
				
			switch(ch)
			{
				case 1 :
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
					break;

				case 2 :
					System.out.print("\n\tEnter ID : ");
					id = scanner.nextInt();

					System.out.print("\n\tEnter NAME : ");
					name = scanner.next();

					System.out.print("\n\tEnter POSITION : ");
					position = scanner.next();

					System.out.print("\n\tEnter WORKING HOUR : ");
					workingHr = scanner.nextInt();
					
					size = obj.update(id, name, position, workingHr);
					
					if(size > 0)
						System.out.println("Updated Successfully");
					break;
					
				case 3 :
					obj.Display();
					break;
					
				default :
					System.out.println("Invalid Choice");
			}
		}
		
	}
}

