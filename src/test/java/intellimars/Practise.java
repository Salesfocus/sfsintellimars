package intellimars;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/Ashishv/eclipse-workspace/IntelliMars/chromedriver");
		WebDriver driver= new ChromeDriver();
		ChromeOptions opt = new ChromeOptions();
		driver.get("https://brokercheck.finra.org/");
		driver.getTitle();
		
		//driver.quit();
		//driver.wait(500);
		//Set<String> handler = driver.getWindowHandles();
		
		String handler = driver.getWindowHandle();
		System.out.println("window handler is  "   + handler);
		driver.switchTo().window(handler);
		System.out.println("Switched to window");
		
		//driver.findElement(By.xpath("//*[@name='session[username_or_email]' and @type='text']")).click();
		/*driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@name='session[username_or_email]' and @type='text']")).sendKeys("avardhineni@phxa.com");
		System.out.println("Email is entered");
		//password
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@name='session[password]' and @type='password']")).click();
		driver.findElement(By.xpath("//*[@name='session[password]' and @type='password']")).sendKeys("iamback9");
		
		driver.findElement(By.xpath("//*[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-vw2c0b r-1777fci r-eljoum r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0']")).click();
		driver.findElement(By.xpath("//*[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).click();
		driver.findElement(By.xpath("//*[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).sendKeys("ash", Keys.RETURN, "gfgcvv");
		//class="public-DraftStyleDefault-block public-DraftStyleDefault-ltr"*/
	    driver.findElement(By.xpath("//*[@placeholder=\"Name or CRD#\"]")).sendKeys("Ashish");
	    driver.findElement(By.xpath("//button[@type='submit'][1]")).click();
	
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	int j = driver.findElements(By.xpath("//div[@class=\"md-title\"]/span")).size();
	 List<WebElement> Names = driver.findElement(By.xpath("//div[@class=\"md-title\"]/span[contains(text(), ASHISH)]"));
	System.out.println(j);
  

	    
	
	
	for (int i = 0; i <= j; i++) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(Names.get(i).getText());
		//String Rep=driver.findElement(By.xpath("//div[@class=\"md-title\"]/span[contains(text(), ASHISH)")).getText();
		
		//System.out.println("Rep name is"+Rep);
		
	}
		
	
	}

}
