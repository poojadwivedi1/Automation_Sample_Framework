package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;


//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic method to read and write data from Excel sheet
 * @author pooja
 *
 */

public class ExcelFileUtiility {
	
	
	/**
	 * 
	 * This method will read data from excel sheet wrt to row number and cell number
	 * @param  
	 * @throws Throwable
	 */
	public  String getExcelData(String sheetName,int rownum,int cellnum)throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum); 
		Cell cell= row.getCell(cellnum);
		String value=cell.getStringCellValue();
 		return value;
		
	}
	/**
	 * This method return the data full in sheet
	 * @throws Throwable
	 */
	public Object [][] getExcelData(String sheetName)throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object [][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=1;j<lastCell;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		
		}
		return data;

	}

}
