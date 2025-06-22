package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.DemoPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class DemoRegistrationTest extends BaseTest {
	
	@DataProvider(name = "DemoRegisterationData")
	public Object[][] RegstPersonalAccountNewData() throws IOException {

		String filePath = System.getProperty("user.dir") + "/testdata/DemoData.xlsx";
		ExcelUtils.loadExcel(filePath, "DemoDataSheet");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][8];

		for (int i = 1; i < rowCount; i++) {

			data[i - 1][0] = ExcelUtils.getCellData(i, 0); 
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); 
			data[i - 1][2] = ExcelUtils.getCellData(i, 2);
			data[i - 1][3] = ExcelUtils.getCellData(i, 3);
			data[i - 1][4] = ExcelUtils.getCellData(i, 4);
			data[i - 1][5] = ExcelUtils.getCellData(i, 5);
			data[i - 1][6] = ExcelUtils.getCellData(i, 6);
			data[i - 1][7] = ExcelUtils.getCellData(i, 7);

			
		}
		ExcelUtils.closeExcel();
		return data;
	}
	

	@Test(dataProvider = "DemoRegisterationData")
	public void DemoFormRegistration(String leverage,String AccountSize ,String FirstName, String LastName,String EmailID,String CountryList, String CountryCode,String PhoneNumber) {

	
		Log.info("Starting Demo Registration test...");
		test = ExtentReportManager.createTest("Henteck - Try a Demo Page Registration");

		Log.info("Navigating to URL");
		test.info("Navigating to URL");
		DemoPage DemoObj = new DemoPage(driver);
		
		Log.info("Automation script is strating to fill Demo Registrartion page");
		test.info("Automation script is strating to fill Demo Registrartion page");
		DemoObj.clickTryDemo(test);

		Log.info("Select Dropdown field from Select Leverage field");
		test.info("Select Dropdown field from Select Leverage field");
		DemoObj.SelectLaverage_DD(leverage,test);
	
		
		Log.info("Select Dropdown field from Select Demo Account Size");
		test.info("Select Dropdown field from Select Demo Account Size");
		DemoObj.SelectAccountSize_DD(AccountSize,test);
		

		Log.info("Entering First name");
		test.info("Entering First name");
		DemoObj.DemoFirstName(FirstName,test);
	
	

		Log.info("Entering Last name");
		test.info("Entering Last name");
		DemoObj.DemoLastName(LastName,test);
		

		Log.info("Entering Email ID");	
		test.info("Entering Email ID");
		DemoObj.DemoEmailId(EmailID,test);


		DemoObj.scroll();
		
		Log.info("Selecting Country Code");		
		test.info("Selecting Country Code");
		DemoObj.SelectCountyFromList(CountryList,test);
		

		Log.info("Entering Phone number");
		test.info("Entering Phone number");
		DemoObj.EnterPhoneNumberWithCountryCode(CountryCode,PhoneNumber,test);
	
		Log.info("Selecting Checkbox from Demo Page");
		test.info("Selecting Checkbox from Demo Page");
		DemoObj.SelectCheckboxDemo(test);
		

		Log.info("Submitting Demo Registration Form also validating if any error mandatory fields are missed to filled");
		test.info("Submitting Demo Registration Form");
		DemoObj.SubmitDemoRequest(test);
		
		
		Log.info("Once after clicking on Submit butting Reading successfull/failure message from browser");
		test.info("Once after clicking on Submit butting Reading successfull/failure message from browser");
		DemoObj.ReadMessage(test);
		
		
	
		
		} 
		
	

	}


