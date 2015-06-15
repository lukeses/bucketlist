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
import java.io.IOException;
import javax.servlet.http.Part;
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
    
    @Test
    public void testGetFilename() throws IOException {
        Part part = null;
        String result = ItemController.getFilename(part);
        
        assertEquals(result, null);
    }  
    
    @Test
    public void testGetExtension() throws IOException {
        String filename = "image.jpg";
        String extension = "jpg";
        String result = ItemController.getExtension(filename);
        	
	assertEquals(result, extension);
    }   
    
    @Test
    public void testValidateExtension1() throws IOException {
        String filename = "image.jpg";
        ItemController c = new ItemController();
        
        boolean result = c.validateExtension(filename);
		
	assertEquals(result, true);
    }   
    
    @Test
    public void testValidateExtension2() throws IOException {
        String filename = "image.pdf";
        ItemController c = new ItemController();
        
        boolean result = c.validateExtension(filename);
		
	assertEquals(result, false);
    }  
}
