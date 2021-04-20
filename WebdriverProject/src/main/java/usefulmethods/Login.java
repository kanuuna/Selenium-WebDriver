package usefulmethods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjects.HomePage;
import testdata.testData;

public class Login {
	
	
public static void successlogin(WebDriver driver) {
		
		//Finding and clicking the Sign in button
		HomePage.signInButton(driver).click();
		
		//Expected results: 
		//Checks that we end up in the right URL
		Assert.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());
		//Checks that page contains Authentication heading
		Assert.assertEquals(testData.authenticationHeading, driver.findElement(By.tagName("h1")).getText());
		
		
		//Signing in to the site: Find email address element (use inspect, find element
		//id. Input username into field
		HomePage.signInEmail(driver).sendKeys(testData.email);
		//Adding expected result: If we have entered text, we must use the getAttribute
		//Method
		Assert.assertEquals(testData.email, driver.findElement(By.id("email")).getAttribute("value"));
		
		
		//We can also use the name attribute to find element
		HomePage.signInPassword(driver).sendKeys(testData.password);
		//Expected result
		Assert.assertEquals(testData.password, driver.findElement(By.id("passwd")).getAttribute("value"));
		
		
		//We can also find an element using xpath
		HomePage.authenticationSignInButton(driver).click();
		//Expected result: Check that search bar is displayed
		Assert.assertTrue(driver.findElement(By.id("search_query_top")).isDisplayed());
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).isDisplayed());
	}

}
