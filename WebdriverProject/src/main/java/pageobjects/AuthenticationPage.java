package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AuthenticationPage {
	
	public static WebElement signInEmail(WebDriver driver) {
		return driver.findElement(By.id("email"));
	}
	
	public static WebElement signInPassword(WebDriver driver) {
		return driver.findElement(By.id("passwd"));
	}
	
	public static WebElement authenticationSignInButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
	
	}
	
	public static WebElement createAccountEmail(WebDriver driver) {
		return driver.findElement(By.id("email_create"));
	}
	
	public static WebElement createAccountButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
	}
	
}
