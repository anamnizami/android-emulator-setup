package com.egym.pageobjects;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MyProfilePage extends PageBase {


  @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Mein Profil\"]")
  protected MobileElement myProfilePage;

  @iOSXCUITFindBy(id = "Profil bearbeiten")
  protected MobileElement editProfile;

  @iOSXCUITFindBy(id = "Passwort ändern")
  protected MobileElement changePassword;

  @iOSXCUITFindBy(id = "currentPasswordTextField")
  protected MobileElement currentPasswordTextField;

  @iOSXCUITFindBy(id = "newPasswordTextField")
  protected MobileElement newPasswordTextField;

  @iOSXCUITFindBy(id = "newPasswordRepeatTextField")
  protected MobileElement newPasswordRepeatTextField;

  @iOSXCUITFindBy(id = "submitButton")
  protected MobileElement submitButton;

  @iOSXCUITFindBy(id = "nameLabel")
  protected MobileElement changePersonalData;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Frau\"]")
  protected MobileElement frau;

  @iOSXCUITFindBy(id = "Vorname")
  protected MobileElement firstName;

  @iOSXCUITFindBy(id = "Nachname")
  protected MobileElement lastName;

  @iOSXCUITFindBy(id = "Telefonnummer")
  protected MobileElement telephoneNumber;

  @iOSXCUITFindBy(id = "saveButton")
  protected MobileElement saveButton;

  @iOSXCUITFindBy(id = "Mobile Automation")
  protected MobileElement mobileAutomationLabel;

  public MyProfilePage(AppiumDriver<MobileElement> driver) {
    super(driver);
  }

  @Step("Check if profile page is being displayed")
  public boolean onMyProfilePage() {
    return visibilityOfMobileElement(myProfilePage);
  }

  @Step("Click Edit-Profile Button")
  public void clickEditProfileButton() {
    visibilityOfMobileElement(editProfile);
    clickMobileButton(editProfile);
  }

  @Step("Click change-password Button")
  public void clickChangePasswordButton() {
    visibilityOfMobileElement(changePassword);
    clickMobileButton(changePassword);
  }

  @Step("Click Change Personal Data Button")
  public void clickChangePersonalDataButton() {
    visibilityOfMobileElement(changePersonalData);
    clickMobileButton(changePersonalData);
  }

  @Step("Enter current password")
  public void enterCurrentPassword(String currentPassword) {
    visibilityOfMobileElement(currentPasswordTextField);
    setTextMobileElement(currentPasswordTextField, currentPassword);
  }

  @Step("Enter new password")
  public void enterNewPassword(String newPassword) {
    visibilityOfMobileElement(newPasswordTextField);
    setTextMobileElement(newPasswordTextField, newPassword);
  }

  @Step("Enter new password again")
  public void enterNewPasswordAgain(String newPassword) {
    visibilityOfMobileElement(newPasswordRepeatTextField);
    setTextMobileElement(newPasswordRepeatTextField, newPassword);
  }

  @Step("Click submit button")
  public void clickSubmitButton() {
    visibilityOfMobileElement(submitButton);
    clickMobileButton(submitButton);
  }

  @Step("Check if Change Password Button is displayed")
  public boolean checkIfChangePasswordButtonDisplayed() {
    return visibilityOfMobileElement(changePassword);
  }

  @Step("Fill in personal data")
  public void fillInPersonalData() {
    clickMobileButton(frau);
    setTextMobileElement(firstName, "Mobile");
    setTextMobileElement(lastName, "Automation");
    setTextMobileElement(telephoneNumber, "123456789");
    scrollToElementAndClickItForIOS("saveButton");
  }

  @Step("Check if Mobile Automation is displayed")
  public boolean checkIfMobileAutomationDisplayed() {
    return visibilityOfMobileElement(mobileAutomationLabel);
  }

}
