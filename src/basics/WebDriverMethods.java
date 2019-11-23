package basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException {

		// launc the browser
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// get(String url) - used to navigate to a given url
		driver.get("http://www.facebook.com");
		Thread.sleep(3000);

		// getTitle() returns inner text of the title tag of head tag i.e. title of the
		// web page
		String title = driver.getTitle();
		System.out.println("title of the web page is " + title);

		// getCurrentUrl() returns url of the current web page
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current url of the web page is " + currentUrl);

		// getPageSource() returns the complete source code of the current web page as a
		// String value
		String pageSource = driver.getPageSource();
		System.out.println(pageSource.contains("Facebook helps you connect and share with the people in your life"));

		// getWindowHandle() returns a unique window id of the current browser window
		String windowID = driver.getWindowHandle();
		System.out.println("window id ---------" + windowID);

		// getWindowHandles() returns all the window ids opened by driver instance as a
		// Set<String>
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println("window ids ----" + windowIds);

		/*
		 * findElement(By arg) returns a WebElement reference. this method will locate
		 * an element in the current web page with the given element information using
		 * By class and returns that element as a WebElement reference. If no element is
		 * located with the given element information it'll throw NoSuchElementException
		 */
		By id = By.id("email");
		WebElement emailField = driver.findElement(id);

		/*
		 * findElements(By arg) returns a List<WebElement> if no element is located with
		 * given element information it'll return List of size zero
		 */
		By tagName = By.tagName("input");
		List<WebElement> inputTags = driver.findElements(tagName);
		System.out.println("number of input tags are " + inputTags.size());

		// close() it'll close the current browser window
//		driver.close();

		// quit() it'll close the all browser windows opened by driver instance
		driver.quit();
	}

}
