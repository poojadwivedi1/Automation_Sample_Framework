package com.crm.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConvertLead {
	public ConvertLead (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "select_account")
	private WebElement checkOrganization;
	
	@FindBy(id = "select_potential")
	private WebElement checkOpportunity;
	
	@FindBy(id = "select_contact")
	private WebElement checkContact;
	@FindBy(xpath = "//select[@name='industry'][1]")
	private WebElement dropdownIndustry;
	/*@FindBy(xpath = "//input[@name='Save']")
	private WebElement convertLeadSave;
	
	
	/**
	 * @return the convertLeadSave
	 */
	/*public WebElement getConvertLeadSave() {
		return convertLeadSave;
	}*/

	/**
	 * @return the dropdownIndustry
	 */
	public WebElement getDropdownIndustry() {
		return dropdownIndustry;
	}

	/**
	 * @return the checkOrganization
	 */
	public WebElement getCheckOrganization() {
		return checkOrganization;
	}

	/**
	 * @return the checkOpportunity
	 */
	public WebElement getCheckOpportunity() {
		return checkOpportunity;
	}

	/**
	 * @return the checkContact
	 */
	public WebElement getCheckContact() {
		return checkContact;
	}
	//business method
	public void clickCheckOpportunity()
	{
		checkOpportunity.click();
	}
	public void clickCheckContact()
	{
		checkContact.click();
	}
	public void clickCheckOrganization()
	{
		checkOrganization.click();
	}
	/*public void clickConvertLeadSave()
	{
		convertLeadSave.click();
	}*/
	
	public void clickdropdownIndustry()
	{
		dropdownIndustry.click();
	}
	
	
	
	
}
