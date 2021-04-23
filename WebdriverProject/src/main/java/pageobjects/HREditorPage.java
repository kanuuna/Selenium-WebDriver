package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HREditorPage {
	
	public static WebElement popupHeading(WebDriver driver) {
		return driver.findElement(By.className("edit-post-welcome-guide__heading"));
	}
	
	public static WebElement popupX(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/button"));
	}
	
	public static WebElement editorTitle(WebDriver driver) {
		return driver.findElement(By.id("post-title-0"));
	}
	
	public static WebElement publishButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"editor\"]/div[1]/div[1]/div[1]/div/div[2]/button[2]"));
		//return driver.findElement(By.linkText("Publish"));
	}
	
	public static WebElement secondPublishButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"editor\"]/div[1]/div[1]/div[2]/div[3]/div[3]/div/div/div[1]/div[1]/button"));
	}
	
	public static WebElement viewPostButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"editor\"]/div[1]/div[1]/div[2]/div[3]/div[3]/div/div/div[2]/div/div[2]/div[2]/a"));
	}
	
}
