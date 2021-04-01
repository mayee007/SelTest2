package com.mine.firefox;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TitleTest {
	private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.gecko.driver","C:\\MyInstalls\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
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
