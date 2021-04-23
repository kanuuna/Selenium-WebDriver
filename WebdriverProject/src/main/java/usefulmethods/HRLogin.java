package usefulmethods;

import org.openqa.selenium.WebDriver;

import driverutilities.DriverUtilities;

public class HRLogin {

	
	
public static void hrLogin() {
	WebDriver driver;
	
	DriverUtilities myDriverUtilities = new DriverUtilities();
	driver = myDriverUtilities.getDriver(); 
	driver.manage().window().maximize();
	
	
}
	
}
