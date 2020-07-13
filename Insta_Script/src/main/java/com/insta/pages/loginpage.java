package com.insta.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insta.base.BaseConfiguration;
import com.insta.base.GeneralWebActions;
import com.insta.utility.utility;


public class loginpage extends BaseConfiguration
{
	GeneralWebActions GeneralWebActionsObj = new GeneralWebActions();
	@FindBy(xpath="//input[@aria-label = 'Phone number, username, or email']")
	WebElement username;
	@FindBy(xpath="//input[@aria-label = 'Password']")
	WebElement password;
	@FindBy(xpath="//button[@type = 'submit']")
	WebElement login;
	
	public loginpage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String un, String pwd) throws IOException, InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//button[text() = 'Not Now']")).isDisplayed())
		{
			GeneralWebActionsObj.clickElement(By.xpath("//button[text() = 'Not Now']"));
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//button[text() = 'Not Now']")).isDisplayed())
			{
				GeneralWebActionsObj.clickElement(By.xpath("//button[text() = 'Not Now']"));
				Thread.sleep(2000);
			}
			
		}
		
		return new HomePage();
	}
}
