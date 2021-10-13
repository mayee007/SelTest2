package com.mine.ie;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TitleTestIE {
	private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.ie.driver","lib\\iedriver.exe");
    	FirefoxOptions options = new FirefoxOptions(); 
    	options.setHeadless(true);
        driver = new FirefoxDriver(options);
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
