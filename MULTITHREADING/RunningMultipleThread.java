class Concurrent extends Thread
{
	Concurrent()
	{
		start();
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

public class RunningMultipleThread
{
	public static void main(String args[])
	{
		Concurrent cObj = new Concurrent();
		
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
	
	Running : Thread[#18,Thread-0,5,main]

	Running : Thread[#1,main,5,main]

	Iteration 1 of : Thread[#18,Thread-0,5,main]

	Iteration 1 of : Thread[#1,main,5,main]

	Iteration 2 of : Thread[#1,main,5,main]

	Iteration 2 of : Thread[#18,Thread-0,5,main]

	Iteration 3 of : Thread[#1,main,5,main]

	Iteration 3 of : Thread[#18,Thread-0,5,main]

	Iteration 4 of : Thread[#1,main,5,main]

	Iteration 4 of : Thread[#18,Thread-0,5,main]

	Exiting Thread[#1,main,5,main]

	Exiting Thread[#18,Thread-0,5,main]

*/
