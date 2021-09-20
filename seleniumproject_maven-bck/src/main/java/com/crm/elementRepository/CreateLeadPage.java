package com.crm.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {
	//constructor initialization
		public CreateLeadPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveXp;
		/**
		 * @return the saveXp
		 */
		public WebElement getSaveXp() {
			return saveXp;
		}
		
		public void clickSaveXp() {
			saveXp.click();
		}
}
