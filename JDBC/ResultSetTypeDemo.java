import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ResultSetTypeDemo
{
	public static void main(String args[])
	{
		String name;
		String position;
		short workinghr;
				
		Scanner scanner;
		Connection conn = null;
		ResultSet result = null;
		Statement statement = null;
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				result = statement.executeQuery("select * from employee;");
				
				while(result.next())
				{
					System.out.println("\n\tID : " + result.getInt(1));
					System.out.println("\n\tNAME : " + result.getString(2));
					System.out.println("\n\tPOSITION : " + result.getString(3));
					System.out.println("\n\tWORKING HOUR : " + result.getInt(4));
				}
				
				result.first();
				System.out.println("\n\tFirst Record : ");
				System.out.println("\n\tID : " + result.getInt(1));
				System.out.println("\n\tNAME : " + result.getString(2));
				System.out.println("\n\tPOSITION : " + result.getString(3));
				System.out.println("\n\tWORKING HOUR : " + result.getInt(4));

				result.last();
				System.out.println("\n\tLast Record : ");
				System.out.println("\n\tID : " + result.getInt(1));
				System.out.println("\n\tNAME : " + result.getString(2));
				System.out.println("\n\tPOSITION : " + result.getString(3));
				System.out.println("\n\tWORKING HOUR : " + result.getInt(4));
				
				statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				scanner = new Scanner(System.in);
				
				result = statement.executeQuery("select * from employee where ID = 12;");

				if(result.next())
				{
					System.out.println("\n\tID : " + result.getInt(1));
					System.out.println("\n\tNAME : " + result.getString(2));
					System.out.println("\n\tPOSITION : " + result.getString(3));
					System.out.println("\n\tWORKING HOUR : " + result.getInt(4));					
				}
				
				System.out.print("\n\tEnter New Name : ");
				name = scanner.next();

				System.out.print("\n\tEnter New Position : ");
				position = scanner.next();

				System.out.print("\n\tEnter New Working Hour : ");
				workinghr = scanner.nextShort();
				
				result.moveToInsertRow();
				result.updateString(2, name);
				result.updateString(3, position);
				result.updateInt(4, workinghr);
				result.insertRow();
				
				result.first();
				System.out.println("\n\tInserted Record : ");
				if(result.next())
				{
					System.out.println("\n\tID : " + result.getInt(1));
					System.out.println("\n\tNAME : " + result.getString(2));
					System.out.println("\n\tPOSITION : " + result.getString(3));
					System.out.println("\n\tWORKING HOUR : " + result.getInt(4));					
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
	
		ID : 1

		NAME : Ramesh

		POSITION : Senior Engineer

		WORKING HOUR : 42

		ID : 2

		NAME : Vishal

		POSITION : Junior Electrician

		WORKING HOUR : 40

		ID : 3

		NAME : Ashutosh

		POSITION : Joint Secrtory

		WORKING HOUR : 48

		ID : 4

		NAME : Vishnavi

		POSITION : Junior Tester

		WORKING HOUR : 58

		ID : 6

		NAME : Shroaim

		POSITION : Junior Developer

		WORKING HOUR : 48

		ID : 7

		NAME : Nur

		POSITION : Junior Tester

		WORKING HOUR : 48

		ID : 8

		NAME : Sarthak

		POSITION : Junior Supplier

		WORKING HOUR : 48

		ID : 5

		NAME : Sonali

		POSITION : H.R.

		WORKING HOUR : 25

		ID : 9

		NAME : Shraavan

		POSITION : Lecturer

		WORKING HOUR : 24

		ID : 10

		NAME : Ram

		POSITION : Professor

		WORKING HOUR : 42

		ID : 11

		NAME : Bharat

		POSITION : Assistant

		WORKING HOUR : 30

		ID : 12

		NAME : Akash

		POSITION : Developer

		WORKING HOUR : 41

		ID : 13

		NAME : Santosh

		POSITION : Manager

		WORKING HOUR : 45

		ID : 14

		NAME : Akshar

		POSITION : Bowler

		WORKING HOUR : 21

		ID : 15

		NAME : Shreyas

		POSITION : Batsman

		WORKING HOUR : 35

		ID : 16

		NAME : Kapil

		POSITION : Comedian

		WORKING HOUR : 8

		ID : 17

		NAME : Williamson

		POSITION : Cricketer

		WORKING HOUR : 10

		ID : 18

		NAME : Santner

		POSITION : Spinner

		WORKING HOUR : 12

		ID : 19

		NAME : Siddhu

		POSITION : Comentator

		WORKING HOUR : 22

		ID : 20

		NAME : Archana

		POSITION : Judge

		WORKING HOUR : 9

		First Record : 

		ID : 1

		NAME : Ramesh

		POSITION : Senior Engineer

		WORKING HOUR : 42

		Last Record : 

		ID : 20

		NAME : Archana

		POSITION : Judge

		WORKING HOUR : 9

		ID : 12

		NAME : Akash

		POSITION : Developer

		WORKING HOUR : 41

		Enter New Name : Akash

		Enter New Position : Staff_Engineer

		Enter New Working Hour : 45

		Inserted Record : 

		ID : 21

		NAME : Akash

		POSITION : Staff_Engineer

		WORKING HOUR : 45

	reflected database :
	
	 id |    name    |      position      | workinghr 
	----+------------+--------------------+-----------
	  1 | Ramesh     | Senior Engineer    |        42
	  2 | Vishal     | Junior Electrician |        40
	  3 | Ashutosh   | Joint Secrtory     |        48
	  4 | Vishnavi   | Junior Tester      |        58
	  6 | Shroaim    | Junior Developer   |        48
	  7 | Nur        | Junior Tester      |        48
	  8 | Sarthak    | Junior Supplier    |        48
	  5 | Sonali     | H.R.               |        25
	  9 | Shraavan   | Lecturer           |        24
	 10 | Ram        | Professor          |        42
	 11 | Bharat     | Assistant          |        30
	 12 | Akash      | Developer          |        41
	 13 | Santosh    | Manager            |        45
	 14 | Akshar     | Bowler             |        21
	 15 | Shreyas    | Batsman            |        35
	 16 | Kapil      | Comedian           |         8
	 17 | Williamson | Cricketer          |        10
	 18 | Santner    | Spinner            |        12
	 19 | Siddhu     | Comentator         |        22
	 20 | Archana    | Judge              |         9
	 21 | Akash      | Staff_Engineer     |        45		<----------------------------
	(21 rows)
*/
