package org.cross;

import org.global.BassFile;
import org.testng.annotations.Test;

public class A extends BassFile{
	
	@Test(groups="smoke")
	private void TC1() {
		browserLaunch("chrome");
		System.out.println("tc1 -thread count ="+Thread.currentThread().getId());
		
	}
    @Test(groups="smoke")
    private void tc2() {
		maxiWindow();
		System.out.println("tc2 -thread count ="+Thread.currentThread().getId());
	}
    @Test(groups="smoke")
    private void tc3() {
		getlaunchUrl("https://www.flipkart.com/account/login");
		System.out.println("tc3 -thread count ="+Thread.currentThread().getId());
	}
    

}
