package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HRToolsPage {
	public static WebElement converterText(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[3]/div/p"));
	}
	
	public static WebElement toolsHeading(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}
	
}
