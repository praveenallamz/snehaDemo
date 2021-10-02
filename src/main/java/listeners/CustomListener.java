package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;


import controllers.WebDriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

import controllers.BaseMethod;
import utils.LogUtil;
import utils.ExtentManager;
import utils.ExtentTestManager;


/**
 * @Author Tarun
 * @Date 15-Jan-2019
 */

public class CustomListener extends WebDriverFactory implements ITestListener, ISuiteListener, IInvokedMethodListener
{

	
	private String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    	
    	LogUtil.infoLog(getClass(), iTestContext.getName());
        //System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.getWebDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
        if(!(getWebDriver()==null)){
        	getWebDriver().quit();
        }
      
       // String htmlReportFile = System.getProperty("user.dir") +  ConfigReader.getValue("HtmlReportFullPath");
		File f = new File(BaseMethod.HtmlReports);
		if (f.exists()) {

			try {
				Runtime.getRuntime()
						.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe \"" + BaseMethod.HtmlReports
								+ "\"");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    	LogUtil.infoLog(getClass(), "Testcase started: "+getTestMethodName(iTestResult) );
        
      //  System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
        
        
        
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    	try {
    		String caseId = getTestMethodName(iTestResult).substring(1);
    		// System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
    		//Extentreports log operation for passed tests.
    		ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed : "+iTestResult.getMethod().getMethodName());
    		ExtentTestManager.getTest().setEndedTime(new Date());
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	//getWebDriver().close();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
    	  try {
    		  //String testName = getTestMethodName(iTestResult).split("_")[1].trim();
    	String caseId = getTestMethodName(iTestResult).substring(1);
		
    	 ExtentTestManager.getTest().setEndedTime(new Date());
    	//String testName = scenario.getName().split("_")[0].trim();
      //  System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");

        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseMethod) testClass).getWebDriver();

        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);

        //Extentreports log and screenshot operations for failed tests.

        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed : "+iTestResult.getMethod().getMethodName(),
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
        
        String path = null;

			//updating the results in Testmangement tool

			 getWebDriver().close();
		} catch (Exception e) {
			e.printStackTrace();
		}    
        
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
       // System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
    	  try {
    		  String caseId = getTestMethodName(iTestResult).substring(1);
    	 
		 ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");

        getWebDriver().close();
    	  }catch(Exception e) {
  			e.printStackTrace();
  			}

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}


}
