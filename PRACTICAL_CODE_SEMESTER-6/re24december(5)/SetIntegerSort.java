import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;

public class SetIntegerSort
{
	public static void main(String args[])
	{
		int i;
		int no;
		int size;
		Iterator move;
		Scanner scanner;
		TreeSet<Integer> set;
		
		scanner = new Scanner(System.in);
		
		set = new TreeSet<Integer>();
		
		System.out.print("\n\tEnter Total Element Size : ");
		size = scanner.nextInt();
		
		for(i = 0; i < size; i++)
		{
			System.out.print("\n\tEnter No " + (i+1) + " : ");
			no = scanner.nextInt();
			
			set.add(no);
		}
		
		move = set.iterator();
		
		System.out.println("\n\tSorted Elements : ");
		while(move.hasNext())
			System.out.print("\t" + move.next());
			
		scanner.close();
	}
}
