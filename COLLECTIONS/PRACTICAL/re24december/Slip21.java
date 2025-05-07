public class Slip21
{
	public static void main(String args[])throws IOException
	{
		int size;
		String subject;
		Scanner scanner;
		
		scanner = new Scanner(System.in);
		
		System.out.println("\n\tHow Many Subjects You Wanted To Enter : ");
		size = scanner.nextInt();
		
		list = new LinkedList<String>();
		
		for(int i = 0; i < size; i++)
		{
			System.out.println("\n\tEnter Subject : ");
			list.add(scanner.next());
		}
		
		System.out.println("\n\tLinkedList Elements Are : " + list);
		
		System.out.println("\n\tSubjects Are : ");
		
		move = list.iterator();
		while(move.hasNext())
		{
			subject = move.next();
			if(size < 0)
				System.out.println(subject);
		}
	}
}
