package com.egym.androidtests.catelogAndSearch;

import com.egym.listeners.MobileTestListener;
import com.egym.pageobjects.FreeSearchBoxPage;
import com.egym.pageobjects.HomePage;
import com.egym.util.Base;
import com.egym.util.SpecialProductsData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners({ MobileTestListener.class })
public class SearchByIdentifierTestsAndroid extends Base {

  private AppiumDriver<MobileElement> driver;
  private HomePage homePageObject;
  private FreeSearchBoxPage freeSearchBoxPageObject;

  @BeforeClass(alwaysRun = true, description = "Setup driver and initialise required classes")
  public void beforeClass() {
    driver = getDriver();
    homePageObject = new HomePage(driver);
    freeSearchBoxPageObject = new FreeSearchBoxPage(driver);
    homePageObject.clickOnBoardingButton();
    homePageObject.clickToAcceptTrackingPolicyButton();
  }

  @BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
    homePageObject.clickShopButton();
  }

  @Test(description = "Search for product using the SKU")
  @Description("The user should be able to perform a quick search with SKU")
  public void searchForProductUsingSku() throws InterruptedException {

    freeSearchBoxPageObject.searchForItem(SpecialProductsData.productSku());
    freeSearchBoxPageObject.clickAddToCartButton();
    freeSearchBoxPageObject.clickProductImage();
    Assert.assertTrue(freeSearchBoxPageObject.verifyIfProductInfoIsDisplayedAndroid());
  }

  @Test(description = "Search for product using the name")
  @Description("The user should be able to perform a quick search with product name")
  public void searchUsingProductName() throws InterruptedException {

    freeSearchBoxPageObject.searchForItem(SpecialProductsData.productName());
    freeSearchBoxPageObject.clickAddToCartButton();
    freeSearchBoxPageObject.clickProductImage();
    Assert.assertTrue(freeSearchBoxPageObject.verifyIfProductInfoIsDisplayedAndroid());
  }

  @AfterClass(alwaysRun = true, description = "Tear down driver setup")
  public void tearDownDriver() {
    driver.quit();
  }
}
