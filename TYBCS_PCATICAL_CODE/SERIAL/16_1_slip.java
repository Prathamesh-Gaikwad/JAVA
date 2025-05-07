interface Square
{
	public abstract void square(int number);
}

class SquareNo
{
	public static void main(String args[])
	{
		//lambda expression[param]...[definition]
		Square operation = number -> System.out.println("Square : " + (number*number));
		
		operation.square(25);
	}
}
