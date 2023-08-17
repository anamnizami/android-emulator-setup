package com.egym.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GymSearchPage extends PageBase {

  @AndroidFindBy(id = "com.android.permissioncontroller:id/grant_dialog")
  protected MobileElement locationPermissionPopUp;
  @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
  protected MobileElement whileUsingTheAppButton;
  @AndroidFindBy(id = "search-window-widget")
  protected MobileElement googleMapSearchWindow;
  @FindBy(css = "body > div.SwipeableEdgeDrawer_container__TTET- > div > div")
  protected WebElement studioListPopUp;
  @FindBy(css = "#search-window-widget > div.MobileSearchInputComponent_textContainer__y49mS.MuiBox-root.css-0 > div.MobileSearchInputComponent_nameText__cNbAI")
  protected WebElement searchByStudioNameFieldWeb;
  @FindBy(css = "body > div.MobileSearchBarComponent_container__EFXtl.MuiBox-root.css-0 > div.MobileSearchBarComponent_inputContainer__y6\\+iL.MuiBox-root.css-0 > div.MobileSearchInputComponent_inputContainerExpanded__s6blI > div > div:nth-child(2) > div")
  protected WebElement searchByStudioNameFieldSecondWebview;
  @FindBy(css = "#studio-name-search")
  protected List<WebElement> studioNameFieldWebview;
  @FindBy(css = "#location-search-clear-btn")
  protected WebElement locationSearchClearButton;


  public GymSearchPage(AppiumDriver<MobileElement> driver) { super(driver);  }

  @Step("Click WhileUsingTheAppButton for giving permission")
  public void clickWhileUsingTheAppButton() {
    if (visibilityOfMobileElement(locationPermissionPopUp)) {
      clickMobileButton(whileUsingTheAppButton);
    }
  }

  @Step("Search Kale and Cake studio from Gym search widget")
  public void searchKaleAndCake(AppiumDriver<MobileElement> driver) throws InterruptedException {
    visibilityOfMobileElement(googleMapSearchWindow);
    switchContext(driver, 1);
    visibilityOfWebElement(searchByStudioNameFieldWeb);
    clickWebButtonViaJse(searchByStudioNameFieldWeb);
    visibilityOfWebElement(searchByStudioNameFieldSecondWebview);
    clickWebButton(searchByStudioNameFieldSecondWebview);
    visibilityOfWebElement(studioNameFieldWebview.get(1));
    setTextWebElement(studioNameFieldWebview.get(1), "cake");
    visibilityOfWebElement(locationSearchClearButton);
    clickWebButton(locationSearchClearButton);

    // Need refactor for this scroll up
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,500)");
    clickWebButton(studioListPopUp);
  }
}
