import java.util.Vector;
import java.util.Enumeration;

public class EnumerationDemo
{
	public static void main(String args[])
	{
		Enumeration days;
		Vector<String> vector;
		
		vector = new Vector<String>();
		
		vector.add("Sunday");
		vector.add("Monday");
		vector.add("Tuesday");
		vector.add("Wednesday");
		vector.add("Thursday");
		vector.add("Friday");
		vector.add("Saturday");
		
		days = vector.elements();
		
		while(days.hasMoreElements())
			System.out.println("\n\t" + days.nextElement());		
	}
}

