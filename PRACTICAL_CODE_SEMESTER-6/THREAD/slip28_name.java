public class slip28_name extends Thread
{
	public void run()
	{
		System.out.println("\n\tCurrently Executing Thread : " + Thread.currentThread().getName());
	}
	
	public static void main(String args[])
	{
		slip28_name thread1 = new slip28_name();
		thread1.setName("Sikandar");
		
		slip28_name thread2 = new slip28_name();
		thread2.setName("Kesari-2");
		
		thread1.start();
		
		thread2.start();
		
		System.out.println("\n\tMain Thread : " + Thread.currentThread().getName());
	}
}

