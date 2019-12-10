package waittypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		// setScriptTimeout()
//		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		
		
//		driver.findElement(By.id("email")).sendKeys("hello");
		
		
		// explicit wait: is also known as WebDriverWait. It is a condition based wait
		// i.e. we can implement any condition and this wait will wait until the amount
		// time we specified to verify that condition
		// All these conditions are available as methods in ExcpectedConditions class
		// we can implement our condition also using a Function or Predicate functional interfaces
		
		
//		Function<WebDriver, WebElement> findEle = new Function<WebDriver, WebElement>() {
//
//			@Override
//			public WebElement apply(WebDriver driver) {
//				WebElement ele = driver.findElement(By.id("email"));
//				return ele;
//			}
//		};
		
		// create WebDriverWait class object
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("email");
		wait.until(driver -> driver.findElement(By.id("email"))).sendKeys("sunshine");
		
//		wait.until()
		
		closeBrowser();
		
	}

}
