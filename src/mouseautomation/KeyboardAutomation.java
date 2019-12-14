package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import utitlities.BrowserHelper;

public class KeyboardAutomation extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.facebook.com");
		driver.findElement(By.name("firstname")).sendKeys(Keys.SHIFT+"sunshine");
		sleep(3000);
		driver.findElement(By.name("firstname")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//		driver.findElement(By.name("firstname")).sendKeys(Keys.CONTROL+"a");
		sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys(Keys.chord(Keys.CONTROL, "c"));
		driver.findElement(By.name("firstname")).sendKeys(Keys.chord(Keys.TAB, Keys.CONTROL, "v"));
//		sleep(5000);
//		closeBrowser();
	}
}
		