/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketlist.model;

import bucketlist.controller.BucketlistDatabaseTest;
import bucketlist.controller.BucketlistListItem;
import bucketlist.controller.IBucketlistDatabase;
import bucketlist.viewController.ItemController;
import java.util.Date;
import java.util.List;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
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

    @Test
    public void testChangePassword() {
	BucketlistUserInfo userInfo = new BucketlistUserInfo();
        
        boolean result = userInfo.changePassword("oldPass", "newPass");
        assertEquals(result, true);
    }
    
    @Test
    public void testChangePasswordFail() {
	BucketlistUserInfo userInfo = new BucketlistUserInfo();
        
        boolean result = userInfo.changePassword("oldPass", "oldPass");
        assertEquals(result, false);
    }
}
