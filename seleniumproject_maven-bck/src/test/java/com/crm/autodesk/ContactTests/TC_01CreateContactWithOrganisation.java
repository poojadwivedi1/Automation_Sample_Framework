package com.crm.autodesk.ContactTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.ExcelFileUtiility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.JsonfileUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.elementRepository.LoginPage;
public class TC_01CreateContactWithOrganisation {
	
	
WebDriver driver;
	

	@Test
	public void createContact() throws Throwable {
		//read all the data
		//then we create JSON file
		JsonfileUtility Jsonlib = new JsonfileUtility();
		ExcelFileUtiility ELib = new ExcelFileUtiility();
		WebDriverUtility WebLib = new WebDriverUtility();
		JavaUtility JLib = new JavaUtility();

		//Accessing common data from Json file
		String URL = Jsonlib.readDataFromJSON("url");
		String USERNAME = Jsonlib.readDataFromJSON("username");
		String PASSWORD = Jsonlib.readDataFromJSON("password");
		String BROWSER = Jsonlib.readDataFromJSON("browser");
		String OrgName = ELib.getExcelData("Sheet1", 1, 3);
		String Contact = ELib.getExcelData("Sheet1", 1, 2);
		//Launch Browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}

		//Apply Implicit wait
		WebLib.waitForPageLoad(driver);
		WebLib.maximiseWindow(driver);

		driver.get(URL);
		
        //login to application 
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("login succesfull");
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		//click on Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//click on create contact link
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//create contact
		driver.findElement(By.name("lastname")).sendKeys(Contact);
		//inspect organisation name(+)
		driver.findElement(By.xpath("//img[@title='Select']")).click();
        //switch to child widow('Accounts' copy from window header)
		WebLib.switchToWindow(driver, "Accounts" );

		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		//enter somethig in searchbox and inspectentered data
		driver.findElement(By.linkText("ch")).click();
		//Switch back to parent window('contact'copy from parent window header)
		WebLib.switchToWindow(driver, "Contact");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//logout
        WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        WebLib.mouseOver(driver, ele);
        //test for commit
		driver.findElement(By.linkText("Sign Out")).click();

		

}	
	

}
