
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;

public class Slip19
{
	public static void main(String args[])
	{
		int size;
		Iterator move;
		Scanner scanner;
		LinkedList<Integer> list;
		
		scanner = new Scanner(System.in);
		
		System.out.println("\n\tHow Many Numbers You Wanted To Enter : ");
		size = scanner.nextInt();
		
		list = new LinkedList<Integer>();
		
		for(int i = 0; i < size; i++)
		{
			System.out.println("\n\tEnter Number : ");
			list.add(scanner.nextInt());
		}
		
		System.out.println("\n\tLinkedList Elements Are : " + list);
		
		System.out.println("\n\tNegative Numbers : ");
		
		move = list.iterator();
		while(move.hasNext())
		{
			size = ((Integer)move.next()).intValue();
			if(size < 0)
				System.out.println(size);
		}
	}
}
