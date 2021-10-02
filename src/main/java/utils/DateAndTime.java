/**
 * 
 */
package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Author Tarun
 * @Date 15-Jan-2019
 */
public class DateAndTime 
{
	/*	To get the Current Time */
	public static String getTime()  
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("kk.mm");
		String TimeNow = dateFormat.format(date);
		return TimeNow;
	}

	/*	To get the Current Date */
	public static String getDate()  
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String DateNow = dateFormat.format(date);
		return DateNow;
	}
	/*	To get the Current Date */
	public static String getDate2()  
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		String DateNow = dateFormat.format(date);
		return DateNow;
	}
	
}
