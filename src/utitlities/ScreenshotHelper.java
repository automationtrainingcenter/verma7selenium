package utitlities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.w3c.dom.css.Rect;

public class ScreenshotHelper extends GenericHelper {
	private static String getTimeStamp() {
		Date date = new Date();
		DateFormat dt = new SimpleDateFormat("dd_MMM_yyyy--HH_mm_ss--z");
		return dt.format(date);

	}

	// capture a screenshot
	// provide file name only, no need of extension
	public static void takeScreenshot(WebDriver driver, String folderName, String fileName) {
		// convert webdriver reference to the TakesScreenshot reference
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(getFilePath(folderName, fileName + getTimeStamp() + ".png"));
		try {
			FileHandler.copy(srcImg, destImg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// capture alert screenshot
	public static void alertScreenshot(String folderName, String fileName) {
		try {
			Thread.sleep(2000);
			Robot r = new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(d);
			BufferedImage bi = r.createScreenCapture(rect);
			File destImg = new File(getFilePath(folderName, fileName + getTimeStamp() + ".png"));
			ImageIO.write(bi, "png", destImg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
