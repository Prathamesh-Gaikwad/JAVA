class Account
{
	int accNo;
	String name;
	
	Account()
	{
		accNo = 0;
		name = "NULL";
	}
	
	Account(int _accNo, String _name)
	{
		accNo = _accNo;
		name = _name;
	}
}

class SavingAccount extends Account
{
	int minBal;
	int savingBal;
	
	SavingAccount(int _accNo, String _name)
	{
		super(_accNo, _name);
		
		minBal = 1000;
		savingBal = 0;
	}
}

class AccountDetail extends SavingAccount
{
	int depositAmt;
	int withdrawlAmt;
	
	AccountDetail(int _accNo, String _name)
	{
		super(_accNo, _name);
		
		depositAmt = withdrawlAmt = 0;
	}
	
	void deposit(int amount)
	{
		depositAmt = amount;
		
		savingBal = savingBal + depositAmt;
	}
	
	int withdraw(int amount)
	{
		if(amount < savingBal)
		{
			withdrawlAmt = amount;
			return (savingBal = savingBal - withdrawlAmt);
		}
		else
			System.out.println("[UNABLE TO WITHDRAW CASH]");
		
		return 0;
	}
	
	public String toString()
	{
		return  "\nAccount No. : " + accNo +
			"\nName : " + name +
			"\nMinimum Balance : " + minBal +
			"\nSaving Balance : " + savingBal +
			"\nLast Deposited Amount : " + depositAmt +
			"\nRecent Withdrawl Amount : " + withdrawlAmt;
	}
	
	public static void main(String args[])
	{
		AccountDetail ayuka = new AccountDetail(1001, "Ayuka");
		
		ayuka.deposit(100000);
		
		ayuka.withdraw(20000);
		
		System.out.println(ayuka);
	}
}


