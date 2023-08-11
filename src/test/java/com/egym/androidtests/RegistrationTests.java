package com.egym.androidtests;

import com.egym.listeners.MobileTestListener;
import com.egym.pageobjects.HomePage;
import com.egym.pageobjects.RegistrationPage;
import com.egym.util.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners({ MobileTestListener.class })
public class RegistrationTests extends Base {

  private AppiumDriver<MobileElement> driver;
  private HomePage homePageObject;
  private RegistrationPage registrationPageObject;

  @BeforeClass(description = "Setup driver and initialise required classes")
  public void beforeClass() {
    driver = getDriver();
    homePageObject = new HomePage(driver);
    registrationPageObject = new RegistrationPage(driver);
  }

  @Test(description = "Register user")
  @Description("User should be able to register successfully")
  public void registerUserTest() {

    homePageObject.clickOnBoardingButton();
    homePageObject.clickToAcceptTrackingPolicyButton();

    homePageObject.clickOnAccountButton();
    registrationPageObject.clickOnAccountRegisterButton();
    registrationPageObject.fillOutRegisterForm();

    Assert.assertTrue(registrationPageObject.checkIfUserAccountIsDisplayed());

  }

  @AfterClass(description = "Tear down driver setup")
  public void tearDownDriver() { driver.quit(); }

}
