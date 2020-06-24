package appiumPages;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.MobileElement;

public class RepLookupPage
{
	AppiumHomePage homeObj=new AppiumHomePage();
	Common comObject=new Common();
	public void verifyRepLookup() throws MalformedURLException, InterruptedException {
			
		comObject.repLookup();
		//Write the code for swipe function
		RemoteWebElement parent = (RemoteWebElement)homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\", YTD Purch, Column Headings\"]"));
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		for (int i = 0; i <=5; i++) {
			scrollObject.put("element", parentID);
			scrollObject.put("direction", "right");
			homeObj.driver.executeScript("mobile:scroll", scrollObject);	
		}
		System.out.println("Right scroll Is performed");
		
		homeObj.driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,\"CD: Rep,\")][1]")).click();
		System.out.println("Click On Rep drill Down");
		Thread.sleep(30000);
		MobileElement element = (MobileElement) homeObj.driver.findElementByAccessibilityId("Add line");
		boolean isDisplayed = element.isDisplayed();

			if(isDisplayed){
				System.out.println("Element is displayed");
	
			}
			else {
				System.out.println("Element is not displaying");
			}

			}
	
	
	public void repProfileAddMeeting() {
		boolean lookup=comObject.repLookup1();
		if(lookup) 
		{
		String Value="Activities";
        String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
        comObject.click(Xpath,Value);
        String Value1="Plus Icon";
        String Xpath1="Add line";	
        comObject.clickByAccessID(Xpath1,Value1);
        String Value2="Meeting";
        String Xpath2="(//XCUIElementTypeButton[@name=\"Meeting\"])";
        comObject.click(Xpath2,Value2);
        String Value3="Meeting Description";
        String Xpath3="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1])";
        comObject.clearAndTypeWithTimeStamp(Xpath3,Value3);
        String Value4="Meeting Type";
        String Xpath4="(//XCUIElementTypeButton[@name=\"1-on-1 Rep Meeting\"])";	
        comObject.click(Xpath4,Value4);
        String Value5="BB Meeting";
        String Xpath5="(//XCUIElementTypeStaticText[@name=\"BB Meeting\"])";	
        comObject.click(Xpath5,Value5);
        String Value6="Scheduled";
        String Xpath6="(//XCUIElementTypeButton[@name=\"Scheduled\"])";	
        comObject.click(Xpath6,Value6);
        String Value7="Scheduled";
        String Xpath7="((//XCUIElementTypeStaticText[@name=\"Scheduled\"])[1])";	
        comObject.click(Xpath7,Value7);
        String Value8="1";
        String Xpath8="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2])";	
        comObject.clearAndType(Xpath8,Value8);
        String Value9="30";
        String Xpath9="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[3])";	
        comObject.clearAndType(Xpath9,Value9);
        String Value10="Alaram";
        String Xpath10="(//XCUIElementTypeButton[@name=\"None\"])";	
        comObject.click(Xpath10,Value10);
        String Value11="00";
        String Xpath11="(//XCUIElementTypeStaticText[@name=\"00\"])";	
        comObject.click(Xpath11,Value11);
        String Value12="Campaign";
        String Xpath12="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton[7])";	
        comObject.click(Xpath12,Value12);
        String Value13="Campaign";
        String Xpath13="(//XCUIElementTypeStaticText[@name=\"8.4.01 Campaigns\"])";
        comObject.click(Xpath13,Value13);
        String Value15="Location Description ";
        String Xpath15="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1])";
        comObject.clearAndTypeWithTimeStamp(Xpath15,Value15);
        String Value16="Address ";
        String Xpath16="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[2])";
        comObject.clearAndTypeWithTimeStamp(Xpath16,Value16);
        String Value17="Carlifornia";
        String Xpath17="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[4])";	
        comObject.clearAndType(Xpath17,Value17);
        String Value18="94563";
        String Xpath18="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextField[5])";	
        comObject.clearAndType(Xpath18,Value18);
        String Value19="Add Note";
        String Xpath19="Add line";	
        comObject.clickByAccessID(Xpath19,Value19);
        String Value20="Meeting Notes ";
        String Xpath20="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeTextView)";
        comObject.clearAndTypeWithTimeStamp(Xpath20,Value20);
        String Value21="Done";
        String Xpath21="(//XCUIElementTypeStaticText[@name=\"Done\"])";
        comObject.click(Xpath21,Value21);
        String Value22="Add Product Group";
        String Xpath22="((//XCUIElementTypeButton[@name=\"Edit outline modified white\"])[2])";
        comObject.click(Xpath22,Value22);
        String Value23="Product Group";
        String Xpath23="Total Funds";	
        comObject.clickByAccessID(Xpath23,Value23);
        String Value24="Done";
        String Xpath24="(//XCUIElementTypeStaticText[@name=\"Done\"])";	
        comObject.click(Xpath24,Value24);
        String Value14="2";
        String Xpath14="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[4])";
        comObject.clearAndType(Xpath14,Value14);
        String Value25="Save";
        String Xpath25="(//XCUIElementTypeStaticText[@name=\"Save\"])";	
        comObject.click(Xpath25,Value25);
        //Need To Add Attendees
        
		}
		else{
			System.out.println("Add Meeting Function Fail:" );
		}
	}
	public void VerifyMeetingInFirm() {
		comObject.firmLookup();
		String Value="Activities";
	    String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
	    comObject.click(Xpath,Value);
	    String Value1="Activities Header";
	    String Xpath1="((//XCUIElementTypeStaticText[@name=\"Activities\"])[1])";
	    comObject.verifyTrueElementEnable(Xpath1,Value1);
	    String Value3="Activities Type Drop down";
	    String Xpath3="(//XCUIElementTypeOther[@name=\"selector, currently selected item is:(All)\"])";
	    comObject.click(Xpath3,Value3);
	    String Value4="Meeting";
	    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Meeting\"])";
	    comObject.click(Xpath4,Value4);	
	    String Value5="Meeting Description";
	    String Xpath5="(//XCUIElementTypeOther[contains(@name,\"Meeting Description\")])";
	    comObject.click(Xpath5,Value5);
	    String Value6="Meeting Notes";
	    String Xpath6="(//XCUIElementTypeOther[contains(@name,\"Meeting Notes\")])";
	    comObject.verifyTrueElementEnable(Xpath6,Value6);
	    String Value7="Close";
	    String Xpath7="(//XCUIElementTypeButton[@name=\"Close\"])";
	    comObject.click(Xpath7,Value7); 
	}
	
	public void repProfileEditMeeting() {
		comObject.repLookup();
		String Value="Activities";
	    String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
	    comObject.click(Xpath,Value);
	    String Value1="Meeting Icon";
	    String Xpath1="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[1])";
	    comObject.click(Xpath1,Value1);
	    String Value2="Scheduled";
	    String Xpath2="(//XCUIElementTypeButton[@name=\"Scheduled\"])";	
	    comObject.click(Xpath2,Value2);
	    String Value3="Canceled";
	    String Xpath3="(//XCUIElementTypeStaticText[@name=\"Canceled\"])";	
	    comObject.click(Xpath3,Value3);
	    String Value4="Save";
	    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Save\"])";	
	    comObject.click(Xpath4,Value4);       
	}
	public void repProfileAddScheduledCall() {
		comObject.repLookup();
		String Value="Activities";
	    String Xpath="(//XCUIElementTypeButton[@name=\"Activities\"])";	
	    comObject.click(Xpath,Value);
	    String Value1="Plus Icon";
	    String Xpath1="Add line";	
	    comObject.clickByAccessID(Xpath1,Value1);
	    String Value2="Scheduled Call";
	    String Xpath2="(//XCUIElementTypeButton[@name=\"Schedule Call\"])";
	    comObject.click(Xpath2,Value2);
	    String Value3="Call Type";
	    String Xpath3="(//XCUIElementTypeButton[@name=\"BB CAll\"])";
	    comObject.click(Xpath3,Value3);
	    String Value4="Material Follow Up";
	    String Xpath4="(//XCUIElementTypeStaticText[@name=\"Materials Follow-up\"])";
	    comObject.click(Xpath4,Value4);
	    String Value5="Time";
	    String Xpath5="(//XCUIElementTypeButton[contains(@name,\"2020\")])";
	    comObject.click(Xpath5,Value5);
	    String Value6="TODAY";
	    String Xpath6="(//XCUIElementTypeButton[@name=\"Today\"])";
	    comObject.click(Xpath6,Value6);
	    String Value7="Done";
	    String Xpath7="(//XCUIElementTypeButton[@name=\"Done\"])";
	    comObject.click(Xpath7,Value7);
	    String Value8="Priority";
	    String Xpath8="(//XCUIElementTypeButton[@name=\"Normal\"])";
	    comObject.click(Xpath8,Value8);
	    String Value9="Normal";
	    String Xpath9="((//XCUIElementTypeStaticText[@name=\"Normal\"])[1])";
	    comObject.click(Xpath9,Value9);
	    String Value10="Campaign";
	    String Xpath10="(//XCUIElementTypeButton[@name=\"Campaign\"])";	
	    comObject.click(Xpath10,Value10);
	    String Value11="Campaign value";
	    String Xpath11="(//XCUIElementTypeStaticText[@name=\"8.4.01 Campaigns\"])";
	    comObject.click(Xpath11,Value11);
	    String Value12="Calendar";
	    String Xpath12="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSwitch)";
	    comObject.click(Xpath12,Value12);
	    String Value13="Scheduled Call Notes ";
	    String Xpath13="(//XCUIElementTypeApplication[@name=\"IntelliMARS\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextView)";
	    comObject.clearAndTypeWithTimeStamp(Xpath13,Value13);
	    String Value14="Save";
	    String Xpath14="(//XCUIElementTypeStaticText[@name=\"Save\"])";	
	    comObject.click(Xpath14,Value14);
	    String Value15="Header";
	    String Xpath15="((//XCUIElementTypeStaticText[@name=\"Activities\"])[1])";
	    comObject.verifyTrueElementEnable(Xpath15,Value15);
	    String Value16="Call Icon";
	    String Xpath16="(//XCUIElementTypeButton[contains(@name,\"Scheduled Call Notes\")])";
	    comObject.verifyTrueElementEnable(Xpath16,Value16);
	   
	}
	
}



