/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.model;

import bucketlist.controller.BucketlistListItem;
import java.util.Date;
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
public class BucketlistUserInfoTest {
    
    public BucketlistUserInfoTest() {
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
     * Test of changePassword method, of class BucketlistUserInfo.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String oldPassword = "";
        String newPassword = "";
        BucketlistUserInfo instance = new BucketlistUserInfo();
        boolean expResult = false;
        boolean result = instance.changePassword(oldPassword, newPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListItems method, of class BucketlistUserInfo.
     */
    @Test
    public void testGetListItems() {
        System.out.println("getListItems");
        BucketlistUserInfo instance = new BucketlistUserInfo();
        List<BucketlistListItem> expResult = null;
        List<BucketlistListItem> result = instance.getListItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class BucketlistUserInfo.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        BucketlistUserInfo instance = new BucketlistUserInfo();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPasswordHash method, of class BucketlistUserInfo.
     */
    @Test
    public void testGetPasswordHash() {
        System.out.println("getPasswordHash");
        BucketlistUserInfo instance = new BucketlistUserInfo();
        String expResult = "";
        String result = instance.getPasswordHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistrationDate method, of class BucketlistUserInfo.
     */
    @Test
    public void testGetRegistrationDate() {
        System.out.println("getRegistrationDate");
        BucketlistUserInfo instance = new BucketlistUserInfo();
        Date expResult = null;
        Date result = instance.getRegistrationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastLogin method, of class BucketlistUserInfo.
     */
    @Test
    public void testGetLastLogin() {
        System.out.println("getLastLogin");
        BucketlistUserInfo instance = new BucketlistUserInfo();
        Date expResult = null;
        Date result = instance.getLastLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastLogin method, of class BucketlistUserInfo.
     */
    @Test
    public void testSetLastLogin() {
        System.out.println("setLastLogin");
        Date lastLogin = null;
        BucketlistUserInfo instance = new BucketlistUserInfo();
        instance.setLastLogin(lastLogin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class BucketlistUserInfo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        BucketlistUserInfo instance = new BucketlistUserInfo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class BucketlistUserInfo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        BucketlistUserInfo instance = new BucketlistUserInfo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistrationDate method, of class BucketlistUserInfo.
     */
    @Test
    public void testSetRegistrationDate() {
        System.out.println("setRegistrationDate");
        Date registrationDate = null;
        BucketlistUserInfo instance = new BucketlistUserInfo();
        instance.setRegistrationDate(registrationDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class BucketlistUserInfo.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        BucketlistUserInfo instance = new BucketlistUserInfo();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPasswordHash method, of class BucketlistUserInfo.
     */
    @Test
    public void testSetPasswordHash() {
        System.out.println("setPasswordHash");
        String passwordHash = "";
        BucketlistUserInfo instance = new BucketlistUserInfo();
        instance.setPasswordHash(passwordHash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListItems method, of class BucketlistUserInfo.
     */
    @Test
    public void testSetListItems() {
        System.out.println("setListItems");
        List<BucketlistListItem> listItems = null;
        BucketlistUserInfo instance = new BucketlistUserInfo();
        instance.setListItems(listItems);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class BucketlistUserInfo.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        BucketlistUserInfo instance = new BucketlistUserInfo();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class BucketlistUserInfo.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        BucketlistUserInfo instance = new BucketlistUserInfo();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class BucketlistUserInfo.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        BucketlistUserInfo instance = new BucketlistUserInfo();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class BucketlistUserInfo.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        BucketlistUserInfo instance = new BucketlistUserInfo();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
