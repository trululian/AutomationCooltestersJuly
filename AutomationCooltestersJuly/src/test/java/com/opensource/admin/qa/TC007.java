package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.AdminPage;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;
import com.opensource.main.LoginPage;

public class TC007 {

	WebDriver driver;
	Base base;
	LoginPage login;
	AdminPage admin;
	String Username, Password, user_Existing, new_User_name, path, Role, status;
	
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
//		  this.user_Existing = base.getJSONValue("TC007", "user_Existing");
//		  this.new_User_name = base.getJSONValue("TC007","new_User_name");
//		  this.Role = base.getJSONValue("TC007","Role");
//		  this.status = base.getJSONValue("TC007","Status");		  
		  
		//Test Data Con excel
		  this.Username = base.getCellData("Orange_test_POM", 2, 0);
		  this.Password = base.getCellData("Orange_test_POM", 2, 1);
		  this.user_Existing = base.getCellData("Orange_test_POM", 6, 0);
		  this.new_User_name = base.getCellData("Orange_test_POM", 6, 1);
		  this.Role = base.getCellData("Orange_test_POM", 6, 2);
		  this.status = base.getCellData("Orange_test_POM", 6, 3);
	  }
	
	@Test
	  
	  public void test() {
		 
		  base.lunchBrowser(GlobalVariables.QA_url);
		  login.LoginOrangeHM(Username, Password);
		  admin.ValidateLogin();
		  admin.addNewUser2(new_User_name, user_Existing, Password, Role, status);
		  admin.Save_validation();
		  admin.ValidateUserStatus(new_User_name, status);
		  login.LogOut();
	  }
	
	 @AfterTest
	  
	  public void afterTest() {
		  base.implicityWait(2);
		  base.CloseBrowser();
	  }
	
}
