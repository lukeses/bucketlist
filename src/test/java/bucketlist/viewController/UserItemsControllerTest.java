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
import java.util.List;
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
public class UserItemsControllerTest {

    public UserItemsControllerTest() {
    }

    @Test
    public void testEditAction() {
        UserItemsController userItems = new UserItemsController();
        BucketlistListItem item = new BucketlistListItem("name", "description");
	
        String result = userItems.editAction(item);
        assertEquals(result, null);
    }

    @Test
    public void testSaveAction() {
        IBucketlistDatabase mock = createStrictMock(BucketlistDatabaseTest.class);
        mock.openSession();
        BucketlistListItem item = new BucketlistListItem("name", "description");
        mock.updateItem(item);
        mock.closeSession();
		
	replay(mock);
	UserItemsController c = new UserItemsController();
        c.setDatabase(mock);
        c.saveAction(item);
		
	verify(mock);
    }

    @Test
    public void testDeleteAction() {
        IBucketlistDatabase mock = createStrictMock(BucketlistDatabaseTest.class);
        mock.openSession();
        BucketlistListItem item = new BucketlistListItem("name", "description");
        mock.deleteItem(item);
        mock.closeSession();
		
	replay(mock);
	UserItemsController c = new UserItemsController();
        c.setDatabase(mock);
        c.deleteAction(item);
		
	verify(mock);
    }
    
    @Test
    public void testDecreaseProgress() {
        IBucketlistDatabase mock = createStrictMock(BucketlistDatabaseTest.class);
        mock.openSession();
        BucketlistListItem item = new BucketlistListItem("name", "description");
        item.setItemId(1);
        item.setProgress(70);
        mock.decreaseProgress(item.getItemId());
        mock.closeSession();
		
	replay(mock);
	UserItemsController c = new UserItemsController();
        c.setDatabase(mock);
        c.decreaseProgress(1);
		
	verify(mock);
    }
    
    @Test
    public void testIncreaseProgress() {
        IBucketlistDatabase mock = createStrictMock(BucketlistDatabaseTest.class);
        mock.openSession();
        BucketlistListItem item = new BucketlistListItem("name", "description");
        item.setItemId(1);
        item.setProgress(70);
        mock.increaseProgress(item.getItemId());
        mock.closeSession();
		
	replay(mock);
	UserItemsController c = new UserItemsController();
        c.setDatabase(mock);
        c.increaseProgress(1);
		
	verify(mock);
    }
    
    @Test
    public void testProgress100() {
        IBucketlistDatabase mock = createStrictMock(BucketlistDatabaseTest.class);
        mock.openSession();
        BucketlistListItem item = new BucketlistListItem("name", "description");
        item.setItemId(1);
        item.setProgress(70);
        mock.progress100(item.getItemId());
        mock.closeSession();
		
	replay(mock);
	UserItemsController c = new UserItemsController();
        c.setDatabase(mock);
        c.progress100(1);
		
	verify(mock);
    }
}
