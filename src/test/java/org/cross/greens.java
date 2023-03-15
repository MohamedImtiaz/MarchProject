package org.cross;

import org.global.BassFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class greens extends BassFile {
	
	
	@Parameters({"useremail"})
	@Test(dataProvider="login")

	private void tc2(@Optional ("875056275") String email) throws InterruptedException {
		
		
		browserLaunch("chrome");
		maxiWindow();
		
		getlaunchUrl("https://mail.google.com/");

		
		WebElement idtext = driver.findElement(By.xpath("(//input[@dir='ltr'])[1]"));
		idtext.sendKeys(email);
		
		
		tSleep(5000);
	}
	
	@DataProvider(name="login")
	public Object [] [] test() {
		return new Object[] [] {
			
			{"9176758053"},
			{"8056275314"},
			{"9941067609"},
	};
	}
}

