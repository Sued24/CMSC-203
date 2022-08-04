/**
 * CMSC 203
 * CRN 202420
 * Professor: Dr. GrinBerg
 * Due Date: 08/07/2022
 * 
 * Customer class which contains information for a customer.
 * 
 * @author Santiago Sued
 *
 */

public class Customer
{
	/**
	 * Name of customer.
	 */
	private String name;
	/**
	 * Age of customer.
	 */
	private int age;
	
	/**
	 * Constructor initializes customer age and name.
	 * @param name Customer name.
	 * @param age Customer age.
	 */
	public Customer(String name , int age)
	{
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Copy constructor, copies the fields of parameter costumer.
	 * @param customer Parameter costumer object to copy.
	 */
	public Customer(Customer customer)
	{
		this.name = customer.getName();
		this.age = customer.getAge();
	}
	
	/**
	 * Prints all of the information of the customer.
	 * @return returnStr - Descriptive String.
	 */
	public String toString()
	{
		return "Customer name: " + name + "\n"
				+ "Customer age: " + age;
	}
	
	/**
	 * Returns costumer name.
	 * @return name - Costumer name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the name of the costumer
	 * @param name Costumer name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Returns costumer age.
	 * @return age - Costumer age.
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * Sets the age of the costumer.
	 * @param age - Costumer age.
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
}
