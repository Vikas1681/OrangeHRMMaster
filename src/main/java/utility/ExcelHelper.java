package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import generic.Pojo;

public class ExcelHelper {

	Pojo objPojo;
	FileInputStream objFileInputStream;
	XSSFWorkbook objXSSFWorkbook;
	XSSFSheet sheet;
	int rowCount;
	HashMap<String, String> objHashMap;

	public ExcelHelper(Pojo objPojo) {
		this.objPojo = objPojo;
	}

	public Workbook loadExcelHelper(String excelFilenName) {

//		excelFilenName = "Test";
		String strExcelPath = System.getProperty("user.dir") + "\\Datasets\\" + excelFilenName + ".xlsx";
		System.out.println(strExcelPath);

		try {
			this.objFileInputStream = new FileInputStream(strExcelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.objXSSFWorkbook = new XSSFWorkbook(this.objFileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.objXSSFWorkbook;
	}

	public HashMap<String, String> loadTestData(String tcID) {
		objHashMap = new HashMap<String, String>();
		sheet = this.objXSSFWorkbook.getSheet("Sheet1");
		this.rowCount = sheet.getLastRowNum();
		for (int i = 0; i < this.rowCount; i++) {
			String obtainedTCIDNo = sheet.getRow(i).getCell(0).getStringCellValue();
			if (obtainedTCIDNo.equalsIgnoreCase(tcID)) {

				Iterator<Cell> cellValues = sheet.getRow(i).cellIterator();
				Iterator<Cell> headerValues = sheet.getRow(i - 1).cellIterator();

				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
					while (headerValues.hasNext()) {
						Cell hdrcellKey = (Cell) headerValues.next();
						Cell hdrcellvalue = (Cell) cellValues.next();
						objHashMap.put(hdrcellKey.toString(), hdrcellvalue.toString());
					}

				}

			}

		}
		return objHashMap;

	}

	public String dpString(String keyName) {

		return objHashMap.get(keyName);

	}

//	public static void main(String[] args) {
//		ExcelHelper objExcel = new ExcelHelper();
//		objExcel.loadExcelHelper("Test");
//		objExcel.loadTestData("100");
//		System.out.println(objExcel.dpString("Company"));
//	}

}
