package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws InterruptedException {
		// set system property
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// create an object of ChromeDriver class
		WebDriver driver = new ChromeDriver();

		// create an object reference of Navigation interface
		Navigation navigate = driver.navigate();

		// to(String url) which is used navigate to a url
		navigate.to("http://www.google.com");
		Thread.sleep(2000);

		// to(URL arg) which is used to navigate to a given url
		try {
			navigate.to(new URL("http://www.gmail.com"));
			Thread.sleep(2000);

			// back() is used to automate back button of the browser
			navigate.back();
			Thread.sleep(2000);

			// forward() is used to automate forward button of the browser
			navigate.forward();
			Thread.sleep(2000);

			// refresh() is used to refresh the current web page
			navigate.refresh();
			Thread.sleep(2000);

		} catch (MalformedURLException e) {
			System.out.println("url is not in proper format");
		} finally {
			driver.close();
		}

	}

}
