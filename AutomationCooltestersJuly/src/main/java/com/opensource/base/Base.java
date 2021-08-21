package com.opensource.base;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

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
			System.out.println("Element present");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Wait x seconds
	 * 
	 * @Author Julian Pardo
	 */

	public void waitTimeInSconds(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Lunch browser method
	 */

	public void lunchBrowser(String url) {
		implicityWait();
		Reporter(GlobalVariables.LUNCH_BROWSER_DESC + url);
		driver.get(url);
		driver.manage().window().maximize();
		implicityWait();
	}

	/*
	 * (Send Keys) Type method
	 */

	public void type(By locator, String inputText) {
		try {
			driver.findElement(locator).sendKeys(inputText);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	/*
	 * (Clear) Clear method
	 */

	public void Clear(By locator) {
		try {
			System.out.println(getText(locator));
			driver.findElement(locator).clear();
			System.out.println(getText(locator));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	/*
	 * click method
	 */

	public void click(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	/*
	 * is Displayed method
	 */

	public boolean isDisplayed(By locator) {
		try {
			driver.findElement(locator).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Get text method
	 */
	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * Hard Assert Method(String)
	 */

	public void assertequalsBase(String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			Assert.fail(e.getMessage() + " /n Actual value: " + actualValue + " does not match with expected value: "
					+ expectedValue);
		}
	}
	
	/*
	 * Hard Assert Method(boolean)
	 */

	public void assertequalsBase(boolean actualValue, boolean expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			Assert.fail(e.getMessage() + " /n Actual value: " + actualValue + " does not match with expected value: "
					+ expectedValue);
		}
	}

	/*
	 * Hard Assert Method(Boolean)
	 */

	public void assertequalsBase(Boolean actualValue, Boolean expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			Assert.fail(e.getMessage() + " /n Actual value: does not match with expected value: " + expectedValue);
		}
	}

	/*
	 * SoftAssert Method(String)
	 */

	public SoftAssert softAssertequalsBase( String actualValue,  String expectedValue) {
		SoftAssert soft = new SoftAssert();
		try {
			soft.assertEquals(actualValue, expectedValue);
			return soft;
		} catch (AssertionError e) {
			soft.fail(e.getMessage() + " /n Actual value: " + actualValue + " does not match with expected value: "
					+ expectedValue);
			return null;
		}
		
	}

	/*
	 * SoftAssert Method(String)
	 */

	public String AlreadyExistingUserName(By locator, String x) {

		if (driver.findElement(locator).isDisplayed()) {
			x = x + "1";
			return x;
		} else {
			return x;
		}

	}
	
	
	/*
	 * read table Method(String)
	 */
	public String findValueinTable (String inputValue, By locator) {
		//table[@id = 'resultTable']/tbody//*[text()='Enabled']
		String aux = locator.toString();
		int x = aux.indexOf("/");
		aux = aux.substring(x);
		locator = By.xpath(aux+"/tbody//*[text()='"+inputValue+"']");
		assertequalsBase(isDisplayed(locator), true);
		return getText(locator);
		
	}
	
	/*
	 * Reporter.log("Verify username exist in table");
		String ActualValue = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		// Assert.assertEquals(ActualValue, "Admin");
		soft.assertEquals(ActualValue, "Admin");
		soft.assertAll();
	*/
	

	/*
	 * read table Method(String)
	 */
	public String readTableRandomValue(By locator) {
		Random Ran = new Random();
		String aux = locator.toString();
		int x = aux.indexOf("/"), y;
		aux = aux.substring(x);
		int rows = driver.findElements(By.xpath(aux+"/tbody/tr")).size();
		x = Ran.nextInt(rows-1) + 1;
		y = Ran.nextInt(5) + 2;
		locator = By.xpath(aux+"/tbody/tr["+x+"]/td["+y+"]");
		aux = "Random value found: " +getText(locator);
		click(locator);
		return aux;
	}
	
	
	/*
	 * read table Method(String)
	 */
	public String[] readTableRandomValue2(By locator) {
		String[] aux2 = new String[4];
		Random Ran = new Random();
		String aux = locator.toString();
		int x = aux.indexOf("/");
		aux = aux.substring(x);
		int rows = driver.findElements(By.xpath(aux+"/tbody/tr")).size();
		x = Ran.nextInt(rows) + 1;
		for(int i = 0; i<aux2.length;i++) {
			locator = By.xpath(aux+"/tbody/tr["+x+"]/td["+(i+2)+"]");
			aux2[i]= getText(locator);
		}
		
		return aux2;
	}

	/*
	 * Close browser Method(String)
	 */

	public void CloseBrowser() {
		implicityWait(5);
		driver.close();
	}
}
