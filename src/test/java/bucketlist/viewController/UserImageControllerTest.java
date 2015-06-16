/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.IBucketlistDatabase;
import javax.servlet.http.Part;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.primefaces.event.FileUploadEvent;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

/**
 *
 * @author Daniel
 */
public class UserImageControllerTest {
    
    public UserImageControllerTest() {
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
     * Test of uploadImage method, of class UserImageController.
     */
    @Test
    public void testUploadImageNoFile() throws Exception {
        UserImageController c = new UserImageController();
        
        assertEquals("/secured/userPanel.xhtml?faces-redirect=true", c.uploadImage(null));
    }

    /**
     * Test of init method, of class UserImageController.
     */
    @Test
    public void testInit() {
        IBucketlistDatabase mock = createStrictMock(IBucketlistDatabase.class);
	replay(mock);
    }
    
}
