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
import com.aventstack.extentreports.Status;

import utils.Helper;

public class DemoPage {

	// constructor
	public DemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new Helper(driver, driver), this); // calling helper class for highlighter

	}

	private WebDriver driver;

	@FindBy(xpath = "//a[.='Try a demo']")
	WebElement tryADemo_btn;

	@FindBy(name = "leverage")
	WebElement SelectLeverage;

	@FindBy(name = "deposit")
	WebElement SelectAccountSize;

	@FindBy(name = "firstName")
	WebElement typeFirstName;

	@FindBy(name = "lastName")
	WebElement typelastName;

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

	@FindBy(css = "div[class='flex items-center ml-1 mr-2.5'] input[type='checkbox']")
	WebElement selectCheckBox;

	@FindBy(css = "button[type='submit']")
	WebElement SubmitDemo_btn;

	@FindBy(xpath = "//p[@class= \"text-hantec-primary ml-1\"]")
	WebElement successMessageLocator;

	// Validation messages

	List<By> validationLocators = Arrays.asList(By.xpath("//span[contains(text(),'Leverage is required')]"),
			By.xpath("//span[contains(text(),'Account size is required')]"),
			By.xpath("//span[contains(text(),'First name is required')]"),
			By.xpath("//span[contains(text(),'Last name is required')]"),
			By.xpath("//span[contains(text(),'Email is required')]"),
			By.xpath("//span[contains(text(),'Country is required')]"),
			By.xpath("//span[contains(text(),'Invalid phone number')]"));

	public void clickTryDemo(ExtentTest test) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(tryADemo_btn));
		if (tryADemo_btn.isDisplayed()) {
			tryADemo_btn.click();
			test.log(Status.PASS, "user sucessfully selected button -TRY A DEMO");
			Assert.assertTrue(true);
		} else {
			test.log(Status.FAIL, "couldn't click on button -TRY A DEMO, please check error message");
			Assert.fail("couldn't click on button -TRY A DEMO, please check error message");
		}
	}

	public void DemoFirstName(String Fname, ExtentTest test) {
		try {
			typeFirstName.click();
			typeFirstName.sendKeys(Fname);
			test.log(Status.PASS, "Entered First name sucessfully");
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered First name" );
			Assert.fail("couldn't Entered First name" );
		}
	}

	public void DemoLastName(String LName, ExtentTest test) {
		try {

			typelastName.click();
			typelastName.sendKeys(LName);
			test.log(Status.PASS, "Entered Last name sucessfully");
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered Last name" );
			Assert.fail("couldn't Entered Last name");
		}

	}

	public void DemoEmailId(String DemoEmailID, ExtentTest test) {
		try {
			typeEmail.click();
			typeEmail.sendKeys(DemoEmailID);

			test.log(Status.PASS, "Entered email ID sucessfully");
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered email ID " );
			Assert.fail("couldn't Entered email ID ");
		}
	}

	public void SelectLaverage_DD(String leverage,ExtentTest test) {
		try {
			Select selectLaverageOject = new Select(SelectLeverage);
			// selectOject.selectByIndex(0);
			// selectOject.selectByContainsVisibleText("1:500");
			selectLaverageOject.selectByValue(leverage);
			test.log(Status.PASS, "laverage data added sucessfully");
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered laverage data" );
			Assert.fail("couldn't Entered laverage data" );
		}
	}

	public void SelectAccountSize_DD(String ACCsize, ExtentTest test) {
		try {
			Select selecAccounttOject = new Select(SelectAccountSize);
			selecAccounttOject.selectByValue(ACCsize);
			test.log(Status.PASS, "SelectAccountSize data added sucessfully");
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered SelectAccountSize data added sucessfully " );
			Assert.fail("couldn't Entered SelectAccountSize data added sucessfully " );
		}
	}

	public void EnterPhoneNumberWithCountryCode(String CountryCode, String PhoneNumber, ExtentTest test) {

		try {
			CCDropDown.click();
			Thread.sleep(200);
			searchCountrycode.click();
			Thread.sleep(200);
			searchCountrycode.sendKeys(CountryCode);
			searchCountrycode.sendKeys(Keys.ENTER);

			Thread.sleep(2000);
			enterPhoneNumber.click();
			enterPhoneNumber.sendKeys(PhoneNumber);
			test.log(Status.PASS, "Entered Phone number sucessfully");
			Assert.assertTrue(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			test.log(Status.FAIL, "couldn't Entered Phone number ");
			Assert.fail("couldn't Entered Phone number" );
		}

	}

	public void SelectCountyFromList(String CountryList, ExtentTest test) {
		try {
			selectCountryFromList.click();
			Select selectCountryOnject = new Select(selectCountryFromList);
			selectCountryOnject.selectByValue(CountryList);
			test.log(Status.PASS, "Selected country from DropDown sucessfully");
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "couldn't Selected country from DropDown ");
			Assert.fail("couldn't Selected country from DropDown " );
		}
	}

	public void SelectCheckboxDemo(ExtentTest test) {
		if (!selectCheckBox.isSelected()) {
			selectCheckBox.click(); // Select the checkbox
			test.log(Status.PASS, "Selected Checkbox sucessfully");
			Assert.assertTrue(true);

		} else {
			test.log(Status.FAIL, "Checkbox coulnot selected");
			Assert.fail("Checkbox coulnot selected");

		}
	}

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
	}

	public void SubmitDemoRequest(ExtentTest test) {
		
		
		try {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement startApplicationPrg = wait.until(ExpectedConditions.elementToBeClickable(SubmitDemo_btn));
		startApplicationPrg.click();

		for (By locator : validationLocators) {
			List<WebElement> elements = driver.findElements(locator);
			if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
				String text = elements.get(0).getText().trim();
				System.out.println("Visible message: " + text);
				test.log(Status.FAIL,
						"user need to fill the mandatory fields on Demo registration page visible error message:  "
								+ text);
			} else {
				System.out.println("Message not visible for: " + locator.toString());

			}
		}
		
		test.log(Status.PASS, " submitted sucessfully");
		Assert.assertTrue(true);
		
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e);
			test.log(Status.FAIL, "Sumbmit request " );
			Assert.fail("couldn't Selected Sumbmit request " + e);
			
		}
		

	}

	public void ReadMessage(ExtentTest test) {
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement startApplicationPrg = wait.until(ExpectedConditions.elementToBeClickable(successMessageLocator));
		String msg =startApplicationPrg.getText();
		System.out.println(msg);

		if (startApplicationPrg.isDisplayed() && startApplicationPrg.getText().equals("Your submission was successful.")) {
			test.log(Status.PASS, "Your submission was successful." + startApplicationPrg);
			Assert.assertTrue(true);

		} else {
			// An error occured. Please try again later.
			test.log(Status.FAIL, "Automation Script failed  error message" + msg);
			Assert.fail("Automation Script failed error message" + msg);

		}

	}
}
