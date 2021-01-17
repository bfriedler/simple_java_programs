package biddingAuction;

public class Bidder 
{
	private String name;
	private int maxBid;
	public Bidder(String name, int maxBid)
	{
		this.name=name;
		this.maxBid=maxBid;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getMaxBid()
	{
		return maxBid;
	}
}
