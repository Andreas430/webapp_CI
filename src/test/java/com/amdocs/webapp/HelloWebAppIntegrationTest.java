package com.amdocs.webapp;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

public class HelloWebAppIntegrationTest {

    WebDriver driver;
    String hubURL = null;
    String testURL = null;
    String screenshotLocation = null;

    @Before
    public void setUp() throws Exception {
        hubURL = System.getProperty("hubURL");
        testURL = System.getProperty("testURL");
        screenshotLocation = System.getProperty("screenshotLocation");

        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL(hubURL), caps);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testScreenshot() throws Exception {
        driver.get(testURL);
        captureScreenshot(driver, screenshotLocation);
    }

    @Test
    public void testCityName() throws Exception {
        driver.get(testURL);
        assertTrue("Page contains correct city name", driver.getPageSource().contains("Limassol!"));
    }

    public void captureScreenshot(WebDriver driver, String filename) throws IOException
	{
		
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filename));
	}	
}
