package com.egym.pageobjects;


import com.egym.util.TestDataUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SofortSandboxPage extends PageBase {

    protected Actions actions;

    @FindBy(id = "BankCodeSearch")
    protected WebElement sofortBankCodeSearchBox;

    @FindBy(id = "BackendFormLOGINNAMEUSERID")
    protected WebElement sofortUsername;

    @FindBy(id = "BackendFormUSERPIN")
    protected WebElement sofortPassword;

    @FindBy(css = ".button-right")
    protected WebElement weiterSofortLogButtton;

    @FindBy(id = "account-1")
    protected WebElement sofortAccountGirokonto;

    @FindBy(id = "BackendFormTan")
    protected WebElement sofortTanForm;

    @FindBy(css = ".modal-content > * .cookie-modal-accept-all")
    protected WebElement acceptCookiesPolicyButton;

    @FindBy(css = ".main > .sidebar")
    protected WebElement sofortPageSidebar;

    @FindBy(css = "label[for='account-88888888'] p[class='description']")
    protected WebElement sofortDemoBankLink;

    @FindBy(css = ".button-right")
    protected WebElement sofortWeiterBtn;

    public SofortSandboxPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @Step("Check account in the Sofort payment method")
    public void checkSofortAccountGirokonto() {
        visibilityOfWebElement(sofortAccountGirokonto);
        clickWebButton(sofortAccountGirokonto);
    }

    @Step("Click on the Weiter button in the Sofort payment method")
    public void clickWeiterSofortLogButtton() {
        scrollToExactElement(weiterSofortLogButtton);
        visibilityOfWebElement(weiterSofortLogButtton);
        clickWebButton(weiterSofortLogButtton);
    }

    @Step("Click on the Weiter button in the Sofort payment method")
    public void clickWeiterSofortButtton() {
        scrollToExactElement(sofortWeiterBtn);
        visibilityOfWebElement(sofortWeiterBtn);
        clickWebButton(sofortWeiterBtn);
    }

    @Step("Complete the Sofort payment method")
    public void sofortPaymentSteps() throws InterruptedException {
        Thread.sleep(1500);

        if (visibilityOfWebElement(acceptCookiesPolicyButton)) { //Check to avoid failure when coming the second time
            acceptCookiesPolicyButton.click();
        }

        /** This section of the sofort pages are accessed only when the user accepts the cookies policy for the first time
         Meaning, a returning user won't have access to this section of sofort page but will directly land on the demo page*/
        Thread.sleep(2000);

        if (visibilityOfWebElement(sofortBankCodeSearchBox))  {
            setTextWebElement(sofortBankCodeSearchBox, TestDataUtil.bankCodeSofort);
            Thread.sleep(1500);
            if (!visibilityOfWebElement(sofortDemoBankLink)) {
                sofortBankCodeSearchBox.sendKeys(Keys.ENTER);
            } else {
                sofortDemoBankLink.click();
            }
        }
        Thread.sleep(2500);

        visibilityOfWebElement(sofortUsername);
        setTextWebElement(sofortUsername, "automation.user@yopm");
       // setTextWebElement(sofortPassword, ConstantUtil.qa1Password);
        clickWeiterSofortButtton();
        checkSofortAccountGirokonto();
        clickWeiterSofortLogButtton();
        visibilityOfWebElement(sofortTanForm);
        setTextWebElement(sofortTanForm, TestDataUtil.tanCodeSofort);
        clickWeiterSofortLogButtton();
    }
}
