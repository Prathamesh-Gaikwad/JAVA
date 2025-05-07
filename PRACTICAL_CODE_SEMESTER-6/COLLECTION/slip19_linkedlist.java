import java.util.Scanner;
import java.util.LinkedList;

public class slip19_linkedlist
{
	public static void main(String args[])
	{
		int size;
		Object obj;
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();

		System.out.println("\n\tSize : ");
		size = scanner.nextInt();
		
		for(int i = 0; i < size; i++)
		{
			System.out.println("\n\tEnter Element " + (i+1) + " : ");
			list.add(scanner.nextInt());
		}
		
		for(int no : list)
		{
			if(no > 0)
				System.out.println("\n\t" + no);
		}
	}
}
