package screenshots;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import utitlities.BrowserHelper;

public class AlertScreenShotDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		// locate alert button and click on it
		driver.findElement(By.id("alertbtn")).click();
		// use Robot class of java to capture the alert screenshots
		try {
			Robot r = new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(d);
			BufferedImage bi = r.createScreenCapture(rect);
			File destImg = new File(getFilePath("screenshots", "alert.png"));
			ImageIO.write(bi, "png", destImg);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().alert().accept();
		closeBrowser();
	}
	
	

}
