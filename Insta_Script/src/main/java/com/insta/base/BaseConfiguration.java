package com.insta.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.insta.utility.utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseConfiguration {
	
		public static WebDriver driver;
			public static Properties prop;
			public static JavascriptExecutor executor;
			public static WebDriverWait w;
			private static Timeouts implicitlyWait;
			
			public BaseConfiguration() throws IOException
			{
			
				try
				{
					prop = new Properties();
					System.out.println(System.getProperty("user.dir"));
					FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\insta\\configProperties\\config.properties"); 
					prop.load(ip);
				}
				
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
				
			}
			
			public static void initialization() throws InterruptedException
			{
				String BrowserName = prop.getProperty("browser");
				if(BrowserName.equals("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				w = new WebDriverWait(driver,25000);
				executor = (JavascriptExecutor) driver;
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies(); 
				driver.manage().timeouts().pageLoadTimeout(utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		        driver.manage().timeouts().implicitlyWait(utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
				driver.get(prop.getProperty("url"));
				executor.executeScript("document.body.style.zoom = '70%'");
				Thread.sleep(5000);
				
			}
			}



