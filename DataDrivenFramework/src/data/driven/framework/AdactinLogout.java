package data.driven.framework;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdactinLogout {
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/Users/admin/Downloads/geckodriver.exe");
		driver = new FirefoxDriver();
		
		String excelFilePath = "C:/Users/admin/Documents/Sample.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(excelFilePath);
		for(Row row: workbook.getSheetAt(0)){
			driver.get("http://adactin.com/HotelApp");
			if(row.getCell(0)!=null)
				driver.findElement(By.id("username")).sendKeys(row.getCell(0).getStringCellValue());
			if(row.getCell(1)!=null)
				driver.findElement(By.id("password")).sendKeys(row.getCell(1).getStringCellValue());
			driver.findElement(By.id("login")).click();
			Thread.sleep(1000);
		}
		workbook.close();
	}

}
