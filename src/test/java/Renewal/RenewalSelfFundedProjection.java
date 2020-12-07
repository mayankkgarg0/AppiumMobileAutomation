package Renewal;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularCssContainingText;
import com.paulhammant.ngwebdriver.ByAngularModel;

import Base.TestBase;

public class RenewalSelfFundedProjection extends TestBase {

	@Test(dataProvider = "getData")
public void renewalSelfFundedProjection(String clientName, String processName, String Q1 , String Q2, String Q3, String Q4, String Q5, String Q6, String Q7 ,
		String ValueQ1,String ValueQ2,String ValueQ3,String ValueQ4,String ValueQ5,String ValueQ6,String ValueQ7,
		String HeadCountOct , String HeadCountNov, String HeadCountDec, String HeadCountJan, String HeadCountFeb , String HeadCountMar ) throws InterruptedException {

		try {
			
//1st task  ////////////////////////////////////////////////////////////////////////////////////

			////Create/Review/Edit/ the Self Funded Renewal Projection///////////////////////			
		/*	Thread.sleep(8000);
			
			click("TaskHyperLink");
			
			
			Thread.sleep(3000);
			reset("SelectClient");
			Thread.sleep(3000);
			click("SelectClient");
			Thread.sleep(6000);
			
			
			type("SelectClient", clientName);
			Thread.sleep(4000);
		    WebelementTab();
			
			Thread.sleep(4000);
			
			select("TaskListFilterByProcess", processName);
			Thread.sleep(5000);
			
			
			
               for(int i=1; i<=20;i++) {
				
				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
				
				      System.out.println(Statusxpathvalue.getText());
				if(i==3 || i==7 ||i==10 || i==14){
					scrolldown();
						    	  }
				String INP = Statusxpathvalue.getText();
                String TaskName = driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText();
				
				String COM = "In Progress";
				
				if (INP.equalsIgnoreCase(COM)) {
					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
					driver.findElement(By.xpath("(//td[@class='link'])[\"+i+\"]")).click();
					Thread.sleep(15000);
			        click("CalendarIcon");
			         Thread.sleep(1000);
					datePickerGeneral("RenewalSelfFundedTask1DueDateDrop");
					 Thread.sleep(1000);
					 scrolldown();
				
					 //Q1Programchanges click
					driver.findElement(By.xpath("(//*[@type='checkbox'])["+Q1+"]")).click();
					Thread.sleep(1000);
                        
					scrolldown();
					type("AddCommentsQ1", ValueQ1);
					Thread.sleep(1000);
					click("AddFileQ1");
					Thread.sleep(1000);
					//(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\Renewal_DatA.xlsx")
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(6000);
					
					//Q2Programchanges click
					driver.findElement(By.xpath("(//*[@type='checkbox'])["+Q2+"]")).click();
					Thread.sleep(1000);
					scrolldown();
					type("AddCommentsQ2", ValueQ2);
					click("AddFileQ2");
					Thread.sleep(1000);
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(6000);
					//huge thread after this 4000 around
					
					//Q3Programchanges click
					driver.findElement(By.xpath("(//*[@type='checkbox'])["+Q3+"]")).click();
					Thread.sleep(1000);
					scrolldown();
					type("AddCommentsQ3", ValueQ3);
					click("AddFileQ3");
					Thread.sleep(1000);
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(6000);
					
					//Q4Programchanges click
					driver.findElement(By.xpath("(//*[@type='checkbox'])["+Q4+"]")).click();
					Thread.sleep(1000);
					scrolldown();
					type("AddCommentsQ4", ValueQ4);
					click("AddFileQ4");
					Thread.sleep(1000);
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(6000);
					
					//Q5Programchanges click
					driver.findElement(By.xpath("(//*[@type='checkbox'])["+Q5+"]")).click();
					Thread.sleep(1000);
					scrolldown();
					type("AddCommentsQ5", ValueQ5);
					click("AddFileQ5");
					Thread.sleep(1000);
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(6000);
					
					//Q6Programchanges click
					driver.findElement(By.xpath("(//*[@type='checkbox'])["+Q6+"]")).click();
					Thread.sleep(1000);
					scrolldown();
					type("AddCommentsQ6", ValueQ6);
					click("AddFileQ6");
					Thread.sleep(1000);
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(6000);
					
					//Q7Programchanges click
					driver.findElement(By.xpath("(//*[@type='checkbox'])["+Q7+"]")).click();
					 scrolldown();
					Thread.sleep(1000);
					type("AddCommentsQ7", ValueQ7);
					click("AddFileQ7");
					Thread.sleep(1000);
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(6000); 
					
					
					 scrolldown(); 
			
					click("CreateProjectionRequest"); 
					Thread.sleep(4000);
					
					click("IsClientSelfFundedNo");
					Thread.sleep(3000);
					click("FirstRenewalProjectionForClient");
					Thread.sleep(3000);
					scrollToParticularElementSecond("2018Oct");
					Thread.sleep(2000);
					type("2018Oct", HeadCountOct);
					type("2018Nov",HeadCountNov);
					type("2019Dec",HeadCountDec);
					type("2019Jan",HeadCountJan);
					type("2019Feb",HeadCountFeb);
					type("2019Mar",HeadCountMar);
					
					Thread.sleep(3000);
					scrollToParticularElementSecond("SelfFundedTask1UploadFile");
					//SelfFundedTask1UploadFile
					Thread.sleep(1000);
					Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
					Thread.sleep(6000);
					scrollToParticularElementSecond("SelfFundedTask1Submit");
					Thread.sleep(7000); 
					click("SelfFundedTask1Complete");
					Thread.sleep(7000);
			break;
				}}	
              
	//2nd Task /////////////////////////////////////////////////////////////////////////
               //2-Peer Review projection Request
               //Logout and Login Code to paste
          	 Thread.sleep(5000);
          		 ProcessAssociateProcessManagerLogout();
          		 Thread.sleep(6000);
          		 //Login to Login Test processManager
          		 ProcessManagerloginToLockTon() ; 
          		 Thread.sleep(8000);
               
   			
   			click("TaskHyperLink");
   			
   			
   			Thread.sleep(3000);
   			reset("SelectClient");
   			Thread.sleep(3000);
   			click("SelectClient");
   			Thread.sleep(6000);
   			
   			
   			type("SelectClient", clientName);
   			Thread.sleep(4000);
   			
   			WebelementTab();
   			
   			Thread.sleep(4000);
   			
   			select("TaskListFilterByProcess", processName);
   			Thread.sleep(5000);
   			
   			
   			
                  for(int i=1; i<=20;i++) {
   				
   				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
   				
   				      System.out.println(Statusxpathvalue.getText());
   				if(i==3 || i==7 ||i==10 || i==14){
   					scrolldown();
   						    	  }
   				String INP = Statusxpathvalue.getText();
                   String TaskName = driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText();
   				
   				String COM = "In Progress";
   				
   				if (INP.equalsIgnoreCase(COM)) {
   					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
   					driver.findElement(By.xpath("(//td[@class='link'])[\"+i+\"]")).click();
   					Thread.sleep(15000);
   					Thread.sleep(3000);
   					scrollToParticularElementSecond("SelfFundedReviwProjectionRequest");
   					Thread.sleep(5000);
   					scrollToParticularElementSecond("SelfFundedTast2Approveall2");
   					Thread.sleep(1000);
   					scrollToParticularElementSecond("SelfFundedTast2Approveall3");
   					Thread.sleep(1000);
   					scrollToParticularElementSecond("SelfFundedTast2Approveall4");
   					Thread.sleep(1000);
   					scrollToParticularElementSecond("SelfFundedTast2Approveall5");
   					Thread.sleep(1000);
   					scrollToParticularElementSecond("SubmitTask2SelfFunded");
   					Thread.sleep(5000);
   					click("SelfFundedTast2ApproveButton");
   					Thread.sleep(5000);
   					click("CompleteTask2SelfFunded");
   					Thread.sleep(5000);
   					click("TaskHyperLink");
   					Thread.sleep(1000);
   				
   					scrolldown();
   					Thread.sleep(1000);
   				break;}}
                  
       //3rdTask  ////////////////////////////////////////////////////////////////////////////
                  
                  Thread.sleep(5000);
           		 ProcessAssociateProcessManagerLogout();
           		 Thread.sleep(6000);
           		 //Login to Login Test processAssociate
           		ProcessAssociateloginToLockTon();
           		 Thread.sleep(8000); 
   		
         /////////////////////Review Data Projection Request///////////////////////////
           		 
           		 Thread.sleep(8000);
                 
        			
        			click("TaskHyperLink");
        			
        			
        			Thread.sleep(3000);
        			reset("SelectClient");
        			Thread.sleep(3000);
        			click("SelectClient");
        			Thread.sleep(6000);
        			
        			
        			type("SelectClient", clientName);
        			Thread.sleep(4000);
        			
        			WebelementTab();
        			
        			Thread.sleep(4000);
        			
        			select("TaskListFilterByProcess", processName);
        			Thread.sleep(5000);
        			
        			
        			
                       for(int i=1; i<=20;i++) {
        				
        				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
        				
        				      System.out.println(Statusxpathvalue.getText());
        				if(i==3 || i==7 ||i==10 || i==14){
        					scrolldown();
        						    	  }
        				String INP = Statusxpathvalue.getText();
                        String TaskName = driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText();
        				
        				String COM = "In Progress";
        				
        				if (INP.equalsIgnoreCase(COM)) {
        					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
        					driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
        					Thread.sleep(15000);
        					scrollToParticularElementSecond("SelfFundedReviwProjectionRequest");
        					Thread.sleep(3000);
        					scrollToParticularElementSecond("SubmitTask2SelfFunded");
        					Thread.sleep(5000);
        					click("SelfFundedTast2ApproveButton");
           					Thread.sleep(5000);
           					click("CompleteTask2SelfFunded");
           					Thread.sleep(5000);
           					click("TaskHyperLink");
           					scrolldown();
           					Thread.sleep(1000);
        					break;
        				}} 
                       
                       
                       //4rdTask  ////////////////////////////////////////////////////////////////////////////
                       
                  //////////Acturial projection report submission/SME Renewal Projection Report Submission//////////
   				
                       Thread.sleep(8000);
                       
           			
           			click("TaskHyperLink");
           			
           			
           			Thread.sleep(3000);
           			reset("SelectClient");
           			Thread.sleep(3000);
           			click("SelectClient");
           			Thread.sleep(6000);
           			
           			
           			type("SelectClient", clientName);
           			Thread.sleep(4000);
           			
           			WebelementTab();
           			
           			Thread.sleep(4000);
           			
           			select("TaskListFilterByProcess", processName);
           			Thread.sleep(5000);
           			
           			
           			
                          for(int i=1; i<=20;i++) {
           				
           				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
           				
           				      System.out.println(Statusxpathvalue.getText());
           				if(i==3 || i==7 ||i==10 || i==14){
           					scrolldown();
           						    	  }
           				String INP = Statusxpathvalue.getText();
                           String TaskName = driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText();
           				
           				String COM = "In Progress";
           				
           				if (INP.equalsIgnoreCase(COM)) {
           					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
           					driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
           					Thread.sleep(15000);
		                   click("DragnDropTask4SelfFunded");
		                   Thread.sleep(1000);
		                   Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
		                   Thread.sleep(5000);
		                   Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\FileUpload.exe");
		                   Thread.sleep(5000);
		                   scrollToParticularElementSecond("SubmitActurialprojectionReports");
		                   Thread.sleep(4000);
		                   click("complete");
		                   Thread.sleep(5000);
           					break;}} 
		
		
                          
                          //5thTask  ////////////////////////////////////////////////////////////////////////////
                          
   ////////////////////SME Peer Review of submitted Renewal Projection Report////////////////////////////////////                       
                          Thread.sleep(8000);
                          
                 			
                 			click("TaskHyperLink");
                 			
                 			
                 			Thread.sleep(3000);
                 			reset("SelectClient");
                 			Thread.sleep(3000);
                 			click("SelectClient");
                 			Thread.sleep(6000);
                 			
                 			
                 			type("SelectClient", clientName);
                 			Thread.sleep(4000);
                 			
                 			WebelementTab();
                 			
                 			Thread.sleep(4000);
                 			
                 			select("TaskListFilterByProcess", processName);
                 			Thread.sleep(5000);
                 			
                 			
                 			
                                for(int i=1; i<=20;i++) {
                 				
                 				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
                 				
                 				      System.out.println(Statusxpathvalue.getText());
                 				if(i==3 || i==7 ||i==10 || i==14){
                 					scrolldown();
                 						    	  }
                 				String INP = Statusxpathvalue.getText();
                                 String TaskName = driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText();
                 				
                 				String COM = "In Progress";
                 				
                 				if (INP.equalsIgnoreCase(COM)) {
                 					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
                 					driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).click();
                 					Thread.sleep(15000);
                 					scrollToParticularElementSecond("SubmitActurialprojectionReports");
                 					Thread.sleep(3000);
                 					click("Submit");
                 					Thread.sleep(5000);
                 					click("Approve");
                 					Thread.sleep(5000);
                 					//Complete xpath not correct
                 					
                 					click("SelfFundedTask5Complete");
                 					Thread.sleep(7000);
                 					click("TaskHyperLink");
                 					scrolldown();
                 					Thread.sleep(3000);
                 				break;}} */
                                
                                //6thTask  ////////////////////////////////////////////////////////////////////////////
                                 //Create Internal update on projection Report cant find////
                                
   //////////////////////////////////7th Task///////////////////////////////////////////////////////////////////////////
                                //Peer Review of renewal actuarial projection Report//////////////
                                
                                Thread.sleep(5000);
                         		 ProcessAssociateProcessManagerLogout();
                         		 Thread.sleep(6000);
                         		 //Login to Login Test processManager
                         		 ProcessManagerloginToLockTon() ; 
                         		 Thread.sleep(8000);
                              
                  			
                  			click("TaskHyperLink");
                  			
                  			
                  			Thread.sleep(3000);
                  			reset("SelectClient");
                  			Thread.sleep(3000);
                  			click("SelectClient");
                  			Thread.sleep(6000);
                  			
                  			
                  			type("SelectClient", clientName);
                  			Thread.sleep(4000);
                  			
                  			WebelementTab();
                  			
                  			Thread.sleep(4000);
                  			
                  			select("TaskListFilterByProcess", processName);
                  			Thread.sleep(5000);
                  			
                  			
                  			
                                 for(int i=1; i<=20;i++) {
                  				
                  				WebElement Statusxpathvalue =driver.findElement(By.xpath("(//tr/td[4])["+i+"]"));
                  				
                  				      System.out.println(Statusxpathvalue.getText());
                  				if(i==3 || i==7 ||i==10 || i==14){
                  					scrolldown();
                  						    	  }
                  				String INP = Statusxpathvalue.getText();
                                  String TaskName = driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText();
                  				
                  				String COM = "In Progress";
                  				
                  				if (INP.equalsIgnoreCase(COM)) {
                  					System.out.println(driver.findElement(By.xpath("(//td[@class='link'])["+i+"]")).getText());
                  					driver.findElement(By.xpath("(//td[@class='link'])[\"+i+\"]")).click();
                  					Thread.sleep(15000);
                  					 scrollToParticularElementSecond("ReviewActuarialProjectionReport");
                  					Thread.sleep(5000);
                  					click("Submit");
                  					Thread.sleep(3000);
                  					click("Approve");
                 					Thread.sleep(5000);
                  					click("Complete");
                  					Thread.sleep(7000);
                 					click("TaskHyperLink");
                 					scrolldown();
                 					Thread.sleep(3000);
                  				break;}}
                                
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	
		
	


	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "SelfFunded";
		int rows = renewalexcel.getRowCount(sheetName);
		int cols = renewalexcel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum=2; rowNum<=rows; rowNum++)
		{
			for (int colNum=0; colNum<cols; colNum++)
			{
				data[rowNum-2][colNum] = renewalexcel.getCellData(sheetName, colNum, rowNum);
			}
				
		}
		return data;
		
	}	

}
