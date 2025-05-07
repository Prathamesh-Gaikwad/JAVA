import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo
{
	public static void main(String args[])
	{
		int no;
		Iterator move;
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		array.add(11);
		array.add(22);
		array.add(33);
		array.add(44);
		
		move  = array.iterator();
		
		//generate java.lang.IllegalStateException if call without calling hasNext or next.		
		//move.remove();
		
		while(move.hasNext())
		{
			no = (Integer)move.next();
			System.out.println("\n\tElement : " + no);
		}
	}
}

/*
	o/p:
	
	Element : 11

	Element : 22

	Element : 33

	Element : 44
*/

