public class ThreadDemo extends Thread
{
	private Thread thread;
	private String threadName;
	
	ThreadDemo(String name)
	{
		threadName = name;
		System.out.println("\n\t[Creating " + threadName + "]\n");
	}
	
	public void run()
	{
		System.out.println("\n\t-->[Running " + threadName + "]\n");
		
		try
		{
			for(int i = 4; i > 0; i--)
			{
				System.out.println("\n\t\t[Thread : " + threadName + " : " + i + "]\n");
				Thread.sleep(50);
			}
		}
		catch(InterruptedException exception)
		{
			exception.printStackTrace();
			System.out.println(exception);
		}
		
		System.out.println("\n\t[Thread " + threadName + " Exiting]\n");
	}
	
	public void start()
	{
		System.out.println("\n\t[Starting " + threadName + "]\n");
		
		if(null == thread)
		{
			thread = new Thread(this, threadName);
			thread.start();
		}
	}
	
	public static void main(String args[])
	{
		ThreadDemo tObj1 = new ThreadDemo("<Bhaag Milkha>");
		tObj1.start();
		
		ThreadDemo tObj2 = new ThreadDemo("<Usain Bolt>");
		tObj2.start();	
		
		System.out.println("\n\t" + tObj1);	
		System.out.println("\n\t" + tObj2);	
	}
}


