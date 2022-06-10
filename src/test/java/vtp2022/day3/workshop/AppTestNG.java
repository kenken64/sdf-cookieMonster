package vtp2022.day3.workshop;

import org.testng.annotations.Test;

import vtp2022.day4.server.Cookie;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;

public class AppTestNG {
  @Test
  public void testCookie() {
    String randomCookie = Cookie
      .getRandomCookie("/Users/kennethphang/Projects/cookie-monster/cookie_file.txt");
    Assert.assertNull(randomCookie);
  }
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {

  }
}
