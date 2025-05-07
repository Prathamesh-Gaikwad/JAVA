import java.util.LinkedHashSet;

public class LinkedHashSetDemo
{
	public static void main(String args[])
	{
		LinkedHashSet<Integer> list = new LinkedHashSet<Integer>();
		
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		
		System.out.println("\n\tInsertion Order Maintain in HashSet : " + list);
	}
}

