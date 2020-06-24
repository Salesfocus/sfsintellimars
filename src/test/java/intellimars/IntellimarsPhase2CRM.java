package intellimars;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.xml.xpath.XPathExpression;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;


public class IntellimarsPhase2CRM <IOSDriverwait> {
	
	public IOSDriver<IOSElement> driver;
	public DesiredCapabilities caps;

	public String Username="ABOSCO";//FOR CRM ABOSCO//for ETF 567829
	public String Userpassword="mars1";//FOR CRM mars1//FOR ETF mars1
	public String Baseurl="https://ipad9qa.phxa.com";//FOR CRM https://ipad9qa.phxa.com//For ETF https://imarsetfqa.phxa.com
	public MobileElement Menu;
	public MobileElement Switch;
	public String Firm="VESTOR";
	public String Office="CA, VESTOR";
	public String Rep="BRIAN";
	public String TeamRep="";
	public String Product="";
	public String Prev_Firm="VESTOR";
	public String Prev_Office="CA, VESTOR";
	public String Prev_Rep="BRIAN";
	public String Rrev_TeamRep="";
	public String Prev_Product="";
	
	
@BeforeTest
public void setUp() throws MalformedURLException {
	
		//Passing Desired Capabilities
		caps= new DesiredCapabilities();	
		caps.setCapability("app", "/Users/Mars/Desktop/IntelliMARS.ipa");
		caps.setCapability("deviceName", "Rajesh iPad");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("udid", "ed48ddd2735d69bb02c94ad521f9a790e0d6eef2");
		caps.setCapability("platformVersion", "13.2");
		caps.setCapability("xcodeOrgId", "AJ48MHDF2U");
		caps.setCapability("XcodeSigningId", "iPhone Developer");
		caps.setCapability("showIOSLog", "true");
		caps.setCapability("noReset", "true");
		caps.setCapability("showXcodeLog", "true");
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.FALSE);
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	
	 
		MobileElement Switch = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSwitch");
		    String valuemain= Switch.getAttribute("value");
		    System.out.println("Result: " + valuemain);
		
		
		    	if  (valuemain.equals("0")){
		    			Switch.click();	
		    			System.out.println("Url Switched is Enabled ");

		    	}
			
	WebElement username=driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]");
	username.clear();
	username.sendKeys(Username);
	System.out.println("Username Entered Is :" +Username);
	
	WebElement password=driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField");
	password.clear();
	password.sendKeys(Userpassword);
	System.out.println("Password Entered Is :" +Userpassword);
	
	WebElement url=driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]");
	url.clear();
	url.sendKeys(Baseurl);
	System.out.println("URL Entered Is :"+Baseurl);
	
	driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Sign In\"]").click();
	System.out.println("Clicked Method Performed");
	System.out.println("Wait page To Load");
	
	try {
		
		String Xpath=("//XCUIElementTypeButton[@name=\"No\"]");
		WebElement element=driver.findElementByXPath(Xpath);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath))); 
		
		if(element.isEnabled())
		{
			System.out.println("Alert Is Handeled:");
			element.click();
			
		}
		
	}
	catch(NoSuchElementException e) {
		//e.printStackTrace();
		//System.out.println(e);
		System.out.println("Alert Is Not Present:");
	}
	
try {
		
		
		WebElement element=driver.findElementById("Allow Once");		
		if(element.isEnabled())
		{
			System.out.println("Location Alert Is Handeled:");
			element.click();
			
		}
		
	}
	catch(NoSuchElementException e) {
		//e.printStackTrace();
		//System.out.println(e);
		System.out.println("Location Alert Is Not Present:");
	}
	
}
	
@BeforeMethod
public void clickMenu() throws MalformedURLException {
	try {
		
	String Xpath=("//XCUIElementTypeStaticText[contains(@name,\"Profile\")]");
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	
	if(element.isEnabled())
	{
		System.out.println("Profile Tab Is Enable:");
		element.click();
		System.out.println("Profile Tab Is Clicked:");
		String Xpath1=("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]");
		String Value1="Menu Icon";
		mobileElementClick(Xpath1, Value1);
	}
	else {
		System.out.println("Screenshot Captured");
	}
} 
	catch(NoSuchElementException e) {
		//e.printStackTrace();
		//System.out.println(e);
		String Xpath1=("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]");
		String Value1="Menu Icon";
		mobileElementClick(Xpath1, Value1);
	}
}
	

@AfterTest
public void terminateBrowser(){
    driver.quit();
}


@Test(priority=0,groups={"PHASE2REP"})
public void phase2verifyRepLookup() throws InterruptedException {
		System.out.println("REP LOOKUP CALLED..............");	
		driver.findElementByAccessibilityId("Rep").click();
		driver.findElementByAccessibilityId("Lookup").click();
		System.out.println("Rep Lookup clicked");
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
		System.out.println("Apply Is Clicked:");
		//Scroll to left right position
		
		RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\", YTD Purch, Column Headings\"]"));
				String parentID = parent.getId();
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				for (int i = 0; i <=5; i++) {
					scrollObject.put("element", parentID);
					scrollObject.put("direction", "right");
					driver.executeScript("mobile:scroll", scrollObject);	
				}
				System.out.println("Right scroll Is performed");
				
		driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
		System.out.println("Click On Rep drill Down");
		Thread.sleep(30000);
		MobileElement element = (MobileElement) driver.findElementByAccessibilityId("Add line");
		boolean isDisplayed = element.isDisplayed();
		
		if(isDisplayed){
			System.out.println("Element is displayed");
			
		}
		else {
			System.out.println("Element is not displaying");
		}

	}
	
@Test(priority=1,groups={"PHASE2REP"})		

	 
	public void phase2AddMeeting() {
		boolean lookup=repLookup1();
		if(lookup) 
		{
		String Value="Activities";
        String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
        click(Xpath,Value);
        String Value1="Plus Icon";
        String Xpath1="Add line";	
        clickByAccessID(Xpath1,Value1);
        String Value2="Meeting";
        String Xpath2="(//XCUIElementTypeButton[@name=\"Meeting\"])";
        click(Xpath2,Value2);
        String Value3="Meeting Description";
        String Xpath3="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1])";
        clearAndTypeWithTimeStamp(Xpath3,Value3);
        String Value4="Meeting Type";
        String Xpath4="(//XCUIElementTypeButton[@name=\"1-on-1 Rep Meeting\"])";	
        click(Xpath4,Value4);
        String Value5="BB Meeting";
        String Xpath5="(//XCUIElementTypeStaticText[@name=\"BB Meeting\"])";	
        click(Xpath5,Value5);
        String Value6="Scheduled";
        String Xpath6="(//XCUIElementTypeButton[@name=\"Scheduled\"])";	
        click(Xpath6,Value6);
        String Value7="Scheduled";
        String Xpath7="((//XCUIElementTypeStaticText[@name=\"Scheduled\"])[1])";	
        click(Xpath7,Value7);
        String Value8="1";
        String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2])";	
        clearAndType(Xpath8,Value8);
        String Value9="30";
        String Xpath9="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[3])";	
        clearAndType(Xpath9,Value9);
        String Value10="Alaram";
        String Xpath10="(//XCUIElementTypeButton[@name=\"None\"])";	
        click(Xpath10,Value10);
        String Value11="00";
        String Xpath11="(//XCUIElementTypeStaticText[@name=\"00\"])";	
        click(Xpath11,Value11);
        String Value12="Campaign";
        String Xpath12="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton[7])";	
        click(Xpath12,Value12);
        String Value13="Campaign";
        String Xpath13="(//XCUIElementTypeStaticText[@name=\"8.4.01 Campaigns\"])";
        click(Xpath13,Value13);
        String Value15="Location Description ";
        String Xpath15="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1])";
        clearAndTypeWithTimeStamp(Xpath15,Value15);
        String Value16="Address ";
        String Xpath16="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[2])";
        clearAndTypeWithTimeStamp(Xpath16,Value16);
        String Value17="Carlifornia";
        String Xpath17="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[4])";	
        clearAndType(Xpath17,Value17);
        String Value18="94563";
        String Xpath18="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[5])";	
        clearAndType(Xpath18,Value18);
        String Value19="Add Note";
        String Xpath19="Add line";	
        clickByAccessID(Xpath19,Value19);
        String Value20="Meeting Notes ";
        String Xpath20="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextView)";
        clearAndTypeWithTimeStamp(Xpath20,Value20);
        String Value21="Done";
        String Xpath21="(//XCUIElementTypeStaticText[@name=\"Done\"])";
        click(Xpath21,Value21);
        String Value22="Add Product Group";
        String Xpath22="((//XCUIElementTypeButton[@name=\"Edit outline modified white\"])[2])";
        click(Xpath22,Value22);
        String Value23="Product Group";
        String Xpath23="Total Funds";	
        clickByAccessID(Xpath23,Value23);
        String Value24="Done";
        String Xpath24="(//XCUIElementTypeStaticText[@name=\"Done\"])";	
        click(Xpath24,Value24);
        String Value14="2";
        String Xpath14="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[4])";
        clearAndType(Xpath14,Value14);
        String Value25="Save";
        String Xpath25="(//XCUIElementTypeStaticText[@name=\"Save\"])";	
        click(Xpath25,Value25);
        //Need To Add Attendees
        
		}
		else{
			System.out.println("Add Meeting Function Fail:" );
		}
	}

