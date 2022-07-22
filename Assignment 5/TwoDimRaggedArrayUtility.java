import java.io.*;
import java.util.Scanner;
/**
 * 2d Ragged Array Utility Class gives tools for accessing, modifying and setting items in 2d arrays, as well as file input/output.
 * CMSC 203
 * Assignment 5
 * 7/22/2022
 * Eclipse IDE
 * @author Santiago Sued
 */
public class TwoDimRaggedArrayUtility 
{
	/** readFile method will read a 2D, ragged array from a file and return it.
	 * 
	 * @param file Input file where the array is read from.
	 * @return data 2D array read from the file.
	 * @throws FileNotFoundException Exception in case file is not found.
	 */
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		String dataStr = "";
		
		try(Scanner inputFile = new Scanner(file))
		{
			while(inputFile.hasNext())
			{
				dataStr += inputFile.nextLine();
				dataStr += "\n";
			}
		}
		
		String[] rowStr = dataStr.split("\n");
		String[][] arrayStr = new String[rowStr.length][];
		
		for(int i = 0 ; i < rowStr.length ; i++)
			arrayStr[i] = rowStr[i].split(" ");
		
		double[][] data = new double[rowStr.length][];
		
		for(int i = 0 ; i < arrayStr.length ; i++)
		{
			data[i] = new double[arrayStr[i].length];
			for(int j = 0; j < arrayStr[i].length ; j++)
			{
				data[i][j] = Double.parseDouble(arrayStr[i][j]);
			}
		}
		
