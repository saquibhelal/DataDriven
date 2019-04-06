package com.qa.TestCases;

import com.qa.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
		
		Xls_Reader reader= new Xls_Reader("E:\\project_for_selenium\\Selenium_Workspace"
			+ "\\DatadrivenByNaveen\\src\\main\\java\\com\\qa\\testdata\\NaveenTestData.xlsx");

		int rowCount=reader.getRowCount("RegTest");
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++){
			
		}
	}

}
