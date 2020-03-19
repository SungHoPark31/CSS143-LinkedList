package LinkedListHW;

/**
 * This is the linked list class "List". This will make a list using Nodes and 
 * go through the list using next. Also, we will be adding elements and 
 * removing elements in the list.
 * 
 * @author Sung Ho Park
 * CSS 143 B
 * Assignment: LinkedLists, Stacks and Queue
 */
public class List 
{
	/**
	 * This is the inner class that will be used for the list class. 
	 */
	private class Node
	{
		private Object data;
		private Node next;
		
		/**
		 * Constructor to set the instance variables
		 * @param data
		 */
		public Node(Object data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	//Instance variables
	Node head = null;
	
	/**
	 * Empty / no arg constructor that sets the head to null
	 */
	public List()
	{
		this.head = null;
	}
	
	/**
	 * Precondition: Next is not null and there is a value in the index
	 * 
	 * Postcondition: This will insert a node in a specific index.
	 * 
	 * @param next
	 * @param index
	 */
	public void insert(Object next, int index)
	{	
		//If head is null then put a value in head
		if(head == null)
		{
			head = new Node(next);	
			head.next = null;
		}
		else if(index == 0)
		{
			Node n = new Node(next);
			n.next = head;
			head = n;
			
		}
		//Else if there is only one element, then add a value in the 
		//next node 
		else if(head.next == null)
		{
			
			Node nextNode = new Node(next);
			head.next = nextNode;
		}
		else
		{
			//Make the current the head
			Node current = head;
			
			//Set a variable that makes the location 0
			//We will increment this.
			int location = 0;
			
			//While current is not null, traverse through the nodes until
			//it goes one before the index.
			while(current != null && location != index - 1)
			{
				//Traverse
				current = current.next;
				//Increment location
				location++; 
			}
			
			//save the next node so that it won't be garbage
			Node after = current.next;
			
			//Make a new node 
			Node s = new Node(next);
			
			//Set the link to the new Node
			current.next = s;
			
			//Set the link to the saved node.
			s.next = after;
		}
	}
	
	/**
	 * Precondition: index has a value 
	 * 
	 * Postcondition: removes the node.
	 * @param index
	 * @return
	 */
	public Object remove(int index) throws LinkedListException
	{
		//If the head is null, then return null
		if(head == null)
		{
			//Since you cannot remove from an empty list, throw the exception
			throw new LinkedListException();
		}
		//If the index you want to remove is 0, then return the next node
		else if(index == 0)
		{
			head = head.next;
			return head;
			
		}
		else if(index >= size())
		{
			throw new LinkedListException();
		}
		else
		{
			//Make a current 
			Node current = head;
			int location = 0;
			
			//Traverse through the Nodes until you get to index -1
			while(current != null && location != index - 1)
			{	
				current = current.next;
				location++; 
			}
			//Make the next node the node after that next node.
			current.next = current.next.next;
			//Returns the list with the deleted node
			return head;
		}
	}
	
	/**
	 * Precondition: There are nodes in the list
	 * 
	 * Postconditions: Return the size
	 * @return size
	 */
	public int size()
	{
		//Make the current equal to the head and initialize the size to 0
		int size = 0;
		Node current = head;
		
		//Traverse through the list until you get to the end (null)
		while(current!= null) 
		{
			//Keep incrementing size until you get null
			size++;
			current = current.next;
		}
		//Return the size
		return size;
	}
	
	@Override
	/**
	 * Precondition: There are nodes in the list
	 * 
	 * Postcondition: Returns the nodes as a string
	 */
	public String toString()
	{
		String val = "";
		
		Node current = head;
		
		//Traverse through and as you traverse, print out the value.
		while(current != null)
		{
			val = val + current.data;
			current = current.next;
		}
		
		//Return the String
		return val;
	}
	
	/**
	 * Precondition: The node is either empty or filled.
	 * 
	 * Postcondition: Returns true or false
	 * @return
	 */
	public boolean isEmpty()
	{
		//If the head is null (The list is empty), then return true
		if(head == null)
		{
			return true;
		}
		//Otherwise return false.
		return false;
	}
	
	/**
	 * Precondition: There are nodes in the list
	 * 
	 * Postcondition: Returns the index
	 * @param target
	 * @return index
	 */
	public int indexOf(Object target)
	{
		//Make the count equal 0
		int count = 0;
		Node current = head;
		//Traverse through the list.
		while(current != null)
		{
			//If the head is the target, return the count.
			if(current.data == target)
			{
				return count;
			}
			count++;
			current = current.next;
		}
		//Otherwise return -1
		return -1;
	}
	
	/**
	 * Precondition: There are nodes in the list
	 * 
	 * Postcondition: Adds a node in the very end of the list.
	 * @param obj
	 */
	public void append(Object obj)
	{
		Node current = head;
		
		//If head is null then put a value in head
		if(head == null)
		{
			head = new Node(obj);	
			head.next = null;
		}
		//Else if there is only one element, then add a value in the 
		//next node 
		else if(head.next == null)
		{
			Node nextNode = new Node(obj);
			head.next = nextNode;
		}
		else
		{
			while(current.next != null) 
			{
				current = current.next;	
			}
		
			//If the current is null, then make a new node and add it
			//To the end. 
			if(current.next == null)
			{
				Node newNode = new Node(obj);
				current.next=  newNode;
			}
		}
	}
	
	/**
	 * Here are the tests for each method.
	 * @param args
	 * @throws LinkedListException 
	 */
	public static void main(String[] args) throws LinkedListException
	{
		List empty = new List();
		List one = new List();
		List multiple = new List();
		
		//Test the append and the insert
		one.append(5);
		one.append(6);
		one.insert(2, 1);
		one.append(3);
		multiple.append(1);
		multiple.append(2);
		multiple.insert(4, 2);
		multiple.append(3);
	
		//Test if empty
		System.out.println("Empty: " + empty);
		System.out.println("Is Empty empty?: " + empty.isEmpty());
		System.out.println();
		
		System.out.println("One: " + one);
		System.out.println("Multiple: " + multiple);	
		
		//Test the remove
		one.remove(0);
		multiple.remove(2);
		System.out.println("One (upon remove): " + one);
		System.out.println("Multiple (upon remove): " + multiple);
		
		//Test append again
		one.append(6);
		multiple.append(5);
		System.out.println("One (on append): " + one);
		System.out.println("Multiple(on append): " + multiple);
		System.out.println();
		//Test the index of
		System.out.println("Target 3 on One is at index: " + one.indexOf(3));
		System.out.println("Target 2 on Multiple is at index: " 
													+ multiple.indexOf(2));
		System.out.println();
		
		//Test if one and multiple is empty (It should return false)
		System.out.println("Is One empty?: " + one.isEmpty());
		System.out.println("Is Multiple empty?: " + multiple.isEmpty());
		
		
		/**
		 * The next section is for throwing exceptions. Uncomment to test them.
		 */
		
		//This will throw the exception if the programmer tries to remove an 
		//empty list
//		System.out.println("Attempting to remove empty: ");
//		empty.remove(1);
		
		//This will also throw the exception if programmer attempts to remove
		//an index bigger than the size
//		System.out.println("Attempting to remove past the size: ");
//		one.remove(12);
		
		
	}

}
