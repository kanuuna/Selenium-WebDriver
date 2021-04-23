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
import java.util.ArrayList;
import java.util.List;

import driverutilities.DriverUtilities;
import testdata.TestDataHR;
import testdata.testData;
import pageobjects.HREditorPage;
import pageobjects.HRHomePage;
import pageobjects.HRLoginPage;
import pageobjects.HRPagesPage;
import pageobjects.HRPostSubmissionPage;
import pageobjects.HRPostsPage;
import pageobjects.HRToolsPage;



public class HRTC4 {
	
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
		//wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void wordingCheck() throws InterruptedException {
		
		
		//Step 1: Click on Pages link
		HRHomePage.pagesLink(driver).click();
		Assert.assertEquals(TestDataHR.pagesPageHeading, HRPagesPage.pagesHeading(driver).getText());
		
		//Step 2: Print the amount of rows
		WebElement table = driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/table"));
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		int count = 0;
		for (WebElement row:tableRows) {
			count++;
		}
		System.out.println(count);
		
		
		//Step 3: Print everything from the 3rd row
		System.out.println(tableRows.get(2).getText());
		
		
		//Step 4: Print titles
		HRPagesPage.publishedLink(driver).click();
		
		WebElement publishedTable = driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/table"));
		List<WebElement> publishedTableRows = publishedTable.findElements(By.tagName("tr"));
		
		for (WebElement row:publishedTableRows) {
			List<WebElement> tableData = row.findElements(By.tagName("td"));
			
			if (tableData.size()>1) {
				System.out.println("\n" + tableData.get(0).getText());
			}
		}
}
	
	@After 
	public void tearDown() {
		driver.quit();
	}

}
