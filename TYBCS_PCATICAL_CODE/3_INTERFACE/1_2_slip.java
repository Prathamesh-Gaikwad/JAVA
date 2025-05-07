import java.util.Scanner;

abstract class Staff
{
	protected int id;
	protected String name;
	
	Staff(int param1, String param2)
	{
		id = param1;
		name = param2;
	}
	
	abstract void display();
}

class OfficeStaff extends Staff
{
	String department;
	
	OfficeStaff(int param1, String param2, String param3)
	{
		super(param1, param2);
		
		department = param3;
	}
	
	void display()
	{
		System.out.println("-------[OFFICE-STAFF-DETAILS]-------");
		System.out.println("ID : " + id);
		System.out.println("NAME : " + name);
		System.out.println("DEPARTMENT : " + department);
		System.out.println("------------------------------------");
	}
	
	public static void main(String args[])
	{
		int i;
		int id;
		int size;
		String name;
		String department;
				
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Total Office Staff Count : ");
		size = scanner.nextInt();
		
		OfficeStaff officeStaff[] = new OfficeStaff[size];
		
		for(i = 0; i < size; i++)
		{
			System.out.print("Enter Employee ID : ");
			id = scanner.nextInt();
			
			System.out.print("Enter Employee Name : ");
			name = scanner.next();
			
			System.out.print("Enter Employee Department : ");
			department = scanner.next();
			
			officeStaff[i] = new OfficeStaff(id, name, department);
		}
		
		System.out.println("[Following Are " + size + " Office Staff Details]");
		for(i = 0; i < size; i++)
		{
			officeStaff[i].display();	
		}
		
		scanner.close();
	}
}

