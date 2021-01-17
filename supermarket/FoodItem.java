package supermarket;

import java.time.LocalDate;

public class FoodItem extends Item
{
	private LocalDate expDate;
	
	//**also need setters now**
	public FoodItem(String upc, LocalDate expDate)
	{
		super(upc);
		this.expDate = expDate;
	}
	
	public FoodItem(String name, String company, String UPC, Category category, double price, LocalDate expDate)
	{
		super(name, company, UPC, category, price);
		this.expDate=expDate;
	}
	
	
	public FoodItem copy(FoodItem f)
	{
		return new FoodItem(f.getName(), f.getCompany(), f.getUPC(), f.getCategory(), f.getPrice(), f.expDate);
	}
	public String getExpDate()
	{
		String eDate=(expDate.getMonth()+" "+expDate.getDayOfMonth()+" "+expDate.getYear());
		return eDate;
	}

	@Override
	public String getUPC()
	{
		String UPC = super.getUPC();
		return UPC;
	}

	@Override
	public String toString() 
	{	
		return super.toString()+" ExpDate: "+this.getExpDate();
	}
	
}
