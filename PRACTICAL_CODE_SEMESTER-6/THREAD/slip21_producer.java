class Q
{
	int n;
	boolean value = false;
	
	synchronized int get()
	{
		if(!value)
		{
			try
			{
				wait();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			
		System.out.println("Got " + n);

		value = false;

		notify();			
		return n;
	}
	
	synchronized void put(int n)
	{
		if(value)
		{
			try
			{
				wait();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}		
			
		this.n = n;
		
		value = true;
		
		System.out.println("Put " + n);
		
		notify();			
	}
}

class Producer implements Runnable
{
	Q q;
	
	Producer(Q q)
	{
		this.q = q;
		
		new Thread(this, "Producer").start();
	}
	
	public void run()
	{
		int i = 0;
		
		while(true)
			q.put(i++);
	}
}

class Consumer implements Runnable
{
	Q q;
	
	Consumer(Q q)
	{
		this.q = q;
		
		new Thread(this, "Consumer").start();
	}
	
	public void run()
	{
		while(true)
			q.get();
	}
}

public class slip21_producer
{
	public static void main(String args[])
	{
		Q q = new Q();
		
		Producer obj1 = new Producer(q);
		
		Consumer obj2 = new Consumer(q);
		
		System.out.println("Press ctrl+c to stop");
	}
}

