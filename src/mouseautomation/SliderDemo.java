package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utitlities.BrowserHelper;

public class SliderDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/slider/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		// driver focus is in the frame
		WebElement sliderHead = driver.findElement(By.cssSelector("#slider>span"));
		// create an object of Actions class
		Actions actions = new Actions(driver);
		// move the slide head in forward direction
		actions.clickAndHold(sliderHead).moveByOffset(250, 0).release().build().perform();
		sleep(3000);
		//move the slider head in backward direction
		actions.dragAndDropBy(sliderHead, -100, 0).build().perform();
		sleep(3000);
		closeBrowser();
	}
}
