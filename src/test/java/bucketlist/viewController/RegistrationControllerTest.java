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
public class RegistrationControllerTest {
    
    /**
     *
     */
    public RegistrationControllerTest() {
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
     * Test of registerNewUser method, of class RegistrationController.
     */
    @Test
    public void testRegisterNewUser() {
        String newUser = "example@example.com";
        String newPassword = "pass1";
        String firstName = "Ela";
        String lastName = "Kowalska";
        BucketlistController controllerMock = createMock(BucketlistController.class);
        controllerMock.openSession();
        expect(controllerMock.userExists(newUser)).andReturn(false);
        controllerMock.closeSession();
        controllerMock.openSession();
        controllerMock.addNewUser(firstName, lastName, newUser, newPassword);
        controllerMock.closeSession();
        
        replay(controllerMock);
        RegistrationController registrationController = new RegistrationController();
        registrationController.setDatabase(controllerMock);
        registrationController.setFirstName(firstName);
        registrationController.setLastName(lastName);
        registrationController.setEmail1(newUser);
        registrationController.setEmail2(newUser);
        registrationController.setPassword1(newPassword);
        registrationController.setPassword2(newPassword);
        registrationController.registerNewUser();
        
        verify(controllerMock);
        }
    
    /**
     * Test of registerNewUser method, of class RegistrationController.
     */
    @Test
    public void testRegisterNewUserWithExistingMail() {
        String newUser = "example@example.com";
        String newPassword = "pass1";
        String firstName = "Ela";
        String lastName = "Kowalska";
        BucketlistController controllerMock = createMock(BucketlistController.class);
        controllerMock.openSession();
        expect(controllerMock.userExists(newUser)).andReturn(true);
        controllerMock.closeSession();
        
        replay(controllerMock);
        RegistrationController registrationController = new RegistrationController();
        registrationController.setDatabase(controllerMock);
        registrationController.setFirstName(firstName);
        registrationController.setLastName(lastName);
        registrationController.setEmail1(newUser);
        registrationController.setEmail2(newUser);
        registrationController.setPassword1(newPassword);
        registrationController.setPassword2(newPassword);
        registrationController.registerNewUser();
        
        verify(controllerMock);
        }
    
    /**
     * Test of registerNewUser method, of class RegistrationController.
     */
    @Test
    public void testRegisterNewUserWithIncorrectPassword() {
        String newUser = "example@example.com";
        String newPassword = "pass1";
        String firstName = "Ela";
        String lastName = "Kowalska";
        BucketlistController controllerMock = createMock(BucketlistController.class);
        
        replay(controllerMock);
        RegistrationController registrationController = new RegistrationController();
        registrationController.setDatabase(controllerMock);
        registrationController.setFirstName(firstName);
        registrationController.setLastName(lastName);
        registrationController.setEmail1(newUser);
        registrationController.setEmail2(newUser);
        registrationController.setPassword1(newPassword);
        registrationController.setPassword2(newPassword + "1");
        registrationController.registerNewUser();
        
        verify(controllerMock);
        }
}
