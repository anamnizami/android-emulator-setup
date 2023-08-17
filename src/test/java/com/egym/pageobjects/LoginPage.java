package com.egym.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;


public class LoginPage extends PageBase {

  @AndroidFindBy(id = "com.qualitrain.fitness:id/start_sign_in_button")
  protected MobileElement loginButton;

  @AndroidFindBy(id = "com.qualitrain.fitness:id/et_user_xid")
  protected MobileElement emailInputField;

  @AndroidFindBy(id = "com.qualitrain.fitness:id/et_user_passcode")
  protected MobileElement passwordInputField;

  @AndroidFindBy(id = "com.qualitrain.fitness:id/bt_sign_in")
  protected MobileElement submitLoginFormButton;


  public LoginPage(AppiumDriver driver) { super(driver); }

  @Step("Click on the login button")
  public void clickOnLoginButton() {
    visibilityOfMobileElement(loginButton);
    clickMobileButton(loginButton);
  }

  @Step("Fill out the login form and submit")
  public void fillOutLoginForm(String email, String password) {
    setTextMobileElement(emailInputField, email);
    setTextMobileElement(passwordInputField, password);
    clickMobileButton(submitLoginFormButton);
  }
}
