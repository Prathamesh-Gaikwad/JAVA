class ConcurrentSuper extends Thread
{
	ConcurrentSuper(String name)
	{
		super(name);
	}
		
	public void run()
	{
		System.out.println("\nRunning : " + Thread.currentThread());
		
		try
		{
			for(int i = 1; i < 5; i++)
			{
				System.out.println("\nIteration " + i + " of : " + Thread.currentThread());
				Thread.sleep(500);
			}
		}
		catch(Exception e)
		{
			System.out.println("\nThread " + Thread.currentThread() + " Interrupted");
		}
		
		System.out.println("\nExiting " + Thread.currentThread());
	}
}

public class superRunningMultipleThread
{
	public static void main(String args[])
	{
		ConcurrentSuper cObj1 = new ConcurrentSuper("Salaar-1");
		ConcurrentSuper cObj2 = new ConcurrentSuper("Salaar-2");
		ConcurrentSuper cObj3 = new ConcurrentSuper("Salaar-3");

		cObj1.start();
		cObj2.start();
		cObj3.start();
		
		System.out.println("\nRunning : " + Thread.currentThread());
		
		try
		{
			for(int i = 1; i < 5; i++)
			{
				System.out.println("\nIteration " + i + " of : " + Thread.currentThread());
				Thread.sleep(500);
			}
		}
		catch(Exception e)
		{
			System.out.println("\nThread " + Thread.currentThread() + " Interrupted");
		}
		
		System.out.println("\nExiting " + Thread.currentThread());		
	}
}
/*
	o/p:
	
	Running : Thread[#18,Salaar-1,5,main]

	Running : Thread[#19,Salaar-2,5,main]

	Running : Thread[#1,main,5,main]

	Running : Thread[#20,Salaar-3,5,main]

	Iteration 1 of : Thread[#20,Salaar-3,5,main]

	Iteration 1 of : Thread[#18,Salaar-1,5,main]

	Iteration 1 of : Thread[#1,main,5,main]

	Iteration 1 of : Thread[#19,Salaar-2,5,main]

	Iteration 2 of : Thread[#18,Salaar-1,5,main]

	Iteration 2 of : Thread[#20,Salaar-3,5,main]

	Iteration 2 of : Thread[#19,Salaar-2,5,main]

	Iteration 2 of : Thread[#1,main,5,main]

	Iteration 3 of : Thread[#20,Salaar-3,5,main]

	Iteration 3 of : Thread[#18,Salaar-1,5,main]

	Iteration 3 of : Thread[#19,Salaar-2,5,main]

	Iteration 3 of : Thread[#1,main,5,main]

	Iteration 4 of : Thread[#20,Salaar-3,5,main]

	Iteration 4 of : Thread[#18,Salaar-1,5,main]

	Iteration 4 of : Thread[#19,Salaar-2,5,main]

	Iteration 4 of : Thread[#1,main,5,main]

	Exiting Thread[#20,Salaar-3,5,main]

	Exiting Thread[#18,Salaar-1,5,main]

	Exiting Thread[#19,Salaar-2,5,main]

	Exiting Thread[#1,main,5,main]

*/
