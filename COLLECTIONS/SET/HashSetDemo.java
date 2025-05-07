import java.util.HashSet;

public class HashSetDemo
{
	public static void main(String args[])
	{
		Object obj;
		HashSet<Integer> hash;
		int count[] = {34, 22, 10, 60, 30, 22};
			
		hash = new HashSet<Integer>();
		
		try
		{
			for(int i = 0; i < 5; i++)
				hash.add(count[i]);
			
			System.out.println("\n\tHashSet : " + hash);
			System.out.println("\n\tIs HashSet Contains 60 : " + hash.contains(60));
			System.out.println("\n\tIs HashSet Empty : " + hash.isEmpty());
			
			hash.remove(60);
			System.out.println("\n\tHashSet : " + hash);
			
			System.out.println("\n\tHashSet size : " + hash.size());
			
			obj = hash.clone();						
			System.out.println("\n\tHashSet clone Object is : " + obj);
		}		
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}

