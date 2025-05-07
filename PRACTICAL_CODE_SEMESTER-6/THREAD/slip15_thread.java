public class slip15_thread extends Thread
{
	public void run()
	{
		System.out.println("Name : " + getName());
		System.out.println("Priority : " + getPriority());
	}
	
	public static void main(String args[])
	{
		slip15_thread thread1 = new slip15_thread();

		slip15_thread thread2 = new slip15_thread();
		
		thread1.setName("Thread-1");
		thread2.setName("Thread-2");

		thread1.setPriority(Thread.MIN_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);

		thread1.start();
		thread2.start();
	}
}

