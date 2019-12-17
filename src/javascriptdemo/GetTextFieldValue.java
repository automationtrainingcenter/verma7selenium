package javascriptdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;

/*
 * Selenium provides JavaScriptExecutor interface to execute any 
 * javascript code using executeScript()
 * 
 * JavaScriptExecutor interface is implemented by browsr driver classes
 * 
 * to call the executeScript() we have to type case webdriver reference to 
 * the JavaScriptExecutor reference
 */
public class GetTextFieldValue extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		
		// locate enter your name text filed
		WebElement enterYourNameField = driver.findElement(By.id("name"));
		
		// type some data in the above field
//		enterYourNameField.sendKeys("sunshine");
		
		// retrieve the data of the above field using JavaScriptExecutor interface
		// Type cast WebDriver reference to JavaScriptExecutor reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// type some data in the above field using js
		js.executeScript("arguments[0].value = arguments[1]", enterYourNameField, "Selenium");
		
		sleep(2000);
		
		String value = js.executeScript("return arguments[0].value", enterYourNameField).toString();
	
		System.out.println("enter your name text filed value is "+value);
		
		closeBrowser();
	}
	

}