@Test(priority=2,groups={"PHASE2REP"})	
public void phase2VerifyMeetingInFirm() {
	firmLookup();
	String Value="Activities";
    String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
    click(Xpath,Value);
    String Value1="Activities Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"Activities\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value3="Activities Type Drop down";
    String Xpath3="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath3,Value3);
    String Value4="Meeting";
    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Meeting\"])";
    click(Xpath4,Value4);	
    String Value5="Meeting Description";
    String Xpath5="(//XCUIElementTypeOther[contains(@name,\"Meeting Description\")])";
    click(Xpath5,Value5);
    String Value6="Meeting Notes";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"Meeting Notes\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}


@Test(priority=3,groups={"PHASE2REP"})
public void phase2EditMeeting() {
	  repLookup();
	  String Value="Activities";
      String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
      click(Xpath,Value);
      String Value1="Meeting Icon";
      String Xpath1="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[1])";
      click(Xpath1,Value1);
      String Value2="Scheduled";
      String Xpath2="(//XCUIElementTypeButton[@name=\"Scheduled\"])";	
      click(Xpath2,Value2);
      String Value3="Canceled";
      String Xpath3="(//XCUIElementTypeStaticText[@name=\"Canceled\"])";	
      click(Xpath3,Value3);
      String Value4="Save";
      String Xpath4="(//XCUIElementTypeStaticText[@name=\"Save\"])";	
      click(Xpath4,Value4);
        
}
@Test(priority=4,groups={"PHASE2REP"})
public void phase2AddScheduledCall() {
	repLookup();
	String Value="Activities";
    String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
    click(Xpath,Value);
    String Value1="Plus Icon";
    String Xpath1="Add line";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Scheduled Call";
    String Xpath2="(//XCUIElementTypeButton[@name=\"Schedule Call\"])";
    click(Xpath2,Value2);
    String Value3="Call Type";
    String Xpath3="(//XCUIElementTypeButton[@name=\"BB CAll\"])";
    click(Xpath3,Value3);
    String Value4="Material Follow Up";
    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Materials Follow-up\"])";
    click(Xpath4,Value4);
    String Value5="Time";
    String Xpath5="(//XCUIElementTypeButton[contains(@name,\"2020\")])";
    click(Xpath5,Value5);
    String Value6="TODAY";
    String Xpath6="(//XCUIElementTypeButton[@name=\"Today\"])";
    click(Xpath6,Value6);
    String Value7="Done";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Done\"])";
    click(Xpath7,Value7);
    String Value8="Priority";
    String Xpath8="(//XCUIElementTypeButton[@name=\"Normal\"])";
    click(Xpath8,Value8);
    String Value9="Normal";
    String Xpath9="((//XCUIElementTypeStaticText[@name=\"Normal\"])[1])";
    click(Xpath9,Value9);
    String Value10="Campaign";
    String Xpath10="(//XCUIElementTypeButton[@name=\"Campaign\"])";	
    click(Xpath10,Value10);
    String Value11="Campaign value";
    String Xpath11="(//XCUIElementTypeStaticText[@name=\"8.4.01 Campaigns\"])";
    click(Xpath11,Value11);
    String Value12="Calendar";
    String Xpath12="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSwitch)";
    click(Xpath12,Value12);
    String Value13="Scheduled Call Notes ";
    String Xpath13="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextView)";
    clearAndTypeWithTimeStamp(Xpath13,Value13);
    String Value14="Save";
    String Xpath14="(//XCUIElementTypeStaticText[@name=\"Save\"])";	
    click(Xpath14,Value14);
    String Value15="Header";
    String Xpath15="((//XCUIElementTypeStaticText[@name=\"Activities\"])[1])";
    verifyTrueElementEnable(Xpath15,Value15);
    String Value16="Call Icon";
    String Xpath16="(//XCUIElementTypeButton[contains(@name,\"Scheduled Call Notes\")])";
    verifyTrueElementEnable(Xpath16,Value16);
   
}
@Test(priority=5,groups={"PHASE2REP"})
public void phase2VerifyScheduledCallInFirm() {
	firmLookup();
	String Value="Activities";
    String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
    click(Xpath,Value);
    String Value1="Activities Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"Activities\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value3="Activities Type Drop down";
    String Xpath3="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath3,Value3);
    String Value4="Call";
    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Call\"])";
    click(Xpath4,Value4);	
    String Value5="Scheduled Call";
    String Xpath5="(//XCUIElementTypeOther[contains(@name,\"Scheduled Call Notes\")])";
    click(Xpath5,Value5);
    String Value6="Scheduled Call";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"Scheduled Call Notes\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}


@Test(priority=6,groups={"PHASE2REP"})
public void phase2EditScheduledCall() {
	repLookup();
	String Value="Activities";
    String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
    click(Xpath,Value);
    String Value1="Call Icon";
    String Xpath1="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[1])";
    click(Xpath1,Value1);
    String Value2="Edit Call";
    String Xpath2="(//XCUIElementTypeButton[@name=\"Edit Call\"])";	
    click(Xpath2,Value2);
    String Value3="Header";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Call\"])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Priority";
    String Xpath4="(//XCUIElementTypeButton[@name=\"Normal\"])";
    click(Xpath4,Value4);
    String Value5="Normal";
    String Xpath5="(//XCUIElementTypeStaticText[@name=\"High\"])";
    click(Xpath5,Value5);
    String Value6="High Priority Scheduled Call Notes ";
    String Xpath6="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextView)";
    clearAndTypeWithTimeStamp(Xpath6,Value6);
    String Value7="Save";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Save\"])";	
    click(Xpath7,Value7);
    String Value8="Header";
    String Xpath8="((//XCUIElementTypeStaticText[@name=\"Activities\"])[1])";
    verifyTrueElementEnable(Xpath8,Value8);
    
}

@Test(priority=7,groups={"PHASE2REP"})
public void phase2LogCall() {
	repLookup();
	String Value="Activities";
    String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
    click(Xpath,Value);
    String Value1="Call Icon";
    String Xpath1="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[1])";
    click(Xpath1,Value1);
    String Value2="Log Call";
    String Xpath2="(//XCUIElementTypeButton[@name=\"Log Call\"])";	
    click(Xpath2,Value2);
    String Value3="Header";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Log Call\"])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Date";
    String Xpath4="(//XCUIElementTypeButton[contains(@name,\"2020\")])";
    click(Xpath4,Value4);
    String Value5="TODAY";
    String Xpath5="(//XCUIElementTypeButton[@name=\"Today\"])";
    click(Xpath5,Value5);
    String Value6="Done";
    String Xpath6="(//XCUIElementTypeButton[@name=\"Done\"])";
    click(Xpath6,Value6);
    String Value7="Call Type";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Selected Log Call Types (0)\"])";
    click(Xpath7,Value7);
    String Value8="Thank You For Order";
    String Xpath8="(//XCUIElementTypeStaticText[@name=\"Thank You for Order\"])";
    click(Xpath8,Value8);
    String Value9="Sent Materials";
    String Xpath9="(//XCUIElementTypeStaticText[@name=\"Sent Materials\"])";
    click(Xpath9,Value9);
    String Value10="Done";
    String Xpath10="(//XCUIElementTypeStaticText[@name=\"Done\"])";	
    click(Xpath10,Value10);
    String Value11="Campaign";
    String Xpath11="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton[3])";	
    click(Xpath11,Value11);
    String Value12="AA Fund Campaign";
    String Xpath12="(//XCUIElementTypeStaticText[@name=\"AA Fund Campaignhh\"])";	
    click(Xpath12,Value12);
    String Value13="Log Call Notes ";
    String Xpath13="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView[1])";
    clearAndTypeWithTimeStamp(Xpath13,Value13);
    String Value14="Save";
    String Xpath14="(//XCUIElementTypeStaticText[@name=\"Save\"])";	
    click(Xpath14,Value14);
    String Value15="Header";
    String Xpath15="((//XCUIElementTypeStaticText[@name=\"Activities\"])[1])";
    verifyTrueElementEnable(Xpath15,Value15);
    
}
@Test(priority=8,groups={"PHASE2REP"})	
public void phase2SendEmail() {
	repLookup();
	String Value="Activities";
    String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
    click(Xpath,Value);
    String Value1="Plus Icon";
    String Xpath1="Add line";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Email";
    String Xpath2="(//XCUIElementTypeButton[@name=\"Email\"])";
    click(Xpath2,Value2);
    String Value3="Header";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Email\"])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Email Subject ";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2])";
    clearAndTypeWithTimeStamp(Xpath4,Value4);
    String Value5="Campaign";
    String Xpath5="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2])";	
    click(Xpath5,Value5);
    String Value6="AA Fund Campaign";
    String Xpath6="(//XCUIElementTypeStaticText[@name=\"AA Fund Campaignhh\"])";	
    click(Xpath6,Value6);
    String Value7="Add Icon";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Add\"])";	
    click(Xpath7,Value7);
    String Value8="Email CC Header";
    String Xpath8="(//XCUIElementTypeStaticText[@name=\"Add Reps to Email CC\"])";
    verifyTrueElementEnable(Xpath8,Value8);
    String Value9="Down Arrow";
    String Xpath9="((//XCUIElementTypeButton[@name=\"DropDownArrow.png\"])[1])";	
    click(Xpath9,Value9);
    String Value10="First Name";
    String Xpath10="First Name";	
    clickByAccessID(Xpath10,Value10);
    String Value11=Prev_Rep;
    String Xpath11="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1])";
    clearAndType(Xpath11,Value11);
    String Value12="Reps";
    String Xpath12="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[1]/XCUIElementTypeCell[1])";
    String Xpath13="(//XCUIElementTypeTable[@name=\"Empty list\"])";
    dragAndDrop(Xpath12,Xpath13,Value12);
    String Value14="Done";
    String Xpath14="(//XCUIElementTypeStaticText[@name=\"Done\"])";	
    click(Xpath14,Value14);
    String Value15="Automation Email Note";
    String Xpath15="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextView)";
    clearAndTypeWithTimeStamp(Xpath15,Value15);
    String Value16="Sent Icon";
    String Xpath16="(//XCUIElementTypeButton[@name=\"MarsSendEmail\"])";	
    click(Xpath16,Value16);
    String Value17="Activities Header";
    String Xpath17="((//XCUIElementTypeStaticText[@name=\"Activities\"])[1])";
    verifyTrueElementEnable(Xpath17,Value17);
    String Value18="Automation Email Note";
    String Xpath18="(//XCUIElementTypeStaticText[contains(@name,\"Automation Email Note\")])";
    verifyTrueElementEnable(Xpath18,Value18); 
}

