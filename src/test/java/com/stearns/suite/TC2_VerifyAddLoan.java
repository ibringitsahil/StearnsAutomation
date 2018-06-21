package com.stearns.suite;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Functions;
import com.relevantcodes.extentreports.LogStatus;
import com.stearns.TestBase.BaseTest;
import com.stearns.pages.AddNewLoan;
import com.stearns.pages.Login;
import com.stearns.util.Log1;
import com.sun.glass.ui.Pixels.Format;

import sun.util.resources.cldr.aa.CalendarData_aa_ER;

public class TC2_VerifyAddLoan extends BaseTest {
	BaseTest func;
	Login login; 
	AddNewLoan addNewLoan;
	Random random = new Random();
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");

	@BeforeTest
	public void setUp() throws Exception{
		func = new BaseTest();
		func.fn_readProperties();
		func.fn_LoadBrowser();
		func.fn_maxWindow();
	}
	
	@Test(priority=0,enabled=true)
	public void VerifyAddLoan(){
		String ln = "865432" + random.nextInt(900);
		addNewLoan = new AddNewLoan(driver);
		login = new Login(driver);
		try{
		extentTest.log(LogStatus.INFO,"**************Starting VerifyAddLoan*****************");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login.login("Himanshu.Pareek", "Digital123");
		addNewLoan.clickAddNewLoanButton();
		Thread.sleep(4000);
		addNewLoan.setLoanNumberField(ln);
		Thread.sleep(1000);
		addNewLoan.setBorrowerFirstNameField("Test");
	
		addNewLoan.setBorrowerLastNameField("Test");

		addNewLoan.setSelectState("1");
/*		addNewLoan.setConfClDt(dateFormat.format(calendar.getTime()));
		Thread.sleep(1000);
		addNewLoan.setLockExp(dateFormat.format(calendar.getTime()));*/
		Thread.sleep(1000);
		addNewLoan.clickSubmitButton();
		Thread.sleep(2000);
		addNewLoan.clickSearchButton();
		Thread.sleep(1000);
		addNewLoan.setLoanNumberSeachField(ln);
		Thread.sleep(1000);
		addNewLoan.clickSearchButtonInSearch();
		Thread.sleep(2000);
		Assert.assertEquals(addNewLoan.getLoanNumberSeached(), ln);
        
		extentTest.log(LogStatus.INFO,"**************Ending VerifyAddLoan****************");
		}catch(Exception e){
 			Assert.fail();
 			System.out.println(e);
			extentTest.log(LogStatus.INFO,"Exception in VerifyAddLoan" + e);
		}		
	}
}
