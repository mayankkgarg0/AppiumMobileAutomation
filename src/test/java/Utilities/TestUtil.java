package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import Base.TestBase;

public class TestUtil extends TestBase{
	
	public static String screenshotPath;
	public static String screenshotName;
	
	
	public static void captureScreenshot() throws IOException {
		
		Date d = new Date();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName));
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum=2; rowNum<=rows; rowNum++)
		{
			for (int colNum=0; colNum<cols; colNum++)
			{
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
				
		}
		return data;
		
	}
	

}
