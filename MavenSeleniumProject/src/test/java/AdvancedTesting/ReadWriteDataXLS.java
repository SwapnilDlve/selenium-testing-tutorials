package AdvancedTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadWriteDataXLS {
	
	
	@Test
	public void testReadWriteXls() throws IOException {
		File file = new File("C:\\Users\\sdalve\\SeleniumWorkspace\\MavenSeleniumProject\\src\\test\\resources\\TestData\\logindata.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
//			XSSFSheet sheet = workbook.getSheet("Sheet1");
			XSSFSheet sheet = workbook.getSheet("Sheet2");
			
			
//			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(0).getLastCellNum());
//			System.out.println(sheet.getRow(1).getLastCellNum());
			System.out.println(sheet.getRow(1).getPhysicalNumberOfCells());
//			System.out.println(sheet.getRow(1).getCell(2).getStringCellValue());
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<row.getLastCellNum();j++) {
					System.out.print(row.getCell(j)+"\t");
				}
				System.out.println("");
			}
			sheet.getRow(1).getCell(2).
			
			sheet.getRow(1).createCell(2).setCellValue("Passed");
			
			FileOutputStream fos = new FileOutputStream(file);
			
			workbook.write(fos);
			
			fos.close();
			
			
			/*
			 * System.out.println(sheet.getRow(0).getCell(0).getStringCellValue()+"\t\t"
			 * +sheet.getRow(0).getCell(1).getStringCellValue());
			 */
			
//			for(int i=1;i<=sheet.getLastRowNum();i++) {
//				/*
//				 * System.out.println(sheet.getRow(i).getCell(0).getStringCellValue()+"\t\t"
//				 * +sheet.getRow(i).getCell(1).getStringCellValue()+"\t\t"
//				 * +sheet.getRow(i).getCell(2).getStringCellValue());
//				 */
//				
//				for(int j =0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++) {
//					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t\t");
//				}
//				sheet.getRow(i).createCell(2).setCellValue("passed");
//				System.out.println("");
//			}
			
//			FileOutputStream fos = new FileOutputStream(file);
//			workbook.write(fos);
//			
//			workbook.close();
//			fos.close();
			fis.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
