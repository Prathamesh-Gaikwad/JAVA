import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class slip2_servlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		PrintWriter writer;
		
		try
		{
			response.setContentType("Text/html");
			
			writer = response.getWriter();
			
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>REQUEST INFORMATION EXAMPLE</title>");
			writer.println("<h3>REQUEST INFORMATION EXAMPLE</h3>");
			writer.println("</head>");
			writer.println("<body>");		
			String osName = System.getProperty("os.name");
			writer.println("Server Name : " + request.getServerName() + "<br/>");
			writer.println("Operating System Name : " + osName + "<br/>");
			writer.println("Method : " + request.getMethod() + "<br/>");
			writer.println("Request URL : " + request.getRequestURL() + "<br/>");
			writer.println("Protocol : " + request.getProtocol() + "<br/>");
			writer.println("Path Info : " + request.getServletPath() + "<br/>");
			writer.println("Remote Address : " + request.getRemoteAddr() + "<br/>");
			writer.println("</body>");
			
			writer.println("</html>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
