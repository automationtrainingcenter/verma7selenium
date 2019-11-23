package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Window interface methods
 */

public class BrowserManagement {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");

		// create an object of Window interface reference
		/*
		 * Window is an inner interface of WebDriver interface in WebDriver we have
		 * manage() which returns Options interface reference. In Options interface we
		 * have window() which returns Window interface reference.
		 */
		Options options = driver.manage();
		Window window = options.window();

		// getSize() returns size of the browser window as a Dimension class object
		Dimension size = window.getSize();
		System.out.println("width = " + size.getWidth() + " and height = " + size.getHeight());

		// getPosition() returns position of the browser window as a Point class object
		Point position = window.getPosition();
		System.out.println("window is at x = " + position.getX() + " and at y = " + position.getY());

		// maximize() it will maximizes the browser window
		window.maximize();
		Thread.sleep(2000);
		// to maximize the browser window we can simply write
//		driver.manage().window().maximize();

		// fullScreen() it will full screen (F11 mode) the browser window
		window.fullscreen();
		Thread.sleep(2000);

		// setSize(Point arg) it will set the browser window size to the specified width
		// and height
		window.setSize(new Dimension(550, 350));
		Thread.sleep(2000);

		// setPosition(Point arg) it will set the browser window position to the
		// specified x and y values
		window.setPosition(new Point(600, 300));
		Thread.sleep(2000);

		driver.close();

	}

}
