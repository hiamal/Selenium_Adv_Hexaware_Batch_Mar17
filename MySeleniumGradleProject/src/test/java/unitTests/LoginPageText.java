package unitTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageClasses.Base;
import pageClasses.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageText {
	
	
	@Test
	public void readExcel() throws IOException{
		String excelFilePath = "C:/Users/admin/Documents/Keywords.xlsx";
		FileInputStream fis = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		fis.close();
		
		for(Row row: workbook.getSheetAt(1))
			for(Cell cell:row)
				System.out.println(cell.getStringCellValue());
		
	}

}
