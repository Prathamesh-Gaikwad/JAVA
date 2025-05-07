import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;

public class CallableStatementDemo
{
	public static void main(String args[])
	{
		short size;
		boolean bool;
		short workinghr;
		StringBuilder name;
		StringBuilder position;
		
		Scanner scanner;
		Connection conn = null;
		ResultSet result = null;
		CallableStatement statement = null;
		PreparedStatement statementPrepare = null;
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				scanner = new Scanner(System.in);
				
				name = new StringBuilder();
				position = new StringBuilder();
				
				System.out.print("\n\tEnter Employee Count : ");
				size = scanner.nextShort();
				
				for(int i = 0; i < size; i++)
				{
					System.out.print("\n\t-->Enter Name : ");
					name.replace(0, name.length(), scanner.next());

					System.out.print("\n\t-->Enter Position : ");
					position.replace(0, position.length(), scanner.next());
					
					System.out.print("\n\t-->Enter Working Hour : ");
					workinghr = scanner.nextShort();
					
					//able to call procedures..
					statement = conn.prepareCall("CALL insertIntoEmployee(?, ?, ?);");
					
					statement.setString(1, name.toString());
					statement.setString(2, position.toString());
					statement.setShort(3, workinghr);
					
					bool = statement.execute();
					
					if(!bool)
						System.out.println("\n\tInsertion Successful");
					else
						System.out.println("\n\tProblem In Query Execution");
				}
				
				System.out.print("\n\tEnter Employee Name To Display His Details : ");
				name.replace(0, name.length(), scanner.next());
				
				statementPrepare = conn.prepareStatement("select * from employee where name = ?;");
				
				statementPrepare.setString(1, name.toString());
				
				result = statementPrepare.executeQuery();
				
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
				statementPrepare.close();
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

	-->Enter Name : Siddhu

	-->Enter Position : Comentator

	-->Enter Working Hour : 22

	Insertion Successful

	-->Enter Name : Archana

	-->Enter Position : Judge

	-->Enter Working Hour : 9

	Insertion Successful

	Enter Employee Name To Display His Details : Santner

	-->ID : 18

	-->NAME : Santner

	-->POSITION : Spinner

	-->WORKING HOUR : 12
*/

