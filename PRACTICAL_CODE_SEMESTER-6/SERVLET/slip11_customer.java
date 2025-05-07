import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class slip11_customer extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int no;
		PrintWriter writer;
		
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		response.setContentType("text/html");
		
		no = Integer.parseInt(request.getParameter("number"));
		
		writer = response.getWriter();
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				statement = conn.prepareStatement("select * from employee where id = ?;");
				
				statement.setInt(1, no);
				
				result = statement.executeQuery();
				
				if(result.next())
				{
					writer.println("--------------EMPLOYEE DETAILS--------------<br/>");
					writer.println("Employee ID : " + result.getInt(1) + "<br/>");
					writer.println("Employee NAME : " + result.getString(2)+ "<br/>");
					writer.println("Employee POSITION : " + result.getString(3)+ "<br/>");
					writer.println("Employee WORKING HOUR : " + result.getInt(4)+ "<br/>");
					writer.println("--------------------------------------------<br/>");
				}
				else
				{
					writer.println("EMPLOYEE NOT FOUND");
					response.sendRedirect("slip11_customer.html");
				}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			finally
			{
				conn.close();
				statement.close();
				result.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
