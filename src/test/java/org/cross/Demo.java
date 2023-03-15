package org.cross;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.global.BassFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo extends BassFile {
	
	@Parameters("browser")
	@Test
	private void crossLaunch(String browserName) throws AWTException {
		
			if(browserName.equals("chrome")){
				WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
				System.out.println("chrome");
				getlaunchUrl("http://www.greenstechnologys.com/");
				
			}
			else if (browserName.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println("edge");
				getlaunchUrl("http://www.greenstechnologys.com/");
			}
			else {
				getlaunchUrl("http://www.greenstechnologys.com/");
			}
	}
		
		}