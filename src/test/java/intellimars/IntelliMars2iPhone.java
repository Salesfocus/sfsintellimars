package intellimars;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;

public class IntelliMars2iPhone {

	public IOSDriver driver;
	public DesiredCapabilities caps;
	public MobileElement more;
	public String dateofSystem;
	



	@BeforeTest
	@Parameters({"app", "deviceName", "udid", "platformVersion", "xcodeOrgId", "userid", "password", "url"})
	public void setUp(String app, String deviceName, String udid, String platformVersion, String xcodeOrgId, String userid, String password, String url) throws MalformedURLException {
		// Passing Desired Capabilities
		caps = new DesiredCapabilities();
		caps.setCapability("app", app);
		caps.setCapability("deviceName", deviceName);
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("udid", udid);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("xcodeOrgId", xcodeOrgId);
		caps.setCapability("XcodeSigningId", "iPhone Developer");
		caps.setCapability("showIOSLog", "true");
		caps.setCapability("noReset", "true");
		caps.setCapability("showXcodeLog", "true");
		caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		WebDriverWait wait = new WebDriverWait(driver, 30);

	
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
				.clear();
		Reporter.log("User name is cleared");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
				.sendKeys(userid);
		Reporter.log("User Name is entered");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
				.sendKeys(password);
		Reporter.log("Password is entered");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
				.clear();
		Reporter.log("URL is cleared");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
				.sendKeys(url);
		Reporter.log("URL is entered");
		driver.findElementByAccessibilityId("Sign In").click();
		Reporter.log("Cicked on Sign In");


	}

	
	@BeforeMethod
	public void waitforit() {

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	
	
	}

	
    @Test(groups="repsync", priority = 1)
    @Parameters({ "MrepFname", "MrepLname"})
	public void repsync(String MrepFname, String MrepLname) {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		boolean menu= driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").isEnabled();
		
		if(menu) {
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
		Reporter.log("Clicked in Menu");
		driver.findElementByAccessibilityId("Rep").click();
		Reporter.log("Clicked on Rep in Menu");}
		
		else {
		
			try {
				Thread. sleep(30000);
				driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
				Reporter.log("Clicked in Menu");
				driver.findElementByAccessibilityId("Rep").click();
				Reporter.log("Clicked on Rep in Menu");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		// Click on First Name and enter Fname
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on First Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys(MrepFname);
		Reporter.log("First Name is entered");

		// Click on Last Name and enter Lname

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Last Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys(MrepLname);
		Reporter.log("Last Name is entered");
		// Apply
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");
		
		
		//driver.findElementByAccessibilityId(MrepFname+ MrepLname).click();
		//driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+MrepLname+")]").click();
		System.out.println(MrepFname+ " "+MrepLname);
		driver.findElementByAccessibilityId(MrepFname+ " "+MrepLname).click();
		Reporter.log("Drilled down on Rep");
		
	
		
		
		//Verify Tabs in Rep Profile.
		//Note::: in dashboard tab of rep profile, all the tabs are veirified as swipe functionality is working yet 
		
		driver.findElementByAccessibilityId("Teams").click();
		Reporter.log("Navigated to Teams");
		
		driver.findElementByAccessibilityId("Dashboard").click();
		Reporter.log("Navigated to Dashboard");
		
		more= (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"More\"]");
		
		more.click();
		Reporter.log("Clicked on more");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Categories\"]").click();
		Reporter.log("Navigated to Categories");
		
		more.click();
		Reporter.log("Clicked on more");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Segmented\"]").click();
		Reporter.log("Navigated to Segmented");
		
		more.click();
		Reporter.log("Clicked on more");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Addresses\"]").click();
		Reporter.log("Navigated to Addresses");
		
