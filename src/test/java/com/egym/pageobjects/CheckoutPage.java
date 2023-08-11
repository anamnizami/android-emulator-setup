package com.egym.pageobjects;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends PageBase {


    @FindBy(css = "button.qa-CookiesMain__btn-agree")
    protected WebElement acceptCookie;

    @FindBy(name = "address__button")
    protected WebElement weiterButton;

    @FindBy(name = "payment__button")
    protected WebElement weiterPaymentButton;

    @FindBy(css = ".qa-payment_in_advance__radio")
    protected WebElement vorkasseRadioButton;

    @FindBy(css = ".qa-afterpay__radio")
    protected WebElement rechnungszahlungRadioButton;

    @FindBy(css = ".qa-paypal__radio")
    protected WebElement payPalRadioButton;

    @FindBy(css = ".qa-sofortuberweisung__radio")
    protected WebElement sofortRadioButton;

    @FindBy(name = "confirmation__button")
    protected WebElement buyNowButton;

    @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/cart_button_continue_shopping")
    @iOSXCUITFindBy(accessibility = "ctaButton")
    protected MobileElement continueShoppingButton;

    @iOSXCUITFindBy(accessibility = "Not Now")
    protected MobileElement notNowButton;

    public CheckoutPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Switch context to Webview")
    public void switchContextToWebview(AppiumDriver<MobileElement> driver) throws InterruptedException {
          switchContext(driver, 1);
    }

    @Step("Switch context to NativeApp")
    public void switchContextToNativeApp(AppiumDriver<MobileElement> driver) throws InterruptedException {
        switchContext(driver, 0);
    }

    @Step("Click Accept Cookie Button")
    public void clickAcceptCookie() throws InterruptedException {
        Thread.sleep(3000);
        visibilityOfWebElement(acceptCookie);
        clickWebButton(acceptCookie);
    }

    @Step("Click Weiter Button")
    public void clickWeiterButton() {
        scrollToExactElement(weiterButton);
        visibilityOfWebElement(weiterButton);
        clickWebButton(weiterButton);
    }

    @Step("Click Vorkasse Radio Button")
    public void clickVorkasseRadioButton() throws InterruptedException {
        Thread.sleep(5000);
        scrollToExactElement(vorkasseRadioButton);
        clickWebButtonViaJse(vorkasseRadioButton);
    }

    @Step("Click Rechnungszahlung Radio Button")
    public void clickRechnungszahlungRadioButton() throws InterruptedException {
        Thread.sleep(3000);
        scrollToExactElement(rechnungszahlungRadioButton);
        clickWebButtonViaJse(rechnungszahlungRadioButton);
    }

    @Step("Click Paypal Radio Button")
    public void clickPaypalRadioButton() throws InterruptedException {
        Thread.sleep(3000);
        scrollToExactElement(payPalRadioButton);
        clickWebButtonViaJse(payPalRadioButton);
    }

    @Step("Scroll To trigger CookiesBanner")
    public void scrollToTriggerCookiesBanner() throws InterruptedException {
        Thread.sleep(5000);
        scrollToBottom(500);
    }

    @Step("Click Weiter Payment Button")
    public void clickWeiterPaymentButton() {
        clickWebButton(weiterPaymentButton);
    }

    @Step("Check if continueShoppingButton is displayed")
    public boolean checkIfContinueShoppingButtonIsDisplayed() {
        return visibilityOfWebElement(continueShoppingButton);
    }

    @Step("Click BuyNowButton")
    public void clickBuyNowButton(){
        visibilityOfWebElement(buyNowButton);
        scrollToBottom(1000);
        clickWebButtonViaJse(buyNowButton);
    }

    @Step("Click NotNow Button")
    public void clickNotNowButton(){
        visibilityOfWebElement(notNowButton);
        clickWebButton(notNowButton);
    }

    @Step("Click Sofort radio button")
    public void clickSofortButton() throws InterruptedException {
        Thread.sleep(3000);
        scrollToExactElement(sofortRadioButton);
        clickWebButtonViaJse(sofortRadioButton);
    }

}
