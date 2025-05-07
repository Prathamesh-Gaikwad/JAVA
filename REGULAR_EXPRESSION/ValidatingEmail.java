import java.util.Scanner;

public class ValidatingEmail 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Email: ");
		String phone = sc.next();
		
	    	String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		//Matching the given phone number with regular expression
		boolean result = phone.matches(regex);
		
		if(result) 
		{
			System.out.println("Given email-id is valid");
		} 
		else 
		{
			System.out.println("Given email-id is not valid");
		}
	}
}

