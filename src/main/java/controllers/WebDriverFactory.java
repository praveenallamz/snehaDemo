/**
 * 
 */
package controllers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.ConfigReader;
import utils.LogUtil;

import java.util.concurrent.TimeUnit;

/**
 * @Author Tarun
 
 */
public class WebDriverFactory extends BrowserFactory
{
	public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();

	/*@Parameters({ "browser" , "url" })
	@BeforeMethod
	public void beforeMethod(String browser, String url) throws Exception
	{		
		//InitMethod.Browser=browser;
		//InitMethod.WebsiteURL=url;
		InitMethod.Browser=ConfigReader.getValue("Browser");
		InitMethod.WebsiteURL=ConfigReader.getValue("BASE_URL");
		//System.out.println("Browser: "+browser);
		//System.out.println("WebsiteURL: "+url);
		new WebDriverFactory();
		WebDriver driver = WebDriverFactory.createDriver(browser,url);
		setWebDriver(driver);
	}*/
	
		@BeforeMethod
		public void beforeMethod() throws Exception
		{		
			InitMethod.Browser=ConfigReader.getValue("Browser");
			InitMethod.WebsiteURL=ConfigReader.getValue("BASE_URL");
			LogUtil.infoLog(getClass(), "Browser: "+Browser+"  URL: "+WebsiteURL);
			//System.out.println("Browser: "+browser);
			//System.out.println("WebsiteURL: "+url);
			new WebDriverFactory();
			WebDriver driver = WebDriverFactory.createDriver(Browser,WebsiteURL);
			setWebDriver(driver);
			driver.manage().deleteAllCookies();
			System.out.println("DELETING ALL COOKIES");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	public void setWebDriver(WebDriver driver) 
	{
		wd.set(driver);
	}

	/*public static WebDriver getWebDriver() 
	{
		return wd.get();
	}*/
	public WebDriver getWebDriver() 
	{
		return wd.get();
	}


	@AfterMethod
	public void afterMethod() throws Exception
	{
		Thread.sleep(2000);
		getWebDriver().quit();	
	}


}
