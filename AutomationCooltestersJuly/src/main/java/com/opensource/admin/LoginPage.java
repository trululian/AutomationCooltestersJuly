package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.opensource.base.Base;

public class LoginPage extends Base {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Objects
	 */
	
	By txtUsername = By.xpath("//input [@id='txtUsername']");
	By txtPassword = By.xpath("//input [@id='txtPassword']");
	By btnLogin = By.xpath("//input [@id='btnLogin']");
	By lnkWelcome = By.xpath("// a [@id = 'welcome']");
	By lnkLogOut = By.xpath("// a [contains(text(), 'Logout')]");
	
	/*
	 * Login OrangeHM
	 * @Author Julian . Pardo
	 * Date: 14/08/2021
	 */
	
	public void LoginOrangeHM(String user, String Password) {
		Reporter.log("Enter Username and Password");
		type(txtUsername, user);
		type(txtPassword, Password);
		click(btnLogin);
		implicityWait();
	}
	
	public void LogOut() {
		Reporter("Loggin out...");
		click(lnkWelcome);
		click(lnkLogOut);
		implicityWait();
		CloseBrowser();
	}
}