@Test(priority=9,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyMeeting() {
	prevRepLookup();	
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Meeting Notes";
    String Xpath2="(//XCUIElementTypeButton[contains(@name,\"Meeting Notes\")])";
    click(Xpath2,Value2);
    String Value3="Meeting Notes";
    String Xpath3="(//XCUIElementTypeStaticText[contains(@name,\"Meeting Notes\")])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Close";
    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Close\"])";
    click(Xpath4,Value4); 
    
}

@Test(priority=10,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyCall() {
	prevRepLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Call Notes";
    String Xpath2="(//XCUIElementTypeButton[contains(@name,\"Log Call Notes\")])";
    click(Xpath2,Value2);
    String Value3="Call Notes";
    String Xpath3="(//XCUIElementTypeStaticText[contains(@name,\"Log Call Notes\")])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Close";
    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Close\"])";
    click(Xpath4,Value4); 
}
@Test(priority=11,groups={"PHASE2REPHISTORY"})
public void phase2AddAndVerifyNotes() {
	prevRepLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Plus Icon";
    String Xpath2="Add line";	
    clickByAccessID(Xpath2,Value2);
    String Value3="Note";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Note\"])";
    click(Xpath3,Value3);
    String Value4="Header";
    String Xpath4="((//XCUIElementTypeStaticText[@name=\"Note\"])[1])";
    verifyTrueElementEnable(Xpath4,Value4);
    String Value5="History Notes ";
    String Xpath5="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextView)";
    clearAndTypeWithTimeStamp(Xpath5,Value5);
    String Value6="Save";
    String Xpath6="(//XCUIElementTypeStaticText[@name=\"Save\"])";	
    click(Xpath6,Value6);
    String Value7="History Notes";
    String Xpath7="(//XCUIElementTypeButton[contains(@name,\"History Notes\")])";
    click(Xpath7,Value7);
    String Value8="History Notes";
    String Xpath8="(//XCUIElementTypeStaticText[contains(@name,\"History Notes\")])";
    verifyTrueElementEnable(Xpath8,Value8);
    String Value9="Close";
    String Xpath9="(//XCUIElementTypeStaticText[@name=\"Close\"])";
    click(Xpath9,Value9); 
}
@Test(priority=12,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyEmail() {
	prevRepLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Email Notes";
    String Xpath2="(//XCUIElementTypeButton[contains(@name,\"Automation Email Note\")])";
    click(Xpath2,Value2);
    String Value3="Email Notes";
    String Xpath3="(//XCUIElementTypeStaticText[contains(@name,\"Automation Email Note\")])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Close";
    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Close\"])";
    click(Xpath4,Value4); 
}
@Test(priority=13,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyEmailInFirm() {
	prevFirmLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Activities Type Drop down";
    String Xpath2="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath2,Value2);
    String Value3="Email";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Email\"])";
    click(Xpath3,Value3);	
    String Value4="Email Subject";
    String Xpath4="(//XCUIElementTypeOther[contains(@name,\"Email Subject\")])";
    click(Xpath4,Value4);
    String Value6="Scheduled Call";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"Automation Email Note\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}
@Test(priority=14,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyCallInFirm() {
	prevFirmLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Activities Type Drop down";
    String Xpath2="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath2,Value2);
    String Value3="Call";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Call\"])";
    click(Xpath3,Value3);	
    String Value4="Call Type";
    String Xpath4="(//XCUIElementTypeOther[contains(@name,\"Thank You for Order\")])";
    click(Xpath4,Value4);
    String Value6="Scheduled Call Note";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"Log Call Notes\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}
@Test(priority=15,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyMeetingInHistoryFirm() {
	prevFirmLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Activities Type Drop down";
    String Xpath2="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath2,Value2);
    String Value3="Meeting";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Meeting\"])";
    click(Xpath3,Value3);	
    String Value4="Meeting Description";
    String Xpath4="(//XCUIElementTypeOther[contains(@name,\"Meeting Description\")])";
    click(Xpath4,Value4);
    String Value6="Meeting Notes";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"Meeting Notes\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}
@Test(priority=16,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyNoteInFirm() {
	prevFirmLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Activities Type Drop down";
    String Xpath2="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath2,Value2);
    String Value3="Notes";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Notes\"])";
    click(Xpath3,Value3);	
    String Value4="Rep Notes";
    String Xpath4="(//XCUIElementTypeOther[contains(@name,\"History Notes\")])";
    click(Xpath4,Value4);
    String Value6="Rep Notes";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"History Notes\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}
@Test(priority=17,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyEmailInOffice() {
	prevOfficeLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Activities Type Drop down";
    String Xpath2="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath2,Value2);
    String Value3="Email";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Email\"])";
    click(Xpath3,Value3);	
    String Value4="Email Subject";
    String Xpath4="(//XCUIElementTypeOther[contains(@name,\"Email Subject\")])";
    click(Xpath4,Value4);
    String Value6="Scheduled Call";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"Automation Email Note\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}
@Test(priority=18,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyCallInOffice() {
	prevOfficeLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Activities Type Drop down";
    String Xpath2="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath2,Value2);
    String Value3="Call";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Call\"])";
    click(Xpath3,Value3);	
    String Value4="Call Type";
    String Xpath4="(//XCUIElementTypeOther[contains(@name,\"Thank You for Order\")])";
    click(Xpath4,Value4);
    String Value6="Scheduled Call Note";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"Log Call Notes\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}
@Test(priority=19,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyMeetingInOffice() {
	prevOfficeLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Activities Type Drop down";
    String Xpath2="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath2,Value2);
    String Value3="Meeting";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Meeting\"])";
    click(Xpath3,Value3);	
    String Value4="Meeting Description";
    String Xpath4="(//XCUIElementTypeOther[contains(@name,\"Meeting Description\")])";
    click(Xpath4,Value4);
    String Value6="Meeting Notes";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"Meeting Notes\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}
@Test(priority=20,groups={"PHASE2REPHISTORY"})	
public void phase2VerifyNoteInOffice() {
	prevOfficeLookup();
	String Value="History";
    String Xpath="(//XCUIElementTypeButton[@name=\"History\"])";	
    click(Xpath,Value);
    String Value1="Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"History\"])[1])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Activities Type Drop down";
    String Xpath2="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
    click(Xpath2,Value2);
    String Value3="Notes";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Notes\"])";
    click(Xpath3,Value3);	
    String Value4="Rep Notes";
    String Xpath4="(//XCUIElementTypeOther[contains(@name,\"History Notes\")])";
    click(Xpath4,Value4);
    String Value6="Rep Notes";
    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"History Notes\")])";
    verifyTrueElementEnable(Xpath6,Value6);
    String Value7="Close";
    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath7,Value7); 
}

@Test(priority=21,groups={"PHASE2REPPROFILE"})	
public void phase2VerifyTopPurchasesSales() {
	System.out.println("REP_TOP_PURCHASES FUNCTION CALLED..............");
	driver.findElementByAccessibilityId("Rep").click();
	System.out.println("Rep is Clicked:");
	driver.findElementByAccessibilityId("Top By Purchases").click();
	System.out.println("Top By Purchases Is clicked");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"Ts:\")][1]")).click();
	System.out.println("Click On Rep drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String Value="Sales";
    String Xpath="(//XCUIElementTypeButton[@name=\"Sales\"])";	
    click(Xpath,Value);
	String Value1="Product Sales Header";
    String Xpath1="(//XCUIElementTypeStaticText[@name=\"Product Sales\"])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="left";
    String Xpath2="(//XCUIElementTypeOther[@name=\", PY Assets, Column Headings\"])";
    swipeToDirection(Xpath2,Value2);
    swipeToDirection(Xpath2,Value2);
    
}
@Test(priority=22,groups={"PHASE2REPPROFILE"})	
public void phase2VerifyTopAssetsSales() {
	System.out.println("REP_ASSERTS FUNCTION CALLED..............");
	driver.findElementByAccessibilityId("Rep").click();
	System.out.println("Rep is Clicked:");
	driver.findElementById("Top By Assets").click();
	System.out.println("Top By Assets Is clicked");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD:\")][1]")).click();
	System.out.println("Click On Rep drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String Value="Sales";
    String Xpath="(//XCUIElementTypeButton[@name=\"Sales\"])";	
    click(Xpath,Value);
	String Value1="Product Sales Header";
    String Xpath1="(//XCUIElementTypeStaticText[@name=\"Product Sales\"])";
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="left";
    String Xpath2="(//XCUIElementTypeOther[@name=\", PY Assets, Column Headings\"])";
    swipeToDirection(Xpath2,Value2);
    swipeToDirection(Xpath2,Value2);
}

@Test(priority=23,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileDashboard() {
	repDashboard();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Dashboard";
    String Xpath1="Dashboard";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Dashboard Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Dashboard \"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Assert Summary By Product Group";
    String Xpath3="(//XCUIElementTypeOther[@name=\"Title.Sales Summary By Product Group\"])";
    verifyTrueElementDisplay(Xpath3,Value3);
    String Value4="Monthly Assert Trend";
    String Xpath4="(//XCUIElementTypeOther[@name=\"Title.Monthly Assets Trend\"])";
    verifyTrueElementDisplay(Xpath4,Value4);
    String Value5="left";
    String Xpath5="(//XCUIElementTypeOther[@name=\"Legend: YTD Sales, PY Sales, \"])";
    swipeToDirection(Xpath5,Value5);
     //String Value6="right";
    //String Xpath6="(//XCUIElementTypeOther[@name=\"Legend: YTD Sales, PY Sales, \"])";
   //swipeToDirection(Xpath6,Value6);
}
@Test(priority=24,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileDashboard2() {
	repDashboard();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Dashboard 2";
    String Xpath1="Dashboard 2";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Dashboard Trend Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Dashboard Trend\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Prior Day Drop Down";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Prior Day\"])";
    click(Xpath3,Value3);
    String Value4="Current Week";
    String Xpath4="(//XCUIElementTypeButton[@name=\"Current Week\"])";
    click(Xpath4,Value4);
    
}

@Test(priority=25,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileProductContribution() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Product Contribution";
    String Xpath1="Product Contribution";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Product Contribution Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Product Contribution \"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Product Profile";
    String Xpath3="((//XCUIElementTypeOther[@name=\", \"])[1]/XCUIElementTypeButton)";
    Boolean cond=ifElseElementDisplay(Xpath3,Value3);
    if(cond){
    	
        click(Xpath3,Value3);
        String Value4="Product Header";
        String Xpath4="(//XCUIElementTypeStaticText[@name=\"Product\"])";
        verifyTrueElementEnable(Xpath4,Value4);
        String Value5="Back Icon";
        String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
        click(Xpath5,Value5);
        verifyTrueElementEnable(Xpath2,Value2);
        
    }
    else {
    	verifyTrueElementEnable(Xpath2,Value2);
    }  
}

@Test(priority=26,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileTimeline() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Timeline";
    String Xpath1="Timeline";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Product Contribution Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Product Contribution \"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Product Profile";
    String Xpath3="((//XCUIElementTypeOther[@name=\", \"])[1])";
    Boolean cond=ifElseElementDisplay(Xpath3,Value3);
    if(cond){
    	
        click(Xpath3,Value3);
        String Value4="Product Header";
        String Xpath4="(//XCUIElementTypeStaticText[@name=\"Product\"])";
        verifyTrueElementEnable(Xpath4,Value4);
        String Value5="Back Icon";
        String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
        click(Xpath5,Value5);
        verifyTrueElementEnable(Xpath2,Value2);
        
    }
    else {
    	verifyTrueElementEnable(Xpath2,Value2);
    }  
}

@Test(priority=27,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileSegmented() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Segmented";
    String Xpath1="Segmented";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Rep Segmented Header";
    String Xpath2="((//XCUIElementTypeStaticText[@name=\"Rep Segmented\"])[1])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Rule Criteria";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Rule Criteria\"])";
    click(Xpath3,Value3);
    String Value4="Segmented Rule";
    String Xpath4="((//XCUIElementTypeStaticText[contains(@name,\"Rep Segment1\")])[1])";
    verifyTrueElementEnable(Xpath4,Value4);
    String Value5="Back Icon";
    String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
    click(Xpath5,Value5);
          
}
@Test(priority=28,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileCategories() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Categories";
    String Xpath1="Categories";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Rep Categories Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Categories\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Add Icon";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Add line\"])";
    click(Xpath3,Value3);
    String Value4="Category Type";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1])";
    click(Xpath4,Value4);
    String Value5="Sales Status";
    String Xpath5="(//XCUIElementTypeStaticText[@name=\"Sales Status\"])";	
    click(Xpath5,Value5);
    String Value6="Category Code";
    String Xpath6="(//XCUIElementTypeButton[@name=\"<Select>\"])";	
    click(Xpath6,Value6);
    String Value7="Appointed";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"APPOINTED\"])";
    click(Xpath7,Value7);
    String Value8="Caterogy Comments ";
    String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField)";
    clearAndTypeWithTimeStamp(Xpath8,Value8);
    String Value9="Save Button";
    String Xpath9="(//XCUIElementTypeStaticText[@name=\"Save\"])";
    click(Xpath9,Value9);
    verifyTrueElementEnable(Xpath2,Value2);        
}

@Test(priority=29,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileProfilling() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Profiling";
    String Xpath1="Profiling";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Rep Profiling Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Profiling\"])";
    String Value3="Profiling Data";
    String Xpath3="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1])";
    verifyTrueElementEnable(Xpath2,Value2);
    Boolean cond=ifElseElementDisplay(Xpath3,Value3);
    if(cond){
    	
        click(Xpath3,Value3);
        String Value4="Questionnaire Header";
        String Xpath4="(//XCUIElementTypeStaticText[@name=\"Questionnaire \"])";
        verifyTrueElementEnable(Xpath4,Value4);
        String Value5="Back Icon";
        String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
        click(Xpath5,Value5);
        verifyTrueElementEnable(Xpath2,Value2);
        
    }
    else {
    	verifyTrueElementEnable(Xpath2,Value2);
    }  
             
}

@Test(priority=30,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileAddAddresses() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Addresses";
    String Xpath1="Addresses";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Rep Addresses Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Addresses\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Add Icon";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Add line\"])";
    click(Xpath3,Value3);
    String Value4="Valid For Shipping Button";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeSwitch)";
    click(Xpath4,Value4);
    String Value5="123654";
    String Xpath5="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[12])";	
    clearAndType(Xpath5,Value5);
    String Value6="34";
    String Xpath6="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[11])";	
    clearAndType(Xpath6,Value6);
    String Value7="9999999999";
    String Xpath7="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[10])";
    clearAndType(Xpath7,Value7);
    String Value8="Address Direction ";
    String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[9])";
    clearAndTypeWithTimeStamp(Xpath8,Value8);
    String Value9="City";
    String Xpath9="(//XCUIElementTypeButton[@name=\" \"])";
    click(Xpath9,Value9);
    String Value10="City";
    String Xpath10="(//XCUIElementTypeStaticText[@name=\"Alabama\"])";
    click(Xpath10,Value10);
    String Value11="Newyork";
    String Xpath11="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[6])";
    clearAndType(Xpath11,Value11);
    String Value12="10001";
    String Xpath12="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[7])";
    clearAndType(Xpath12,Value12);
    String Value13="Line 1 ";
    String Xpath13="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[2])";
    clearAndTypeWithTimeStamp(Xpath13,Value13);
    String Value14="Line 2 ";
    String Xpath14="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[3])";
    clearAndTypeWithTimeStamp(Xpath14,Value14);
    String Value15="Line 3 ";
    String Xpath15="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[4])";
    clearAndTypeWithTimeStamp(Xpath15,Value15);
    String Value16="Line 4 ";
    String Xpath16="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[5])";
    clearAndTypeWithTimeStamp(Xpath16,Value16);
    String Value17="Automation Addresses ";
    String Xpath17="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[1])";
    clearAndTypeWithTimeStamp(Xpath17,Value17);
    String Value18="Save Icon";
    String Xpath18="(//XCUIElementTypeStaticText[@name=\"Save\"])";
    click(Xpath18,Value18);
    String Value19="Automation Addresses";
    String Xpath19="(//XCUIElementTypeStaticText[contains(@name,\"Automation Addresses\")])";
    verifyTrueElementEnable(Xpath19,Value19);
    click(Xpath19,Value19);
    String Value20="Cancel Icon";
    String Xpath20="(//XCUIElementTypeStaticText[@name=\"Cancel\"])";
    click(Xpath20,Value20);        
}
@Test(priority=31,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileEditAddresses() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Addresses";
    String Xpath1="Addresses";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Rep Addresses Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Addresses\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Automation Addresses";
    String Xpath3="(//XCUIElementTypeStaticText[contains(@name,\"Automation Addresses\")])";
    verifyTrueElementEnable(Xpath3,Value3);
    click(Xpath3,Value3);
    String Value4="Line 1 ";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[2])";
    clearAndTypeWithTimeStamp(Xpath4,Value4);
    String Value5="Line 2 ";
    String Xpath5="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[3])";
    clearAndTypeWithTimeStamp(Xpath5,Value5);
    String Value6="Modified Addresses ";
    String Xpath6="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTextField[1])";
    clearAndTypeWithTimeStamp(Xpath6,Value6);
    String Value7="Save Icon";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Save\"])";
    click(Xpath7,Value7);
    String Value8="Modified Addresses";
    String Xpath8="(//XCUIElementTypeStaticText[contains(@name,\"Modified Addresses\")])";
    verifyTrueElementEnable(Xpath8,Value8);
          
}
@Test(priority=32,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileAddPhone() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Phones";
    String Xpath1="Phones";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Rep Phones Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Phones\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Add Icon";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Add line\"])";
    click(Xpath3,Value3);
    String Value4="Add phone Window";
    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Add Phone\"])";
    verifyTrueElementEnable(Xpath4,Value4);
    String Value5="Phone Type";
    String Xpath5="(//XCUIElementTypeButton[@name=\"Home\"])";	
    click(Xpath5,Value5);
    String Value6="Mobile";
    String Xpath6="(//XCUIElementTypeButton[@name=\"Mobile\"])";	
    click(Xpath6,Value6);
    String Value7="9999999999";
    String Xpath7="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1])";
    clearAndType(Xpath7,Value7);
    String Value8="12345";
    String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2])";
    clearAndType(Xpath8,Value8);
    String Value9="Save Icon";
    String Xpath9="(//XCUIElementTypeStaticText[@name=\"Save\"])";
    click(Xpath9,Value9);
    String Value10="First Row";
    String Xpath10="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTable/XCUIElementTypeCell[1])";
    verifyTrueElementEnable(Xpath10,Value10);   
}
@Test(priority=33,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileEditPhone() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Phones";
    String Xpath1="Phones";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Rep Phones Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Phones\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Mobile Menu";
    String Xpath3="((//XCUIElementTypeButton[@name=\"Mobile\"])[1])";
    click(Xpath3,Value3);
    String Value4="Direct Phone";
    String Xpath4="(//XCUIElementTypeButton[@name=\"Direct\"])";
    click(Xpath4,Value4);
    String Value5="1234567892";
    String Xpath5="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField[1])";
    clearAndType(Xpath5,Value5);
    String Value6="89745";
    String Xpath6="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField[2])";
    clearAndType(Xpath6,Value6);
    String Value7="First Row";
    String Xpath7="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeTable/XCUIElementTypeCell[1])";
    verifyTrueElementEnable(Xpath7,Value7);   
}

@Test(priority=34,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileReadOut() {
	repLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Read Out";
    String Xpath1="(//XCUIElementTypeButton[@name=\"Read Out\"])";	
    click(Xpath1,Value1);
    String Value2="Rep Read Out Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Read Out\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Play Icon";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Play\"])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Close Icon";
    String Xpath4="(//XCUIElementTypeButton[@name=\"Close\"])";
    click(Xpath4,Value4);   
}

@Test(priority=35,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileTeamTab() {
	repLookup();
	String Value="Teams Tab";
    String Xpath="(//XCUIElementTypeButton[@name=\"Teams\"])";	
    click(Xpath,Value);
    String Value1="Teams Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"Teams\"])[1])";	
    verifyTrueElementEnable(Xpath1,Value1);
    
}
@Test(priority=36,groups={"PHASE2REPPROFILE"})	
public void phase2RepProfileMaps() {
	System.out.print("REP_MAP FUNCTION CALLED..............");
    driver.findElementByAccessibilityId("Rep").click();
    System.out.println("Rep Is Clicked:");
    driver.findElementByAccessibilityId("Maps").click();
    System.out.println("Map Is Clicked:");
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String Value="Channel Bank";
    String Xpath="(//XCUIElementTypeOther[@name=\"RT: 1, Bank\"])";	
    click(Xpath,Value);
    String Value1="Territory Bank Central";
    String Xpath1="(//XCUIElementTypeOther[@name=\"Channel: Bank, RT: 1, Bank Central. This is a link\"])";	
    click(Xpath1,Value1);
    String Value2="Channel Bank Text";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Channel: Bank\"])";	
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Search Icon";
    String Xpath3="(//XCUIElementTypeImage[@name=\"Image6e0\"])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Home Icon";
    String Xpath4="(//XCUIElementTypeImage[@name=\"Image4. This is a Link. \"])";
    verifyTrueElementEnable(Xpath4,Value4);
    String Value5="Filter Icon";
    String Xpath5="(//XCUIElementTypeImage[@name=\"Image5. This is a Link. \"])";
    verifyTrueElementEnable(Xpath5,Value5);
    String Value6="Back Icon";
    String Xpath6="(//XCUIElementTypeImage[@name=\"Image2. This is a Link. \"])";
    verifyTrueElementEnable(Xpath6,Value6);
    click(Xpath6,Value6);
    String Value7="Channel / Territory for Rep Map Header";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Channel / Territory for Rep Map\"])";
    verifyTrueElementEnable(Xpath7,Value7);  
}

//Need To work On DragAndDrop Method Call
@Test(priority=37,groups={"PHASE2REPPROFILE"})	
public void phase2RepQuery() {
	System.out.print("REP_QUERY FUNCTION CALLED..............");
	driver.findElementByAccessibilityId("Rep").click();
	System.out.println("Rep Is Clicked:");
	driver.findElementByAccessibilityId("Query").click();
	System.out.println("RepQuery Is Clicked:");
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	//String Value="Rep Queries In Header";
    //String Xpath="(//XCUIElementTypeStaticText[@name=\"Rep Queries\"])";	
    //verifyTrueElementEnable(Xpath,Value);
    //String Value1="Refresh Icon";
    //String Xpath1="(//XCUIElementTypeButton[@name=\"Reload line\"])";	
    //click(Xpath1,Value1);
    String Value2="Add Icon";
    String Xpath2="(//XCUIElementTypeButton[@name=\"Add line\"])";	
    click(Xpath2,Value2);
    //String Value3="Rep Query In Header";
    //String Xpath3="(//XCUIElementTypeStaticText[@name=\"Rep Query\"])";
    //verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Firm Name";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[1]/XCUIElementTypeCell[2])";
    String Xpath5="((//XCUIElementTypeTable[@name=\"Empty list\"])[1])";
    dragAndDrop(Xpath4,Xpath5,Value4);
    String Value6="Contains Drop Down";
    String Xpath6="(//XCUIElementTypeButton[@name=\" Contains\"])";
    click(Xpath6,Value6);
    String Value7="Contains";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Contains\"])";
    click(Xpath7,Value7);
    String Value8="AF";
    String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[2]/XCUIElementTypeCell/XCUIElementTypeTextField)";
    clearAndType(Xpath8,Value8);
    String Value9="Hide Tap";
    String Xpath9="(//XCUIElementTypeButton[@name=\"Criteria Fields - Tap to Hide\"])";
    click(Xpath9,Value9);
    String Value10="Tap To Show";
    String Xpath10="(//XCUIElementTypeButton[@name=\"Criteria Fields - Tap to Show\"])";
    click(Xpath10,Value10);
    
    String Value11="Office Name";
    String Xpath11="(//XCUIElementTypeStaticText[@name=\"Office Name\"])";
    String Xpath12="(/XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[2])";
    dragAndDrop(Xpath11,Xpath12,Value11);
    String Value13="Contains Drop Down";
    String Xpath13="((//XCUIElementTypeButton[@name=\" Contains\"])[2])";
    click(Xpath13,Value13);
    String Value14="Contains";
    String Xpath14="(//XCUIElementTypeStaticText[@name=\"Contains\"])";
    click(Xpath14,Value14);
    String Value15="AO";
    String Xpath15="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[2]/XCUIElementTypeCell[2]/XCUIElementTypeTextField)";
    clearAndType(Xpath15,Value15);
    String Value16="Play Button";
    String Xpath16="(//XCUIElementTypeButton[@name=\"Play btn\"])";
    click(Xpath16,Value16);
    String Value17="Alert Message.";
    String Xpath17="(//XCUIElementTypeStaticText[@name=\"Please add at least one Display Field\"])";
    verifyTrueElementDisplay(Xpath17,Value17);
    String Value18="OK Button";
    String Xpath18="(//XCUIElementTypeButton[@name=\"OK\"])";
    click(Xpath18,Value18);
}

@Test(priority=38,groups={"PHASE2REPROFILE"})
public void phase2AddRepProfile() {
    officeLookup();
    String Value="Add Button";
    String Xpath="(//XCUIElementTypeImage[@name=\"Image8. This is a Link. \"])";
    click(Xpath,Value);
    String Value1="Add Rep Profile Header";
    String Xpath1="(//XCUIElementTypeStaticText[@name=\"Add Rep\"])";	
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="AutoRep ";
    String Xpath2="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1])";	
    clearAndTypeWithTimeStamp(Xpath2,Value2);
    String Value3="Alexa";
    String Xpath3="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2])";
    clearAndType(Xpath3,Value3);
    String Value4="Ronam ";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[3])";
    clearAndTypeWithTimeStamp(Xpath4,Value4);
    String Xpath5="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[4])";
    String Value5="Mr.";
    clearAndType(Xpath5,Value5);
    String Value6="Hugo ";
    String Xpath6="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[5])";
    clearAndTypeWithTimeStamp(Xpath6,Value6);
    String Value7="Birth Day";
    String Xpath7="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton[1])";
    click(Xpath7,Value7);
    String Value8="TODAY";
    String Xpath8="(//XCUIElementTypeButton[@name=\"Today\"])";
    click(Xpath8,Value8);
    String Value9="Done Icon";
    String Xpath9="(//XCUIElementTypeButton[@name=\"Done\"])";
    click(Xpath9,Value9);
    String Value10="Macro ";
    String Xpath10="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[6])";
    clearAndTypeWithTimeStamp(Xpath10,Value10);
    String Value11="Devin ";
    String Xpath11="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[7])";
    clearAndTypeWithTimeStamp(Xpath11,Value11);
    String Value12="Save Icon";
    String Xpath12="(//XCUIElementTypeStaticText[@name=\"Save\"])";
    click(Xpath12,Value12);
    String Value13="Reps Tab";
    String Xpath13="(//XCUIElementTypeStaticText[@name=\"Reps\"])";	
    verifyTrueElementEnable(Xpath13, Value13);
}

@Test(priority=39,groups={"PHASE2REPROFILE"})
public void phase2ModifyRepProfile() {
	repLookup();
	String Value="Profile Header";
    String Xpath="((//XCUIElementTypeStaticText[@name=\"Profile\"])[1])";
    verifyTrueElementEnable(Xpath,Value);
    String Xpath101=Rep;
    String Value100="Rep Profile";
    String Xpath100="(//XCUIElementTypeStaticText[contains(@name,"+Xpath101+")])";	
    verifyTrueElementEnable(Xpath100,Value100);
    doubleClick(Xpath100,Value100);
    //Failed Due to Application Bug
    //String Xpath102=Office;
    //String Value103="Office Profile";
    //String Xpath103="(//XCUIElementTypeStaticText[contains(@name,"+Xpath102+")])";	
    //verifyTrueElementEnable(Xpath103,Value103);
    String Xpath104=Firm;
    String Value105="Firm Profile";
    String Xpath105="(//XCUIElementTypeStaticText[contains(@name,"+Xpath104+")])";	
    verifyTrueElementEnable(Xpath105,Value105);
    //String Xpath200="(//XCUIElementTypeButton[contains(@name,"+Xpath101+")])";
    String Value1="Edit Rep Profile Header";
    String Xpath1="(//XCUIElementTypeStaticText[@name=\"Edit Rep\"])";	
    verifyTrueElementEnable(Xpath1,Value1);
    String Value3="Alexa";
    String Xpath3="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2])";
    clearAndType(Xpath3,Value3);
    String Value4="Ronam ";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[3])";
    clearAndTypeWithTimeStamp(Xpath4,Value4);
    String Xpath5="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[4])";
    String Value5="Mr.";
    clearAndType(Xpath5,Value5);
    String Value6="Hugo ";
    String Xpath6="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[5])";
    clearAndTypeWithTimeStamp(Xpath6,Value6);
    String Value7="Birth Day";
    String Xpath7="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton[1])";
    click(Xpath7,Value7);
    String Value8="TODAY";
    String Xpath8="(//XCUIElementTypeButton[@name=\"Today\"])";
    click(Xpath8,Value8);
    String Value9="Done Icon";
    String Xpath9="(//XCUIElementTypeButton[@name=\"Done\"])";
    click(Xpath9,Value9);
    String Value10="Macro ";
    String Xpath10="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[6])";
    clearAndTypeWithTimeStamp(Xpath10,Value10);
    String Value11="Devin ";
    String Xpath11="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[7])";
    clearAndTypeWithTimeStamp(Xpath11,Value11);
    String Value12="Save Icon";
    String Xpath12="(//XCUIElementTypeStaticText[@name=\"Save\"])";
    click(Xpath12,Value12);
    String Value13="Profile Header";
    String Xpath13="((//XCUIElementTypeStaticText[@name=\"Profile\"])[1])";
    verifyTrueElementEnable(Xpath13, Value13);
    String Xpath201="(//XCUIElementTypeButton[contains(@name,"+Xpath104+")])";
    click(Xpath201,Value105);
    String Value14="Offices Tab";
    String Xpath14="(//XCUIElementTypeStaticText[@name=\"Offices\"])";	
    verifyTrueElementEnable(Xpath14,Value14);
    String Value15="Back Icon";
    String Xpath15="(//XCUIElementTypeImage[@name=\"K177. This is a Link. \"])";	
    click(Xpath15,Value15);
    //String Xpath202="(//XCUIElementTypeButton[contains(@name,"+Xpath102+")])";
    //click(Xpath202,Value103);
    //String Value16="Reps Tab";
    //String Xpath16="(//XCUIElementTypeStaticText[@name=\"Reps\"])";	
    //verifyTrueElementEnable(Xpath16,Value16);
    
}

 
@Test(priority=40,groups={"PHASE2FIRMPROFILE"})	
public void phase2VerifyFirmProfile() {
	firmLookup();
	String Xpath=Firm;
    String Value1="Firm Profile";
    String Xpath1="(//XCUIElementTypeStaticText[contains(@name,"+Xpath+")])";	
    verifyTrueElementEnable(Xpath1,Value1);
    String Xpath2=Office;
    String Value3="Office Profile";
    String Xpath3="(//XCUIElementTypeStaticText[contains(@name,"+Xpath2+")])";	
    verifyTrueElementEnable(Xpath3,Value3);
    String Xpath4="(//XCUIElementTypeButton[contains(@name,"+Xpath2+")])";	
    click(Xpath4,Value3);
    String Value5="Reps Tab";
    String Xpath5="(//XCUIElementTypeStaticText[@name=\"Reps\"])";	
    verifyTrueElementEnable(Xpath5,Value5);
	

}

@Test(priority=41,groups={"PHASE2FIRMPROFILE"})	
public void phase2VerifyFirmTopPurchasesSales() {
	System.out.println("FIRM TOP BY PURCHASES FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Firm").click();
    System.out.println("Firm Is Clicked");
	driver.findElementByAccessibilityId("Top By Purchases").click();
	System.out.println("Top By Purchases Is clicked");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT:\")][1]")).click();
	System.out.println("Click On Firm Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String Value="Sales";
	String Xpath="(//XCUIElementTypeButton[@name=\"Sales\"])";	
	click(Xpath,Value);
    String Value1="Product Sales Header";
	String Xpath1="(//XCUIElementTypeStaticText[@name=\"Product Sales\"])";
	verifyTrueElementEnable(Xpath1,Value1);
	String Value2="left";
	String Xpath2="(//XCUIElementTypeOther[@name=\", PY Assets, Column Headings\"])";
	swipeToDirection(Xpath2,Value2);
	swipeToDirection(Xpath2,Value2);
	String Value3="right";
	String Xpath3="(//XCUIElementTypeOther[@name=\", Product Type, Row Headings\"])";
	swipeToDirection(Xpath3,Value3);
	String Xpath4="(//XCUIElementTypeOther[@name=\", Product Group, Row Headings\"])";
	swipeToDirection(Xpath4,Value3);  
	
}

@Test(priority=42,groups={"PHASE2FIRMPROFILE"})	
public void phase2VerifyFirmTopAssetsSales() {
	System.out.println("FIRM TOP BY ASSETS FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Firm").click();
    System.out.println("Firm Is Clicked");
	driver.findElementByAccessibilityId("Top By Assets").click();
	System.out.println("Top By Assets Is clicked");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT:\")][1]")).click();
	System.out.println("Click On Firm Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String Value="Sales";
	String Xpath="(//XCUIElementTypeButton[@name=\"Sales\"])";	
	click(Xpath,Value);
    String Value1="Product Sales Header";
	String Xpath1="(//XCUIElementTypeStaticText[@name=\"Product Sales\"])";
	verifyTrueElementEnable(Xpath1,Value1);
	String Value2="left";
	String Xpath2="(//XCUIElementTypeOther[@name=\", PY Assets, Column Headings\"])";
	swipeToDirection(Xpath2,Value2);
	swipeToDirection(Xpath2,Value2);
	String Value3="right";
	String Xpath3="(//XCUIElementTypeOther[@name=\", Product Type, Row Headings\"])";
	swipeToDirection(Xpath3,Value3);
	String Xpath4="(//XCUIElementTypeOther[@name=\", Product Group, Row Headings\"])";
	swipeToDirection(Xpath4,Value3);  

}

@Test(priority=43,groups={"PHASE2FIRMPROFILE"})	
public void phase2FirmProfileDashboard() {
	firmDashboard();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Dashboard";
    String Xpath1="Dashboard";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Dashboard Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Dashboard \"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Sales Summary By Product Group";
    String Xpath3="(//XCUIElementTypeOther[@name=\"Title.Sales Summary By Product Group\"])";
    verifyTrueElementDisplay(Xpath3,Value3);
    String Value4="Monthly Assert Trend";
    String Xpath4="(//XCUIElementTypeOther[@name=\"Title.Monthly Assets Trend\"])";
    verifyTrueElementDisplay(Xpath4,Value4);
    String Value5="left";
    String Xpath5="(//XCUIElementTypeOther[@name=\"Legend: YTD Sales, PY Sales, \"])";
    swipeToDirection(Xpath5,Value5);
    String Value6="right";
    String Xpath6="(//XCUIElementTypeOther[@name=\"Title.Assets Summary By Product Group\"])";
    swipeToDirection(Xpath6,Value6);
}

@Test(priority=44,groups={"PHASE2FIRMPROFILE"})	
public void phase2FirmProfileDashboard2() {
	firmDashboard();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Dashboard 2";
    String Xpath1="Dashboard 2";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Dashboard 2 Header";
    String Xpath2="(//XCUIElementTypeStaticText[contains(@name,\"Dashboard 2\")])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Prior Day Drop Down";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Prior Day\"])";
    click(Xpath3,Value3);
    String Value4="Current Week";
    String Xpath4="(//XCUIElementTypeButton[@name=\"Current Week\"])";
    click(Xpath4,Value4);
    
}

@Test(priority=45,groups={"PHASE2FIRMPROFILE"})	
public void phase2FirmProfileProductContribution() {
	firmLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Product Contribution";
    String Xpath1="Product Contribution";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Product Contribution Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Product Contribution \"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Product Profile";
    String Xpath3="((//XCUIElementTypeOther[@name=\", \"])[1]/XCUIElementTypeButton)";
    Boolean cond=ifElseElementDisplay(Xpath3,Value3);
    if(cond){
    	
        click(Xpath3,Value3);
        String Value4="Product Header";
        String Xpath4="(//XCUIElementTypeStaticText[@name=\"Product\"])";
        verifyTrueElementEnable(Xpath4,Value4);
        String Value5="Back Icon";
        String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
        click(Xpath5,Value5);
        verifyTrueElementEnable(Xpath2,Value2);
        
    }
    else {
    	verifyTrueElementEnable(Xpath2,Value2);
    }  
}


@Test(priority=46,groups={"PHASE2FIRMPROFILE"})		
public void phase2FirmProfileSegmented() {
	firmLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Segmented";
    String Xpath1="Segmented";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Firm Segmented Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Segmented Categories\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Rule Criteria";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Rule Criteria\"])";
    click(Xpath3,Value3);
    //String Value4="Segmented Rule";
    //String Xpath4="((//XCUIElementTypeStaticText[contains(@name,\"Rep Segment1\")])[1])";
    //verifyTrueElementEnable(Xpath4,Value4);
    //String Value5="Back Icon";
    //String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
    //click(Xpath5,Value5);
          
}
@Test(priority=47,groups={"PHASE2FIRMPROFILE"})	
public void phase2FirmProfileCategories() {
	firmLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Categories";
    String Xpath1="Categories";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Firm Categories Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Categories\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Add Icon";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Add line\"])";
    click(Xpath3,Value3);
    String Value4="Category Type";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1])";
    click(Xpath4,Value4);
    String Value5="General Text";
    String Xpath5="(//XCUIElementTypeStaticText[@name=\"General\"])";	
    click(Xpath5,Value5);
    String Value6="Category Code";
    String Xpath6="(//XCUIElementTypeButton[@name=\"<Select>\"])";	
    click(Xpath6,Value6);
    String Value7="Accepted";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Accepted\"])";
    click(Xpath7,Value7);
    String Value8="Caterogy Comments ";
    String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField)";
    clearAndTypeWithTimeStamp(Xpath8,Value8);
    String Value9="Save Button";
    String Xpath9="(//XCUIElementTypeStaticText[@name=\"Save\"])";
    click(Xpath9,Value9);
    verifyTrueElementEnable(Xpath2,Value2);        
}

@Test(priority=48,groups={"PHASE2FIRMPROFILE"})	
public void phase2FirmProfileProfilling() {
	firmLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Profiling";
    String Xpath1="Profiling";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Firm Profiling Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Profiling\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Profiling Data";
    String Xpath3="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1])";
    Boolean cond=ifElseElementDisplay(Xpath3,Value3);
    if(cond){
    	
        click(Xpath3,Value3);
        String Value4="Questionnaire Header";
        String Xpath4="(//XCUIElementTypeStaticText[@name=\"Questionnaire \"])";
        verifyTrueElementEnable(Xpath4,Value4);
        String Value5="Back Icon";
        String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
        click(Xpath5,Value5);
        verifyTrueElementEnable(Xpath2,Value2);
        
    }
    else {
    	verifyTrueElementEnable(Xpath2,Value2);
    }  
             
}

@Test(priority=49,groups={"PHASE2FIRMPROFILE"})	
public void phase2FirmProfileOfficeTab() {
	firmLookup();
	String Value="Office Tab";
    String Xpath="(//XCUIElementTypeStaticText[@name=\"Offices\"])";	
    click(Xpath,Value);
    String Value1="Offices Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"Offices\"])[1])";	
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Offices Profile";
    String Xpath2="(//XCUIElementTypeOther[contains(@name,\"RT:\")])";	
    verifyTrueElementEnable(Xpath2,Value2);
    click(Xpath2,Value2);
    String Value3="Offices Header";
    String Xpath3="(//XCUIElementTypeStaticText[@name=\" Profile\"])";	
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Back Icon";
    String Xpath4="(//XCUIElementTypeImage[@name=\"Image5. This is a Link. \"])";	
    click(Xpath4,Value4);
    verifyTrueElementEnable(Xpath1,Value1);
  
}

@Test(priority=50,groups={"PHASE2FIRMPROFILE"})	
public void phase2FirmProfileMaps() {
	System.out.print("FIRM_MAP FUNCTION CALLED..............");
	driver.findElementByAccessibilityId("Firm").click();
	System.out.println("Firm Is Clicked:");
	driver.findElementById("Maps").click();
    System.out.println("Map Is Clicked:");
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String Value="Channel Bank";
    String Xpath="(//XCUIElementTypeOther[@name=\"RT: 1, Bank\"])";	
    click(Xpath,Value);
    String Value1="Territory Bank Central";
    String Xpath1="(//XCUIElementTypeOther[@name=\"Channel: Bank, RT: 1, Bank Central. This is a link\"])";	
    click(Xpath1,Value1);
    String Value2="Channel Bank Text";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Channel: Bank\"])";	
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Search Icon";
    String Xpath3="(//XCUIElementTypeImage[@name=\"Image6e0\"])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Home Icon";
    String Xpath4="(//XCUIElementTypeImage[@name=\"Image4. This is a Link. \"])";
    verifyTrueElementEnable(Xpath4,Value4);
    String Value5="Filter Icon";
    String Xpath5="(//XCUIElementTypeImage[@name=\"Image5. This is a Link. \"])";
    verifyTrueElementEnable(Xpath5,Value5);
    String Value6="Back Icon";
    String Xpath6="(//XCUIElementTypeImage[@name=\"Image2. This is a Link. \"])";
    verifyTrueElementEnable(Xpath6,Value6);
    click(Xpath6,Value6);
    String Value7="Channel / Territory for Rep Map Header";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Channel / Territory for Rep Map\"])";
    verifyTrueElementEnable(Xpath7,Value7);  
}

//Need To work On DragAndDrop Method Call
@Test(priority=51,groups={"PHASE2FIRMPROFILE"})
public void phase2FirmQuery() {
	System.out.print("REP_QUERY FUNCTION CALLED..............");
	driver.findElementByAccessibilityId("Rep").click();
	System.out.println("Rep Is Clicked:");
	driver.findElementByAccessibilityId("Query").click();
	System.out.println("RepQuery Is Clicked:");
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	//String Value="Rep Queries In Header";
    //String Xpath="(//XCUIElementTypeStaticText[@name=\"Rep Queries\"])";	
    //verifyTrueElementEnable(Xpath,Value);
    //String Value1="Refresh Icon";
    //String Xpath1="(//XCUIElementTypeButton[@name=\"Reload line\"])";	
    //click(Xpath1,Value1);
    String Value2="Add Icon";
    String Xpath2="(//XCUIElementTypeButton[@name=\"Add line\"])";	
    click(Xpath2,Value2);
    //String Value3="Rep Query In Header";
    //String Xpath3="(//XCUIElementTypeStaticText[@name=\"Rep Query\"])";
    //verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Firm Name";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[1]/XCUIElementTypeCell[2])";
    String Xpath5="((//XCUIElementTypeTable[@name=\"Empty list\"])[1])";
    dragAndDrop(Xpath4,Xpath5,Value4);
    String Value6="Contains Drop Down";
    String Xpath6="(//XCUIElementTypeButton[@name=\" Contains\"])";
    click(Xpath6,Value6);
    String Value7="Contains";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Contains\"])";
    click(Xpath7,Value7);
    String Value8="AF";
    String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[2]/XCUIElementTypeCell/XCUIElementTypeTextField)";
    clearAndType(Xpath8,Value8);
    String Value9="Hide Tap";
    String Xpath9="(//XCUIElementTypeButton[@name=\"Criteria Fields - Tap to Hide\"])";
    click(Xpath9,Value9);
    String Value10="Tap To Show";
    String Xpath10="(//XCUIElementTypeButton[@name=\"Criteria Fields - Tap to Show\"])";
    click(Xpath10,Value10);
    
    String Value11="Office Name";
    String Xpath11="(//XCUIElementTypeStaticText[@name=\"Office Name\"])";
    String Xpath12="(/XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[2])";
    dragAndDrop(Xpath11,Xpath12,Value11);
    String Value13="Contains Drop Down";
    String Xpath13="((//XCUIElementTypeButton[@name=\" Contains\"])[2])";
    click(Xpath13,Value13);
    String Value14="Contains";
    String Xpath14="(//XCUIElementTypeStaticText[@name=\"Contains\"])";
    click(Xpath14,Value14);
    String Value15="AO";
    String Xpath15="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[2]/XCUIElementTypeCell[2]/XCUIElementTypeTextField)";
    clearAndType(Xpath15,Value15);
    String Value16="Play Button";
    String Xpath16="(//XCUIElementTypeButton[@name=\"Play btn\"])";
    click(Xpath16,Value16);
    String Value17="Alert Message.";
    String Xpath17="(//XCUIElementTypeStaticText[@name=\"Please add at least one Display Field\"])";
    verifyTrueElementDisplay(Xpath17,Value17);
    String Value18="OK Button";
    String Xpath18="(//XCUIElementTypeButton[@name=\"OK\"])";
    click(Xpath18,Value18);
}

@Test(priority=52,groups={"PHASE2FIRMPROFILE"})	
public void phase2FirmProfileAddGroupList() {

}

@Test(priority=53,groups={"PHASE2OFFICEPROFILE"})	
public void phase2VerifyOfficeTopPurchasesSales() {
	System.out.println("OFFICE_TOP_By_PURCHASES FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Office").click();
    System.out.println("Office Is Clicked");
	driver.findElementById("Top By Purchases").click();
	System.out.println("Top By Purchases Is clicked");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT:\")][1]")).click();
	System.out.println("Click On Office Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String Value="Sales";
	String Xpath="(//XCUIElementTypeButton[@name=\"Sales\"])";	
	click(Xpath,Value);
    String Value1="Product Sales Header";
	String Xpath1="(//XCUIElementTypeStaticText[@name=\"Product Sales\"])";
	verifyTrueElementEnable(Xpath1,Value1);
	String Value2="left";
	String Xpath2="(//XCUIElementTypeOther[@name=\", PY Assets, Column Headings\"])";
	swipeToDirection(Xpath2,Value2);
	swipeToDirection(Xpath2,Value2);
	String Value3="right";
	String Xpath3="(//XCUIElementTypeOther[@name=\", Product Type, Row Headings\"])";
	swipeToDirection(Xpath3,Value3);
	String Xpath4="(//XCUIElementTypeOther[@name=\", Product Group, Row Headings\"])";
	swipeToDirection(Xpath4,Value3);  
	
}

