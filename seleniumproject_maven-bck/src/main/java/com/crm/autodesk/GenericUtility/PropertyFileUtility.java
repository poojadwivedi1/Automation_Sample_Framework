package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author pooja
 *
 */
public class PropertyFileUtility {
	/**
	 * this method reads data from property file
	 * @throws Throwable 
	 * @throws  
	 * @throws Throwable
	 */
public String getPropertyFileData(String key) throws Throwable 
{
FileInputStream fis=new FileInputStream(IPathConstant.PropertyFilePath);	
Properties p=new Properties();
p.load(fis);
String value=p.getProperty(key);
return value;

}
}
