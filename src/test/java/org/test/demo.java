package org.test;

import org.global.BassFile;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo extends BassFile{
	
	
	@Test
	private void tc1(String browserName) {
		
		getTheTitle();
		Thread.currentThread().getId(); 
}
	@AfterClass
	private void timeout() {
		dateTime();
		quit();
		Thread.currentThread().getId(); 
	}
}