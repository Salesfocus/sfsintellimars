package appiumPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;

public class Common {
	AppiumHomePage homeObj=new AppiumHomePage();

public void click(String Xpath,String Value)  {
	
		WebElement element=homeObj.driver.findElementByXPath(Xpath);
		WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	    
	    MobileElement element=(MobileElement)homeObj.driver.findElementByXPath(Xpath);
		WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
		homeObj.caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.FALSE);
		MobileElement element = (MobileElement) homeObj.driver.findElementByAccessibilityId(Xpath);
		WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
			WebElement element=homeObj.driver.findElementByXPath(Xpath);
			WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	WebElement element=homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	WebElement element=homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	homeObj.caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.FALSE);
	MobileElement element = (MobileElement) homeObj.driver.findElementByAccessibilityId(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	WebElement element=homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	
	Select select = new Select(element);
	if (Value != null && (!Value.equals(""))) 
		select.selectByVisibleText(Value);
} 

public void selectByVisibleText(String Xpath,String Value){
	homeObj.caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.FALSE);
	MobileElement element = (MobileElement) homeObj.driver.findElementByAccessibilityId(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(Xpath))); 
	
	Select select = new Select(element);
	if (Value != null && (!Value.equals(""))) 
		select.selectByVisibleText(Value);
} 

