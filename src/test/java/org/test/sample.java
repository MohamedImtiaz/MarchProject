package org.test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.xmlbeans.XmlFactoryHook.ThreadContext;
import org.global.BassFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.pojo.PomLocators;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;


public class sample extends BassFile {
	
	@BeforeClass
	private void timeDate() {
		dateTime();
	}
	
    @Parameters("browser")
    @Test
    private void tc3(String browserName) {
	
    	if (browserName.startsWith("ch")) {
			
    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\ProgramProject\\driver\\chromedriver.exe");
    		WebDriver driver= new ChromeDriver();
		}
        else if (browserName.equals("edge")) {
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\ProgramProject\\driver\\msedgedriver.exe");
    		WebDriver driver= new EdgeDriver();
		}
        else {
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\ProgramProject\\driver\\geckodriver.exe");
    		WebDriver driver= new EdgeDriver();
			
		}
    	driver.get("https://www.flipkart.com/account/login");
	}
    
	}

	

	
	


