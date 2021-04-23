package tests;


//We need to import the @before,@test and @after modules, and webdriver module
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverutilities.DriverUtilities;
import pageobjects.HomePage;
import testdata.testData;

public class Login {
	WebDriver driver; // This needs to be at the class level else you can’t use it 	in the methods below

	@Before						
	public void preConditions() { 			
		// The driver instantiation is moved to the preconditions
		// Doesn’t affect the outcome of the test so should be here
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver(); 
		
		//Maximises the screen
		driver.manage().window().maximize();
		
		driver.get(testData.mainUrl);
		// Add code to check if user is registered
	}
	
	//Need to have the @test tag to get option to run as JUnit test. We can have 
	//multiple @Tests, which run sequentially
	@Test
	public void login() {
		
		//Finding and clicking the Sign in button
		HomePage.signInButton(driver).click();
		
		//Expected results: 
		//Checks that we end up in the right URL
		Assert.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());
		//Checks that page contains Authentication heading
		Assert.assertEquals(testData.authenticationHeading, driver.findElement(By.tagName("h1")).getText());
		
		
		//Signing in to the site: Find email address element (use inspect, find element
		//id. Input username into field
		HomePage.signInEmail(driver).sendKeys(testData.email);
		//Adding expected result: If we have entered text, we must use the getAttribute
		//Method
		Assert.assertEquals(testData.email, driver.findElement(By.id("email")).getAttribute("value"));
		
		
		//We can also use the name attribute to find element
		HomePage.signInPassword(driver).sendKeys(testData.password);
		//Expected result
		Assert.assertEquals(testData.password, driver.findElement(By.id("passwd")).getAttribute("value"));
		
		
		//We can also find an element using xpath
		HomePage.authenticationSignInButton(driver).click();
		//Expected result: Check that search bar is displayed
		Assert.assertTrue(driver.findElement(By.id("search_query_top")).isDisplayed());
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).isDisplayed());
	}
	
	//What to do after test completion
	@After
	public void tearDow() {
		
		//Closes down browser 
		//driver.quit();
		
		
	}
	
	
}
