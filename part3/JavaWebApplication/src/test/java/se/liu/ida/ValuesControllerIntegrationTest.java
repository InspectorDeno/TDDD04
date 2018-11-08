package se.liu.ida;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ValuesControllerIntegrationTest {

	private OurLoginService loginService;
	private ValuesController vc;
	
	@Before
	public void setup() {
		loginService = new OurLoginService();
		vc = new ValuesController(loginService);
	}
	
	
	@Test
	public void test1Login() {
		assertEquals(vc.login("olero", "valid_password"), "OK");
	}
	
	@Test
	public void test2InvalidLogin() {
		assertEquals(vc.login("olero", "invalid_password"), "NO");
	}
	
	@Test
	public void test3GetSession() {
		assertEquals(vc.getSession("olero"), "olero933");
	}
	
	@Test
	public void test4GetInvalidSession() {
		assertEquals(vc.getSession("bumbo"), "NO");
	}
	
	@Test
	public void test5GetId() {
		assertNotEquals(vc.getId("olero"), -1);
	}
	
	@Test
	public void test6InvalidGetId() {
		assertEquals(vc.getId("bumbo"), -1);
	}
	
	@Test
	public void test7Index() {
		assertEquals(vc.index("olero"), "Hello, you are user #1");
	}
	
	@After
	public void tearDown() {
		loginService = null;
		vc = null;
		
		assertNull(vc);
		assertNull(loginService);
		
	}

}
