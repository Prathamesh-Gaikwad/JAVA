import java.util.Scanner;

public class slip23_vowel extends Thread
{
	String str;
	
	public slip23_vowel(String str)
	{
		this.str = str;
		start();
	}
	
	public void run()
	{
		char ch;
		
		System.out.println("\n\tVowels : ");
		for(int i = 0; i < str.length(); i++)
		{
			ch = str.charAt(i);
			
			if(ch == 'A'|| ch == 'E'|| ch == 'I'|| ch == 'O'|| ch == 'U'|| ch == 'a'|| ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u')
			{
				System.out.print(ch);
				
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
		
		System.out.print("\n\tEnter String : ");
		
		String str = scanner.nextLine();
		
		slip23_vowel thread = new slip23_vowel(str);
	}
}

