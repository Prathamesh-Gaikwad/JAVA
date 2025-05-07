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
	
	public Donor(int age, String name, String address, String contactNo, String bGroup, Date ldDate)
	{
		this.age = age;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.bGroup = bGroup;
		this.ldDate = ldDate;
	}
	
	public String getBGroup()
	{
		return bGroup;
	}
	
	public Date getDateOfLastDonation()
	{
		return ldDate;
	}
	
	public void display()
	{
		System.out.println(" Name : " + name);
		System.out.println(" Age : " + age);
		System.out.println(" Address : " + address);
		System.out.println(" contactNo : " + contactNo);
		System.out.println(" Blood Group : " + bGroup);
		System.out.println(" Last Date Of Blood Donation : " + ldDate);
	}
	
	public boolean isEligibleForDonation()
	{
		Calendar cDate = Calendar.getInstance();
		Calendar dDate = Calendar.getInstance();
		
		dDate.setTime(ldDate);
		//dDate.add(Calendar.MONTH, 6);
		
		if(cDate.after(dDate))
			return true;
		else
			return false;
	}
	
	public static void writeDonorsToFile(Donor arr[], String fileName) throws IOException
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			for(Donor donor : arr)
			{
				oos.writeObject(donor);
			}
		}
	}
	
	public static Donor readDonorFromFile(ObjectInputStream ois) throws IOException, ClassNotFoundException
	{
		return (Donor)ois.readObject();
	}
	
	public static Date createDate(int year, int month, int day)
	{
		Calendar cDate = Calendar.getInstance();
		
		cDate.set(Calendar.YEAR, year);
		cDate.set(Calendar.MONTH, month-1);
		cDate.set(Calendar.DAY_OF_MONTH, day);
		
		return cDate.getTime();
	}
	
	public static void main(String args[])
	{
		int i;
		
		String fileName = "donor.dat";
		
		Donor arr[] = new Donor[3];
		
		Date date1 = Donor.createDate(2024, 10, 17);
		Date date2 = Donor.createDate(2023, 11, 13);
		Date date3 = Donor.createDate(2022, 4, 13);
		
		arr[0] = new Donor(29, "Rahul", "Pune", "56387239", "O+", date1);
		arr[1] = new Donor(34, "shantanu", "Nigdi", "737837908", "A+", date2);
		arr[2] = new Donor(44, "Raghu", "Chinchwad", "417364278", "A+", date3);
		
		try
		{
			Donor.writeDonorsToFile(arr, fileName);
			
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
			{
				System.out.println("Donors With Blood Group A+ve Who Have Not Donated Blood In Last 6 Months : ");
				
				for(i = 0;  i < arr.length; i++)
				{
					Donor donor = Donor.readDonorFromFile(ois);
					
					if(donor.getBGroup().equals("A+") && donor.isEligibleForDonation())
					{
						donor.display();
					}
				}
			}
		}
		catch(IOException | ClassNotFoundException exception)
		{
			exception.printStackTrace();
		}
		
	}
}

