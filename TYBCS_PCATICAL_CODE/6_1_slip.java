class Employee
{
	int id;
	int salary;
	String name;
	String designation;
	
	Employee(int param1, int param2, String param3, String param4)
	{
		id = param1;
		salary = param2;
		name = param3;
		designation = param4;
	}
	
	public String toString()
	{
		return "Employee Record : " + "ID : " + id + "   Name : " + name + " Designation : " + designation + " Salary : " + salary;
	}
	
	public static void main(String args[])
	{
		Employee employee = new Employee(101, 10000, "Prathamesh_Bapu_Gaikwad", "Explorer");
		
		System.out.println(employee);
	}
}

