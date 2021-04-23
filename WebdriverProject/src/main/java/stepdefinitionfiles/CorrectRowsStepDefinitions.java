package stepdefinitionfiles;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverutilities.DriverUtilities;
import pageobjects.HRHomePage;
import pageobjects.HRLoginPage;
import pageobjects.HRPagesPage;
import testdata.TestDataHR;

public class CorrectRowsStepDefinitions {
	WebDriver driver;
	
	public CorrectRowsStepDefinitions(BaseStepDefinition baseStepDefinition) {
		this.driver = baseStepDefinition.driver;
	}
	
	@Given("^that the user is currently on the homepage$")
	public void that_the_user_is_currently_on_the_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(TestDataHR.loginUrl);
		HRLoginPage.loginUsername(driver).sendKeys(TestDataHR.username);
		HRLoginPage.loginPassword(driver).sendKeys(TestDataHR.password);
		HRLoginPage.loginButton(driver).click();
	}

	@When("^the user clicks the Pages link$")
	public void the_user_clicks_the_Pages_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HRHomePage.pagesLink(driver).click();
	}
	
	@Then("^the Pages page appears$")
	public void the_Pages_page_appears() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(TestDataHR.pagesPageHeading, HRPagesPage.pagesHeading(driver).getText());
	}

	@Then("^print the amount of rows in the table$")
	public void print_the_amount_of_rows_in_the_table() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement table = driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/table"));
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		int count = 0;
		for (WebElement row:tableRows) {
			count++;
		}
		System.out.println(count);
	}

	@Then("^print everything from the third row$")
	public void print_everything_from_the_third_row() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement table = driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/table"));
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		System.out.println(tableRows.get(2).getText());
	}

	@Then("^the user clicks the Published button$")
	public void the_user_clicks_the_Published_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		HRPagesPage.publishedLink(driver).click();
	}

	@Then("^print all titles of published pages$")
	public void print_all_titles_of_published_pages() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement publishedTable = driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/table"));
		List<WebElement> publishedTableRows = publishedTable.findElements(By.tagName("tr"));
		for (WebElement row:publishedTableRows) {
			List<WebElement> tableData = row.findElements(By.tagName("td"));
			
			if (tableData.size()>1) {
				System.out.println("\n" + tableData.get(0).getText());
			}
		}
		
	}


}
