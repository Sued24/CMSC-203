
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests class for HolidayBonus class
 *  * CMSC 203
 * Assignment 5
 * 7/22/2022
 * Eclipse IDE
 * @author Santiago Sued
 */
public class HolidayBonusTestSTUDENT {
	
	/** Student generated 2D, ragged array for testing*/
	private double[][] dataSet1 = {{1,2,3},
								   {4,5},
								   {6,7,8}};
	
	/** Student generated 2D, ragged array for testing*/
	private double[][] dataSet2 = {{-3.4,20.8},
								   {29.24,-12.4,9.9,0.2},
								   {6.0}};
	/** JUnit set up method before every test.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/** JUnit tearDown method after every test.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
		
	/**
	 * Test calculateHolidayBonus1 method with a high of 10000, low of 500 and 3000 as other.		 
	 */

		@Test
		public void testCalculateHolidayBonus1() 
		{
			double[] result1 = HolidayBonus.calculateHolidayBonus(dataSet1,10000,500,3000); // Should give {1500 , 6000 , 30000}
			assertEquals(1500,result1[0],.001);
			assertEquals(6000,result1[1],.001);
			assertEquals(30000,result1[2],.001);
		}
		
		/**
		 * Test calculateHolidayBonus2 method with a high of 10000, low of 500 and 3000 as other, this array contains negative numbers.		 
		 */
		@Test
		public void testCalculateHolidayBonus2() 
		{
			double[] result2 = HolidayBonus.calculateHolidayBonus(dataSet2,10000,500,3000); // Should give {10000, 30000, 3000}
			assertEquals(10000,result2[0],.001);
			assertEquals(30000,result2[1],.001);
			assertEquals(3000,result2[2],.001);
		}
}
