package intellimars;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;

public class iPadPhase2 {

	public IOSDriver driver;
	public DesiredCapabilities caps;
	public MobileElement more;
	public MobileElement menu;
	public String dateofSystem;

	@BeforeTest
	@Parameters({ "app", "deviceName", "udid", "platformVersion", "xcodeOrgId", "userid", "password", "url" })
	public void setUp(String app, String deviceName, String udid, String platformVersion, String xcodeOrgId,
			String userid, String password, String url) throws MalformedURLException {
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

		// Created Object for Menu Options
		menu = (MobileElement) driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]");

	}

	@BeforeMethod
	public void waitforit() {

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test(groups = "Report", priority = 1)
	@Parameters({ "Mreportname" })
	public void reports(String Mreportname) {

		menu.click();
		driver.findElementByAccessibilityId("Reports").click();
		driver.findElementByXPath("//XCUIElementTypeOther[contains(@name, " + Mreportname + ")] /XCUIElementTypeButton")
				.click();

	}

	@Test(groups = "MProduct", priority = 2)
	@Parameters({ "mproduct" })
	public void MProduct(String mproduct) {
		menu.click();
		driver.findElementByAccessibilityId("Products").click();
		driver.findElementByAccessibilityId("Lookup").click();

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Title");
		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys(mproduct);
		Reporter.log("Enetered Product Title");
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name, " + mproduct + ")]").click();
		Reporter.log("Drilleddown on Product profile");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Assets\"]").click();
		Reporter.log("Clicked on Assets Tab");
		driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Purchases\"])[1]").click();
		Reporter.log("Clicked on Purchases Tab");
		driver.findElementByAccessibilityId("Quarterly").click();
		Reporter.log("Clicked on quaterly tab");
		driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Yearly\"])[2]").click();
		Reporter.log("Clicked on Yearly Tab");
		driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Redemptions\"])[2]").click();
		Reporter.log("Clicked on Redmetion tab");
		driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Net\"])[2]").click();
		Reporter.log("Clicked on Net tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Dashboard\"]").click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Reporter.log("Navigated to dashboard");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reps\"]").click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Reporter.log("Navigated to Reps");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Offices\"]").click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Reporter.log("Navigated to Offices");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Firms\"]").click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Reporter.log("Navigated to Firms");

	}

	@Test(groups = "Prod_topbypurchases", priority = 3)
	public void prodtopbypur() {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Product").click();
		Reporter.log("Clicked on Product");
		driver.findElementByAccessibilityId("Top By Purchases").click();
		Reporter.log("Seleceted Top by puchases");

		driver.findElementByAccessibilityId("Groups").click();
		Reporter.log("Clicked on Groups Tab");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("Types").click();
		Reporter.log("Clicked on Types Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reload line\"]]").click();
		Reporter.log("Refreshed the Page");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Map button\"]").click();
		Reporter.log("Clicked on Map icon");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back from map page");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel image\"]").click();
		Reporter.log("Clicked on filter icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel buttton");

	}

	@Test(groups = "Prod_topbyassets", priority = 4)
	public void prodtopbyassets() {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("Product").click();
		Reporter.log("Clicked on Product");
		driver.findElementByAccessibilityId("Top By Assets").click();
		Reporter.log("Seleceted Top by Assets");

		driver.findElementByAccessibilityId("Groups").click();
		Reporter.log("Clicked on Groups Tab");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("Types").click();
		Reporter.log("Clicked on Types Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Reload line\"]]").click();
		Reporter.log("Refreshed the Page");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Map button\"]").click();
		Reporter.log("Clicked on Map icon");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back from map page");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel image\"]").click();
		Reporter.log("Clicked on filter icon");
		driver.findElementByAccessibilityId("Cancel").click();
		Reporter.log("Clicked on Cancel buttton");

	}

	@Test(groups = "Star Report_quickview", priority = 5)
	public void starreportquickview() {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("STAR Report").click();
		Reporter.log("Clicked on STAR Report");
		driver.findElementByAccessibilityId("Quick View").click();
		Reporter.log("Seleceted Quick View");

		driver.findElementByAccessibilityId("bookmark line").click();
		Reporter.log("Click on bookmark line icon");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Mark profile\"]").click();
		Reporter.log("Clicked on profile");

		driver.findElementByAccessibilityId("Quarterly, not selected, Link Bar.");
		Reporter.log("Selected Quaterly Tab");
		driver.findElementByAccessibilityId(" Yearly  , not selected, Link Bar.");
		Reporter.log("Selected Yearly Tab");
		driver.findElementByAccessibilityId("Redemptions, not selected, Link Bar.");
		Reporter.log("Selected Redemptions Tab");
		driver.findElementByAccessibilityId("    Net    , not selected, Link Bar.");
		Reporter.log("Selected Net Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Teams\"]").click();
		Reporter.log("Clicked on Teams Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Activities\"]").click();
		Reporter.log("Clicked on Activities Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"History\"]").click();
		Reporter.log("Clicked on History Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sales\"]").click();
		Reporter.log("Clicked on Sales Tab");

	}

	@Test(groups = "Star Report_Summary", priority = 6)
	public void starreportsummary() {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("STAR Report").click();
		Reporter.log("Clicked on STAR Report");
		driver.findElementByAccessibilityId("Summary").click();
		Reporter.log("Selected Summary");

	}

	@Test(groups = "EISFIRM", priority = 7)
	@Parameters({ "EISFIRM" })
	public void eisfirm(String EISFIRM) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("EIS").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Firm").click();
		Reporter.log("Slected Firm in EIS");
		driver.findElementByAccessibilityId("Reload line").click();
		Reporter.log("Clicked on Refresh icon");
		driver.findElementByAccessibilityId("Reorder line").click();
		Reporter.log("Clicked on Reorder icon");
		driver.findElementByAccessibilityId("YTD Purchases").click();
		Reporter.log("Reorder by YTD Puchases is selected");
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Cliked on Done in Reorder window");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Firm Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
				.sendKeys(EISFIRM);
		Reporter.log("Entered the firm name");

		// driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"VESTOR
		// CAPITAL LLC\"])[1]");
		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + EISFIRM + ")][1]").click();
		Reporter.log("Selected the firm in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + EISFIRM + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "EISOFFICE", priority = 8)
	@Parameters({ "EISOFFICE" })
	public void eisoffice(String EISOFFICE) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("EIS").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Office").click();
		Reporter.log("Clicked on Office in EIS");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Office filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[5]/XCUIElementTypeTextField")
				.sendKeys(EISOFFICE);
		;
		Reporter.log("Enetered Office Name");

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + EISOFFICE + ")][1]").click();
		Reporter.log("Selected the firm in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + EISOFFICE + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "EISREP", priority = 9)
	@Parameters({ "EISREP" })
	public void eisrep(String EISREP) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("EIS").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Rep").click();
		Reporter.log("Clicked on Rep in EIS");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Rep Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[7]/XCUIElementTypeTextField")
				.sendKeys(EISREP);
		Reporter.log("Entered Rep name");

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + EISREP + ")][1]").click();
		Reporter.log("Selected the firm in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + EISREP + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "EISPRODUCT", priority = 10)
	@Parameters({ "EISPRODUCT" })
	public void eisproduct(String EISPRODUCT) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("EIS").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Product").click();
		Reporter.log("Clicked on Product in EIS");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[17]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[17]/XCUIElementTypeTextField")
				.sendKeys(EISPRODUCT);
		Reporter.log("Enetered product name");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + EISPRODUCT + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + EISPRODUCT + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");
	}

	@Test(groups = "EISPRODUCTGROUP", priority = 11)
	@Parameters({ "EISPRODGROUP" })
	public void eisprodgroup(String EISPRODGROUP) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("EIS").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Product Group").click();
		Reporter.log("Clicked on Product Group in EIS");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[23]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Group Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[23]/XCUIElementTypeTextField")
				.sendKeys(EISPRODGROUP);
		Reporter.log("Enetered Product Group");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + EISPRODGROUP + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + EISPRODGROUP + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "EISPRODUCTTYPE", priority = 12)
	@Parameters({ "EISPRODUCTTYPE" })
	public void eisprodtype(String EISPRODUCTTYPE) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("EIS").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Product Type").click();
		Reporter.log("Clicked on Product Group in EIS");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[21]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Type Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[21]/XCUIElementTypeTextField")
				.sendKeys(EISPRODUCTTYPE);
		Reporter.log("Entered Product Type");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + EISPRODUCTTYPE + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + EISPRODUCTTYPE + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "EISCHANNEL", priority = 13)
	@Parameters({ "EISCHANNEL" })
	public void eischannel(String EISCHANNEL) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("EIS").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Channel").click();
		Reporter.log("Clicked on Product Group in EIS");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Channel Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeTextField")
				.sendKeys(EISCHANNEL);
		Reporter.log("Entered Channel Filter");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + EISCHANNEL + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + EISCHANNEL + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "EISTERRITORY", priority = 13)
	@Parameters({ "EISTERRITORY" })
	public void eisterritory(String EISTERRITORY) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("EIS").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Territory").click();
		Reporter.log("Clicked on Product Group in EIS");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[11]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Territory Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[11]/XCUIElementTypeTextField")
				.sendKeys("Bank Central");
		Reporter.log("Enetered Territory Filter");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + EISTERRITORY + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + EISTERRITORY + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");
	}

	@Test(groups = "EISWHOLESALER", priority = 14)
	@Parameters({ "EISWHOLESALER" })
	public void eiswholesaler(String EISWHOLESALER) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("EIS").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Wholesaler").click();
		Reporter.log("Clicked on Product Group in EIS");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

	}

	@Test(groups = "ETRFIRM", priority = 14)
	@Parameters({ "ETRFIRM" })
	public void etrfirm(String ETRFIRM) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Firm").click();
		Reporter.log("Clicked on Firm in ETR");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Firm Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[9]/XCUIElementTypeTextField")
				.sendKeys(ETRFIRM);
		Reporter.log("Entered Firm Name");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRFIRM + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRFIRM + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETROFFICE", priority = 14)
	@Parameters({ "ETROFFICE" })
	public void etroffice(String ETROFFICE) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Office").click();
		Reporter.log("Clicked on Office in ETR");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[11]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Office Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[11]/XCUIElementTypeTextField")
				.sendKeys(ETROFFICE);
		Reporter.log("Enetered the Office Name");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETROFFICE + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETROFFICE + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRREP", priority = 14)
	@Parameters({ "ETRREP" })
	public void etrrep(String ETRREP) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Rep").click();
		Reporter.log("Clicked on Rep in ETR");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[13]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Rep Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[13]/XCUIElementTypeTextField")
				.sendKeys(ETRREP);
		Reporter.log("Entered Rep Name");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRREP + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRREP + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRPROD", priority = 15)
	@Parameters({ "ETRPROD" })
	public void etrprod(String ETRPROD) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Product").click();
		Reporter.log("Clicked on Product Group in ETR");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[23]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[23]/XCUIElementTypeTextField")
				.sendKeys(ETRPROD);
		Reporter.log("Entered Product Name");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRPROD + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRPROD + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRPRODGRP", priority = 16)
	@Parameters({ "ETRPRODGRP" })
	public void etrprodgrp(String ETRPRODGRP) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Product Group").click();
		Reporter.log("Clicked on Product Group in ETR");

		// NEED TO SWIPE DOWN

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[29]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Group Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[29]/XCUIElementTypeTextField")
				.sendKeys(ETRPRODGRP);
		Reporter.log("Entered Product Group");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRPRODGRP + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRPRODGRP + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRPRODTYP", priority = 17)
	@Parameters({ "ETRPRODTYP" })
	public void etrprodtyp(String ETRPRODTYP) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Product Type").click();
		Reporter.log("Clicked on Product Type in ETR");

		// NEED TO SWIPE DOWN

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[25]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Product Type Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[25]/XCUIElementTypeTextField")
				.sendKeys(ETRPRODTYP);
		Reporter.log("Entered Product Type");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRPRODTYP + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRPRODTYP + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRCHANNEL", priority = 18)
	@Parameters({ "ETRCHANNEL" })
	public void etrchannel(String ETRCHANNEL) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Channel").click();
		Reporter.log("Clicked on Product Type in ETR");

		// NEED TO SWIPE DOWN

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[15]/XCUIElementTypeButton")
				.click();
		Reporter.log("Clicked on Channel Filter");

		driver.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[15]/XCUIElementTypeTextField")
				.sendKeys(ETRCHANNEL);
		Reporter.log("Entered Channel Name");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRCHANNEL + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRCHANNEL + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRTERR", priority = 19)
	@Parameters({ "ETRTERR" })
	public void etrterr(String ETRTERR) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Territory").click();
		Reporter.log("Clicked on Product Type in ETR");

		// NEED TO SWIPE DOWN

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Territory\"]//preceding::XCUIElementTypeButton[1]").click();
		Reporter.log("Clicked on Territory filter");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Territory\"]/following::XCUIElementTypeTextField")
				.sendKeys(ETRTERR);
		Reporter.log("Entered Territory name");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRTERR + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRTERR + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRWHOLESALER", priority = 19)
	@Parameters({ "ETRWHOLESALER" })
	public void etrwholesaler(String ETRWHOLESALER) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Territory").click();
		Reporter.log("Clicked on Product Type in ETR");

		// NEED TO SWIPE DOWN

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Wholesaler\"]//preceding::XCUIElementTypeButton[1]").click();
		Reporter.log("Clicked on Wholesaler filter");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Territory\"]/following::XCUIElementTypeTextField")
				.sendKeys(ETRWHOLESALER);
		Reporter.log("Enetered Wholesaler Name");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRWHOLESALER + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRWHOLESALER + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRASSETCLASS", priority = 19)
	@Parameters({ "ETRASSETCLASS" })
	public void assetClass(String ETRASSETCLASS) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Assets Class").click();
		Reporter.log("Clicked on Assets Class in ETR");

		// NEED TO SWIPE DOWN

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Assets Class\"]//preceding::XCUIElementTypeButton[1]").click();
		Reporter.log("Clicked on Assets Class filter");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Assets Class\"]/following::XCUIElementTypeTextField")
				.sendKeys(ETRASSETCLASS);
		Reporter.log("Entered Assets Class");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRASSETCLASS + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRASSETCLASS + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRASSETSCLASS", priority = 20)
	@Parameters({ "ETRASSETSCLASS" })
	public void assetSClass(String ETRASSETSCLASS) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Assets Sub Class").click();
		Reporter.log("Clicked on Assets Sub Class in ETR");

		// NEED TO SWIPE DOWN

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Assets Sub Class\"]//preceding::XCUIElementTypeButton[1]").click();
		Reporter.log("Clicked on Assets Sub Class filter");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Assets Sub Class\"]/following::XCUIElementTypeTextField")
				.sendKeys(ETRASSETSCLASS);
		Reporter.log("Entered Assets Sub Class");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRASSETSCLASS + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRASSETSCLASS + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "ETRPLATFORMCODE", priority = 20)
	@Parameters({ "ETRPLATFORMCODE" })
	public void etrplatformcode(String ETRPLATFORMCODE) {

		menu.click();
		Reporter.log("Clicked on Menu");
		driver.findElementByAccessibilityId("ETR").click();
		Reporter.log("Selected EIS on Menu");
		driver.findElementByAccessibilityId("Platform Code").click();
		Reporter.log("Clicked on Platform Code in ETR");

		// NEED TO SWIPE DOWN

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Funnel line\"]").click();
		Reporter.log("Clicked on funnel icon");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Platform Code\"]//preceding::XCUIElementTypeButton[1]").click();
		Reporter.log("Clicked on Platform code filter");

		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name=\"Platform Code\"]/following::XCUIElementTypeTextField")
				.sendKeys(ETRPLATFORMCODE);
		Reporter.log("Entered Platofrm Code");

		boolean isKeyboardShown = driver.isKeyboardShown();

		if (isKeyboardShown) {

			driver.hideKeyboard();

		}

		driver.findElementByXPath("(//XCUIElementTypeStaticText[contains(@name," + ETRPLATFORMCODE + ")][1]").click();
		Reporter.log("Selected the Product in filter");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]").click();
		Reporter.log("Clicked on done");

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Apply\"]").click();
		Reporter.log("Clicked on Apply");

		driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name," + ETRPLATFORMCODE + ")]").isDisplayed();
		Reporter.log("Verified if Firm is displayed");

	}

	@Test(groups = "Global Search Firm", priority = 21)
	@Parameters({ "MFIRM" })
	public void globalsearchfirm(String MFIRM) {

		menu.click();
		Reporter.log("Clicked on Menu");

		driver.findElementByAccessibilityId("Global Search").sendKeys(MFIRM);
		Reporter.log("Searched with Firm Name");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Reporter.log("Wait for Page to load");
		// READ OUT FINANCES
		// ACKWORTH FIN CORP, STE 225 E ST
		// SCHEIBEL PAUL
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Cards\"]").click();
		// driver.findElementByAccessibilityId("Cards").click();
		Reporter.log("CLicked on Cards Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Offices\"]").click();
		// driver.findElementByAccessibilityId("Offices").click();
		Reporter.log("Cliked on Offices Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Firms\"]").click();
		// driver.findElementByAccessibilityId("Firms").click();
		Reporter.log("Clicked on Firms Tab");

		driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"READ OUT FINANCES\"])[1]");
		Reporter.log("Verify if firm is Shown");

		driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"READ OUT FINANCES\"])[1]").click();
		Reporter.log("Drilled down on Firm");
		driver.findElementByAccessibilityId("Firm Profile").click();
		Reporter.log("Clicked on Firm Porfile in Opened menu");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back from map page");

	}

	@Test(groups = "Global Search Office", priority = 22)
	@Parameters({ "MOFFICE" })
	public void globalsearchoffice(String MOFFICE) {

		menu.click();
		Reporter.log("Clicked on Menu");

		driver.findElementByAccessibilityId("Global Search").sendKeys(MOFFICE);
		Reporter.log("Searched with Firm Name");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Reporter.log("Wait for Page to load");
		// READ OUT FINANCES
		// ACKWORTH FIN CORP, STE 225 E ST
		// SCHEIBEL PAUL
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Cards\"]").click();
		// driver.findElementByAccessibilityId("Cards").click();
		Reporter.log("CLicked on Cards Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Offices\"]").click();
		// driver.findElementByAccessibilityId("Offices").click();
		Reporter.log("Cliked on Offices Tab");

		driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=" + MOFFICE + "])[1]");
		Reporter.log("Verify if Office is Shown");

		driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=" + MOFFICE + "])[1]").click();
		Reporter.log("Drilled down on Office");
		driver.findElementByAccessibilityId("Office Profile").click();
		Reporter.log("Clicked on Office Porfile in Opened menu");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back from map page");

	}

	@Test(groups = "Global Search Rep", priority = 23)
	@Parameters({ "MREP" })
	public void globalsearchrep(String MREP) {

		menu.click();
		Reporter.log("Clicked on Menu");

		driver.findElementByAccessibilityId("Global Search").sendKeys(MREP);
		Reporter.log("Searched with Firm Name");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Reporter.log("Wait for Page to load");
		// READ OUT FINANCES
		// ACKWORTH FIN CORP, STE 225 E ST
		// SCHEIBEL PAUL
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Cards\"]").click();
		// driver.findElementByAccessibilityId("Cards").click();
		Reporter.log("CLicked on Cards Tab");

		driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=" + MREP + "])[1]");
		Reporter.log("Verify if Rep is Shown");

		driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=" + MREP + "])[1]").click();
		Reporter.log("Drilled down on Rep");
		driver.findElementByAccessibilityId("Rep Profile").click();
		Reporter.log("Clicked on Office Porfile in Opened menu");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back from map page");

	}

	@Test(groups = "Favorites", priority = 24)
	public void fav() {

		menu.click();
		Reporter.log("Clicked on Menu");

		driver.findElementByAccessibilityId("My Favorites").click();
		Reporter.log("Clicked on My Favorites");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Icon View\"]").click();
		// driver.findElementByAccessibilityId("Icon View").click();
		Reporter.log("Clicked on Icon View Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Grid View\"]").click();
		// driver.findElementByAccessibilityId("Grid View");
		Reporter.log("Clicked on Grid View Tab");

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"BackArrow line\"]").click();
		Reporter.log("Navigated back from map page");

	}
}
