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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileConnect2 {

	static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"cb88922c");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
		capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
		
		capabilities.setCapability(MobileCapabilityType.VERSION, "8.0.0");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		
		 
		 driver.get("https://www.amazon.com");
		 
		 	driver.findElement(By.id("nav-search-keywords")).sendKeys("abc test");
        driver.quit();
	}

}
