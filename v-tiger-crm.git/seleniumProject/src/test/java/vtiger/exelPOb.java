package vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import reuseble.excelExtration;

public class exelPOb {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		// TODO Auto-generated method stub
//		FileInputStream fis = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\seleniumProject\\src\\main\\resources\\newexel.xlsx");
//		// step 2> get the access of workbook
//		Workbook wb = WorkbookFactory.create(fis);
//		// step 3> get the access of sheet
//		Sheet sheet = wb.getSheet("dummy");
//		// step 4> get the access of row
//		Row row = sheet.getRow(6);
//		// step 5> get the access of cell
//		Cell cell = row.getCell(2);
//		// step 6> get the data
//		String data = cell.getStringCellValue();
//		// cell.getNumericCellValue();
//		// cell.getBooleanCellValue();
//		System.out.println(data);
		// don’t forget to close the workbook
//		wb.close();
		String data=excelExtration.workbookName("sheet1",4,3);
		System.out.println(data);
	}

}
