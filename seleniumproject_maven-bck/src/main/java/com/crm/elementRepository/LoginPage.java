package com.crm.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	@FindBy(name="user_password")
	private WebElement userpasswordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	/**
	 * @return the userNameEdt
	 */
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	/**
	 * @return the userpasswordEdt
	 */
	public WebElement getUserpasswordEdt() {
		return userpasswordEdt;
	}
	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return loginBtn;
	}

public void login(String username,String password)
{
	userNameEdt.sendKeys(username);
	 userpasswordEdt.sendKeys(password);
	 loginBtn.click();
}
}
