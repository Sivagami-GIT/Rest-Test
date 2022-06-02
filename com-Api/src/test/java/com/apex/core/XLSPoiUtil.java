package com.apex.core;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSPoiUtil {
	private static XSSFSheet excelWSheet;

	private static XSSFWorkbook excelWBook;

	private static XSSFCell cell;

	private static XSSFRow row;

	public static Object[][] setExcelFile(String Path, String SheetName) throws Exception {
		Object[][] obj;
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet

			excelWBook = new XSSFWorkbook(ExcelFile);

			excelWSheet = excelWBook.getSheet(SheetName);
			int rows=excelWSheet.getLastRowNum();
			Row row = excelWSheet.getRow(rows);
			int cells = row.getLastCellNum();
			System.out.println("cellno " + cells);
			obj=new Object[rows][cells];
			for (int i = 0; i < excelWSheet.getLastRowNum(); i++) {
				for (int j = 0; j < cells; j++) {
					cell = excelWSheet.getRow(i).getCell(j);
					CellType cellType = cell.getCellType();
				
					switch(cellType) {
					case NUMERIC:{
						System.out.println(i +" "+j);
						obj[i][j]= cell.getNumericCellValue();
						System.out.println(i + " :" + cell.getNumericCellValue());
						break;
					}
					case STRING:{
						obj[i][j]= cell.getStringCellValue();
						System.out.println(i + " :" + cell.getStringCellValue());
						break;
					}
					default:
						System.out.println("Blank");
					}
					
				}
				
				
			}
//
//			Iterator<Row> iterator = excelWSheet.iterator();
//			while (iterator.hasNext()) {
//				Row rowIT = iterator.next();
//				Iterator<Cell> cellIterator = rowIT.cellIterator();
//				while (cellIterator.hasNext()) {
//					Cell next = cellIterator.next();
//					CellType cellType = next.getCellType();
//					
//					switch(cellType) {
//					case NUMERIC:{
//						System.out.println( " :" + next.getNumericCellValue());
//						break;
//					}
//					case STRING:{
//						System.out.println( " :" + next.getStringCellValue());
//						break;
//					}
//					default:
//						System.out.println("Blank");
//					}
//				}
//			}
		} catch (Exception e) {

			throw (e);

		}
		return obj;

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			cell = excelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = cell.getRawValue();

			return CellData;

		} catch (Exception e) {
			e.printStackTrace();
			return "";

		}

	}

	public static void main(String[] args) throws Exception {
		String path = "C:\\Sample\\SignIn_USERID_2.xlsx";
		Object[][] setExcelFile = setExcelFile(path, "ValidUserID");
		System.out.println(setExcelFile.length);
		System.out.println("data :" + getCellData(0, 0));

	}

}
