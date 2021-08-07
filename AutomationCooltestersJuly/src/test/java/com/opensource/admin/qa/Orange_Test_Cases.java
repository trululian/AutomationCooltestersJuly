package com.opensource.admin.qa;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Orange_Test_Cases {

	@BeforeTest
	public void beforeTest() {
	}

	@Test
	public void TC001_Admin_SearchEmployee_script() {

		SoftAssert soft = new SoftAssert();

		// Step 1
		Reporter.log("Open Browser 'OrangeHRM' web page");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 2
		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input [@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input [@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input [@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 3
		Reporter.log("Validate that you have logged in successfully");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='OrangeHRM']")));

		// Step 4
		Reporter.log("Click Admin - Go to the admin page");
		boolean isAdminDisplayed = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).isDisplayed();
		soft.assertEquals(isAdminDisplayed, true);
		driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("// input[ @type= 'button' ][@id = 'searchBtn' ] ")));

		// Step 5
		Reporter.log("Search username in field 'Username'");
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Admin");

		// Step 6
		Reporter.log("Click Search");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

		// Step 7
		Reporter.log("Verify username exist in table");
		String ActualValue = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		// Assert.assertEquals(ActualValue, "Admin");
		soft.assertEquals(ActualValue, "Admin");
		soft.assertAll();

		// Step 8
		Reporter.log("Log Out");
		driver.findElement(By.xpath("// a [@id = 'welcome']")).click();
		driver.findElement(By.xpath("// a [contains(text(), 'Logout')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 9
		Reporter.log("Close browser");
		driver.close();
	}

	@Test
	public void TC002_Admin_SearchEmployee_NotExist() {
		// Step 1
		Reporter.log("Open Browser 'OrangeHRM' web page");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 2
		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input [@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input [@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input [@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 3
		Reporter.log("Validate that you have logged in successfully");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='OrangeHRM']")));

		// Step 4
		Reporter.log("Click Admin - Go to the admin page");
		boolean isAdminDisplayed = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).isDisplayed();
		Assert.assertEquals(isAdminDisplayed, true);
		driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("// input[ @type= 'button' ][@id = 'searchBtn' ] ")));

		// Step 5
		Reporter.log("Search username in field 'Username'");
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("XYZ");

		// Step 6
		Reporter.log("Click Search");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

		// Step 7
		Reporter.log("Verify username exist in table");
		String ActualValue = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(ActualValue);
		Assert.assertEquals(ActualValue, "No Records Found");

		// Step 8
		Reporter.log("Log Out");
		driver.findElement(By.xpath("// a [@id = 'welcome']")).click();
		driver.findElement(By.xpath("// a [contains(text(), 'Logout')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 9
		Reporter.log("Close browser");
		driver.close();
	}

	@Test
	public void TC003_Admin_AddNewUser() {
		// Step 1
		Reporter.log("Open Browser 'OrangeHRM' web page");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 2
		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input [@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input [@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input [@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 3
		Reporter.log("Validate that you have logged in successfully");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='OrangeHRM']")));

		// Step 4
		Reporter.log("Click Admin - Go to the admin page");
		boolean isDisplayed = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).isDisplayed();
		Assert.assertEquals(isDisplayed, true);
		driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("// input[ @type= 'button' ][@id = 'searchBtn' ] ")));

		// Step 5
		Reporter.log("Click Add button");
		isDisplayed = driver.findElement(By.xpath("//input [@type = 'button'][@id ='btnAdd']")).isDisplayed();
		Assert.assertEquals(isDisplayed, true);
		driver.findElement(By.xpath("//input [@type = 'button'][@id ='btnAdd']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@type = 'button' ] [@id ='btnSave']")));

		// Step 6
		Reporter.log("Enter valid Employee Name");
		driver.findElement(By.xpath("//input [@id ='systemUser_employeeName_empName']")).sendKeys("Nina Patel");

		// Step 7
		Reporter.log("Enter valid User name");
		driver.findElement(By.xpath("//input [@id ='systemUser_userName']")).sendKeys("trulutest");
		
		//Step 8 
		Reporter.log("Enter Password and confirm");
		driver.findElement(By.xpath("//input [@id ='systemUser_password']")).sendKeys("Test12345678");
		driver.findElement(By.xpath("//input [@id ='systemUser_confirmPassword']")).sendKeys("Test12345678");
		
		//Step 9
		Reporter.log("Click save");
		driver.findElement((By.xpath("//input [@type = 'button'][@id ='btnSave']"))).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		isDisplayed = driver.findElement(By.xpath("//input [@type = 'button'][@id ='btnAdd']")).isDisplayed();
		Assert.assertEquals(isDisplayed, true);
		
		//Step 10
		Reporter.log("Search username in field 'Username'");
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("trulutest");
		
		//Step 11
		Reporter.log("Click search");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step 12
		Reporter.log("Verify username exist in table");
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText(), "trulutest");
		
		//Step 11
		Reporter.log("log out");
		driver.findElement(By.xpath("// a [@id = 'welcome']")).click();
		driver.findElement(By.xpath("// a [contains(text(), 'Logout')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Step 12
		Reporter.log("Close browser");
		driver.close();
	}

	@AfterTest
	public void afterTest() {
	}

}
