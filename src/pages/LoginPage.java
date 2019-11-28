package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	public WebDriver driver;
	
	// we are not using this code because it give you null pointer error. 
	/*public WebElement emailId = driver.findElement(By.xpath("//input[@id='identifierId']"));
	public WebElement emailNext = driver.findElement(By.id("identifierNext"));
	public WebElement password1 = driver.findElement(By.name("password"));
	public WebElement passwordNext = driver.findElement(By.id("passwordNext"));
	public WebElement passwordErrMsg = driver.findElement(By.className("xgOPLd"));
	public WebElement emailErrMsg = driver.findElement(By.xpath("//div[@class='o6cuMc']"));*/
	
	//this is called page factory 
	@FindBy(xpath = "//input[@id='identifierId']")
	public static WebElement emailId;
	
	@FindBy(id = "identifierNext" )
	public static WebElement emailNext;
	
	@FindBy(name = "password")
	public static WebElement password1;
	
	@FindBy(id = "passwordNext" )
	public static WebElement passwordNext;
	
	@FindBy(className = "xgOPLd" )
	public static WebElement passwordErrMsg;
	
	@FindBy(xpath = "//div[@class='o6cuMc']")
	public static WebElement emailErrMsg;
	
	
	
	public void openBrowser() throws IOException {
		
		FileInputStream fs = new FileInputStream("C:\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(fs);
		
		String browser = prop.getProperty("browser");
		
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\LIPI\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\LIPI\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "C:\\LIPI\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		PageFactory.initElements(driver, this);
		
	}

	
	public void openGmail() {
		driver.get(
				"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void enterEmail(String email) throws InterruptedException {
		
			emailId.sendKeys(email);
			emailNext.click();
			Thread.sleep(2000);
		 
	}
	
	public void enterPassword(String password) throws InterruptedException {
		password1.sendKeys(password);
		passwordNext.click();
		Thread.sleep(2000);
	}
	
	public String readPasswordError() {
		String actualMsg = passwordErrMsg.getText();
		System.out.println(actualMsg);
		return actualMsg;
	}
	
	public String readEmailError() {
		String actualMsg = emailErrMsg.getText();
		System.out.println(actualMsg);
		return actualMsg;
		
	}

	
	

}
