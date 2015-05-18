/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.controller.BucketlistListItem;
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
public class UserItemsControllerTest {
    
    public UserItemsControllerTest() {
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
     * Test of setDatabase method, of class UserItemsController.
     */
    @Test
    public void testSetDatabase() {
        System.out.println("setDatabase");
        BucketlistController database = null;
        UserItemsController instance = new UserItemsController();
        instance.setDatabase(database);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getList method, of class UserItemsController.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        UserItemsController instance = new UserItemsController();
        List<BucketlistListItem> expResult = null;
        List<BucketlistListItem> result = instance.getList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class UserItemsController.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        LoginController login = null;
        UserItemsController instance = new UserItemsController();
        instance.setLogin(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editAction method, of class UserItemsController.
     */
    @Test
    public void testEditAction() {
        System.out.println("editAction");
        BucketlistListItem item = null;
        UserItemsController instance = new UserItemsController();
        String expResult = "";
        String result = instance.editAction(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveAction method, of class UserItemsController.
     */
    @Test
    public void testSaveAction() {
        System.out.println("saveAction");
        BucketlistListItem item = null;
        UserItemsController instance = new UserItemsController();
        String expResult = "";
        String result = instance.saveAction(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAction method, of class UserItemsController.
     */
    @Test
    public void testDeleteAction() {
        System.out.println("deleteAction");
        BucketlistListItem item = null;
        UserItemsController instance = new UserItemsController();
        String expResult = "";
        String result = instance.deleteAction(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
