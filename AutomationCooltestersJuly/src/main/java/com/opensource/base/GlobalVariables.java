package com.opensource.base;

import org.openqa.selenium.WebDriver;

public class GlobalVariables {

	public static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_NAME = "./src/test/resources/drivers/chrome/chromedriver.exe";
	public static final String PATH_JSON_DATA = "./src/test/resources/testdata/json/"; //Path json
	public static final String PATH_EXCEL_DATA = "./src/test/resources/testdata/excel/"; //Path excel
	public static final String PATH_SCREENSHOTS = System.getProperty("user.dir")+"/test-output/screenshots/";
	public static final int GENERAL_TIMEOUT = 15;
	public static final int GENERAL_IMPLICITY_TIMEOUT = 15;
	public static final String QA_url ="https://opensource-demo.orangehrmlive.com/";
	public static final String LUNCH_BROWSER_DESC = "Lunching Browser: ";
	public static final String VALUETOBEFOUNDINADMINPAGEUSERTABLE ="manali28";
	
	

	
	
	
}
