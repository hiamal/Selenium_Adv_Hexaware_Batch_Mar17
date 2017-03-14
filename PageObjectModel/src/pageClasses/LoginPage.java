package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="username")
	WebElement txtUsername;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login")
	WebElement btnLogin;
	
	public LoginPage(){
		PageFactory.initElements(Base.getDriver(), this);
	}
	
	public String getTxtUsername(){
		return txtUsername.getAttribute("value");
	}
	
	public String getTxtPassword(){
		return txtPassword.getAttribute("value");
	}
	
	public void setTxtUsername(String text){
		txtUsername.clear();
		txtUsername.sendKeys(text);
	}
	
	public void setTxtPassword(String text){
		txtPassword.clear();
		txtPassword.sendKeys(text);
	}
	
	public void clickBtnLogin(){
		btnLogin.click();
	}

}
