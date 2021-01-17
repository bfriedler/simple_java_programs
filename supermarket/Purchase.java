package supermarket;

import java.time.LocalDate;
import java.util.ArrayList;

public class Purchase 
{
	private ArrayList<PurchasedItem> purchasedItems = new ArrayList<>();
	//PurchasedItem purchasedItem;
	private String customerName;
	private LocalDate purchaseDate;
	
	//**need setters now**
	public Purchase()
	{
		
	}
	
	public Purchase(String customerName, String purchaseDate)
	{
		this.customerName=customerName;
		this.purchaseDate= LocalDate.parse(purchaseDate);
	}
	
	public void addPurchasedItem (PurchasedItem pI)
	{
		purchasedItems.add(pI);
	}
	
	public  void addPurchasedItem (Item theItem, int qtyPurchased)
	{
		PurchasedItem pI = new PurchasedItem(theItem, qtyPurchased, theItem.getPrice());
		purchasedItems.add(pI);
	}
	
	public double getPurchaseCost()
	{
		double totalPurchaseCost=0;
		double tax;
		double purchasedItemcost;
		for(int i=0; i<purchasedItems.size(); i++)
		{
			if(purchasedItems.get(i).getIsFood() == false)
			{
				tax=.0825*purchasedItems.get(i).getTotalCost();
				purchasedItemcost=(purchasedItems.get(i).getTotalCost()) + tax;
				totalPurchaseCost+=purchasedItemcost;
			}
			else
			{
				totalPurchaseCost+=purchasedItems.get(i).getTotalCost();			
			}
		}
		
		String formattedCost = String.format("%,2f", totalPurchaseCost);
		
		return Double.parseDouble(formattedCost);
		
	}
	
	public double getTax()
	{
		double tax=0.00;
		for(int i=0; i<purchasedItems.size(); i++)
		{
			if(purchasedItems.get(i).getIsFood() == false)
			{
				tax+=.0825*purchasedItems.get(i).getTotalCost();
			}
		}
		return tax;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	
	public LocalDate getPurchaseDate()
	{
		return purchaseDate;
	}

	@Override
	public String toString() {
		return "Purchase [purchasedItems=" + purchasedItems + ", customerName=" + customerName + ", purchaseDate="
				+ purchaseDate + "]";
	}
	
	public Item findItem(Item theItem)
	{
		Item searchItem=theItem;
		Item returnItem=null;
		
		for(int i=0; i<purchasedItems.size(); i++)
		{
			if(purchasedItems.get(i).getUPC().equalsIgnoreCase(searchItem.getUPC()))
			//if(purchasedItems.get(i).getUPC().contentEquals(searchItem.getUPC().toUpperCase()))
			{
				returnItem = new Item(searchItem.getName(), searchItem.getCompany(), searchItem.getUPC(),searchItem.getCategory(), searchItem.getPrice());
			}
		}
		return returnItem;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		return true;
	}
	
	
	//@Override
	/*public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		else
		{
			if (obj instanceof Purchase)
			{
				Purchase temp = (Purchase)obj;
				
			}
			else
			{
				return false;
			}
		}
		if(this.customerName.equalsIgnoreCase(p.customerName))
		{
			if(this.purchaseDate)
		}*/
	//}*/
 	
	/*@Override
	public int compareTo(Purchase obj)
	{
		if (this.customerName.equalsIgnoreCase(obj.customerName));
		{
			return this.purchaseDate.compareTo(obj.purchaseDate);
		}
		else
		{
			return this.
		}
	}*/
	
}
