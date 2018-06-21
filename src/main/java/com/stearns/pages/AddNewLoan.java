package com.stearns.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stearns.TestBase.BaseTest;

public class AddNewLoan extends BaseTest{
	
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(@class,'btn mx-button mx-name-actionButton1')]")
	WebElement addNewLoanButton;
	
	@FindBy(css=".mx-window-active .mx-name-textBox1 input")
	WebElement loanNumberField;
	
	@FindBy(xpath="//div[contains(@class,'mx-name-layoutGrid1')]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/input[1]")
	WebElement borrowerFirstNameField;
	
	@FindBy(xpath="//div[contains(@class,'mx-name-layoutGrid1')]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/div[1]/input[1]")
	WebElement borrowerLastNameField;
	
	@FindBy(xpath="//div[contains(@class,'mx-name-layoutGrid1')]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/div/select")
	WebElement selectState;
	
	@FindBy(xpath="//div[contains(@class,'mx-name-layoutGrid1')]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[2]/div[1]/div/select")
	WebElement selectLNProg;
	
	@FindBy(xpath="//div[contains(@class,'mx-name-layoutGrid1')]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[6]/td[2]/div[1]/div/div/div[2]/input")
	WebElement rcvdDt;
	
	@FindBy(xpath="//div[contains(@class,'mx-name-layoutGrid1')]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[2]/div[1]/div/div[1]/input")
	WebElement confClDt;
	
	@FindBy(xpath="//div[contains(@class,'mx-name-layoutGrid1')]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[8]/td[2]/div[1]/div/div[1]/input")
	WebElement lockExpDt;
	
	@FindBy(css = ".mx-window-active .mx-name-actionButton1")
	WebElement submitButton;
	
	@FindBy(xpath = "//div[contains(@class,'mx-grid mx-datagrid mx-name-grid41')]/div[2]/div[2]/button")
	WebElement searchButton;

	@FindBy(xpath= "//div[contains(@class,'mx-name-grid41')]/div/div[2]/div/div[2]/input[1]")
	WebElement loanNumberSeachField;
	
	@FindBy(xpath = "//div[contains(@class,'mx-grid mx-datagrid mx-name-grid41')]/div[1]/div[1]/button")
	WebElement searchButtonInSearch;
	
	@FindBy(xpath="//table[contains(@class,'table table-striped table-bordered mx-datagrid-body-table')]/tbody[1]/tr[1]/td[2]/div[1]")
	WebElement loanNumberSeached;
	
	public AddNewLoan(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void clickAddNewLoanButton() {
		waitForElement(driver, 10, addNewLoanButton);
		 addNewLoanButton.click();
	}

	public void setLoanNumberField(String loanNo) {
		try{
		Actions a = new Actions(driver);
		submitButton.click();
		a.moveToElement(loanNumberField).click().sendKeys(loanNo).build().perform();
		submitButton.click();
		}catch(Exception e){
			
		}
	}

	public void setBorrowerFirstNameField(String frstName) {
		 borrowerFirstNameField.sendKeys(frstName);
	}

	public void setSelectState(String index) {
		 fn_selectByIndex(selectState, 1);
	}

	public void setBorrowerLastNameField(String lastName) {
		 borrowerLastNameField.sendKeys(lastName);;
	}

	public void setRcvdDt(String rcvdDate) {
		 rcvdDt.sendKeys(rcvdDate);;
	}

	public void setConfClDt(String confDt) {
		 confClDt.sendKeys(confDt);;
	}
	
	public void setLockExp(String lockExpDt1) {
		lockExpDt.sendKeys(lockExpDt1);
	}

	public void clickSubmitButton() {
		lockExpDt.sendKeys(Keys.TAB);
		 submitButton.click();
	}


	public void clickSearchButton() {
		 searchButton.click();
	}


	public void setLoanNumberSeachField(String ln) {
		loanNumberSeachField.sendKeys(ln);
	}


	public void clickSearchButtonInSearch() {
		searchButtonInSearch.click();
	}


	public String getLoanNumberSeached() {
		return loanNumberSeached.getText();
	}
	
}
