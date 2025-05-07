class MultiplePrioterizedThread extends Thread
{
	public void run()
	{
		System.out.println("\nRunning Thread : " + Thread.currentThread());
		System.out.println("\nThread Priority : " + Thread.currentThread().getPriority());		
	}
	
	public static void main(String args[])
	{
		MultiplePrioterizedThread mObj1 = new MultiplePrioterizedThread();
		MultiplePrioterizedThread mObj2 = new MultiplePrioterizedThread();
		
		mObj1.setPriority(MIN_PRIORITY);
		mObj2.setPriority(MAX_PRIORITY);
		
		mObj1.start();
		mObj2.start();
	}
}
/*
	o/p:
	
	Running Thread : Thread[#19,Thread-1,10,main]

	Running Thread : Thread[#18,Thread-0,1,main]

	Thread Priority : 10

	Thread Priority : 1

*/
