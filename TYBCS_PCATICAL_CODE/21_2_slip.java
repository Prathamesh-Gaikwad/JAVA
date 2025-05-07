class Employee
{
	int id;
	int salary;
	String name;
	String deptName;
	static int count;
	
	Employee()
	{
		id = salary = 0;
		name = "NULL";
		deptName = "NULL";
		count++;
	}
	
	Employee(int id, int salary, String name, String deptName)
	{
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.deptName = deptName;
		count++;
	}
	
	public String toString()
	{
		return  "\nID : " + id +
			"\nName : " + name +
			"\nDepartment Name : " + deptName +
			"\nSalary : " + salary +
			"\nObject Created : " + count;
	}
	
	public static void main(String args[])
	{
		Employee avinash = new Employee(1001, 10000, "[AVINASH]", "[ELECTRIC]");
		System.out.println(avinash);
		
		Employee unknown = new Employee();
		System.out.println(unknown);
	}
}

