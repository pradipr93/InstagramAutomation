package com.insta.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insta.base.BaseConfiguration;
import com.insta.pages.HomePage;
import com.insta.pages.loginpage;
import com.insta.utility.ReadWriteFile;
import com.insta.utility.utility;





public class LoginTest extends BaseConfiguration
{
	loginpage login;
	HomePage HomePageObj;
	ReadWriteFile ReadWriteFileObj; 
	utility utilityObj;
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
	   ReadWriteFileObj = new ReadWriteFile();
	   utilityObj = new utility();
	}
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		String hashtag = ReadWriteFileObj.replaceSelected();
		System.out.println(hashtag);
		String encodedpassword = prop.getProperty("encodedpassword");
		String decodedpassword = utilityObj.decodepassword(encodedpassword);
		login.login(prop.getProperty("username"), decodedpassword);
		HomePageObj.verifyAutoLike(hashtag);
		
	}
	}
	

