package stepdefinitionfiles;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverutilities.DriverUtilities;
import pageobjects.HREditorPage;
import pageobjects.HRHomePage;
import pageobjects.HRLoginPage;
import pageobjects.HRPostSubmissionPage;
import pageobjects.HRPostsPage;
import testdata.TestDataHR;

public class AddFileStepDefinitions {
	WebDriver driver;
	WebDriverWait wait;
	
	public AddFileStepDefinitions(BaseStepDefinition baseStepDefinition) {
		this.driver = baseStepDefinition.driver;
	}

	
	
	@Given("^that the user is logged in on the homepage$")
	public void that_the_user_is_logged_in_on_the_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(TestDataHR.loginUrl);
		HRLoginPage.loginUsername(driver).sendKeys(TestDataHR.username);
		HRLoginPage.loginPassword(driver).sendKeys(TestDataHR.password);
		HRLoginPage.loginButton(driver).click();
		wait = new WebDriverWait(driver, 20);
	}

	@When("^the user clicks the Posts link$")
	public void the_user_clicks_the_Posts_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HRHomePage.postsLink(driver).click();
	}

	@Then("^the Posts page appears$")
	public void the_Posts_page_appears() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(TestDataHR.postsPageHeading, HRPostsPage.postsHeading(driver).getText());
	}

	@When("^the user clicks the Add New button$")
	public void the_user_clicks_the_Add_New_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HRPostsPage.addNewButton(driver).click();
	}

	@Then("^the user is shown a welcome popup$")
	public void the_user_is_shown_a_welcome_popup() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.textToBe(By.className("edit-post-welcome-guide__heading"), TestDataHR.popupHeading));
		Assert.assertEquals(TestDataHR.popupHeading, HREditorPage.popupHeading(driver).getText());
	}

	@When("^the user clicks the X button$")
	public void the_user_clicks_the_X_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HREditorPage.popupX(driver).click();
	}

	@Then("^the popup disappears$")
	public void the_popup_disappears() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertFalse(driver.findElement(By.tagName("h1")).getText() == TestDataHR.popupHeading);
	}

	@Then("^the Publish button is disabled$")
	public void the_Publish_button_is_disabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("true", HREditorPage.publishButton(driver).getAttribute("aria-disabled"));
	}

	@When("^the user enters text in the \"([^\"]*)\"$")
	public void the_user_enters_text_in_the(String title) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HREditorPage.editorTitle(driver).sendKeys(title);
	}


	@Then("^the publish button is enabled$")
	public void the_publish_button_is_enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.elementToBeClickable(HREditorPage.publishButton(driver)));
		Assert.assertEquals("false", HREditorPage.publishButton(driver).getAttribute("aria-disabled"));
	}

	@When("^the user clicks the publish button$")
	public void the_user_clicks_the_publish_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HREditorPage.publishButton(driver).click();
	}

	@Then("^a second Publish button appears$")
	public void a_second_Publish_button_appears() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(HREditorPage.secondPublishButton(driver).isEnabled());
	}

	@When("^the user clicks the second button$")
	public void the_user_clicks_the_second_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HREditorPage.secondPublishButton(driver).click();
	}

	@Then("^a View Post link appears$")
	public void a_View_Post_link_appears() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"editor\"]/div[1]/div[1]/div[2]/div[3]/div[3]/div/div/div[2]/div/div[2]/div[2]/a")));
		Assert.assertTrue(HREditorPage.viewPostButton(driver).isDisplayed()); 
	}

	@When("^the user clicks the View Post link$")
	public void the_user_clicks_the_View_Post_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HREditorPage.viewPostButton(driver).click();
	}

	@Then("^a page that contains the current date$")
	public void a_page_that_contains_the_current_date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(HRPostSubmissionPage.submissionDate(driver).getAttribute("datetime").contains(TestDataHR.dateString));
	}

	@Then("^username$")
	public void username() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(TestDataHR.username, HRPostSubmissionPage.submissionAuthor(driver).getText());
	}

	@Then("^the \"([^\"]*)\" of the post$")
	public void the_of_the_post(String title) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(title, HRPostSubmissionPage.submissionTitle(driver).getText());
	}
	
}
