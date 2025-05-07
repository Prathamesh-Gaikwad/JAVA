import java.util.LinkedList;

class Person
{
	String name;
	int age;
	
	Person(String strName, int iAge)
	{
		name = strName;
		age = iAge;
	}
}

public class LinkedListPerson
{
	public static void main(String args[])
	{		
		Person pObj1 = new Person("Prathamesh", 23);
		Person pObj2 = new Person("Payal", 20);
		Person pObj3 = new Person("Shivani", 23);
		Person pObj4 = new Person("Utkarsh", 23);
		
		LinkedList<Person> list = new LinkedList<Person>();
		
		list.add(pObj1);
		list.add(pObj2);
		list.add(pObj3);
		list.add(pObj4);
		
		for(Person pObj : list)
		{
			System.out.println("\n\tName : " + pObj.name);
			System.out.println("\n\tAge : " + pObj.age);
			System.out.println("\n\t----------------\n");
		}
	}
}

/*
	o/p:

	Name : Prathamesh

	Age : 23

	----------------


	Name : Payal

	Age : 20

	----------------


	Name : Shivani

	Age : 23

	----------------


	Name : Utkarsh

	Age : 23

	----------------
	
*/
