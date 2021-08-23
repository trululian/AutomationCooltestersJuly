package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.AdminPage;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;
import com.opensource.main.LoginPage;

public class TC004 {

	WebDriver driver;
	Base base;
	LoginPage login;
	AdminPage admin;
	String Username, Password, path;
	
	@BeforeTest
	  public void beforeTest() {
		  //Set up driver
		  base = new Base(driver);
		  driver = base.chromeDriver();
		  login =new LoginPage(driver);
		  admin = new AdminPage(driver);
		  this.path = base.createScreenshotsDIR(this.getClass().getName());
		  admin.updatePath(path);
		  login.updatePath(path);
		  //Test Data Con Json
//		  this.Username = base.getJSONValue("General", "Username");
//		  this.Password = base.getJSONValue("General", "Password");

		  
		//Test Data Con excel
		  this.Username = base.getCellData("Orange_test_POM", 2, 0);
		  this.Password = base.getCellData("Orange_test_POM", 2, 1);
	  }
	
	@Test

	public void test() {
		 
		  base.lunchBrowser(GlobalVariables.QA_url);
		  login.LoginOrangeHM(Username, Password);
		  admin.ValidateLogin();
		  admin.PrintRandomValueinTableAdminPage();
		  admin.PrintRandomRowTableAdminPage();
		  login.LogOut();
	}
	
	@AfterTest
	  
	  public void afterTest() {
		  base.implicityWait(2);
		  base.CloseBrowser();
	  }
	
}
