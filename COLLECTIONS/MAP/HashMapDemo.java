import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Collection;

public class HashMapDemo
{
	public static void main(String args[])
	{
		Set set;
		Object obj;
		int balance;
		Entry entry;
		Iterator move;
		Collection<Integer> values;
		HashMap<String, Integer> map;
		
		
		map = new HashMap<String, Integer>();
		
		map.put("Rohan", 74);
		map.put("Sanket", 73);
		map.put("Aniket", 70);
		map.put("Omkar", 77);
		map.put("Akshay", 85);
		map.put(null, 87);
		map.put(null, 89);
		map.put("Akash", null);
		map.put("Prathamesh", null);
		
		set = map.entrySet();
		
		move = set.iterator();
		while(move.hasNext())
		{
			entry = (Entry)move.next();
			System.out.println("\t" + entry.getKey() + " : " + entry.getValue());
		}
		
		balance = (Integer)map.get("Rohan");
		balance = (Integer)map.put("Rohan", balance + 10);
		System.out.println("\n\tRohan [old marks] : " + balance);
		System.out.println("\tRohan [new marks] : " + (Integer)map.get("Rohan"));
		
		values = map.values();
		System.out.println("\n\tValues : " + values);

		set = map.keySet();
		System.out.println("\n\tKeySet : " + set);
		
		System.out.println("\n\tTotal Elements in HashMap : " + map.size());
		
		obj = map.clone();
		System.out.println("\n\tClone Object : " + obj);
		
		System.out.println("\n\tIt Contains \"Rohan\" ? : " + map.containsKey("Rohan"));
		System.out.println("\n\tIt Contains \"Rohan's\" Marks ? : " + map.containsValue(84));

		System.out.println("\n\t\"Rohan's\" Marks : " + map.get("Rohan"));

		System.out.println("\n\t\"Rohan's\" Record Removed : " + map.remove("Rohan"));

		map.clear();		
		System.out.println("\n\tIs Map Empty : " + map.isEmpty());
	}
}
/*
	HashMapDemo.java:10: warning: [rawtypes] found raw type: Set
			Set set;
			^
	  missing type arguments for generic class Set<E>
	  where E is a type-variable:
	    E extends Object declared in interface Set
	HashMapDemo.java:12: warning: [rawtypes] found raw type: Entry
			Entry entry;
			^
	  missing type arguments for generic class Entry<K,V>
	  where K,V are type-variables:
	    K extends Object declared in interface Entry
	    V extends Object declared in interface Entry
	HashMapDemo.java:14: warning: [rawtypes] found raw type: Iterator
			Iterator move;
			^
	  missing type arguments for generic class Iterator<E>
	  where E is a type-variable:
	    E extends Object declared in interface Iterator
	HashMapDemo.java:33: warning: [cast] redundant cast to Integer
			balance = (Integer)map.get("Rohan");
				  ^
	HashMapDemo.java:34: warning: [cast] redundant cast to Integer
			balance = (Integer)map.put("Rohan", balance + 10);
				  ^
	HashMapDemo.java:36: warning: [cast] redundant cast to Integer
			System.out.println("\tRohan [new marks] : " + (Integer)map.get("Rohan"));		
				                                      ^
	6 warnings
*/
