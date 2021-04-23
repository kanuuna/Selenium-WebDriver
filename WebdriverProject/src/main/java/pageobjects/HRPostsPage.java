package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HRPostsPage {
	
	public static WebElement postsHeading(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}
	
	public static WebElement addNewButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[3]/a"));
	}
	
}
