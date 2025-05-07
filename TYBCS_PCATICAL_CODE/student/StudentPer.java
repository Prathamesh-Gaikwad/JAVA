package student;

public class StudentPer
{
	public int percentage(int marks[])
	{
		int i;
		int sum = 0;
		
		for(int ele : marks)
			sum = sum + ele;
		
		return (sum/6);
	}
}

