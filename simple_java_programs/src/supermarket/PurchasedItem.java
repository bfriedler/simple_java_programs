package supermarket;

public class PurchasedItem 
{
	//food item
	private Item item;
	private int quantity;
	private double purchasePrice;
	private double totalCost;
	private boolean isFood=false;
	
	public PurchasedItem(Item item, int quantity, double purchasePrice)
	{
		this.item=item;
		this.quantity=quantity;
		this.purchasePrice=purchasePrice;
		totalCost=purchasePrice*quantity;
		if( item instanceof FoodItem)
		{
			isFood=true;
		}
	}
	
	public double getTotalCost()
	{
		return totalCost;
	}
	
	public double getPurchasePrice()
	{
		return purchasePrice;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	
	public String getItem()
	{
		return item.toString();
	}
	
	public String getUPC()//protected
	{
		return item.getUPC().toUpperCase();
	}

	@Override
	public String toString() {
		return "PurchasedItem [item=" + item.getUPC() + ", quantity=" + quantity + ", purchasePrice=" + purchasePrice
				+ ", totalCost=" + totalCost + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchasedItem other = (PurchasedItem) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (purchasePrice != other.purchasePrice)
			return false;
		if (quantity != other.quantity)
			return false;
		if (totalCost != other.totalCost)
			return false;
		return true;
	}
	
	public boolean getIsFood()
	{
		return isFood;
	}
	
	
	
}
