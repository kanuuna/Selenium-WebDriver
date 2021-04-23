package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testdata.TestDataHR;

public class HRPostSubmissionPage {
	
	public static WebElement submissionDate(WebDriver driver) {
		return driver.findElement(By.tagName("time"));
	}
	
	public static WebElement submissionAuthor(WebDriver driver) {
		return driver.findElement(By.linkText(TestDataHR.username));
	}
	
	public static WebElement submissionTitle(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}
	
	
}
