package screenshots;

import utitlities.BrowserHelper;
import utitlities.JavascriptHelper;
import utitlities.ScreenshotHelper;

public class MultiScreenshots extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome", "https://amazon.in");
		// retrieve scroll height and client hieght
		long sh = (long) JavascriptHelper.executeScript(driver, "return document.documentElement.scrollHeight");
		long ch = (long) JavascriptHelper.executeScript(driver, "return document.documentElement.clientHeight");
		while(sh >= 0) {
			ScreenshotHelper.takeScreenshot(driver, "screenshots", "amazon");
			JavascriptHelper.scrollPage(driver, 0, ch);
			sh -= ch;
			sleep(2000);
		}
		closeBrowser();
	}

}
