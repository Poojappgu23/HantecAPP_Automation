package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utils.ExtentReportManager;
import utils.Helper;

public class RegstPersonalPagevalidation {
	ExtentTest test;

	// constructor
	public RegstPersonalPagevalidation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new Helper(driver, driver), this); // calling helper class for Action element

	}

	private WebDriver driver;

	@FindBy(xpath = "//a[.='Open an account']")
	WebElement OpenRegisteration_btn;

	@FindBy(name = "first_name")
	WebElement typeFirstNamePA;

	@FindBy(name = "last_name")
	WebElement typelastNamePA;

	@FindBy(name = "email")
	WebElement typeEmail;

	@FindBy(name = "country")
	WebElement selectCountryFromList;

	@FindBy(xpath = "//button[contains(@class, 'm-select-input__toggle-button') and @aria-label='expand list of options']")
	WebElement CCDropDown;

	@FindBy(id = "country-selector-MazPhoneNumberInput-87")
	WebElement countryCode;

	@FindBy(name = "search")
	WebElement searchCountrycode;

	@FindBy(css = "[id^='MazPhoneNumberInput-']")
	WebElement enterPhoneNumber;

	@FindBy(name = "password")
	WebElement enterPassword;

	@FindBy(css = "div[class='flex items-center ml-1 mr-2.5'] input[type='checkbox']")
	WebElement selectCheckBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement startApplication;

	@FindBy(xpath = "//*[@id=\"app\"]/main/div/div[2]/div/form/div[8]/p")
	WebElement ReadMessageRegistration;

	@FindBy(css = "//p[contains(text(),'Account registration')]")
	WebElement accountRegistered;

	@FindBy(xpath = "//div[contains(normalize-space(),'Hantec Markets - FSC')]")
	WebElement pagePath;

	// Account Registration Page
	@FindBy(css = "//a[contains(.,'Personal details')]")
	WebElement personalDetails;

	@FindBy(id = "fname")
	WebElement Account_firstName;

	@FindBy(id = "lname")
	WebElement Account_LastName;

	@FindBy(name = "email")
	WebElement Account_Email;

	// Validation messages

	List<By> validationLocators = Arrays.asList(By.xpath("//span[contains(text(),'First name is required')]"),
			By.xpath("//span[contains(text(),'Last name is required')]"),
			By.xpath("//span[contains(text(),'Email is required')]"),
			By.xpath("//span[contains(text(),'Country is required')]"),
			By.xpath("//span[contains(text(),'Invalid phone number')]"),
			By.xpath("//span[contains(text(),'Between 8 and 20 characters long')]"),
			By.xpath("//span[contains(text(),'At least one number')]"),
			By.xpath("//span[contains(text(),'At least one lowercase letter')]"),
			By.xpath("//span[contains(text(),'At least one uppercase letter')]"),
			By.xpath("//span[contains(text(),'At least one special character (~!@#$%^&*[?+)')]"),
			By.xpath("//span[contains(text(),'A client with the same email ID already exists in this entity.')]")

	);

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
	}

	public void clickPersonalAccount(ExtentTest test) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(OpenRegisteration_btn));
		if (OpenRegisteration_btn.isDisplayed()) {
			OpenRegisteration_btn.click();
			test.log(Status.PASS, "user sucessfully selected button -OPEN AN ACCOUNT");
			Assert.assertTrue(true);
		} else {
			test.log(Status.FAIL, "couldn't click on selected button -OPEN AN ACCOUNT, please check error message");
			Assert.fail("couldn't click on selected button -OPEN AN ACCOUNT, please check error message");
		}
	}

	public void DemoFirstName(String firstName, ExtentTest test) {
		try {
			typeFirstNamePA.click();
			typeFirstNamePA.sendKeys(firstName);
			test.log(Status.PASS, "Entered First name sucessfully");
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered First name" );
			Assert.fail("couldn't Entered First name" );
		}
	}

	public void DemoLastName(String lastName, ExtentTest test) {
		try {

			typelastNamePA.click();
			typelastNamePA.sendKeys(lastName);
			test.log(Status.PASS, "Entered Last name sucessfully");
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered Last name" );
			Assert.fail("couldn't Entered Last name" );
		}

	}

	// reading email ID from excel
	public void DemoEmailId(String email, ExtentTest test) {
		try {
			typeEmail.click();
			typeEmail.sendKeys(email);

			test.log(Status.PASS, "Entered email ID sucessfully");
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered email ID ");
			Assert.fail("couldn't Entered email ID ");
		}
	}

	// Generate Dynamic email ID
	public void DemoEmailId_dynamic(ExtentTest test) {
		try {

			String randomEmail = Helper.generateRandomEmail();
			System.out.println("Generated Randon email Id Email for Automation: " + randomEmail);

			// Example: Use it in registration

			typeEmail.sendKeys(randomEmail);

			test.log(Status.PASS, "Entered email ID sucessfully");
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered email ID ");
			Assert.fail("couldn't Entered email ID ");
		}
	}

	public void EnterPhoneNumberWithCountryCode(String countryCode, String phoneNumber, ExtentTest test) {

		try {

			CCDropDown.click();
			Thread.sleep(200);
			searchCountrycode.click();
			Thread.sleep(200);
			searchCountrycode.sendKeys(countryCode);
			searchCountrycode.sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			enterPhoneNumber.click();
			enterPhoneNumber.sendKeys(phoneNumber);
			Thread.sleep(4000);
			test.log(Status.PASS, "Entered Phone number sucessfully");
			Assert.assertTrue(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered Phone number ");
			Assert.fail("couldn't Entered Phone number");
		}

	}

	public void SelectCountyFromList(ExtentTest test) {

		try {
			selectCountryFromList.click();
			Select selectLaverageOject = new Select(selectCountryFromList);
			selectLaverageOject.selectByValue("AE");

			test.log(Status.PASS, "Selected country from DropDown sucessfully");
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Selected country from DropDown ");
			Assert.fail("couldn't Selected country from DropDown ");
		}
	}

	public void EnterPassword(String Password, ExtentTest test) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(enterPassword));
			enterPassword.click();
			enterPassword.sendKeys(Password);
			enterPassword.sendKeys(Keys.ENTER);
			test.log(Status.PASS, "Entered Password sucessfully");
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered Password  ");
			Assert.fail("couldn't Entered Password  ");

		}
	}

	public void SelectCheckboxDemo(ExtentTest test) {

		if (!selectCheckBox.isSelected()) {
			selectCheckBox.click(); // Select the checkbox 

			test.log(Status.PASS, "Selected Checkbox sucessfully");
			Assert.assertTrue(true);

		} else {
			Assert.fail("Checkbox coulnot selected");

		}
	}

	public void PersonalApplicationRegistration(ExtentTest test) {

		startApplication.click();
		

		String expectedUrl = "https://portal-mu.hmarkets.com/en/#docs";
		String actualUrl = driver.getCurrentUrl();
		
		
		 //Wait for the URL to change to the target URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

		if (actualUrl.equals(expectedUrl)) {
			System.out.println("URL matches");
			String screenshotApplicationSubmit = ExtentReportManager.captureScreenshot(driver,
					"Application submit screenshort");
			test.pass("Check Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotApplicationSubmit).build());

		} else {
			System.out.println("URL does not match");
			test.log(Status.FAIL, "URL did not matched");

		}

		for (By locator : validationLocators) {
			List<WebElement> elements = driver.findElements(locator);

			if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
				String text = elements.get(0).getText().trim();

				System.out.println(
						"user need to fill the mandatory fields on Demo registration page visible error message: "
								+ text);

				test.log(Status.FAIL,
						"user need to fill the mandatory fields on Demo registration page visible error message:  "
								+ text);
				Assert.fail("System error message:" + text);
			} else {
				System.out.println("No message visible for: " + locator.toString());
				// test.info("No message visible for: " + locator.toString());
			}
		}

	}

	public void ReadSucessExistingUserMessage(ExtentTest test) {

		String ExistingUserMessage = ReadMessageRegistration.getText();

		if (ExistingUserMessage.equals("A client with the same email ID already exists in this entity.")) {

			test.log(Status.FAIL, "A client with the same email ID already exists in this entity.");
			// Assert.assertTrue(true);
			Assert.fail("System error message:" + ExistingUserMessage);

		} else {
			Assert.fail("System error message:" + ExistingUserMessage);
		}
	}

	public void UserAccountRegistration(ExtentTest test) {
		// TODO Auto-generated method stub
		driver.navigate().to("https://portal-mu.hmarkets.com/en/#docs");

		String screenshotUserAccount = ExtentReportManager.captureScreenshot(driver, "Application submit screenshort");
		test.pass("Check Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotUserAccount).build());

	}

}