import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SQLBatchDemo
{
	public static void main(String args[])
	{
		short size;
		short workinghr;
		StringBuilder name;
		StringBuilder position;
		
		Scanner scanner = null;
		Connection conn = null;
		PreparedStatement statement = null;
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				scanner = new Scanner(System.in);
				
				name = new StringBuilder();
				position = new StringBuilder();
				
				conn.setAutoCommit(false);
				
				statement = conn.prepareStatement("insert into employee (name, position, workinghr) values(?, ?, ?);");
				
				System.out.print("\n\tEnter Employee Count : ");
				size = scanner.nextShort();
				
				for(int i = 0; i < size; i++)
				{
					System.out.print("\n\tEnter Name : ");
					name.replace(0, name.length(), scanner.next());
					
					System.out.print("\n\tEnter Position : ");
					position.replace(0, position.length(), scanner.next());
					
					System.out.print("\n\tEnter Working Hour : ");
					workinghr = scanner.nextShort();
					
					statement.setString(1, name.toString());
					statement.setString(2, position.toString());
					statement.setInt(3, workinghr);
					
					statement.addBatch();
				}
				
				int arr[] = statement.executeBatch();
				workinghr = (short)arr.length;
				if(0 < workinghr)
				{
					System.out.println("\n\tTotal Employee Details Inserted is " + workinghr);
					conn.commit();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				statement.close();
				conn.setAutoCommit(true);
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

		Enter Name : Dhoni

		Enter Position : WicketKeeper

		Enter Working Hour : 11

		Enter Name : Ashish_Nehra

		Enter Position : FastBowler

		Enter Working Hour : 12

		Total Employee Details Inserted is 2

	DATABASE REFLECTION ==>
	
		 id |     name     |      position      | workinghr 
		----+--------------+--------------------+-----------
		  1 | Ramesh       | Senior Engineer    |        42
		  2 | Vishal       | Junior Electrician |        40
		  3 | Ashutosh     | Joint Secrtory     |        48
		  4 | Vishnavi     | Junior Tester      |        58
		  6 | Shroaim      | Junior Developer   |        48
		  7 | Nur          | Junior Tester      |        48
		  8 | Sarthak      | Junior Supplier    |        48
		  9 | Shraavan     | Lecturer           |        24
		 10 | Ram          | Professor          |        42
		 11 | Bharat       | Assistant          |        30
		 12 | Akash        | Developer          |        41
		 13 | Santosh      | Manager            |        45
		 15 | Shreyas      | Batsman            |        35
		 16 | Kapil        | Comedian           |         8
		 17 | Williamson   | Cricketer          |        10
		 18 | Santner      | Spinner            |        12
		 19 | Siddhu       | Comentator         |        22
		 21 | Akash        | Staff_Engineer     |        45
		 20 | Rohit        | Judge              |         9
		  5 | Sakshi       | H.R.               |        25
		 22 | Rohan        | GrocerySeller      |        10
		 23 | Mahesh       | ExamHead           |         8
		 24 | Harshita     | DepartmentHead     |         9
		 25 | HarpaalSingh | Shef               |         7
		 26 | Dhoni        | WicketKeeper       |        11			<---------------
		 27 | Ashish_Nehra | FastBowler         |        12			<---------------
		(26 rows)
*/

