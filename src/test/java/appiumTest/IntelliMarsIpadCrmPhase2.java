package appiumTest;
import java.net.MalformedURLException;

import org.aspectj.lang.annotation.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appiumPages.AppiumHomePage;
import appiumPages.Common;
import appiumPages.RepLookupPage;

public class IntelliMarsIpadCrmPhase2 {
	AppiumHomePage homeObj=new AppiumHomePage();
	RepLookupPage repObj=new RepLookupPage();
	Common comObject=new Common();
	@BeforeTest
	public void login() throws MalformedURLException {
		homeObj.setUp();
	}
	@AfterTest
	public void terminateBrowser(){
		homeObj.driver.quit();
	}

	@BeforeMethod
	public void menuOptionClick() {
		comObject.menuOption();
	}
	@Test(priority=0,groups={"PHASE2REP"})
		public void phase2verifyRepLookup() throws MalformedURLException, InterruptedException {
		repObj.verifyRepLookup();
		
	}
	@Test(priority=1,groups={"PHASE2REP"})
	public void phase2AddMeeting()  {
	repObj.repProfileAddMeeting();
	}
	
	@Test(priority=2,groups={"PHASE2REP"})	
	public void phase2VerifyMeetingInFirm() {
	repObj.VerifyMeetingInFirm();
	}
	@Test(priority=3,groups={"PHASE2REP"})
	public void phase2EditMeeting() {
	repObj.repProfileEditMeeting();	
	}
	@Test(priority=4,groups={"PHASE2REP"})
	public void phase2AddScheduledCall() {
	repObj.repProfileAddScheduledCall();		
	}
}
