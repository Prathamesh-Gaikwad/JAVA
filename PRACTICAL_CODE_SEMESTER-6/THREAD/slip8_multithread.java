public class slip8_multithread
{
	public static void main(String args[])
	{
		Print thread1 = new Print("Covid19", 10);
		thread1.start();

		Print thread2 = new Print("Lockdown2020", 20);
		thread2.start();

		Print thread3 = new Print("Vaccinated2021", 30);
		thread3.start();	
	}
}

class Print extends Thread
{
	int n;
	String msg;
	
	public Print(String msg, int n)
	{
		this.msg = msg;
		this.n = n;
	}
	
	public void run()
	{
		for(int i = 0; i < n; i++)
			System.out.println(msg);
	}
}

