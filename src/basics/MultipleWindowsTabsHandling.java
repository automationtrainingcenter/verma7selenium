package basics;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsTabsHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/SSTS/verma7am/selenium_concepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		// locate open windows button and click on it
		// it will open multiple windows
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(5000);
		
		// retrieve all the window ids using getWindowHandles()
		Set<String> windowHandles = driver.getWindowHandles();
		// convert set to list
		List<String> windowsIDs = new ArrayList<>(windowHandles);
		// List is index based so in index 0 we will have main window, in index 1 we will have first child window
		// in index 2 we will have second child window and so on
//		for(int i= 0; i < windowsIDs.size(); i++) {
//			driver.switchTo().window(windowsIDs.get(i));
//			System.out.println("in index "+i+" we have "+driver.getTitle());
//		}
		
		// youtube in index 2
		// now driver focus is in main page switch the driver focus to youtube window i.e. 2nd child window
		driver.switchTo().window(windowsIDs.get(2));
		// now driver focus is in youtube window
		driver.findElement(By.id("search")).sendKeys("selenium webdriver architechture"+Keys.ENTER);
		Thread.sleep(3000);
		driver.close();
		
		
		// facebook in index 1
		// now driver focus is in youtube page switch that focus to facebook window i.e. 1st child window
		driver.switchTo().window(windowsIDs.get(1));
		// now driver focus in facebook window
		driver.switchTo().activeElement().sendKeys("sunshine");
		Thread.sleep(3000);
		driver.close();
		
		
		// google in index 3
		// now driver focus is in facebook page switch that focus to google window i.e. 3rd child window
		driver.switchTo().window(windowsIDs.get(3));
		// now driver focus is in google page
		driver.findElement(By.name("q")).sendKeys("sunshine techno system"+Keys.ENTER);
		Thread.sleep(3000);
		driver.close();
		
		// main page in index 0
		// now driver focus is in google page switch that focus to main page i.e index 0
		driver.switchTo().window(windowsIDs.get(0));
		// now driver focus is in main page
		driver.findElement(By.id("opentWin")).click();
		
		Thread.sleep(5000);
		
		
		driver.quit();
	}

}
