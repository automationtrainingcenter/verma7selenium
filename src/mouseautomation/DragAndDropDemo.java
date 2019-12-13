package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utitlities.BrowserHelper;

public class DragAndDropDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/droppable/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// switch to the frame which contains drag and drop elements
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

		// locate drag and drop elements
		WebElement dragEle = driver.findElement(By.id("draggable"));
		WebElement dropEle = driver.findElement(By.id("droppable"));

		// create an Actions class object
		Actions actions = new Actions(driver);
		
		// automate drag and drop action
//		actions.clickAndHold(dragEle).moveToElement(dropEle).release().build().perform();

		actions.dragAndDrop(dragEle, dropEle).build().perform();
		sleep(3000);
		closeBrowser();
	}

}
