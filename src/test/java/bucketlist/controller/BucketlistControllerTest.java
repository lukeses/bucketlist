/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

import bucketlist.model.BucketlistUserInfo;
import java.util.List;
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
public class BucketlistControllerTest {
    
    public BucketlistControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of openSession method, of class BucketlistController.
     */
    @Test
    public void testOpenSession() {
        System.out.println("openSession");
        BucketlistController instance = new BucketlistController();
        instance.openSession();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CloseSession method, of class BucketlistController.
     */
    @Test
    public void testCloseSession() {
        System.out.println("CloseSession");
        BucketlistController instance = new BucketlistController();
        instance.CloseSession();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewUser method, of class BucketlistController.
     */
    @Test
    public void testAddNewUser_String_String() {
        System.out.println("addNewUser");
        String email = "";
        String passwordHash = "";
        BucketlistController instance = new BucketlistController();
        instance.addNewUser(email, passwordHash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewUser method, of class BucketlistController.
     */
    @Test
    public void testAddNewUser_4args() {
        System.out.println("addNewUser");
        String firstName = "";
        String lastName = "";
        String email = "";
        String passwordHash = "";
        BucketlistController instance = new BucketlistController();
        instance.addNewUser(firstName, lastName, email, passwordHash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class BucketlistController.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int id = 0;
        BucketlistController instance = new BucketlistController();
        BucketlistUserInfo expResult = null;
        BucketlistUserInfo result = instance.getUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addListItemToUser method, of class BucketlistController.
     */
    @Test
    public void testAddListItemToUser() {
        System.out.println("addListItemToUser");
        int userId = 0;
        String content = "";
        BucketlistController instance = new BucketlistController();
        instance.addListItemToUser(userId, content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserItems method, of class BucketlistController.
     */
    @Test
    public void testGetUserItems() {
        System.out.println("getUserItems");
        int id = 0;
        BucketlistController instance = new BucketlistController();
        List<BucketlistListItem> expResult = null;
        List<BucketlistListItem> result = instance.getUserItems(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllItems method, of class BucketlistController.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        BucketlistController instance = new BucketlistController();
        List<BucketlistListItem> expResult = null;
        List<BucketlistListItem> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByEmail method, of class BucketlistController.
     */
    @Test
    public void testGetUserByEmail() {
        System.out.println("getUserByEmail");
        String email = "";
        BucketlistController instance = new BucketlistController();
        List<BucketlistUserInfo> expResult = null;
        List<BucketlistUserInfo> result = instance.getUserByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class BucketlistController.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String userEmail = "";
        String password = "";
        BucketlistController instance = new BucketlistController();
        boolean expResult = false;
        boolean result = instance.checkPassword(userEmail, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
