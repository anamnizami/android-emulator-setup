package com.egym.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;


public class DeviceFarmDriverSetupUtil {

  public static AppiumDriver<MobileElement> setUpAppium(String platform, String url) throws IOException {

    DesiredCapabilities capabilities = new DesiredCapabilities();

    if (platform.equals("Android"))  {
      return new AndroidDriver<>(new URL(url), capabilities);
    } else {
      return new IOSDriver<>(new URL(url), capabilities);
    }
  }
}
