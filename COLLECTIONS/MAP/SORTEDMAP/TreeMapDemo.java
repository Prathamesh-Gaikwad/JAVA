import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Map.Entry;

public class TreeMapDemo
{
	public static void main(String args[])
	{
		TreeMap<Integer, String> tree;
		SortedMap<Integer, String> map;
		
		tree = new TreeMap<Integer, String>();
		
		tree.put(2, "Tiger");
		tree.put(1, "Lion");
		tree.put(4, "Rabit");
		tree.put(5, "Ox");
		tree.put(3, "Crocodile");
		
		for(Entry entry : tree.entrySet())
			System.out.println("\n\t" + entry.getKey() + " : "+ entry.getValue());
			
		System.out.println("\n\tFirst Key : " + tree.firstKey());
		System.out.println("\n\tLast Key : " + tree.lastKey());
		
		map = tree.headMap(4);
		System.out.println("\n\tPortion [key < 4] : " + map);
		
		map = tree.subMap(2, 6);
		System.out.println("\n\tPortion [2 to 6] : " + map);

		map = tree.tailMap(3);
		System.out.println("\n\tPortion [from 3] : " + map);
	}
}

