package org.cross;

import org.global.BassFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class gress extends BassFile{

	
	@Test(groups = "sanity")
	private void tc3() {
		
		WebElement passtxt = driver.findElement(By.xpath("//input[@id='pass']"));
		passtxt.sendKeys("8056275314");
		
		
	}
}
