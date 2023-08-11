package com.egym.pageobjects;

import com.egym.util.TestDataUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.UUID;

public class RegistrationPage extends PageBase {

  @AndroidFindBy(id = "account_register_button")
  @iOSXCUITFindBy(accessibility = "Registrieren")
  protected MobileElement accountRegisterButton;

  @AndroidFindBy(id = "account_email_edittext")
  @iOSXCUITFindBy(accessibility = "emailTextField")
  protected MobileElement emailInputField;

  @AndroidFindBy(id = "account_password_edittext")
  @iOSXCUITFindBy(accessibility = "passwordTextField")
  protected MobileElement passwordInputField;

  @AndroidFindBy(id = "account_register_button")
  @iOSXCUITFindBy(accessibility = "signUpButton")
  protected MobileElement submitRegisterFormButton;

  @AndroidFindBy(id = "account_user_name")
  @iOSXCUITFindBy(accessibility = "tableView")
  protected MobileElement userAccount;

  @iOSXCUITFindBy(accessibility = "Loslegen!")
  protected MobileElement completeRegistrationButton;


  public RegistrationPage(AppiumDriver<MobileElement> driver) { super(driver); }

  @Step("Click the account button")
  public void clickOnAccountRegisterButton() {
    if (isUserIsLoggedIn()) {
      clickOnLogoutButton();
    }
    clickMobileButton(accountRegisterButton);
  }

  @Step("Fill out the registration form")
  public String fillOutRegisterForm() {
    String email = "automation-" + UUID.randomUUID().toString().substring(0, 8) + "@yopmail.com";
    setTextMobileElement(emailInputField, email);
    setTextMobileElement(passwordInputField, TestDataUtil.passwordForAll);
    clickMobileButton(submitRegisterFormButton);
    return email;
  }


  @Step("Check if user has successfully registered")
  public boolean checkIfUserAccountIsDisplayed() {
    return visibilityOfMobileElement(userAccount);
  }

  @Step("Click on finish button to complete registration")
  public void clickToFinishRegistration() {
    clickMobileButton(completeRegistrationButton);
  }
}
