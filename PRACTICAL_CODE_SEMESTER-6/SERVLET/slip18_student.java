import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class slip18_student extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		PrintWriter writer = null;
		
		response.setContentType("text/html");
		
		writer = response.getWriter();
		
		String no  = request.getParameter("no");
		String name = request.getParameter("name");
		String _class = request.getParameter("class");
		int mark = Integer.parseInt(request.getParameter("marks"));
		String grade = null;
		
		double percent = (mark/600.0)*100;
		
		if(percent >= 90)
			grade = "A+";
		else if(percent >= 80)
			grade = "A";
		else if(percent >= 70)
			grade = "B";
		else if(percent >= 60)
			grade = "C";
		else
			grade = "D";
			
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<h2>STUDENT DETAILS</h2>");
		writer.println("<body>");
		writer.println("<p>SEAT NO : " + no + "</p>");
		writer.println("<p>STUDENT NAME : " + name + "</p>");
		writer.println("<p>STUDENT CLASS : " + _class + "</p>");
		writer.println("<p>STUDENT MARKS : " + mark + "</p>");
		writer.println("<p>PERCENTAGE : " + percent + "</p>");
		writer.println("<p>GRADE : " + grade + "</p>");
		writer.println("</body></html>");
	}
}
