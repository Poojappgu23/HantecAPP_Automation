package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static Workbook workbook;
	private static Sheet sheet;

	public static void loadExcel(String filePath, String sheetName) throws IOException {

		FileInputStream file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
	}

	public static String getCellData(int row, int col) {
		try {
		Cell cell = sheet.getRow(row).getCell(col);
		 DataFormatter formatter = new DataFormatter();
		 
		  if (cell == null) {
	            return ""; // or return null if you prefer
	        }
		  return formatter.formatCellValue(cell);
		 
			/*
			 * if (cell.getCellType() == CellType.STRING) { return
			 * cell.getStringCellValue(); } else if (cell.getCellType() == CellType.NUMERIC)
			 * { return String.valueOf((int) cell.getNumericCellValue()); } return "";
			 */
	
	} catch (Exception e) {
        System.out.println("Error reading cell: " + e.getMessage());
        return ""; 
        // or return null
    }
	}
	
	
	

	public static int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static void closeExcel() throws IOException {
		workbook.close();
	}

}
