package com.egym.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class HomePage extends PageBase {

  @AndroidFindBy(id = "onboarding_intro_button")
  @iOSXCUITFindBy(accessibility = "startButton")
  protected MobileElement onBoardingIntroductionButton;

  @AndroidFindBy(id = "onboarding_skip_button")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Überspringen\"]\n")
  protected MobileElement skipOnBoardingIntroduction;

  @AndroidFindBy(id = "tracking_accept_button")
  @iOSXCUITFindBy(accessibility = "saveAndContinueButton")
  protected MobileElement acceptTrackingPolicyButton;

  @AndroidFindBy(id = "account")
  @iOSXCUITFindBy(accessibility = "Konto")
  protected MobileElement accountButton;

  @iOSXCUITFindBy(accessibility = "nextButton")
  protected MobileElement trackSettingContinueButton;

  @AndroidFindBy(id = "Allow")
  @iOSXCUITFindBy(accessibility = "Allow")
  protected MobileElement allowTracking;

  @iOSXCUITFindBy(accessibility = "Gastkonto")
  protected MobileElement loginRegistrationPage;

  @AndroidFindBy(accessibility = "Shop")
  @iOSXCUITFindBy(accessibility = "Shop")
  protected MobileElement shopButton;

  public HomePage(AppiumDriver<MobileElement> driver) { super(driver);  }

  @Step("Click on the on boarding introduction button")
  public void clickOnBoardingButton() {
    clickMobileButton(onBoardingIntroductionButton);
  }

  @Step("Click to skip the on boarding introduction")
  public void clickToSkipOnBoardingIntroduction() {
    clickMobileButton(skipOnBoardingIntroduction);
  }

  @Step("Accept the tracking policy")
  public void clickToAcceptTrackingPolicyButton() {
    clickMobileButton(acceptTrackingPolicyButton);
  }

  @Step("Click on the account button")
  public void clickOnAccountButton() {
    clickMobileButton(accountButton);
  }

  @Step("Click on continue button to set tracking")
  public void clickTrackSettingContinueButton() {
    if (visibilityOfMobileElement(trackSettingContinueButton)) {
      clickMobileButton(trackSettingContinueButton);
    }
  }

  @Step("Click on allow tracking button")
  public void clickAllowTracking() {
   if (visibilityOfMobileElement(allowTracking)) {
     clickMobileButton(allowTracking);
   }
  }

  @Step("Check if loginRegistration page is being displayed")
  public boolean onLoginRegistrationPage() {
    return visibilityOfMobileElement(loginRegistrationPage);
  }

  public void clickShopButton() {
    if (visibilityOfMobileElement(shopButton)) {
      clickMobileButton(shopButton);
    }
  }

}
