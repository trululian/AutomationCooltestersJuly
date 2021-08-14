package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.Base;

public class AdminPage extends Base{

	public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By imgHeaderOrange = By.xpath("//img[@alt='OrangeHRM']");
	By lnkAdmin = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	By txtSearchUserName = By.xpath("//input[@id='searchSystemUser_userName']");
	By btnSearchButton = By.xpath("//input[@id='searchBtn']");
	By tblUsername = By.xpath("//tbody/tr[1]/td[2]");
	
	public void ValidateLogin() {
		Reporter("Validate login was succesful");
		waitForElementPresent(imgHeaderOrange);
		isDisplayed(imgHeaderOrange);
	}
	
	public void ClickAdmin () {
		Reporter("Click Admin module");
		click(lnkAdmin);
		implicityWait();
	}
	
	public void searchUser(String username) {
		Reporter("Searching " + username);
		type(txtSearchUserName, username);
		ClickAdmin();
		implicityWait();
	}
	
	public void validateUsernameTable(String username) {
		Reporter("Verify user "+username+"  in admin table");
		assertequalsBase(getText(tblUsername), username);
	}
	
	/*
	 * Wrapper method
	 */
	
	public void ValidateUserInTableAfterClick(String username) {
		ClickAdmin();
		searchUser(username);
		validateUsernameTable(username);
	}
}
