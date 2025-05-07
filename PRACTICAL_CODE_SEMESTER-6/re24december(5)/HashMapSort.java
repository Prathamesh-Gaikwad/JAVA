import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Random;

public class HashMapSort
{
	public static void main(String args[])
	{
		int i;
		int size;
		Random key;
		String value;
		Scanner scanner;
		TreeMap<Integer, String> tree;
		HashMap<Integer, String> hash;

		key = new Random();
		
		scanner = new Scanner(System.in);
		
		hash = new HashMap<Integer, String>();
				
		System.out.print("\n\tEnter Total Element Size : ");
		size = scanner.nextInt();
		
		for(i = 0; i < size; i++)
		{
			System.out.print("\n\tEnter No " + (i+1) + " : ");
			value = scanner.next();
			
			hash.put((i+key.nextInt()), value);
		}
		
		System.out.println("\n\tHashMap : " + hash);
		
		tree = new TreeMap<Integer, String>(hash);

		System.out.println("\n\tTreeMap : " + tree);
	}
}
