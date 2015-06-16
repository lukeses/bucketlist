package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterDelete extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:13089";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRegisterDelete() throws Exception {
    driver.get(baseUrl + "/bucketlist/logpanel.xhtml");
    assertEquals("Logon", driver.findElement(By.cssSelector("span.ui-panel-title")).getText());
    assertEquals("Log in", driver.findElement(By.id("j_idt6:j_idt11")).getText());
    assertEquals("Register", driver.findElement(By.id("j_idt12:j_idt15")).getText());
    driver.findElement(By.id("j_idt12:j_idt15")).click();
    assertEquals("First name", driver.findElement(By.id("j_idt5:j_idt7")).getText());
    assertEquals("Last name", driver.findElement(By.id("j_idt5:j_idt9")).getText());
    assertEquals("Password", driver.findElement(By.id("j_idt5:j_idt11")).getText());
    assertEquals("Repeat password", driver.findElement(By.id("j_idt5:j_idt13")).getText());
    assertEquals("Email address", driver.findElement(By.id("j_idt5:j_idt15")).getText());
    assertEquals("Repeat email address", driver.findElement(By.id("j_idt5:j_idt17")).getText());
    assertEquals("Register", driver.findElement(By.id("j_idt5:j_idt19")).getText());
    driver.findElement(By.id("j_idt5:j_idt8")).clear();
    driver.findElement(By.id("j_idt5:j_idt8")).sendKeys("First");
    driver.findElement(By.id("j_idt5:j_idt10")).clear();
    driver.findElement(By.id("j_idt5:j_idt10")).sendKeys("Last");
    driver.findElement(By.id("j_idt5:j_idt12")).clear();
    driver.findElement(By.id("j_idt5:j_idt12")).sendKeys("password");
    driver.findElement(By.id("j_idt5:j_idt14")).clear();
    driver.findElement(By.id("j_idt5:j_idt14")).sendKeys("password");
    driver.findElement(By.id("j_idt5:j_idt16")).clear();
    driver.findElement(By.id("j_idt5:j_idt16")).sendKeys("email@email.email");
    driver.findElement(By.id("j_idt5:j_idt18")).clear();
    driver.findElement(By.id("j_idt5:j_idt18")).sendKeys("email@email.email");
    driver.findElement(By.id("j_idt5:j_idt19")).click();
    assertEquals("Logon", driver.findElement(By.cssSelector("span.ui-panel-title")).getText());
    driver.findElement(By.id("j_idt6:name")).click();
    driver.findElement(By.id("j_idt6:name")).clear();
    driver.findElement(By.id("j_idt6:name")).sendKeys("email@email.email");
    driver.findElement(By.id("j_idt6:pass")).clear();
    driver.findElement(By.id("j_idt6:pass")).sendKeys("password");
    driver.findElement(By.id("j_idt6:j_idt11")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("j_idt11"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    //assertEquals("Welcome email@email.email! \nLog outAdd itemUsersUser panel", driver.findElement(By.id("j_idt11")).getText());
    driver.findElement(By.id("j_idt11:j_idt16")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    assertEquals("Manage profile", driver.findElement(By.xpath("//div[@id='j_idt6:j_idt10']/h3[2]")).getText());
    driver.findElement(By.xpath("//div[@id='j_idt6:j_idt10']/h3[2]")).click();
    driver.findElement(By.xpath("//div[@id='j_idt6:j_idt10']/h3[2]")).click();
    driver.findElement(By.xpath("//div[@id='j_idt6:j_idt10']/h3[2]")).click();
    assertEquals("Confirm with password:", driver.findElement(By.cssSelector("label")).getText());
    assertEquals("Delete account", driver.findElement(By.id("j_idt6:j_idt10:j_idt16:j_idt25")).getText());
    driver.findElement(By.id("j_idt6:j_idt10:j_idt16:j_idt19")).clear();
    driver.findElement(By.id("j_idt6:j_idt10:j_idt16:j_idt19")).sendKeys("password");
    driver.findElement(By.id("j_idt6:j_idt10:j_idt16:j_idt25")).click();
    assertEquals("Logon", driver.findElement(By.cssSelector("span.ui-panel-title")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
