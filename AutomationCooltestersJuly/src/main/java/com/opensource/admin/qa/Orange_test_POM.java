package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.AdminPage;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;
import com.opensource.main.LoginPage;

public class Orange_test_POM {
	
	WebDriver driver;
	Base base;
	LoginPage login;
	AdminPage admin;
	String Username, UsernameTC002, errorMsg, Password, user_Existing, new_User_name;
	
	
  
  @BeforeTest
  public void beforeTest() {
	  //Set up driver
	  base = new Base(driver);
	  driver = base.chromeDriver();
	  login =new LoginPage(driver);
	  admin = new AdminPage(driver);
	  
	  //Test Data
	  this.Username = "Admin";
	  this.Password = "admin123";
	  this.UsernameTC002 = "XYZ";
	  this.errorMsg = "No Records Found";
	  this.user_Existing = "Nina Patel";
	  this.new_User_name = "testorgange";
	  
  }
  
  @Test
  
  public void Orange_test_POM_Script() {
	  base.lunchBrowser(GlobalVariables.QA_url);
	  login.LoginOrangeHM(Username, Password);
	  admin.ValidateLogin();
	  admin.ValidateUserInTableAfterClick(Username);
	  login.LogOut();
  }
  
  
  @Test
  
  public void TC002() {
	  base.lunchBrowser(GlobalVariables.QA_url);
	  login.LoginOrangeHM(Username, Password);
	  admin.ValidateLogin();
	  admin.ClickAdmin();
	  admin.searchUser(UsernameTC002);
	  admin.validateUsernameIsNOTinTable(errorMsg);
	  login.LogOut();
  }
  
  
@Test
  
  public void TC003() {
	 
	  base.lunchBrowser(GlobalVariables.QA_url);
	  login.LoginOrangeHM(Username, Password);
	  admin.ValidateLogin();
	  new_User_name = admin.addNewUser(new_User_name, user_Existing, Password); 
	  admin.Save_validation();
	  admin.ValidateUserInTableAfterClick(new_User_name);
	  login.LogOut();
  }


@Test

public void TC004() {
	 
	  base.lunchBrowser(GlobalVariables.QA_url);
	  login.LoginOrangeHM(Username, Password);
	  admin.ValidateLogin();
	  admin.PrintRandomValueinTableAdminPage();
	  admin.PrintRandomRowTableAdminPage();
	  login.LogOut();
}


@Test

public void TC005() {
	 
	  base.lunchBrowser(GlobalVariables.QA_url);
	  login.LoginOrangeHM(Username, Password);
	  admin.ValidateLogin();
	  admin.ClickAdmin();
	  admin.printValueinTableAdminPage();
	  login.LogOut();
}

  @AfterTest
  
  public void afterTest() {
	  base.implicityWait(2);
	  base.CloseBrowser();
  }

}
