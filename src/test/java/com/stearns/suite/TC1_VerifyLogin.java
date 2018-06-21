package com.stearns.suite;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stearns.TestBase.BaseTest;
import com.stearns.pages.Login;
import com.stearns.util.Log1;

public class TC1_VerifyLogin extends BaseTest{
	public static BaseTest func;
	public static boolean Result = false;

	Login login = new Login(driver);
	String TestCaseName = "Verify Login";
	String TestCaseNameSheetName = "Sheet1";

	@BeforeTest
	public static void setUp() throws Exception {
		func = new BaseTest();
		func.fn_readProperties();
		func.fn_LoadBrowser();
		func.fn_maxWindow();
	}

	// validate Login Page
	@Test(description = "Test Stearns Url")
	public void Test_Stearns_Url() throws Exception {
		try {
			Assert.assertEquals(func.fn_GetTitle(), "DigitalRisk-Amplify");
		} catch (Exception e) {
			Log1.error("Test Stearns Url" + e);
		}
	}

	// test SuccessFull login
	@Test(description = "test SuccessFull login", dataProvider = "LoginUser")
	public void Test_Successfull_Login(String user, String pass){
		try {
			Login login = new Login(driver);
			login.setUserName(user);
			login.setPassword(pass);
			login.clickLogin();
			func.wait(4);
			Thread.sleep(20000);
			Assert.assertEquals(func.fn_GetTitle(), "AMPLIFY");
		} catch (Exception e) {
			Log1.error("Exception in Test_Successfull_Login " + e);
			Assert.fail();
		}
	}

	@DataProvider
	public Object[][] LoginUser(){

		return new Object[][] { { "sahil.singh", "Digital123" } };
	}
	
	 @AfterTest
	 public void afterTest(){
		 driver.close();
	 }

}
