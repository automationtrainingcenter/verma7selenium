package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utitlities.BrowserHelper;

public class DragEventDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/draggable/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		// create Actions class object
		Actions actions = new Actions(driver);
		
		// the elements we want to automate are inside a frame so switch driver
		// focus to the frame
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		
		//locate drag me around element
		WebElement dragEle = driver.findElement(By.id("draggable"));
		
		// approach 1
//		actions.clickAndHold(dragEle).moveByOffset(100, 100).release().build().perform();
		
		
		// approach 2
		actions.dragAndDropBy(dragEle, 100, 100).build().perform();
		sleep(3000);
		
		driver.switchTo().defaultContent();
		
		closeBrowser();
		
	}

}
