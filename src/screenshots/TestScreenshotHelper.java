package screenshots;

import utitlities.BrowserHelper;
import utitlities.ScreenshotHelper;

public class TestScreenshotHelper extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("firefox", "http://www.facebook.com");
		ScreenshotHelper.takeScreenshot(driver, "screenshots", "facebook");
		closeBrowser();
	}

}
