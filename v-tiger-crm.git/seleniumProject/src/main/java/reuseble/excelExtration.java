package reuseble;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelExtration   {
	
	public static String workbookName(String sheetName,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\seleniumProject\\src\\main\\resources\\newexel.xlsx");
	
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetName);
	Row row = sheet.getRow(rowIndex);
	Cell cell = row.getCell(cellIndex);
	String data = cell.getStringCellValue();
	wb.close();
	return data;
	}

}
