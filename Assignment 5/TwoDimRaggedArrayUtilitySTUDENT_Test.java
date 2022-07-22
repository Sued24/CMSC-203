

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests class for 2D, Ragged Array Utility class.
 *  * CMSC 203
 * Assignment 5
 * 7/22/2022
 * Eclipse IDE
 * @author Santiago Sued
 */
public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	/** 2D, ragged array provided by student.
	 * 
	 */
	private double[][] dataSetSTUDENT = {{1 , 2 , 4},
										 {-3 , 0},
										 {12},
										 {-9 , 2 ,-3}};
	
	/** File object used to read/write to file.
	 * 
	 */
	private File outputFile;

	/** JUnit set up method before every test.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	/** JUnit tearDown method after every test.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() 
	{
		assertEquals(6,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),0.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(0.66666666666666666666666666666667,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),0.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(-3,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,1),0.001);	
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(4,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,1),0.001);	
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(12,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),0.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws IOException 
	{
		double[][] inputArr = new double[dataSetSTUDENT.length][];
		
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		inputArr = TwoDimRaggedArrayUtility.readFile(outputFile);
		
		for(int i = 0 ; i < dataSetSTUDENT.length ; i++)
			for(int j = 0 ; j < dataSetSTUDENT[i].length ; j++)
				assertEquals(inputArr[i][j],dataSetSTUDENT[i][j],0);
	}

}
