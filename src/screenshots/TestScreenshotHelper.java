package screenshots;

import org.openqa.selenium.By;

import utitlities.BrowserHelper;
import utitlities.ScreenshotHelper;

public class TestScreenshotHelper extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		// alert screen capture
//		driver.findElement(By.id("alertbtn")).click();
//		ScreenshotHelper.alertScreenshot("screenshots", "alert");
//		driver.switchTo().alert().accept();
		
		// single screenshot
//		ScreenshotHelper.takeScreenshot(driver, "screenshots", "facebook");
		
		
		// multiple screenshots
		ScreenshotHelper.takeMultipleScreenshots(driver, "screenshots", "practice"); 
		closeBrowser();
	}

}
