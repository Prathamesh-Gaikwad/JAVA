import java.util.Random;

public class slip13_lifecycle implements Runnable
{
	private String name;
	private int time;
	
	public slip13_lifecycle(String name)
	{
		this.name = name;
		
		Random rand = new Random();
		
		time = rand.nextInt(5000);
	}
	
	public void run()
	{
		System.out.println(name + " created\n");
		
		try
		{
			Thread.sleep(time);
			System.out.println(name + "sleeps for " + time + " milliseconds.\n");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(name + " dead");
	}
	
	public static void main(String args[])
	{
		Thread thread1 = new Thread(new slip13_lifecycle("Thread-1"));

		Thread thread2 = new Thread(new slip13_lifecycle("Thread-2"));
		
		thread1.start();
		
		thread2.start();
		
		try
		{
			thread1.join();
			thread2.join();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("MAIN THREAD ENDED SUCCESSFULLY");
	}
}

