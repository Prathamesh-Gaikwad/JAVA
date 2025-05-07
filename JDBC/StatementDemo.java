import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class StatementDemo
{
	private Connection conn;
	private ResultSet result;
	private Statement statement;
	
	public StatementDemo()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002"); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) 
	{
		int count;
		boolean bool;
		
		StringBuilder query = new StringBuilder();
		
		StatementDemo obj = new StatementDemo();
		try
		{
			try
			{
				obj.statement = obj.conn.createStatement();
				
				query.replace(0, query.length(), "select * from employee;");
				
				obj.result = obj.statement.executeQuery(query.toString());
				
				while(obj.result.next())
				{
					System.out.println("\n\t#Employee ID : " + obj.result.getInt(1));
					System.out.println("\t1)Name : " + obj.result.getString(2));
					System.out.println("\t2)Position : " + obj.result.getString(3));
					System.out.println("\t3)Working Hour : " + obj.result.getInt(4));
				}
				
				bool = obj.statement.execute("insert into employee (name, position, workinghr) values ('Sarthak', 'Junior Supplier', 48);");
				//why execute returned opposite result i.e false in success..
				
				if(!bool)
				{
					query.replace(0, query.length(), "select * from employee where name = 'Sarthak';");
					
					obj.result = obj.statement.executeQuery(query.toString());
					
					while(obj.result.next())
					{
						System.out.println("\n\t#Employee ID : " + obj.result.getInt(1));
						System.out.println("\t1)Name : " + obj.result.getString(2));
						System.out.println("\t2)Position : " + obj.result.getString(3));
						System.out.println("\t3)Working Hour : " + obj.result.getInt(4));
					}				
				}
				else
					System.out.println("Problem In Query Execution");
					
				query.replace(0, query.length(), "update employee set workinghr = 25 where name = 'Sonali';");
				count = obj.statement.executeUpdate(query.toString());
				
				if(count > 0)
				{
					query.replace(0, query.length(), "select * from employee where name = 'Sonali';");
					
					obj.result = obj.statement.executeQuery(query.toString());
					
					while(obj.result.next())
					{
						System.out.println("\n\t#Employee ID : " + obj.result.getInt(1));
						System.out.println("\t1)Name : " + obj.result.getString(2));
						System.out.println("\t2)Position : " + obj.result.getString(3));
						System.out.println("\t3)Working Hour : " + obj.result.getInt(4));
					}				
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				obj.statement.close();
				obj.result.close();
				obj.conn.close();
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
	
	#Employee ID : 1
	1)Name : Ramesh
	2)Position : Senior Engineer
	3)Working Hour : 42

	#Employee ID : 2
	1)Name : Vishal
	2)Position : Junior Electrician
	3)Working Hour : 40

	#Employee ID : 3
	1)Name : Ashutosh
	2)Position : Joint Secrtory
	3)Working Hour : 48

	#Employee ID : 4
	1)Name : Vishnavi
	2)Position : Junior Tester
	3)Working Hour : 58

	#Employee ID : 5
	1)Name : Sonali
	2)Position : H.R.
	3)Working Hour : 38

	#Employee ID : 6
	1)Name : Shroaim
	2)Position : Junior Developer
	3)Working Hour : 48

	#Employee ID : 7
	1)Name : Nur
	2)Position : Junior Tester
	3)Working Hour : 48

	#Employee ID : 8
	1)Name : Sarthak
	2)Position : Junior Supplier
	3)Working Hour : 48

	#Employee ID : 5
	1)Name : Sonali
	2)Position : H.R.
	3)Working Hour : 25
*/

