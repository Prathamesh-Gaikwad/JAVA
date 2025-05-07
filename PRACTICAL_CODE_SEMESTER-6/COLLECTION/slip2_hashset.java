import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;

public class slip2_hashset
{
	public static void main(String args[])
	{
		short count;
		Scanner scanner = new Scanner(System.in);
		HashSet<String> hash = new HashSet<String>();

		System.out.print("\n\tTotal Name Size : ");
		count = scanner.nextShort();
		
		try
		{
			for(short i = 0; i < count; i++)
			{
				System.out.print("\n\tEnter Name " + (i+1) + " : ");
				hash.add(scanner.next());
			}

			TreeSet<String> tree = new TreeSet<String>(hash);
			
			for(String name : tree)
				System.out.println("\n\t" + name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
	}
}

