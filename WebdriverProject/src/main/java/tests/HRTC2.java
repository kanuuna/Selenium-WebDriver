package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import driverutilities.DriverUtilities;
import testdata.TestDataHR;
import testdata.testData;
import pageobjects.HRHomePage;
import pageobjects.HRLoginPage;
import pageobjects.HRToolsPage;

public class HRTC2 {
	WebDriver driver;
	
	
	
	
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void wordingCheck() throws InterruptedException {
		Actions builder = new Actions(driver);
		
		
		//Step 1: Check that user is on the homepage. Hover over 'Tools' link and check options
		builder.moveToElement(HRHomePage.toolsLink(driver)).perform();
		Assert.assertEquals(TestDataHR.toolsOptionOne, HRHomePage.toolsLinkAvailable(driver).getText());
		Assert.assertEquals(TestDataHR.toolsOptionTwo, HRHomePage.toolsLinkImport(driver).getText());
		Assert.assertEquals(TestDataHR.toolsOptionThree, HRHomePage.toolsLinkExport(driver).getText());
		Assert.assertEquals(TestDataHR.toolsOptionFour, HRHomePage.toolsLinkSiteHealth(driver).getText());
		Assert.assertEquals(TestDataHR.toolsOptionFive, HRHomePage.toolsLinkExportData(driver).getText());
		Assert.assertEquals(TestDataHR.toolsOptionSix, HRHomePage.toolsLinkEraseData(driver).getText());
		
		//Step 2: Click Available Tools
		HRHomePage.toolsLinkAvailable(driver).click();
		Assert.assertEquals(TestDataHR.toolsPageHeading, HRToolsPage.toolsHeading(driver).getText());
		Assert.assertTrue(HRToolsPage.converterText(driver).getText().contains(TestDataHR.availableToolsParagraph));
	}
	
	@After 
	public void tearDown() {
		driver.quit();
	}
	
}
