package appiumPages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumHomePage {

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
	    			System.out.println();
	    			
	    	}
	    	
	    	Common comObject=new Common();
	    	String Xpath="(//XCUIElementTypeApplication[@name=\\\"IntelliMARS\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1])";
	    	String Value=Username;
	    	comObject.clearAndType(Xpath, Value);
	    	
	    	String Xpath1="(//XCUIElementTypeApplication[@name=\\\"IntelliMARS\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField)";
	    	String Value1=Userpassword;
	    	comObject.clearAndType(Xpath1, Value1);
	    	
	    	String Xpath2="(//XCUIElementTypeApplication[@name=\\\"IntelliMARS\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2])";
	    	String Value2=Baseurl;
	    	comObject.clearAndType(Xpath2, Value2);
	    	
	    	String Xpath3="(//XCUIElementTypeStaticText[@name=\"Sign In\"])";
	    	String Value3="Sign In Button";
	    	comObject.click(Xpath3, Value3);
	    	
	    	
	    	
	    	try {
	    		
	    		String alert=("//XCUIElementTypeButton[@name=\"No\"]");
	    		WebElement element=driver.findElementByXPath(alert);
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
	    
	    try {
			
			String Xpath4=("//XCUIElementTypeStaticText[contains(@name,\"Profile\")]");
			WebElement element=driver.findElementByXPath(Xpath4);
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath4)));  
			
			if(element.isEnabled())
			{
				System.out.println("Profile Tab Is Enable:");
				element.click();
				System.out.println("Profile Tab Is Clicked:");
				String Xpath5=("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]");
				String Value5="Menu Icon";
				comObject.mobileElementClick(Xpath5, Value5);
			}
			else {
				System.out.println("Screenshot Captured");
			}
		} 
			catch(NoSuchElementException e) {
				//e.printStackTrace();
				//System.out.println(e);
				String Xpath5=("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]");
				String Value5="Menu Icon";
				comObject.mobileElementClick(Xpath5, Value5);
			}
	    	
	    }

}

