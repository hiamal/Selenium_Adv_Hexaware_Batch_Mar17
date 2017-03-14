package keyword.driven.fw;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public static String excelFilePath, browser, URL;
	public static XSSFWorkbook workbook;
	
	public static void loadConfig() throws IOException{
		excelFilePath = "C:/Users/admin/Documents/Keywords.xlsx";
		FileInputStream fis = new FileInputStream(excelFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
		browser = workbook.getSheet("Config").getRow(0).getCell(1).getStringCellValue();
		URL = workbook.getSheet("Config").getRow(1).getCell(1).getStringCellValue();
	}
	
	public static void writeFile() throws IOException{
		FileOutputStream fis = new FileOutputStream(excelFilePath);
		workbook.write(fis);
		workbook.close();
	}
	
	public static void initDriver(){		
		switch(browser.toLowerCase().trim()){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Downloads/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:/Users/admin/Downloads/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void correctLogin(){
		driver.get(URL);
		Row row=workbook.getSheetAt(0).getRow(0);
		driver.findElement(By.id("username")).sendKeys(row.getCell(0).getStringCellValue());
		driver.findElement(By.id("password")).sendKeys(row.getCell(1).getStringCellValue());
		driver.findElement(By.id("login")).click();
	}
}
