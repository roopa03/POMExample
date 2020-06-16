package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Pages.Guru99Login;
import Pages.Guru99HomePage;

public class Test99GuruLogin {
	
	public String baseUrl = "http://demo.guru99.com/V4/";
	String driverPath = "C:\\Roopa\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe";
	
    public WebDriver driver;
	Guru99Login objLogin;
	Guru99HomePage objHomePage;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	/**
     * This test case will login in http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message
     */
	
  @Test(priority = 0)
  public void testHomePageAppearCorrect() {
	//Create Login Page object
	  objLogin = new Guru99Login(driver);
	  
	//Verify login page title
	  
	  String loginPageTitle = objLogin.getLoginTitle();
	  Assert.assertTrue(loginPageTitle.contains("Guru99 Bank"));
	  
	//login to application
	  objLogin.loginToGuru99("mgr123", "mgr!23");
	  
	// Go to next page
	  objHomePage = new Guru99HomePage(driver);
	  
	//Verify home page
	  Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
      
    }
		
 }
  

