import java.util.Stack;

public class StackDemo
{
	public static void main(String args[])
	{
		Stack<String> stack = new Stack<String>();
		
		System.out.println("\n\tIs Stack Empty : " + stack.empty());

		System.out.println("\n\tPushed Element Is : " + (String)stack.push("Fridge"));
		System.out.println("\n\tPushed Element Is : " + (String)stack.push("Mixer"));
		System.out.println("\n\tPushed Element Is : " + (String)stack.push("OTG"));
		System.out.println("\n\tPushed Element Is : " + (String)stack.push("Pressure Cooker"));
		System.out.println("\n\tPushed Element Is : " + (String)stack.push("Juicer"));
		
		System.out.println("\n\tTop Of The Stack Is : " + (String)stack.peek());

		System.out.println("\n\tOffset of \"Pressure Cooker\" : " + stack.search("Pressure Cooker"));

		System.out.println("\n\tOffset of \"Dosa Pan\" : " + stack.search("Dosa Pan"));
	
		System.out.println("\n\tStack : " + stack);

		System.out.println("\n\tPoped Element Is : " + (String)stack.pop());
		System.out.println("\n\tPoped Element Is : " + (String)stack.pop());
		System.out.println("\n\tPoped Element Is : " + (String)stack.pop());
		System.out.println("\n\tPoped Element Is : " + (String)stack.pop());
		System.out.println("\n\tPoped Element Is : " + (String)stack.pop());

		System.out.println("\n\tIs Stack Empty : " + stack.empty());		
	}
}

/*
	o/p:

	Is Stack Empty : true

	Pushed Element Is : Fridge

	Pushed Element Is : Mixer

	Pushed Element Is : OTG

	Pushed Element Is : Pressure Cooker

	Pushed Element Is : Juicer

	Top Of The Stack Is : Juicer

	Offset of "Pressure Cooker" : 2

	Offset of "Dosa Pan" : -1

	Stack : [Fridge, Mixer, OTG, Pressure Cooker, Juicer]

	Poped Element Is : Juicer

	Poped Element Is : Pressure Cooker

	Poped Element Is : OTG

	Poped Element Is : Mixer

	Poped Element Is : Fridge

	Is Stack Empty : true	
*/
