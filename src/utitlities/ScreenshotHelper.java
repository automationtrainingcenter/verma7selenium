package utitlities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotHelper extends GenericHelper{
	private static String getTimeStamp() {
		Date date = new Date();
		DateFormat dt = new SimpleDateFormat("dd_MMM_yyyy--HH_mm_ss--z");
		return dt.format(date);
		
	}
	
	// capture a screenshot
	// provide file name only, no need of extension
	public static void takeScreenshot(WebDriver driver, String folderName, String fileName) {
		// convert webdriver reference to the TakesScreenshot reference
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(getFilePath(folderName, fileName+getTimeStamp()+".png"));
		try {
			FileHandler.copy(srcImg, destImg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
