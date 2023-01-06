package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.CraterDashBoardPage;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagementSteps {
	
	CraterLoginPage craterLogin = new CraterLoginPage();
	CraterDashBoardPage dashboard = new CraterDashBoardPage();
	BrowserUtils utils = new BrowserUtils();
	CraterCommonPage commonPage = new CraterCommonPage();
	
	//valid login
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		   Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));

	}
	@When("user enters valid {string} and {string}")
	public void user_enters_valid_user_name_and_password(String useremail, String password) {
	    // Write code here that turns the phrase above into concrete actions
	  utils.sendKeysWithActionsClass(craterLogin.useremail, useremail);
	  utils.sendKeysWithActionsClass(craterLogin.useremail, password);
	}
	
	
	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		craterLogin.LoginButton. click();
	
	}
	@Then("user should be on the dash-board page")
	public void user_should_be_on_the_dash_board_page() {
	    // Write code here that turns the phrase above into concrete actions
	    utils.waitUntilElementVisible(dashboard.amountDueText);
	    Assert.assertTrue(dashboard.amountDueText.isDisplayed());
	}

	@Then("user quits the browser")
	public void user_quits_the_browser() {
	   Driver.quitDriver();
	}
	
	
	// invalid login steps
	@When("user enters invalid {string} and {string}")
	public void user_enters_invalid_and(String invalidUseremail, String invalidPassword) {
		utils.sendKeysWithActionsClass(craterLogin.useremail, invalidUseremail);
		utils.sendKeysWithActionsClass(craterLogin.password, invalidPassword);
	}

	@Then("an error message appears")
	public void an_error_message_appears() {
	    utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
	    Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
	}

	@Then("user is not logged in")
	public void user_is_not_logged_in() {
		Assert.assertTrue(craterLogin.LoginButton.isDisplayed());
		Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
		
	}
	
	
	// invalid login scenario outline
	boolean useremailEmpty;
	boolean passwordEnpty;
	@When("user enters invalid useremail {string} and password {string}")
	public void user_enters_invalid_useremail_and_password(String invalidUseremail, String invalidPassword) {
		useremailEmpty = invalidUseremail.isBlank();
		passwordEnpty = invalidPassword.isBlank();
				
		utils.sendKeysWithActionsClass(craterLogin.useremail, invalidUseremail);
		utils.sendKeysWithActionsClass(craterLogin.password, invalidPassword);
	}
	
	@Then("error messages appear")
	public void error_messages_appear() {
	    if (useremailEmpty || passwordEnpty) {
	    	utils.waitUntilElementVisible(craterLogin.fieldRequired);
		    Assert.assertTrue(craterLogin.fieldRequired.isDisplayed());
		} else {
			utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
			Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
		}
	}
}