		more.click();
		Reporter.log("Clicked on more");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Phones\"]").click();
		Reporter.log("Navigated to Phones");
		
		more.click();
		Reporter.log("Clicked on more");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Read Out\"]").click();
		Reporter.log("Navigated to Read Out");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Close\"]").click();
		Reporter.log("Navigated out of Read Out");
		
		driver.findElementByAccessibilityId("Timeline").click();
		Reporter.log("Selected Timeline in rep profile");
		driver.findElementByAccessibilityId("OK").click();
		Reporter.log("Clicked on OK and granted access to Calnedar");
	
		
		//Note: Crosscheck if add cat etc should be implemented from here and verify in MARS
		
	}
	@Test(groups="officesyn", priority = 2)
	@Parameters({"Mfirmname", "Mofficename"})
	public void officesync(String Mfirmname, String Mofficename) {
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Office").click();
		Reporter.log("Clicked on Office");
		// select and enter Firm Name

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Firm Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys(Mfirmname);
		Reporter.log("Firm Name is entered");
		
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Office");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys(Mofficename);
		Reporter.log("Office Name is entered");
		
		// apply
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");
		
		driver.findElementByAccessibilityId(Mofficename).click();
		Reporter.log("Drilled down on office profile");
		
		driver.findElementByAccessibilityId("Reps").click();
		Reporter.log("Clicked on Rep Tab");
		
		driver.findElementByAccessibilityId("Teams").click();
		Reporter.log("Clicked on Teams Tab");
		
		//more.click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"More\"]").click();
		Reporter.log("Clicked on More");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Dashboard\"]").click();
		Reporter.log("Clicked on Dashboard");
		
		more.click();
		Reporter.log("Clicked on More");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Categories\"]").click();
		Reporter.log("Clicked on Categories");
		
		more.click();
		driver.findElementByAccessibilityId("More").click();
		Reporter.log("Clicked on More");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Segmented\"]").click();
		Reporter.log("Clicked on Segmented");
		
	
	}
	@Test(groups="firmsync", priority = 3)
	@Parameters({"Mfirmname"})
	public void firmsync(String Mfirmname) {
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
		Reporter.log("Clicked on Menu Icon");
		driver.findElementByAccessibilityId("Firm").click();
		Reporter.log("Clicked on Firm in Menu");
		// Firm Name
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Firm Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys(Mfirmname);
		Reporter.log("Entered Firm Name");
		
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");
		
		driver.findElementByAccessibilityId(Mfirmname).click();
		Reporter.log("Drilled down on Firm");
		
		driver.findElementByAccessibilityId("Reps").click();
		Reporter.log("Clicked on Rep Tab");
		
		driver.findElementByAccessibilityId("Teams").click();
		Reporter.log("Clicked on Teams Tab");
		
		more.click();
		Reporter.log("Clicked on More");
		driver.findElementByAccessibilityId("Offices").click();
		Reporter.log("Clicked on Offices");
		
		more.click();
		Reporter.log("Clicked on More");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Dashboard\"]").click();
		Reporter.log("Clicked on Dashboard");
		
		more.click();
		Reporter.log("Clicked on More");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Categories\"]").click();
		Reporter.log("Clicked on Categories");
		
		more.click();
		Reporter.log("Clicked on More");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Segmented\"]").click();
		Reporter.log("Clicked on Segmented");
		
		}
	
	
	@Test(groups="editrep", priority= 4)
	@Parameters({"editrepFname", "editrepLname" })
	public void editrep(String editrepFname, String editrepLname) {
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
		Reporter.log("Clicked in Menu");
		driver.findElementByAccessibilityId("Rep").click();
		Reporter.log("Clicked on Rep in Menu");

		// Click on First Name and enter Fname
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on First Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys(editrepFname);
		Reporter.log("First Name is entered");

		// Click on Last Name and enter Lname

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Last Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys(editrepLname);
		Reporter.log("Last Name is entered");
		// Apply
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");
		
		
		driver.findElementByAccessibilityId(editrepFname+ " "+editrepLname).click();
		//driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+editrepLname+")]").click();
		Reporter.log("Drilled down on Rep");
		
		driver.findElementByAccessibilityId(editrepFname+ " "+editrepLname).click();
		//driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+editrepLname+")]").click();
		Reporter.log("Drilled down to Rep edit page");
		//Clear & Type First Name
		//driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[1]").clear();
		//Reporter.log("Clear First Name");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[1]").sendKeys("..");
		Reporter.log("Type First Name");
		
		//Clear & Type Middle Name
		//driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[2]").clear();
		//Reporter.log("Clear Middle Name");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[2]").sendKeys("..");
		Reporter.log("Type Middle Name");
		
		//Clear & Type Last Name
		//driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[3]").clear();
		//Reporter.log("Cleared Last Name");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[3]").sendKeys("..");
		Reporter.log("Typed Last Name");
		//Disbale Same as office Switch
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeSwitch[2]").click();
		Reporter.log("Cliked and Disbaled 'Use Office Switch");
		
		//Edit Address line 1
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[4]").clear();
		Reporter.log("Cleared Address line 1");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[4]").sendKeys("Address Line 1_Rep Modified Address");
		Reporter.log("Modified Address Line 1");
		//Edit Address Line 2
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[5]").clear();
		Reporter.log("Cleared Address Line 2");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[5]").sendKeys("Address Line 2_Rep Modified Address");
		Reporter.log("Modified Address Line 2");
		//Edit Address Line 3
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[6]").clear();
		Reporter.log("Cleared Address Line 3");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[6]").sendKeys("Address Line 3_Rep Modified Address");
		Reporter.log("Modified Address Line 3");
		//Edit Address Line 4
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[7]").click();
		Reporter.log("Cleared Address Line 4");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[7]").sendKeys("Address Line 4_Rep Modified Address");
		Reporter.log("Modified Address Line 4");
		//Clear and Type City
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[8]").clear();
		Reporter.log("Cleared Address Line 4");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[8]").sendKeys("MOODY");
		Reporter.log("Modified Address Line 4");
		//Clear & Type Zip
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[9]").clear();
		Reporter.log("Cleared Zip");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[9]").sendKeys("35004");
		Reporter.log("Modified Zip");
		
		//Modify State
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Florida\"]").click();
		Reporter.log("Clicked on State");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Alabama\"]").click();
		
		//Modify Phone
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[10]").clear();
		Reporter.log("Cleared Phone Number");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[10]").sendKeys("9876543210");
		Reporter.log("Modified Phone Number");
		
		//Enter Extension
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[11]").clear();
		Reporter.log("Cleared Extension");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[11]").sendKeys("12345");
		Reporter.log("Modified Extension");
		
		//Click on Save
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
		Reporter.log("Clicked on Save");

		
	}
	
	@Test(groups="addrep", priority = 5)
	@Parameters({"Mfirmname", "Mofficename"})
	public void addrep(String Mfirmname, String Mofficename) {
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Office").click();
		Reporter.log("Clicked on Office");
		// select and enter Firm Name

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Firm Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys(Mfirmname);
		Reporter.log("Firm Name is entered");
		
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Office");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys(Mofficename);
		Reporter.log("Office name is typed");
		
		// apply
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");
		
		driver.findElementByAccessibilityId(Mofficename).click();
		Reporter.log("Drilled down on office profile");
		
		//Click on Add icon
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add line\"]").click();
		Reporter.log("Clicked on Add Icon");
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Rep\"]").click();
		Reporter.log("Clicked on Rep(to add");
		
	DateFormat formatdate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date systemDate = new Date();
    dateofSystem = formatdate.format(systemDate);
		
    driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[1]").sendKeys("First Name"+ dateofSystem);
    Reporter.log("Entered First Name");
    driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[2]").sendKeys("Meddle Name"+ dateofSystem);
	Reporter.log("Entered Middle Name");
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[3]").sendKeys("Last Name"+ dateofSystem);
	Reporter.log("Entered Last Name");
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
	Reporter.log("Clicked on Save");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test(groups="calmeeting", priority= 6)
	@Parameters("editrepLname")
	public void calmeeting(String editrepLname) {
		
		//line491 & 487 : pass the parameters as last name; 494: Pass Timestamp in Meeting Description.
		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Calendar").click();
		Reporter.log("Clicked on Calendar in Menu");
		driver.findElementByAccessibilityId("Allow").click();
		Reporter.log("Allowed to access Location");
		driver.findElementByAccessibilityId("OK").click();
		Reporter.log("Allowed Access to calendar");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add\"]").click();
		Reporter.log("Clicked on add icon");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Meeting\"]").click();
		Reporter.log("Clicked on Add Meeting");
		
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[1]").sendKeys(editrepLname);
		Reporter.log("Entered Last Name");
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeApplication[@name=\\\"IntelliMARS\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[1]"))).sendKeys("BISHOP");

		driver.findElementByAccessibilityId(editrepLname).click();
		Reporter.log("Select Rep Profile");
		
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]").sendKeys("Meeting"+ dateofSystem);
		Reporter.log("Type Meeting Description");
		
	    driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
		
		
	}
	
	@Test(groups="calcall", priority= 7)
	@Parameters({"editrepLname"})
	public void calcall(String editrepLname) {
		
		//Note: Line 516 & 518: Parameters should be passed for LastName;
		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Calendar").click();
		Reporter.log("Clicked on Calendar in Menu");
		driver.findElementByAccessibilityId("Allow").click();
		Reporter.log("Allowed to access Location");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add\"]").click();
		Reporter.log("Clicked on add icon");
		driver.findElementByAccessibilityId("Call").click();
		Reporter.log("Clicked on Add Call");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[1]").sendKeys(editrepLname);
		Reporter.log("Entered Last Name");
		driver.findElementByXPath("	//XCUIElementTypeStaticText[@name=\"Brandon Bishop\"]").click();
		//driver.findElementByAccessibilityId("Brandon Bishop").click();
		Reporter.log("Selected the rep");
		driver.findElementByAccessibilityId("Save").click();
		//driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
		Reporter.log("Clicked on Save and added call");		
		
	}
	
	@Test(groups="callogcall", priority= 8)
	@Parameters({"editrepLname", "editrepFname"})
	public void callogcall(String editrepLname, String editrepFname) {
		
		//note: 545, 547 need to  be updated with parameters
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElementByAccessibilityId("Menu line").click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Calendar").click();
		Reporter.log("Clicked on Calendar in Menu");
		driver.findElementByAccessibilityId("Allow").click();
		Reporter.log("Allowed to access Location");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add\"]").click();
		Reporter.log("Clicked on add icon");
		driver.findElementByAccessibilityId("Log Call").click();
		Reporter.log("Clicked on Add Log Call");
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[1]").sendKeys(editrepLname);
		Reporter.log("Entered Last Name");
		//driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Brandon Bishop\"]").click();

	   //driver.findElementByAccessibilityId(editrepFname+ editrepLname).click();
		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+editrepLname+")]").click();
		Reporter.log("Selected the Rep");
		driver.findElementByAccessibilityId("Selected Log Call Types (0)").click();
		Reporter.log("Clicked on Select Log");
		
		driver.findElementByAccessibilityId("BB Call").click();
		Reporter.log("Select BB Call Type");
		driver.findElementByAccessibilityId("Done").click();
		//driver.findElementByXPath("//XCUIElementTypeButton[@name="Done"]").click();
		Reporter.log("Clicked on Done");
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//driver.findElementByAccessibilityId("Save").click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
		Reporter.log("Clicked on Save");
		
	}
	
	@Test(groups="repmeet", priority= 9)
	@Parameters({"MrepFname", "MrepLname"})
	
	public void repmeet(String MrepFname, String MrepLname) {
		//note: First/Last name & drilldown on 606, 618 line should be updated with parameters
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
		Reporter.log("Clicked in Menu");
		driver.findElementByAccessibilityId("Rep").click();
		Reporter.log("Clicked on Rep in Menu");

		// Click on First Name and enter Fname
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on First Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
				.sendKeys(MrepFname);
		Reporter.log("First Name is entered");

		// Click on Last Name and enter Lname

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Last Name");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys(MrepLname);
		Reporter.log("Last Name is entered");
		// Apply
		driver.findElementByAccessibilityId("Apply").click();
		Reporter.log("Clicked on Apply");
		
		
		//driver.findElementByAccessibilityId(MrepFname+ MrepLname).click();
		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+MrepLname+")]").click();
		Reporter.log("Drilled down on Rep");
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add line\"]").click();
		//driver.findElemetByAccessibilityId("Add line").click();
		Reporter.log("Clicked on Add Icon");
		
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Meeting\"]").click();
		//driver.findElementByAccessibilityId("Meeting").click();
		Reporter.log("Clicked on Meeting");
		
		//Send Parameter
		driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]").sendKeys("PARAMETER");
		Reporter.log("Entered Meeting Description");
		
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
	//driver.findElementByAccessibilityId("Save").click();
	Reporter.log("Clicked on Save");
		
	}

