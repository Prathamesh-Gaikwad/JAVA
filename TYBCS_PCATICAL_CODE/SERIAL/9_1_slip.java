class Clock
{
	int sec;
	int min;
	int hour;
	
	Clock(int param1, int param2, int param3)
	{
		sec = param1;
		min = param2;
		hour = param3;
	}
	
	boolean validity()
	{
		if(hour >= 0 && hour < 24)
		{
			if(min >= 0 && min < 60)
			{
				if(sec >= 0 && sec < 60)
					return true;
			}
		}
		
		return false;
	}
	
	void setAM_PM()
	{
		if(hour >= 0 && hour < 12)
			System.out.println("Time : " + hour + ":" + min + ":" + sec + " AM");
		else
			System.out.println("Time : " + hour + ":" + min + ":" + sec + " PM");
	}
	
	public static void main(String args[])
	{
		int sec;
		int min;
		int hour;
		boolean result;
		
		sec = Integer.parseInt(args[2]);
		min = Integer.parseInt(args[1]);
		hour = Integer.parseInt(args[0]);
		
		Clock clock = new Clock(sec, min, hour);
		
		result = clock.validity();
		
		if(result)
			clock.setAM_PM();
		else
			System.out.println("Invalid Time Values");				
	}
}
