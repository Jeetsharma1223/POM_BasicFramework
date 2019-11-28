package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import utilities.Xls_Reader;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	public static WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	
	
	@Test
	public void loginWithWrongPasswordTest() throws InterruptedException {
		// enter correct email
		// click on next
		// Thread.sleep
		// enter wrong pass
		// click on next
		// verify error message
		lp.enterEmail(df.ValidEmail);
		lp.enterPassword(df.WrongPassword);
		Assert.assertEquals(lp.readPasswordError(), df.PasswordErrorMessage);

	}

	@Test
	public void loginWithWrongEmailTest() throws InterruptedException {
		// enter correct email
		// click on next
		// Thread.sleep
		// enter wrong pass
		// click on next
		// verify error message
		lp.enterEmail(df.InvalidEmail);
		Assert.assertEquals(lp.readEmailError(), df.EmailErrorMessage);

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		// open firefox
		// open gmail
		lp.openBrowser();
		lp.openGmail();

	}

	@AfterMethod
	public void afterMethod() {
		// close browser
		lp.closeBrowser();
	}

}
