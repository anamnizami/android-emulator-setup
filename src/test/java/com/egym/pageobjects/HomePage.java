package com.egym.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import java.util.List;

public class HomePage extends PageBase {

  @AndroidFindBy(id = "com.qualitrain.fitness:id/root_view")
  protected MobileElement widgetHomeView;
  @AndroidFindBy(id = "com.qualitrain.fitness:id/title")
  protected List<MobileElement> widgetList;


  public HomePage(AppiumDriver<MobileElement> driver) { super(driver);  }

  public boolean checkIfWidgetHomeViewIsDisplayed() {
     return visibilityOfMobileElement(widgetHomeView);
  }

  @Step("Click GymSearch Widget")
  public void clickGymSearchWidget() {
    for (MobileElement ele : widgetList) {
      if (ele.getText().equals("Gym Search")) {
        clickMobileButton(ele);
        break;
      }
    }
  }

}
