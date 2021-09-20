package com.crm.autodesk.LeadTeast;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.elementRepository.ConvertLead;
import com.crm.elementRepository.HomePage;
import com.crm.elementRepository.LeadInformationPage;
import com.crm.elementRepository.LeadPage;

public class TC_25_ConvertLeadOnlyWithContactTest extends BaseClass{

	@Test
	public void convertLeadWithContactTest() throws Throwable
	{

		// String LSTNAME = jsonLib.readDataFromJSON("lastname");
		// String COMPANYNAME = jsonLib.readDataFromJSON("comname");
		// Navigate to lead page
		HomePage homepage = new HomePage(driver);
		homepage.clickOnLead();
		// navigate to create lead
		LeadPage leadp = new LeadPage(driver);
		// select particular lead
		leadp.clickselectedLead();
		// navigate to LeadInfoPage
		LeadInformationPage leadinfop = new LeadInformationPage(driver);
		leadinfop.clickConvertLead();
		WebDriverUtility wbd=new WebDriverUtility();
				wbd.switchToWindow(driver, "pritam");
				ConvertLead cl=new ConvertLead(driver);	
		cl.clickCheckOrganization();
		//Thread.sleep(1000);
		cl.clickCheckOpportunity();
		//Thread.sleep(1000);
		cl.clickCheckContact();
		Thread.sleep(1000);
		//cl.clickConvertLeadSave();

	}


}



