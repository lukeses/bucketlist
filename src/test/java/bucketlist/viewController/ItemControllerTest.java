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
public class ItemControllerTest {
    
    /**
     *
     */
    public ItemControllerTest() {
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
     * Test of setDatabase method, of class ItemController.
     */
    @Test
    public void testSetDatabase() {
        System.out.println("setDatabase");
        BucketlistController database = null;
        ItemController instance = new ItemController();
        instance.setDatabase(database);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemId method, of class ItemController.
     */
    @Test
    public void testGetItemId() {
        System.out.println("getItemId");
        ItemController instance = new ItemController();
        int expResult = 0;
        int result = instance.getItemId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemId method, of class ItemController.
     */
    @Test
    public void testSetItemId() {
        System.out.println("setItemId");
        int itemId = 0;
        ItemController instance = new ItemController();
        instance.setItemId(itemId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class ItemController.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ItemController instance = new ItemController();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class ItemController.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ItemController instance = new ItemController();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class ItemController.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ItemController instance = new ItemController();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class ItemController.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        ItemController instance = new ItemController();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class ItemController.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        ItemController instance = new ItemController();
        String expResult = "";
        String result = instance.addItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ItemController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        ItemController instance = new ItemController();
        String expResult = "";
        String result = instance.update();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of init method, of class ItemController.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        ItemController instance = new ItemController();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMyId method, of class ItemController.
     */
    @Test
    public void testGetMyId() {
        System.out.println("getMyId");
        ItemController instance = new ItemController();
        int expResult = 0;
        int result = instance.getMyId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
