package MobileLocktonConnect;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileConnect extends TestBase{

   static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"cb88922c");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
		capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
	
		capabilities.setCapability(MobileCapabilityType.VERSION, "8.0.0");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		  
		  //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		 
		 driver.get("https://dev.locktonconnect.com/clients/home");
		
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("scugno@lockton.com");
		 
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");	
			
		 driver.findElement(By.xpath("//input[@class='btn btn-primary btn-block btn-lg']")).click();
		 
		 Thread.sleep(9000);
		 driver.findElement(By.id("companyInformationTab")).click();
		// driver.findElement(By.xpath("//a[contains(.,'Task')]")).click();
		//a[contains(.,'Task')]
		 		
		  /*driver.get("http://google.com");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.name("q")).sendKeys("LocktonConnect!!!");*/
        driver.quit();
        
        
	}

}
