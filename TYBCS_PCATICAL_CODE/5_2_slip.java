import java.util.Scanner;

class ND_Array
{
	public static void main(String args[])
	{
		int i;
		int j;
		int rows;
		int cols;
		int choice;
		
		Scanner scanner = new Scanner(System.in);

		while(true)
		{
			System.out.println("------[MENU]------");
			System.out.println("1)Addition Of 2 2D Matrices.");
			System.out.println("2)Multiplication Of 2 2D Matrices.");
			System.out.println("3)Exit");
			
			System.out.print("Enter Your Choice : ");
			choice = scanner.nextInt();
			
			if(3 == choice)
				break;

			System.out.print("Enter Total Rows : ");
			rows = scanner.nextInt();

			System.out.print("Enter Total Columns : ");
			cols = scanner.nextInt();
			
			int arr1[][] = new int[rows][cols];
			
			System.out.println("Enter Array 1 : ");
			for(i = 0; i < rows; i++)
			{
				for(j = 0; j < cols; j++)
				{
					System.out.print("Enter Element  : ");
					arr1[i][j] = scanner.nextInt();
				}
			}
			
			int arr2[][] = new int[rows][cols];
			
			System.out.println("Enter Array 1 : ");
			for(i = 0; i < rows; i++)
			{
				for(j = 0; j < cols; j++)
				{
					System.out.print("Enter Element  : ");
					arr2[i][j] = scanner.nextInt();
				}
			}

			int arr3[][] = new int[rows][cols];			
				
			switch(choice)
			{
				case 1 :					
					for(i = 0; i < rows; i++)
					{
						for(j = 0; j < cols; j++)
						{
							arr3[i][j] = arr1[i][j] + arr2[i][j];
						}
					}
					
					System.out.println("Addition Of Two Matrices : ");
					for(i = 0; i < rows; i++)
					{
						for(j = 0; j < cols; j++)
						{
							System.out.print("\t" + arr3[i][j]);
						}
						System.out.println("\n");
					}				
					break;
					
				case 2 :
					for(i = 0; i < rows; i++)
					{
						for(j = 0; j < cols; j++)
						{
							arr3[i][j] = arr1[i][j] * arr2[i][j];
						}
					}

					System.out.println("Multiplication Of Two Matrices : ");
					for(i = 0; i < rows; i++)
					{
						for(j = 0; j < cols; j++)
						{
							System.out.print("\t" + arr3[i][j]);
						}
						System.out.println("\n");
					}					
					break;
					
				default :
					System.out.println("Invalid Choices");		
			}
		}
		
		scanner.close();		
	}
}

