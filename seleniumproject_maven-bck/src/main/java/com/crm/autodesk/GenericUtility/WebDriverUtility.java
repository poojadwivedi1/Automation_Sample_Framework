package com.crm.autodesk.GenericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	@SuppressWarnings("deprecation")
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
/**
 * this method will maximise the window
 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will select from the dropdown using visible text
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}
	/**
	 * This method will select from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	/**
	 * this method is used formouse over actions
	 * @param driver
	 * @param element
	 * 
	 */
	public void mouseOverMovetoElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	
	/**
	 * this method use to dismiss the alert popup
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method will switch to frame wrt to id
	 * @param driver
	 * @param frameid
	 */
	public void switchToFrame(WebDriver driver,String frameid)
	{
		driver.switchTo().frame(frameid);
	}
	/**
	 * Switch to frame by webElement
	 * @param driver
	 * @param frameelement
	 */
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * this method wait for particular webElement explicitly for 20 seconds
	 * 	
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	/**
	 * this method wiat for particular webElement explicitly for 20 seconds
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this method use for right click actions
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method use for double click on a perticula webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method switch child to parent and parent to child by partial contains
	 * text
	 * 
	 * @param driver
	 * @param pertialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialwinTitle)
	{
		Set<String> windowHandles=driver.getWindowHandles();
		Iterator<String> it=windowHandles.iterator();
		while(it.hasNext())
		{
			String winId=it.next();
			String actTitle=driver.switchTo().window(winId).getTitle();
			if(actTitle.contains(partialwinTitle))
			{
				driver.switchTo().window(actTitle);
				break;
			}
		
		}
		
	}
}
