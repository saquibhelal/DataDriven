package com.qa.TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.excel.utility.Xls_Reader;

public class DataDriven {

	public static void main(String[] args) {
		
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		
	    driver=new ChromeDriver();	
		driver.get("https://reg.ebay.com/reg/PartialReg?rv4=1");
		
		Xls_Reader reader= new Xls_Reader("E:\\project_for_selenium\\Selenium_Workspace"
				+ "\\DatadrivenByNaveen\\src\\main\\java\\com\\qa\\testdata\\NaveenTestData.xlsx");
        int rowCount=reader.getRowCount("RegTest");
        
        int colCount=reader.getColumnCount("RegTest");
        
        reader.addColumn("RegTest", "Status");
        
		//Parameterize
		for(int rowNum=2;rowNum<=rowCount;rowNum++){
			for(int col=0;col<colCount;col++){
				String fName=reader.getCellData("RegTest", col, rowNum);
				System.out.println(fName);
				String lName=reader.getCellData("RegTest", col, rowNum);
				System.out.println(lName);
				/*String mail=reader.getCellData("RegTest", col, rowNum);
				System.out.println(mail);*/
				// enterData
				driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(fName);
				driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lName);
				//driver.findElement(By.xpath("//*[@id='suggestion']")).sendKeys(mail);
				
				reader.setCellData("RegTest", "Status", rowNum, "Pass");

			}
			
		}	
	}

}
