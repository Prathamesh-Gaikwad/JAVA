import java.util.Scanner;

class Customer
{
	String name;
	String phoneNo;
	
	Customer(String _name, String _phoneNo)
	{
		name = _name;
		phoneNo = _phoneNo;
	}
}

class Depositor extends Customer
{
	int accNo;
	int balance;
	
	Depositor(String _name, String _phoneNo, int _accNo, int _balance)
	{
		super(_name, _phoneNo);
		
		accNo = _accNo;
		balance = _balance;
	}
}

class Borrower extends Depositor
{
	int loanNo;
	int loanAmt;
	static int No;
	
	Borrower(String _name, String _phoneNo, int _accNo, int _balance, int _loanAmt)
	{
		super(_name, _phoneNo, _accNo, _balance);
		
		loanNo = ++No;
		loanAmt = _loanAmt;		
	}
	
	public String toString()
	{
		return  "\nName : " + name +
			"\nPhone No : " + phoneNo +
			"\nAccount No : " + accNo +
			"\nBalance : " + balance +
			"\nLoan No : " + loanNo +
			"\nLoan Amount : " + loanAmt;
	}
	
	public static void main(String args[])
	{
		int size;
		int accNo;
		int balance;
		String name;
		int counter;
		int loanAmt;
		String phoneNo;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Total Customers : ");
		size = scanner.nextInt();
		
		Borrower arr[] = new Borrower[size];
		
		for(counter = 0; counter < size; counter++)
		{
			System.out.print("Enter Name : ");
			name = scanner.next();
			
			System.out.print("Enter Phone No. : ");
			phoneNo = scanner.next();
			
			System.out.print("Enter Account No. : ");
			accNo = scanner.nextInt();
			
			System.out.print("Enter Account Balance : ");
			balance = scanner.nextInt();

			System.out.print("Enter Account Loan Amount : ");
			loanAmt = scanner.nextInt();
			
			arr[counter] = new Borrower(name, phoneNo, accNo, balance, loanAmt);
		}
		
		for(counter = 0; counter < size; counter++)
		{
			System.out.println(arr[counter]);
		}
		
		scanner.close();
	}
}

