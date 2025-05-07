import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class slip19_login extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		PrintWriter writer = null;
		
		Connection conn = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		
		writer = response.getWriter();
		
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		try
		{
			try
			{
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Pratham@2002");
				
				statement = conn.prepareStatement("select password from users where username = ?;");
				
				statement.setString(1, name);
				
				result = statement.executeQuery();
				
				if(result.next())
				{
					if(result.getString(1).equals(pass))
						writer.println("<b>WELCOME </b>" + name);
					else
						writer.println("<b>PASSWORD IS INCORRECT</b>");
				}
				else
					writer.println("<b>USERNAME IS INCORRECT</b>");
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
	}
}

