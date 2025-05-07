import  java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class slip15_visit extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		int i;
		PrintWriter writer = null;
		
		try
		{            		
			response.setContentType("text/html");
			
			writer = response.getWriter();
			
			Cookie arr[] = request.getCookies();

			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>Visitor Counter</title>");
			writer.println("</head>");
			writer.println("<body>");
			
			if(arr == null)
			{
				writer.println("<b>WELCOME<b>");
				
				Cookie visit = new Cookie("count", "1");
				
				response.addCookie(visit);
			}
			else
			{
				for(i = 0; i < arr.length; i++)
				{
					String str = arr[i].getName();
					
					if(str.equals("count"))
					{
						String value = arr[i].getValue();
						
						int count = Integer.parseInt(value) + 1;
						
						writer.println("Page Visited For " + count + " Times");
						
						Cookie visit1 = new Cookie("count", Integer.toString(count));
						
						response.addCookie(visit1);
						break;
					}
				}
			}
			
			writer.println("</body>");
            		writer.println("</html>");
		}
		catch(Exception ex1)
		{
			ex1.printStackTrace();
		}
	}
}

