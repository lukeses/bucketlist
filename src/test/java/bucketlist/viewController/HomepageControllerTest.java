/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.controller.BucketlistListItem;
import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
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
public class HomepageControllerTest {
    
    /**
     *
     */
    public HomepageControllerTest() {
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
     * Test of getList method, of class HomepageController.
     */
    @Test
    public void testGetList() {
        BucketlistController controllerMock = createMock(BucketlistController.class);
        controllerMock.openSession();
        expect(controllerMock.getAllItems()).andReturn(new ArrayList<BucketlistListItem>());
        controllerMock.closeSession();
        
        replay(controllerMock);
    }
    
}
