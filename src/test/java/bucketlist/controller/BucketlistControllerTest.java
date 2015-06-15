/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.controller;

import bucketlist.model.BucketlistUserInfo;
import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        
        Session sessionMock = createMock(Session.class);
        SessionFactory factoryMock = createMock(SessionFactory.class);
        expect(factoryMock.openSession()).andReturn(sessionMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("openSession");
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.openSession();
        
        verify(sessionMock);
        verify(factoryMock);
        
    }

    /**
     * Test of CloseSession method, of class BucketlistController.
     */
    @Test
    public void testCloseSession() {
        Session sessionMock = createMock(Session.class);
        SessionFactory factoryMock = createMock(SessionFactory.class);
        expect(sessionMock.close()).andReturn(null);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("CloseSession");
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        instance.closeSession();
        verify(sessionMock);
        verify(factoryMock);
    }

    /**
     * Test of addNewUser method, of class BucketlistController.
     */
    @Test
    public void testAddNewUser_String_String() {
        
        Transaction queryMock = createMock(Transaction.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.beginTransaction()).andReturn(queryMock);
        sessionMock.persist(isA(BucketlistUserInfo.class));
        EasyMock.expectLastCall();
        queryMock.commit();
        EasyMock.expectLastCall();
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("addNewUser");
        String email = "";
        String passwordHash = "";
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        instance.addNewUser(email, passwordHash);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
        
    }

    /**
     * Test of addNewUser method, of class BucketlistController.
     */
    @Test
    public void testAddNewUser_4args() {
        
        Transaction queryMock = createMock(Transaction.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.beginTransaction()).andReturn(queryMock);
        sessionMock.persist(isA(BucketlistUserInfo.class));
        EasyMock.expectLastCall();
        queryMock.commit();
        EasyMock.expectLastCall();
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("addNewUser");
        String firstName = "";
        String lastName = "";
        String email = "";
        String passwordHash = "";
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        instance.addNewUser(firstName, lastName, email, passwordHash);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }

    /**
     * Test of getUser method, of class BucketlistController.
     */
    @Test
    public void testGetUser() {
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.get(BucketlistUserInfo.class, 0)).andReturn(null);
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("getUser");
        int id = 0;
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        BucketlistUserInfo expResult = null;
        BucketlistUserInfo result = instance.getUser(id);
        assertEquals(expResult, result);
        
        verify(sessionMock);
        verify(factoryMock);
        
    }

    /**
     * Test of addListItemToUser method, of class BucketlistController.
     */
    @Test
    public void testAddListItemToUser() {
        Session sessionMock = createMock(Session.class);
        
        Transaction queryMock = createMock(Transaction.class);
        
        expect(sessionMock.beginTransaction()).andReturn(queryMock);
        expect(sessionMock.get(BucketlistUserInfo.class, 0)).andReturn(new BucketlistUserInfo("", ""));
        sessionMock.persist(isA(BucketlistUserInfo.class));
        EasyMock.expectLastCall();
        queryMock.commit();
        EasyMock.expectLastCall();
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("addListItemToUser");
        int userId = 0;
        String content = "";
        String description = "";
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        instance.addListItemToUser(userId, content, description);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }

    /**
     * Test of getUserItems method, of class BucketlistController.
     */
    @Test
    public void testGetUserItems() {
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.list()).andReturn(new ArrayList<BucketlistListItem>());
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("getUserItems");
        int id = 0;
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        List<BucketlistListItem> expResult = new ArrayList<>();
        List<BucketlistListItem> result = instance.getUserItems(id);
        assertEquals(expResult, result);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }

    /**
     * Test of getAllItems method, of class BucketlistController.
     */
    @Test
    public void testGetAllItems() {
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.list()).andReturn(new ArrayList<BucketlistListItem>());
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("getAllItems");
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        List<BucketlistListItem> expResult = new ArrayList<>();
        List<BucketlistListItem> result = instance.getAllItems();
        assertEquals(expResult, result);
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }

    /**
     * Test of getUserByEmail method, of class BucketlistController.
     */
    @Test
    public void testGetUserByEmail() {
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.list()).andReturn(new ArrayList<BucketlistUserInfo>());
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("getUserByEmail");
        String email = "";
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        List<BucketlistListItem> expResult = new ArrayList<>();
        
        List<BucketlistUserInfo> result = instance.getUserByEmail(email);
        assertEquals(expResult, result);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }

    /**
     * Test of checkPassword method, of class BucketlistController.
     */
    @Test
    public void testCheckPassword() {
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.list()).andReturn(new ArrayList<BucketlistUserInfo>());
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("checkPassword");
        String userEmail = "";
        String password = "";
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        int expResult = -1;
        int result = instance.checkPassword(userEmail, password);
        assertEquals(expResult, result);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }

    /**
     * Test of getItemById method, of class BucketlistController.
     */
    @Test
    public void testGetItemById() {
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.list()).andReturn(new ArrayList<BucketlistListItem>());
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("getItemById");
        int itemId = 0;
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        List<BucketlistListItem> expResult = null;
        
        BucketlistListItem result = instance.getItemById(itemId);
        assertEquals(expResult, result);
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }

    /**
     * Test of saveItem method, of class BucketlistController.
     */
    @Test
    public void testSaveItem() {
        
        Transaction tMock = createMock(Transaction.class);
        
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.beginTransaction()).andReturn(tMock);
        tMock.commit();
        EasyMock.expectLastCall();
        
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.list()).andReturn(new ArrayList<BucketlistListItem>());
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        replay(tMock);
        
        System.out.println("saveItem");
        int itemId = 0;
        String name = "";
        String description = "";
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        instance.saveItem(itemId, name, description);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
        verify(tMock);
    }

    /**
     * Test of userExists method, of class BucketlistController.
     */
    @Test
    public void testUserExists() {
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.list()).andReturn(new ArrayList<BucketlistListItem>());
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("userExists");
        String userEmail = "";
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        boolean expResult = false;
        boolean result = instance.userExists(userEmail);
        assertEquals(expResult, result);
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }

    /**
     * Test of updateItem method, of class BucketlistController.
     */
    @Test
    public void testUpdateItem() {
        Transaction tMock = createMock(Transaction.class);
        
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.beginTransaction()).andReturn(tMock);
        tMock.commit();
        EasyMock.expectLastCall();
        
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.setParameter(isA(String.class), isA(String.class))).andReturn(queryMock);
        expect(queryMock.setParameter(isA(String.class), isA(Integer.class))).andReturn(queryMock);
        expect(queryMock.executeUpdate()).andReturn(0);
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        replay(tMock);
        
        System.out.println("updateItem");
        BucketlistListItem item = new BucketlistListItem("", "");
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        instance.updateItem(item);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
        verify(tMock);
    }

    /**
     * Test of deleteItem method, of class BucketlistController.
     */
    @Test
    public void testDeleteItem() {
        Transaction tMock = createMock(Transaction.class);
        
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.beginTransaction()).andReturn(tMock);
        tMock.commit();
        EasyMock.expectLastCall();
        
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.setParameter(isA(String.class), isA(Integer.class))).andReturn(queryMock);
        expect(queryMock.executeUpdate()).andReturn(0);
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        replay(tMock);
        
        System.out.println("deleteItem");
        BucketlistListItem item = new BucketlistListItem("", "");
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        instance.deleteItem(item);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
        verify(tMock);
    }

    /**
     * Test of getMyId method, of class ItemController.
     */
    @Test
    public void testGetMyId() {
        System.out.println("getMyId");
        BucketlistController instance = new BucketlistController();
        int expResult = -1;
        int result = instance.getMyId();
        assertEquals(expResult, result);
    }

    /**
     * Test of addMyListItem method, of class BucketlistController.
     */
    @Test
    public void testAddMyListItem() {
        Session sessionMock = createMock(Session.class);
        
        Transaction queryMock = createMock(Transaction.class);
        
        expect(sessionMock.beginTransaction()).andReturn(queryMock);
        expect(sessionMock.get(BucketlistUserInfo.class, -1)).andReturn(new BucketlistUserInfo("", ""));
        sessionMock.persist(isA(BucketlistUserInfo.class));
        EasyMock.expectLastCall();
        queryMock.commit();
        EasyMock.expectLastCall();
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("addMyListItem");
        String content = "";
        String description = "";
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        instance.addMyListItem(content, description);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }

    /**
     * Test of getAllUsersButMe method, of class BucketlistController.
     */
    @Test
    public void testGetAllUsersButMe() {
        Query queryMock = createMock(Query.class);
        Session sessionMock = createMock(Session.class);
        expect(sessionMock.createQuery(isA(String.class))).andReturn(queryMock);
        expect(queryMock.list()).andReturn(new ArrayList<BucketlistUserInfo>());
        SessionFactory factoryMock = createMock(SessionFactory.class);
        replay(queryMock);
        replay(sessionMock);
        replay(factoryMock);
        
        System.out.println("getAllUsersButMe");
        BucketlistController.setFactory(factoryMock);
        BucketlistController instance = new BucketlistController();
        instance.setSession(sessionMock);
        List<BucketlistUserInfo> expResult = new ArrayList<>();
        List<BucketlistUserInfo> result = instance.getAllUsersButMe();
        assertEquals(expResult, result);
        
        verify(sessionMock);
        verify(queryMock);
        verify(factoryMock);
    }
    
}