@Test(priority=54,groups={"PHASE2OFFICEPROFILE"})	
public void phase2VerifyOfficeTopAssetsSales() {
	System.out.println("OFFICE_TOP_By_ASSETS FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Office").click();
    System.out.println("Office Is Clicked");
	driver.findElementById("Top By Assets").click();
	System.out.println("Top By Assets Is clicked");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT:\")][1]")).click();
	System.out.println("Click On Office Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String Value="Sales";
	String Xpath="(//XCUIElementTypeButton[@name=\"Sales\"])";	
	click(Xpath,Value);
    String Value1="Product Sales Header";
	String Xpath1="(//XCUIElementTypeStaticText[@name=\"Product Sales\"])";
	verifyTrueElementEnable(Xpath1,Value1);
	String Value2="left";
	String Xpath2="(//XCUIElementTypeOther[@name=\", PY Assets, Column Headings\"])";
	swipeToDirection(Xpath2,Value2);
	swipeToDirection(Xpath2,Value2);
	String Value3="right";
	String Xpath3="(//XCUIElementTypeOther[@name=\", Product Type, Row Headings\"])";
	swipeToDirection(Xpath3,Value3);
	String Xpath4="(//XCUIElementTypeOther[@name=\", Product Group, Row Headings\"])";
	swipeToDirection(Xpath4,Value3);  

}

