package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write data into excel sheet
 * @author Admin
 *
 */
public class ExcelFileLibrary {
	
	/**
	 * This method will read the data from excel sheet for the sheetName,l rowNo, celNo given by
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws IOException 
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int celNo) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell ce = rw.getCell(celNo);
		String value = ce.getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This method will provide the last row number utilized in a given sheet
	 * @param sheetName
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	/**
	 * This method will write the data into excel sheet for user specified sheetName,rowNo, celNo
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell cel = rw.createCell(celNo);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsLibrary.excelFilepath);
		wb.write(fos);
		wb.close();
		System.out.println("Data written Successfully");
	}
	
}
