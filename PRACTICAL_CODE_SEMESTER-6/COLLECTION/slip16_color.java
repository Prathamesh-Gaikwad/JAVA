import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;

public class slip16_color
{
	public static void main(String args[])
	{
		int i;
		int size;
		String color;
		Iterator move;
		Scanner scanner;
		TreeSet<String> set;
		
		scanner = new Scanner(System.in);
		
		set = new TreeSet<String>();
		
		System.out.print("\n\tHow Many Colors You Wanted Store Now : ");
		size = scanner.nextInt();
		
		for(i = 0; i < size; i++)
		{
			System.out.print("\n\tEnter Color " + (i+1) + " : ");
			color = scanner.next();
			
			set.add(color);
		}
		
		move = set.iterator();
		
		while(move.hasNext())
			System.out.println("\n\t-->Color : " + move.next());
			
		scanner.close();
	}
}
