package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class AmazonSearchPage {
	public AmazonSearchPage() {
	PageFactory.initElements(Driver.getDriver(), this);
}
	@FindBy (id = "twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy (id = "nav-search-submit-button")
	public WebElement searchButton;
	
	@FindBy (css = ".a-color-state")
	public WebElement searchResultPageText;

	
	
	
	
	
	
}