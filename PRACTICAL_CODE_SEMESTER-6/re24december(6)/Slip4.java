import java.util.Scanner;
import java.util.Hashtable;

public class Slip4
{
	public static void main(String args[])
	{
		int i;
		int size;		
		int stdCode;
		Scanner scanner;
		StringBuilder city;
		Hashtable<String, Integer> table;
		
		city = new StringBuilder();
		
		scanner = new Scanner(System.in);

		table = new Hashtable<String, Integer>();

		System.out.print("\n\tEnter No. Of Records : ");
		size = scanner.nextInt();
		
		//move to next line in scanner buffer
		scanner.nextLine();
				
		for(i = 0; i < size; i++)
		{
			System.out.print("\n\tEnter City Name : ");
			city.replace(0, city.length(), scanner.nextLine());

			System.out.print("\n\tEnter STD Code : ");
			stdCode = scanner.nextInt();
						
			table.put(city.toString(), stdCode);

			//move to next line in scanner buffer
			scanner.nextLine();
		}
		
		System.out.println("\n\tHashTable : " + table);
		
		System.out.print("\n\tEnter City Name To Be Search : ");
		city.replace(0, city.length(), scanner.nextLine());
		
		if(table.containsKey(city.toString()))
			System.out.println("\n\tSTD Code Of City : " + city + " is " + table.get(city.toString()));
		else
			System.out.println("\n\tCity Not Found");
		
		System.out.print("\n\tEnter City Name To Be Remove : ");
		city.replace(0, city.length(), scanner.nextLine());
				
		table.remove(city.toString());
		
		System.out.println("\n\tAfter Removing City " + city + " Remaining Data : " + table);
	}
}
