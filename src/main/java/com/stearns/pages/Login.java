package com.stearns.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.stearns.TestBase.BaseTest;

public class Login extends BaseTest{
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(linkText="Log Out")
	WebElement logoutLink;
	
	@FindBy(xpath="//a[contains(.,'Loan Overview')]")
	WebElement LoanOverviewTab;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	
	//InputFieds
		public void setUserName(String user){
			waitForElement(driver, 10, userName);
			userName.sendKeys(user);
		}
		public void setPassword(String pass){
			waitForElement(driver, 10, password);
			password.sendKeys(pass);
		}
		public void clickLogin(){
			password.submit();
			waitForElement(driver,120, LoanOverviewTab);
		}
		public void login(String user,String pass){
			setUserName(user);
			setPassword(pass);
			clickLogin();
		}
		public void clickLogoutLink(){
			logoutLink.click();
		}
}
