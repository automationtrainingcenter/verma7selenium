package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFramesDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/SSTS/verma7am/selenium_concepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		
		// now driver focus is in main page
		// automate frame 4 which is an inner frame of frame 3
		// so first switch the driver focus to frame 3 then switch to frame 4
		driver.switchTo().frame("fthree");
		// now driver focus is in frame 3
		// locate frame 4 because it does not have any id or name attribute values
		WebElement frame4Ele = driver.findElement(By.cssSelector("iframe[src *= 'guru99']"));
		driver.switchTo().frame(frame4Ele);
		// now driver focus in in frame 4
		driver.findElement(By.id("gsc-i-id2")).sendKeys("selenium");
		Thread.sleep(3000);
		
		
		// now driver focus is in frame 4 switch that driver focus to frame 3
		// using parentFrame()
		driver.switchTo().parentFrame();
		
		// now driver focus is in frame 3
		driver.findElement(By.id("click")).click();
		Thread.sleep(3000);
		
		// now focus is in frame 3 
		// automate frame 2
		// first switch the driver focus to the main page then switch to frame 2
		driver.switchTo().defaultContent();
		// now driver focus is in main page
		driver.switchTo().frame("ftwo");
		
		// now driver focus in in frame 2
		driver.findElement(By.linkText("selenium official site")).click();
		Thread.sleep(2000);
		
		// now automate frame 1
		// first switch the driver focus to main page using defaultContent()
		// then switch to frame 1 using frame() 
		driver.switchTo().defaultContent();
		// now driver focus is in main page
		driver.switchTo().frame(0);
		
		// now driver focus is in frame 1 
		driver.findElement(By.cssSelector("input[placeholder = 'Enter name']")).sendKeys("sunshine");
		Thread.sleep(2000);
		
		// now driver focus is in frame 1 switch that focus to main page
		driver.switchTo().defaultContent();
		// now driver focus is in main page
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
