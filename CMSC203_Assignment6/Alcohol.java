/**
 * CMSC 203
 * CRN 202420
 * Professor: Dr. GrinBerg
 * Due Date: 08/07/2022
 * 
 * Alcohol class extends the beverage class adding specific methods for alcohol orders.
 * 
 * @author Santiago Sued
 *
 */

public class Alcohol extends Beverage 
{
	/**
	 * True if the order was given on a weekend.
	 */
	private boolean isWeekend;
	
	/**
	 * The added cost of ordering alcohol on the weekend.
	 */
	private final double WEEKENDCOST = 0.6;
	
	/**
	 * Constructor uses the beverage constructor as well as initializing the isWeekend field.
	 * @param bevName Name of the alcohol beverage.
	 * @param bevSize Size of the alcohol beverage.
	 * @param isWeekend Boolean that returns if it is the weekend or not.
	 */
	public Alcohol(String bevName , SIZE bevSize , boolean isWeekend)
	{
		super(bevName , TYPE.ALCOHOL, bevSize);
		this.isWeekend = isWeekend;
	}
	
	/**
	 * Overrides calcPrice in the beverage class. The price of the alcohol depending on its size and day of the week ordered.
	 * @return price - The price of the alcohol.
	 */
	@Override
	public double calcPrice() // Every size upgrade adds a addedprice constant. Weekend cost is also added if the order was made in the weekend.
	{
		double price = getBasePrice();
		
		if(getSize() == SIZE.MEDIUM)
			price += getAddedPrice();
		if(getSize() == SIZE.LARGE)
			price += (2 * getAddedPrice());
		if(isWeekend)
			price += WEEKENDCOST;
		
		return price;
	}

	/**
	 * Overrides toString in the beverage class. Prints all of the information of the alcohol beverage.
	 * @return returnStr - Descriptive String.
	 */
	@Override
	public String toString() 
	{
		return super.toString()
				+ "Is offered in the weekend: " + isWeekend + "\n"
				+ "Alcoholic beverage price: " + calcPrice();
	}

	/**
	 * Overrides equals in the beverage class. Compares different alcoholic beverages' fields to determine if they are the same.
	 * @param beverage Parameter beverage to compare.
	 * @return equals - returns true if they are equal.
	 */
	@Override
	public boolean equals(Beverage beverage) {
		boolean equals = false;
		Alcohol alcohol = (Alcohol) beverage; // Cast beverage object as an alcohol subclass.
		
		if(super.equals(beverage) &&
			isWeekend == alcohol.getIfWeekend())
			equals = true;
		
		return equals;
	}

	/**
	 * Returns if the alcohol was ordered on the weekend.
	 * @return isWeekend - boolean that indicates if the alcohol was ordered on the weekend.
	 */
	public boolean getIfWeekend()
	{
		return isWeekend;
	}
}