public void verifyTrueElementDisplay(String Xpath,String Value){
	WebElement element=homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	WebElement element=homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	WebElement element=homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	
	MobileElement element=(MobileElement)homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	WebElement element=homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	MobileElement element = (MobileElement) homeObj.driver.findElementByAccessibilityId(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	MobileElement element = (MobileElement) homeObj.driver.findElementByAccessibilityId(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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
	WebElement element1 = (WebElement) homeObj.driver.findElementByXPath(Xpath1);
	WebDriverWait wait1 = new WebDriverWait(homeObj.driver,20);
	wait1.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(Xpath1)));
	
	//MobileElement element2 = (MobileElement) driver.findElement(By.xpath(Xpath2));
	WebDriverWait wait2 = new WebDriverWait(homeObj.driver,20);
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
	if(homeObj.driver.findElementByAccessibilityId("Rep") != null) {
	homeObj.driver.findElementByAccessibilityId("Rep").click();
	homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Rep Lookup Clicked");
	String Value=homeObj.Rep;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
	System.out.println("Click On Rep Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	return true;
	}
	else {
		return false;
	}
} 

public void repLookup(){
	System.out.println("REP LOOKUP CALLED..............");
	homeObj.driver.findElementByAccessibilityId("Rep").click();
	homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Rep Lookup Clicked");
	String Value=homeObj.Rep;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
	System.out.println("Click On Rep Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
} 

public void prevRepLookup(){
	System.out.println("REP LOOKUP CALLED..............");	
	homeObj.driver.findElementByAccessibilityId("Rep").click();
	homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Rep Lookup Clicked");
	String Value=homeObj.Prev_Rep;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
	System.out.println("Click On Rep Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void repDashboard(){
	System.out.println("REP LOOKUP CALLED..............");	
	homeObj.driver.findElementByAccessibilityId("Rep").click();
	homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Rep Lookup Clicked");
	String Value="BRIAN";
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
	System.out.println("Click On Rep Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 
public void firmDashboard(){
	System.out.println("FIRM LOOKUP FUNCTION CALLED.............."); 
	homeObj.driver.findElementByAccessibilityId("Firm").click();
	homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Firm Lookup Clicked");
	String Value="vestor";
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Firm Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 
public void officeDashboard(){
	System.out.println("OFFICE_LOOKUP FUNCTION CALLED.............."); 
	homeObj.driver.findElementByAccessibilityId("Office").click();
	homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Office Lookup Clicked");
	String Value="CA, VESTOR";
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Office Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void firmLookup(){
	System.out.println("FIRM LOOKUP FUNCTION CALLED.............."); 
	homeObj.driver.findElementByAccessibilityId("Firm").click();
	homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Firm Lookup Clicked");
	String Value=homeObj.Firm;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Firm Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void prevFirmLookup(){
	System.out.println("FIRM LOOKUP FUNCTION CALLED.............."); 
	homeObj.driver.findElementByAccessibilityId("Firm").click();
	homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Firm Lookup Clicked");
	String Value=homeObj.Prev_Firm;
	String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Firm Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void officeLookup(){
	System.out.println("OFFICE_LOOKUP FUNCTION CALLED.............."); 
	homeObj.driver.findElementByAccessibilityId("Office").click();
    homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Office Lookup Clicked");
	String Value=homeObj.Office;
    String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Office Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void prevOfficeLookup(){
	System.out.println("OFFICE_LOOKUP FUNCTION CALLED.............."); 
	homeObj.driver.findElementByAccessibilityId("Office").click();
    homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("Office Lookup clicked");
	String Value=homeObj.Prev_Office;
	String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"RT: \")][1]")).click();
	System.out.println("Click On Office drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void teamLookup(){
	System.out.print("TEAMREP FUNCTION CALLED.............."); 
	homeObj.driver.findElementByAccessibilityId("Team").click();
	System.out.println("Team Is Clicked:");
	homeObj.driver.findElementByAccessibilityId("Lookup").click();
	System.out.println("TeamLookup Is Clicked:");
	String Value=homeObj.TeamRep;
	String Xpath="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField)";
    clearAndType(Xpath,Value);
    homeObj.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Apply\"]").click();
	System.out.println("Apply Is Clicked:");
	homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: \")][1]")).click();
	System.out.println("Click On TeamRep Drill Down");
	homeObj.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
} 

public void verifyTrueElementEnableWithVariable(String Xpath,String Value1,String Value2){
	
	Xpath.replace("VARIABLE", Value2);
	WebElement element=homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
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

   RemoteWebElement parent = (RemoteWebElement)homeObj.driver.findElement(By.xpath(Xpath));
   WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
   String parentID = parent.getId();
   HashMap<String, String> scrollObject = new HashMap<String, String>();
   for (int i = 0; i <=Value; i++) {
	  scrollObject.put("element", parentID);
	  scrollObject.put("direction", "right");
	  homeObj.driver.executeScript("mobile:scroll", scrollObject);	
      }
  System.out.println("Right Scroll Is Performed");
}	

public void swipeToDirection(String Xpath,String Value) {
RemoteWebElement parent = (RemoteWebElement)homeObj.driver.findElement(By.xpath(Xpath));
WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
String parentID = parent.getId();
HashMap<String, String> swipeObject = new HashMap<String, String>();
for (int i = 0; i <=1; i++) {
	swipeObject.put("element", parentID);
	swipeObject.put("direction", Value);
	homeObj.driver.executeScript("mobile:swipe", swipeObject);	
   }
System.out.println("Swipe Is Performed: "+Value);
}	
public void doubleClick(String Xpath,String Value)  {
    
	WebElement element=homeObj.driver.findElementByXPath(Xpath);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));  
	boolean isEnable = element.isEnabled();
	if(isEnable)
	{
		Actions action = new Actions(homeObj.driver);
		//action.moveToElement(element).doubleClick().build().perform();
		action.moveToElement(element).contextClick().perform();
		System.out.println("Element Is DoubleClicked :"+Value);
	}
	else {
		System.out.println("Screenshot Captured");
	}
}
public void menuOption() {
try {
	
	String Xpath4=("//XCUIElementTypeStaticText[contains(@name,\"Profile\")]");
	WebElement element=homeObj.driver.findElementByXPath(Xpath4);
	WebDriverWait wait = new WebDriverWait(homeObj.driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath4)));  
	
	if(element.isEnabled())
	{
		System.out.println("Profile Tab Is Enable:");
		element.click();
		System.out.println("Profile Tab Is Clicked:");
		String Xpath5=("//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[1]");
		String Value5="Menu Icon";
		mobileElementClick(Xpath5, Value5);
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
		mobileElementClick(Xpath5, Value5);
	}
	
}

}
