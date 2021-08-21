package com.opensource.admin;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;

public class AdminPage extends Base {

	public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String pathString;
	SoftAssert soft;
	By imgHeaderOrange = By.xpath("//img[@alt='OrangeHRM']");
	By lnkAdmin = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	By txtSearchUserName = By.xpath("//input[@id='searchSystemUser_userName']");
	By btnSearchButton = By.xpath("//input[@id='searchBtn']");
	By tblUsername = By.xpath("//tbody/tr[1]/td[2]");
	By tblnotFoundMsg = By.xpath("//tbody/tr[1]/td[1]");
	By btnAdd = By.xpath("//input [@type = 'button'][@id ='btnAdd']");
	By btnSave = By.xpath("//input [@type = 'button' ] [@id ='btnSave']");
	By txtInputExistingUserName = By.xpath("//input [@id ='systemUser_employeeName_empName']");
	By txtInputNewUser = By.xpath("//input [@id ='systemUser_userName']");
	By txtNewPassword = By.xpath("//input [@id ='systemUser_password']");
	By txtConfirmNewPassword = By.xpath("//input [@id ='systemUser_confirmPassword']");
	By AlreadyExistsUserName = By.xpath("//span[text()='Already exists']");
	By formbox = By.xpath("//form[@id = 'frmSystemUser']");
	By saveConfirmationMessage = By.xpath("//*[@class = 'message success fadable']");
	By tableUserTableAdminPage = By.xpath("//table[@id = 'resultTable']");
			

	public void updatePath(String x) {
		pathString = x;
		System.out.println(x);
	}
	public void ValidateLogin() {
		Reporter("Validate login was succesful");
		waitForElementPresent(imgHeaderOrange);
		assertEquals(isDisplayed(imgHeaderOrange),true);
		String x = ""+isDisplayed(imgHeaderOrange);
		soft = softAssertequalsBase(x , "true");
	}

	public void ClickAdmin() {
		Reporter("Click Admin module");
		click(lnkAdmin);
		implicityWait(5);
		assertequalsBase(isDisplayed(tableUserTableAdminPage),true);
		takeScreenshot("Admin clicked",pathString);
	}

	public void Clicksearch() {
		Reporter("Click search button");
		click(btnSearchButton);
		implicityWait(5);
		takeScreenshot("search clicked",pathString);
	}

	public void searchUser(String username) {
		Reporter("Searching " + username);
		type(txtSearchUserName, username);
		Clicksearch();
		implicityWait();
	}

	public void validateUsernameTable(String username) {
		Reporter("Verify user " + username + "  in admin table");
		implicityWait(2);
		assertequalsBase(getText(tblUsername), username);
	}

	public void validateUsernameIsNOTinTable(String ErrorMsg) {
		Reporter("Verify user " + ErrorMsg + "  is not found in admin table");
		assertequalsBase(getText(tblnotFoundMsg), ErrorMsg);
	}

	public void clickAddBtn() {
		Reporter("Click Add Button");
		assertequalsBase(isDisplayed(btnAdd), true);
		click(btnAdd);
		implicityWait(2);
	}

	public void clickSaveButton() {
		Reporter("Click Save Button: ");
		assertequalsBase(isDisplayed(btnSave), true);
		click(btnSave);
		System.out.println("Save button Clicked");
	}

	public String isAlreadyUsed(By locator, By locator1, String UserName) {
		Reporter("already existing user name");
		//type(locator, UserName);
		click(formbox);
		click(locator);
		System.out.println(getText(locator1));
		while (isDisplayed(locator1)) {
			System.out.println(getText(locator1));
			UserName = AlreadyExistingUserName(locator1, UserName);
			System.out.println(UserName);
			Clear(locator);
			click(formbox);
			click(locator);
			type(locator, UserName);
			waitTimeInSconds(2);
			click(locator);
			click(formbox);
			
		}
		return UserName;
	}
	
	
	public void printValueinTableAdminPage () {
		Reporter("Printing especific Value from Admin Page Table");
		String answer = findValueinTable(GlobalVariables.VALUETOBEFOUNDINADMINPAGEUSERTABLE,tableUserTableAdminPage);
		Reporter("The value: "+GlobalVariables.VALUETOBEFOUNDINADMINPAGEUSERTABLE+ "was found in the table.-- Value in table:"+answer+"");
		System.out.println("The value: "+GlobalVariables.VALUETOBEFOUNDINADMINPAGEUSERTABLE+"  was found in the table.-- Value in table: "+answer+"");
	}
	
	public void PrintRandomValueinTableAdminPage () {
		Reporter("Printing random Value from Admin Page Table");
		ClickAdmin();
		waitForElementPresent(tableUserTableAdminPage);
		String x = (readTableRandomValue(tableUserTableAdminPage));
		Reporter(x);
		System.out.println(x);
		
	}	
	
	public void PrintRandomRowTableAdminPage () {
		Reporter("Printing random complete row from Admin Page Table");
		ClickAdmin();
		waitForElementPresent(tableUserTableAdminPage);
		String [] aux = readTableRandomValue2(tableUserTableAdminPage);
		for (int i = 0; i<aux.length; i++) {
			System.out.print(" "+aux[i]+ " ");
		}
		
	}
	
	/*
	 * Wrapper method add new user
	 */

	public String addNewUser(String UserName, String exisntingUser, String Password) {
		Reporter("Inputting new user data");
		ClickAdmin();
		clickAddBtn();
		waitForElementPresent(btnSave, 5);
		type(txtInputExistingUserName, exisntingUser);
		waitTimeInSconds(2);
		type(txtInputNewUser, UserName);
		waitTimeInSconds(2);
		type(txtNewPassword, Password);
		waitTimeInSconds(2);
		type(txtConfirmNewPassword, Password);
		System.out.println("datos ingresados y a validar");
		click(formbox);
		click(txtInputNewUser);
		waitTimeInSconds(2);
		if (isDisplayed(AlreadyExistsUserName)) {
			UserName = isAlreadyUsed(txtInputNewUser, AlreadyExistsUserName, UserName);
		}
		
		System.out.println(UserName);
		return UserName;
	}
	/*
	 * Wrapper method
	 */

	public void ValidateUserInTableAfterClick(String username) {
		ClickAdmin();
		searchUser(username);
		validateUsernameTable(username);
	}
	
	public void Save_validation() {
		clickSaveButton();
//		waitForElementPresent(saveConfirmationMessage, 1);
		waitForElementPresent(btnAdd, 2);
		System.out.println(getText(saveConfirmationMessage));
		assertEquals(getText(saveConfirmationMessage), "Successfully Saved");
		
	}
	
}
