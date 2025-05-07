import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.LinkedHashMap;

public class LinkedHashMapDemo
{
	public static void main(String args[])
	{
		Set set;
		Entry entry;
		Iterator move;
		LinkedHashMap<String, Integer> linked;
		
		linked = new LinkedHashMap<String, Integer>(10, 0.25f, true);		//order depends on access of elements..
		
		linked.put("A.R.", 411004);
		linked.put("Aundh", 411007);
		linked.put("Bajirao Road", 411002);
		linked.put("Bhosari", 411026);
		linked.put("Chinchwad", 411019);
		
		System.out.println("\n\t\tAundh :" + linked.get("Aundh"));
		System.out.println("\n\t\tBajirao Road : " + linked.get("Bajirao Road"));
		System.out.println("\n\t\tChinchwad : " + linked.get("Chinchwad"));
		
		System.out.println("\n\tLinkedHashMap : ");
		set = linked.entrySet();
		
		move = set.iterator();
		while(move.hasNext())
		{
			entry = (Entry)move.next();
			System.out.println("\n\t\t" + entry.getKey() + " : " + entry.getValue());
		}
	}
}
