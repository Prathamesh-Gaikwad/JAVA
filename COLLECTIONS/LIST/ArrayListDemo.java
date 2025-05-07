import java.util.List;
import java.util.ArrayList;

public class ArrayListDemo
{
	public static void main(String args[])
	{
		Object string;
		
		ArrayList list1 = new ArrayList();
		System.out.println("\n\tSize Of List 1 : " + list1.size());
		
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		ArrayList list2 = new ArrayList(list1);
		System.out.println("\n\tSize Of List 2 : " + list2.size());

		ArrayList list3 = new ArrayList(10);
		
		list3.add("Prathamesh");
		list3.add(list2);
		
		list1.clear();
		System.out.println("\n\tIs List 1 clear : " + list1);
		
		string = list3.clone();
		System.out.println("\n\tClone is : " + string);
		
		list3.ensureCapacity(20);
		System.out.println("\n\tList 3 is : " + list3);
		
		//list3.removeRange(3, 8);					//from[inclusive] and to[exclusive]
		//System.out.println("\n\tList 3 is : " + list3);

		list3.trimToSize();
		System.out.println("\n\tList 3 is : " + list3);
		
		System.out.println("\n\tList3 size : " + list3.size());		
	}
}
/*
	o/p : 

	Size Of List 1 : 0

	Size Of List 2 : 3

	Is List 1 clear : []

	Clone is : [Prathamesh, [10, 20, 30]]

	List 3 is : [Prathamesh, [10, 20, 30]]

	List 3 is : [Prathamesh, [10, 20, 30]]

	List3 size : 2	
*/

