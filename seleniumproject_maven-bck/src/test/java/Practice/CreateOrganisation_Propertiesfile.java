package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganisation_Propertiesfile {

		public static void main(String[] args) throws IOException {
			InputStream inputStream = null;
	        try {
			  //step 1 : get the java representation object of the Physical file 
	        	//Properties properties = new Properties();
	        	FileInputStream fis = new FileInputStream("C:\\D-drive\\Automation-workspace\\seleniumproject_maven-bck\\src\\test\\resources\\commonData.properties");
	           // ClassLoader loader = Thread.currentThread().getContextClassLoader();
	            //inputStream = loader.getResourceAsStream("localdata/Commondata.properties");
		      //step 2 : Create an object to Property class to load all the Keys
	            Properties pobj = new Properties();
	            pobj.load(fis);
			   //step 3 : read the value using getPropert("Key")	
	            String BROWSER = pobj.getProperty("browser");
		        String URL = pobj.getProperty("url");
		        String USERNAME = pobj.getProperty("username");
		        String PASSWORD = pobj.getProperty("password");
		        
		        WebDriver driver =null; 
		        
		        if(BROWSER.equals("chrome"))
		        {        
		             driver = new ChromeDriver();
		        }else if(BROWSER.equals("firefox")) {
		        	driver = new FirefoxDriver();
		        }
		        
		        driver.get(URL);
		        driver.findElement(By.name("user_name")).sendKeys(USERNAME );
		        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		        driver.findElement(By.id("submitButton")).click(); 
		        
	        } finally {
	            if (inputStream != null) {
	                inputStream.close();
	            }
		            
	}
		
		 
		


}
}
