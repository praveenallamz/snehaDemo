package utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.HashMap;
import java.util.Map;
/**
  * @Author Tarun
 * @Date 15-Jan-2019
 */ 
public class ExtentTestManager {
    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();
 
    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
 
    public static synchronized void endTest() {
        extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }
 
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
    public static synchronized void stepInfo(String stepName) {
    	  ExtentTestManager.getTest().log(LogStatus.INFO, stepName);
    }
    public static void stepSkip(String stepName) {
  	  ExtentTestManager.getTest().log(LogStatus.SKIP,stepName);
  }
    public static void stepPass(String stepName) {
  	  ExtentTestManager.getTest().log(LogStatus.PASS, stepName);
  }
    public static void stepFail(String stepName) {
  	  ExtentTestManager.getTest().log(LogStatus.FAIL, stepName);
  }
  public static void stepError(String stepName) {
	  ExtentTestManager.getTest().log(LogStatus.ERROR, stepName);
}
  public static void stepWarning(String stepName) {
	  ExtentTestManager.getTest().log(LogStatus.WARNING, stepName);
}
}
  