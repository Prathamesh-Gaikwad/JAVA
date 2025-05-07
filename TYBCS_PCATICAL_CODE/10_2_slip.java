import java.util.Scanner;
import student.StudentPer;
import student.StudentInfo;

class PackageDemo
{
	public static void main(String args[])
	{
		int i;
		int rollNo;
		String name;
		String _class;
		int percentage;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Roll No : ");
		rollNo = scanner.nextInt();

		System.out.println("Enter Name : ");
		name = scanner.next();

		System.out.println("Enter Class : ");
		_class = scanner.next();

		int marks[] = new int[6];
				
		System.out.println("Enter marks of 6 subjects : ");
		for(i = 0; i < 6; i++)
		{
			System.out.println("Subject " + (i+1) + " : ");
			marks[i] = scanner.nextInt();
		}
		
		StudentPer calculate = new StudentPer();
		
		percentage = calculate.percentage(marks);
		
		StudentInfo student = new StudentInfo();
		
		student.display(rollNo, _class, percentage);
		
		scanner.close();
	}
}

