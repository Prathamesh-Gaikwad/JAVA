import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class slip27_inactive extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int out = 3600;
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(out);
		
		response.setContentType("text/html");
		
		response.getWriter().println("SESSION INACTIVE TIME HAS BEEN CHANGED TO " + out + "SECONDS");
	}
}

