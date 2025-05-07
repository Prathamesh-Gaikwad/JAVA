import java.util.LinkedList;
import java.util.ArrayList;

public class LinkedListDemo
{
	public static void main(String args[])
	{
		int size;
		Object obj;
		LinkedList<Object> list = new LinkedList<Object>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();

		list.add("Hii");
		list.add("Hello");
		list.add(23);
		
		list.add(1, "NamoBaoudhay");
		
		list.addFirst("Namaskar");
		list.addLast("Bye");
		
		System.out.println("\n\tLinkedList : " + list);
				
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list.addAll(1, list1);
		list.addAll(list1);	

		System.out.println("\n\tAfter adding ArrayList LinkedList is : " + list);
		
		obj = list.clone();
		
		System.out.println("\n\tObject : " + obj);
		
		System.out.println("\n\tElement : " + list.element());		//only return head
		System.out.println("\n\tElement : " + list.element());		//only return head
		
		System.out.println("\n\tSize : " + list.size());
		
		size = list.size();
		
		/*
		//infinite loop for project...		
		for(int i = 0; true; i++)
		{
			System.out.println("\n\tElement : " + list.get(i));
			
			if(i == size - 1)
			{
				i = -1;
				
				for(int j = 0; j < 1000000000; j++)
					for(int k = 0; k < 1000000000; k++);
					
				System.out.println("\n\t-----------------\n");
			}
		}
		*/
		
		list.offer("Jai Jinendra");
		list.offerFirst("Jai Maharashtra");
		list.offerLast("Ram Krushna Hari");
		
		System.out.println("\n\tLinkedList : " + list);
		
		list = list.reversed();
		System.out.println("\n\tLinkedList : " + list);

		list.removeFirst();
		list.removeLast();		
		list.remove(3);
		System.out.println("\n\tLinkedList : " + list);

		Object array[] = list.toArray();
		
		for(Object ele : array)
			System.out.println("\n\tElement : " + ele);
	}
}

