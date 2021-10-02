package utils;
	 
import com.relevantcodes.extentreports.ExtentReports;

import controllers.BaseMethod;
/**
 * @Author Chandu
 * @Date 15-Nov-2018
 */	 
	//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
	 
	public class ExtentManager {
	 
	    private static ExtentReports extent;
	 
	    public synchronized static ExtentReports getReporter(){
	        if(extent == null){
	            //Set HTML reporting file location
	        	BaseMethod.HtmlReports =System.getProperty("user.dir")+"\\ExecutionReports\\HtmlReport\\HtmlReport_"+DateAndTime.getDate2()+"\\HtmlReports_"+DateAndTime.getTime()+".html";
	            extent = new ExtentReports( BaseMethod.HtmlReports, true); extent.assignProject("Draft Kings");
	           
	        }
	        return extent;
	    }
	
}
