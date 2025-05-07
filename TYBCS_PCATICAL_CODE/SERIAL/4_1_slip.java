import java.util.Scanner;

class MD_Array
{
	public static void main(String args[])
	{
		int i;
		int j;
		int rows;
		int cols;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Rows : ");
		rows = scanner.nextInt();
		
		System.out.print(" Enter Columns : ");
		cols = scanner.nextInt();
		
		int arr[][] = new int[rows][cols];
		int arr1[][] = new int[cols][rows];
		
		System.out.print("Enter " + (rows*cols) + " Elements : \n");
		for(i = 0; i < rows; i++)
		{
			for(j = 0; j < cols; j++)
			{
				System.out.print("Enter Element : ");
				arr[i][j] = scanner.nextInt();
			}
		}
		
		for(i = 0; i < rows; i++)
		{
			for(j = 0; j < cols; j++)
			{
				arr1[j][i] = arr[i][j];
			}
		}
		
		for(int arr2[] : arr1)
		{
			for(int ele : arr2)
			{
				System.out.print(ele);
			}
			System.out.print("\n");
		}
		
		scanner.close();
	}
}
