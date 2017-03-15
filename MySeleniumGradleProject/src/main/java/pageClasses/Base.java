package pageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	private static WebDriver driver;
	
	public static WebDriver getDriver(){
		if(driver==null){
			System.setProperty("webdriver.gecko.driver", "C:/Users/admin/Downloads/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://adactin.com/HotelApp");
		}
		return driver;
	}
	
}