@Test(groups="repschedulecall", priority= 10)
@Parameters({"MrepFname", "MrepLname"})
public void repschedulecall(String MrepFname, String MrepLname) {
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
	Reporter.log("Clicked in Menu");
	driver.findElementByAccessibilityId("Rep").click();
	Reporter.log("Clicked on Rep in Menu");

	// Click on First Name and enter Fname
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on First Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
			.sendKeys(MrepFname);
	Reporter.log("First Name is entered");

	// Click on Last Name and enter Lname

	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on Last Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
			.sendKeys(MrepLname);
	Reporter.log("Last Name is entered");
	// Apply
	driver.findElementByAccessibilityId("Apply").click();
	Reporter.log("Clicked on Apply");
	
	
	//driver.findElementByAccessibilityId(MrepFname+ MrepLname).click();
	driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+MrepLname+")]").click();
	Reporter.log("Drilled down on Rep");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add line\"]").click();
	//driver.findElemetByAccessibilityId("Add line").click();
	Reporter.log("Clicked on Add Icon");
	
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Schedule Call\"]").click();
	//driver.findElemetByAccessibilityId("Schedule Call").click();
	Reporter.log("Clicked on Schedule Call");
	
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
	//driver.findElemetByAccessibilityId("Save").click();
	Reporter.log("Clicked on Save");
	
}

