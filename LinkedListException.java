package LinkedListHW;

public class LinkedListException extends Exception
{
	public LinkedListException() 
	{
		super("Either cannot remove past the size or cannot remove an empty list.");
	}
	
	public LinkedListException(String message)
	{
		super(message);
	}
}
