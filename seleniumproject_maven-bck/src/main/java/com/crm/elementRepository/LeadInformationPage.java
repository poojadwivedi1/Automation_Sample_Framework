package com.crm.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LeadInformationPage {
	
	
	
	public LeadInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Convert Lead")
	private WebElement convertLeadLnk;
	
	/**
	 * @return the convertLeadLnk
	 */
	public WebElement getConvertLeadLnk() {
		return convertLeadLnk;
	}

	public void clickConvertLead() {
		convertLeadLnk.click();
	}

	
}
