import java.util.LinkedList;

public class slip3_linkedlist
{
	public static void main(String args[])
	{
		int size;
		Object obj;
		LinkedList<String> list = new LinkedList<String>();

		list.add("Hii");
		list.add("Hello");

		System.out.println("\n\tLinkedList Is : " + list);
		
		list.addLast("Bye");
		
		System.out.println("\n\tAfter Adding Element At Last LinkedList : " + list);

		list.removeFirst();
				
		System.out.println("\n\tAfter Deleting First Element Of LinkedList : " + list);
		
		list = list.reversed();
		System.out.println("\n\tLinkedList In Reverse : " + list);
	}
}
