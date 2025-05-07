class RunnableThread implements Runnable
{
	private String name;
	private Thread thread;
	
	RunnableThread(String name)
	{
		this.name = name;
		System.out.println("\nRunnable Instance Created And Thread Name Set");
	}
	
	public void run()
	{
		System.out.println("\nRunning Thread " + name);
	}
	
	public void start()
	{
		System.out.println("\nStarting Thread " + name);
		
		thread = new Thread(this, name);
		thread.start();
	}
}

public class RunnableDemo
{
	public static void main(String args[])
	{
		RunnableThread rObj1 = new RunnableThread("Salaar-1");
		rObj1.start();

		RunnableThread rObj2 = new RunnableThread("Salaar-2");
		rObj2.start();		
	}
}
/*
	o/p:

		Runnable Instance Created And Thread Name Set

		Starting Thread Salaar-1

		Runnable Instance Created And Thread Name Set

		Starting Thread Salaar-2

		Running Thread Salaar-2

		Running Thread Salaar-1
*/

