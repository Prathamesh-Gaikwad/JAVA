import java.util.Hashtable;
import java.util.Enumeration;

public class HashTableDemo
{
	public static void main(String args[])
	{
		Object obj;
		Enumeration _enum;
		Hashtable<Integer, String> table;
		
		table = new Hashtable<Integer, String>();
		
		table.put(1, "January");
		table.put(2, "February");
		table.put(3, "March");
		table.put(4, "April");
		table.put(5, "May");
		table.put(6, "June");
		//table.put(null, "October");		//java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "key" is null
		//table.put(7, null);			//java.lang.NullPointerException
		//table.put(8, null);			//java.lang.NullPointerException
		
		System.out.println("\n\tTotal Elements in Hashtable : " + table.size());

		obj = table.clone();
		System.out.println("\n\tClone Object : " + obj);
		
		System.out.println("\n\tIt Contains \"3\" ? : " + table.containsKey(3));
		System.out.println("\n\tIt Contains \"February's\" Index ? : " + table.containsValue("February"));

		System.out.println("\n\t\"5th Month's\" Name : " + table.get(5));

		System.out.println("\n\t\"4th Month's\" Record Removed : " + table.remove(4));

		System.out.println("\n\tValue Set : ");		
		_enum = table.elements();
		while(_enum.hasMoreElements())
			System.out.println("\n\t\t" + _enum.nextElement());
			
		System.out.println("\n\tKey Set : ");
		_enum = table.keys();
		while(_enum.hasMoreElements())
			System.out.println("\n\t\t" + _enum.nextElement());

		System.out.println("\n\tString Representation : " + table.toString());
		
		table.clear();		
		System.out.println("\n\tIs Table Empty : " + table.isEmpty());
	}
}
