package com.egym.pageobjects;

//import com.kfz24.util.ConstantUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class PayPalPaymentSanboxPage extends PageBase {


    @FindBy(id = "email")
    protected  WebElement payPalEmailBox;

    @FindBy(id = "btnNext")
    protected WebElement payPalWeiterButton;

    @FindBy(id = "password")
    protected WebElement payPalPasswordBox;

    @FindBy(xpath = "//button[@id='btnLogin']")
    protected WebElement payPalLoginButtton;

    @FindBy(id = "payment-submit-btn")
    protected WebElement payPalContinueButton;

    @FindBy(id = "acceptAllButton")
    protected WebElement payPalCookiesButton;

    @FindBy(xpath = "//div[contains(@class, 'FundingInstrument_instrument')]")
    protected WebElement paymentMethodContainers;

    public PayPalPaymentSanboxPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    @Step("PayPal payment method steps")
    public void payPalPaymentSteps() throws InterruptedException {
        Thread.sleep(3000);
     //   setTextWebElement(payPalEmailBox, ConstantUtil.paypalUsernameTestAccount);
        visibilityOfWebElement(payPalWeiterButton);
        clickWebButton(payPalWeiterButton);
        Thread.sleep(2500);
    //    setTextWebElement(payPalPasswordBox, ConstantUtil.paypalPasswordTestAccount);
        visibilityOfWebElement(payPalLoginButtton);
        clickWebButton(payPalLoginButtton);
        visibilityOfWebElement(paymentMethodContainers);
        visibilityOfWebElement(payPalContinueButton);
        clickWebButton(payPalContinueButton);
    }
}
