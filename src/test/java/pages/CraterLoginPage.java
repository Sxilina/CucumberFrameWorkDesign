package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class CraterLoginPage {
	public CraterLoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//div[@name='email']/input")
	public WebElement useremail;
	
	@FindBy(xpath = "//div[@name='password']/input")
	public WebElement password;
	
	@FindBy(linkText="Fforgot Password?")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath="//button[text()='Login']")
	public WebElement LoginButton;
	
	@FindBy(xpath="//p[contains(text(),'Copyright @')]")
	public WebElement copyRightText;
	
	@FindBy(xpath="//h1[contains(text(), 'Simple Invoicing for')]")
	public WebElement businessTagLine;
	
	@FindBy(xpath="//p[contains(text(), 'Crater helps you track expense')]")
	public WebElement businessSubline;
	
	@FindBy(xpath="//p[contains(text(), 'These credentials do not match our record ")
	public WebElement invalidUserErrorMessage;
	
	@FindBy(xpath = "//span[text()='Field is required']")
	public WebElement fieldRequired;

	BrowserUtils utils;

	public void login() throws InterruptedException {
		utils = new BrowserUtils();
		utils.sendKeysWithActionsClass(useremail, TestDataReader.getProperty("craterValidUserEmail"));
		Thread.sleep(1000);
		utils.sendKeysWithActionsClass(password, TestDataReader.getProperty("craterValidUserPassword"));
		LoginButton.click();
		
}
}
