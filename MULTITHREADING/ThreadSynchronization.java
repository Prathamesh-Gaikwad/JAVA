class SynchronizedDemo extends Thread
{
	String msg[] = {"Java", "Supports", "MultiThreading", "Concepts"};
	
	public void run()
	{
		display(Thread.currentThread());
		System.out.println("\nExiting " + Thread.currentThread());
	}
	
	synchronized void display(Thread thread)
	{
		for(int i = 0; i < 4 ; i++)
		{
			System.out.println("\nThread : " + thread.getName() + " " + msg[i]);
		}
	}
}

public class ThreadSynchronization
{
	public static void main(String args[])
	{
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		SynchronizedDemo sObj1 = new SynchronizedDemo();
		SynchronizedDemo sObj2 = new SynchronizedDemo();
		
		sObj1.setPriority(Thread.NORM_PRIORITY);
		sObj2.setPriority(Thread.MAX_PRIORITY);
		
		sObj1.start();
		sObj2.start();
		
		System.out.println("\nExiting " + Thread.currentThread());
	}
}
/*
	o/p:

		Exiting Thread[#1,main,1,main]

		Thread : Thread-1 Java

		Thread : Thread-1 Supports

		Thread : Thread-1 MultiThreading

		Thread : Thread-1 Concepts

		Exiting Thread[#19,Thread-1,10,main]

		Thread : Thread-0 Java

		Thread : Thread-0 Supports

		Thread : Thread-0 MultiThreading

		Thread : Thread-0 Concepts

		Exiting Thread[#18,Thread-0,5,main]	
*/