@Test(groups="logcalls", priority=11)
@Parameters({"MrepFname", "MrepLname"})
public void logcalls(String MrepFname, String MrepLname) {
	
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
	Reporter.log("Clicked in Menu");
	driver.findElementByAccessibilityId("Rep").click();
	Reporter.log("Clicked on Rep in Menu");

	// Click on First Name and enter Fname
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on First Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
			.sendKeys(MrepFname);
	Reporter.log("First Name is entered");

	// Click on Last Name and enter Lname

	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on Last Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
			.sendKeys(MrepLname);
	Reporter.log("Last Name is entered");
	// Apply
	driver.findElementByAccessibilityId("Apply").click();
	Reporter.log("Clicked on Apply");
	
	
	//driver.findElementByAccessibilityId(MrepFname+ MrepLname).click();
	driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+MrepLname+")]").click();
	Reporter.log("Drilled down on Rep");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add line\"]").click();
	//driver.findElemetByAccessibilityId("Add line").click();
	Reporter.log("Clicked on Add Icon");
	
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Log Call\"]").click();
	//driver.findElemetByAccessibilityId("Log Call").click();
	Reporter.log("Clicked on Log Call");
	
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Selected Log Call Types (0)\"]").click();
	//driver.findElementByAccessibilityId("Selected Log Call Types (0)");.click();
	Reporter.log("Clicked to select Call type");
	
	
	driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"BB Call\"]").click();
	//driver.findElementByAccessibilityId("BB Call").click();
	Reporter.log("Clicked on BB Call type");
	
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Done\"]").click();
	//driver.findElementByAccessibilityId("Done").click();
	Reporter.log("Clicked on Done");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
	//driver.findElementByAccessibilityId("Save").click();
	Reporter.log("Clicked on Save");
	
}

