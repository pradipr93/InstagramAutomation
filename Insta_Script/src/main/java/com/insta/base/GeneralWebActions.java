package com.insta.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GeneralWebActions extends BaseConfiguration{

	public GeneralWebActions() throws IOException {
		super();
	}
	//This is generic method created for Clicking on any element
	//Method Name: clickElement
	//Parameter: element with By as return type
	public void clickElement(By element) throws InterruptedException
	{
		driver.findElement(element).click();
		Thread.sleep(2000);
	}
	
	public void clickUsingJavascript(WebElement webElement) throws InterruptedException
	{
		executor.executeScript("arguments[0].click();", webElement);
		Thread.sleep(2000);
	}
	
	//This is generic method created for Sending text on any element
	//Method Name: clickElement
	//Parameter: element with By as return type
	public void sendKeys(By element, String text) throws InterruptedException
	{
		driver.findElement(element).sendKeys(text);
	}
	
	public void wait(int time) throws InterruptedException
	{
		Thread.sleep(time);
	}
	
	

}
