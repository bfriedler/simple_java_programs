package biddingAuction;
import java.util.EmptyStackException;

public class LinkedStack <T> implements StackInterface<T>
{
	protected LLNode<T> top;
	
	public LinkedStack()
	{
		top=null;
	}
	
	public boolean isEmpty()
	{
		return (top==null);
	}
	
	public void push(T element)
	{
		LLNode<T> newNode = new LLNode<T> (element);
		newNode.setLink(top);
		top = newNode;
	}
	
	public void pop()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		else top=top.getLink();
	}
	
	public T top()
	{
		if(isEmpty()) 
		{
			throw new EmptyStackException();
		}
		else return top.getInfo();
	}
}
