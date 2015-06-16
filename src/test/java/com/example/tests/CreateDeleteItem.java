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

public class CreateDeleteItem extends TestCase {
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
  public void testCreateDeleteItem() throws Exception {
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
    driver.findElement(By.id("j_idt11:j_idt17:3:j_idt35")).click();
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
