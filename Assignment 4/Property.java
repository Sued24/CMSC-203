
public class Property // private fields with all of the attributes
{
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	public Property() // default constructor
	{
		 city = "";
		 owner = "";
		 propertyName = "";
		 rentAmount = 0;
		 plot = new Plot();
	}
	
	public Property(Property property) // copy constructor
	{
		this.city = property.getCity();
		this.owner = property.getOwner();
		this.propertyName = property.getPropertyName();
		this.rentAmount = property.getRentAmount();
		this.plot = property.getPlot();
	}
	
	public Property(String propertyName , String city , double rentAmount , String owner) 
	{
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot();
	}
	
	public Property(String propertyName , String city , double rentAmount , String owner , int x , int y , int width , int depth)
	{
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot(x , y , width , depth);
	}
	
	// Set and get methods
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public void setPropertyName (String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	public String getPropertyName()
	{
		return propertyName;
	}
	
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	public void setPlot(Plot plot)
	{
		this.plot = new Plot(plot);
	}
	
	public Plot getPlot()
	{
		return new Plot(this.plot);
	}
	
	public String toString() // toString() method that returns a string with all of the info of Property fields
	{
		return "Property Name: " + propertyName + "\n"
				+ "Located in " + city + "\n"
				+ "Belonging to: " + owner + "\n"
				+ "Rent Amount: " + rentAmount;
	}
}


