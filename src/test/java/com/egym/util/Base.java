package com.egym.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.*;
import java.util.concurrent.TimeUnit;


public class Base {

  final static private String URL_STRING = "http://127.0.0.1:4723/";
  private final String deviceFarmPlatform = System.getenv("DEVICEFARM_DEVICE_PLATFORM_NAME");
  public static String platform;
  public static AppiumDriver<MobileElement> driver = null;
  LocalEnvSetup localAppiumSetup = new LocalEnvSetup();

  @Parameters({"platform"})
  @BeforeClass(alwaysRun = true, description = "Setup the driver locally or on device farm")
  public void setUpDriver(@Optional("ios") String platform) throws IOException, InterruptedException {
    Base.platform = platform;

    if (deviceFarmPlatform == null) {
      localAppiumSetup.startAppiumAndDevice(platform);
      driver = localAppiumSetup.setupDriver(platform, URL_STRING);
    } else {
      driver = DeviceFarmDriverSetupUtil.setUpAppium(deviceFarmPlatform, URL_STRING);
    }
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  public AppiumDriver<MobileElement> getDriver() {
    return driver;
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public static byte[] saveScreenshotPNG() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment(value = "{0}", type = "text/plain")
  public static String saveMessageLog(String message) {
    return message;
  }

  @AfterClass(alwaysRun = true)
  public void tearDownDriver() {
    if (getDriver() != null) {
      getDriver().quit();
    }
    if (LocalEnvSetup.service.isRunning() ) {
      LocalEnvSetup.service.stop();
    }
  }
}
