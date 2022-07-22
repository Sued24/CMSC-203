/**
 * Holiday Bonus class utilized the tools in TwoDimRaggedArrayUtility class to calculate the holiday bonuses.
 * CMSC 203
 * Assignment 5
 * 7/22/2022
 * Eclipse IDE
 * @author Santiago Sued
 */
public class HolidayBonus 
{
	/** calculateHolidayBonus method returns an array with the holiday bonuses for all of the stores.
	 * 
	 * @param data 2D ragged array with all of the retail stores' earnings in each category.
	 * @param high Price reward given to a store for being the leading seller in a category.
	 * @param low Price reward given to a store for being the lowest seller in a category.
	 * @param other Price reward given to a store for not being the highest/lowest seller but still selling stock in a category.
	 * @return hBonus 1 Dimensional array with all of the stores' bonuses.
	 */
	public static double[]	calculateHolidayBonus(double[][] data, double high, double low, double other)
	{
		double[] hBonus = new double[data.length];
		
		for(int i = 0 ; i < data.length ; i++)
			for(int j = 0 ; j < data[i].length ; j++)
			{
				if(TwoDimRaggedArrayUtility.getHighestInColumnIndex(data , j) == i && data[i][j] > 0)
					hBonus[i] += high;
				else if (TwoDimRaggedArrayUtility.getLowestInColumnIndex(data , j) == i && data[i][j] > 0)
					hBonus[i] += low;
				else if (data[i][j] > 0)
					hBonus[i] += other;
			}
		
		return hBonus;
	}
	
	/** calculateTotalHolidayBonus method returns the additive total of all of the holiday bonuses of all stores.
	 * 
	 * @param data 2D ragged array with all of the retail stores' earnings in each category.
	 * @param high Price reward given to a store for being the leading seller in a category.
	 * @param low Price reward given to a store for being the lowest seller in a category.
	 * @param other Price reward given to a store for not being the highest/lowest seller but still selling stock in a category.
	 * @return total Additive total of all of the holiday bonuses of all stores.
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
	{
		double[] hBonus = new double[data.length];
		double total = 0;
		
		for(int i = 0 ; i < data.length ; i++)
			for(int j = 0 ; j < data[i].length ; j++)
			{
				if(TwoDimRaggedArrayUtility.getHighestInColumnIndex(data , j) == i && data[i][j] > 0)
					hBonus[i] += high;
				else if (TwoDimRaggedArrayUtility.getLowestInColumnIndex(data , j) == i && data[i][j] > 0)
					hBonus[i] += low;
				else if (data[i][j] > 0)
					hBonus[i] += other;
			}
		
		for(int i = 0 ; i < hBonus.length ; i++)
			total += hBonus[i];
		
		return total;
	}
}
