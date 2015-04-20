import org.junit.*; 
import net.sourceforge.jwebunit.junit.WebTester;

/**
 *
 * @author hanka
 */
public class UserAuthenticationTest {
    
    private static final String WEBSITE_URL = "http://localhost:8084/bucketlist";
    private WebTester tester;
    
    @Before
    public void prepare() {
        tester = new WebTester();
        tester.setBaseUrl(WEBSITE_URL);
    }
    
    @Test
    public void testSuccessfulLogin() {
        tester.beginAt("logpanel.jsp");
        tester.assertTitleEquals("Login");
        
        tester.assertButtonPresent("btnLogin");
        tester.assertButtonPresent("btnRegister");
        tester.assertFormPresent("login_form");
        tester.assertFormElementPresent("inputEmail");
        tester.assertFormElementPresent("inputPassword");

        tester.setTextField("inputEmail", "kowal82@buziaczek.pl");
        tester.setTextField("inputPassword", "irenka15");
        tester.assertFormElementMatch("inputEmail", "kowal82@buziaczek.pl");
        tester.assertFormElementMatch("inputPassword", "irenka15");
        tester.submit("btnLogin");
        tester.assertTitleEquals("User Items");
        tester.assertButtonPresent("btnLogout");
    }
    
    @Test
    public void testUnsuccessfulLogin() {
        tester.beginAt("logpanel.jsp");
        tester.assertTitleEquals("Login");
        
        tester.assertFormPresent("login_form");
        tester.assertFormElementPresent("inputEmail");
        tester.assertFormElementPresent("inputPassword");
        tester.assertButtonPresent("btnLogin");
        tester.assertButtonPresent("btnRegister");

        tester.setTextField("inputEmail", "incorrectLogin");
        tester.setTextField("inputPassword", "incorrectPassword");
        tester.assertFormElementMatch("inputEmail", "incorrectLogin");
        tester.assertFormElementMatch("inputPassword", "incorrectPassword");
        tester.submit("btnLogin");
        tester.assertTitleEquals("Login");
        tester.assertTextPresent("User does not exist!");
    }
    
    @Test
    public void testRegister() {
        tester.beginAt("regpanel.jsp");
        tester.assertTitleEquals("Register");
        
        tester.assertFormPresent("registration_form");
        tester.assertFormElementPresent("fName");
        tester.assertFormElementPresent("lName");
        tester.assertFormElementPresent("pass1");
        tester.assertFormElementPresent("pass2");
        tester.assertFormElementPresent("email1");
        tester.assertFormElementPresent("email2");
        tester.assertButtonPresent("btnRegister");
        
        tester.submit("btnRegister");
        tester.assertTitleEquals("Register");
    }
    
    @Test
    public void testLogout() {
        tester.beginAt("logpanel.jsp");
        
        tester.setTextField("inputEmail", "kowal82@buziaczek.pl");
        tester.setTextField("inputPassword", "irenka15");
        tester.submit("btnLogin");

        tester.submit("btnLogout");
        tester.assertTitleEquals("Login");
    }
}