		return data;
	}
	
	/** writeToFile method will store a 2D, ragged array to a file with proper syntax.
	 * 
	 * @param data 2D, ragged array to be stored in file.
	 * @param file File where the array will be stored.
	 * @throws FileNotFoundException Exception in case file is not found.
	 */
	public static void	writeToFile(double[][] data, File file) throws FileNotFoundException
	{
		try(BufferedWriter fWriter = new BufferedWriter(new FileWriter(file));)
		{
			for(int i = 0 ; i < data.length ; i++)
			{
				for(int j = 0 ; j < data[i].length ; j++)
				{
					fWriter.write(Double.toString(data[i][j]));
					fWriter.write(" ");
				}
				fWriter.write("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/** getTotal method returns the total value of the sum of all of the doubles in the array.
	 * 
	 * @param data 2D, ragged array.
	 * @return total The total value of the sum of all doubles in the array.
	 */
	public static double getTotal(double[][] data)
	{
		double total = 0;
		
		for(int i = 0 ; i < data.length ; i++)
		{
			for(int j = 0; j < data[i].length ; j++)
			{
				total += data[i][j];
			}
		}
		
		return total;
	}
	
	/** getAverage method returns the average value of the doubles of the array.
	 * 
	 * @param data 2D, ragged array.
	 * @return average The average value of the doubles of the array.
	 */
	public static double getAverage(double[][] data)
	{
		double average = 0;
		int count = 0;
		
		for(int i = 0 ; i < data.length ; i++)
		{
			for(int j = 0; j < data[i].length ; j++)
			{
				average += data[i][j];
				count++;
			}
		}
		average /= count;
		
		return average;
	}
	
	/** getHighestInArray finds and returns the highest double value in the array.
	 * 
	 * @param data 2D, ragged array.
	 * @return highest The highest double value in the array.
	 */
	public static double getHighestInArray(double[][] data)
	{
		double highest = data[0][0];
		
		for(int i = 0 ; i < data.length ; i++)
		{
			for(int j = 0; j < data[i].length ; j++)
			{
				if(data[i][j] > highest)
					highest = data[i][j];
			}
		}
		
		return highest;
	}
	
	/** getLowestInArray finds and returns the lowest double value in the array.
	 * 
	 * @param data 2D, ragged array.
	 * @return lowest The lowest double value in the array.
	 */
	public static double getLowestInArray(double[][] data)
	{
		double lowest = data[0][0];
		
		for(int i = 0 ; i < data.length ; i++)
		{
			for(int j = 0; j < data[i].length ; j++)
			{
				if(data[i][j] < lowest)
					lowest = data[i][j];
			}
		}
		
		return lowest;
	}
	
	/** getRowTotal method returns the value of the sum of the doubles in the array in a given row.
	 * 
	 * @param data 2D, ragged array.
	 * @param row Specified row.
	 * @return rowTotal Value of the sum of the doubles in a row.
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		double rowTotal = 0;
		
		for(int i = 0 ; i < data[row].length ; i++)
		{
				rowTotal += data[row][i];
		}
		
		return rowTotal;
	}
	
	/** getHighestInRow method returns the highest double value in a given row.
	 * 
	 * @param data 2D, ragged array.
	 * @param row Specified row.
	 * @return highest Highest double value in a given row.
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		double highest = -Double.MAX_VALUE;
		
		for(int i = 0 ; i < data[row].length ; i++)
		{
				if(data[row][i] > highest)
					highest = data[row][i];
		}
		
		return highest;
	}
	
	/** getHighestInRowIndex method returns the position of the highest double value in a given row.
	 * 
	 * @param data 2D, ragged array.
	 * @param row Specified row.
	 * @return index Row position of the highest double value in the row.
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		double highest = -Double.MAX_VALUE;
		int index = 0;
		
		for(int i = 0 ; i < data[row].length ; i++)
		{
				if(data[row][i] > highest)
				{
					highest = data[row][i];
					index = i;
				}
		}
		
		return index;
	}
	
	/** getLowestInRow method returns the lowest double value in a given row.
	 * 
	 * @param data 2D, ragged array.
	 * @param row Specified row.
	 * @return lowest Lowest double value in a given row.
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		double lowest = Double.MAX_VALUE;
		
		for(int i = 0 ; i < data[row].length ; i++)
		{
				if(data[row][i] < lowest)
					lowest = data[row][i];
		}
		
		return lowest;
	}
	
	/** getLowestInRowIndex method returns the position of the lowest double value in a given row.
	 * 
	 * @param data 2D, ragged array.
	 * @param row Specified row.
	 * @return index Row position of the lowest double value in the row.
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		double lowest = Double.MAX_VALUE;
		int index = 0;
		
		for(int i = 0 ; i < data[row].length ; i++)
		{
				if(data[row][i] < lowest)
				{
					lowest = data[row][i];
					index = i;
				}
		}
		
		return index;
	}
	
	/** getColumnTotal method returns the value of the sum of the doubles in the array in a given column.
	 * 
	 * @param data 2D, ragged array.
	 * @param col Specified column.
	 * @return columnTotal Value of the sum of the doubles in a column.
	 */
	public static double getColumnTotal(double[][] data, int col)
	{
		double colTotal = 0;
		
		for(int i = 0 ; i < data.length ; i++)
		{
			if(data[i].length > col)
				colTotal += data[i][col];
		}
		
		return colTotal;
	}
	
	/** getHighestInColumn method returns the highest double value in a given column.
	 * 
	 * @param data 2D, ragged array.
	 * @param col Specified column.
	 * @return highest Highest double value in a given column.
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		double highest = -Double.MAX_VALUE;
		
		for(int i = 0 ; i < data.length ; i++)
		{
			if(data[i].length > col)
				if(data[i][col] > highest)
					highest = data[i][col];
		}
		
		return highest;
	}
	
	/** getHighestInColumnIndex method returns the position of the highest double value in a given column.
	 * 
	 * @param data 2D, ragged array.
	 * @param col Specified column.
	 * @return index column position of the highest double value in the column.
	 */
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		double highest = -Double.MAX_VALUE;
		int index = 0;
		
		for(int i = 0 ; i < data.length ; i++)
		{
			if(data[i].length > col)
				if(data[i][col] > highest)
				{
					highest = data[i][col];
					index = i;
				}
		}
		
		return index;
	}
	
	/** getLowestInColumn method returns the lowest double value in a given column.
	 * 
	 * @param data 2D, ragged array.
	 * @param col Specified column.
	 * @return lowest Lowest double value in a given column.
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowest = Double.MAX_VALUE;
		
		for(int i = 0 ; i < data.length ; i++)
		{
			if(data[i].length > col)
				if(data[i][col] < lowest)
					lowest = data[i][col];
		}
		
		return lowest;
	}
	
	/** getLowestInColumnIndex method returns the position of the lowest double value in a given column.
	 * 
	 * @param data 2D, ragged array.
	 * @param col Specified column.
	 * @return index column position of the lowest double value in the column.
	 */
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		double lowest = Double.MAX_VALUE;
		int index = 0;
		
		for(int i = 0 ; i < data.length ; i++)
		{
			if(data[i].length > col)
				if(data[i][col] < lowest)
				{
					lowest = data[i][col];
					index = i;
				}
		}
		
		return index;
	}
}


