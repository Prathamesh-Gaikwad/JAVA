import java.util.Scanner;

class InvalidPassword extends Exception
{
	InvalidPassword()
	{
		System.out.println("Invalid Password Exception");
	}
}

class Check
{	
	public static void main(String args[])
	{
		String name;
		String password;
		
		try
		{	
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter User Name : ");
			name = scanner.next();
			
			System.out.println("Enter Password : ");
			password = scanner.next();
			
			if(name.equals(password))
				System.out.println("Login Successful");
			else
				throw new InvalidPassword();
			scanner.close();
		}
		catch(InvalidPassword exception)
		{
			//exception handling
		}
	}
}

