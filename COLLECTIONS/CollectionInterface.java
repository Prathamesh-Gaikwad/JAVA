import java.util.List;
import java.util.ArrayList;

public class CollectionInterface
{
	public static void main(String args[])
	{
		List list1 = new ArrayList();			// warning: [rawtypes] found raw type: List	[because unspecifying element type]
		
		//of type 'String'
		List<String> list2 = new ArrayList<String>();
		
		list1.add(10);
		list1.add(20);
		
		list2.add("Hii");
		list2.add("Hello");
		list2.add("Namskar");
		
		list1.addAll(list2);
		
		System.out.println("\n\tElements Of List 1 : " + list1);
		
		System.out.println("\n\tSearch For \"Hii\" : " + list1.contains("Hii"));
		
		System.out.println("\n\tSearch For All Elements Of List 2 in List 1 : " + list1.containsAll(list2));

		System.out.println("\n\tCheck Whether Both List 1 & List 2 are equal : " + list1.equals(list2));
		
		System.out.println("\n\tCheck List 1 is empty or not : " + list1.isEmpty());

		System.out.println("\n\tSize Of List 1  : " + list1.size());

		System.out.println("\n\tHashCode Of List 1 : " + list1.hashCode());

		System.out.println("\n\tAll Elements Of List 1 : " + list1);

		System.out.println("\n\tRemove 0th index element from List 1 : " + list1.remove(0));
		
		System.out.println("\n\tIs All Elements of List 1 Deleted Except elements of List 2 : " + list1.retainAll(list2));

		System.out.println("\n\tList 1 is : " + list1);

		System.out.println("\n\tRemove All Elements Of List 2 From List 1 : " + list1.removeAll(list2));

		System.out.println("\n\tList 1 is  : " + list1);

		list2.clear();		
		
		System.out.println("\n\tList 2 is Cleared : " + list2);		
	}
}

/*
	o/p:
	
	Elements Of List 1 : [10, 20, Hii, Hello, Namskar]

	Search For "Hii" : true

	Search For All Elements Of List 2 in List 1 : true

	Check Whether Both List 1 & List 2 are equal : false

	Check List 1 is empty or not : false

	Size Of List 1  : 5

	HashCode Of List 1 : 1358148238

	All Elements Of List 1 : [10, 20, Hii, Hello, Namskar]

	Remove 0th index element from List 1 : 10

	Is All Elements of List 1 Deleted Except elements of List 2 : true

	List 1 is : [Hii, Hello, Namskar]

	Remove All Elements Of List 2 From List 1 : true

	List 1 is  : []

	List 2 is Cleared : []	
*/

