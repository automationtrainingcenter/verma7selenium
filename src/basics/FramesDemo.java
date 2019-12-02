package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		
		// locate enter your name text field and type some data
		driver.findElement(By.id("name")).sendKeys("sunshine");
		Thread.sleep(3000);
		
		/*
		 * find a course text field is inside a frame so first switch the driver focus 
		 * from main page to frame using one of the following methods.
		 * 
		 * frame(int index) is used to switch the driver focus from main page to frame based on index number
		 * 
		 * frame(String id or name) is used to switch driver focus from main page to frame based on 
		 * frame id or name attribute values
		 * 
		 * frame(WebElement frameEle) is used to switch driver focus from main page to frame based
		 * on frame element, i.e locate frame and save in web elemnet reference and use this
		 * reference as an attribute the frame().
		 * 
		 */
		//now driver focus is in main page so switch the focus to frame
		driver.switchTo().frame("courses-iframe");
		
		// now driver focus switched to frame
		
		// locate find a course test field and type some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(3000);
		
		// switch the driver focus to main page using defaultContent()
		driver.switchTo().defaultContent();
		
		// now driver focus is in main page
		
		// locate hide and show text field and type some data
		driver.findElement(By.id("displayed-text")).sendKeys("selenium");
		Thread.sleep(3000);
		
		driver.close();
	}
	
}
