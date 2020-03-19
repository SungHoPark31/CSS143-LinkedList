package LinkedListHW;

/**
 * This is the child class (Stack) of the parent class (List)
 * The only thing this class has is the push and pop override 
 * methods
 * 
 * @author Sung Ho Park
 * CSS 143 B
 * Assignment: LinkedLists, Stacks and Queue
 *
 */
public class Stack extends List
{
 
	/**
	 * Precondition: obj is not null and has a value
	 * 
	 * Postcondition: This is meant to help the insert method. This will 
	 * push the object in. Stack
	 * 
	 * @param obj
	 */
	public void push(Object obj)
	{
		super.insert(obj, 0);
	}
	
	/**
	 * Precondition: There are objects in the stack
	 * 
	 * Postcondition: This is meant to help the remove method. This will 
	 * remove the last object put in. Stack
	 * @return
	 * @throws LinkedListException 
	 */
	public Object pop() throws LinkedListException
	{
		return super.remove(0);
	}
	
	@Override
	/**
	 * Preconditions: obj is not null
	 * 
	 * Postconditions: Index doesn't matter but it is added. Uses the 
	 * push method to push values in the stack.
	 * @param obj
	 */		
	public void insert(Object obj, int index)
	{
		push(obj);
	}
	
	@Override
	/**
	 * Preconditions: obj is not null
	 * 
	 * Postconditions: Index doesn't matter but it is added. Uses the 
	 * pop method to pop values out of the stack.
	 * @return pop();
	 */
	public Object remove(int index) throws LinkedListException
	{
		return pop();
	}
	
	/**
	 * Main method to test the push and pop.
	 * @param arg
	 * @throws LinkedListException 
	 */
	public static void main(String[] arg) throws LinkedListException
	{
		
		Stack n = new Stack();
		
		//Test the insert
		n.insert(5, 0);
		n.insert(1, 1);
		n.insert(6, 2);
		n.insert(4, 2);
		n.insert(2, 2);
		n.insert(8, 2);
		System.out.println(n);
		//Test the isEmpty
		System.out.println("Is the stack empty?: " + n.isEmpty());
		
		//Test the pop
		n.remove(2);
		n.remove(2);
		System.out.println(n);
		
		//Test the index of 
		System.out.println("The target 6 is at index: " + n.indexOf(6));
		System.out.println("The target 5 is at index: " + n.indexOf(5));
		System.out.println("The target 1 is at index: " + n.indexOf(1));
		
		//Test the exception and is empty
		Stack empty = new Stack();
		System.out.println("Is this new stack empty?: " + empty.isEmpty());
		
		//This will throw the exception.
		empty.remove(2);
		
	}

}
