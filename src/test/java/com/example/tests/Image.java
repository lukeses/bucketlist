package com.example.tests;

import java.net.URL;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Image extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:13089";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testImage() throws Exception {
      
    //URL rootfile= Test.class.getResource("/picture/WP_20150427_002.jpg");  
      
    driver.get(baseUrl + "/bucketlist/logpanel.xhtml");
    try {
      assertEquals("Logon", driver.findElement(By.cssSelector("span.ui-panel-title")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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
    driver.findElement(By.id("j_idt11:j_idt14")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    assertEquals("Add Item", driver.findElement(By.cssSelector("span.ui-panel-title")).getText());
    driver.findElement(By.name("j_idt7:j_idt10")).clear();
    driver.findElement(By.name("j_idt7:j_idt10")).sendKeys("Example");
    driver.findElement(By.name("j_idt7:j_idt12")).clear();
    driver.findElement(By.name("j_idt7:j_idt12")).sendKeys("Example description");
    driver.findElement(By.name("j_idt7:j_idt14")).click();
    assertEquals("Example", driver.findElement(By.xpath("//table[@id='j_idt11:j_idt17:3:j_idt19']/tbody/tr/td[2]")).getText());
    assertEquals("ui-button", driver.findElement(By.id("j_idt11:j_idt17:3:j_idt37")).getText());
    driver.findElement(By.id("j_idt11:j_idt17:3:j_idt37")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    assertEquals("Add Image to Item: Example", driver.findElement(By.cssSelector("span.ui-panel-title")).getText());
    assertEquals("Choose file:", driver.findElement(By.cssSelector("td")).getText());
    assertEquals("", driver.findElement(By.name("j_idt7:j_idt10")).getText());
    assertEquals("", driver.findElement(By.name("j_idt7:j_idt12")).getText());
    driver.findElement(By.name("j_idt7:j_idt10")).clear();
    driver.findElement(By.name("j_idt7:j_idt10")).sendKeys("D:\\repo\\BucketList\\Nowy folder\\bucketlist\\picture\\WP_20150427_002.jpg");
    assertEquals("", driver.findElement(By.name("j_idt7:j_idt10")).getText());
    driver.findElement(By.name("j_idt7:j_idt12")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getTable | id=j_idt11:j_idt17:3:j_idt19.0.0 | ]]
    assertEquals("", driver.findElement(By.xpath("//table[@id='j_idt11:j_idt17:3:j_idt19']/tbody/tr/td/a/img")).getText());
    driver.findElement(By.id("j_idt11:j_idt17:3:j_idt37")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    driver.findElement(By.name("j_idt7:j_idt10")).clear();
    driver.findElement(By.name("j_idt7:j_idt10")).sendKeys("D:\\repo\\BucketList\\Nowy folder\\bucketlist\\picture\\bv_high_1.png");
    driver.findElement(By.name("j_idt7:j_idt12")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getTable | id=j_idt11:j_idt17:3:j_idt19.0.0 | ]]
    assertEquals("", driver.findElement(By.xpath("//table[@id='j_idt11:j_idt17:3:j_idt19']/tbody/tr/td/a/img")).getText());
    driver.findElement(By.xpath("//table[@id='j_idt11:j_idt17:3:j_idt19']/tbody/tr/td/a/img")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("img.fancybox-image"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("", driver.findElement(By.cssSelector("img.fancybox-image")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("a.fancybox-nav.fancybox-next > span"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("a.fancybox-nav.fancybox-next > span")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("img.fancybox-image"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("", driver.findElement(By.cssSelector("img.fancybox-image")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("a.fancybox-nav.fancybox-prev > span"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("a.fancybox-nav.fancybox-prev > span")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("img.fancybox-image"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("", driver.findElement(By.cssSelector("img.fancybox-image")).getText());
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("a.fancybox-item.fancybox-close"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
    driver.findElement(By.id("j_idt11:j_idt15")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    assertEquals("kowal82@buziaczek.pl", driver.findElement(By.cssSelector("span")).getText());
    assertEquals("show items", driver.findElement(By.linkText("show items")).getText());
    driver.findElement(By.linkText("show items")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getTable | //div[@id='j_idt12:j_idt13']/div/ul/li[4]/table.0.0 | ]]
    assertEquals("", driver.findElement(By.xpath("//div[@id='j_idt12:j_idt13']/div/ul/li[4]/table/tbody/tr/td/a/img")).getText());
    driver.get(baseUrl + "/bucketlist/secured/userItems.xhtml");
    driver.findElement(By.id("j_idt11:j_idt17:3:j_idt35")).click();
    driver.findElement(By.id("j_idt11:j_idt13")).click();
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
