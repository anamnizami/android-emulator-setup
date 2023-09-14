package com.egym.androidtests;

import com.egym.listeners.MobileTestListener;
import com.egym.pageobjects.GymSearchPage;
import com.egym.pageobjects.HomePage;
import com.egym.pageobjects.LoginPage;
import com.egym.util.Base;
import com.egym.util.TestDataUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners({ MobileTestListener.class })
public class LoginAndSearchStudioTests extends Base {

  private AppiumDriver<MobileElement> driver;
  private HomePage homePageObject;
  private LoginPage loginPageObject;
  private GymSearchPage gymSearchPageObject;
  private final String password = TestDataUtil.passwordForAll;
  private final String email = TestDataUtil.mobileUserProdEmail;

  @BeforeClass(alwaysRun = true, description = "Setup driver and initialise required classes")
  public void beforeClass() {
    driver = getDriver();
    loginPageObject = new LoginPage(driver);
    homePageObject = new HomePage(driver);
    gymSearchPageObject = new GymSearchPage(driver);
  }

  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
    loginPageObject.clickOnLoginButton();
  }

  @Test(description = "User logs in and search for studio - kale & cake")
  @Description("")
  public void loginUserSearchStudioTest() throws InterruptedException {
    loginPageObject.fillOutLoginForm(email, password);
    Assert.assertTrue(homePageObject.checkIfWidgetHomeViewIsDisplayed());

//    homePageObject.clickGymSearchWidget();
//    gymSearchPageObject.clickWhileUsingTheAppButton();
//    gymSearchPageObject.searchKaleAndCake(driver);
//    Assert.assertEquals("9", "9");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @AfterClass(alwaysRun = true, description = "Tear down driver setup")
  public void tearDownDriver() {
    driver.quit();
  }
}
