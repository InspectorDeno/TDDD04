package interpreter;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InterpreterTest {
	public InterpreterExample iex;
	public String expression;
	public Evaluator sentence;
	public Map<String,Expression> variables;
	
	@Before
	public void setUp() {
		System.out.println("Setting up tests");
		variables = new HashMap<String,Expression>();
		iex = new InterpreterExample(); 
	}
	
	@Test
	public void testExample() {
		System.out.println("Running: testExample");
		// Create our own output stream
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
	    System.setOut(new PrintStream(outContent));

		iex.main(null);
		assertEquals(outContent.toString(), "12\n");
		// Reset output stream
		System.setOut(originalOut);
	}
	

	@Test
	public void testAddition() {
		System.out.println("Running: testAddition");
		expression = "w z x + +";
		sentence = new Evaluator(Evaluator.read(expression));
        variables.put("w", new Number(5));
        variables.put("x", new Number(10));
        variables.put("z", new Number(42));
        int result = sentence.interpret(variables);
        assertEquals(result, 57);
	}
	
	@Test
	public void testSubtraction() {
		System.out.println("Running: testSubtraction");
		expression = "w z x - -";
		sentence = new Evaluator(Evaluator.read(expression));
        variables.put("w", new Number(5));
        variables.put("x", new Number(10));
        variables.put("z", new Number(42));
        int result = sentence.interpret(variables);
        assertEquals(result, -37);
	}
	
	@Test
	public void testDivision() {
		System.out.println("Running: testDivision");
		expression = "x w /";
		sentence = new Evaluator(Evaluator.read(expression));
        variables.put("x", new Number(5));
        variables.put("w", new Number(10));
        int result = sentence.interpret(variables);
        assertEquals(result, 2);
	}
	
	@Test
	public void testMultiplication() {
		System.out.println("Running: testMultiplication");
		expression = "w z x * *";
		sentence = new Evaluator(Evaluator.read(expression));
        variables.put("w", new Number(5));
        variables.put("x", new Number(10));
        variables.put("z", new Number(42));
        int result = sentence.interpret(variables);
        assertEquals(result, 2100);
	}
	
	@Test
	public void testNull() {
		System.out.println("Running: testNull");
		expression = "w z x * *";
		sentence = new Evaluator(Evaluator.read(expression));
        variables.put("w", null);
        variables.put("x", null);
        variables.put("z", null);
        int result = sentence.interpret(variables);
        assertEquals(result, 0);
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown");
		variables = null;
		sentence = null;
		assertNull(variables);
		assertNull(sentence);
	}
	
}
