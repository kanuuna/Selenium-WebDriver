package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driverutilities.DriverUtilities;
import pageobjects.AuthenticationPage;
import pageobjects.CreateAccountPage;
import pageobjects.HomePage;
import testdata.testData;

public class Registration {
	WebDriver driver;
	
	@Before						
	public void preConditions() { 			
		// The driver instantiation is moved to the preconditions
		// Doesn’t affect the outcome of the test so should be here
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver(); 
		driver.get(testData.mainUrl);
	}
	
	@Test
	public void registerUser() throws InterruptedException {
		
		//Step 1: Click Sign in button
		HomePage.signInButton(driver).click();
		Assert.assertEquals(testData.authenticationHeading, driver.findElement(By.tagName("h1")).getText());
		
		
		//Step 2: Enter an email address
		AuthenticationPage.createAccountEmail(driver).sendKeys(testData.registrationEmail);
		Assert.assertEquals(testData.registrationEmail, AuthenticationPage.createAccountEmail(driver).getAttribute("value"));
		
		
		//Step 3: Click Create an Account
		AuthenticationPage.createAccountButton(driver).click();
		Thread.sleep(15000);
		Assert.assertEquals(testData.createAccountHeading, CreateAccountPage.createAccountHeading(driver).getText());
		
		
		//Step 4: Select a checkbox for title
		CreateAccountPage.titleCheckbox(driver).click();
		Thread.sleep(15000);
		Assert.assertTrue(CreateAccountPage.titleCheckbox(driver).isSelected());
		
		
		//Step 5: Enter first name in First name field
		CreateAccountPage.firstNameField(driver).sendKeys(testData.firstName);
		Assert.assertEquals(testData.firstName, CreateAccountPage.firstNameField(driver).getAttribute("value"));
		
		
		//Step 6: Enter last name in Last name field. Check email field.
		CreateAccountPage.lastNameField(driver).sendKeys(testData.lastName);
		Thread.sleep(2000);
		Assert.assertEquals(testData.lastName, CreateAccountPage.lastNameField(driver).getAttribute("value"));
		Assert.assertEquals(testData.registrationEmail, CreateAccountPage.emailField(driver).getAttribute("value"));
		
		
		//Step 7: Enter password
		CreateAccountPage.passwordField(driver).sendKeys(testData.password);
		Thread.sleep(2000);
		Assert.assertEquals(testData.password, CreateAccountPage.passwordField(driver).getAttribute("value"));
		
		
		//Step 8: Enter address
		CreateAccountPage.addressField(driver).sendKeys(testData.address);
		Thread.sleep(2000);
		Assert.assertEquals(testData.address, CreateAccountPage.addressField(driver).getAttribute("value"));
		
		
		//Step 9: Enter city
		CreateAccountPage.cityField(driver).sendKeys(testData.city);
		Thread.sleep(2000);
		Assert.assertEquals(testData.city, CreateAccountPage.cityField(driver).getAttribute("value"));
		
		
		//Step 10: Enter a state
		WebElement questionField = CreateAccountPage.stateField(driver);
		Select stateSelect = new Select(questionField);
		stateSelect.selectByVisibleText(testData.state);
		Assert.assertEquals(testData.state, CreateAccountPage.stateField(driver).getAttribute("value"));
	
		
		//Step 11: Enter Post code
		CreateAccountPage.postCodeField(driver).sendKeys(testData.postCode);
		Assert.assertEquals(testData.postCode, CreateAccountPage.postCodeField(driver).getAttribute("value"));
		
		
		//Step 12:
		CreateAccountPage.mobileNumberField(driver).sendKeys(testData.mobileNumber);
		Assert.assertEquals(testData.mobileNumber, CreateAccountPage.mobileNumberField(driver).getAttribute("value"));
		
	}
	
	
	@After
	public void tearDow() {
		//Closes down browser 
		//driver.quit();
	}
	
	
	
}
