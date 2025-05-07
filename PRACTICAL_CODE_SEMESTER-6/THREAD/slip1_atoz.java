import java.lang.Thread;

public class slip1_atoz extends Thread
{
	public void run()
	{
		char ch;
		
		System.out.print("\n\tCharcters From A To z : \t");
		for(ch = 'A'; ch <= 'Z'; ch++)
		{
			System.out.print(" " + ch);
			
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[])
	{
		slip1_atoz thread = new slip1_atoz();
		
		thread.start();
	}
}

