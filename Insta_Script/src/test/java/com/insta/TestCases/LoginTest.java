package com.insta.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insta.base.BaseConfiguration;
import com.insta.pages.HomePage;
import com.insta.pages.loginpage;





public class LoginTest extends BaseConfiguration
{
	loginpage login;
	HomePage HomePageObj;
	
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
    
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
	   login = new loginpage();
	   HomePageObj = new HomePage();
	}
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		HomePageObj.verifyAutoLike(prop.getProperty("hashtag"));
		
	}
	}
	

