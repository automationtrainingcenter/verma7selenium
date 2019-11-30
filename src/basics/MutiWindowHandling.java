package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MutiWindowHandling {
	
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://learn.letskodeit.com/p/practice");
			driver.manage().window().maximize();
			
			// locate open window and click on it
			driver.findElement(By.id("openwindow")).click();
			Thread.sleep(3000);
			
			// the above click will open a new window, get all opened window ids using getWindowHandles()
			Set<String> windowHandles = driver.getWindowHandles();
			
			// convert set to list
			List<String> windowIds = new ArrayList<>(windowHandles);
			
			/*
			 * the above will store all the window ids opened by driver instance in order, i.e
			 * in index 0 we will main window or parent window, in index 1 we will have first child
			 * window, in index 2 we will second child window ..etc
			 */
			
			// now driver focus is in main window i.e. parent
			// switch that focus to child window
			driver.switchTo().window(windowIds.get(1));
			
			// now driver focus is in child window
			System.out.println("child window url is "+driver.getCurrentUrl());
			
			// locate search courses in child window and type some data
			driver.findElement(By.id("search-courses")).sendKeys("ruby");
			Thread.sleep(3000);
			
			
			// now switch driver focus back to the parent window
			driver.switchTo().window(windowIds.get(0));
			// now driver focus is in parent window
			System.out.println("parent window url is "+driver.getCurrentUrl());
			
			// locate enter your name text field and type some data
			driver.findElement(By.id("name")).sendKeys("sunshine");
			Thread.sleep(3000);
			
			driver.quit();
		}

}
