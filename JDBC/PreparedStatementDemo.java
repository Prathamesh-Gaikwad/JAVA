import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo
{
	public static void main(String args[])
	{
		int size;
		short ack;
		short workinghr;
		StringBuilder name;
		StringBuilder position;

		Scanner scanner;
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		try
		{
			try
			{
				Class.forName("org.postgresql.Driver");
				
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				//parameterized query..
				statement = conn.prepareStatement("insert into employee (name, position, workinghr) values (?, ?, ?);");
				
				scanner = new Scanner(System.in);
				
				name = new StringBuilder();
				position = new StringBuilder();
				
				System.out.print("\n\tEnter Employee Count : ");
				size = scanner.nextInt();

				for(int i = 0; i < size;  i++)
				{
					System.out.print("\n\t-->Enter Name : ");
					name.replace(0, name.length(), scanner.next());

					System.out.print("\n\t-->Enter Position : ");
					position.replace(0, position.length(), scanner.next());

					System.out.print("\n\t-->Enter Working Hour : ");
					workinghr = scanner.nextShort();
					
					statement.setString(1, name.toString());
					statement.setString(2, position.toString());
					statement.setShort(3, workinghr);
					
					ack = (short)statement.executeUpdate();
					
					if(1 == ack)
						System.out.println("\n\tInsertion Successful");
					else
						System.out.println("\n\tProblem In Query Exceution");
				}
				
				statement = conn.prepareStatement("Select * from employee where name = ?;");
				
				System.out.print("\n\tEnter Employee Name To Get His Details : ");
				name.replace(0, name.length(), scanner.next());
				
				statement.setString(1, name.toString());
				
				result = statement.executeQuery();
				
				while(result.next())
				{
					System.out.println("\n\t-->ID : " + result.getInt(1));
					System.out.println("\n\t-->NAME : " + result.getString(2));
					System.out.println("\n\t-->POSITION : " + result.getString(3));
					System.out.println("\n\t-->WORKING HOUR : " + result.getString(4));
				}
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
/*
	o/p:
	
	Enter Employee Count : 2

	-->Enter Name : Akash

	-->Enter Position : Developer

	-->Enter Working Hour : 41

	Insertion Successful

	-->Enter Name : Santosh

	-->Enter Position : Manager

	-->Enter Working Hour : 45

	Insertion Successful

	Enter Employee Name To Get His Details : Ashutosh

	-->ID : 3

	-->NAME : Ashutosh

	-->POSITION : Joint Secrtory

	-->WORKING HOUR : 48	
*/
