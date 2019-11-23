package basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LaunchBrowser {
	
	public static void main(String[] args) {
		// set system property to the path of driver executable of the browser we want to automate
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// create an object of ChromeDriver class
		ChromeDriver cdriver = new ChromeDriver();
		
		
		
		// set the system property for geckodriver.exe to launch firefox browser
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		// create an object of FirefoxDriver class
		FirefoxDriver fdriver = new FirefoxDriver();
		
	}

}
