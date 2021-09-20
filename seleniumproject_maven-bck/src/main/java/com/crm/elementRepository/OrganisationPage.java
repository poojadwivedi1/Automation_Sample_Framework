package com.crm.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="submit")
	private WebElement submitBtn;

	/**
	 * @return the createOrgImg
	 */
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}

	/**
	 * @return the searchEdt
	 */
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	/**
	 * @return the submitBtn
	 */
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	//business method
	public void clickOnCreateOrgImg()
	{
		createOrgImg.click();
	}

}
