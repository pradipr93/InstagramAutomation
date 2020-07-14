package com.insta.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.insta.base.BaseConfiguration;
import com.insta.base.GeneralWebActions;



public class HomePage extends BaseConfiguration
{
	GeneralWebActions GeneralWebActionsObj = new GeneralWebActions();
//Search textbox element
@FindBy(xpath = "//input[@placeholder = 'Search']")
	WebElement searchbox;

//initialising webelements
 public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}

 //This method is used to search with hashtag and automatically like and comment for each posts in the searched hashtag
 //Parameter: hashtag with return type as String
public void verifyAutoLike(String hashtag) throws InterruptedException
{
	String comment1 = prop.getProperty("comment1");
	String comment2 = prop.getProperty("comment2");
	String comment3 = prop.getProperty("comment3");
	String comment4 = prop.getProperty("comment4");
	String comment5 = prop.getProperty("comment5");
	String comment6 = prop.getProperty("comment6");
	String comment7 = prop.getProperty("comment7");
	String comment8 = prop.getProperty("comment8");
	String comment9 = prop.getProperty("comment9");
	String comment10 = prop.getProperty("comment10");
	
	searchbox.sendKeys(hashtag);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text() = '"+hashtag+"']")).click();
	Thread.sleep(2000);
	List <WebElement> postlinks = driver.findElements(By.xpath("//div[@class = 'v1Nh3 kIKUG  _bz0w']//a"));
	System.out.println(postlinks.size());
	//ArrayList created for storing user defined comments
	ArrayList<String> al = new ArrayList();
	al.add(comment1);
	al.add(comment2);
	al.add(comment3);
	al.add(comment4);
	al.add(comment5);
	al.add(comment6);
	al.add(comment7);
	al.add(comment8);
	al.add(comment9);
	al.add(comment10);
	
	for(int i=0; i<=50; i++)
	{
		executor.executeScript("arguments[0].scrollIntoView();", postlinks.get(i));
		postlinks.get(i).click();
		
		if(driver.findElements(By.xpath("//section//button/..//*[@aria-label = 'Like']")).size()!=0)
		{
		GeneralWebActionsObj.clickElement(By.xpath("//section//button/..//*[@aria-label = 'Like']"));
		GeneralWebActionsObj.wait(5000);
		//This is loop is to comment for only first 10 posts
		if(i<10)
		{
		//Click on Comment Element
		GeneralWebActionsObj.clickElement(By.xpath("//textarea[@aria-label = 'Add a comment…']"));
		driver.findElement(By.xpath("//textarea[@aria-label = 'Add a comment…']")).sendKeys(al.get(i));
		//Posting Comment
		GeneralWebActionsObj.clickElement(By.xpath("//button[text() = 'Post']"));
		GeneralWebActionsObj.wait(10000);
		}
		}
		executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@aria-label='Close']")));
		GeneralWebActionsObj.clickElement(By.xpath("//*[@aria-label='Close']"));
		Thread.sleep(2000);
		postlinks = driver.findElements(By.xpath("//div[@class = 'v1Nh3 kIKUG  _bz0w']//a"));
		System.out.println(postlinks.size());
	
}

}
}
