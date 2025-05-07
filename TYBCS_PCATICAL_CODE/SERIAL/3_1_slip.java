import java.util.Scanner;

class CitySort
{
	public static void main(String args[])
	{
		int i;
		int size;
		String name;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Total City Count : ");
		size = scanner.nextInt();
		
		String city[] = new String[size];
		
		for(i = 0; i < size; i++)
		{
			System.out.print("Enter City " + (i+1) + " : ");
			city[i] = scanner.next();
		}
		
		for(i = 0; i < size-1; i++)
		{
			if(city[i].compareTo(city[i+1]) > 0)
			{
				name = city[i];
				city[i] = city[i+1];
				city[i+1] = name;
			}
		}
		
		for(String name1 : city)
		{
			System.out.println("City : " + name1);
		}
	}
}

