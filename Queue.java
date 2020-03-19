package LinkedListHW;

/**
 * This is the child class (Queue) of the parent class (List)
 * The only thing this class has is the enqueue and dequeue override 
 * methods
 * 
 * @author Sung Ho Park
 * CSS 143 B
 * Assignment: LinkedLists, Stacks and Queue
 *
 */
public class Queue extends List
{
	/**
	 * Precondition: obj is not null and has a value
	 * 
	 * Postcondition: This is meant to help the insert method. This will 
	 * enqueue the object in the queue
	 * 
	 * @param obj
	 */
	public void enqueue(Object obj)
	{
		super.insert(obj, 0);
	}
	
	/**
	 * Precondition: There are objects in the queue
	 * 
	 * Postcondition: This is meant to help the remove method. This will 
	 * remove the first object put in.
	 * @return
	 * @throws LinkedListException 
	 */
	public Object dequeue(int index) throws LinkedListException
	{
		return super.remove(size() - 1);
	}
	
	@Override
	/**
	 * Preconditions: obj is not null
	 * 
	 * Postconditions: Index doesn't matter but it is added. Uses the 
	 * enqueue method to enqueue values in the queue.
	 * @param obj
	 */	
	public void insert(Object obj, int index)
	{
		enqueue(obj);
	}
	
	@Override
	/**
	 * Preconditions: obj is not null
	 * 
	 * Postconditions: Index doesn't matter but it is added. Uses the 
	 * dequeue method to dequeue the first thing put in the queue.
	 * 
	 * @return dequeue the size - 1 to delete the first thing put in ;
	 */
	public Object remove(int index) throws LinkedListException
	{
		return dequeue(size() - 1);
	}
	
	public static void main(String[] arg) throws LinkedListException
	{
		Queue q = new Queue();
		
		//Test the insert
		q.insert(1, 0);
		q.insert(4, 0);
		q.insert(6, 0);
		q.insert(2, 0);
		q.insert(3, 0);
		q.insert(9, 0);
		
		System.out.println(q);
		
		//Test the isEmpty
		System.out.println("Is this queue empty?: " + q.isEmpty());
		
		//Test the remove
		q.remove(1);
		q.remove(2);
		System.out.println(q);
		
		//Test the index of 
		System.out.println("The target 6 is at index: " + q.indexOf(6));
		System.out.println("The target 3 is at index: " + q.indexOf(3));
		System.out.println("The target 9 is at index: " + q.indexOf(9));
		
		//Tests the exception and the isEmpty 
		Queue m = new Queue();
		System.out.println("Is this new queue empty?: " + m.isEmpty());
		m.remove(1);
		
	}
}
