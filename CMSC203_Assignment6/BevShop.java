import java.util.ArrayList;

/**
 * CMSC 203
 * CRN 202420
 * Professor: Dr. GrinBerg
 * Due Date: 08/07/2022
 * 
 * BevShop class contains information and methods for running a bevshop. It utilizes all other classes and implements the BevShopInterface.
 * 
 * @author Santiago Sued
 *
 */

public class BevShop implements BevShopInterface 
{
	/**
	 * Number of alcohol beverages in an order.
	 */
	private int alcoholCount;
	/**
	 * List of orders.
	 */
	private ArrayList<Order> orderList = new ArrayList<Order>();
	
	/**
	 * Checks if the order was given at a valid time, utilizes constants in the BevShopInterface.
	 * @param time The time the order was given.
	 * @return True if the order was given between the allowed hours.
	 */
	@Override
	public boolean validTime(int time) 
	{
		boolean validTime = false;
		
		if(time >= MIN_TIME && time <= MAX_TIME)
			validTime = true;
			
		return validTime;
	}
	
	/**
	 * Checks if the alcohol beverage limit has been reached.
	 * @return True if it has been reached.
	 */
	@Override
	public boolean eligibleForMore() 
	{
		boolean eligible = false;
		
		if(alcoholCount < MAX_ORDER_FOR_ALCOHOL)
			eligible = true;
		
		return eligible;
	}

	/**
	 * Checks if the age of the customer is above the minimum age for alcohol.
	 * @param age Age of the customer.
	 * @return True if it is.
	 */
	@Override
	public boolean validAge(int age) 
	{
		boolean validAge = false;
		
		if(age > MIN_AGE_FOR_ALCOHOL)
		validAge = true;
			
		return validAge;
	}

	/**
	 * Starts a new order
	 * @param time Time of the order.
	 * @param day Day of the order.
	 * @param customerName Name of the customer.
	 * @param customerAge Age of the customer.
	 */
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) 
	{
		alcoholCount = 0;
		Order order = new Order(time , day , customerName , customerAge);
		orderList.add(order);
	}

	/**
	 * Adds a coffee to the most recent order.
	 * @param bevName Coffee name.
	 * @param size Coffee size.
	 * @param extraShot If the coffee has an extra shot.
	 * @param extraSyrup If the coffee has extra syrup.
	 */
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) 
	{
		orderList.get(orderList.size() - 1).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	/**
	 * Adds an alcohol to the most recent order and increases the alcohol count.
	 * @param bevName Alcohol name.
	 * @param size Alcohol size.
	 */
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) 
	{
			orderList.get(orderList.size() - 1).addNewBeverage(bevName, size);
			alcoholCount++;
	}

	/**
	 * Adds a smoothie to the most recent order.
	 * @param bevName Smoothie name.
	 * @param size Smoothie size.
	 * @param numOfFruits number of fruits in the smoothie.
	 * @param addProtien If the smoothie has extra protein.
	 */
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) 
	{
		orderList.get(orderList.size() - 1).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	/**
	 * Find a specific order, given its number
	 * @param orderNo The number of the order.
	 * @return The position of the specified order.
	 */
	@Override
	public int findOrder(int orderNo) {
		int index = -1;
		
		for(int i = 0 ; i < orderList.size() ; i++)
			if(orderList.get(i).getOrderNo() == orderNo)
				index = i;
		
		return index;
	}

	/**
	 * Returns the price of a specific order, given its number.
	 * @param orderNo The number of the order.
	 * @return The price of the beverages in the specific order.
	 */
	@Override
	public double totalOrderPrice(int orderNo) 
	{ 
		double ordTotal = -1;
		
		for(Order ord : orderList)
			if(ord.getOrderNo() == orderNo)
				ordTotal = ord.calcOrderTotal();
		
		return ordTotal;
	}
	
	/**
	 * Returns the total price of all of the orders in the order list.
	 * @return total monthly price.
	 */
	@Override
	public double totalMonthlySale() 
	{
		double total = 0;
		
		for(Order ord : orderList)
			total += ord.calcOrderTotal();
			
		return total;
	}

	/**
	 * Utilizes the selection sort algorithm to sort orders by ordernumber utilizing its compareTo method.
	 */
	@Override
	public void sortOrders()  // Modify
	{
		int min;
		Order temp;

		for (int i = 0; i < orderList.size(); i++)
		{
			min = i;
			for (int j = i + 1; j< orderList.size(); j++)
				if (orderList.get(j).compareTo(orderList.get(min)) < 0)
					min = j;

			temp = orderList.get(min);
			orderList.set(min, orderList.get(i));
			orderList.set(i, temp);
		}
	}

	/**
	 * Returns order at a specific position in the order list.
	 * @param index Position of the order.
	 * @return Order at position.
	 */
	@Override
	public Order getOrderAtIndex(int index) {
		return orderList.get(index);
	}

	/**
	 * Returns the last order on the list.
	 * @return final order on the list.
	 */
	public Order getCurrentOrder()
	{
		return orderList.get(orderList.size() - 1);
	}
	
	/**
	 * Returns the number of alcohol drinks in the current order.
	 * @return Number of alcohol drinks in the current order.
	 */
	public int getNumOfAlcoholDrink()
	{
		int alcoholCount = 0;
		Order currentOrder = orderList.get(orderList.size() - 1);
		
		for(int i = 0 ; i < currentOrder.getBeverageList().size() ; i++)
			if(currentOrder.getBeverageList().get(i).getType() == TYPE.ALCOHOL)
				alcoholCount++;
			
		//for(Order ord : orderList) Residual code for calculating the number of alcohol drinks in ALL OF THE ORDERS. 
			//for(int i = 0 ; i < orderList.size() ; i++)
				//for(int j = 0 ; j < orderList.get(i).getBeverageList().size(); j++)
					//if(orderList.get(i).getBeverageList().get(j).getType() == TYPE.ALCOHOL)
						//alcoholCount++;
		
		return alcoholCount;
	}
	
	/**
	 * Returns the total amount of orders.
	 * @return Number of orders on the list.
	 */
	public int totalNumOfMonthlyOrders()
	{
		int numOrders = 0;
		
		for(Order ord : orderList)
			numOrders++;
		
		return numOrders;
	}
	
	/**
	 * Determines if the smoothie ordered has too many fruits.
	 * @param maxF Number of fruits to put on the smoothie.
	 * @return If the number exceeds the limit, return true.
	 */
	public boolean isMaxFruit(int maxF)
	{
		boolean isMaxFruit = false;
		
		if (MAX_FRUIT < maxF)
			isMaxFruit = true;
		
		return isMaxFruit;
	}
	
	/**
	 * ¡Prints all of the information of the beverage shop.
	 * @return returnStr - Descriptive String.
	 */
	public String toString()
	{
		String returnStr = "Santiago's Beverage Shop \n\n";
		
		for(Order ord : orderList)
			returnStr += ord.toString();
		
		returnStr += "\n\tFinal Monthly Salary: " + totalMonthlySale() + "\n";
		return returnStr;
	}
	
	/**
	 * Returns the max orders of alcohol allowed.
	 * @return max order of alcohol allowed.
	 */
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * Returns the minimum age for alcohol.
	 * @return Minimum age for alcohol consumption.
	 */
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
 /**
  * Overriden method from interface, returns the maximum number of fruits allowed on a smoothie.
  * @return Maximum number of fruits allowed on a smoothie.
  */
	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
}