@Test(groups="repemail", priority= 12)
@Parameters({"MrepFname", "MrepLname"})
public void repemail(String MrepFname, String MrepLname) {
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
	Reporter.log("Clicked in Menu");
	driver.findElementByAccessibilityId("Rep").click();
	Reporter.log("Clicked on Rep in Menu");

	// Click on First Name and enter Fname
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on First Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
			.sendKeys(MrepFname);
	Reporter.log("First Name is entered");

	// Click on Last Name and enter Lname

	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on Last Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
			.sendKeys(MrepLname);
	Reporter.log("Last Name is entered");
	// Apply
	driver.findElementByAccessibilityId("Apply").click();
	Reporter.log("Clicked on Apply");
	
	
	//driver.findElementByAccessibilityId(MrepFname+ MrepFname).click();
	driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+MrepLname+")]").click();
	Reporter.log("Drilled down on Rep");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add line\"]").click();
	//driver.findElemetByAccessibilityId("Add line").click();
	Reporter.log("Clicked on Add Icon");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Email\"]").click();
	//driver.findElemetByAccessibilityId("Email").click();
	Reporter.log("Clicked on email");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[2]").sendKeys("Email Subject PARAMETER:Timestamp");
	Reporter.log("Email Subject is entered");
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextView").click();
	Reporter.log("Click on Email body");
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextView").sendKeys("Email Body");
	Reporter.log("Email body is typed");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Email filled\"]").click();
	//driver.findElementByAccessibilityId("Email filled").click();
	Reporter.log("Clicked on send Email");
	
	
}


	
	
