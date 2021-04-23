package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HRPagesPage {
	
	public static WebElement pagesHeading(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}
	
	public static WebElement publishedLink(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[3]/ul/li[2]/a"));
	}
}
