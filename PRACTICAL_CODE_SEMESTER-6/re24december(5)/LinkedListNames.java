import java.util.Scanner;
import java.util.LinkedList;

public class LinkedListNames
{
	public static void main(String args[])
	{
		int i;
		int size;
		String friend;
		Scanner scanner;
		LinkedList<String> list;
		
		scanner = new Scanner(System.in);
		
		System.out.print("\n\tHow Many Friend's Name You Wanted To Insert : ");
		size = scanner.nextInt();
		
		list = new LinkedList<String>();
		
		for(i = 0; i < size; i++)
		{
			System.out.print("\n\t-->Enter Friend Name : ");
			friend = scanner.next();
			
			list.add(friend);
		}
		
		System.out.println("\n\tMy Friends : " + list);
		
		scanner.close();
	}
}
/*
       How Many Friend's Name You Wanted To Insert : 5

        -->Enter Friend Name : Ajay

        -->Enter Friend Name : Santosh

        -->Enter Friend Name : Nihar

        -->Enter Friend Name : Utkarsh

        -->Enter Friend Name : Krishna

        My Friends : [Ajay, Santosh, Nihar, Utkarsh, Krishna]	
*/
