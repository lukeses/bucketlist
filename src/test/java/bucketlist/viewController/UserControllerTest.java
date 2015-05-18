/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.IBucketlistDatabase;
import bucketlist.model.BucketlistUserInfo;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;
import org.easymock.EasyMockSupport;

/**
 *
 * @author Adam
 */
public class UserControllerTest {
    
    public UserControllerTest() {
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
     * Test of setDatabase method, of class UserController.
     */
    @Test
    public void testSetDatabase() {
        System.out.println("setDatabase");
        BucketlistController database = null;
        UserController instance = new UserController();
        instance.setDatabase(database);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class UserController.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        UserController instance = new UserController();
        List<BucketlistUserInfo> expResult = null;
        List<BucketlistUserInfo> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserItems method, of class UserController.
     */
    @Test
    public void testGetUserItems() {
        System.out.println("getUserItems");
        UserController instance = new UserController();
        List<BucketlistListItem> expResult = null;
        List<BucketlistListItem> result = instance.getUserItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
