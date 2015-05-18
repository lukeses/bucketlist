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
import static org.easymock.EasyMock.*;

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
     * Test of tryToLogin method, of class LoginController.
     */
    @Test
    public void testTryToLogin() {
        String newUser = "example@example.com";
        String newPassword = "pass1";
        BucketlistController controllerMock = createMock(BucketlistController.class);
        controllerMock.openSession();
        expect(controllerMock.checkPassword(newUser, newPassword)).andReturn(10);
        controllerMock.closeSession();
        
        replay(controllerMock);
        LoginController loginController = new LoginController();
        loginController.setDatabase(controllerMock);
        loginController.setUserName(newUser);
        loginController.setUserPassword(newPassword);
        loginController.tryToLogin();
        assertEquals(true, loginController.isLoggedIn());
        
        verify(controllerMock);
    }
    
    /**
     * Test of tryToLogin method, of class LoginController.
     */
    @Test
    public void testTryToLoginWithFailure() {
        String newUser = "example@example.com";
        String newPassword = "pass1";
        BucketlistController controllerMock = createMock(BucketlistController.class);
        controllerMock.openSession();
        expect(controllerMock.checkPassword(newUser, newPassword)).andReturn(-1);
        controllerMock.closeSession();
        
        replay(controllerMock);
        LoginController loginController = new LoginController();
        loginController.setDatabase(controllerMock);
        loginController.setUserName(newUser);
        loginController.setUserPassword(newPassword);
        loginController.tryToLogin();
        assertEquals(false, loginController.isLoggedIn());
        
        verify(controllerMock);
    }

    /**
     * Test of logout method, of class LoginController.
     */
    @Test
    public void testLogout() {
        LoginController loginController = new LoginController();
        loginController.logout();
        assertEquals(false, loginController.isLoggedIn());
    }
    
}
