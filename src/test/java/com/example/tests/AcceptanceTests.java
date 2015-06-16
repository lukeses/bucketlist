package com.example.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AcceptanceTests {

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(Login.class);
    suite.addTestSuite(CreateDeleteItem.class);
    suite.addTestSuite(Progress.class);
    suite.addTestSuite(Image.class);
    suite.addTestSuite(ItemEdit.class);
    suite.addTestSuite(ItemShare.class);
    suite.addTestSuite(UserImage.class);
    suite.addTestSuite(ChangePassword.class);
    suite.addTestSuite(RegisterDelete.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}
