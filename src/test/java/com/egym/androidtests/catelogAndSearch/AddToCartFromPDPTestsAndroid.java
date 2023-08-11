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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ MobileTestListener.class })
public class AddToCartFromPDPTestsAndroid extends Base {

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
        homePageObject.clickTrackSettingContinueButton();
        homePageObject.clickAllowTracking();
    }

    @Test(description = "Add product to cart then remove product from cart")
    @Description("Add product to cart then remove product from cart")
    public void addProductToCartAndRemoveProductFromCart() throws InterruptedException {
        // Add to cart
       freeSearchBoxPageObject.searchForItem(SpecialProductsData.productListForCheckout());
       freeSearchBoxPageObject.clickProductImage();
       freeSearchBoxPageObject.clickAddToCartButtonFromPDP();
       freeSearchBoxPageObject.clickShoppingCart();
       Assert.assertTrue(freeSearchBoxPageObject.checkIfProductIsInCart());

       // Remove from cart
       freeSearchBoxPageObject.clickThreeDotsBottom();
       freeSearchBoxPageObject.clickDeleteBottom();
       Assert.assertFalse(freeSearchBoxPageObject.checkIfProductIsInCart());
    }

    @AfterClass(alwaysRun = true, description = "Tear down driver setup")
    public void tearDownDriver() {
        driver.quit();
    }
}
