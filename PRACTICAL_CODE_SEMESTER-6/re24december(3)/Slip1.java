public class Slip1 extends Thread
{
	char ch;
	
	public void run()
	{
		for(ch = 'A'; ch <= 'Z'; ch++)
		{
			System.out.println(ch + " ");
			
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e){}
		}
	}
	
	public static void main(String args[])
	{
		Slip1  thread = new Slip1();
		
		thread.start();
	}
}
