import java.util.List;
import java.util.ArrayList;

public class ListInterface
{
	public static void main(String args[])
	{
		List<String> list3;
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		list1.add("Prathamesh");
		list1.add("Payal");
		list1.add("Shreya");
		list1.add("Utkarsh");
		
		list2.add("Hii");
		list2.add(1, "Hello");
		list2.add("Namaskar");
		list2.add("Namaskar");
		
		System.out.println("\n\tList 1 is : " + list1);

		System.out.println("\n\tObject of index 1 : " + list1.get(1));

		System.out.println("\n\tList 1 is : " + list1);

		System.out.println("\n\tList 2 is : " + list2);

		System.out.println("\n\tadd all elements of List 2 at index 1 : " + list1.addAll(1, list2));

		System.out.println("\n\tList 1 is : " + list1);

		System.out.println("\n\tFirst index of \"Namaskar\" : " + list1.indexOf("Namaskar"));

		System.out.println("\n\tindex of \"NamoBaudhay\" : " + list1.indexOf("NamoBaudhay"));

		System.out.println("\n\tLast index of \"Namaskar\" : " + list1.lastIndexOf("Namaskar"));

		System.out.println("\n\tRemove element at index 3 : " + list1.remove(3));

		System.out.println("\n\tSet Object \"Pranaam\" at index 5 : " + list1.set(5, "Pranaam"));

		System.out.println("\n\tList 1 is : " + list1);

		list3 = list1.subList(2, 7);

		System.out.println("\n\tSub List is : " + list3);		
	}
}
/*
	o/p :

	List 1 is : [Prathamesh, Payal, Shreya, Utkarsh]

	Object of index 1 : Payal

	List 1 is : [Prathamesh, Payal, Shreya, Utkarsh]

	List 2 is : [Hii, Hello, Namaskar, Namaskar]

	add all elements of List 2 at index 1 : true

	List 1 is : [Prathamesh, Hii, Hello, Namaskar, Namaskar, Payal, Shreya, Utkarsh]

	First index of "Namaskar" : 3

	index of "NamoBaudhay" : -1

	Last index of "Namaskar" : 4

	Remove element at index 3 : Namaskar

	Set Object "Pranaam" at index 5 : Shreya

	List 1 is : [Prathamesh, Hii, Hello, Namaskar, Payal, Pranaam, Utkarsh]

	Sub List is : [Hello, Namaskar, Payal, Pranaam, Utkarsh]	
*/
