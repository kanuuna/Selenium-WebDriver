package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	//Method that returns the specified element
	public static WebElement signInButton(WebDriver driver) {
		return driver.findElement(By.linkText("Sign in"));
	}
	
	public static WebElement signInEmail(WebDriver driver) {
		return driver.findElement(By.id("email"));
	}
	
	public static WebElement signInPassword(WebDriver driver) {
		return driver.findElement(By.id("passwd"));
	}
	
	public static WebElement authenticationSignInButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
	
	}
}
