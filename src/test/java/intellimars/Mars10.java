package intellimars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Mars10 {
	public WebDriver driver;
	
	
	@BeforeSuite
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/Ashishv/eclipse-workspace/IntelliMars/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://192.168.169.175/MARSWeb2/Login");
		
	boolean error= driver.findElement(By.xpath("//button[text()=\"Advanced\"]")).isDisplayed();
	
	if(error) {
		driver.findElement(By.xpath("//button[text()=\"Advanced\"]")).click();
		
	}
	
		
		
	}
	@BeforeTest
	public void login(){
		
		
		
	}
	
	
	

}
