/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class LoginControllerTest {
    
    /**
     *
     */
    public LoginControllerTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of setDatabase method, of class LoginController.
     */
    @Test
    public void testSetDatabase() {
        System.out.println("setDatabase");
        BucketlistController database = null;
        LoginController instance = new LoginController();
        instance.setDatabase(database);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class LoginController.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        LoginController instance = new LoginController();
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class LoginController.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        LoginController instance = new LoginController();
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPassword method, of class LoginController.
     */
    @Test
    public void testGetUserPassword() {
        System.out.println("getUserPassword");
        LoginController instance = new LoginController();
        String expResult = "";
        String result = instance.getUserPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserPassword method, of class LoginController.
     */
    @Test
    public void testSetUserPassword() {
        System.out.println("setUserPassword");
        String userPassword = "";
        LoginController instance = new LoginController();
        instance.setUserPassword(userPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tryToLogin method, of class LoginController.
     */
    @Test
    public void testTryToLogin() {
        System.out.println("tryToLogin");
        LoginController instance = new LoginController();
        String expResult = "";
        String result = instance.tryToLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class LoginController.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        LoginController instance = new LoginController();
        String expResult = "";
        String result = instance.logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLoggedIn method, of class LoginController.
     */
    @Test
    public void testIsLoggedIn() {
        System.out.println("isLoggedIn");
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.isLoggedIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
