package tests;

import base.BaseTest;
import pages.RegstPersonalPage;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class RegstPersonalAccountValidation extends BaseTest {

	@DataProvider(name = "PersonalAccountRegistrationData")
	public Object[][] RegstPersonalAccountData() throws IOException {

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

	@Test(dataProvider = "PersonalAccountRegistrationData")
	public void RegstPersonalAccountUser(String PFirstName, String PLastName, String PEmail, String PCountryCode,
			String PPhoneNumber, String PPassword) {

		Log.info("Starting participant Registration test page to verify existing users validation..");
		test = ExtentReportManager.createTest("henteck - Personal Account Page Registration");

		RegstPersonalPage objRegPage = new RegstPersonalPage(driver);

		// data reading from Excel
		System.out.println("Testing with: " + PFirstName + " / " + PLastName + " / " + PEmail + " / " + PCountryCode
				+ " / " + PPhoneNumber + " / " + PPassword);

		Log.info("Starting Personal Registration test...");
		test = ExtentReportManager.createTest("henteck - Try a Personal Page Registration");

		Log.info("Navigating to URL");
		test.info("Navigating to URL");

		Log.info("Register new account as Personal Account");
		objRegPage.clickPersonalAccount(test);
		test.info("Register new account as Personal Account");

		

		Log.info("click on start your application");
		objRegPage.PersonalApplicationRegistration(test);
		test.info("click on start your application");

		Log.info("Reading Existing user from UI and taking screenShot and purposfully marking Test cases as failed");
		objRegPage.ReadSucessExistingUserMessage(test);
		test.info("Reading Existing user from UI and taking screenShot and purposfully marking Test cases as failed");

	}

}
