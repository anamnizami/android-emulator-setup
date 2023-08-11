package com.egym.listeners;

import com.egym.util.Base;
import org.testng.*;


public class MobileTestListener implements ITestListener, ISuiteListener {

  @Override
  public void onStart(ISuite suite) {
    Reporter.log("Executing suite: " + suite.getName() + " with class: " + suite.getClass(), true);
  }

  @Override
  public void onFinish(ISuite suite) {
    Reporter.log("End execution of " + suite.getName() +"suite", true);
  }

  @Override
  public void onTestStart(ITestResult result) {
    Reporter.log("Executing test method: " + result.getMethod().getMethodName(), true);
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    Reporter.log(result.getMethod().getMethodName() + " -->  Passed");
    Reporter.log(result.getMethod().getMethodName() + " -->  Passed");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    Base.saveScreenshotPNG();
    Base.saveMessageLog(result.getMethod().getMethodName() + " failed with the attached screenshot");
    Reporter.log(result.getMethod().getMethodName() + " has failed");
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    Reporter.log(result.getMethod().getMethodName() + " has been skipped");
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    Reporter.log(result.getMethod().getMethodName() + " failed but passed with this percentage");
  }

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    Reporter.log(result + " failed with timeout");
  }

  @Override
  public void onStart(ITestContext context) {
    Reporter.log(context.getName() + " started with this context");
  }

  @Override
  public void onFinish(ITestContext context) {
    Reporter.log(context.getName() + " finished with this context");
  }

}
