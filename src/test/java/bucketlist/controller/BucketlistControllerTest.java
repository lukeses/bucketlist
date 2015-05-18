/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

import bucketlist.model.BucketlistUserInfo;
import bucketlist.viewController.ItemController;
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
    
    /**
     *
     */
    public BucketlistControllerTest() {
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
        instance.closeSession();
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
        String description = "";
        BucketlistController instance = new BucketlistController();
        instance.addListItemToUser(userId, content, description);
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
        int result = instance.checkPassword(userEmail, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemById method, of class BucketlistController.
     */
    @Test
    public void testGetItemById() {
        System.out.println("getItemById");
        int itemId = 0;
        BucketlistController instance = new BucketlistController();
        BucketlistListItem expResult = null;
        BucketlistListItem result = instance.getItemById(itemId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveItem method, of class BucketlistController.
     */
    @Test
    public void testSaveItem() {
        System.out.println("saveItem");
        int itemId = 0;
        String name = "";
        String description = "";
        BucketlistController instance = new BucketlistController();
        instance.saveItem(itemId, name, description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userExists method, of class BucketlistController.
     */
    @Test
    public void testUserExists() {
        System.out.println("userExists");
        String userEmail = "";
        BucketlistController instance = new BucketlistController();
        boolean expResult = false;
        boolean result = instance.userExists(userEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateItem method, of class BucketlistController.
     */
    @Test
    public void testUpdateItem() {
        System.out.println("updateItem");
        BucketlistListItem item = null;
        BucketlistController instance = new BucketlistController();
        instance.updateItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItem method, of class BucketlistController.
     */
    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");
        BucketlistListItem item = null;
        BucketlistController instance = new BucketlistController();
        instance.deleteItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
        /**
     * Test of getMyId method, of class ItemController.
     */
    @Test
    public void testGetMyId() {
        System.out.println("getMyId");
        BucketlistController instance = new BucketlistController();
        int expResult = 0;
        int result = instance.getMyId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
