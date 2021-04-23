package stepdefinitionfiles;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverutilities.DriverUtilities;
import pageobjects.HRHomePage;
import pageobjects.HRLoginPage;
import pageobjects.HRToolsPage;
import testdata.TestDataHR;

public class ToolsHeadingsStepDefinitions {
	WebDriver driver;
	
	public ToolsHeadingsStepDefinitions(BaseStepDefinition baseStepDefinition) {
		this.driver = baseStepDefinition.driver;
	}
	
	@Given("^that the user is on the homepage$")
	public void that_the_user_is_on_the_homepage() throws Throwable {
		driver.get(TestDataHR.loginUrl);
		HRLoginPage.loginUsername(driver).sendKeys(TestDataHR.username);
		HRLoginPage.loginPassword(driver).sendKeys(TestDataHR.password);
		HRLoginPage.loginButton(driver).click();
	}
	
	
	@When("^the user hovers over the Tools link$")
	public void the_user_hovers_over_the_Tools_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Actions builder = new Actions(driver);
		builder.moveToElement(HRHomePage.toolsLink(driver)).perform();
	}

	
	@Then("^the correct options are displayed$")
	public void the_correct_options_are_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Available Tools", HRHomePage.toolsLinkAvailable(driver).getText());
		Assert.assertEquals("Import", HRHomePage.toolsLinkImport(driver).getText());
		Assert.assertEquals("Export", HRHomePage.toolsLinkExport(driver).getText());
		Assert.assertEquals("Site Health", HRHomePage.toolsLinkSiteHealth(driver).getText());
		Assert.assertEquals("Export Personal Data", HRHomePage.toolsLinkExportData(driver).getText());
		Assert.assertEquals("Erase Personal Data", HRHomePage.toolsLinkEraseData(driver).getText());
	}

	@When("^the user clicks the available tools button$")
	public void the_user_clicks_the_available_tools_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HRHomePage.toolsLinkAvailable(driver).click();
	}

	@Then("^the user is taken to the Tools page$")
	public void the_user_is_taken_to_the_Tools_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(TestDataHR.toolsPageHeading, HRToolsPage.toolsHeading(driver).getText());
	}

	
	@Then("^the displayed paragraph contains vice versa$")
	public void the_displayed_paragraph_contains_vice_versa() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(HRToolsPage.converterText(driver).getText().contains("vice versa"));
	}

	
}