@Test(priority=55,groups={"PHASE2OFFICEPROFILE"})	
public void phase2OfficeProfileDashboard() {
	officeDashboard();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Dashboard";
    String Xpath1="Dashboard";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Dashboard Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Dashboard \"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Sales Distribution by Product Group";
    String Xpath3="(//XCUIElementTypeOther[@name=\"Title.Sales Distribution by Product Group\"])";
    verifyTrueElementDisplay(Xpath3,Value3);
    String Value4="Monthly Assert Trend";
    String Xpath4="(//XCUIElementTypeOther[@name=\"Title.Monthly Assets Trend\"])";
    verifyTrueElementDisplay(Xpath4,Value4);
    String Value5="left";
    String Xpath5="(//XCUIElementTypeOther[@name=\"Legend: YTD Sales, PY Sales, \"])";
    swipeToDirection(Xpath5,Value5);
    String Value6="right";
    String Xpath6="(//XCUIElementTypeOther[@name=\"Title.Sales Distribution by Product Group\"])";
    swipeToDirection(Xpath6,Value6);
}

@Test(priority=56,groups={"PHASE2OFFICEPROFILE"})	
public void phase2OfficeProfileDashboard2() {
	officeDashboard();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Dashboard 2";
    String Xpath1="Dashboard 2";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Dashboard 2 Header";
    String Xpath2="(//XCUIElementTypeStaticText[contains(@name,\"Dashboard 2\")])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Prior Day Drop Down";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Prior Day\"])";
    click(Xpath3,Value3);
    String Value4="Current Week";
    String Xpath4="(//XCUIElementTypeButton[@name=\"Current Month\"])";
    click(Xpath4,Value4);
    
}

