package Generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {
	public static int getExcelRowCount(String xlpath, String SheetName) {
		int rowCount;
		try {
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(SheetName);
			rowCount = s.getLastRowNum();

		} catch (Exception e) {
			rowCount = -1;
		}

		return rowCount;

	}// getExcelcoun

	public static String getExcelCellValue(String xlpath, String SheetName, int rowNo, int ColNum) {

		String cellValue;
		try {
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(SheetName);
			cellValue = s.getRow(rowNo).getCell(ColNum).getStringCellValue();
		} catch (Exception e) {
			cellValue = " ";
		}
		return cellValue;

	}// getExcelValue

	public static String[][] readinfxlsfilepoi( String filename, String sheetname) {
		boolean result = true;
		String file = filename;
		   int rownum = 0;
		   int numberOfCells =  0;
		   XSSFWorkbook myExcelBook = null;
		    XSSFSheet myExcelSheet = null;
		    XSSFRow row =  null;
		try {
			myExcelBook = new XSSFWorkbook(new FileInputStream(file));
			myExcelSheet = myExcelBook.getSheet(sheetname);
			row = myExcelSheet.getRow(0);
			rownum = myExcelSheet.getLastRowNum();
			//int physicalrows = myExcelSheet.getPhysicalNumberOfRows();
			System.out.println("number of Rows " + rownum);
			numberOfCells = row.getPhysicalNumberOfCells();
			System.out.println("number of cells " + numberOfCells);
		} catch (Exception E) {
			System.out.println();
		}
		
		
		
	        String[][] inputarr = new String[rownum][numberOfCells];
	        XSSFCell cell = null;
	        
	        
	        
	        
	        try {
	        for (int i =0; i<rownum;i++)
	        {
	        	for (int j=0; j<numberOfCells ; j++)
	        	{
	        		cell = myExcelSheet.getRow(i+1).getCell(j);
	        		inputarr[i][j]= cell.toString();
	        		
	        	}
	        }
	        
	        
	
		}
		catch (Exception E)
		{
			System.out.println();
		}

		return inputarr;
	}
	
	
}
