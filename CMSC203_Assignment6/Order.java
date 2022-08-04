import java.util.Random;
import java.util.ArrayList;

/**
 * CMSC 203
 * CRN 202420
 * Professor: Dr. GrinBerg
 * Due Date: 08/07/2022
 * 
 * Order class contains information and methods for customer orders, it implements its order interface and the comparable interface.
 * 
 * @author Santiago Sued
 *
 */

public class Order implements OrderInterface, Comparable<Order>
{
	/**
	 * Order number, assigned randomly.
	 */
	private int orderNum;
	/**
	 * Time of order.
	 */
	private int orderTime;
	/**
	 * Day of order.
	 */
	private DAY orderDay;
	/**
	 * Customer who ordered.
	 */
	private Customer customer;
	/**
	 * Beverage list containing all of the beverages in the order.
	 */
	private ArrayList<Beverage> beverageList = new ArrayList<Beverage>();
	/**
	 * Static order number list, responsible for saving previous order numbers.
	 */
	public static ArrayList<Integer> orderNums = new ArrayList<Integer>();
	
	/**
	 * Constructor initializes order fields.
	 * @param orderTime Time of order.
	 * @param orderDay Day of order.
	 * @param customerName Name of the customer who ordered.
	 * @param customerAge Age of the customer who ordered.
	 */
	public Order(int orderTime, DAY orderDay , String customerName , int customerAge)
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = new Customer(customerName , customerAge);
		this.orderNum = getOrderNum(); // Calls orderNum method to generate the order number.
	}
	
	/**
	 * Constructor initializes order fields.
	 * @param orderTime Time of order.
	 * @param orderDay Day of order.
	 * @param customer Customer who ordered.
	 */
	public Order(int orderTime, DAY orderDay , Customer customer)
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = new Customer(customer);
		this.orderNum = getOrderNum();
	}
	
	/**
	 * Returns order number, as well as adds the number to the order number list. If the number was already in the list, generates a new order number.
	 * @return
	 */
	public int getOrderNum() // Should not repeat with this setup.
	{
		int randomNum = 0;
		
		Random random = new Random();
		randomNum = (random.nextInt(90001) + 10000);
		
		for(int i = 0 ; i < orderNums.size(); i++) // Checks every item in the list.
		{
			while (orderNums.get(i) == randomNum) // If the number is equal to any order number, generate a new number and check the entire list again.
			{
				randomNum = (random.nextInt(90001) + 10000);
				i = 0;
			}

		}
		
		orderNums.add(randomNum); // If the number hasn't appeared before, add it to the list and return it.
		
		return randomNum;
	}
		
	/**
	 *  Overriden method from the order interface. Returns true if the order was made on the weekend.
	 *  @return isWeekend - True if order was made on the weekend.
	 */
	@Override
	public boolean isWeekend() 
	{
		boolean isWeekend = false;
		
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY)
			isWeekend = true;
		
		return isWeekend;
	}

	/**
	 * Overriden method from the order interface. Returns the beverage at a given position on the beverage list.
	 * @param itemNo - Position of the beverage in the list.
	 * @return beverage - Beverage in the beverage list.
	 */
	@Override
	public Beverage getBeverage(int itemNo) {
	
		return beverageList.get(itemNo);
	}

	/**
	 * Overriden method from the order interface. Overloaded method that adds a coffee beverage to the end of the beverage list.
	 * @param bevName Name of the coffee.
	 * @param size Size of the coffee.
	 * @param extraShot If the coffee has an extra shot.
	 * @param extraSyrup If the coffe has extra syrup.
	 */
	@Override
	public void addNewBeverage(String bevName , SIZE size , boolean extraShot , boolean extraSyrup) 
	{
		Coffee coffee = new Coffee(bevName , size , extraShot , extraSyrup);
		beverageList.add(coffee);
	}

	/**
	 * Overriden method from the order interface. Overloaded method that adds an alcohol beverage to the end of the beverage list.
	 * @param bevName Name of the alcohol.
	 * @param size Size of the alcohol.
	 */
	@Override 
	public void addNewBeverage(String bevName , SIZE size) 
	{
		Alcohol alcohol = new Alcohol(bevName , size , isWeekend());
		beverageList.add(alcohol);
	}

	/**
	 * Overriden method from the order interface. Overloaded method that adds a smoothie beverage to the end of the beverage list.
	 * @param bevName Name of the smoothie.
	 * @param size Size of the smoothie.
	 * @param numOfFruits number of fruits in the smoothie.
	 * @param addProtein if the smoothie has extra protein.
	 */
	@Override
	public void addNewBeverage(String bevName , SIZE size , int numOfFruits , boolean addProtein) 
	{
		Smoothie smoothie = new Smoothie(bevName , size , numOfFruits , addProtein);
		beverageList.add(smoothie);
	}

	/**
	 * Overriden method from the order interface. Calculates the total price of all of the beverages by calling the calcprice method for each.
	 * @return total - The total cost of all of the beverages in the list.
	 */
	@Override
	public double calcOrderTotal() {
		double total = 0;
		
		for(Beverage bev : beverageList)
			total += bev.calcPrice();
		
		return total;
	}

	/**
	 * Overriden method from the order interface. Returns the number of beverages of a certain type in the list.
	 * @return count - Number of beverages of a certain type in the list.
	 */
	@Override
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		
		for(Beverage bev : beverageList)
			if(bev.getType() == type)
				count += 1;
		
		return count;
	}

	/**
	 * Overriden compareTo method from the comparable class. Returns integers which signal which order has the biggest order number.
	 * @param order Order to compare to.
	 * @return -1 If the calling order is smaller, 0 if they are the same, 1 if the calling order is bigger.
	 */
	@Override
	public int compareTo(Order order) 
	{
		int output = 0;
		
		if (this.orderNum > order.getOrderNo())
			output = 1;
		else if (this.orderNum == order.getOrderNo())
			output = 0;
		else if (this.orderNum < order.getOrderNo())
			output = -1;
		
		return output;
	}

	/**
	 * Prints all of the information of the order.
	 * @return returnStr - Descriptive String.
	 */
	@Override
	public String toString()
	{
		String returnStr = "=============================================" + "\n"
		+ "Order Number: " + orderNum + " From customer: " + customer.getName() + "\n"
		+ "=============================================" + "\n";	
		for(Beverage bev : beverageList)
		{
			returnStr += "Beverage Type: " + bev.getType() + "\n";
			returnStr += "Beverage Name: " + bev.getBevName() + "\n";
			returnStr += "Beverage Size: " + bev.getSize() + "\n";
			returnStr += "Beverage Price: " + bev.calcPrice() + "\n";
			switch(bev.getType())
			{
				case COFFEE:
				{
					Coffee coffee = (Coffee) bev;
					returnStr += "Extra Coffee Shot: " + coffee.getExtraShot() + " , Extra Syrup: " + coffee.getExtraSyrup() + "\n";
					break;
				}
				case SMOOTHIE:
				{
					Smoothie smoothie = (Smoothie) bev;
					returnStr += "Number of fruits: " + smoothie.getNumOfFruits() + " , Extra Protein: " + smoothie.getAddProtein() + "\n";
					break;
				}
				case ALCOHOL:
				{
					Alcohol alcohol = (Alcohol) bev;
					returnStr += "Weekend markup: " + alcohol.getIfWeekend() + "\n";
					break;
				}
				default:
			}
			returnStr += "\n";
		}
		
		returnStr += "\n"
		+ "Total Price: " + calcOrderTotal() + "\n"
		+ "=============================================" + "\n";;
		
		return returnStr;
	}
	
	/**
	 * Returns the number of beverages on the list
	 * @return Number of beverages on the list.
	 */
	public int getTotalItems()
	{
		return beverageList.size();
	}
	
	/**
	 * Returns the order number.
	 * @return Order number.
	 */
	public int getOrderNo()
	{
		return orderNum;
	}
	
	/**
	 * Returns the customer responsible for the order.
	 * @return Customer object.
	 */
	public Customer getCustomer()
	{
		return new Customer(this.customer);
	}
	
	/**
	 * Returns the time the order was made.
	 * @return Time of order.
	 */
	public int getOrderTime()
	{
		return orderTime;
	}
	
	/**
	 *  Returns the day the order was made.
	 * @return Day of order.
	 */
	public DAY getOrderDay()
	{
		return orderDay;
	}
	
	/**
	 * Returns a copy of the beverage list.
	 * @return Copy of the order's beverage list.
	 */
	public ArrayList<Beverage> getBeverageList()
	{
		return new ArrayList<Beverage>(beverageList);
	}
}
