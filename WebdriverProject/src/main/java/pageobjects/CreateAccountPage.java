package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
	
	public static WebElement createAccountHeading(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}
	
	public static WebElement titleCheckbox(WebDriver driver) {
		return driver.findElement(By.id("id_gender1"));
	}
	
	public static WebElement firstNameField(WebDriver driver) {
		return driver.findElement(By.id("customer_firstname"));
	}
	
	public static WebElement lastNameField(WebDriver driver) {
		return driver.findElement(By.id("customer_lastname"));
	}
	
	public static WebElement emailField(WebDriver driver) {
		return driver.findElement(By.id("email"));
	}
	
	public static WebElement passwordField(WebDriver driver) {
		return driver.findElement(By.id("passwd"));
	}
	
	public static WebElement yourAddressFirstNameField(WebDriver driver) {
		return driver.findElement(By.id("firstname"));
	}
	
	public static WebElement yourAddressLastNameField(WebDriver driver) {
		return driver.findElement(By.id("lastname"));
	}
	
	public static WebElement addressField(WebDriver driver) {
		return driver.findElement(By.id("address1"));
	}
	
	public static WebElement cityField(WebDriver driver) {
		return driver.findElement(By.id("city"));
	}
	
	public static WebElement stateField(WebDriver driver) {
		return driver.findElement(By.id("id_state"));
	}
	
	public static WebElement postCodeField(WebDriver driver) {
		return driver.findElement(By.id("postcode"));
	}
	
	public static WebElement mobileNumberField(WebDriver driver) {
		return driver.findElement(By.id("phone_mobile"));
	}
	
	public static WebElement registerButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
	}
	
	
	
	
	
}
