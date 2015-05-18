/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.viewController;

import bucketlist.controller.BucketlistController;
import bucketlist.controller.BucketlistDatabaseTest;
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

    @Test
    public void testGetUsers() {
        IBucketlistDatabase mock = createStrictMock(BucketlistDatabaseTest.class);
        mock.openSession();
        expect(mock.getAllUsersButMe()).andReturn(null);
        mock.closeSession();
		
	replay(mock);
	UserController c = new UserController();
        c.setDatabase(mock);
        c.getUsers();
		
	verify(mock);
    }
}
