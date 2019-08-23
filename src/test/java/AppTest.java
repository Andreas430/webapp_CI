package com.qaagility.controller;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import java.util.logging.Logger;

public class AppTest {

WebDriver driver;

      public void testSlow() {
        System.out.println("slow");
      }

      public void testSlower() {
        System.out.println("slower");
      }

      public void testFast() {
        System.out.println("fast-updated");
      }
	
	@Test	
      public void testCalc() {
        String mygecko=System.getenv("HOME") + "/Downloads/geckodriver";
        System.out.println(mygecko);
	//System.setProperty("webdriver.gecko.driver","/home/train/Downloads/geckodriver");
	System.setProperty("webdriver.gecko.driver",mygecko);
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/HelloWebAppProject/hello");

       try 
 	{
		Thread.sleep(3000);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
      String text = "Maven Web Project";
      String bodyText = driver.findElement(By.tagName("body")).getText();
      Assert.assertTrue("Text not found!", bodyText.contains(text));
      driver.quit();





      }



}
