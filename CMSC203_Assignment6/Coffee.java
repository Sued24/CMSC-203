/**
 * CMSC 203
 * CRN 202420
 * Professor: Dr. GrinBerg
 * Due Date: 08/07/2022
 * 
 * Coffee class extends the beverage class adding specific methods for coffee orders.
 * 
 * @author Santiago Sued
 *
 */

public class Coffee extends Beverage 
{
	/**
	 * Determines if the coffee has an extra shot of coffee.
	 */
	private boolean extraCoffee;
	/**
	 * Determines if the coffee has extra syrup.
	 */
	private boolean extraSyrup;
	/**
	 * Price of the extra coffee shot.
	 */
	private final double PRICEEXTRACOFFEE = 0.5;
	/**
	 * Price of the extra syrup.
	 */
	private final double PRICEEXTRASYRUP = 0.5;
	
	/**
	 * Constructor uses the beverage constructor as well as initializing extraSyrup and extraCoffee fields.
	 * @param bevName Name of the coffee.
	 * @param bevSize Size of the coffee.
	 * @param extraCoffee If the coffee has an extra shot.
	 * @param extraSyrup If the coffee has extra syrup.
	 */
	public Coffee(String bevName , SIZE bevSize , boolean extraCoffee , boolean extraSyrup)
	{
		super(bevName , TYPE.COFFEE, bevSize);
		this.extraCoffee = extraCoffee;
		this.extraSyrup = extraSyrup;
	}
	
	/**
	 * Overrides calcPrice in the beverage class. Calculates the price of coffee given its size and if they have extra shot/syrup.
	 * @return price - The price of the coffee.
	 */
	@Override
	public double calcPrice() 
	{
		double price = getBasePrice(); // Every size upgrade adds a addedprice constant. Extra syrup and coffee also adds their respective constants.
		
		if(getSize() == SIZE.MEDIUM)
			price += getAddedPrice();
		if(getSize() == SIZE.LARGE)
			price += (2 * getAddedPrice());
		if(extraCoffee)
			price += PRICEEXTRACOFFEE;
		if(extraSyrup)
			price += PRICEEXTRASYRUP;
		
		return price;
	}

	/**
	 * Overrides toString in the beverage class. Prints all of the information of the coffee beverage.
	 * @return returnStr - Descriptive String.
	 */
	@Override
	public String toString() 
	{
		return super.toString()
				+ "Contains extra coffee shot: " + extraCoffee + "\n"
				+ "Contains extra syrup: " + extraSyrup + "\n"
				+ "Coffe price: " + calcPrice();
	}

	/**
	 * Overrides equals in the beverage class. Compares different coffees' fields to determine if they are the same.
	 * @param beverage Parameter beverage to compare.
	 * @return equals - returns true if they are equal.
	 */
	@Override
	public boolean equals(Beverage beverage)
	{
		boolean equals = false;
		Coffee coffee = (Coffee) beverage; 
		
		if(super.equals(beverage) &&
			extraCoffee == coffee.getExtraShot() &&
			extraSyrup == coffee.getExtraSyrup())
			equals = true;
		
		return equals;
	}
	
	/**
	 * Returns if an extra coffee shot was added.
	 * @return isWeekend - boolean that indicates if an extra coffee shot was added.
	 */
	public boolean getExtraShot()
	{
		return extraCoffee;
	}
	
	/**
	 * Returns if extra syrup was added.
	 * @return isWeekend - boolean that indicates if extra syrup was added.
	 */
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}

}