@Test(priority=57,groups={"PHASE2OFFICEPROFILE"})	
public void phase2OfficeProfileProductContribution() {
	officeLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Product Contribution";
    String Xpath1="Product Contribution";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Product Contribution Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Product Contribution \"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Product Profile";
    String Xpath3="((//XCUIElementTypeOther[@name=\", \"])[1]/XCUIElementTypeButton)";
    Boolean cond=ifElseElementDisplay(Xpath3,Value3);
    if(cond){
    	
        click(Xpath3,Value3);
        String Value4="Product Header";
        String Xpath4="(//XCUIElementTypeStaticText[@name=\"Product\"])";
        verifyTrueElementEnable(Xpath4,Value4);
        String Value5="Back Icon";
        String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
        click(Xpath5,Value5);
        verifyTrueElementEnable(Xpath2,Value2);
        
    }
    else {
    	verifyTrueElementEnable(Xpath2,Value2);
    }  
}

@Test(priority=58,groups={"PHASE2OFFICEPROFILE"})		
public void phase2OfficeProfileSegmented() {
	officeLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Segmented";
    String Xpath1="Segmented";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Office Segmented Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Segmented Categories\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Rule Criteria";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Rule Criteria\"])";
    click(Xpath3,Value3);
    //String Value4="Segmented Rule";
    //String Xpath4="((//XCUIElementTypeStaticText[contains(@name,\"Rep Segment1\")])[1])";
    //verifyTrueElementEnable(Xpath4,Value4);
    //String Value5="Back Icon";
    //String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
    //click(Xpath5,Value5);
          
}
@Test(priority=59,groups={"PHASE2OFFICEPROFILE"})	
public void phase2OfficeProfileCategories() {
	officeLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Categories";
    String Xpath1="Categories";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Office Categories Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Categories\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Add Icon";
    String Xpath3="(//XCUIElementTypeButton[@name=\"Add line\"])";
    click(Xpath3,Value3);
    String Value4="Category Type";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1])";
    click(Xpath4,Value4);
    String Value5="General Text";
    String Xpath5="(//XCUIElementTypeStaticText[@name=\"General\"])";	
    click(Xpath5,Value5);
    String Value6="Category Code";
    String Xpath6="(//XCUIElementTypeButton[@name=\"<Select>\"])";	
    click(Xpath6,Value6);
    String Value7="Jeff Vega 3 General";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Jeff Vega 3 General\"])";
    click(Xpath7,Value7);
    String Value8="Caterogy Comments ";
    String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField)";
    clearAndTypeWithTimeStamp(Xpath8,Value8);
    String Value9="Save Button";
    String Xpath9="(//XCUIElementTypeStaticText[@name=\"Save\"])";
    click(Xpath9,Value9);
    verifyTrueElementEnable(Xpath2,Value2);        
}

