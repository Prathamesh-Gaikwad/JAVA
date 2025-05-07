class InvalidDateException extends Exception
{
	InvalidDateException()
	{
		System.out.println("Invalid Date");
	}
}

class MyDate
{
	int day;
	int year;
	int month;
	
	MyDate(int iDay, int iMonth, int iYear)
	{
		try
		{
			if(valid(iDay, iYear, iMonth))
			{
				day = iDay;
				year = iYear;
				month = iMonth;
				
				System.out.println("Valid Date : " + day + "/" + month + "/" + year);
			}
			else
				throw new InvalidDateException();
		}
		catch(InvalidDateException exception)
		{
			//
		}
	}
	
	boolean valid(int iDay, int iYear, int iMonth)
	{
		int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(iMonth >= 1 && iMonth <= 12)
		{
			if((iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0))
			{
				days[1] = 29;
			}
			
			if((iDay > 0) && (iDay <= days[iMonth - 1]))
				return true;
		}
		
		return false;
	}
	
	public static void main(String args[])
	{
		MyDate date = new MyDate(29, 1, 2024);
	}
}

