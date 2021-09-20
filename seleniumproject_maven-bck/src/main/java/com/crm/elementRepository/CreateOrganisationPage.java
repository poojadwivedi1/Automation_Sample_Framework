package com.crm.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class CreateOrganisationPage extends WebDriverUtility

{WebDriver driver;
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this );
	}
	//loacate all the WebElement
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	@FindBy(name="industry")
	private WebElement industrydropdown;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	//provide getters
	/**
	 * @return the orgNameEdt
	 */
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	/**
	 * @return the industrydropdown
	 */
	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}
	/**
	 * @return the savebtn
	 */
	public WebElement getSavebtn() {
		return savebtn;
	}
	//provide business method
	/**
	 * this method will create organisation with mandatory field
	 *
	 */
	public void createOrganisation(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		savebtn.click();
		
	}
/**
 * this method will create organization by choosing industry type	
 */
	public void createOrganizationWithIndustry(String indtype)
	{
		orgNameEdt.sendKeys(indtype);
		select(industrydropdown,indtype);
		savebtn.click();
		
	}

}
