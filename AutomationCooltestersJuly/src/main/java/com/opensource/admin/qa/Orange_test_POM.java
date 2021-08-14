package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.AdminPage;
import com.opensource.admin.LoginPage;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;

public class Orange_test_POM {
	
	WebDriver driver;
	Base base;
	LoginPage login;
	AdminPage admin;
	String Username , Password;
	
  
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
  }
  
  @Test
  public void Orange_test_POM_Script() {
	  base.lunchBrowser(GlobalVariables.QA_url);
	  login.LoginOrangeHM(Username, Password);
	  admin.ValidateLogin();
	  admin.ValidateUserInTableAfterClick(Username);
	  login.LogOut();
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
