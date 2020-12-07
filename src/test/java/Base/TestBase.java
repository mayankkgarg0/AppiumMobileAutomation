package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExcelReader;
import Utilities.ExtentManager;

public class TestBase {

	/*
	 * WebDrivers : Properties : Logs - Log4j jar , .log, log4j.properties
	 * ExtendedReports DB Excel Mail ReportNG, ExtentReports Jenkins
	 */
	public static WebDriver driver;
	
	public static NgWebDriver ngWebDriver;
	JavascriptExecutor jsDriver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\Vendor_Screen_test_Data.xlsx");
	public static ExcelReader dentalexcel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\Dental_LOC_Test_Data.xlsx");
	public static ExcelReader renewalexcel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\Renewal_DatA.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUp() {

		if (driver == null ) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
				ngWebDriver.waitForAngularRequestsToFinish();
			}

			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			// driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
			// TimeUnit.SECONDS);
			wait=new WebDriverWait(driver, 5);
			
	
		}

	}
	
	public void MobileCapability() {
		
		
		
	}
	//For Client in place tab
	public void WebelementTab(){
		WebElement webElement =driver.findElement(By.xpath(OR.getProperty("SelectClient")));
			webElement.sendKeys(Keys.TAB);
		
	}
	//Scroll UP
public void scrollUP() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -250)", "");
		
	}
  //scroll down to particular extent
	public void scrolldown() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 250)", "");
		
	}
	
//scroll down to bottom of page
	public void scrollToBotton() {
		
		 ((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	//Scroll to Particular Element Second 

public void scrollToParticularElementSecond(String locator) {
		
	WebElement Project = driver.findElement(By.xpath(OR.getProperty(locator)));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);",Project);
	Project.click();
	test.log(LogStatus.INFO, "scrollToParticularElementSecond : " + locator );
	//EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver6);
	//eventFiringWebDriver.executeScript("document.querySelector('#gridview-1032').scrollTop=3000");
	}
	
	//scroll down to particular element of page
	public void scrollToParticularElement(String locator) {
		
		WebElement element = driver.findElement(By.xpath(OR.getProperty(locator)));
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();",element);
		   test.log(LogStatus.INFO, "scrollToParticularElement : " + locator ); 
	}
	
	// is element present method
	public boolean isElementPresent(By by) {
		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}

	}
	
	//loop
	
		


	// type method

	public void type(String locator, String value) {

		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as : " + value);

	}

	// click method

	public void click(String locator) {

		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		test.log(LogStatus.INFO, "Clicking on : " + locator);

	}
	//GetText
	public String getText(String locator) {

		String GetTextValue=driver.findElement(By.xpath(OR.getProperty(locator))).getText();
		
		return GetTextValue;

	}

	

	
	// verify true method
	public void verifyTrue(String locator) {

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty(locator))), "Element Not Found");
		
	}

	// verify false method
	public void verifyFalse(String locator) {

		Assert.assertFalse(isElementPresent(By.xpath(OR.getProperty(locator))));

	}

	// wait Until

	public void waitUntil(String locator) {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(locator))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(locator))));
	}

	// select dropdown values method

	static WebElement dropdown;

	public void select(String locator, String value) {
		
		WebElement dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		Select select = new Select(dropdown);
		
		select.selectByVisibleText(value);
		
		test.log(LogStatus.INFO, "Selected value from : " + locator + " is :  " + value);

	}
	
	// select multi choice checkbox dropdown value
	public void Multiselectcheckbox( String value) {
	
		if(driver.findElement(By.xpath("//li/div[text()='"+value+"']")).isEnabled()){
			
			driver.findElement(By.xpath("//li/div[text()='"+value+"']")).click();
			System.out.println("Element is Present");
			test.log(LogStatus.INFO, "Multiselectcheckbox value is :  " + value);
			} 
		     
		//test.log(LogStatus.INFO, "Selected value from : " + locator + " is :  " + value);
}

	// select multi choice dropdown value
	public void selectcheckbox(String locator, String value) {
		dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		Select select = new Select(dropdown);
		select.selectByValue(value);
		
		test.log(LogStatus.INFO, "Selected value from : " + locator + " is :  " + value);

	}
	// Reset the fields method

	public void reset(String locator) {

		driver.findElement(By.xpath(OR.getProperty(locator))).clear();

	}
	

	
	//DatePickerGeneral
	public void datePickerGeneral(String locator) {
		// Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("dd");
	
		 //get current date time with Date()
		 Date date = new Date();
		 System.out.println(date);
		 Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
		 
		 // Now format the date
		String CurrentDate= dateFormat.format(tomorrow);
		// String CurrentDate= dateFormat.format(date);
		 System.out.println(CurrentDate);
		
		String dateParts[] = CurrentDate.split("");
		 String First  = dateParts[0];
		 String Second  = dateParts[1];
		 String value1="0";
		 System.out.println(First +"+"+ Second);
		 if(First.equalsIgnoreCase(value1)) {
			 CurrentDate = Second;
			 System.out.println(CurrentDate);
		 }
		 
		WebElement dateWidgetFrom = driver.findElement(By.xpath(OR.getProperty(locator))); 
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		for (WebElement cell: columns) {
              System.out.println("Calender Date value"+cell.getText());
             //if (cell.getText().equals("CurrentDate"))
              if (CurrentDate.equalsIgnoreCase(cell.getText())) {
                cell.click();
                test.log(LogStatus.INFO, "Selected DayafterDate :  " + cell);
                break;
           }
            
        }
	}	
	
	
	private void If(boolean equalsIgnoreCase) {
		// TODO Auto-generated method stub
		
	}

	//DatePicker
	public void datePickerFrom(String locator, String value) {
		System.out.println(value);
		WebElement dateWidgetFrom = driver.findElement(By.xpath(OR.getProperty(locator))); 
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		for (WebElement cell: columns) {
            System.out.println(cell.getText());
            if (cell.getText().equals(value)) {
                cell.click();
                test.log(LogStatus.INFO, "Selected datePickerFrom :  " + cell);
                break;
           }
            
        }
		
	}
	
	public void datePickerTo(String locator , String value) {
		WebElement dateWidgetFrom = driver.findElement(By.xpath(OR.getProperty(locator))); 
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		for (WebElement cell: columns) {
			System.out.println(cell.getText());
            if (cell.getText().equals(value)) {
                cell.click();
                test.log(LogStatus.INFO, "Selected datePickerTo :  " + cell);
                break;
           }
            
        }
		
	}
	//ProcessManager Login
public void ProcessManagerloginToLockTon() throws InterruptedException {
	
		
		type("LoginUsername", "kbeinecke@lockton.com");
		type("Loginpass", "123456");
		click("LoginBtn");
		//waitUntil("VendorsHyperLink");
		
		Thread.sleep(3000);
		verifyTrue("DashBoardHyperLink");
		
		Reporter.log("Login Successfully");	
		
	}
//ProcessAssociate Login
public void ProcessAssociateloginToLockTon() throws InterruptedException {
	
	
	type("LoginUsername", "scugno@lockton.com");
	type("Loginpass", "123456");
	click("LoginBtn");
	//waitUntil("VendorsHyperLink");
	
	Thread.sleep(6000);
	verifyTrue("DashBoardHyperLink");
	
	Reporter.log("Login Successfully");	
	
}

      //Process Associate Logout
        public void ProcessAssociateProcessManagerLogout() throws InterruptedException {
	    driver.findElement(By.xpath("(//div[@class='no-image'])[1]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[text()='Logout']")).click();
	    Thread.sleep(5000);
    }
		
		
	

	@AfterSuite
	public void tearDown() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();

	}

}
