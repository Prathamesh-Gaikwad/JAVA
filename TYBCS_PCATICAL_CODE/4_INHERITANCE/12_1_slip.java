class College
{
	int cNo;
	String cName;
	String cAddr;
	
	College(int _cNo, String _cName, String _cAddr)
	{
		cNo = _cNo;
		cName = _cName;
		cAddr = _cAddr;
	}
}

class Department extends College
{
	int dNo;
	String dName;
	
	Department(int _cNo, String _cName, String _cAddr, int _dNo, String _dName)
	{
		super(_cNo, _cName, _cAddr);
		dNo = _dNo;
		dName = _dName;
	}
	
	void display()
	{
		System.out.println("College Name : " + cName);
		System.out.println("College No. : " + cNo);
		System.out.println("College Address : " + cAddr);
		System.out.println("Department Name : " + dName);
		System.out.println("Department No. : " + dNo);
	}
	
	public static void main(String args[])
	{
		Department department = new Department(11, "Pratibha College Of Commerece & Computer Studies", "Chinchwad", 101, "Computer Science");
		
		department.display();
	}
}

