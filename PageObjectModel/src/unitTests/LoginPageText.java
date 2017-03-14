package unitTests;

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
	LoginPage loginPage = new LoginPage();
	
	@Test
	public void testaTxtUsername() {
		loginPage.setTxtUsername("hiamal007");
		Assert.assertEquals("hiamal007", loginPage.getTxtUsername());
	}
	
	@Test
	public void testbTxtPassword() {
		loginPage.setTxtPassword("test");
		Assert.assertEquals("test", loginPage.getTxtPassword());
	}
	
	@Test
	public void testcClickLogin() {
		loginPage.clickBtnLogin();
		new WebDriverWait(Base.getDriver(),10).until(ExpectedConditions.presenceOfElementLocated(By.id("location")));
		Assert.assertEquals("AdactIn.com - Search Hotel", Base.getDriver().getTitle());
	}

}
