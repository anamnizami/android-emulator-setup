package com.egym.androidtests;

import com.egym.listeners.MobileTestListener;
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
public class LoginTests extends Base {

  private AppiumDriver<MobileElement> driver;
  private HomePage homePageObject;
  private LoginPage loginPageObject;
  private final String password = TestDataUtil.passwordForAll;
  private final String email = TestDataUtil.mobileUser;

  @BeforeClass(alwaysRun = true, description = "Setup driver and initialise required classes")
  public void beforeClass() {
    driver = getDriver();
    homePageObject = new HomePage(driver);
    loginPageObject = new LoginPage(driver);
    homePageObject.clickOnBoardingButton();
    homePageObject.clickToAcceptTrackingPolicyButton();
  }

  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
    homePageObject.clickOnAccountButton();
    loginPageObject.clickOnLoginButtonAndroid();
  }

  @Test(description = "User logs in")
  @Description("Returning user should be able to login")
  public void loginUserTest() {
    loginPageObject.fillOutLoginForm(email,password);
    Assert.assertTrue(loginPageObject.checkIfMyOrderButtonIsEnabled());
  }

  @Test(description = "User login with wrong email")
  @Description("A user should not be able to log in with a wrong email")
  public void logInWithWrongEmail() {
    String invalidEmail = TestDataUtil.qa1UserWrong;

    loginPageObject.fillOutLoginForm(invalidEmail, password);
    Assert.assertTrue(loginPageObject.verifyInvalidEmailMessageAndroid());
    loginPageObject.clickOnMyPopUpMessageButtonAndroid();
    loginPageObject.clickOnCloseBtnAndroid();
  }

  @Test(description = "User logs in with a wrong password" )
  @Description("A user should not log in with a wrong password")
  public void logInWithWrongPassword() {
    String wrongPassword = TestDataUtil.qa1WrongPassword;
    loginPageObject.fillOutLoginForm(email, wrongPassword);
    Assert.assertTrue(loginPageObject.verifyInvalidEmailMessageAndroid());
    loginPageObject.clickOnMyPopUpMessageButtonAndroid();
    loginPageObject.clickOnCloseBtnAndroid();
  }

  @AfterClass(alwaysRun = true, description = "Tear down driver setup")
  public void tearDownDriver() {
    driver.quit();
  }
}
