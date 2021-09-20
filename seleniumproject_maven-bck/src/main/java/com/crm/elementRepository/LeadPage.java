package com.crm.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	// initialize constructor
	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = "[title='Create Lead...']")
	private WebElement createleadImg;
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]'][1]")
	private WebElement cancelBtn;
	@FindBy(xpath = "//a[text()='pooja']")
	private WebElement selectedLead;

	/**
	 * @return the createleadImg
	 */
	public WebElement getCreateleadImg() {
		return createleadImg;
	}

	/**
	 * @return the cancelBtn
	 */
	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	/**
	 * @return the selectedLead
	 */
	public WebElement getSelectedLead() {
		return selectedLead;
	}

// provide business method
	public void clickselectedLead() {
		selectedLead.click();
	}

	public void clickCreateLeadImg() {
		createleadImg.click();
	}

	public void clickCancel() {
		cancelBtn.click();
	}

}
