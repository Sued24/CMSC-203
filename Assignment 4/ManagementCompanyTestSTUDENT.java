

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany m;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("LowFare", "555555555",12);
		//student add three properties, with plots, to mgmt co
		m.addProperty("Stardew Farm", "Stardew Valley", 2613, "Mr. Houtson",3,3,10,1);
		m.addProperty("Chef Now", "Lakepointe", 5327, "Joey Balloney",4,5,2,2);
		m.addProperty("Amazon", "Cambridge", 1000, "Jeff Bezos",9,9,2,2);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		m = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		assertEquals(m.addProperty("McDonalds" , "Rockville" , 20 , "Dr. Viktor"), 3);//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(m.addProperty("BurgerKing" , "Rockville" , 20 , "Mr. Stuart" , 0 , 9 , 5 , 1) , 4);//student should add property with 8 args
		assertEquals(m.addProperty("IKEA" , "Minnesota" , 100 , "Felix" , 0 , 0 , 20 , 20), -1);//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		System.out.println(m);
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(m.maxRentProp() , 5327.0 , 0);
		//student should test if maxRentProp contains the maximum rent of properties
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(m.totalRent() , 8940.0 , 0);
		//student should test if totalRent returns the total rent of properties
	}

 }
