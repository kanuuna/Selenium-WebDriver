package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import driverutilities.DriverUtilities;

public class OpenGoogle {
	WebDriver driver; // This needs to be at the class level else you can’t use it 	in the methods below

	@Before						
	public void preConditions() { 			
		// The driver instantiation is moved to the preconditions
		// Doesn’t affect the outcome of the test so should be here
		DriverUtilities myDriverUtilities = new DriverUtilities();
		driver = myDriverUtilities.getDriver(); 	

		// Add code to check if user is registered
	}
	
	@Test
	public void openGoogle() {
		driver.get("http://www.google.co.uk");
	}
}
