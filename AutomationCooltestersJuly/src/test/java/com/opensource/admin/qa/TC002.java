package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.AdminPage;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;
import com.opensource.main.LoginPage;

public class TC002 {

	WebDriver driver;
	Base base;
	LoginPage login;
	AdminPage admin;
	String Username, UsernameTC002, errorMsg, Password, path;
	
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
//		  this.Username = base.getJSONValue("Orange_test_POM", "Username");
//		  this.Password = base.getJSONValue("Orange_test_POM", "Password");
//		  this.UsernameTC002 = base.getJSONValue("Orange_test_POM", "UsernameTC002");
//		  this.errorMsg = base.getJSONValue("Orange_test_POM", "errorMsg");
//		  
		  
		//Test Data Con excel
		  this.Username = base.getCellData("Orange_test_POM", 2, 0);
		  this.Password = base.getCellData("Orange_test_POM", 2, 1);
		  this.UsernameTC002 = base.getCellData("Orange_test_POM", 2, 2);
		  this.errorMsg = base.getCellData("Orange_test_POM", 2, 3);
		  
	  }
	 
	 @Test
	  
	  public void test() {
		  base.lunchBrowser(GlobalVariables.QA_url);
		  login.LoginOrangeHM(Username, Password);
		  admin.ValidateLogin();
		  admin.ClickAdmin();
		  admin.searchUser(UsernameTC002);
		  admin.validateUsernameIsNOTinTable(errorMsg);
		  login.LogOut();
	  }
	 
	 @AfterTest
	  
	  public void afterTest() {
		  base.implicityWait(2);
		  base.CloseBrowser();
	  }
	
}
