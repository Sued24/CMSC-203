/**
 * CMSC 203
 * CRN 202420
 * Professor: Dr. GrinBerg
 * Due Date: 08/07/2022
 * 
 * Beverage class is an abstract class. Utilized to create beverage subclasses.
 * 
 * @author Santiago Sued
 *
 */
public abstract class Beverage 
{
	/**
	 *  Name of the beverage.
	 */
	private String bevName;
	/**
	 * Type of the beverage, corresponds to the TYPE enumerated type.
	 */
	private TYPE bevType;
	/**
	 * Size of the beverage, corresponds to the SIZE enumerated type.
	 */
	private SIZE bevSize;
	/**
	 * Base price of the beverage, all beverages start with a $2 cost.
	 */
	private final double BASEPRICE = 2.0;
	/**
	 * Added price of the beverage, each increment in size increases the cost by $1.
	 */
	private final double ADDEDPRICE = 1.0;
	
	/**
	 *  Constructor takes the beverage name, type and size and initializes their respective fields.
	 * @param bevName Name of the beverage.
	 * @param bevType Type of the beverage.
	 * @param bevSize Size of the beverage.
	 */
	public Beverage(String bevName , TYPE bevType , SIZE bevSize)
	{
		this.bevName = bevName;
		this.bevType = bevType;
		this.bevSize = bevSize;
	}
	
	/**
	 * abstract price calculation method for future beverages.
	 * 
	 */
	public abstract double calcPrice();

	/**
	 * Prints all of the information of the beverage.
	 * @return returnStr - Descriptive String.
	 */
	public String toString()
	{
		return "Beverage Name: " + bevName + "\n"
				+ "Beverage Size: " + bevSize + "\n"
				+ "Beverage Type: " + bevType + "\n";
	}
	
	/**
	 * Compares different beverages' fields to determine if they are the same.
	 * @param beverage Parameter beverage to compare.
	 * @return equals - returns true if they are equal.
	 */
	public boolean equals(Beverage beverage)
	{
		boolean equals = false;
		
		if(bevName == beverage.getBevName() &&
			bevType == beverage.getType() &&
			bevSize == beverage.getSize())
			equals = true;
		
		return equals;
	}
	/**
	 * Returns beverage name.
	 * @return beverageName - Name of the beverage.
	 */
	public String getBevName()
	{
		return this.bevName;
	}

	/**
	 * Sets the name of the beverage.
	 * @param bevName Name of the beverage.
	 */
	public void setBevName(String bevName)
	{
		this.bevName = bevName;
	}
	
	/**
	 * Returns beverage type.
	 * @return beverageType - Type of the beverage.
	 */
	public TYPE getType()
	{
		return this.bevType;
	}
	
	/**
	 * Sets the type of the beverage.
	 * @param bevType Type of the beverage.
	 */
	public void setType(TYPE bevType)
	{
		this.bevType = bevType;
	}
	
	/**
	 * Returns beverage size.
	 * @return beverageSize - Size of the beverage.
	 */
	public SIZE getSize()
	{
		return this.bevSize;
	}
	
	/**
	 * Sets the size of the beverage.
	 * @param bevSize Size of the beverage.
	 */
	public void setSize(SIZE bevSize)
	{
		this.bevSize = bevSize;
	}
	
	/**
	 * Returns beverage base price.
	 * @return BASEPRICE - Base price of the beverage.
	 */
	public double getBasePrice()
	{
		return BASEPRICE;
	}
	
	/**
	 * Returns beverage added price.
	 * @return ADDEDPRICE - Added price of the beverage.
	 */
	public double getAddedPrice()
	{
		return ADDEDPRICE;
	}
}
