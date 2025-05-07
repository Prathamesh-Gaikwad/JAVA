public class mainThreadReference
{
	public static void main(String args[])
	{
		Thread thread = Thread.currentThread();
		
		System.out.println("Thread : " + thread.getName());
		System.out.println("Thread Object : " + thread);
	}
}

