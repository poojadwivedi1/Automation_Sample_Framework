package com.crm.autodesk.LeadTeast;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.elementRepository.HomePage;
import com.crm.elementRepository.LeadPage;

@Listeners(com.crm.autodesk.GenericUtility.ListenerS.class)
public class TC_21_CreateLeadTest extends BaseClass {

	@Test(groups="smokesuits",retryAnalyzer =com.crm.autodesk.GenericUtility.RetryAnalyzer.class )
	public void CreateLeadTest() throws Throwable {

		 
		// Navigate to lead page
		HomePage homepage = new HomePage(driver);
		homepage.clickOnLead();
		// navigate to create lead
		LeadPage leadp = new LeadPage(driver);
		// click on create lead
		leadp.clickCreateLeadImg();
		leadp.clickCancel();
		
	}
}
