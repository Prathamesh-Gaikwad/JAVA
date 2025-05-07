<% @page import = "java.sql.*, java.util.*" %>
<h2>EMPLOYEE DETAILS</h2>

<table border = 1>
	<tr>
		<th>EMPLOYEE ID</th>
		<th>EMPLOYEE NAME</th>
		<th>EMPLOYEE POSITION</th>
		<th>EMPLOYEE WORKING HOUR</th>
	</tr>
	
	<%
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				statement = conn.createStatement();
				
				result = statement.executeQuery("select * from employee;");
				
				while(result.next())
				{
	%>
					<tr>
						<td><% = result.getInt(1) %></td>
						<td><% = result.getString(2) %></td>
						<td><% = result.getString(3) %></td>
						<td><% = result.getInt(4) %></td>
					</tr>
	<%
			}
			catch(Exception ex1)
			{
				ex1.printStackTrace();
			}
			finally
			{
				conn.close();
				statement.close();
				result.close();
			}
		}
		catch(Exception ex2)
		{
			ex2.printStackTrace();
		}
	%>
</table>
