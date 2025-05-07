import java.util.Scanner;

public class Slip23_1 extends Thread
{
	String s1;
	
	public Slip23_1(String str)
	{
		s1 = str;
		
		start();
	}
	
	public void run()
	{
		for(int i = 0; i < s1.length(); i++)
		{
			char ch = s1.charAt(i);
			
			if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||)
			{
				System.out.println(ch);
				
				try
				{
					Thread.sleep(3000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEnter a String : ");
		String str = scanner.nextLine();
		
		Slip23_1 obj = new Slip23_1(str);
	}
}
