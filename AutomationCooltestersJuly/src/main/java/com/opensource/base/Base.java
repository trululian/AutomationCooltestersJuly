package com.opensource.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Base {

	private WebDriver driver;

	/*
	 * Constructor
	 * 
	 * @Author Julian Pardo
	 */

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Reporter method
	 * 
	 * @Author Julian Pardo
	 */

	public void Reporter(String log) {
		Reporter.log(log);
	}

	/*
	 * Set Web Driver method
	 * 
	 * @Author Julian Pardo
	 */
	public WebDriver chromeDriver() {
		System.setProperty(GlobalVariables.CHROME_DRIVER_KEY, GlobalVariables.CHROME_DRIVER_NAME);
		driver = new ChromeDriver();
		return driver;
	}

	/*
	 * Implicity wait
	 * 
	 * @Author Julian Pardo
	 */

	public void implicityWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * Implicity wait (overloading)
	 * 
	 * @Author Julian Pardo
	 */

	public void implicityWait() {
		try {
			driver.manage().timeouts().implicitlyWait(GlobalVariables.GENERAL_IMPLICITY_TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Wait for Element present(sync)
	 * 
	 * @Author Julian Pardo
	 */

	public void waitForElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.GENERAL_TIMEOUT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Wait for Element present(sync)(overloading)
	 * 
	 * @Author Julian Pardo
	 */

	public void waitForElementPresent(By locator, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Lunch browser method
	 */
	
	public void lunchBrowser (String url) {
		Reporter("Lunch Browser: "+url);
		driver.get(url);
		driver.manage().window().maximize();
		implicityWait();
	}
	
	/*
	 * (Send Keys) Type method
	 */
	
	public void type (By locator, String inputText) {
		try {
			driver.findElement(locator).sendKeys(inputText);	
		} catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
	}
	
	/*
	 * click method
	 */
	
	public void click (By locator) {
		try {
			driver.findElement(locator).click();	
		} catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
	}
	
	/*
	 * is Displayed method
	 */
	
	public boolean isDisplayed (By locator) {
		try {
			driver.findElement(locator).isDisplayed();
			return true;
		} catch(NoSuchElementException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	/*
	 * Get text method
	 */
	public String getText (By locator) {
		try {
			return driver.findElement(locator).getText();
			 
		} catch(NoSuchElementException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	/*
	 * Hard Assert Method(String)
	 */
	
	public void assertequalsBase(String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(actualValue,expectedValue);
		}catch(AssertionError e) {
			Assert.fail(e.getMessage() + " /n Actual value: "+actualValue+ " does not match with expected value: "+expectedValue );
		}
	}
	
	public void CloseBrowser () {
		driver.close();
	}
}
