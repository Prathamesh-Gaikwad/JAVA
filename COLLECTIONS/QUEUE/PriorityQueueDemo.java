import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo
{
	public static void main(String args[])
	{
		Iterator move;
		PriorityQueue<Integer> queue;
		
		queue = new PriorityQueue<Integer>();

		System.out.println("\n\tTop Element : " + queue.peek());

		queue.offer(11);
		queue.offer(22);
		queue.offer(33);
		queue.offer(44);
		queue.offer(55);		
		
		move = queue.iterator();
		while(move.hasNext())
			System.out.println("\n\t" + move.next());
			
		System.out.println("\n\tTop Element : " + queue.peek());

		System.out.println("\n\tFront End Of Container : " + queue.poll());

		move = queue.iterator();
		while(move.hasNext())
			System.out.println("\n\t" + move.next());

		System.out.println("\n\tHead Element : " + queue.remove());

		move = queue.iterator();
		while(move.hasNext())
			System.out.println("\n\t" + move.next());
	}
}
