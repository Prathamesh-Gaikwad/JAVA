class Chat
{
	boolean flag = false;
	
	public synchronized void Question(String msg, Thread thread)
	{
		if(flag)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("\n\t[" + thread.getName() + "] : " + msg);
		
		flag = true;
		
		notify();
	}

	public synchronized void Answer(String msg, Thread thread)
	{
		if(!flag)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("\t\t\t\t\t\t" + msg + " : [" + thread.getName() + "]");
		
		flag = false;
		
		notify();
	}
}

class Thread1 implements Runnable
{
	Chat bot;
	String s1[] = {"Hii", "How Are You?", "I am also doing fine!"};
	
	public Thread1(Chat bot)
	{
		this.bot = bot;
		
		Thread thread = new Thread(this, "Rakesh");
		
		thread.start();
	}
	
	public void run()
	{
		for(int i = 0; i < s1.length; i++)
			bot.Question(s1[i], Thread.currentThread());
	}
}

class Thread2 implements Runnable
{
	Chat bot;
	String s2[] = {"Hii", "I am good, What about you?", "Great!"};
	
	public Thread2(Chat bot)
	{
		this.bot = bot;
		
		Thread thread = new Thread(this, "Ronak");
		
		thread.start();
	}
	
	public void run()
	{
		for(int i = 0; i < s2.length; i++)
			bot.Answer(s2[i], Thread.currentThread());
	}
}

public class InterThreadCommunication
{
	public static void main(String args[])
	{
		Chat bot = new Chat();
		
		Thread1 tObj1 = new Thread1(bot);

		Thread2 tObj2 = new Thread2(bot);
	}
}
/*
	(pahila konta thread execute hoel yaach confirmation naahiye answer pan pahila call hou shakto.. tya sathi donhi methods madhe if block aahe)
	
	o/p:
	
	[Rakesh] : Hii
						Hii : [Ronak]

	[Rakesh] : How Are You?
						I am good, What about you? : [Ronak]

	[Rakesh] : I am also doing fine!
						Great! : [Ronak]
*/

