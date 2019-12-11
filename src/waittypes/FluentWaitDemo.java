package waittypes;

import java.time.Duration;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import utitlities.BrowserHelper;

public class FluentWaitDemo extends BrowserHelper{
	
	public static void main(String[] args) throws InterruptedException {
		
//		Function<WebDriver, WebElement> mywait = new Function<WebDriver, WebElement>() {
//
//			@Override
//			public WebElement apply(WebDriver t) {
//				return t.findElement(By.id("email"));
//			}
//		};
		openBrowser("chrome", "http://www.facebook.com");
		// create a FluentWait class object
		FluentWait<WebDriver> fwait = new FluentWait<>(driver);
		fwait.withTimeout(Duration.ofSeconds(30));
		fwait.pollingEvery(Duration.ofMillis(5000));
		fwait.ignoring(NoSuchElementException.class);
		
		fwait.until(driver -> driver.findElement(By.id("email"))).sendKeys("sunshine");
		
		
	}

}
