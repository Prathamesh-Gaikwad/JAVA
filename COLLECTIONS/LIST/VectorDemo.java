import java.util.Vector;
import java.util.ArrayList;

public class VectorDemo
{
	public static void main(String args[])
	{
		Vector<Object> list = new Vector<Object>(5);
		
		System.out.println("\n\tSize : " + list.size());
		System.out.println("\n\tCapacity : " + list.capacity());
		
		list.addElement(25);
		list.addElement("Hello");
		list.addElement(25.45);
		list.addElement('A');

		System.out.println("\n\tSize : " + list.size());
		
		list.setSize(9);
		System.out.println("\n\tSize : " + list.size());
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(11);
		list1.add(12);
		list1.add(13);
		list1.add(14);
		
		list.addAll(list1);
		System.out.println("\n\tVector is : " + list);
		
		list.setElementAt(17, 3);

		System.out.println("\n\tUpdated Vector is : " + list);
		
		System.out.println("\n\tIs 14 present in Vector : " + list.contains(14));
		
		System.out.println("\n\tIs ArrayList present in Vector : " + list.containsAll(list1));
		
		System.out.println("\n\tElement At 5th index : " + list.elementAt(5));

		System.out.println("\n\tFirst Element Of Vector : " + list.firstElement());

		System.out.println("\n\tLast Element Of Vector : " + list.lastElement());

		System.out.println("\n\tElement At 2nd index(using get method) : " + list.get(2));

		System.out.println("\n\tIs Vector Empty : " + list.isEmpty());

		System.out.println("\n\tIs 12 Removed : " + list.removeElement(12));

		System.out.println("\n\tIs All ArrayList Element removed : " + list.removeAll(list1));
		
		list.setElementAt("Done", 3);
		
		System.out.println("\n\tVector is : " + list);

		System.out.println("\n\tSize : " + list.size());
		System.out.println("\n\tCapacity : " + list.capacity());
	}
}

/*
	o/p:

	Size : 0

	Capacity : 5

	Size : 4

	Size : 9

	Vector is : [25, Hello, 25.45, A, null, null, null, null, null, 11, 12, 13, 14]

	Updated Vector is : [25, Hello, 25.45, 17, A, null, null, null, null, null, 11, 12, 13, 14]

	Is 14 present in Vector : true

	Is ArrayList present in Vector : true

	Element At 5th index : null

	First Element Of Vector : 25

	Last Element Of Vector : 14

	Element At 2nd index(using get method) : 25.45

	Is Vector Empty : false

	Is 12 Removed : true

	Is All ArrayList Element removed : true

	Vector is : [25, Hello, 25.45, Done, null, null, null, null, null]

	Size : 9

	Capacity : 20	
*/
