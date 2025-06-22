package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.DemoPage;

import utils.ExtentReportManager;
import utils.Log;

public class DemoRegistrationTestValidation extends BaseTest {

	@Test
	public void DemoFormRegistrationvalidation() {

		Log.info("Starting Demo Registration test to validate for mandatory field validation...");
		test = ExtentReportManager.createTest("henteck - Try a Demo Page Registration");

		Log.info("Navigating to URL");
		DemoPage DemoValidObj = new DemoPage(driver);
		

		test.info("Navigating to URL");
		Log.info("From home page click on Try demo button ");
		DemoValidObj.clickTryDemo(test);
		// test.pass("From home page click on Try demo button ");

		Log.info("Automation script to validate error messages on Demo form");
		test.info("Automation script to validate error messages on Demo form");

	

		Log.info(
				"Submitting Demo Registration Form also validating if any error mandatory fields are missed to filled");
		test.info("Submitting Demo Registration Form also validating if any error mandatory fields are missed to filled");
		DemoValidObj.SubmitDemoRequest(test);
		

		Log.info("Once after clicking on Submit butting Reading successfull/failure message from browser");
		DemoValidObj.ReadMessage(test);
		test.info("Once after clicking on Submit butting Reading successfull/failure message from browser");



	}

}