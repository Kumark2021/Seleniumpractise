package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
	public static final int IMPLICIT_WAIT=10;
	
	public static String generateDateStamp()
	{
		Date date=new Date();
		String emailTimeStamp= date.toString().replace(" ", "_").replace(":", "_");
		return "kumar"+emailTimeStamp+"@gmail.com";
					
	}
	
	public static Object[][] getTestDatafromExcel(String sheetName)
	{
		File excelFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\config\\TutorialDemo.xlsx");
		XSSFWorkbook workbook=null;
		try {
		FileInputStream fisExcel=new FileInputStream(excelFile);
		workbook=new XSSFWorkbook(fisExcel);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		XSSFSheet sheet =workbook.getSheet(sheetName);
		
		
		
		/*FileInputStream fisExcel = null;
		try {
			fisExcel = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fisExcel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet=workbook.getSheet(sheetName);*/
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rows][cols];
		
		for (int i=0;i<rows;i++)
		{
			
			XSSFRow row = sheet.getRow(i+1);
			
		for(int j=0;j<cols;j++)
		{
				
				XSSFCell cell=row.getCell(j);
			CellType cellType = cell.getCellType();
			
			switch(cellType)
			{
			case STRING:
				data[i][j]=cell.getStringCellValue();
				break;
				
			case NUMERIC:
				data[i][j]=Integer.toString( (int)cell.getNumericCellValue());
				break;
				
			case BOOLEAN:
				data[i][j]=cell.getBooleanCellValue();
				break;
				
				
			
			
			}
			}
			
			
			}
			
						
			
				
		return data;
		
		
		
	}

}
