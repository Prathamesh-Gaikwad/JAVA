
class ZeroNumberExec extends Exception
{
	public static String print()
	{
		return "zeronumber Exc ==> Number is zero";
	}
}

class UserDefinedException
{
	public static void main(String args[])
	{
		int No;
		int firstDigit = 0;
		int lastDigit = 0;
		
		try
		{
			No = Integer.parseInt(args[0]);
			
			if(0 == No)
				throw new ZeroNumberExec();
			else
			{
				lastDigit = No % 10;
				
				while(No != 0)
				{
					firstDigit = No % 10;
					No = No / 10;	
				}
				
				System.out.println("Sum Of First + Last Digit : " + (firstDigit + lastDigit));
			}
		}
		catch(Exception exception)
		{
			System.out.println(ZeroNumberExec.print());
		}		
	}
}

