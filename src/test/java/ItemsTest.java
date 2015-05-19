import bucketlist.controller.BucketlistController;
import bucketlist.controller.BucketlistListItem;
import java.util.List;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hanka
 */
public class ItemsTest {
    /**
    private static final String WEBSITE_URL = "http://localhost:8084/bucketlist";
    private WebTester tester;
    
    @Before
    public void prepare() {
        tester = new WebTester();
        tester.setBaseUrl(WEBSITE_URL);
    }

    @Test
    public void testUserItems() {
        String email = "kowal82@buziaczek.pl";
        String pass = "irenka15";
        
        tester.beginAt("logpanel.jsp");
        
        tester.setTextField("inputEmail", email);
        tester.setTextField("inputPassword", pass);
        tester.submit("btnLogin");
        
        BucketlistController bucketlistController = new BucketlistController();
        List<BucketlistListItem> items = bucketlistController.getUserItems(bucketlistController.getUserByEmail(email).get(0).getId());
        
        if(items.isEmpty()) //empty items list
        {
            tester.assertTableRowCountEquals("user_items", 1);
        }
        else //not empty items list
        {
            tester.assertTableRowCountEquals("user_items", items.size() + 1);
        }
    }
    
    @Test
    public void testAllItems() {
        tester.beginAt("homepage.jsp");
        
        BucketlistController bucketlistController = new BucketlistController();
        List<BucketlistListItem> items = bucketlistController.getAllItems();
        
        if(items.isEmpty()) //empty items list
        {
            tester.assertTableRowCountEquals("all_items", 1);
        }
        else //not empty items list
        {
            tester.assertTableRowCountEquals("all_items", items.size() + 1);
        }
    }*/
}
