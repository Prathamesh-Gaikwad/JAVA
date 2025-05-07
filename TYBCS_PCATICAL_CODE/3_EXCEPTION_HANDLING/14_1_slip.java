import java.util.Scanner;

class NumberException extends Exception
{	
	public String toString()
	{
		return "[NUMBER IS ZERO!!]";
	}
}

class UserException
{
	public static void main(String args[])
	{
		int no;		
		int counter;
		boolean prime = true;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Number : ");
		no = scanner.nextInt();

		scanner.close();
		
		try
		{
			if(0 == no)
				throw new NumberException();
			else
			{
				for(counter = 2; counter < no; counter++)
				{
					if(0 == (no % counter))
						prime = false;
				}
				
				if(true == prime)
					System.out.println("[NUMBER IS PRIME]");
			}
		}
		catch(NumberException exception)
		{
			System.out.println(exception);
		}
	}
}

