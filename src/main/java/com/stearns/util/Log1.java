package com.stearns.util;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.stearns.TestBase.BaseTest;

public class Log1 extends BaseTest {


		// Initialize Log4j logs
		private static Logger Log = Logger.getLogger(Log1.class);
	
		// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
		public static void startTestCase(String sTestCaseName){
			Log.info("****************************************************************************************");
			Log.info("****************************************************************************************");
			Log.info("$$$$$$$$$$$$$$$$$$$$$ "+sTestCaseName+ " $$$$$$$$$$$$$$$$$$$$$$$$$");
			Log.info("****************************************************************************************");
			Log.info("****************************************************************************************");
		}
		//This is to print log for the ending of the test case
		public static void endTestCase(String sTestCaseName){
			Log.info("XXXXXXXXXXXXXXXXXXXXXXX "+"-E---N---D-"+" XXXXXXXXXXXXXXXXXXXXXX");
			Log.info("X");
			Log.info("X");
			Log.info("X");
			Log.info("X");
		}
		// Need to create these methods, so that they can be called 
		public static  void info(String message) {
			Log.info(message);
		}


		public static void warn(String message) {
			Log.warn(message);
		}
		public static void error(String message) {
			Log.error(message);
		}
		public static void fatal(String message) {
			Log.fatal(message);
		}
		public static void debug(String message) {
			Log.debug(message);
		}
	


}