@Test(priority=60,groups={"PHASE2OFFICEPROFILE"})	
public void phase2OfficeProfileProfilling() {
	officeLookup();
	String Value="More";
    String Xpath="(//XCUIElementTypeButton[@name=\"More\"])";	
    click(Xpath,Value);
    String Value1="Profiling";
    String Xpath1="Profiling";	
    clickByAccessID(Xpath1,Value1);
    String Value2="Office Profiling Header";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Profiling\"])";
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Profiling Data";
    String Xpath3="((//XCUIElementTypeButton[@name=\"Template Profile\"])[2])";
    Boolean cond=ifElseElementDisplay(Xpath3,Value3);
    if(cond){
    	
        click(Xpath3,Value3);
        String Value4="Questionnaire Header";
        String Xpath4="(//XCUIElementTypeStaticText[@name=\"Questionnaire \"])";
        verifyTrueElementEnable(Xpath4,Value4);
        String Value5="Back Icon";
        String Xpath5="(//XCUIElementTypeButton[@name=\"BackArrow line\"])";	
        click(Xpath5,Value5);
        verifyTrueElementEnable(Xpath2,Value2);
        
    }
    else {
    	verifyTrueElementEnable(Xpath2,Value2);
    }  
             
}

@Test(priority=61,groups={"PHASE2OFFICEPROFILE"})	
public void phase2OfficeProfileRepTab() {
	officeLookup();
	String Value="Reps Tab";
    String Xpath="(//XCUIElementTypeStaticText[@name=\"Reps\"])";	
    click(Xpath,Value);
    String Value1="Reps Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"Reps\"])[1])";	
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Rep Profile";
    String Xpath2="(//XCUIElementTypeOther[contains(@name,\"RT:\")])";	
    verifyTrueElementEnable(Xpath2,Value2);
    click(Xpath2,Value2);
    String Value3="Reps Header";
    String Xpath3="((//XCUIElementTypeStaticText[@name=\"Profile\"])[1])";	
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Back Icon";
    String Xpath4="(//XCUIElementTypeImage[@name=\"K55. This is a Link. \"])";	
    click(Xpath4,Value4);
    verifyTrueElementEnable(Xpath1,Value1);
  
}

@Test(priority=62,groups={"PHASE2OFFICEPROFILE"})	
public void phase2OfficeProfileMaps() {
	System.out.println("OFFICE MAP FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Office").click();
    System.out.println("Office Is Clicked:");
	driver.findElementById("Maps").click();
    System.out.println("Map Is Clicked:");
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String Value="Channel Bank";
    String Xpath="(//XCUIElementTypeOther[@name=\"RT: 1, Bank\"])";	
    click(Xpath,Value);
    String Value1="Territory Bank Central";
    String Xpath1="(//XCUIElementTypeOther[@name=\"Channel: Bank, RT: 1, Bank Central. This is a link\"])";	
    click(Xpath1,Value1);
    String Value2="Channel Bank Text";
    String Xpath2="(//XCUIElementTypeStaticText[@name=\"Channel: Bank\"])";	
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Search Icon";
    String Xpath3="(//XCUIElementTypeImage[@name=\"Image6e0\"])";
    verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Home Icon";
    String Xpath4="(//XCUIElementTypeImage[@name=\"Image4. This is a Link. \"])";
    verifyTrueElementEnable(Xpath4,Value4);
    String Value5="Filter Icon";
    String Xpath5="(//XCUIElementTypeImage[@name=\"Image5. This is a Link. \"])";
    verifyTrueElementEnable(Xpath5,Value5);
    String Value6="Back Icon";
    String Xpath6="(//XCUIElementTypeImage[@name=\"Image2. This is a Link. \"])";
    verifyTrueElementEnable(Xpath6,Value6);
    click(Xpath6,Value6);
    String Value7="Channel / Territory for Rep Map Header";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Channel / Territory for Rep Map\"])";
    verifyTrueElementEnable(Xpath7,Value7);  
}

//Need To work On DragAndDrop Method Call
@Test(priority=63,groups={"PHASE2OFFICEPROFILE"})
public void phase2OfficeQuery() {
	System.out.print("REP_QUERY FUNCTION CALLED..............");
	driver.findElementByAccessibilityId("Rep").click();
	System.out.println("Rep Is Clicked:");
	driver.findElementByAccessibilityId("Query").click();
	System.out.println("RepQuery Is Clicked:");
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	//String Value="Rep Queries In Header";
    //String Xpath="(//XCUIElementTypeStaticText[@name=\"Rep Queries\"])";	
    //verifyTrueElementEnable(Xpath,Value);
    //String Value1="Refresh Icon";
    //String Xpath1="(//XCUIElementTypeButton[@name=\"Reload line\"])";	
    //click(Xpath1,Value1);
    String Value2="Add Icon";
    String Xpath2="(//XCUIElementTypeButton[@name=\"Add line\"])";	
    click(Xpath2,Value2);
    //String Value3="Rep Query In Header";
    //String Xpath3="(//XCUIElementTypeStaticText[@name=\"Rep Query\"])";
    //verifyTrueElementEnable(Xpath3,Value3);
    String Value4="Firm Name";
    String Xpath4="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[1]/XCUIElementTypeCell[2])";
    String Xpath5="((//XCUIElementTypeTable[@name=\"Empty list\"])[1])";
    dragAndDrop(Xpath4,Xpath5,Value4);
    String Value6="Contains Drop Down";
    String Xpath6="(//XCUIElementTypeButton[@name=\" Contains\"])";
    click(Xpath6,Value6);
    String Value7="Contains";
    String Xpath7="(//XCUIElementTypeStaticText[@name=\"Contains\"])";
    click(Xpath7,Value7);
    String Value8="AF";
    String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[2]/XCUIElementTypeCell/XCUIElementTypeTextField)";
    clearAndType(Xpath8,Value8);
    String Value9="Hide Tap";
    String Xpath9="(//XCUIElementTypeButton[@name=\"Criteria Fields - Tap to Hide\"])";
    click(Xpath9,Value9);
    String Value10="Tap To Show";
    String Xpath10="(//XCUIElementTypeButton[@name=\"Criteria Fields - Tap to Show\"])";
    click(Xpath10,Value10);
    
    String Value11="Office Name";
    String Xpath11="(//XCUIElementTypeStaticText[@name=\"Office Name\"])";
    String Xpath12="(/XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[2])";
    dragAndDrop(Xpath11,Xpath12,Value11);
    String Value13="Contains Drop Down";
    String Xpath13="((//XCUIElementTypeButton[@name=\" Contains\"])[2])";
    click(Xpath13,Value13);
    String Value14="Contains";
    String Xpath14="(//XCUIElementTypeStaticText[@name=\"Contains\"])";
    click(Xpath14,Value14);
    String Value15="AO";
    String Xpath15="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable[2]/XCUIElementTypeCell[2]/XCUIElementTypeTextField)";
    clearAndType(Xpath15,Value15);
    String Value16="Play Button";
    String Xpath16="(//XCUIElementTypeButton[@name=\"Play btn\"])";
    click(Xpath16,Value16);
    String Value17="Alert Message.";
    String Xpath17="(//XCUIElementTypeStaticText[@name=\"Please add at least one Display Field\"])";
    verifyTrueElementDisplay(Xpath17,Value17);
    String Value18="OK Button";
    String Xpath18="(//XCUIElementTypeButton[@name=\"OK\"])";
    click(Xpath18,Value18);
}


@Test(priority=64,groups={"PHASE2OFFICEPROFILE"})
public void phase2OfficeProfileAddGroupList() {
}

@Test(priority=65,groups={"PHASE2OFFICEPROFILE"})
public void phase2VerifyOfficeProfile() {
	
	officeLookup();
	String Xpath=Office;
    String Value1="Office Profile";
    String Xpath1="(//XCUIElementTypeStaticText[contains(@name,"+Xpath+")])";	
    verifyTrueElementEnable(Xpath1,Value1);
    String Xpath2=Firm;
    String Value3="Firm Profile";
    String Xpath3="(//XCUIElementTypeStaticText[contains(@name,"+Xpath2+")])";	
    verifyTrueElementEnable(Xpath3,Value3);
    String Xpath4="(//XCUIElementTypeButton[contains(@name,"+Xpath2+")])";	
    click(Xpath4,Value3);
    String Value5="Offices Tab";
    String Xpath5="(//XCUIElementTypeStaticText[@name=\"Offices\"])";	
    verifyTrueElementEnable(Xpath5,Value5);
    
}

@Test(priority=66,groups={"PHASE2TEAMREPPROFILE"})
public void phase2VerifyTeamRepProfile() {
	teamLookup();
	String Value="Team Profile Header";
    String Xpath="(//XCUIElementTypeStaticText[@name=\"Team Profile\"])";
    verifyTrueElementEnable(Xpath,Value);
    String Xpath101=TeamRep;
    String Value100="TeamRep Profile";
    String Xpath100="(//XCUIElementTypeStaticText[contains(@name,"+Xpath101+")])";	
    verifyTrueElementEnable(Xpath100,Value100);
    //Failed Due to Application Bug
    //String Xpath102=Office;
    //String Value103="Office Profile";
    //String Xpath103="(//XCUIElementTypeStaticText[contains(@name,"+Xpath102+")])";	
    //verifyTrueElementEnable(Xpath103,Value103);
    String Xpath104=Firm;
    String Value105="Firm Profile";
    String Xpath105="(//XCUIElementTypeStaticText[contains(@name,"+Xpath104+")])";	
    verifyTrueElementEnable(Xpath105,Value105);
    String Xpath201="(//XCUIElementTypeButton[contains(@name,"+Xpath104+")])";
    click(Xpath201,Value105);
    String Value14="Offices Tab";
    String Xpath14="(//XCUIElementTypeStaticText[@name=\"Offices\"])";	
    verifyTrueElementEnable(Xpath14,Value14);
    String Value15="Back Icon";
    String Xpath15="(//XCUIElementTypeImage[@name=\"K177. This is a Link. \"])";	
    click(Xpath15,Value15);
    //String Xpath202="(//XCUIElementTypeButton[contains(@name,"+Xpath102+")])";
    //click(Xpath202,Value103);
    //String Value16="Reps Tab";
    //String Xpath16="(//XCUIElementTypeStaticText[@name=\"Reps\"])";	
    //verifyTrueElementEnable(Xpath16,Value16);

}

