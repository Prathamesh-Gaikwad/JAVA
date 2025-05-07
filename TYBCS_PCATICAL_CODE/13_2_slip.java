import java.util.Date;
import java.text.SimpleDateFormat;

class DateFormat
{
	public static void main(String args[])
	{
		String string;
		
		Date today = new Date();
		
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		string = date.format(today);
		System.out.println("Current Date is : " + string);
		
		date = new SimpleDateFormat("MM-dd-yyyy");
		string = date.format(today);
		System.out.println("Current Date is : " + string);		

		date = new SimpleDateFormat("EEEEE d MMM yyyy");
		string = date.format(today);
		System.out.println("Current Date is : " + string);		
		
		System.out.println("Current Date And Time is : " + today);

		date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss aaaZ");
		string = date.format(today);
		System.out.println("Current Date is : " + string);		

	}
}
