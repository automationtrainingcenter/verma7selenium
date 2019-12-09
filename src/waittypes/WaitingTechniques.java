package waittypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import utitlities.BrowserHelper;

public class WaitingTechniques extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.facebook.com");
		
		/*
		 * WebDriver interface contains manage() which returns Options interface
		 * reference. In Options interface we have timeouts() which returns TimeOuts
		 * interface reference. This TimeOut interface contains different wait type
		 * methods
		 */
		// pageLoadTimeout(): is used to wait for entire page to load
//		Options manage = driver.manage();
//		Timeouts timeouts = manage.timeouts();
//		timeouts.pageLoadTimeout(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		// implicitlyWait(): is used to wait until an element found.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		// setScriptTimeout()
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("email")).sendKeys("hello");
		
		
		
	}

}
