package com.opensource.main;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
	String pathString;
	By txtUsername = By.xpath("//input [@id='txtUsername']");
	By txtPassword = By.xpath("//input [@id='txtPassword']");
	By btnLogin = By.xpath("//input [@id='btnLogin']");
	By lnkWelcome = By.xpath("// a [@id = 'welcome']");
	By lnkLogOut = By.xpath("// a [contains(text(), 'Logout')]");

	/*
	 * Login OrangeHM
	 * 
	 * @Author Julian . Pardo Date: 14/08/2021
	 */

	public void updatePath(String x) {
		pathString = x;
		System.out.println(x);
	}
	public void LoginOrangeHM(String user, String Password) {
		Reporter.log("Enter Username and Password");
		type(txtUsername, user);
		type(txtPassword, Password);
		takeScreenshot("enter credentials",pathString);
		click(btnLogin);
		implicityWait();
	}

	public void LogOut() {
		Reporter("Loggin out...");
		click(lnkWelcome);
		waitForElementPresent(lnkLogOut);
		takeScreenshot("log out", pathString);
		click(lnkLogOut);
	}
}
