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
        System.out.println("Testing login...");
        try {
            // Reset database file
            loginservice.clearData();
            boolean login = loginservice.login("dendu", "password123");
            assertTrue(login);

        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void test2GetId() {
        System.out.println("Testing getId...");
        int id = loginservice.getId("dendu");
        System.out.println(id);
        assertNotEquals(id, -1);
    }

    @Test
    public void test3GetSession() {
        System.out.println("Testing getSession...");
        String session = loginservice.getSession("dendu");
        System.out.println(session);
        assertNotNull(session);
    }

    @After
    public void tearDown(){
        System.out.println("Running teardown...");
        loginservice = null;
        assertNull(loginservice);
    }
}