@Test(groups="note", priority= 13)
@Parameters({"MrepFname", "MrepLname"})
public void note(String MrepFname, String MrepLname ) {
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
	Reporter.log("Clicked in Menu");
	driver.findElementByAccessibilityId("Rep").click();
	Reporter.log("Clicked on Rep in Menu");

	// Click on First Name and enter Fname
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on First Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
			.sendKeys(MrepFname);
	Reporter.log("First Name is entered");

	// Click on Last Name and enter Lname

	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on Last name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
			.sendKeys(MrepLname);
	Reporter.log("Last Name is entered");
	// Apply
	driver.findElementByAccessibilityId("Apply").click();
	Reporter.log("Clicked on Apply");
	
	
	//driver.findElementByAccessibilityId(MrepFname+ MrepLname).click();
	driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+MrepLname+")]").click();
	Reporter.log("Drilled down on Rep");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add line\"]").click();
	//driver.findElemetByAccessibilityId("Add line").click();
	Reporter.log("Clicked on Add Icon");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Note\"]").click();
	//driver.findElementByAccessibilityId("Note").click();
	Reporter.log("Click on Note");
	
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextView").sendKeys("Mobile Rep Notes PARAMETER:timestamp");
	Reporter.log("Added Notes");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
	//driver.findElementByAccessibilityId("Save").click();
	Reporter.log("Click on save");
	

	
}

@Test(groups="repcategory", priority= 14)
@Parameters({"MrepFname", "MrepLname"})
public void repcategory(String MrepFname, String MrepLname ) {
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
	Reporter.log("Clicked in Menu");
	driver.findElementByAccessibilityId("Rep").click();
	Reporter.log("Clicked on Rep in Menu");

	// Click on First Name and enter Fname
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on First Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
			.sendKeys(MrepFname);
	Reporter.log("First Name is entered");

	// Click on Last Name and enter Lname

	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on Last Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
			.sendKeys(MrepLname);
	Reporter.log("Last Name is entered");
	// Apply
	driver.findElementByAccessibilityId("Apply").click();
	Reporter.log("Clicked on Apply");
	
	
	//driver.findElementByAccessibilityId(MrepFname+ MrepLname).click();
	driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+MrepLname+")]").click();
	Reporter.log("Drilled down on Rep");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add line\"]").click();
	//driver.findElemetByAccessibilityId("Add line").click();
	Reporter.log("Clicked on Add Icon");
	
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Category\"]").click();
	//driver.findElemetByAccessibilityId("Category").click();
	Reporter.log("Clicked on Category");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton[1]").click();
	Reporter.log("Clicked on Category Type");
	driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Professional Designation\"]").click();
	//driver.findElemetByAccessibilityId("Professional Designation").click();
	Reporter.log("Selected Professional Designation in Category Log");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"<Select>\"]").click();
	//driver.findElemetByAccessibilityId("<Select>").click();
	Reporter.log("Clicked on Category Code");
	
	driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Cert. Fin. Planner\"]").click();
	//driver.findElemetByAccessibilityId("Cert. Fin. Planner").click();
	Reporter.log("Selected Cert. Fin.Planner as Category Code");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys("Mob Rep_Category Comments_PARAMETERS Timestamp");
	Reporter.log("Category comments are added");
	
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
	//driver.findElementByAccessibilityId("Save").click();
	Reporter.log("Selected Cert. Fin.Planner as Category Code");
	
}

