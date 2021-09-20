package com.crm.autodesk.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.ExcelFileUtiility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.JsonfileUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.elementRepository.CreateOrganisationPage;
import com.crm.elementRepository.HomePage;
import com.crm.elementRepository.LoginPage;
import com.crm.elementRepository.OrganisationPage;

public class TC_02_CreateOrganizationTest {
	WebDriver driver;
	@Test
	public void CreateOrganisationTest() throws Throwable
	{
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
				//Navigate to Organisation page
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganisation();
				
				//Navigate to create Organisation Page
				OrganisationPage orgPage=new OrganisationPage(driver);
				orgPage.clickOnCreateOrgImg();
				//create Organizaton
				CreateOrganisationPage createOrgP=new CreateOrganisationPage(driver);
				createOrgP.createOrganisation(OrgName);
				
				
				
	}
	


}
