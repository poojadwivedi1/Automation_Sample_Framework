package com.crm.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	
	@FindBy(linkText ="Organizations")
	private WebElement organizationLnk;
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	@FindBy(linkText ="Sign Out")
	private WebElement signoutLnk;
	@FindBy(linkText ="Contacts")
	private WebElement contactLnk;
	@FindBy(linkText ="Leads")
	private WebElement leadLnk;
	@FindBy(linkText ="Products")
	private WebElement productLnk;
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	@FindBy(linkText ="Email")
	private WebElement emailLnk;
	
	
	/**
	 * @return the organizationLnk
	 */
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	/**
	 * @return the administratorImg
	 */
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	/**
	 * @return the signoutLnk
	 */
	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	/**
	 * @return the contactLnk
	 */
	public WebElement getContactLnk() {
		return contactLnk;
	}
	/**
	 * @return the leadLnk
	 */
	public WebElement getLeadLnk() {
		return leadLnk;
	}
	/**
	 * @return the productLnk
	 */
	public WebElement getProductLnk() {
		return productLnk;
	}
	/**
	 * @return the opportunitiesLnk
	 */
	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}
	/**
	 * @return the emailLnk
	 */
	public WebElement getEmailLnk() {
		return emailLnk;
	}
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clickOnOrganisation()
	{
		organizationLnk.click();
	}
	public void signOut(WebDriver driver)
	{
		waitForElementToBeVisible(driver, administratorImg);
		mouseOverMovetoElement(driver, administratorImg);
		signoutLnk.click();

	}
	
	
	public void clickOnLead()
	{
		leadLnk.click();
	}
	
	
		
	}