@Test(groups="repphone", priority= 15)
@Parameters({"MrepFname", "MrepLname"})
public void rephone(String MrepFname, String MrepLname ) {
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
	Reporter.log("Clicked in Menu");
	driver.findElementByAccessibilityId("Rep").click();
	Reporter.log("Clicked on Rep in Menu");

	// Click on First Name and enter Fname
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on First Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
			.sendKeys(MrepFname);
	Reporter.log("First Name is entered");

	// Click on Last Name and enter Lname

	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on Last Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
			.sendKeys(MrepLname);
	Reporter.log("Last Name is entered");
	// Apply
	driver.findElementByAccessibilityId("Apply").click();
	Reporter.log("Clicked on Apply");
	
	
	//driver.findElementByAccessibilityId(MrepFname+ MrepLname).click();
	driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+MrepLname+")]").click();
	Reporter.log("Drilled down on Rep");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add line\"]").click();
	//driver.findElemetByAccessibilityId("Add line").click();
	Reporter.log("Clicked on Add Icon");
	
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Phone\"]").click();
	//driver.findElemetByAccessibilityId("Phone").click();
	Reporter.log("Clicked on Phone");
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[1]").sendKeys("1234567890");
	Reporter.log("Eneterd Phone Number");
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField[2]").sendKeys("12345");
	Reporter.log("Eneterd Extension Number");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
	//driver.findElementByAccessibilityId("Save").click();
	Reporter.log("Clicked on Save");
	
}

@Test(groups="repaddress", priority= 16)
@Parameters({"MrepFname", "MrepLname"})
public void repaddress(String MrepFname, String MrepLname) {
	
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Menu line\"]").click();
	Reporter.log("Clicked in Menu");
	driver.findElementByAccessibilityId("Rep").click();
	Reporter.log("Clicked on Rep in Menu");

	// Click on First Name and enter Fname
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on First Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
			.sendKeys(MrepFname);
	Reporter.log("First Name is entered");

	// Click on Last Name and enter Lname

	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
			.click();
	Reporter.log("Clicked on Last Name");
	driver.findElementByXPath(
			"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
			.sendKeys(MrepLname);
	Reporter.log("Last Name is entered");
	// Apply
	driver.findElementByAccessibilityId("Apply").click();
	Reporter.log("Clicked on Apply");
	
	
	//driver.findElementByAccessibilityId(MrepFname+ MrepFname).click();
	driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,"+MrepLname+")]").click();
	Reporter.log("Drilled down on Rep");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Add line\"]").click();
	//driver.findElemetByAccessibilityId("Add line").click();
	Reporter.log("Clicked on Add Icon");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Address\"]").click();
	//driver.findElemetByAccessibilityId("Address").click();
	Reporter.log("Clicked on Address");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[1]").sendKeys("MOB_REP_ADD_DESCRIPTION:PARAMETERS:TIMESTAMP");
	Reporter.log("Entered mobile rep Address description");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[2]").sendKeys("MOB_REP_ADDRESS1_PARAMETERS:TIMESTAMP");
	Reporter.log("Entered Address line 1");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[3]").sendKeys("MOB_REP_ADDRESS2_PARAMETERS:TIMESTAMP");
	Reporter.log("Entered Address line2");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[4]").sendKeys("MOB_REP_ADDRESS3_PARAMETERS:TIMESTAMP");
	Reporter.log("Entered Address line 3");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[5]").sendKeys("MOB_REP_ADDRESS4_PARAMETERS:TIMESTAMP");
	Reporter.log("Entered Address line 4");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[6]").sendKeys("AKRON");
	Reporter.log("Entered City as AKRON");
	
	driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeTextField[7]").sendKeys("35441");
	Reporter.log("Zip has been entered");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\" \"]").click();
	Reporter.log("Click on State Field");
	
	driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Alabama\"]").click();
	Reporter.log("Selected Alabama State");
	
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Save\"]").click();
	//driver.findElementByAccessibilityId("Save").click();
	Reporter.log("Clicked on save and added Rep Address");

	
}

}
