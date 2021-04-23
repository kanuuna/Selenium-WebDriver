package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HRHomePage {
	
	public static WebElement toolsLink(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/a/div[3]"));
	}
	
	public static WebElement toolsLinkAvailable(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/ul/li[2]/a"));
	}
	
	public static WebElement toolsLinkImport(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/ul/li[3]/a"));
	}
	
	public static WebElement toolsLinkExport(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/ul/li[4]/a"));
	}
	
	public static WebElement toolsLinkSiteHealth(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/ul/li[5]/a"));
	}
	
	public static WebElement toolsLinkExportData(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/ul/li[6]/a"));
	}
	
	public static WebElement toolsLinkEraseData(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-tools\"]/ul/li[7]/a"));
	}
	
	public static WebElement postsLink(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]"));
	}
	
	public static WebElement pagesLink(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"menu-pages\"]/a/div[3]"));
	}
	
	public static WebElement homePageHeading(WebDriver driver) {
		return driver.findElement(By.tagName("h1"));
	}
	
}
