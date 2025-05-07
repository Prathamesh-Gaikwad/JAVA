class Nonsynchronization
{
	synchronized void display()
	{
		try
		{
			System.out.println("Come On");
			System.out.println("Students");
			System.out.println("Enjoy");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Book");
		System.out.println("Reading");
	}
}

class Test implements Runnable
{
	Thread thread;
	Nonsynchronization object;
	
	public Test(Nonsynchronization object)
	{
		this.object = object;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		object.display();
	}
}

public class slip30_synchronization
{
	public static void main(String args[])
	{
		Nonsynchronization object1 = new Nonsynchronization();
		
		Test object2 = new Test(object1);
		
		Test object3 = new Test(object1);
	}
}

