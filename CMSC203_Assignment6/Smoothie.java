/**
 * CMSC 203
 * CRN 202420
 * Professor: Dr. GrinBerg
 * Due Date: 08/07/2022
 * 
 * Smoothie class extends the beverage class adding specific methods for smoothie orders.
 * 
 * @author Santiago Sued
 *
 */


public class Smoothie extends Beverage 
{
	/**
	 * Number of fruits in the smoothie.
	 */
	private int numOfFruits;
	/**
	 * Price for adding fruits to the smoothie.
	 */
	private final double ADDFRUIT = 0.5;
	/**
	 * Boolean that returns if protein is added to the smoothie.
	 */
	private boolean addProtein;
	/**
	 * The cost of adding protein.
	 */
	private final double PROTEINCOST = 1.5;

	/**
	 * Constructor uses the beverage constructor as well as initializing numOfFruits and addProtein fields.
	 * @param bevName Name of the smoothie.
	 * @param bevSize Size of the smoothie.
	 * @param numOfFruits Number of fruits in the smoothie.
	 * @param addProtein If protein is added to the smoothie.
	 */
	public Smoothie(String bevName , SIZE bevSize , int numOfFruits , boolean addProtein)
	{
		super(bevName , TYPE.SMOOTHIE, bevSize);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;// Is this ok?
	}
	
	/**
	 * Overrides calcPrice in the beverage class. Calculates the price of smoothie given its size, the number of fruits and if it has extra protein.
	 * @return price - The price of the smoothie.
	 */
	@Override
	public double calcPrice() // Every size upgrade adds a addedprice constant. Added protein adds its respective amount and adds the price of each fruit.
	{
		double price = getBasePrice();
		
		if(getSize() == SIZE.MEDIUM)
			price += getAddedPrice();
		if(getSize() == SIZE.LARGE)
			price += (2 * getAddedPrice());
			price += numOfFruits * ADDFRUIT;
		if(addProtein)
			price += PROTEINCOST;
		
		return price;
	}

	/**
	 * Overrides toString in the beverage class. Prints all of the information of the smoothie beverage.
	 * @return returnStr - Descriptive String.
	 */
	@Override
	public String toString() 
	{
		return super.toString()
				+ "Contains " + numOfFruits + " fruits" + "\n"
				+ "Contains added protein: " + addProtein + "\n"
				+ "Smoothie price: " + calcPrice();
	}

	/**
	 * Overrides equals in the beverage class. Compares different smoothies' fields to determine if they are the same.
	 * @param beverage Parameter beverage to compare.
	 * @return equals - returns true if they are equal.
	 */
	@Override
	public boolean equals(Beverage beverage) 
	{
		boolean equals = false;
		Smoothie smoothie = (Smoothie) beverage; 
		
		if(super.equals(beverage) &&
			numOfFruits == smoothie.getNumOfFruits() &&
			addProtein == smoothie.getAddProtein())
			equals = true;
		
		return equals;
	}

	/**
	 * Returns the number of fruits in the smoothie.
	 * @return numOfFruits - The number of fruits in the smoothie.
	 */
	public int getNumOfFruits()
	{
		return numOfFruits;
	}
	
	/**
	 * Returns if extra protein was added.
	 * @return addProtein - returns if protein was added.
	 */
	public boolean getAddProtein()
	{
		return addProtein;
	}
}
