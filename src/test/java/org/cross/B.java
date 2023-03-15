package org.cross;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.global.BassFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class B extends BassFile {
	
    @Test
    private void tc3() {
		browserLaunch("chrome");
		getlaunchUrl("https://www.flipkart.com/account/login");

	}
	
	@Test(groups="smoke")
	private void TC5() throws AWTException {

    	SoftAssert s  = new SoftAssert();
    	WebElement text = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
    	text.sendKeys("805275314");
    	
    	Robot r = new Robot();
    	
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    	
    	Thread.currentThread().getId();    
    	
    	Assert.assertEquals("805275314", "8056275314", "veified");
        
    	s.assertAll(getTheTitle());

    	System.out.println("tc4 -thread count ="+Thread.currentThread().getId());
	}
    
}
