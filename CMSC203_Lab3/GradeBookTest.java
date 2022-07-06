import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook gBook1 = new GradeBook(5);
	private GradeBook gBook2 = new GradeBook(5);
	
	
	@BeforeEach
	public void setUp() throws Exception {
		gBook1.addScore(12);
		gBook1.addScore(8);
		gBook2.addScore(3);
		gBook2.addScore(20);
		gBook2.addScore(14);
	}

	@AfterEach
	void tearDown() throws Exception {
		gBook1 = null;
		gBook2 = null;
	}
	
	@Test
	public void testAddScore() {
		assertTrue(gBook1.toString().equals("12.0 8.0 0.0 0.0 0.0 "));
		assertTrue(gBook2.toString().equals("3.0 20.0 14.0 0.0 0.0 "));
	}

	@Test
	void testSum() {
		assertEquals(20.0, gBook1.sum());
		assertEquals(37.0, gBook2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(8.0, gBook1.minimum());
		assertEquals(3.0, gBook2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(12.0 , gBook1.finalScore());
		assertEquals(34.0 , gBook2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, gBook1.getScoreSize());
		assertEquals(3, gBook2.getScoreSize());
	}
}
