package biddingAuction;

public interface StackInterface<T>
{
	public void pop();
	public void push(T t);
	public T top();
	public boolean isEmpty();
	
}
