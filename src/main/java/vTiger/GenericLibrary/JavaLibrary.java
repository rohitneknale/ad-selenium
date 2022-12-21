package vTiger.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This method will contain all the generic method related to java
 * @author admin
 *
 */

public class JavaLibrary {

		/**
		 * this method will generate random number for every execution
		 * @return 
		 */
		public int getRandomNumber()
		{
			Random ran = new Random();
			int value = ran.nextInt(1000);
			return value;
		}
	
		/**
		 * This method will generate System date
		 * @return
		 */
		public String getSystemDate()
		{
			Date d=new Date();
			String Date= d.toString();
			return Date;
		}
		
		/**
		 * This method will generate System date in a specific format
		 * @return 
		 */
		public String getSystemDateInFormat()
		{
			Date d = new Date();
			String[] dArr = d.toString().split(" ");
			String month = dArr[1];
			String date = dArr[2];
			String year = dArr[5];
			String time = dArr[3];
			
			String dateInFormat = date+"-"+month+"-"+year+"-"+time;
			return dateInFormat;
		}
}
