package triangle;

import triangle.Triangle.TriangleType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TriangleTest {
	private triangle.Triangle triangle;

	@Before
	public void setUp() {
		System.out.println("Setting up tests");
		triangle = new triangle.Triangle();
	}

	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testException() throws InvalidTriangleException {
		System.out.println("Running: testException");
		exception.expect(InvalidTriangleException.class);
		final int[] is = new int[]{1, -1, 1};
		triangle.setSides(is);
		triangle.getType();
	}
	
	@Test
	public void testInvalidInput() throws InvalidTriangleException {
		System.out.println("Running: testInvalidInput");
		exception.expect(InvalidTriangleException.class);
		final int[] is = new int[]{1, 1};
		triangle.setSides(is);
		triangle.getType();
	}
	
	@Test
	public void testNaT() throws InvalidTriangleException {
		System.out.println("Running: testNaT");
		exception.expect(InvalidTriangleException.class);
		final int[] is = new int[]{4, 2, 1};
		triangle.setSides(is);
		assertEquals(TriangleType.NaT, triangle.getType());
	}
	
	@Test
	public void testEquilateral() throws InvalidTriangleException {
		System.out.println("Running: testEquilateral");
		final int[] is = new int[]{2, 2, 2};
		triangle.setSides(is);
		assertEquals(TriangleType.Equilateral, triangle.getType());
	}
	
	
	@Test
	public void testIsosceles() throws InvalidTriangleException {
		System.out.println("Running: testIsosceles");
		final int[] is = new int[]{3, 2, 2};
		triangle.setSides(is);
		assertEquals(TriangleType.Isosceles, triangle.getType());
	}
	
	@Test
	public void testScalene() throws InvalidTriangleException {
		System.out.println("Running: testScalene");
		final int[] is = new int[]{3, 4, 5};
		triangle.setSides(is);
		assertEquals(TriangleType.Scalene, triangle.getType());
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		triangle.setSides(null);
		assertNull(triangle.getSides());
	}
	
	
}
