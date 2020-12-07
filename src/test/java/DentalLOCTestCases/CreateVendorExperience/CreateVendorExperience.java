package DentalLOCTestCases.CreateVendorExperience;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class CreateVendorExperience extends TestBase {

	@Test(dataProvider = "getData")

	public void createVendorExperience(String clientName, String processName , String vendorName , String template , String VendorDueDate) throws InterruptedException, IOException, AWTException {

		Thread.sleep(6000);
		Thread.sleep(6000);
		click("SelectClient");
		reset("SelectClient");
		Thread.sleep(6000);
		click("SelectClient");
		Thread.sleep(6000);

		type( "SelectClient", clientName);

		WebElement webElement = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
		Thread.sleep(2000);
		webElement.sendKeys(Keys.TAB);
		//click("LM");
		Thread.sleep(6000);

		//Thread.sleep(3000);

		click("TaskListAllTasks");
		Thread.sleep(3000);
		select("TaskListFilterByProcess", processName);
		Thread.sleep(5000);
		//1st task
		for(int i=1; i<=20;i++) {

			WebElement xpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));

			System.out.println(xpathvalue.getText());

			if(i==2 || i==7 ||i==10 || i==14){
				// javascript executor for scroll down
				scrolldown();
			}
			String INP = xpathvalue.getText();


			String COM = "In Progress";

			if (INP.equalsIgnoreCase(COM)) {
				//1st task
				driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
				System.out.println("First Task clicked of Create vendor");



				//click("CreateUndefinedRequestDentalForUtilization");
				//More time to give
				Thread.sleep(15000);

				click("SelectVendorContact");
				Thread.sleep(3000);
				select("SelectVendorContact" , vendorName);

				Thread.sleep(3000);
				//click("SelectVendorContact");
				//Thread.sleep(3000);

				//click("EmailTemplate");
				//type("EmailTemplate", template);
				//Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0, 500)", "");
				click("CalendarIcon");



				//more time to give
				Thread.sleep(3000);
				//click("MonthAfter");
				//Thread.sleep(3000);
				//click("MonthAfter");
				datePickerGeneral("DueDateForVendor");


				Thread.sleep(3000);

				click("Complete");
				Thread.sleep(8000); 
				break;

			} } 
		//first task complete
		//2nd task

		Thread.sleep(6000); 
		click("TaskHyperLink");
		Thread.sleep(3000);
		click("SelectClient");
		reset("SelectClient");
		Thread.sleep(6000);
		click("SelectClient");
		Thread.sleep(6000);

		type("SelectClient", clientName);
		Thread.sleep(4000);
		WebElement webElement1 =driver.findElement(By.xpath(OR.getProperty("SelectClient")));
		webElement1.sendKeys(Keys.TAB);
		Thread.sleep(7000); 
		click("TaskListAllTasks");
		Thread.sleep(7000);
		select("TaskListFilterByProcess", processName);

		Thread.sleep(6000);


		for(int j=1; j<=20;j++) {

			WebElement DynamicObtainutilizationclaimVsPremiumReportInProgress =driver.findElement(By.xpath("(//tr/td[4])["+j+"]"));

			System.out.println(DynamicObtainutilizationclaimVsPremiumReportInProgress.getText());

			if(j==2 || j==7 ||j==10 || j==14){
				// javascript executor for scroll down
				scrolldown();
			}
			String INP1 = DynamicObtainutilizationclaimVsPremiumReportInProgress.getText();
			String COM = "In Progress";
			if (INP1.equalsIgnoreCase(COM)) {
				//1st task
				//click("Obtainutilization/claimVsPremiumReport");
				driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).click();
				System.out.println("Second Task clicked of Create vendor");




				Thread.sleep(20000);
				click("ObtainUtilizationAddAttachment");
				Thread.sleep(3000);
				//AutoIT

				Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");

				Thread.sleep(7000); // scroll to botton to include
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(7000);

				click("Complete"); //more wait to include
				Thread.sleep(12000); 

				break;  } 
		} 


		Thread.sleep(3000); 
		click("TaskHyperLink");
		Thread.sleep(3000);

		click("SelectClient");
		reset("SelectClient");
		Thread.sleep(3000);
		click("SelectClient");
		Thread.sleep(3000);
		type("SelectClient", clientName);
		Thread.sleep(4000);
		WebElement webElement3 =driver.findElement(By.xpath(OR.getProperty("SelectClient")));
		webElement3.sendKeys(Keys.TAB);
		Thread.sleep(8000); 
		click("TaskListAllTasks");
		Thread.sleep(5000);
		select("TaskListFilterByProcess", processName);
		Thread.sleep(3000);
		//3rd Task

		for(int k=1; k<=20;k++) 
		{

			WebElement ReviewAndSaveUtilizationClaimVersusPremiumReportInProgress  =driver.findElement(By.xpath("(//tr/td[4])["+k+"]"));

			System.out.println(ReviewAndSaveUtilizationClaimVersusPremiumReportInProgress.getText());
			//k==2 need to do
			if(k==2 || k==7 ||k==10 || k==14){
				// javascript executor for scroll down
				scrolldown();
			}
			String INP2 = ReviewAndSaveUtilizationClaimVersusPremiumReportInProgress.getText();
			String COM = "In Progress";
			if (INP2.equalsIgnoreCase(COM)) {
				//1st task
				//click("Obtainutilization/claimVsPremiumReport");
				driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).click();

				System.out.println("Third Task clicked of Create vendor");

				//click("ReviewAndSaveUtilization/ClaimVersusPremiumReport");

				Thread.sleep(15000);

				click("CreateVendor3TaskApproveButton");
				Thread.sleep(4000);

				click("Complete"); 
				Thread.sleep(8000);

				break;	  }
		} 

		Thread.sleep(5000); 
		click("TaskHyperLink");
		Thread.sleep(3000);
		click("SelectClient");
		Thread.sleep(1000);
		reset("SelectClient");
		Thread.sleep(6000);
		click("SelectClient");
		//Thread.sleep(6000);
		Thread.sleep(3000);
		type("SelectClient", clientName);
		Thread.sleep(4000);
		WebElement webElement4 =driver.findElement(By.xpath(OR.getProperty("SelectClient")));
		webElement4.sendKeys(Keys.TAB); 
		Thread.sleep(8000); 

		click("TaskListAllTasks");
		Thread.sleep(5000);

		select("TaskListFilterByProcess", processName);
		Thread.sleep(5000);

		//4th Task

		for(int l=1; l<=20;l++) 
		{

			WebElement SelectModifyReportsForRFPInProgress  =driver.findElement(By.xpath("(//tr/td[4])["+l+"]"));

			System.out.println(SelectModifyReportsForRFPInProgress.getText());
			//l=2  nned to do
			if(l==2 || l==7 ||l==10 || l==14 ){
				// javascript executor for scroll down
				scrolldown();
			}
			String INP3 = SelectModifyReportsForRFPInProgress.getText();
			String COM = "In Progress";
			if (INP3.equalsIgnoreCase(COM)) {

				//click("Obtainutilization/claimVsPremiumReport");
				driver.findElement(By.xpath("(//td[@class='link'])["+l+"]")).click();
				System.out.println("Fourth Task clicked of Create vendor");

				Thread.sleep(20000);


				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("window.scrollBy(0,-250)", "");

				click("CreateVendor4TaskCheckbox");
				Thread.sleep(3000);
				js2.executeScript("window.scrollBy(0,250)", "");
				//One more upload attachment  is there
				Thread.sleep(3000);
				click("Complete");
				Thread.sleep(7000); 
				scrolldown();
				Thread.sleep(4000);
				scrollUP();
				break;  } 
		}

	}  


	@DataProvider
	public Object[][] getData(){

		String sheetName = "CreateVendor";
		int rows = dentalexcel.getRowCount(sheetName);
		int cols = dentalexcel.getColumnCount(sheetName);

		Object[][] data = new Object[rows-1][cols];

		for (int rowNum=2; rowNum<=rows; rowNum++)
		{
			for (int colNum=0; colNum<cols; colNum++)
			{
				data[rowNum-2][colNum] = dentalexcel.getCellData(sheetName, colNum, rowNum);
			}

		}
		return data;

	}	
}
