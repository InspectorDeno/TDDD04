import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StatementTest {
	private PizzaStore ps;
	private Pizza pizza;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	
	@Before
	public void setUp() {
		System.out.println("Setting up tests");
		pizza = new Pizza();
		ps = new PizzaStore();
		
	    System.setOut(new PrintStream(outContent));
	}

	
	@Test
	public void testPizza() {
		assertEquals(pizza.describe(), "Pizza");
	}	
	
	@Test
	public void testMain() {
		ps.main(null);
		assertEquals("preparing pizza\n" + 
				"baking pizza\n" + 
				"cutting pizza\n" + 
				"boxing our pizza\n" + 
				"Woohoo, I got a Veggie Pizza\n", outContent.toString());
	}
	
	@Test
	public void testPreparingPizza() {
		pizza.prepare();
        assertEquals("preparing pizza\n", outContent.toString());
	}
	
	@Test
	public void testBakingPizza() {
		pizza.bake();
        assertEquals("baking pizza\n", outContent.toString());
	}
	@Test
	public void testCuttingPizza() {
		pizza.cut();
        assertEquals("cutting pizza\n", outContent.toString());
	}
	@Test
	public void testBoxingPizza() {
		pizza.box();
        assertEquals("boxing our pizza\n", outContent.toString());
	}

	@Test
	public void testSthlmVeggie() {
		PizzaFranchise sthlmps = new SthlmPizzaStore();
		pizza = sthlmps.selectPizza("veggie");
		assertEquals(pizza.describe(), "Veggie Pizza");
	}

	@Test
	public void testSthlmClam() {
		PizzaFranchise sthlmps = new SthlmPizzaStore();
		pizza = sthlmps.selectPizza("clam");
		assertEquals(pizza.describe(), "Clam Pizza");
	}
	
	@Test
	public void testSthlmCheese() {
		PizzaFranchise sthlmps = new SthlmPizzaStore();
		pizza = sthlmps.selectPizza("cheese");
		assertEquals(pizza.describe(), "Cheese pizza");
	}

	@Test
	public void testSthlmPepperoni() {
		PizzaFranchise sthlmps = new SthlmPizzaStore();
		pizza = sthlmps.selectPizza("pepperoni");
		assertEquals(pizza.describe(), "Pepperoni pizza");
	}

	
	// New York Pizzas
	@Test
	public void testNYVeggie() {
		PizzaFranchise nyps = new NYPizzaStore();
		pizza = nyps.selectPizza("veggie");
		assertEquals(pizza.describe(), "Veggie Pizza");
	}

	@Test
	public void testNYClam() {
		PizzaFranchise nyps = new NYPizzaStore();
		pizza = nyps.selectPizza("clam");
		assertEquals(pizza.describe(), "Clam Pizza");
	}
	
	@Test
	public void testNYCheese() {
		PizzaFranchise nyps = new NYPizzaStore();
		pizza = nyps.selectPizza("cheese");
		assertEquals(pizza.describe(), "NY Cheese Pizza");
	}

	@Test
	public void testNYPepperoni() {
		PizzaFranchise nyps = new NYPizzaStore();
		pizza = nyps.selectPizza("pepperoni");
		assertEquals(pizza.describe(), "Pepperoni pizza");
	}
	
	@After
	public void tearDown() throws Exception {
		
		System.setOut(originalOut);
		
		System.out.println("Tearing down...");
		
		pizza = null;
		ps = null;
		
		assertNull(ps);
		assertNull(pizza);
	}
	

}