import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class slip23_linkedlist
{
	public static void main(String args[])
	{
		Iterator move;
		ListIterator<String> moveL;
		LinkedList<String> list = new LinkedList<String>();
		
		for(String str : args)
			list.add(str);
			
		move = list.iterator();
		
		while(move.hasNext())
			System.out.println("\n\t" + move.next());
			
		moveL = list.listIterator();
		
		while(moveL.hasNext())
			System.out.println("\n\t--->" + moveL.next());
			
		System.out.println("\n\tSize Of Linked List : " + list.size());
	}
}
