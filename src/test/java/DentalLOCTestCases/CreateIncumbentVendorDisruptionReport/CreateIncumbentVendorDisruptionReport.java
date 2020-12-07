package DentalLOCTestCases.CreateIncumbentVendorDisruptionReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class CreateIncumbentVendorDisruptionReport extends TestBase {

	@Test(dataProvider = "getData")
public void createIncumbentVendorDisruption(String ClientName, String processName , String vendorName) throws InterruptedException, IOException {
	  
		Thread.sleep(6000);
     click("TaskHyperLink");
	 Thread.sleep(6000);
	 reset("SelectClient"); 
	  Thread.sleep(3000);
	  click("SelectClient");
	  Thread.sleep(3000); 
	  type( "SelectClient", ClientName);
	  Thread.sleep(6000);
		WebElement webElement = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
		Thread.sleep(2000);
		webElement.sendKeys(Keys.TAB); 
	  //click("LM");
	  Thread.sleep(6000);
	  click("TaskListAllTasks");
	  Thread.sleep(6000);
	 select("TaskListFilterByProcess", processName);
		Thread.sleep(6000);  
		
		//1st task
		
	 for(int i=1; i<=20;i++) {
			
			WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
			
			      System.out.println(Statusxpathvalue.getText());
			if(i==2 || i==7 ||i==10 || i==14){
					    	 // javascript executor for scroll down
				scrolldown();
					    	  }
			String INP = Statusxpathvalue.getText();

			
			String COM = "In Progress";
			
			if (INP.equalsIgnoreCase(COM)) {
				System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
				
				driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
				System.out.println("First Task clicked of Incumbent Vendor");
				Thread.sleep(20000);
				
			
				click("SelectDataFields");
				Thread.sleep(2000);
				//Multiple click on Checkbox
				for(int j=1; j<7;j++) {
					
					
					driver.findElement(By.xpath("(//*[@class='text-center'])["+j+"]")).click();	
				}
				scrollToParticularElement("SelectDataFieldscheckboxComplete");
				//click("SelectDataFieldscheckboxComplete");
				Thread.sleep(2000);
				click("SelectEndodontistsDental");
				Thread.sleep(3000);
				 
				
	              click("SelectVendorContactTask1IncumbentVendor");
				Thread.sleep(3000);
				//Cigma
				select("SelectVendorContactTask1IncumbentVendor" , vendorName);
				Thread.sleep(3000);
				scrolldown();
				
				click("CalendarIcon"); 
				//mo time to give
				Thread.sleep(1000);
				click("MonthAfter");
				Thread.sleep(3000);
				//2 below same date picker as, now date picker is not able to click date due to application issue
				datePickerGeneral("DueDateForVendorTask1IncumbentVendor");
				datePickerGeneral("DueDateForVendorTask1IncumbentVendor");
				Thread.sleep(3000);
				
				click("Complete");
				Thread.sleep(20000); 
				
				
			break;
			}
			} 
	
	click("TaskHyperLink");
		 Thread.sleep(3000);
		 reset("SelectClient"); 
		  Thread.sleep(3000);
		  click("SelectClient");
		  Thread.sleep(3000); 
		  type( "SelectClient", ClientName);
		  Thread.sleep(6000);
		  
			WebElement webElement1 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement1.sendKeys(Keys.TAB);
		 // click("LM");
		  Thread.sleep(6000);
		 select("TaskListFilterByProcess", processName);
			Thread.sleep(6000);
		
			//2nd task
	  for(int j=1; j<=20;j++) {
			
			WebElement  StatusxpathvalueforObtainDistribution  =driver.findElement(By.xpath("(//tr/td[4])["+j+"]"));
			//AllObtainDistributionReportxpathvalue
			      System.out.println(StatusxpathvalueforObtainDistribution.getText());
		
			String INPObtainDistribution = StatusxpathvalueforObtainDistribution.getText();
          
                          if(j==2 || j==7 ||j==10 || j==14){
					    	 // javascript executor for scroll down
                        	  scrolldown();
					    	  }
			
		String COM = "In Progress";
			
   		   if (INPObtainDistribution.equalsIgnoreCase(COM)) {
   			System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).getText());
				driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).click();
				System.out.println("Second Task clicked of Incumbent Vendor");
				Thread.sleep(20000);
				
				
				click("ObtainDistributionAddAttachment");
				Thread.sleep(3000);
				
				//type(String locator, String value)
				//AutoIT
				
				//To check
				Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
				Thread.sleep(10000);
				scrolldown();
							
	     click("ObtainDistributionTask2Complete");
	     Thread.sleep(15000);
	     break; 
	  } } 
	  
	  
	  Thread.sleep(5000);
		click("TaskHyperLink");
		 Thread.sleep(6000);
		 reset("SelectClient"); 
		  Thread.sleep(6000);
		  click("SelectClient");
		  Thread.sleep(6000); 
		  type( "SelectClient", ClientName);
		  Thread.sleep(6000);
			WebElement webElement2 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement2.sendKeys(Keys.TAB);
		 // click("LM");
		  Thread.sleep(6000);
		 
		 
		 select("TaskListFilterByProcess", processName);
			Thread.sleep(5000);
			
			//3rd Task
			
			for(int k=1; k<=20;k++) {
				
				WebElement  StatusxpathvalueforValidatescrubDisruption  =driver.findElement(By.xpath("(//tr/td[4])["+k+"]"));
				//AllObtainDistributionReportxpathvalue
				      System.out.println(StatusxpathvalueforValidatescrubDisruption.getText());
			
				      if(k==2 || k==7 ||k==10 || k==14){
					    	 // javascript executor for scroll down
				    	  scrolldown();
					    	  }
				String INPValidatescrubDisruption = StatusxpathvalueforValidatescrubDisruption.getText();

				
			String COM = "In Progress";
				
	   		   if (INPValidatescrubDisruption.equalsIgnoreCase(COM)) {
	   			System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).getText());
					driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).click();
					System.out.println("Third Task clicked of Incumbent Vendor");
					Thread.sleep(20000);
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, -250)", "");
					Thread.sleep(1500);
					click("DownloadVendorExperience");
					Thread.sleep(3000);
					scrolldown();
					scrolldown();
					click("ValidateScrubDisruption3taskselectfieldstoincludeinRFP");
					Thread.sleep(3000);
					for(int n=1; n<4;n++) {
						
						
						driver.findElement(By.xpath("(//*[@class='text-center'])["+n+"]")).click();	
					}
				click("SelectDataFieldscheckboxComplete");
				Thread.sleep(2000);
				click("IncumbentVendorDisruptionTask3Complete");
				 Thread.sleep(15000);
				
					break;	
	   		   }
	   		   }
	   		   }



@DataProvider
public Object[][] getData(){
	
	String sheetName = "CreateIncumbentVendor";
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