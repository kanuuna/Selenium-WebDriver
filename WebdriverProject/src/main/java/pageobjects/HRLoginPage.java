package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HRLoginPage {

	public static WebElement loginUsername(WebDriver driver) {
		return driver.findElement(By.id("user_login"));
	}
	
	public static WebElement loginPassword(WebDriver driver) {
		return driver.findElement(By.id("user_pass"));
	}
	
	public static WebElement loginButton(WebDriver driver) {
		return driver.findElement(By.id("wp-submit"));
	}
	
}
