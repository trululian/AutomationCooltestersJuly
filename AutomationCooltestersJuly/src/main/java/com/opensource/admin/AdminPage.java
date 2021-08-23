package com.opensource.admin;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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
	By tblCheckBox = By.xpath("//tbody/tr[1]/td/input[@type = 'checkbox']");
	By tblnotFoundMsg = By.xpath("//tbody/tr[1]/td[1]");
	By tblUserStatus = By.xpath("//tbody/tr[1]/td[5]");
	By btnAdd = By.xpath("//input [@type = 'button'][@id ='btnAdd']");
	By btnSave = By.xpath("//input [@type = 'button' ] [@id ='btnSave']");
	By btnDel = By.xpath("//input [@type = 'submit' ] [@id ='btnDelete']");
	By btnOKConfrimDeleteUser = By.xpath("//input [@type = 'button' ] [@id ='dialogDeleteBtn']");
	By lstUserROle = By.xpath("//select[@id='systemUser_userType']");
	By txtInputExistingUserName = By.xpath("//input [@id ='systemUser_employeeName_empName']");
	By txtInputNewUser = By.xpath("//input [@id ='systemUser_userName']");
	By lstUserStatus= By.xpath("// select[@id = 'systemUser_status']");
	By txtNewPassword = By.xpath("//input [@id ='systemUser_password']");
	By txtConfirmNewPassword = By.xpath("//input [@id ='systemUser_confirmPassword']");
	By AlreadyExistsUserName = By.xpath("//span[text()='Already exists']");
	By formbox = By.xpath("//form[@id = 'frmSystemUser']");
	By saveConfirmationMessage = By.xpath("//*[@class = 'message success fadable']");
	By deleteConfirmationMessage = By.xpath("//*[@class = 'message success fadable']");
	By tableUserTableAdminPage = By.xpath("//table[@id = 'resultTable']");

	public void updatePath(String x) {
		pathString = x;
		System.out.println(x);
	}

	public void ValidateLogin() {
		Reporter("Validate login was succesful");
		waitForElementPresent(imgHeaderOrange);
		assertEquals(isDisplayed(imgHeaderOrange), true);
		takeScreenshot("login succesful", pathString);
	}

	public void ClickAdmin() {
		Reporter("Click Admin module");
		click(lnkAdmin);
		implicityWait(5);
		assertequalsBase(isDisplayed(tableUserTableAdminPage), true);
		takeScreenshot("Admin clicked", pathString);
	}

	public void Clicksearch() {
		Reporter("Click search button");
		click(btnSearchButton);
		implicityWait(5);
		takeScreenshot("search clicked", pathString);
	}

	public void searchUser(String username) {
		Reporter("Searching " + username);
		type(txtSearchUserName, username);
		takeScreenshot("search user", pathString);
		Clicksearch();
		implicityWait();
	}

	public void validateUsernameTable(String username) {
		Reporter("Verify user " + username + "  in admin table");
		implicityWait(2);
		assertequalsBase(getText(tblUsername), username);
		takeScreenshot("User found", pathString);
	}

	public void validateUsernameIsNOTinTable(String Username) {
		Reporter("Verify user " + Username + "  is not found in admin table");
		System.out.println(getText(tblnotFoundMsg));
		assertequalsBase(getText(tblnotFoundMsg), "No Records Found");
		takeScreenshot("User not found", pathString);
	}
	
	public void validateUserSatus(String expectedStatus) {
		Reporter("Verify Status " + expectedStatus + "  is the correct one");
		System.out.println(getText(tblUserStatus));
		if(expectedStatus.equals("Enabled")) {
			takeScreenshot("User status is Enabled", pathString);
		}else if(expectedStatus.equals("Disabled")) {
			takeScreenshot("User status is Disabled", pathString);
		}else {
			Assert.fail("Status is not the expected");
		}
	}

	public void clickAddBtn() {
		Reporter("Click Add Button");
		assertequalsBase(isDisplayed(btnAdd), true);
		click(btnAdd);
		implicityWait(2);
		takeScreenshot("add page displayed", pathString);
	}

	public void clickDeleteBtn() {
		Reporter("Click Delete Button");
		assertequalsBase(isDisplayed(btnDel), true);
		takeScreenshot("located Delbtn", pathString);
		click(btnDel);
		takeScreenshot("Delbtn clicked", pathString);
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
		// type(locator, UserName);
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

	public void printValueinTableAdminPage() {
		Reporter("Printing especific Value from Admin Page Table");
		String answer = findValueinTable(GlobalVariables.VALUETOBEFOUNDINADMINPAGEUSERTABLE, tableUserTableAdminPage);
		Reporter("The value: " + GlobalVariables.VALUETOBEFOUNDINADMINPAGEUSERTABLE
				+ "was found in the table.-- Value in table:" + answer + "");
		System.out.println("The value: " + GlobalVariables.VALUETOBEFOUNDINADMINPAGEUSERTABLE
				+ "  was found in the table.-- Value in table: " + answer + "");
	}

	public void PrintRandomValueinTableAdminPage() {
		Reporter("Printing random Value from Admin Page Table");
		ClickAdmin();
		waitForElementPresent(tableUserTableAdminPage);
		String x = (readTableRandomValue(tableUserTableAdminPage));
		Reporter(x);
		System.out.println(x);

	}

	public void PrintRandomRowTableAdminPage() {
		Reporter("Printing random complete row from Admin Page Table");
		ClickAdmin();
		waitForElementPresent(tableUserTableAdminPage);
		String[] aux = readTableRandomValue2(tableUserTableAdminPage);
		for (int i = 0; i < aux.length; i++) {
			System.out.print(" " + aux[i] + " ");
		}

	}

	public void selectRole(String option) {
		System.out.println("Option inputted is "+option);
		if (option.equals("Admin")) {
			SelectFromList(lstUserROle, option);
		} else if (option.equals("ESS")){
			SelectFromList(lstUserROle, option);
		} else {
			Assert.fail("Role was not set");
		}
		
	}
	
	public void selectStatus(String option) {
		System.out.println("Option inputted is "+option);
		if (option.equals("Enabled")) {
			SelectFromList(lstUserStatus, option);
		} else if(option.equals("Disabled")) {
			SelectFromList(lstUserStatus, option);
		}else {
			Assert.fail("Status was not set");
		}
	}

	/*
	 * Wrapper method add new user2
	 */

	public void addNewUser2(String UserName, String exisntingUser, String Password, String Role, String status) {
		Reporter("Inputting new user data");
		ClickAdmin();
		clickAddBtn();
		waitForElementPresent(btnSave, 5);
		selectRole(Role);
		type(txtInputExistingUserName, exisntingUser);
		type(txtInputNewUser, UserName);
		waitTimeInSconds(2);
		selectStatus(status);
		type(txtNewPassword, Password);
		waitTimeInSconds(1);
		type(txtConfirmNewPassword, Password);
		System.out.println("datos ingresados y a validar");
		click(formbox);
		click(txtInputNewUser);
		assertEquals(isDisplayed(AlreadyExistsUserName), false);
		takeScreenshot("adding new user", pathString);
	}

	public String addNewUser(String UserName, String exisntingUser, String Password) {
		Reporter("Inputting new user data");
		ClickAdmin();
		clickAddBtn();
		waitForElementPresent(btnSave, 5);
		type(txtInputExistingUserName, exisntingUser);
		type(txtInputNewUser, UserName);
		waitTimeInSconds(2);
		type(txtNewPassword, Password);
		waitTimeInSconds(1);
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

	public void deleteUser(String username) {
		Reporter("Deleteing an user");
		ClickAdmin();
		waitForElementPresent(tableUserTableAdminPage, 5);
		ValidateUserInTableAfterClick(username);
		click(tblCheckBox);
		takeScreenshot("user selected to be deleted", pathString);
		clickDeleteBtn();
		waitTimeInSconds(1);
		assertEquals(isDisplayed(btnOKConfrimDeleteUser), true);
		click(btnOKConfrimDeleteUser);
		System.out.println(getText(deleteConfirmationMessage));
		assertEquals(getText(deleteConfirmationMessage), "Successfully Deleted");
		takeScreenshot("user deleted", pathString);
		ValidateUserInNOTTableAfterClick(username);
	}
	/*
	 * Wrapper method
	 */

	public void ValidateUserInTableAfterClick(String username) {
		ClickAdmin();
		searchUser(username);
		validateUsernameTable(username);
	}

	public void ValidateUserInNOTTableAfterClick(String username) {
		ClickAdmin();
		searchUser(username);
		validateUsernameIsNOTinTable(username);
	}
	
	public void ValidateUserStatus(String username, String expectedstatus) {
		ClickAdmin();
		searchUser(username);
		validateUsernameTable(username);
		validateUserSatus(expectedstatus);
	}

	public void Save_validation() {
		clickSaveButton();
//		waitForElementPresent(saveConfirmationMessage, 1);
		waitForElementPresent(btnAdd, 1);
		System.out.println(getText(saveConfirmationMessage));
		assertEquals(getText(saveConfirmationMessage), "Successfully Saved");
		takeScreenshot("User saved", pathString);
	}

}
