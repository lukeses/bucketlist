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

public class UserImage extends TestCase {
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
  public void testUserImage() throws Exception {
    driver.get(baseUrl + "/bucketlist/logpanel.xhtml");
    assertEquals("Logon", driver.findElement(By.cssSelector("span.ui-panel-title")).getText());
    driver.findElement(By.id("j_idt6:name")).clear();
    driver.findElement(By.id("j_idt6:name")).sendKeys("kowal82@buziaczek.pl");
    driver.findElement(By.id("j_idt6:pass")).clear();
    driver.findElement(By.id("j_idt6:pass")).sendKeys("irenka15");
    driver.findElement(By.id("j_idt6:j_idt11")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("j_idt11"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    //assertEquals("Welcome kowal82@buziaczek.pl! \nLog outAdd itemUsersUser panel \nIsc do baru. ui-button ui-button ui-button \n Finish task ui-button 0% \n \n ui-button \n \n \nSamochód ui-button ui-button ui-button \n Finish task ui-button 0% \n \n ui-button \n \n \nZarobic milion dolarow. ui-button ui-button ui-button \n Finish task ui-button 0% \n \n ui-button", driver.findElement(By.id("j_idt11")).getText());
    assertEquals("User panel", driver.findElement(By.id("j_idt11:j_idt16")).getText());
    driver.findElement(By.id("j_idt11:j_idt16")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    assertEquals("Change profile picture", driver.findElement(By.xpath("//div[@id='j_idt6:j_idt10']/h3")).getText());
    driver.findElement(By.xpath("//div[@id='j_idt6:j_idt10']/h3")).click();
    driver.findElement(By.xpath("//div[@id='j_idt6:j_idt10']/h3")).click();
    Thread.sleep(1000);
    assertEquals("Upload new picture", driver.findElement(By.id("j_idt6:j_idt10:j_idt14")).getText());
    driver.findElement(By.id("j_idt6:j_idt10:j_idt14")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    assertEquals("", driver.findElement(By.id("j_idt6:j_idt7_input")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("j_idt6:j_idt7_input"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("j_idt6:j_idt7_input")).clear();
    driver.findElement(By.id("j_idt6:j_idt7_input")).sendKeys("D:\\repo\\BucketList\\Nowy folder\\bucketlist\\picture\\WP_20150427_002.jpg");
    assertEquals("", driver.findElement(By.cssSelector("canvas")).getText());
    assertEquals("WP_20150427_002.jpg", driver.findElement(By.xpath("//div[@id='j_idt6:j_idt7']/div[2]/table/tbody/tr/td[2]")).getText());
    // ERROR: Caught exception [ERROR: Unsupported command [getTable | css=table.ui-fileupload-files.0.3 | ]]
    assertEquals("ui-button", driver.findElement(By.xpath("//div[@id='j_idt6:j_idt7']/div[2]/table/tbody/tr/td[5]/button")).getText());
    assertEquals("Upload", driver.findElement(By.xpath("//button[@type='button']")).getText());
    assertEquals("Cancel", driver.findElement(By.xpath("(//button[@type='button'])[2]")).getText());
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.get(baseUrl + "/bucketlist/secured/userPanel.xhtml");
    // ERROR: Caught exception [ERROR: Unsupported command [getTable | css=table.0.0 | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [getTable | css=table.0.0 | ]]
    assertEquals("", driver.findElement(By.id("j_idt6:j_idt10:j_idt13")).getText());
    driver.findElement(By.id("j_idt6:j_idt9")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    assertEquals("kowal82@buziaczek.pl", driver.findElement(By.cssSelector("span")).getText());
    assertEquals("", driver.findElement(By.id("j_idt5:j_idt6:0:j_idt8")).getText());
    driver.get(baseUrl + "/bucketlist/secured/userPanel.xhtml");
    driver.findElement(By.id("j_idt6:j_idt8")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    driver.findElement(By.id("j_idt11:j_idt13")).click();
    try {
      assertEquals("Logon", driver.findElement(By.cssSelector("span.ui-panel-title")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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
