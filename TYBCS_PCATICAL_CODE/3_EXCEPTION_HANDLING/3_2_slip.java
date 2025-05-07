import java.util.Scanner;

class CovidPositiveException extends Exception
{
	public CovidPositiveException()
	{
		System.out.println("\n\t\"RECOMMENDATION : Patient is covid positive, he needs to be hospitalised..\"\n");
	}
}

class Patient
{
	int age;
	String name;
	int oxyLevel;
	int hrctReport;

	Patient(int param1, String param2, int param3, int param4)
	{
		age = param1;
		name = param2;
		oxyLevel = param3;
		hrctReport = param4;
	}
	
	void display()
	{
		System.out.println("\n\tPatient Details : ");
		System.out.println("\n\t\t-->Patient Age : " + age);
		System.out.println("\n\t\t-->Patient Name : " + name);
		try
		{
			if(oxyLevel > 95 && hrctReport > 10)
				throw new CovidPositiveException();
			System.out.println("\n\t\t-->Patient Oxygen Level : " + oxyLevel);
			System.out.println("\n\t\t-->Patient HRCT Reoprt : " + hrctReport);
			System.out.println("\n\t-----------------------------------\n");
		}
		catch(CovidPositiveException exception)
		{
			System.out.println("\n\t-----------------------------------\n");
		}
	}
}

class ExceptionHandling
{
	public static void main(String args[])
	{
		int i;
		int age;
		int size;
		String name;
		int oxyLevel;
		int hrctReport;

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n\tEnter Total Number of Patient : ");
		size = scanner.nextInt();

		Patient patient[] = new Patient[size];
		
		System.out.println("\n\tEnter " + size + " Patient Details : ");
		System.out.println("\n\t^^^^^^^^^^^^^^^^^^^^^^^^");

		for(i = 0; i < size; i++)
		{
			System.out.print("\n\t1)Enter Patient " +(i + 1) + " Age : ");
			age = scanner.nextInt();

			System.out.print("\n\t2)Enter Patient " +(i + 1) + " Name : ");
			name = scanner.next();

			System.out.print("\n\t3)Enter Patient " +(i + 1) + " oxyLevel : ");
			oxyLevel = scanner.nextInt();

			System.out.print("\n\t4)Enter Patient " +(i + 1) + " HRCT Report : ");
			hrctReport = scanner.nextInt();
	
			patient[i] = new Patient(age, name, oxyLevel, hrctReport);
			System.out.println("\n\t*******************************************\n");
		}
		
		for(i = 0; i < size; i++)
			patient[i].display();
	}
}

/*
	o/p:
	
	Enter Total Number of Patient : 4

	Enter 4 Patient Details : 

	^^^^^^^^^^^^^^^^^^^^^^^^

	1)Enter Patient 1 Age : 21

	2)Enter Patient 1 Name : Prathamesh

	3)Enter Patient 1 oxyLevel : 78

	4)Enter Patient 1 HRCT Report : 8

	*******************************************


	1)Enter Patient 2 Age : 29

	2)Enter Patient 2 Name : Akash

	3)Enter Patient 2 oxyLevel : 67

	4)Enter Patient 2 HRCT Report : 7

	*******************************************


	1)Enter Patient 3 Age : 78

	2)Enter Patient 3 Name : Hari

	3)Enter Patient 3 oxyLevel : 97

	4)Enter Patient 3 HRCT Report : 11

	*******************************************


	1)Enter Patient 4 Age : 67

	2)Enter Patient 4 Name : Sham

	3)Enter Patient 4 oxyLevel : 99

	4)Enter Patient 4 HRCT Report : 14

	*******************************************


	Patient Details : 

		-->Patient Age : 21

		-->Patient Name : Prathamesh

		-->Patient Oxygen Level : 78

		-->Patient HRCT Reoprt : 8

	-----------------------------------


	Patient Details : 

		-->Patient Age : 29

		-->Patient Name : Akash

		-->Patient Oxygen Level : 67

		-->Patient HRCT Reoprt : 7

	-----------------------------------


	Patient Details : 

		-->Patient Age : 78

		-->Patient Name : Hari

	"RECOMMENDATION : Patient is covid positive, he needs to be hospitalised.."


	-----------------------------------


	Patient Details : 

		-->Patient Age : 67

		-->Patient Name : Sham

	"RECOMMENDATION : Patient is covid positive, he needs to be hospitalised.."


	-----------------------------------


*/

