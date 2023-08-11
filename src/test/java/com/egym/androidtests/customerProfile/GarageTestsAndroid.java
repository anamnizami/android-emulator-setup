package com.egym.androidtests.customerProfile;

import com.egym.listeners.MobileTestListener;
import com.egym.pageobjects.GaragePage;
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
public class GarageTestsAndroid extends Base {

  private AppiumDriver<MobileElement> driver;
  private HomePage homePageObject;
  private LoginPage loginPageObject;
  private GaragePage garagePageObject;

  @BeforeClass(alwaysRun = true, description = "Setup driver and initialise required classes")
  public void beforeClass() {
    driver = getDriver();
    homePageObject = new HomePage(driver);
    loginPageObject = new LoginPage(driver);
    garagePageObject = new GaragePage(driver);
    homePageObject.clickOnBoardingButton();
    homePageObject.clickToAcceptTrackingPolicyButton();
    homePageObject.clickOnAccountButton();
    loginPageObject.clickOnLoginButtonAndroid();
    String password = TestDataUtil.passwordForAll;
    String email = TestDataUtil.mobileUser;
    loginPageObject.fillOutLoginForm(email, password);
  }

  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
    homePageObject.clickShopButton();
    garagePageObject.clickOnGarageArrowButton();
  }

  @Test(description = "Save or add vehicle to garage through dialog")
  @Description("User can successfully add or save a vehicle to garage via dialog vehicle selection")
  public void addVehicleToGarage() throws InterruptedException {
    String kbaZu2 = TestDataUtil.KBA_NR_ZU_2_GOLF3;
    String kbaZu3 = TestDataUtil.KBA_NR_ZU_3_GOLF3;

    garagePageObject.fillOutDialogKbaNrInputFields(kbaZu2, kbaZu3);
    garagePageObject.clickOnAddKbaButton();
    garagePageObject.clickOnCarDetailsSaveButton();
    Assert.assertTrue(garagePageObject.checkIfSelectedCarIsDisplayed());
  }

  @Test(description = "EDIT vehicle under My vehicles logged in user", dependsOnMethods = {"addVehicleToGarage"})
  @Description("User should be able to EDIT their saved vehicles")
  public void carSelectionEditMyVehicleTest() {
    String vehicleUpdateName = "AutomationSavedVehicle updated";

    garagePageObject.clickOnEditVehicleButton();
    garagePageObject.updateSavedVehicleDisplayName(vehicleUpdateName);
    garagePageObject.clickOnCarDetailsSaveButton();
    Assert.assertTrue(garagePageObject.checkIfSelectedCarIsDisplayed());
  }

  @Test(description = "Delete vehicle under My vehicles logged in user", dependsOnMethods = {"carSelectionEditMyVehicleTest"})
  @Description("User should be able to delete their saved vehicles")
  public void carSelectionDeleteMyVehicleTest() {
    garagePageObject.clickOnEditVehicleButton();
    garagePageObject.clickSavedVehicleDeleteButton();
    Assert.assertTrue(garagePageObject.checkIfSelectedCarIsDisplayed());
  }

  @AfterClass(alwaysRun = true, description = "Tear down driver setup")
  public void tearDownDriver() {
    driver.quit();
  }
}
