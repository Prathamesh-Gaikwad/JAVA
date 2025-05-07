import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorDemo
{
	public static void main(String args[])
	{
		int index = 0;
		String element = null;
		ListIterator<String> move;
		ArrayList<String> array = new ArrayList<String>();
		
		array.add("Hii");
		array.add("Namaskar");
		array.add("Hello");
		array.add("JaiJinendra");
		array.add("NamoBoudhay");
		
		move = array.listIterator();
		
		System.out.println("\n\t[Forward Direction]");
		while(move.hasNext())
		{
			index = move.nextIndex();
			element = move.next();
			System.out.println("\n\t\tElement " + index + " :" + element);
		}

		System.out.println("\n\t[Backward Direction]");
		while(move.hasPrevious())
		{
			index = move.previousIndex();
			element = move.previous();
			System.out.println("\n\t\tElement " + index + " :" + element);
		}
		
		System.out.println("\n\tHas Next Element : " + move.hasNext() + " Which is : " + move.next());
		
		move.add("Ram Krushna Hari");
		move.previous();
		System.out.println("\n\tand ADD this at front : " + move.next());

		while(move.hasNext())
		{
			index = move.nextIndex();
			element = move.next();
			if("Hello" == element)
			{
				move.set("Wadkkam");
				move.hasPrevious();
				move.previous();
				continue;
			}
			
			System.out.println("\n\t\tElement " + index + " :" + element);
		}
		
		move.hasPrevious();
		move.previous();
		move.remove();
		
		System.out.println("\n\tHas Previous Element : " + move.hasPrevious() + " Which is : " + move.previous());
		/*
			after calling previous(), index for next element is moved at previous element..
		*/
		
		while(move.hasPrevious())
			move.previous();

		System.out.println("\n\t[Forward Direction]");
		while(move.hasNext())
		{
			index = move.nextIndex();
			element = move.next();
			System.out.println("\n\t\tElement " + index + " :" + element);
		}
	}
}

/*
	o/p:

	[Forward Direction]

		Element 0 :Hii

		Element 1 :Namaskar

		Element 2 :Hello

		Element 3 :JaiJinendra

		Element 4 :NamoBoudhay

	[Backward Direction]

		Element 4 :NamoBoudhay

		Element 3 :JaiJinendra

		Element 2 :Hello

		Element 1 :Namaskar

		Element 0 :Hii

	Has Next Element : true Which is : Hii

	and ADD this at front : Ram Krushna Hari

		Element 2 :Namaskar

		Element 3 :Wadkkam

		Element 4 :JaiJinendra

		Element 5 :NamoBoudhay

	Has Previous Element : true Which is : JaiJinendra

	[Forward Direction]

		Element 0 :Hii

		Element 1 :Ram Krushna Hari

		Element 2 :Namaskar

		Element 3 :Wadkkam

		Element 4 :JaiJinendra	
*/
