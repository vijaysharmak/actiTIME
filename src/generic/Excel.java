package generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class Excel {
	
	// This method is used to get the number of row count in the excel sheet.
	// It will fetch the last row number.
	public static int getRowCount(String path) {
		int rowCnt=0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rowCnt = wb.getSheet("sheet1").getLastRowNum();
		}
		catch(Exception e) {
			Reporter.log("Exception while accessing the excel file", true);
			Assert.fail();
		}
		return rowCnt;
	}
	
	// This method is used to get the value from the cell in String format.
	public static String getCellValue(String path, int row, int col) {
		String cellValue = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			cellValue = wb.getSheet("sheet1").getRow(row).getCell(col).toString();
		}
		catch(Exception e) {
			Reporter.log("Exception while accessing the excel file", true);
			Assert.fail();
		}
		return cellValue;
	}
	
	// This method is to write the value in an excel sheet in a specified row and column.
	public static void setCellValue(String path, String sheet, int row, int col, String data) {
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			wb.getSheet(sheet).createRow(row).createCell(col).setCellValue(data);			
		}
		catch(Exception e) {
			Reporter.log("Exception while accessing the excel file", true);
		}		
	}

}