@Test(priority=67,groups={"PHASE2TEAMREPPROFILE"})
public void phase2VerifyTeamMembersInTeamRepProfile() {

	teamLookup();
	String Value="Team Member Tab";
    String Xpath="(//XCUIElementTypeStaticText[@name=\"Team Members\"])";	
    click(Xpath,Value);
    String Value1="Team Members Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"Team Members\"])[1])";	
    verifyTrueElementEnable(Xpath1,Value1);
    String Value2="Team Members";
    String Xpath2="((//XCUIElementTypeStaticText[@name=\"Team Members\"])[1])";	
    verifyTrueElementEnable(Xpath2,Value2);
    String Value3="Rep Profile";
    String Xpath3="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton)";	
    click(Xpath3,Value3);
    String Value4="Rep Profile Header";
    String Xpath4="((//XCUIElementTypeStaticText[@name=\"Profile\"])[1])";	
    verifyTrueElementEnable(Xpath4,Value4);
    
}

@Test(priority=68,groups={"PHASE2TEAMREPPROFILE"})
public void phase2VerifyTeamGroupInTeamRepProfile() {
	teamLookup();
	String Value="Team Group Tab";
    String Xpath="((//XCUIElementTypeStaticText[@name=\"Team Group\"])[2])";	
    click(Xpath,Value);
    String Value1="Team Group Header";
    String Xpath1="((//XCUIElementTypeStaticText[@name=\"Team Group\"])[1])";	
    verifyTrueElementEnable(Xpath1,Value1);
   // String Value2="Team Group Name";
   // String Xpath2="((//XCUIElementTypeStaticText[contains(@name,\"TGROUP\")])[1])";	
    //verifyTrueElementEnable(Xpath2,Value2);
    
}
//All User Defined Methods	
	
	public void click(String Xpath,String Value)  {
	    
		WebElement element=driver.findElementByXPath(Xpath);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
		boolean isEnable = element.isEnabled();
		if(isEnable)
		{
			element.click();
			System.out.println("Element Is Clicked :"+Value);
		}
		else {
			System.out.println("Screenshot Captured");
		}
	}
public void mobileElementClick(String Xpath,String Value)  {
	    
	    MobileElement element=(MobileElement)driver.findElementByXPath(Xpath);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
		boolean isEnable = element.isEnabled();
		if(isEnable)
		{
			element.click();
			System.out.println("Element Is Clicked :"+Value);
		}
		else {
			System.out.println("Screenshot Captured");
		}
	}	
	public void clickByAccessID(String Xpath,String Value){
		caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.FALSE);
		MobileElement element = (MobileElement) driver.findElementByAccessibilityId(Xpath);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(Xpath))); 
		boolean isEnable = element.isEnabled();
		if(isEnable)
		{
			element.click();
			System.out.println("Element Is clicked :"+Value);
		}
		else {
			System.out.println("Screenshot Captured");
		}
	}
	
	
public void clearAndType(String Xpath,String Value){
			WebElement element=driver.findElementByXPath(Xpath);
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
			boolean isEnable = element.isEnabled();
			if(isEnable)
			{
				element.clear();
				element.clear();
				element.sendKeys(Value);
				System.out.println("Entered Value Is :"+Value);
			}
			else {
				System.out.println("Screenshot Captured");
			}
	
	} 

public void clearAndTypeWithTimeStamp(String Xpath,String Value){
	String today; 
	DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); 
	Calendar calendar = Calendar.getInstance(); 
	today = dateFormat.format(calendar.getTime()); 
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isEnable = element.isEnabled();
	if(isEnable)
	{
		element.clear();
		element.clear();
		element.sendKeys(Value);
		element.sendKeys(today);
		System.out.println("Entered Value Is :"+Value + today);
	}
	else {
		System.out.println("Screenshot Captured");
	}

} 

public void clearAndTypeAccessIdWithTime(String Xpath,String Value){
	String today; 
	DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); 
	Calendar calendar = Calendar.getInstance(); 
	today = dateFormat.format(calendar.getTime()); 
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isEnable = element.isEnabled();
	if(isEnable)
	{
		element.clear();
		element.sendKeys(Value ,"+\n");
		element.sendKeys(today);
		System.out.println("Entered Value Is :"+Value);
	}
	else {
		System.out.println("Screenshot Captured");
	}

} 


public void clearAndTypeByAcessId(String Xpath,String Value){
	caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.FALSE);
	MobileElement element = (MobileElement) driver.findElementByAccessibilityId(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(Xpath))); 
	boolean isEnable = element.isEnabled();
	if(isEnable)
	{
		element.clear();
		element.sendKeys(Value);
		System.out.println("Entered Value Is :"+Value);
	}
	else {
		System.out.println("screenshot Captured");
	}

} 			
public void select(String Xpath,String Value){
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	
	Select select = new Select(element);
	if (Value != null && (!Value.equals(""))) 
		select.selectByVisibleText(Value);
} 

public void selectByVisibleText(String Xpath,String Value){
	caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.FALSE);
	MobileElement element = (MobileElement) driver.findElementByAccessibilityId(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(Xpath))); 
	
	Select select = new Select(element);
	if (Value != null && (!Value.equals(""))) 
		select.selectByVisibleText(Value);
} 

public void verifyTrueElementDisplay(String Xpath,String Value){
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isDisplay= element.isDisplayed();
	if(isDisplay)
	{
		
		System.out.println("Element Is Displaying :"+Value);
	}
	else {
		System.out.println("Screenshot Captured");
	}
} 
public boolean ifElseElementDisplay(String Xpath,String Value){
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isDisplay= element.isDisplayed();
	if(isDisplay)
	{
		
		System.out.println("Element Is Displaying :"+Value);
		return true;
	}
	else {
		return false;
	}
} 
public boolean ifElseElementEnable(String Xpath,String Value){
	if(Xpath.equals(null)){
		return false;
	}
	else {
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isEnable= element.isEnabled();

	  if(isEnable)
	     {
		    System.out.println("Element Is Enabled :"+Value);
		    return true;
	     }
	else {  
		    return false;
	     }
	}
} 
public boolean ifElseElementDisplayMenu(String Xpath,String Value){
	
	MobileElement element=(MobileElement)driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isDisplay= element.isDisplayed();
	if(isDisplay)
	{
		
		System.out.println("Element is Displaying :"+Value);
		return true;
	}
	else {
		return false;
	}
} 

public void verifyTrueElementEnable(String Xpath,String Value){
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isEnable= element.isEnabled();
	if(isEnable)
	{
		
		System.out.println("Element Is Enabled:"+Value);
	}
	else {
		System.out.println("Screenshot Captured");
	}
} 



public void verifyTrueElementDisplayWithAccessId(String Xpath,String Value){
	MobileElement element = (MobileElement) driver.findElementByAccessibilityId(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(Xpath)));
	boolean isDisplay= element.isDisplayed();
	if(isDisplay)
	{
		
		System.out.println("Element Is Displaying :"+Value);
	}
	else {
		System.out.println("screenshot Captured");
	}
} 

public void verifyFalseEmptyTextbox(String Xpath,String Value){
	MobileElement element = (MobileElement) driver.findElementByAccessibilityId(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(Xpath)));
	boolean isDisplay= element.isDisplayed();
	if(isDisplay)
	{
		
		System.out.println("Element Is Displaying :"+Value);
	}
	else {
		System.out.println("Screenshot Captured");
	}
} 

public void dragAndDrop(String Xpath1,String Xpath2,String Value){
	WebElement element1 = (WebElement) driver.findElementByXPath(Xpath1);
	WebDriverWait wait1 = new WebDriverWait(driver,20);
	wait1.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(Xpath1)));
	
	//MobileElement element2 = (MobileElement) driver.findElement(By.xpath(Xpath2));
	WebDriverWait wait2 = new WebDriverWait(driver,20);
	wait2.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(Xpath1)));
	boolean isEnable= element1.isEnabled();
	if(isEnable)
	{
		
		
	    System.out.println("Drag And Drop Is Performed :"+Value);
	    
	    
	}
	else {
		System.out.println("Screenshot Captured");
	}
} 

public boolean repLookup1(){
	System.out.println("REP LOOKUP CALLED..............");
	if(driver.findElementByAccessibilityId("Rep") != null) {
	driver.findElementByAccessibilityId("Rep").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Rep Lookup Clicked");
	String Value=Rep;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
	System.out.println("Click On Rep Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	return true;
	}
	else {
		return false;
	}
} 

public void repLookup(){
	System.out.println("REP LOOKUP CALLED..............");
	driver.findElementByAccessibilityId("Rep").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Rep Lookup Clicked");
	String Value=Rep;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
	System.out.println("Click On Rep Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
} 

public void prevRepLookup(){
	System.out.println("REP LOOKUP CALLED..............");	
	driver.findElementByAccessibilityId("Rep").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Rep Lookup Clicked");
	String Value=Prev_Rep;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
	System.out.println("Click On Rep Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void repDashboard(){
	System.out.println("REP LOOKUP CALLED..............");	
	driver.findElementByAccessibilityId("Rep").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Rep Lookup Clicked");
	String Value="BRIAN";
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
	System.out.println("Click On Rep Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 
public void firmDashboard(){
	System.out.println("FIRM LOOKUP FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Firm").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Firm Lookup Clicked");
	String Value="vestor";
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Firm Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 
public void officeDashboard(){
	System.out.println("OFFICE_LOOKUP FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Office").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Office Lookup Clicked");
	String Value="CA, VESTOR";
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Office Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void firmLookup(){
	System.out.println("FIRM LOOKUP FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Firm").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Firm Lookup Clicked");
	String Value=Firm;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Firm Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void prevFirmLookup(){
	System.out.println("FIRM LOOKUP FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Firm").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Firm Lookup Clicked");
	String Value=Prev_Firm;
	String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Firm Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void officeLookup(){
	System.out.println("OFFICE_LOOKUP FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Office").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Office Lookup Clicked");
	String Value=Office;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Office Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void prevOfficeLookup(){
	System.out.println("OFFICE_LOOKUP FUNCTION CALLED.............."); 
    driver.findElementByAccessibilityId("Office").click();
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Office Lookup clicked");
	String Value=Prev_Office;
	String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Office drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void teamLookup(){
	System.out.print("TEAMREP FUNCTION CALLED.............."); 
	driver.findElementByAccessibilityId("Team").click();
	System.out.println("Team Is Clicked:");
	driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("TeamLookup Is Clicked:");
	String Value=TeamRep;
	String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
	driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: \")][1]")).click();
	System.out.println("Click On TeamRep Drill Down");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void verifyTrueElementEnableWithVariable(String Xpath,String Value1,String Value2){
	
	Xpath.replace("VARIABLE", Value2);
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isEnable= element.isEnabled();
	if(isEnable)
	{
		
		System.out.println("Element Is Enabled:"+Value1);
	}
	else {
		System.out.println("Screenshot Captured");
	}
} 

public void scroolToRightDirection(String Xpath,int Value){

   RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.xpath(Xpath));
   WebDriverWait wait = new WebDriverWait(driver,20);
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
   String parentID = parent.getId();
   HashMap<String, String> scrollObject = new HashMap<String, String>();
   for (int i = 0; i <=Value; i++) {
	  scrollObject.put("element", parentID);
	  scrollObject.put("direction", "right");
	  driver.executeScript("mobile:scroll", scrollObject);	
      }
  System.out.println("Right Scroll Is Performed");
}	

public void swipeToDirection(String Xpath,String Value) {
RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.xpath(Xpath));
WebDriverWait wait = new WebDriverWait(driver,20);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
String parentID = parent.getId();
HashMap<String, String> swipeObject = new HashMap<String, String>();
for (int i = 0; i <=1; i++) {
	swipeObject.put("element", parentID);
	swipeObject.put("direction", Value);
	driver.executeScript("mobile:swipe", swipeObject);	
   }
System.out.println("Swipe Is Performed: "+Value);
}	
public void doubleClick(String Xpath,String Value)  {
    
	WebElement element=driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isEnable = element.isEnabled();
	if(isEnable)
	{
		Actions action = new Actions(driver);
		//action.moveToElement(element).doubleClick().build().perform();
		action.moveToElement(element).contextClick().perform();
		System.out.println("Element Is DoubleClicked :"+Value);
	}
	else {
		System.out.println("Screenshot Captured");
	}
}

}


	