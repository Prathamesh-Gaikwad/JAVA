import java.util.Scanner;

class prime
{
	public static void main(String args[])
	{
		int i;
		int j;
		int flag = 0;
				
		Scanner scanner = new Scanner(System.in);
		
		int size = Integer.parseInt(args[0]);
		
		int arr[] = new int[size];
		
		System.out.println("\nEnter " + size + " elements : ");
		for(i = 0; i < size; i++)
		{
			System.out.print("\nNumber " + (i+1) + " : ");
			arr[i] = scanner.nextInt();
		}
		
		for(i = 0; i < size; i++)
		{
			flag = 0;
			for(j = 2; j < arr[i]; j++)
			{
				if(0 == (arr[i] % j))
					flag = 1;
			}
			
			if(0 == flag)
				System.out.println("["+ arr[i] + " is prime number]");
		}
		
		scanner.close();
	}
}

