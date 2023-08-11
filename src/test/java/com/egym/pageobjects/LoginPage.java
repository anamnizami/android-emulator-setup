package com.egym.pageobjects;

import com.egym.util.TestDataUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;


public class LoginPage extends PageBase {

  @AndroidFindBy(id = "account_login_button")
  @iOSXCUITFindBy(accessibility = "Anmelden")
  protected MobileElement loginButton;

  @AndroidFindBy(id = "account_email_edittext")
  @iOSXCUITFindBy(accessibility = "emailTextField")
  protected MobileElement emailInputField;

  @AndroidFindBy(id = "account_password_edittext")
  @iOSXCUITFindBy(accessibility = "passwordTextField")
  protected MobileElement passwordInputField;

  @AndroidFindBy(id = "account_login_button")
  @iOSXCUITFindBy(accessibility = "loginButton")
  protected MobileElement submitLoginFormButton;

  @iOSXCUITFindBy(accessibility = "tableView")
  protected MobileElement userAccountSection;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"subtitleLabel\"])[1]")
  protected MobileElement myProfileButton;

  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/account_my_orders_item_text")
  protected MobileElement myOrder;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='Fehler aufgetreten']")
  protected MobileElement invalidEmailMessageiOS;
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Alles klar']")
  protected MobileElement acceptPopupMsgiOS;
  @iOSXCUITFindBy(id = "Abbrechen")
  protected MobileElement closeLoginPageBtniOS;

  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/alertTitle")
  protected MobileElement invalidEmailMessageAndroid;
  @AndroidFindBy(id = "android:id/button1")
  protected MobileElement acceptPopupMsgAndroid;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/back")
  protected MobileElement closeLoginPageBtnandroid;

  public LoginPage(AppiumDriver driver) { super(driver); }

  @Step("Click on the login button")
  public void clickOnLoginButtoniOS() {
    if (isUserIsLoggedIn()) {
      clickOnLogoutButton();
    }
    clickMobileButton(loginButton);
  }

  @Step("Click on the login button")
  public void clickOnLoginButtonAndroid() {
    clickMobileButton(loginButton);
  }

  //This is to check if user is already login for iOS
  //If user is already logged in, it won't go inside the if statement
  public void loginFlowForCheckoutiOS() {
    String email = TestDataUtil.mobileUser;
    String password = TestDataUtil.passwordForAll;

    if (visibilityOfMobileElement(logoutButton)) {
      clickOnLogoutButton();
    }

    clickOnLoginButtoniOS();
    fillOutLoginForm(email, password);
  }

  // We need this user because a preselected address is
  // already configured in the account, if not the checkout steps will fail
  @Step("login flow for Checkout with correct user")
  public void loginFlowForCheckoutIOSWithCorrectUser() {
    String email = TestDataUtil.mobileUser;
    String password = TestDataUtil.passwordForAll;

    if (visibilityOfMobileElement(logoutButton)) {
      clickOnLogoutButton();
    }

    clickOnLoginButtoniOS();
    fillOutLoginForm(email, password);
  }

  // We need refactor for this method
  @Step("Fill out the login form and submit")
  public void fillOutLoginForm(String email, String password) {
    setTextMobileElement(emailInputField, email);
    setTextMobileElement(passwordInputField, password);
    clickMobileButton(submitLoginFormButton);
  }

  @Step("Fill out the login form and submit")
  public void fillOutLoginFormDynamicData(String email, String password) {
    setTextMobileElement(emailInputField, email);
    setTextMobileElement(passwordInputField, password);
    clickMobileButton(submitLoginFormButton);
  }

  @Step("Verify if the user is logged in")
  public boolean checkIfUserAccountIsDisplayed() {
    return visibilityOfMobileElement(userAccountSection);
  }

  @Step("Click on my profile button")
  public void clickOnMyProfileButton() {
    clickMobileButton(myProfileButton);
  }

  @Step("Check if MyOrderButton is enabled")
  public boolean checkIfMyOrderButtonIsEnabled() {
    return myOrder.getAttribute("enabled").equals("true");
  }

  @Step("Verify invalid email message for iOS")
  public boolean verifyInvalidEmailMessageiOS() {
    return visibilityOfMobileElement(invalidEmailMessageiOS);
  }

  @Step("Click on my wrong email popup message button for iOS")
  public void clickOnMyPopUpMessageButtoniOS() {
    clickMobileButton(acceptPopupMsgiOS);
  }

  @Step("Click on close login page for iOS")
  public void clickOnCloseBtniOS() {
    clickMobileButton(closeLoginPageBtniOS);
  }

  @Step("Verify invalid email message for Android")
  public boolean verifyInvalidEmailMessageAndroid() {
    return visibilityOfMobileElement(invalidEmailMessageAndroid);
  }

  @Step("Click on my wrong email popup message button for Android")
  public void clickOnMyPopUpMessageButtonAndroid() {
    clickMobileButton(acceptPopupMsgAndroid);
  }

  @Step("Click on close login page for Android")
  public void clickOnCloseBtnAndroid() {
    clickMobileButton(closeLoginPageBtnandroid);
  }
}
