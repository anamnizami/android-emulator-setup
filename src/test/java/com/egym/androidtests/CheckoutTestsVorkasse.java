package com.egym.androidtests;

import com.egym.listeners.MobileTestListener;
import com.egym.pageobjects.CheckoutPage;
import com.egym.pageobjects.FreeSearchBoxPage;
import com.egym.pageobjects.HomePage;
import com.egym.pageobjects.LoginPage;
import com.egym.util.Base;
import com.egym.util.SpecialProductsData;
import com.egym.util.TestDataUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ MobileTestListener.class })
public class CheckoutTestsVorkasse extends Base {

  private AppiumDriver<MobileElement> driver;
  private HomePage homePageObject;
  private LoginPage loginPageObject;
  private FreeSearchBoxPage freeSearchBoxPageObject;
  private CheckoutPage checkoutPageObject;

  @BeforeClass(alwaysRun = true, description = "Setup driver and initialise required classes")
  public void beforeClass() {
    driver = getDriver();
    homePageObject = new HomePage(driver);
    loginPageObject = new LoginPage(driver);
    freeSearchBoxPageObject = new FreeSearchBoxPage(driver);
    checkoutPageObject = new CheckoutPage(driver);
  }

  // Only works on 1 device because of webview issue: DEV-38749
  @Test(description = "Check out via Vorkasse")
  @Description("Returning user should be able to login")
  public void CheckoutTestVorkasseExistingUser() throws InterruptedException {
    String email = TestDataUtil.mobileUser;
    String password = TestDataUtil.passwordForAll;
    homePageObject.clickOnBoardingButton();
    homePageObject.clickToAcceptTrackingPolicyButton();
    homePageObject.clickOnAccountButton();
    loginPageObject.clickOnLoginButtonAndroid();
    loginPageObject.fillOutLoginForm(email, password);
    homePageObject.clickShopButton();
    freeSearchBoxPageObject.searchForItem(SpecialProductsData.productListForCheckout());
    freeSearchBoxPageObject.clickAddToCartButton();
    freeSearchBoxPageObject.clickShoppingCart();
    freeSearchBoxPageObject.clickCheckoutButton();
    Thread.sleep(5000);
    checkoutPageObject.switchContextToWebview(driver);
    checkoutPageObject.scrollToTriggerCookiesBanner();
    checkoutPageObject.clickAcceptCookie();
    checkoutPageObject.clickWeiterButton();
    checkoutPageObject.clickVorkasseRadioButton();
    checkoutPageObject.clickWeiterPaymentButton();
    checkoutPageObject.clickBuyNowButton();
    checkoutPageObject.switchContextToNativeApp(driver);
    Assert.assertTrue(checkoutPageObject.checkIfContinueShoppingButtonIsDisplayed());
  }

  @AfterClass(alwaysRun = true, description = "Tear down driver setup")
  public void tearDownDriver() {
    driver.quit();
  }
}
