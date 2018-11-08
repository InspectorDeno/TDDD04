package se.liu.ida;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginServiceTest {
    private OurLoginService loginservice;
    @Before
    public void setup(){
        System.out.println("Setting up tests...");
        loginservice = new OurLoginService();
    }

    @Test
    public void test1Login(){
        System.out.println("Testing login");
        assertTrue(loginservice.login("dendu", "password"));
    }
    
    @Test
    public void test2InvalidLogin(){
        System.out.println("Testing invalid login");
        assertFalse(loginservice.login("dendu", "passpass"));
    }

    @Test
    public void test3GetId() {
        System.out.println("Testing getId");
        assertNotEquals(loginservice.getId("dendu"), -1);
    }
    
    @Test
    public void test4InvalidGetId() {
        System.out.println("Testing invalid getId");
        assertEquals(loginservice.getId("dendu"), -1);
    }

    @Test
    public void test5GetSession() {
        System.out.println("Testing getSession");
        assertEquals(loginservice.getSession("dendu"), "dendu933");
    }
    
    @Test
    public void test6GetInvalidSession() {
        System.out.println("Testing invalid getSession");
        assertEquals(loginservice.getSession("bumbo"), "NO");
    }

    @After
    public void tearDown(){
        System.out.println("Running teardown");
        loginservice = null;
        assertNull(loginservice);
    }
}
