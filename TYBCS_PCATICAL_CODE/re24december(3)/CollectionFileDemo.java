import java.io.*;
import java.util.*;

public class CollectionFileDemo
{
	public static void main(String args[])
	{
		String a;
		Scanner s;
		String str;
		Scanner sc;
		String no = "10";
		String strarray[];
		String name = null;
		StringTokenizer st;
		FileInputStream fis = null;
		Hashtable<String, String> ht;
		
		try
		{
			
			ht = new Hashtable<String, String>();
			sc = new Scanner(fis).useDelimiter("\t");
			fis = new FileInputStream("myPhone.txt");
			
			System.out.println("\n\t[Name]	 	[Phone Number]");
			
			while(sc.hasNext())
			{
				a = sc.nextLine();
				st = new StringTokenizer(a, "\t");
				
				while(st.hasMoreTokens())
				{
					if(st.countTokens()== 2)
						name = st.nextToken();
					
					if(st.countTokens()== 1)
						no = st.nextToken();

					ht.put(name, no);
					System.out.println("\n\t" + name + "\t" + no);
				}
			}
			
			s = new Scanner(System.in);

			System.out.println("\tEnter Name As Given In Phone Book : ");
			str = s.next();
			
			if(ht.containsKey(str))
				System.out.println("Phone No is : " + ht.get(str));
			else
				System.out.println("Name Is Not Matched");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}		
	}
}
