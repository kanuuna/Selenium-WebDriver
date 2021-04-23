package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverutilities.DriverUtilities;
import testdata.TestDataHR;
import testdata.testData;
import pageobjects.HREditorPage;
import pageobjects.HRHomePage;
import pageobjects.HRLoginPage;
import pageobjects.HRPostSubmissionPage;
import pageobjects.HRPostsPage;
import pageobjects.HRToolsPage;

public class HRTC3 {
	WebDriver driver;
	WebDriverWait wait;
	
	
	
	@Before						
	public void preConditions() { 			
		// The driver instantiation is moved to the preconditions
		// Doesn’t affect the outcome of the test so should be here
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver(); 
		driver.get(TestDataHR.loginUrl);
		driver.manage().window().maximize();
		HRLoginPage.loginUsername(driver).sendKeys(TestDataHR.username);
		HRLoginPage.loginPassword(driver).sendKeys(TestDataHR.password);
		HRLoginPage.loginButton(driver).click();
		wait = new WebDriverWait(driver, 20);
	}
	
	@Test
	public void wordingCheck() throws InterruptedException {
		Actions builder = new Actions(driver);
		
		//Step 1: Click on Posts link
		HRHomePage.postsLink(driver).click();
		Assert.assertEquals(TestDataHR.postsPageHeading, HRPostsPage.postsHeading(driver).getText());
		
		
		//Step 2: Click Add New button
		HRPostsPage.addNewButton(driver).click();
		wait.until(ExpectedConditions.textToBe(By.className("edit-post-welcome-guide__heading"), "Welcome to the block editor"));
		Assert.assertEquals(TestDataHR.popupHeading, HREditorPage.popupHeading(driver).getText());
		
		
		
		//Step 3: Click X button
		HREditorPage.popupX(driver).click();
		Assert.assertFalse(driver.findElement(By.tagName("h1")).getText() == TestDataHR.popupHeading);
		Assert.assertEquals("true", HREditorPage.publishButton(driver).getAttribute(TestDataHR.publishDisabledAttribute));
		
		
		
		//Step 4: Enter text in the title field
		HREditorPage.editorTitle(driver).sendKeys(TestDataHR.createTitle);
		wait.until(ExpectedConditions.elementToBeClickable(HREditorPage.publishButton(driver)));
		Assert.assertEquals("false", HREditorPage.publishButton(driver).getAttribute(TestDataHR.publishDisabledAttribute));
		
		
		
		//Step 5: Click the Publish button
		HREditorPage.publishButton(driver).click();
		Assert.assertTrue(HREditorPage.secondPublishButton(driver).isEnabled());
		
		
		//Step 6: Click the second Publish button
		HREditorPage.secondPublishButton(driver).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"editor\"]/div[1]/div[1]/div[2]/div[3]/div[3]/div/div/div[2]/div/div[2]/div[2]/a")));
		Assert.assertTrue(HREditorPage.viewPostButton(driver).isDisplayed());    //
		
		
		//Step 7: Click View Post link
		HREditorPage.viewPostButton(driver).click();
		Assert.assertEquals(TestDataHR.createTitle, HRPostSubmissionPage.submissionTitle(driver).getText());
		Assert.assertEquals(TestDataHR.username, HRPostSubmissionPage.submissionAuthor(driver).getText());
		Assert.assertTrue(HRPostSubmissionPage.submissionDate(driver).getAttribute("datetime").contains(TestDataHR.dateString));
		
		
	}
	
	@After 
	public void tearDown() {
		driver.quit();
	}
	
	
}


