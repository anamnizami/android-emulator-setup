package com.egym.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class GaragePage extends PageBase {

  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/item_garage_entry_arrow_button")
  protected MobileElement garageEntryArrowBtn;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/mainactivity_garage_add_car_button")
  protected MobileElement addCarBtn;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/hsn_edit_text")
  protected MobileElement carSelectionDialogKbaNr1;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/tsn_edit_text")
  protected MobileElement carSelectionDialogKbaNr2;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/add_kba_button")
  protected MobileElement addKbaBtn;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/customer_car_details_save_button")
  protected MobileElement carDetailsSaveBtn;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/mainactivity_garage_backdrop_header_selected_car")
  protected MobileElement selectedCarGarageHeader;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/item_garage_entry_edit_button")
  protected MobileElement carEditBtn;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/vehicle_name_editText")
  protected MobileElement vehicleNameEditTxt;
  @AndroidFindBy(id = "de.kfzteile24.playqa.app:id/right_side_action_txt")
  protected MobileElement carDeleteBtn;

  public GaragePage(AppiumDriver<MobileElement> driver) { super(driver);  }

  @Step("Click on the on garage entry arrow button")
  public void clickOnGarageArrowButton() {
    clickMobileButton(garageEntryArrowBtn);
  }

  @Step("Click on the on add car button")
  public void clickOnAddCarButton() throws InterruptedException {
    Thread.sleep(1000);
    clickMobileButton(addCarBtn);
  }

  @Step("Fill out the dialog KBA Nr. input fields")
  public void fillOutDialogKbaNrInputFields(String valueKbaNrZu2, String valueKbaNrZu3) {
    setTextMobileElement(carSelectionDialogKbaNr1, valueKbaNrZu2 );
    setTextMobileElement(carSelectionDialogKbaNr2, valueKbaNrZu3);
  }

  @Step("Click on the on add KBA button")
  public void clickOnAddKbaButton() {
    clickMobileButton(addKbaBtn);
  }

  @Step("Click on the save button for car details")
  public void clickOnCarDetailsSaveButton() {
    clickMobileButton(carDetailsSaveBtn);
  }

  @Step("Verify if the selected vehicle is displayed in the garage header")
  public boolean checkIfSelectedCarIsDisplayed() {
    return visibilityOfMobileElement(selectedCarGarageHeader);
  }

  @Step("Click on the on edit vehicle button")
  public void clickOnEditVehicleButton() {
    clickMobileButton(carEditBtn);
  }

  @Step("The user update saved vehicle display name")
  public void updateSavedVehicleDisplayName(String displayName) {
    setTextMobileElement(vehicleNameEditTxt, displayName);
  }

  @Step("Click on saved vehicle deletion button")
  public void clickSavedVehicleDeleteButton() {
    clickMobileButton(carDeleteBtn);
  }

}
