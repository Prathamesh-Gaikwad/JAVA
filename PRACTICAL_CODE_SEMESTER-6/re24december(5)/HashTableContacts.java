import java.util.Set;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.Map.Entry;

public class HashTableContacts
{
	public static void main(String args[])
	{
		int i;
		int size;
		Set set;
		String name;
		int contact;
		Iterator move;
		Entry entry;
		Scanner scanner;
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
		
		set = table.entrySet();
		
		move = set.iterator();
		
		while(move.hasNext())
		{
			entry = (Entry)move.next();
						
			System.out.println("\n\tName : " + entry.getKey() + " \tContact : " + entry.getValue());
		}
	}
}
/*
	  How Many Student Records You Wanted To Insert : 4

        -->Enter Student Name : Ram

                Enter Student Contact No : 98654387

        -->Enter Student Name : Bharat

                Enter Student Contact No : 98765409

        -->Enter Student Name : Laxman

                Enter Student Contact No : 91654387

        -->Enter Student Name : Shtrughna

                Enter Student Contact No : 98765437

        Name : Shtrughna        Contact : 98765437

        Name : Laxman   Contact : 91654387

        Name : Bharat   Contact : 98765409

        Name : Ram      Contact : 98654387
*/
