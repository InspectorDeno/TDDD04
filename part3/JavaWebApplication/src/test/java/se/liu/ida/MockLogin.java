package se.liu.ida;

import se.liu.ida.LoginService;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class MockLogin {
	String session;

	@Test
	public void testValidLogin() {
		// Create mock
		LoginService mockup = mock(LoginService.class);
		// Define return value for login
		when(mockup.login("dendu", "password1")).thenReturn(true);
		
		assertTrue(mockup.login("dendu", "password1"));
	}
	
	@Test
	public void testInValidLogin() {
		// Create mock
		LoginService mockup = mock(LoginService.class);
		// Define return value for login
		when(mockup.login("toblu", "password2")).thenReturn(false);
		
		assertFalse(mockup.login("toblu", "password2"));
	}
	
	@Test
	public void testgetId() {
		// Create mock
		LoginService mockup = mock(LoginService.class);
		
		when(mockup.getId("toblu")).thenReturn(anyInt());
		
		assertNotNull(mockup.getId("toblu"));
	}
	
	@Test
	public void testgetSession() {
		// Create mock
		LoginService mockup = mock(LoginService.class);
		
		when(mockup.getSession("dendu")).thenReturn(anyString());
		
		assertNotNull(mockup.getSession("dendu"));
	}

}

