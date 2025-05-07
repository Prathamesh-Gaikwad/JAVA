import java.util.*;

class Horse implements Comparator<Horse>, Comparable<Horse>
{
	private String name;
	private int age;
	
	Horse()
	{

	}
	
	Horse(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String getHorseName()
	{
		return this.name;
	}

	public int getHorseAge()
	{
		return this.age;
	}
	
	public int compareTo(Horse hObj)
	{
		return (this.name).compareTo(hObj.name);
	}
	
	public int compare(Horse hObj1, Horse hObj2)
	{
		return hObj1.age - hObj2.age;
	}
}

public class ComparatorDemo
{
	public static void main(String args[])
	{
		List<Horse> list = new ArrayList<Horse>();
		
		list.add(new Horse("Jimmy", 10));
		list.add(new Horse("Sam", 20));
		list.add(new Horse("Rambo", 13));
		list.add(new Horse("Ransan", 18));
		list.add(new Horse("Devil", 11));
		
		System.out.println("Sorting Without Comparator : ");
		Collections.sort(list);
		
		for(Horse hObj : list)
			System.out.println("\tHorse Name : " + hObj.getHorseName() + " Horse Age : " + hObj.getHorseAge());

		System.out.println("Sorting With Comparator : ");
		Collections.sort(list, new Horse());
		
		for(Horse hObj : list)
			System.out.println("\tHorse Name : " + hObj.getHorseName() + " Horse Age : " + hObj.getHorseAge());
			
	}
}
