package screenshots;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import utitlities.BrowserHelper;
/*
 * Selenium provides TakesScreenshot interface which contains
 * getScreenshotAs() to capture the screenshot of the current web page.
 * 
 * TakesScreenshot interface is implemented all out browser driver classes
 * 
 * to call TakesScreenshot interface methods we have to type cast existing 
 * driver object to the TakesScreenshot interface object
 * 
 */
public class ScreenshotDemo extends BrowserHelper{
	public static void main(String[] args) throws IOException {
		openBrowser("chrome", "http://www.google.com");
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File desImg = new File(getFilePath("screenshots", "image1.png"));
//		BufferedImage bi = ImageIO.read(srcImg);
//		ImageIO.write(bi, "png", desImg);
		// from selenium 3.6 we have a inbuilt class to handle image savings
		FileHandler.copy(srcImg, desImg);
		closeBrowser();
	}

}
