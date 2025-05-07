import java.util.Scanner;
import SY.SYMarks;
import TY.TYMarks;

class Student
{
	int rollNo;
	String name;
	String grade;
	int percentage;
	TYMarks tyMarks;
	SYMarks syMarks;
	static Scanner scanner;
	
	Student(int _rollNo, String _name)
	{
		rollNo = _rollNo;
		name = _name;
	}
	
	void accept()
	{	
		syMarks = new SYMarks();
		
		tyMarks = new TYMarks();
		
		System.out.print("Enter Electronic Marks : ");
		syMarks.eleTotal = scanner.nextInt();

		System.out.print("Enter Computer Marks : ");
		syMarks.compTotal = scanner.nextInt();

		System.out.print("Enter Math Marks : ");
		syMarks.mathTotal = scanner.nextInt();

		System.out.print("Enter Theory Marks : ");
		tyMarks.theory = scanner.nextInt();

		System.out.print("Enter Practical Marks : ");
		tyMarks.practical = scanner.nextInt();
		
		setPercentage();
		
		setGrade();
	}
	
	void setPercentage()
	{		
		percentage = (syMarks.eleTotal + syMarks.compTotal + syMarks.mathTotal + tyMarks.theory + tyMarks.practical)/5;
	}
	
	void setGrade()
	{
		if(percentage >= 70)
			grade = "A";
		else if(percentage >= 60)
			grade = "B";
		else if(percentage >= 50)
			grade = "C";
		else if(percentage >= 40)
			grade = "PASS";
		else
			grade = "FAIL";
	}
	
	public String toString()
	{
		return  "Roll No. : " + rollNo +
			" Name : " + name +
			" Percentage : " + percentage +
			" grade : " + grade;
	}	
			
	public static void main(String args[])
	{
		int size;
		int rollNo;
		int counter;
		String name;
		
		scanner = new Scanner(System.in);
		
		System.out.print("How Many Students Are There : ");
		size = scanner.nextInt();
		
		Student arr[] = new Student[size];
		
		for(counter = 0; counter < size; counter++)
		{
			System.out.print("Enter Roll No. : ");
			rollNo = scanner.nextInt();
			
			System.out.print("Enter Name : ");
			name = scanner.next();
			
			arr[counter] = new Student(rollNo, name);
			
			arr[counter].accept();
		}

		for(counter = 0; counter < size; counter++)
		{
			System.out.println(arr[counter]);
		}
		
		scanner.close();
	}
}

