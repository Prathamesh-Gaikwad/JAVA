import java.util.Scanner;

class Diagonal
{
	public static void main(String args[])
	{
		int sum = 0;
		int counter1;
		int counter2;
		
		Scanner scanner = new Scanner(System.in);
		
		int arr[][] = new int[3][3];
				
		for(counter1 = 0; counter1 < 3; counter1++)
		{
			for(counter2 = 0; counter2 < 3; counter2++)
			{
				System.out.print("\nEnter arr[" + counter1 + "][" + counter2 + "]" + " : ");
				arr[counter1][counter2] = scanner.nextInt();
				
				if(counter1 == counter2)
				{
					sum = sum + arr[counter1][counter2];
				}
			}
		}
		
		System.out.println("\t----[MATRIX]----");
		for(counter1 = 0; counter1 < 3; counter1++)
		{			
			for(counter2 = 0; counter2 < 3; counter2++)
			{
				System.out.print("\t" + arr[counter1][counter2]);
			}
			
			System.out.print("\n");
		}
		
		System.out.println("\nSum Of Diagonal Elements : " + sum);
		
		scanner.close();
	}
}

