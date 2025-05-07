import java.util.Scanner;
import java.util.Hashtable;
import java.util.Enumeration;

public class slip5_hashtable
{
	public static void main(String args[])
	{
		int i;
		int size;
		String name;
		int contact;
		Scanner scanner;
		Enumeration obj;
		Hashtable<String, Integer> table;
		
		scanner = new Scanner(System.in);
		
		table = new Hashtable<String, Integer>();
		
		System.out.print("\n\tHow Many Student Records You Wanted To Insert : ");
		size = scanner.nextInt();
		
		for(i = 0; i < size; i++)
		{
			System.out.print("\n\t-->Enter Student Name : ");
			name = scanner.next();

			System.out.print("\n\t\tEnter Student Contact No : ");
			contact = scanner.nextInt();
			
			table.put(name, contact);
		}
		
		obj = table.elements();
		
		while(obj.hasMoreElements())
			System.out.println("\n\t" + obj.nextElement());
	}
}

