import java.util.Random;

public class slip7_multithread extends Thread
{
	public void run()
	{
		int num;
		
		Random random = new Random();
		
		for(int i = 0; i < 10; i++)
		{
			num = random.nextInt(100);
			
			System.out.println("\n\tRandom Integer Generated : " + num);
			
			if((num % 2) == 0)
			{
				Square thread = new Square(num);
				thread.start();
			}
			else
			{
				Cube thread = new Cube(num);
				thread.start();			
			}
			
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[])
	{
		slip7_multithread parent = new slip7_multithread();
		parent.start();
	}
}

class Square extends Thread
{
	int n;
	
	public Square(int num)
	{
		n = num;
	}
	
	public void run()
	{
		System.out.println("\n\tSquare of " + n + " is : " + (n*n));
	}
}

class Cube extends Thread
{
	int n;
	
	public Cube(int num)
	{
		n = num;
	}
	
	public void run()
	{
		System.out.println("\n\tCube of " + n + " is : " + (n*n*n));
	}
}
