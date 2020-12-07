package DentalLOCTestCases.RFPtoPreaentationCreation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import Base.TestBase;
import Utilities.TestUtil;

public class CreateRFP extends TestBase {
	
	@Test(dataProvider="getData")
	public void createRFP(String ClientName, String loc, String PlanType, String planName, String reasonForRFP,
	  String IntendToBidDateValue, String lastDateofRFPSubmission, String Vendor, String taskNotes ) throws InterruptedException, AWTException  {
		
		Thread.sleep(6000);
	    click("TaskHyperLink");
		Thread.sleep(4000);
		
		click("PlansHyperLink");
		
	//	waitUntil("PlansHyperLink");
		  Thread.sleep(10000);
		
		    
		  reset("SelectClient"); 
		  Thread.sleep(6000);
		  click("SelectClient");
		  Thread.sleep(2000);
		//click("LM");
		 type("SelectClient", ClientName);
		 Thread.sleep(4000);
			WebElement webElement =driver.findElement(By.xpath(OR.getProperty("SelectClient")));
		webElement.sendKeys(Keys.TAB);
//		
		
		
			
		  
		  Thread.sleep(8000);
		//  waitUntil("ClientPlans");
		
		  
		 click("ClientPlans");
		 
		
    	Thread.sleep(6000);
	//	waitUntil("CreateRFPBtn");
		click("CreateRFPBtn");
		Thread.sleep(6000);
		waitUntil("CreateRFPLOC");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click("CreateRFPLOC");
		Thread.sleep(3000);
		type("CreateRFPLOCDropBox" , loc);
		
		
		Thread.sleep(3000);
		//new Actions(driver).sendKeys(Keys.TAB);
		Thread.sleep(5000);
		   
		
		
		   //click("CreateRFPTaskNotes");
		   Thread.sleep(3000);
		click("CreateRFPPlanType");
		

//		 
		//Mouse Hover to do

		Thread.sleep(5000);
		click("CreateRFPPlanType");
		Thread.sleep(3000);
		
		
		   
		 
		Multiselectcheckbox(PlanType);
		Thread.sleep(6000);
		click("CreateRFPTaskNotes");
		   Thread.sleep(5000);
		click("CreateRFPPlanName");
		Thread.sleep(3000);
		
		Multiselectcheckbox(planName);
		
		
		Thread.sleep(3000); 
		
		
		
		
		
		click("CalendarIcon");
		Thread.sleep(3000);
		//click("MonthAfter");
	     Thread.sleep(1000);
	     
	   //1st date
	     datePickerFrom("IntentToBidDate" , IntendToBidDateValue); 
		//datePickerGeneral("IntentToBidDate");
		//datePickerFrom("IntentToBidDate");
		//last date for RFP calender icon
		Thread.sleep(6000);
		
		click("CalenderIconTo");
		Thread.sleep(1000);
		click("MonthAfter");
		Thread.sleep(3000);
		
		//2nd Date
		datePickerTo("LatDateForRFP" , lastDateofRFPSubmission);
		
		//datePickerTo("LatDateForRFP");
		
		Thread.sleep(6000);
		select("CreateRFPReasonForRFP",reasonForRFP);
		Thread.sleep(3000);
		click("CreateRFPSelectVendors");
		Thread.sleep(3000);
		
		//click("VendorDropDownValue");
		Thread.sleep(3000);
		Multiselectcheckbox(Vendor);
		
		//click("CreateRFPSelectVendors");
		
		Thread.sleep(3000);
		type("CreateRFPTaskNotes",taskNotes);
		
		Thread.sleep(3000);
		click("CreateRFPTask");
		verifyTrue("CreateRFPTask"); 
		
		Thread.sleep(10000);	
		
	}	
		
  
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "CreateRFP";
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
	

