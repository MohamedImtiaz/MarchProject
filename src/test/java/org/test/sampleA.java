package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.global.BassFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pojo.PomLocators;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class sampleA extends BassFile {
	
	@Test()
	private void tc1() {
		browserLaunch("chrome");
        maxiWindow();
        getlaunchUrl("https://www.flipkart.com/account/login");
	}
	@Test()
    private void tc2() throws InterruptedException, IOException, AWTException {
    	
    	SoftAssert s  = new SoftAssert();
    	WebElement text = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
    	text.sendKeys("805275314");
    	
    	Robot r = new Robot();
    	
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    	
    	Thread.currentThread().getId();    
    	
    	Assert.assertEquals("805275314", "8056275314", "veified");
        
    	s.assertAll(getTheTitle());
    }  
    }


