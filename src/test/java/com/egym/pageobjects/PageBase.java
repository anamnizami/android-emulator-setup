package com.egym.pageobjects;

import com.egym.util.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PageBase {
  protected AppiumDriver driver;
  public static MobileElement mobileElement;
  protected WebDriverWait mediumWaitTime;
  protected WebDriverWait maximumWaitTime;
  protected WebDriverWait minimumWaitTime;
  protected JavascriptExecutor jse;

  @iOSXCUITFindBy(accessibility = "logoutButton")
  protected MobileElement logoutButton;


  public PageBase(AppiumDriver<MobileElement> driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    minimumWaitTime = new WebDriverWait(driver, 5);
    mediumWaitTime = new WebDriverWait(driver, 10);
    maximumWaitTime = new WebDriverWait(driver, 20);
    jse = (JavascriptExecutor) driver;
  }

  public void clickMobileButton(MobileElement mobileButton) {
    minimumWaitTime.until(ExpectedConditions.elementToBeClickable(mobileButton));
    mobileButton.click();
  }

  public void clickWebButton(WebElement webButton) {
    minimumWaitTime.until(ExpectedConditions.elementToBeClickable(webButton));
    webButton.click();
  }

  // If normal .click() is not working, use this jse instead
  public void clickWebButtonViaJse(WebElement element) {
    jse.executeScript("arguments[0].click();", element);
  }

  @Step("Scroll to the bottom of the page to the exact element ")
  public void scrollToExactElement(WebElement element) {
    jse.executeScript("arguments[0].scrollIntoView(true);", element);
  }

  @Step("Scroll to the bottom of the page with exact yCoordinate value ")
  public void scrollToBottom(long yCoordinate) {
    jse.executeScript("scrollBy(0," + yCoordinate + ")");
  }

  @Step("Check if element is visible or not")
  public boolean visibilityOfMobileElement(MobileElement mobileElement) {
    try {
       mediumWaitTime.until(ExpectedConditions.visibilityOf(mobileElement));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Step("Check if element is visible or not")
  public boolean visibilityOfWebElement(WebElement webElement) {
    try {
      mediumWaitTime.until(ExpectedConditions.visibilityOf(webElement));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Step("Set text on a text element field")
  public void setTextMobileElement(MobileElement textMobileElement, String value) {
    minimumWaitTime.until(ExpectedConditions.elementToBeClickable(textMobileElement)).clear();
    textMobileElement.sendKeys(value);
  }

  @Step("Set text on a text element field")
  public void setTextWebElement(WebElement textWebElement, String value) {
    minimumWaitTime.until(ExpectedConditions.elementToBeClickable(textWebElement)).clear();
    textWebElement.sendKeys(value);
  }

  @Step("Click on logout button")
  public void clickOnLogoutButton() {
    clickMobileButton(logoutButton);
  }


  @Step("Check if the user is logged in")
  public boolean isUserIsLoggedIn() {
    return visibilityOfMobileElement(logoutButton);
  }

  @Step("Switch context to webview(index 1) or native app(index 0)")
  public void switchContext(AppiumDriver<MobileElement> driver, int index) throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
    Set<String> contextNames = driver.getContextHandles();
    for (String contextName : contextNames) {
      System.out.println("contextName: " + contextName);
    }

    driver.context((String) contextNames.toArray()[index]);

    String currentContext = driver.getContext();
    System.out.println("Current context: " + currentContext);

  }

  @Step("Scroll to element and click it on iOS screen")
  public void scrollToElementAndClickItForIOS(String id) {
    driver = new Base().getDriver();
    HashMap<String, Object> scrollObject =new HashMap<>();
    scrollObject.put("direction", "up");
    scrollObject.put("accessibility id", id);

    driver.executeScript("mobile:swipe", scrollObject);
    driver.findElementById(id).click();
  }
}
