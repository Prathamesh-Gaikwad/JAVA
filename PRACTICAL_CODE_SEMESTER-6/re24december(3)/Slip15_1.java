class Slip15_1
{
	public static void main(String args[])
	{
		String name;
		int priority;
		
		Thread thread = Thread.CurrentThread();
		
		name = thread.getName();
		System.out.println("\nCurrent Thread Name : " + name);
		
		priority = thread.getPriority();
		System.out.println("\nCurrent Thread Priority : " + priority);
		
		thread.setName("Assigning New Name");
		
		name = thread.getName();
		System.out.println("\nNew Thread Name : " + name);
	}
}
