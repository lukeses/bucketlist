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
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
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
public class ItemControllerTest {
    
    public ItemControllerTest() {
    }
    
    @Test
    public void testAddItem() {
        IBucketlistDatabase mock = createStrictMock(BucketlistDatabaseTest.class);
        mock.addMyListItem("name", "description");
		
	replay(mock);
	ItemController c = new ItemController();
        c.setDatabase(mock);
        c.setName("name");
        c.setDescription("description");
	c.addItem();
		
	verify(mock);
    }
    
    @Test
    public void testUpdate() {
        IBucketlistDatabase mock = createStrictMock(BucketlistDatabaseTest.class);
        mock.saveItem(1, "name", "description");
		
	replay(mock);
	ItemController c = new ItemController();
        c.setDatabase(mock);
        c.setItemId(1);
        c.setName("name");
        c.setDescription("description");
	c.update();
		
	verify(mock);
    }    
}
