package screenshots;

import org.openqa.selenium.By;

import utitlities.BrowserHelper;
import utitlities.ScreenshotHelper;

public class TestScreenshotHelper extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		driver.findElement(By.id("alertbtn")).click();
		ScreenshotHelper.alertScreenshot("screenshots", "alert");
		driver.switchTo().alert().accept();
//		ScreenshotHelper.takeScreenshot(driver, "screenshots", "facebook");
		closeBrowser();
	}

}
