public class ManagementCompany // private fields 
{
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name;
	private String taxID;
	private Property[] properties;
	private Plot plot;
	
	public ManagementCompany() // Empty constructor
	{
		name = "";
		taxID = "";
		plot = new Plot(0 , 0 , MGMT_WIDTH , MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name , String taxID , double mgmFeePer)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(0 , 0 , MGMT_WIDTH , MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name , String taxID , double mgmFeePer , int x , int y , int width , int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(x , y , width , depth);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany managementCompany) // copy constructor
	{
		this.name = managementCompany.getName();
		this.taxID = managementCompany.getTaxID();
		this.mgmFeePer = managementCompany.getMgmFeePer();
		this.plot = new Plot(managementCompany.getPlot());
		for (int i = 0 ; i < MAX_PROPERTY ; i++) // loop copies all of the properties from calling stream
		{
			this.properties[i] = new Property(managementCompany.getProperty(i));
		}
	}
	
	// Set and get methods
	
	public String getName()
	{
		return name;
	}
	
	public Plot getPlot()
	{
		return new Plot(this.plot);
	}
	
	public String getTaxID()
	{
		return taxID;
	}
	
	public double getMgmFeePer() // Is this a potential security issue?
	{
		return mgmFeePer;
	}
	
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	
	public Property getProperty(int i)
	{
		return properties[i];
	}
	
	public int addProperty(Property property) // adds properties to the mgment company
	{
		int output = 0; // return variable
		if (properties[MAX_PROPERTY - 1] != null)
			output = -1; // If the final property in array is not null, string is full so set output to 1
		if (property == null) // If the property being added is null, return -2 and end method
			return -2;
		if (!this.plot.encompasses(property.getPlot())) // If the property being added is outside of the company plot, return -3 and end method
			return -3;
		
		for (int i = 0 ; i < MAX_PROPERTY ; i++) // check if all other properties don't overlap with this one
		{
			if(properties[i] != null)
				if (property.getPlot().overlaps(properties[i].getPlot()))
				{
					output = -4; // If they overlap, return -4 and break loop
/*					System.out.println("Property " + properties[i].getPlot().toString() + " overlaps " + property.getPlot().toString() + "\n");
					System.out.println("Property " + properties[i].toString() + "\n\n overlaps \n\n" + property.toString() + "\n\n");
					System.out.println((property.getPlot().overlaps(properties[i].getPlot()))); */
					break; 
				}
		}
		
		if (output != -4) // While the array spot isn't occupied add property to array then stop the loop.
			for (int i = 0 ; i < MAX_PROPERTY ; i++)
			{
				if(properties[i] == null)
				{
					properties[i] = new Property(property);
					output = i; // Set return variable to index of array
					break;
				}
			}
		return output;
	}
	
	public int addProperty(String name , String city , double rent , String owner) // all other add property methods work similarly with different arguments
	{
		Property property = new Property(name , city , rent , owner);
		
		int output = 0;
		if (properties[MAX_PROPERTY - 1] != null)
			output = -1;
		//if (property == null)
			//return -2;
		if (!this.plot.encompasses(property.getPlot()))
			return -3;
		
		for (int i = 0 ; i < MAX_PROPERTY ; i++)
		{
			if(properties[i] != null)
				if (property.getPlot().overlaps(properties[i].getPlot()))
				{
					output = -4;
/*					System.out.println("Property " + properties[i].getPlot().toString() + " overlaps " + property.getPlot().toString() + "\n");
					System.out.println("Property " + properties[i].toString() + "\n\n overlaps \n\n" + property.toString() + "\n\n");
					System.out.println((property.getPlot().overlaps(properties[i].getPlot()))); */
					break; 
				}
		}
		
		if (output != -4) 
			for (int i = 0 ; i < MAX_PROPERTY ; i++)
			{
				if(properties[i] == null)
				{
					properties[i] = new Property(property);
					output = i;
					break;
				}
			}
		
		return output;
	}
	
	public int addProperty(String name , String city , double rent , String owner , int x , int y , int width , int depth) // all other add property methods work similarly with different arguments
	{
		Property property = new Property(name , city , rent , owner , x , y , width , depth);
		
		int output = 0;
		if (properties[MAX_PROPERTY - 1] != null) // Still needs work
			return -1;
		//if (property == null)
			//return -2;
		if (!this.plot.encompasses(property.getPlot()))
			return -3;
		
		for (int i = 0 ; i < MAX_PROPERTY ; i++)
		{
			if(properties[i] != null)
				if (property.getPlot().overlaps(properties[i].getPlot()))
				{
					output = -4;
/*					System.out.println("Property " + properties[i].getPlot().toString() + " overlaps " + property.getPlot().toString() + "\n");
					System.out.println("Property " + properties[i].toString() + "\n\n overlaps \n\n" + property.toString() + "\n\n");
					System.out.println((property.getPlot().overlaps(properties[i].getPlot()))); */
					break; 
				}
		}
		
		if (output != -4) 
			for (int i = 0 ; i < MAX_PROPERTY ; i++)
			{
				if(properties[i] == null)
				{
					properties[i] = new Property(property);
					output = i;
					break;
				}
			}
		
		return output;
	}
	
	public double totalRent() // Simple method that calculates rent by adding to a counter every properties rent amount.
	{
		double totalRent = 0;
		
		for (int i = 0 ; i < MAX_PROPERTY ; i++)
		{
			if (properties[i] != null)
				totalRent += properties[i].getRentAmount();
		}
		
		return totalRent;
	}
	
	public double maxRentProp() // Simple method that calculates which property has the highest rent
	{
		double maxRent = properties[0].getRentAmount();
		
		for (int i = 1 ; i < MAX_PROPERTY ; i++)
		{
			if (properties[i] != null)
				if (maxRent < properties[i].getRentAmount())
					maxRent = properties[i].getRentAmount();
		}
		
		return maxRent;
	}
	
	public double maxRentPropertyIndex() // Similar to the previous method but returns the index of the highest rent property
	{
		double maxRent = properties[0].getRentAmount();
		int maxIndex = 0;
		
		for (int i = 1 ; i < MAX_PROPERTY ; i++)
		{
			if (maxRent < properties[i].getRentAmount())
			{
				maxRent = properties[i].getRentAmount();
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	public double totalFee() // Divides the total rate times the percantage of the fee rate
	{
		double totalFee;
		totalFee = this.totalRent() * (this.mgmFeePer / 100);
		return totalFee;
	}
	
	public String toString() // toString() method returns string with field info
	{
		String printString = "List of the Properties for " + this.name +", taxID: " + this.taxID + "\n"
				+ "______________________________________________________" + "\n\n";
		
		for (int i = 0 ; i < MAX_PROPERTY ; i++)
		{
			if (properties[i] != null)
				printString += properties[i].toString() + "\n\n";
		}
		
		printString += "______________________________________________________" + "\n"
					+ "total management Fee: " + this.totalFee();

		return printString;
	}
}
