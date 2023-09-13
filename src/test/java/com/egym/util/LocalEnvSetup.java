package com.egym.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.net.*;

public class LocalEnvSetup {

  protected File appLocalPath = new File("src/apps/");
  protected static File startScriptPath = new File("src/test/resources/");
  public static AppiumDriverLocalService service;
  String androidAppName  = "galaxy-QualitrainRelease-3.13.10644.283.apk";
  String iosAppName = "K24-app.app";
  DesiredCapabilities capabilities = new DesiredCapabilities();
  AppiumDriver<MobileElement> localDriver;


  public void startAppiumAndDevice(String platform) throws IOException, InterruptedException {

    createOrKeepService();

    Thread.sleep(5000);

    if (platform.equals("android")) {
    //  startEmulator();
    } else {
      startSimulator();
    }
    Thread.sleep(5000);
  }

  public AppiumDriver<MobileElement> setupDriver(String platform, String url) throws IOException {

      switch (platform) {
        case "ios":
         localDriver = iosDriverSet(url);
         break;
        case "android":
          localDriver = androidDriverSet(url);
          break;
        default:
          Assert.fail("Platform is not supported");
          break;
      }
      return localDriver;
  }

  public AppiumDriver <MobileElement> androidDriverSet(String url) throws MalformedURLException {

    File file = new File(appLocalPath, androidAppName);
    System.out.println("file absolute path: " + file.getAbsoluteFile());
    //"Pixel_XL_Android_12"
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 31");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
    capabilities.setCapability(MobileCapabilityType.APP, file.getAbsoluteFile().toString());
    capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
//    capabilities.setCapability("androidInstallTimeout", 400000);
//    capabilities.setCapability("appium:uiautomator2ServerInstallTimeout", 120000);

    return new AndroidDriver<>(new URL(url), capabilities);
  }

  public AppiumDriver <MobileElement> iosDriverSet(String url) throws MalformedURLException {

    File myApp = new File(appLocalPath, iosAppName );
    System.out.print("FilePath iOS: " + myApp.getAbsoluteFile());

    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13");
    capabilities.setCapability(MobileCapabilityType.APP, myApp.getAbsoluteFile().toString());
    capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);

    return new IOSDriver<>(new URL(url), capabilities);
  }

  public static void startEmulator() throws IOException {
    File startFilePath = new File(startScriptPath, "startEmulator.sh");
    System.out.println(startFilePath.getAbsoluteFile());
    Runtime.getRuntime().exec(startFilePath.getAbsoluteFile().toString());
  }

  public static void startSimulator() throws IOException {
    File startFilePath = new File(startScriptPath, "startSimulator.sh");
    System.out.println(startFilePath.getAbsoluteFile());
    Runtime.getRuntime().exec(startFilePath.getAbsoluteFile().toString());
  }


  public AppiumDriverLocalService createOrKeepService() {
    if (isPortAvailableToUse(4723)) {
      System.out.println("Use me, already running");
    } else {
      service = AppiumDriverLocalService.buildDefaultService();
    //  service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).withArgument(() -> "--allow-insecure","chromedriver_autodownload"));
      service.start();
      System.out.println("Start and use me!");
    }
    return service;
  }

  private static boolean isPortAvailableToUse(int port) {
    System.out.println("--------------Testing port " + port);
    Socket socket = null;
    try {
      new Socket("localhost", port);

      // If the code makes it this far without an exception it means
      // something is using the port and has responded.
      System.out.println("--------------Port " + port + " is not available");
      return true;
    } catch (IOException e) {
      System.out.println("--------------Port " + port + " is available");
      return false;
    } finally {
      if( socket != null){
        try {
          socket.close();
        } catch (IOException e) {
           e.getStackTrace();
        }
      }
    }
  }
}
