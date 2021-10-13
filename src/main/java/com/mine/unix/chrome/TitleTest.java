package com.mine.unix.chrome;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TitleTest {
	private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	String remoteURL = "http://localhost:4444"; 
    	ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.addArguments("--headless");
    	 
    	//System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
    	
    	try { 
    		driver = new RemoteWebDriver(new URL(remoteURL), chromeOptions);
    		//driver = new ChromeDriver(chromeOptions);
    		System.out.println("Driver info " +driver);
    	}
    	catch(Exception e) {
    		System.out.println("----- Exception " +e);
    	}
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void googleTitleTest() {

    	System.out.println("inside google test"); 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        // get the actual value of the title
        String actualTitle = driver.getTitle();
        
        String expectedTitle = "Google";

        System.out.println("expected = "+ expectedTitle + ", actual = " + actualTitle); 
        Assert.assertEquals(expectedTitle, actualTitle, "Title doesn't match");
        
        
    }

    @Test
    public void yahooTitleTest() {

    	System.out.println("inside yahoo test"); 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.yahoo.com");

        // get the actual value of the title
        String actualTitle = driver.getTitle();
        
        String expectedTitle = "Ygoo";

        System.out.println("expected = "+ expectedTitle + ", actual = " + actualTitle); 
        Assert.assertEquals(expectedTitle, actualTitle, "Title doesn't match");
        
        
    }
}
