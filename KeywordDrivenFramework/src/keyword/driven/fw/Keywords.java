package keyword.driven.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Keywords extends Base{
	
	public void performAction(String locator, String locatorValue, String keyword, String parameter){
		switch(keyword){
			case "typeText": 
				typeText(getByObject(locator, locatorValue), parameter);
				break;
			
			case "click": 
				click(getByObject(locator, locatorValue));
				break;
		}		
	}
	
	public By getByObject(String locator, String locatorValue){
		By byObject = null;
		
		switch(locator){
		case "id": 
			byObject = By.id(locatorValue);
			break;
			
		case "xpath": 
			byObject = By.xpath(locatorValue);
			break;
		}
		
		return byObject;
	}
	
	public void typeText(By by, String parameter){
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(parameter);
	}
	
	public void click(By by){
		WebElement element = driver.findElement(by);
		element.click();
	}
}
