package se.liu.ida;

import se.liu.ida.LoginService;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class MockLogin {
	String session;

	@Test
	public void testValidLogin() throws Exception{
		// Create mock
		LoginService mockup = mock(LoginService.class);
		// Define return value for login
		when(mockup.login("dendu", "password1")).thenReturn(true);
		
		assertTrue(mockup.login("dendu", "password1"));
	}
	
	@Test
	public void testInValidLogin() throws Exception{
		// Create mock
		LoginService mockup = mock(LoginService.class);
		// Define return value for login
		when(mockup.login("toblu", "password2")).thenReturn(false);
		
		assertFalse(mockup.login("toblu", "password2"));
	}
	
	@Test
	public void testgetId() throws Exception{
		// Create mock
		LoginService mockup = mock(LoginService.class);
		
		when(mockup.getId("toblu")).thenReturn(anyInt());
		
		assertNotNull(mockup.getId("toblu"));
	}
	
	@Test
	public void testgetSession() throws Exception{
		// Create mock
		LoginService mockup = mock(LoginService.class);
		
		when(mockup.getSession("dendu")).thenReturn(anyString());
		
		assertNotNull(mockup.getSession("dendu"));
	}

}

