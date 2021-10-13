package com.mine.unix.chrome;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TitleTest {
	private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	String remoteURL = "http://localhost:4444"; 
    	//System.setProperty("webdriver.chrome.driver","lib/chromedriver");
    	ChromeOptions chromeOptions = new ChromeOptions();
    	chromeOptions.addArguments("--headless");
    	try { 
    		driver = new RemoteWebDriver(new URL(remoteURL), chromeOptions);
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
    public void verifySearchButton() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        // get the actual value of the title
        String actualTitle = driver.getTitle();
        
        String expectedTitle = "Google";

        Assert.assertEquals(expectedTitle, actualTitle, "Title doesn't match");
        
        
    }

}
