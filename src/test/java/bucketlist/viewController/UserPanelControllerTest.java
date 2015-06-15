/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistDatabaseTest;
import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.IBucketlistDatabase;
import bucketlist.model.BucketlistUserInfo;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

/**
 *
 * @author Daniel
 */
public class UserPanelControllerTest {
    
    public UserPanelControllerTest() {
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
     * Test of tryToChangePassword method, of class UserPanelController.
     */
    @Test
    public void testTryToChangePasswordCorrect() {
        int userId = 1;
        String oldPassword = "old";
        String oldConfirm = "old";
        String userMail = "email@email.com";
        String new1 = "new";
        String new2 = "new";
        IBucketlistDatabase mock = createStrictMock(IBucketlistDatabase.class);
        mock.openSession();
        mock.changePassword(userId, new1);
        mock.closeSession();
		
	replay(mock);
        
        BucketlistUserInfo u = new BucketlistUserInfo(userMail, oldPassword);
        u.setId(1);
	UserPanelController c = new UserPanelController();
        c.setDatabase(mock);
        c.setNewPassword1(new1);
        c.setNewPassword2(new2);
        c.setOldPassword(oldConfirm);
        c.setUser(u);
        
        c.tryToChangePassword();
		
	verify(mock);
    }
    
    /**
     * Test of tryToChangePassword method, of class UserPanelController.
     */
    @Test
    public void testTryToChangePasswordWrongOld() {
        int userId = 1;
        String oldPassword = "old";
        String oldConfirm = "old2";
        String userMail = "email@email.com";
        String new1 = "new";
        String new2 = "new";
        IBucketlistDatabase mock = createStrictMock(IBucketlistDatabase.class);
        //mock.openSession();
        //mock.changePassword(1, "new");
        //mock.closeSession();
		
	replay(mock);
        
        BucketlistUserInfo u = new BucketlistUserInfo(userMail, oldPassword);
        u.setId(userId);
	UserPanelController c = new UserPanelController();
        c.setDatabase(mock);
        c.setNewPassword1(new1);
        c.setNewPassword2(new2);
        c.setOldPassword(oldConfirm);
        c.setUser(u);
        
        c.tryToChangePassword();
		
	verify(mock);
    }
    
    /**
     * Test of tryToChangePassword method, of class UserPanelController.
     */
    @Test
    public void testTryToChangePasswordWrongNew() {
        int userId = 1;
        String oldPassword = "old";
        String userMail = "email@email.com";
        String new1 = "new";
        String new2 = "new1";
        IBucketlistDatabase mock = createStrictMock(IBucketlistDatabase.class);
        //mock.openSession();
        //mock.changePassword(1, "new");
        //mock.closeSession();
		
	replay(mock);
        
        BucketlistUserInfo u = new BucketlistUserInfo(userMail, oldPassword);
        u.setId(userId);
	UserPanelController c = new UserPanelController();
        c.setDatabase(mock);
        c.setNewPassword1(new1);
        c.setNewPassword2(new2);
        c.setOldPassword(oldPassword);
        c.setUser(u);
        
        c.tryToChangePassword();
		
	verify(mock);
    }

    /**
     * Test of tryToDeleteUser method, of class UserPanelController.
     */
    @Test
    public void testTryToDeleteUserCorrect() {
        int userId = 1;
        String oldPassword = "old";
        String oldConfirm = "old";
        String userMail = "email@email.com";
        IBucketlistDatabase mock = createStrictMock(IBucketlistDatabase.class);
        mock.openSession();
        expect(mock.checkPassword(userMail, oldPassword)).andReturn(userId);
        mock.closeSession();
        mock.openSession();
        mock.deleteUser(userId);
        mock.closeSession();
		
	replay(mock);
        
        BucketlistUserInfo u = new BucketlistUserInfo(userMail, oldPassword);
        u.setId(userId);
	UserPanelController c = new UserPanelController();
        c.setDatabase(mock);
        c.setOldPassword(oldPassword);
        c.setUser(u);
        
        c.tryToDeleteUser();
		
	verify(mock);
    }
    
    /**
     * Test of tryToDeleteUser method, of class UserPanelController.
     */
    @Test
    public void testTryToDeleteUserWrongOld() {
        int userId = 1;
        String oldPassword = "old";
        String userMail = "email@email.com";
        IBucketlistDatabase mock = createStrictMock(IBucketlistDatabase.class);
        mock.openSession();
        expect(mock.checkPassword(userMail, oldPassword)).andReturn(0);
        mock.closeSession();
        //mock.openSession();
        //mock.deleteUser(userId);
        //mock.closeSession();
		
	replay(mock);
        
        BucketlistUserInfo u = new BucketlistUserInfo(userMail, oldPassword);
        u.setId(userId);
	UserPanelController c = new UserPanelController();
        c.setDatabase(mock);
        c.setOldPassword(oldPassword);
        c.setUser(u);
        
        c.tryToDeleteUser();
		
	verify(mock);
    }

    /**
     * Test of init method, of class UserPanelController.
     */
    @Test
    public void testInit() {
        IBucketlistDatabase mock = createStrictMock(IBucketlistDatabase.class);
	replay(mock);
    }
    
}
