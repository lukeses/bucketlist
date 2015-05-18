/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

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
public class BucketlistListItemTest {
    
    public BucketlistListItemTest() {
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
     * Test of getItemId method, of class BucketlistListItem.
     */
    @Test
    public void testGetItemId() {
        System.out.println("getItemId");
        BucketlistListItem instance = new BucketlistListItem();
        int expResult = 0;
        int result = instance.getItemId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemId method, of class BucketlistListItem.
     */
    @Test
    public void testSetItemId() {
        System.out.println("setItemId");
        int itemId = 0;
        BucketlistListItem instance = new BucketlistListItem();
        instance.setItemId(itemId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class BucketlistListItem.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        BucketlistListItem instance = new BucketlistListItem();
        String expResult = "";
        String result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContent method, of class BucketlistListItem.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "";
        BucketlistListItem instance = new BucketlistListItem();
        instance.setContent(content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEditable method, of class BucketlistListItem.
     */
    @Test
    public void testIsEditable() {
        System.out.println("isEditable");
        BucketlistListItem instance = new BucketlistListItem();
        boolean expResult = false;
        boolean result = instance.isEditable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEditable method, of class BucketlistListItem.
     */
    @Test
    public void testSetEditable() {
        System.out.println("setEditable");
        boolean editable = false;
        BucketlistListItem instance = new BucketlistListItem();
        instance.setEditable(editable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
