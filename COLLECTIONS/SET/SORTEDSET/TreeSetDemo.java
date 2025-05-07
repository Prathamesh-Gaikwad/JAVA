import java.util.TreeSet;
import java.util.SortedSet;
import java.util.LinkedList;

public class TreeSetDemo
{
	public static void main(String args[])
	{
		Object obj;
		String string;
		SortedSet<String> set;
		TreeSet<String> sorted;
		LinkedList<String> list;
		
		list = new LinkedList<String>();
		
		list.add("Pen");
		list.add("Eraser");
		list.add("Pad");
		list.add("Book");
		list.add("Bag");
		list.add("WaterBottle");
		list.add("Tiffin");

		System.out.println("\n\tLinkedList is : " + list);
		
		sorted = new TreeSet<String>();
		
		sorted.add("Laptop");
		sorted.add("Pendrive");
		sorted.add("KeyBoard");
		sorted.add("Mouse");
		sorted.add("Internet Provider");
		
		sorted.addAll(list);
		
		System.out.println("\n\tTreeSet is : " + sorted);
		
		string = (String)sorted.clone();
		System.out.println("\n\tClone Object Of TreeSet is : " + string);

		string = (String)sorted.first();
		System.out.println("\n\tFirst Object Of TreeSet is : " + string);

		string = (String)sorted.last();
		System.out.println("\n\tLast Object Of TreeSet is : " + string);
		
		set = sorted.headSet("Pustak");
		System.out.println("\n\tSubSet Less Than \"Pustak\" Of TreeSet is : " + set);

		set = sorted.tailSet("Pustak");
		System.out.println("\n\tSubSet Greater Than \"Pustak\" Of TreeSet is : " + set);
		
		set = sorted.subSet("Bag", "WaterBottle");
		System.out.println("\n\tSubSet from \"Bag\" to \"WaterBottle\" Of TreeSet is : " + set);		
	}
}

/*
	o/p:

	LinkedList is : [Pen, Eraser, Pad, Book, Bag, WaterBottle, Tiffin]

	TreeSet is : [Bag, Book, Eraser, Internet Provider, KeyBoard, Laptop, Mouse, Pad, Pen, Pendrive, Tiffin, WaterBottle]

	Clone Object Of TreeSet is : [Bag, Book, Eraser, Internet Provider, KeyBoard, Laptop, Mouse, Pad, Pen, Pendrive, Tiffin, WaterBottle]

	First Object Of TreeSet is : Bag

	Last Object Of TreeSet is : WaterBottle

	SubSet Less Than "Pustak" Of TreeSet is : [Bag, Book, Eraser, Internet Provider, KeyBoard, Laptop, Mouse, Pad, Pen, Pendrive]

	SubSet Greater Than "Pustak" Of TreeSet is : [Tiffin, WaterBottle]

	SubSet from "Bag" to "WaterBottle" Of TreeSet is : [Bag, Book, Eraser, Internet Provider, KeyBoard, Laptop, Mouse, Pad, Pen, Pendrive, Tiffin]	
*/
