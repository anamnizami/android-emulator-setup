package com.egym.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class FreeSearchBoxPage extends PageBase {

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/mainactivity_garage_add_car_button")
    protected MobileElement searchBox;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/search_src_text")
    protected MobileElement searchSourceText;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/productlist_item_product_add_to_cart_button")
    protected MobileElement addToCartButton;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/productdetails_add_to_cart_button")
    protected MobileElement addToCartButtonPDP;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/cart")
    protected MobileElement shoppingCart;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/button_checkout")
    protected MobileElement checkoutButton;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/productlist_item_product_image")
    protected MobileElement productImage;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/view_border")
    protected MobileElement productInShoppingCart;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/vItemMenu")
    protected MobileElement threeDotsIcon;

    @AndroidFindBy(id = "android:id/button1")
    protected MobileElement yesRemoveBtn;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().textContains(\"Abgasanlage\"))")
    protected MobileElement scrollToAbgasanlage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Abgasklappe\")")
    protected MobileElement abgasklappe;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"11 Artikel\")")
    protected MobileElement abgasklappe11Article;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/productdetails_main_content")
    protected MobileElement productInfo;

    AndroidDriver androidDriver;

    public FreeSearchBoxPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        androidDriver = (AndroidDriver) driver;
    }

    @Step("Search for an Item in the search menu")
    public void searchForItem(String item) throws InterruptedException {
        visibilityOfMobileElement(searchBox);
        clickMobileButton(searchBox);

        visibilityOfMobileElement(searchSourceText);
        setTextMobileElement(searchSourceText, item);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickAddToCartButton() {
        visibilityOfMobileElement(addToCartButton);
        clickMobileButton(addToCartButton);
    }

    @Step("Click AddToCartButton from PDP")
    public void clickAddToCartButtonFromPDP() {
        visibilityOfMobileElement(addToCartButtonPDP);
        clickMobileButton(addToCartButtonPDP);
    }

    public void clickShoppingCart() throws InterruptedException {
        Thread.sleep(3000);
        visibilityOfMobileElement(shoppingCart);
        clickMobileButton(shoppingCart);
    }

    public void clickCheckoutButton() {
        visibilityOfMobileElement(checkoutButton);
        clickMobileButton(checkoutButton);
    }

    @Step("Click product image")
    public void clickProductImage() {
        visibilityOfMobileElement(productImage);
        clickMobileButton(productImage);
    }

    @Step("Check if product is in cart")
    public boolean checkIfProductIsInCart() {
        return visibilityOfMobileElement(productInShoppingCart);
    }

    @Step("Click three dots icon")
    public void clickThreeDotsBottom() {
        visibilityOfMobileElement(threeDotsIcon);
        clickMobileButton(threeDotsIcon);
    }

    @Step("Click delete bottom")
    public void clickDeleteBottom() {
        // There is no proper id for the "Löschen" element and xpath from Appium inspector is long.
        // This is an alternative way to click.
        androidDriver.findElement(By.xpath("//*[contains(@text, 'Löschen')]")).click();
        clickMobileButton(yesRemoveBtn);
    }

    @Step("Verify if product information section is displayed")
    public boolean verifyIfProductInfoIsDisplayedAndroid() {
        return visibilityOfMobileElement(productInfo);
    }

    @Step("Click Abgasanlage Category and subcategory")
    public void clickAbgasanlage() throws InterruptedException {
        clickMobileButton(scrollToAbgasanlage);
        clickMobileButton(abgasklappe);
        Thread.sleep(2000);
        clickMobileButton(abgasklappe11Article);
    }
}
