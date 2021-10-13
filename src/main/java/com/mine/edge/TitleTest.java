package com.mine.edge;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import com.microsoft.edge.seleniumtools.*;

public class TitleTest {
	private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.edge.driver","lib\\msedgedriver.exe");
    	//.drive chromeOptions = new Options();
    	//chromeOptions.addArguments("--headless");
        //driver = new ChromeDriver(chromeOptions);
    	EdgeOptions options = new EdgeOptions(); 
    	//options.setCapability("headless", true);
    	options.addArguments("--headless"); 
    	
    	driver = new EdgeDriver(options); 
    }

    @AfterClass
    public void afterClass() {
    	driver.close();
        //driver.quit();
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
