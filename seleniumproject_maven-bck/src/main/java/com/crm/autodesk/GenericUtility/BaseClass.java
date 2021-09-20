package com.crm.autodesk.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.elementRepository.HomePage;
import com.crm.elementRepository.LoginPage;

public class BaseClass {
	// public MySqlDataBaseUtility dbLib = new MySqlDataBaseUtility();
	public JsonfileUtility jsonLib = new JsonfileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelFileUtiility eLib = new ExcelFileUtiility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;

	@BeforeSuite
	public void connectToDb() {
		// dbLib.getDataFromMySqlDB(null, 0);
		System.out.println("=======make DB connections========");
	}

	@BeforeClass
	public void launchBrowser() throws Throwable {
		System.out.println("=======launch browser========");
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
	}

	@BeforeMethod
	public void loginToApp() throws Throwable {
		System.out.println("=========login to app============");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void logOutOfApp() {
		System.out.println("========log out from app==========");
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("============clocse the browser============");
		driver.close();
	}

	@AfterSuite
	public void closeTheDB() {
		System.out.println("===========clocse the db===========");

	}
	//screenshot method
		public String getscreenshot(String name) throws IOException
		{
			File srcfile=((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
			String destfile=System.getProperty("user.dir")+"/screenshot/"+name+".png";
			File finaldest=new File(destfile);
			FileUtils.copyFile( srcfile,finaldest);
			return destfile;
		}

}
