import java.util.Scanner;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionDemo
{
	public static void main(String args[])
	{
		short id;
		String name;
		
		Savepoint save = null;
		Connection conn = null;
		Scanner scanner = null;
		ResultSet result = null;
		Statement statement = null;
		PreparedStatement statementPrepare = null;
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				conn.setAutoCommit(false);

				save = conn.setSavepoint();
				
				statement = conn.createStatement();
				
				scanner = new Scanner(System.in);
								
				result = statement.executeQuery("select * from employee;");
				
				while(result.next())
				{
					System.out.println("\n\t[ID]:" + result.getInt(1));
					System.out.println("\n\t[NAME]:" + result.getString(2));
					System.out.println("\n\t[POSITION]:" + result.getString(3));
					System.out.println("\n\t[WORKING HOUR]:" + result.getInt(4));
				}

				statement.execute("delete from employee where name = 'Akshar';");
								
				statementPrepare = conn.prepareStatement("update employee set name = ? where id = ?;");
				
				System.out.print("\n\tEnter ID : ");
				id = scanner.nextShort();

				System.out.print("\n\tEnter New Name : ");
				name = scanner.next();
				
				statementPrepare.setString(1, name);
				statementPrepare.setInt(2, id);
				
				if(id < 1000)
				{
					statementPrepare.executeUpdate();				
					result = statement.executeQuery("select * from employee;");					
					while(result.next())
					{
						System.out.println("\n\t[ID]:" + result.getInt(1));
						System.out.println("\n\t[NAME]:" + result.getString(2));
						System.out.println("\n\t[POSITION]:" + result.getString(3));
						System.out.println("\n\t[WORKING HOUR]:" + result.getInt(4));
					}
					
					conn.commit();
				}
				else
					conn.rollback(save);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				statement.close();
				result.close();
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
	
	[ID]:1

	[NAME]:Ramesh

	[POSITION]:Senior Engineer

	[WORKING HOUR]:42

	[ID]:2

	[NAME]:Vishal

	[POSITION]:Junior Electrician

	[WORKING HOUR]:40

	[ID]:3

	[NAME]:Ashutosh

	[POSITION]:Joint Secrtory

	[WORKING HOUR]:48

	[ID]:4

	[NAME]:Vishnavi

	[POSITION]:Junior Tester

	[WORKING HOUR]:58

	[ID]:6

	[NAME]:Shroaim

	[POSITION]:Junior Developer

	[WORKING HOUR]:48

	[ID]:7

	[NAME]:Nur

	[POSITION]:Junior Tester

	[WORKING HOUR]:48

	[ID]:8

	[NAME]:Sarthak

	[POSITION]:Junior Supplier

	[WORKING HOUR]:48

	[ID]:5

	[NAME]:Sonali

	[POSITION]:H.R.

	[WORKING HOUR]:25

	[ID]:9

	[NAME]:Shraavan

	[POSITION]:Lecturer

	[WORKING HOUR]:24

	[ID]:10

	[NAME]:Ram

	[POSITION]:Professor

	[WORKING HOUR]:42

	[ID]:11

	[NAME]:Bharat

	[POSITION]:Assistant

	[WORKING HOUR]:30

	[ID]:12

	[NAME]:Akash

	[POSITION]:Developer

	[WORKING HOUR]:41

	[ID]:13

	[NAME]:Santosh

	[POSITION]:Manager

	[WORKING HOUR]:45

	[ID]:15

	[NAME]:Shreyas

	[POSITION]:Batsman

	[WORKING HOUR]:35

	[ID]:16

	[NAME]:Kapil

	[POSITION]:Comedian

	[WORKING HOUR]:8

	[ID]:17

	[NAME]:Williamson

	[POSITION]:Cricketer

	[WORKING HOUR]:10

	[ID]:18

	[NAME]:Santner

	[POSITION]:Spinner

	[WORKING HOUR]:12

	[ID]:19

	[NAME]:Siddhu

	[POSITION]:Comentator

	[WORKING HOUR]:22

	[ID]:21

	[NAME]:Akash

	[POSITION]:Staff_Engineer

	[WORKING HOUR]:45

	[ID]:20

	[NAME]:Rohit

	[POSITION]:Judge

	[WORKING HOUR]:9

	Enter ID : 5				<---------------------------------

	Enter New Name : Sakshi			<---------------------------------

	[ID]:1

	[NAME]:Ramesh

	[POSITION]:Senior Engineer

	[WORKING HOUR]:42

	[ID]:2

	[NAME]:Vishal

	[POSITION]:Junior Electrician

	[WORKING HOUR]:40

	[ID]:3

	[NAME]:Ashutosh

	[POSITION]:Joint Secrtory

	[WORKING HOUR]:48

	[ID]:4

	[NAME]:Vishnavi

	[POSITION]:Junior Tester

	[WORKING HOUR]:58

	[ID]:6

	[NAME]:Shroaim

	[POSITION]:Junior Developer

	[WORKING HOUR]:48

	[ID]:7

	[NAME]:Nur

	[POSITION]:Junior Tester

	[WORKING HOUR]:48

	[ID]:8

	[NAME]:Sarthak

	[POSITION]:Junior Supplier

	[WORKING HOUR]:48

	[ID]:9

	[NAME]:Shraavan

	[POSITION]:Lecturer

	[WORKING HOUR]:24

	[ID]:10

	[NAME]:Ram

	[POSITION]:Professor

	[WORKING HOUR]:42

	[ID]:11

	[NAME]:Bharat

	[POSITION]:Assistant

	[WORKING HOUR]:30

	[ID]:12

	[NAME]:Akash

	[POSITION]:Developer

	[WORKING HOUR]:41

	[ID]:13

	[NAME]:Santosh

	[POSITION]:Manager

	[WORKING HOUR]:45

	[ID]:15

	[NAME]:Shreyas

	[POSITION]:Batsman

	[WORKING HOUR]:35

	[ID]:16

	[NAME]:Kapil

	[POSITION]:Comedian

	[WORKING HOUR]:8

	[ID]:17

	[NAME]:Williamson

	[POSITION]:Cricketer

	[WORKING HOUR]:10

	[ID]:18

	[NAME]:Santner

	[POSITION]:Spinner

	[WORKING HOUR]:12

	[ID]:19

	[NAME]:Siddhu

	[POSITION]:Comentator

	[WORKING HOUR]:22

	[ID]:21

	[NAME]:Akash

	[POSITION]:Staff_Engineer

	[WORKING HOUR]:45

	[ID]:20

	[NAME]:Rohit

	[POSITION]:Judge

	[WORKING HOUR]:9

	[ID]:5				<=======================

	[NAME]:Sakshi

	[POSITION]:H.R.

	[WORKING HOUR]:25
*/
