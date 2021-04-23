package stepdefinitionfiles;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverutilities.DriverUtilities;
import pageobjects.HRHomePage;
import pageobjects.HRLoginPage;
import testdata.TestDataHR;

public class LoginStepDefinition {
	WebDriver driver;
	
	public LoginStepDefinition(BaseStepDefinition baseStepDefinition) {
		this.driver = baseStepDefinition.driver;
	}


	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(TestDataHR.loginUrl);
	}

	@When("^the user enters their username$")
	public void the_user_enters_their_username() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HRLoginPage.loginUsername(driver).sendKeys(TestDataHR.username);
	}

	@Then("^the username is entered correctly$")
	public void the_username_is_entered_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(TestDataHR.username, HRLoginPage.loginUsername(driver).getAttribute("value"));
	}

	@When("^the user enters their password$")
	public void the_user_enters_their_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HRLoginPage.loginPassword(driver).sendKeys(TestDataHR.password);
	}

	@Then("^the password is entered correctly$")
	public void the_password_is_entered_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(TestDataHR.password, HRLoginPage.loginPassword(driver).getAttribute("value"));
	}

	@When("^the user clicks the login button$")
	public void the_user_clicks_the_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HRLoginPage.loginButton(driver).click();
	}

	@Then("^the user is logged in succesfully$")
	public void the_user_is_logged_in_succesfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(TestDataHR.homePageHeading, HRHomePage.homePageHeading(driver).getText());
	}
	
	@When("^the links are shown$")
	public void the_links_are_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Runs");
	}
	

}
