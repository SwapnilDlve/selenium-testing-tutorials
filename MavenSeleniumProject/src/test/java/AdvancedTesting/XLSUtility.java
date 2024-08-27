package AdvancedTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSUtility {
	public static Object[][] readXLS(String filename,String sheetName) throws IOException{
		Object[][] obj = null;
		File file = new File("C:\\Users\\sdalve\\SeleniumWorkspace\\MavenSeleniumProject\\src\\test\\resources\\TestData\\"+filename);
		
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		obj = new Object[sheet.getLastRowNum()][];
		
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			obj[i-1] = new Object[sheet.getRow(i).getPhysicalNumberOfCells()];
			for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++) {
				obj[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		workbook.close();
		
		return obj;
	}
}
