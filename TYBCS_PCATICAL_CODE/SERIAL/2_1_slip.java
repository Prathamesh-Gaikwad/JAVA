class BMI
{
	public static void main(String args[])
	{
		float BMI;
		int weight = Integer.parseInt(args[2]);
		float height = Float.parseFloat(args[3]);
		String lastName = args[1];
		String firstName = args[0];
		
		BMI = weight/(height*height);
		
		System.out.println("Name : " + firstName + " " + lastName);
		System.out.println("BMI : " + BMI);
	}
}
