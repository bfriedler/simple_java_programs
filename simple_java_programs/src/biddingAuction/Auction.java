package biddingAuction;

import java.util.Scanner;

public class Auction 
{
	public static void main(String[] args)
	{
		LinkedStack<Bidder> bidders= new LinkedStack<>();
		Bidder b;
		String bidderName;
		int bidderMaxBid;
		Scanner keyboard=new Scanner(System.in);
		StringBuilder results=new StringBuilder();
		int currHighBid=0;
		int currMaxBid=0;
		System.out.println("Welcome to the Auction! Lets start Bidding!");
		int option=getOption(keyboard);
		
		
		
		while(option==1)
		{
			bidderName=getBidderName(keyboard);
			bidderMaxBid=getBidderMaxBid(keyboard);
			b = new Bidder(bidderName, bidderMaxBid);
			if(bidders.isEmpty())
			{
				bidders.push(b);
				currHighBid=1;
				currMaxBid=b.getMaxBid();
				results.insert(0, "\n"+b.getName()+"\t\t"+currHighBid);
			}
			else 
			{
				if(b.getMaxBid()>currHighBid && b.getMaxBid()<currMaxBid)
				{
					
					currHighBid=b.getMaxBid();
					results.insert(0, "\n"+bidders.top().getName()+"\t\t"+currHighBid);
				}
				else if(b.getMaxBid()>bidders.top().getMaxBid())
				{
					currHighBid=(bidders.top().getMaxBid())+1;
					bidders.push(b);
					results.insert(0, "\n"+bidders.top().getName()+"\t\t"+currHighBid);
				}
			}
			System.out.println("auction updated ");
			option=getOption(keyboard);
		}
		
		results.insert(0, "\nBidder:    Bid History:");
		printResults(results);

		

		//System.out.println("New Bid \t Result \t High Bidder \t High Bid \t Maximum Bid");

		
	}
	public static int getOption(Scanner keyboard)
	{
		int option;
		System.out.println("To enter a new bidder, enter 1");
		System.out.println("To stop the auction, enter 2");
		option=keyboard.nextInt();

		if(option !=1 && option !=2)
		{
			System.out.println("invalid option");
			System.out.println("To enter a new bidder, enter 1");
			System.out.println("To stop the auction, enter 2");
			option=keyboard.nextInt();
		}
		keyboard.nextLine();
		return option;
	}
	
	public static void printResults(StringBuilder results)
	{
		System.out.println("\nAuction had Ended \nAuction History: ");
	//	results.reverse();
		System.out.println(results);
	}
	
	public static String getBidderName(Scanner keyboard)
	{
		System.out.println("Bidder Name: ");
		return keyboard.nextLine();
	}
	
	public static int getBidderMaxBid(Scanner keyboard) 
	{
		System.out.println("Maximum Bid: ");
		int bid = keyboard.nextInt();
		while(bid<=0) 
		{
			System.out.println("Invalid amount");
			System.out.println("Maximum Bid: ");
			bid = keyboard.nextInt();
		}
		keyboard.nextLine();
		return bid;
	}
	
	/*public static StringBuilder addResults(StringBuilder results, Bidder currBidder, int currHighBid)
	{
		results.append(currBidder.getName()+"\t"+currHighBid); // need to format
	}*/
}
