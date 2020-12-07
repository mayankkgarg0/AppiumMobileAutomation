package DentalLOCTestCases.CreateMarketingCensusRequest;

import java.awt.Window;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import Base.TestBase;

public class CreateMarketingCensusRequest   extends TestBase {

	
	@Test(dataProvider = "getData")
	public void createMarketingCensusRequest(String ClientName, String processName , String vendorName, 
			String taskOneDropDownOneLOC, String Dropdown2ValueMarketCensusTask12pageLOC , String Dropdown3ValueMarketCensusTask12pageLOC ,
			String Dropdown1ValueMarketCensusTask32pageFileIncludes ) throws InterruptedException, IOException {
		 
		
		Thread.sleep(6000);
		    click("TaskHyperLink");
		Thread.sleep(6000);
		 reset("SelectClient");; 
		  Thread.sleep(2000);
		  click("SelectClient");
		  Thread.sleep(2000);
		  type( "SelectClient", ClientName);
			
			WebElement webElement = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement.sendKeys(Keys.TAB);
		  //click("LM");//thread increase
		  Thread.sleep(6000);
		 
		 
		 select("TaskListFilterByProcess", processName);
			Thread.sleep(6000);  
			select("TaskListFilterByProcess", processName);
			Thread.sleep(6000);
			//Market Census in process select is not reflecting for filtering task for market census for automation?
			//1st task
				for(int i=1; i<=20;i++) {
				
				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
				
				      System.out.println(Statusxpathvalue.getText());
				if(i==3 || i==7 ||i==10 || i==14){
						    	 // javascript executor for scroll down
					scrolldown();
						    	  }
				String INP = Statusxpathvalue.getText();

				
				String COM = "In Progress";
				System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
				if (INP.equalsIgnoreCase(COM)) {
					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
					driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
					System.out.println("First Task clicked of Marketing Census");
					
					Thread.sleep(15000);
					//to scroll to top of page
					((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
					Thread.sleep(1000);
					scrolldown(); 
					//scrollUP();
					   click("Dropdown1MarketCensusTask12pageLOC");
					   Thread.sleep(3000);
					//for Cigna scott value
					   Multiselectcheckbox(taskOneDropDownOneLOC);
					   Thread.sleep(3000);
					   
					   click("Dropdown1MarketCensusTask12pageLOC");
					   
					   //click("Dropdown2MarketCensusTask12pageLOC");
					   Thread.sleep(3000);
					   Multiselectcheckbox(Dropdown2ValueMarketCensusTask12pageLOC);
					   Thread.sleep(3000);
					   click("Dropdown2MarketCensusTask12pageLOC");
					
					   
					   //click("Dropdown3MarketCensusTask12pageLOC");
					   Thread.sleep(3000);
					   Multiselectcheckbox(Dropdown3ValueMarketCensusTask12pageLOC);
					   Thread.sleep(3000);
					   //click("Dropdown3MarketCensusTask12pageLOC");
					   
					   click("SelectCensusDataFieldsMarketCensusTask12pageLOC");
					   Thread.sleep(5000);
					   click("EmployeeFirstNameMarketCensusTask12pageLOC");
					   Thread.sleep(3000);
					   scrollToParticularElement("MarketCensustaskoneSelectCensusnewWindowComplete");
					   
					  
				  
					   // driver.switchTo().activeElement();
					   Thread.sleep(3000);
					   scrollToBotton();
					   Thread.sleep(3000);
					   click("CalendarIcon");
					   Thread.sleep(3000);
					   
					   datePickerGeneral("DuedateforclienttoreturnCensus");
				       
					   Thread.sleep(3000);
					   click("MarketCensustaskoneComplete");
					   Thread.sleep(7000);
					break;
					}
					
}  
	//Logout and Login Code to paste
	 Thread.sleep(3000);
		 ProcessAssociateProcessManagerLogout();
		 Thread.sleep(6000);
		 //Login to Login Test processManager
		 ProcessManagerloginToLockTon() ; 
		 Thread.sleep(8000);
		
		    click("TaskHyperLink");
		Thread.sleep(6000);
		 reset("SelectClient");; 
		  Thread.sleep(6000);
		  click("SelectClient");
		  Thread.sleep(6000); 
		  type( "SelectClient", ClientName);
			
			WebElement webElement1 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement1.sendKeys(Keys.TAB);
		//  click("LM");
		  Thread.sleep(6000);
		 
		 select("TaskListFilterByProcess", processName);
			Thread.sleep(5000); 
	    
			//2nd Task
	
               for(int j=1; j<=20;j++) {
				
				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+j+"]"));
				
				      System.out.println(Statusxpathvalue.getText());
				if(j==3 || j==7 ||j==10 || j==14){
						    	 // javascript executor for scroll down
					scrolldown();
						    	  }
				String INP = Statusxpathvalue.getText();

				
				String COM = "In Progress";
				
				if (INP.equalsIgnoreCase(COM)) {
					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).getText());
					driver.findElement(By.xpath("(//td[@class='link'])["+j+"]")).click();
					System.out.println("Second Task clicked of Marketing Census");
					Thread.sleep(9000);
					scrollToBotton();
					Thread.sleep(3000);
					click("PeerReviewCensusRequestTask3approveButton");
					Thread.sleep(3000);
					click("MarketCensustaskTwoComplete");
					Thread.sleep(3000);
					break;
				}
				} 
			
			//Logout Process Manager
		ProcessAssociateProcessManagerLogout();
		Thread.sleep(3000);
		//Login Process Associate
		ProcessAssociateloginToLockTon(); 
		
		Thread.sleep(8000);
	
		  click("TaskHyperLink");
			Thread.sleep(6000);
			 reset("SelectClient");; 
			  Thread.sleep(6000);
			  click("SelectClient");
			  Thread.sleep(6000); 
			  type( "SelectClient", ClientName);
				
				WebElement webElement2 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
				Thread.sleep(2000);
				webElement2.sendKeys(Keys.TAB);
			 // click("LM");
			  Thread.sleep(6000);
			 
			 select("TaskListFilterByProcess", processName);
				Thread.sleep(5000); 
		    
				//3rd Task
		
	               for(int k=1; k<=20;k++) {
					
					WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+k+"]"));
					
					      System.out.println(Statusxpathvalue.getText());
					if(k==2 || k==7 ||k==10 || k==14){
							    	 // javascript executor for scroll down
						scrolldown();
							    	  }
					String INP = Statusxpathvalue.getText();

					
					String COM = "In Progress";
					
					if (INP.equalsIgnoreCase(COM)) {
						System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).getText());
						Thread.sleep(3000);
						driver.findElement(By.xpath("(//td[@class='link'])["+k+"]")).click();
						System.out.println("Third Task clicked of Marketing Census");
						Thread.sleep(9000);
						scrollToBotton();
						scrollUP();
						Thread.sleep(3000);
						click("ObtainCensusInfoTheFileIncludes");
						Thread.sleep(3000);
						
						
						Multiselectcheckbox(Dropdown1ValueMarketCensusTask32pageFileIncludes);
						Thread.sleep(3000);
						click("CalendarIcon");
						Thread.sleep(3000);
						datePickerGeneral("DateObtaincensusInfotask2");
						Thread.sleep(3000);
						click("DragAndDrop");
						Thread.sleep(3000);
						Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
						Thread.sleep(5000);
						//break point need to check
						scrollToBotton();
						click("complete");
						Thread.sleep(5000);
						break;
					}} 
	           //-----------
		
                         //4th Task
 Thread.sleep(6000);
 
		click("TaskHyperLink");
		Thread.sleep(6000);
		 reset("SelectClient");; 
		  Thread.sleep(6000);
		  click("SelectClient");
		  Thread.sleep(6000); 
		  type( "SelectClient", ClientName);
			
			WebElement webElement3 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement3.sendKeys(Keys.TAB);
		  //click("LM");
		  Thread.sleep(6000);
		 
		 select("TaskListFilterByProcess", processName);
			Thread.sleep(5000);   
	               
	               for(int l=1; l<=20;l++) {
						
						WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+l+"]"));
						
						      System.out.println(Statusxpathvalue.getText());
						if(l==2 || l==7 ||l==10 || l==14){
								    	 // javascript executor for scroll down
							scrolldown();
								    	  }
						String INP = Statusxpathvalue.getText();

						
						String COM = "In Progress";
						
						if (INP.equalsIgnoreCase(COM)) {
							System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+l+"]")).getText());
							Thread.sleep(3000);
							driver.findElement(By.xpath("(//td[@class='link'])["+l+"]")).click();
							System.out.println("Fourth Task clicked of Marketing Census");
							Thread.sleep(8000);
							scrolldown();
							
							Thread.sleep(1000);
							click("MarketCensusTaskValinScrubDownloadTemplate");
							Thread.sleep(1000);
							scrolldown();
							Thread.sleep(5000);
							click("DragAndDrop");
							Thread.sleep(2000);
							Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
							Thread.sleep(6000);
							scrollToBotton();
							click("complete");
							Thread.sleep(7000);
							break;
						}}
	               
	               //Task 5
		Thread.sleep(5000);
	             //Logout Process Manager
	       		ProcessAssociateProcessManagerLogout();
	       		Thread.sleep(3000);
	       		
	       	 //Login to Login Test processManager
	   		 
	   		 ProcessManagerloginToLockTon() ; 
	   		 Thread.sleep(8000);
	   		
	   		    click("TaskHyperLink");
	   		Thread.sleep(6000);
	   		 reset("SelectClient");; 
	   		  Thread.sleep(6000);
	   		  click("SelectClient");
	   		  Thread.sleep(6000); 
	   		type( "SelectClient", ClientName);
			
			WebElement webElement4 = driver.findElement(By.xpath("/html/body/app-root/lib-common-info-header/div/div/div[1]/input"));
			Thread.sleep(2000);
			webElement4.sendKeys(Keys.TAB);
	   		  //click("LM");
	   		  Thread.sleep(6000);
	   		 
	   		 select("TaskListFilterByProcess", processName);
	   			Thread.sleep(5000); 
	   	    
	   			
	   	
	                  for(int m=1; m<=20;m++) {
	   				
	   				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+m+"]"));
	   				
	   				      System.out.println(Statusxpathvalue.getText());
	   				if(m==2 || m==7 ||m==10 || m==14){
	   						    	 // javascript executor for scroll down
	   					scrolldown();
	   						    	  }
	   				String INP = Statusxpathvalue.getText();

	   				
	   				String COM = "In Progress";
	   				
	   				if (INP.equalsIgnoreCase(COM)) {
	   					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+m+"]")).getText());
	   					driver.findElement(By.xpath("(//td[@class='link'])["+m+"]")).click();
	   					System.out.println("Fifth Task clicked of Marketing Census");
	   					Thread.sleep(9000);
	   					scrolldown();
	   					scrolldown();
	   					
	   					Thread.sleep(3000);
	   					
						click("MarketCensusTaskValinScrubDownloadTemplate");
	   					
	   					Thread.sleep(5000);
	   					scrollToBotton();
	   					Thread.sleep(1000);
						click("DragAndDrop");
						Thread.sleep(2000);
						Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\ObtainCensusInfo.exe");
						
						Thread.sleep(8000);
						
						click("PeerReviewCensusRequestTask3approveButton");
	   					
	   					
	   					Thread.sleep(3000);
	   					click("complete");
						Thread.sleep(6000);
						scrolldown();
						Thread.sleep(4000);
	   				break;}
	   				}
	}
	


	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "CreateMarketingCensus";
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
