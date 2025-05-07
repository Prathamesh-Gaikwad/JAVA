import java.io.*;
import java.util.Date;
import java.util.Calendar;

class Donor implements Serializable
{
	int age;
	String name;
	String address;
	String contactNo;
	String bGroup;
	Date ldDate;

	Donor(int age, String name, String address, String contactNo, String bGroup, Date ldDate)
	{
		this.age = age;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.bGroup = bGroup;
		this.ldDate = ldDate;
	}
	
	static Date createDate(int day, int month, int year)
	{
		Calendar cDate = Calendar.getInstance();
		
		cDate.set(Calendar.YEAR, year);
		cDate.set(Calendar.MONTH, month-1);
		cDate.set(Calendar.DAY_OF_MONTH, day);
		
		return cDate.getTime();
	}
	
	static void writeObjectToFile(Donor arr[], String fileName) throws IOException
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			for(Donor donor : arr)
				oos.writeObject(donor);
		}
		catch(FileNotFoundException exception)
		{
			exception.printStackTrace();
		}
	}
	
	static Donor readObjectFromFile(ObjectInputStream ois) throws IOException, ClassNotFoundException
	{
		return (Donor)ois.readObject();
	}
	
	boolean isValid()
	{
		Calendar cDate = Calendar.getInstance();
		Calendar dDate = Calendar.getInstance();
		
		dDate.setTime(ldDate);
		
		if(cDate.after(dDate))
			return true;
		else
			return false;
	}
	
	void display()
	{
		System.out.println("-------------------------------------");
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
		System.out.println("Address : " + address);
		System.out.println("Contact No : " + contactNo);
		System.out.println("Blood Group : " + bGroup);
		System.out.println("Last Date Of Donation : " + ldDate);
		System.out.println("-------------------------------------");
	}
	
	public static void main(String args[]) throws IOException
	{
		String fileName = "source.dat";
		
		Donor arr[] = new Donor[3];
		
		Date date1 = Donor.createDate(17, 5, 2020);
		Date date2 = Donor.createDate(24, 9, 2023);
		Date date3 = Donor.createDate(13, 7, 2022);
		
		arr[0] = new Donor(29, "Vivian", "Pune", "4576987654", "O+", date1);
		arr[1] = new Donor(32, "Abhishek", "Nigdi", "6754894578", "A+", date2);
		arr[2] = new Donor(45, "Rahul", "Chinchwad", "2345765423", "A+", date3);

		try
		{		
			Donor.writeObjectToFile(arr, fileName);
			
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
			{
				System.out.println("Donors with blood group A+ who have not donated blood from last 6 months..");
				
				for(Donor donor : arr)
				{
					donor = Donor.readObjectFromFile(ois);
					
					if(donor.bGroup.equals("A+") && donor.isValid())
					{
						donor.display();
					}
				}
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
