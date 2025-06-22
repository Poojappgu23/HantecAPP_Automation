package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegstPersonalPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class RegstPersonalAccount extends BaseTest {

	

	@DataProvider(name = "PersonalAccountRegistrationDataNewUser")
	public Object[][] RegstPersonalAccountNewData() throws IOException {

		String filePath = System.getProperty("user.dir") + "/testdata/PersonalAccountTestData.xlsx";
		ExcelUtils.loadExcel(filePath, "PersonalAccountRegisterData");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][6];

		for (int i = 1; i < rowCount; i++) {

			data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Firstname
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); // lastName
			data[i - 1][2] = ExcelUtils.getCellData(i, 2);// Email
			data[i - 1][3] = ExcelUtils.getCellData(i, 3);// country code
			data[i - 1][4] = ExcelUtils.getCellData(i, 4);// Phone number
			data[i - 1][5] = ExcelUtils.getCellData(i, 5); // password
		}
		ExcelUtils.closeExcel();
		return data;
	}



	// Program to register new Users
	@Test(dataProvider = "PersonalAccountRegistrationDataNewUser")
	public void RegstPersonalAccountNewUser(String PFirstName, String PLastName, String PEmail, String PCountryCode,
			String PPhoneNumber, String PPassword) {
	
		
		Log.info("Starting participant Registration test to Register New User...");
		test = ExtentReportManager.createTest("henteck - Personal Account Page Registration");

		Log.info("Navigating to URL");
		test.info("Navigating to URL");
		
		RegstPersonalPage objRegPage = new RegstPersonalPage(driver);

		Log.info("Register new account as Personal Account");
		test.info("Register new account as Personal Account");
		objRegPage.clickPersonalAccount(test);

		Log.info("Entering First name");
		test.info("Entering First name");
		objRegPage.DemoFirstName(PFirstName, test);

		Log.info("Entering Last name");
		test.info("Entering Last name");
		objRegPage.DemoLastName(PLastName, test);

		objRegPage.scroll();

		Log.info("Entering Email ID");
		test.info("Entering Email ID");
		objRegPage.DemoEmailId_dynamic(test);

		Log.info("Selecting Country from List");
		test.info("Selecting Country from List");
		objRegPage.SelectCountyFromList(test);

		Log.info("Entering Phone number");
		test.info("Entering Phone number");
		objRegPage.EnterPhoneNumberWithCountryCode(PCountryCode, PPhoneNumber, test);

		Log.info("Entering password");
		test.info("Entering password");
		objRegPage.EnterPassword(PPassword, test);

		objRegPage.scroll();

		Log.info("Selecting Checkbox from Demo Page");
		test.info("Selecting Checkbox from Demo Page");
		objRegPage.SelectCheckboxDemo(test);

		Log.info("click on start your application");
		test.info("click on start your application");
		objRegPage.PersonalApplicationRegistration(test);

	}

	
}
