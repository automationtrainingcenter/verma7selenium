package javascriptdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;
import utitlities.JavascriptHelper;

public class BringElementToView extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.amazon.in/");
		WebElement navBackToTopLink = driver.findElement(By.id("navBackToTop"));
		// create a JavaScriptExecutor object reference
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView()", navBackToTopLink);
		JavascriptHelper.bringElementToView(driver, navBackToTopLink);
		sleep(3000);
		// scroll the page up
//		js.executeScript("document.documentElement.scrollBy(0, -150)");
		JavascriptHelper.scrollPage(driver, 0, -150);
		sleep(3000);
		
		closeBrowser();
	}

}
