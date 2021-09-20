package com.crm.autodesk.GenericUtility;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebTable {
	@Test
public void handlingDynamicWebtable() throws Throwable
{
		JsonfileUtility jsonLib= new JsonfileUtility();	
		String URL=jsonLib.readDataFromJSON("url");
		String USERNAME=jsonLib.readDataFromJSON("username");
		String PASSWORD=jsonLib.readDataFromJSON("password");
		String BROWSER=jsonLib.readDataFromJSON("browser");
		
		 WebDriver driver =null; 
	        
	        if(BROWSER.equals("chrome"))
	        {        
	             driver = new ChromeDriver();
	        }else if(BROWSER.equals("firefox")) {
	        	driver = new FirefoxDriver();
	        }else {
	        	System.out.println("invali browser");
	        }
	        System.out.println("invali browser");
	        //load the url
	        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        driver.get(URL);
	        //login to application
	        driver.findElement(By.name("user_name")).sendKeys(USERNAME );
	        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	        driver.findElement(By.id("submitButton")).click(); 
	        //click on organisations
	        driver.findElement(By.linkText("Organizations")).click();
	        //click on all the checkbox
	        List<WebElement> list=driver.findElements(By.xpath("//table[@class='lvt small']/tr[*]/td[1]/input[@name='selected_id']"));
	        
	        
		
}
}
