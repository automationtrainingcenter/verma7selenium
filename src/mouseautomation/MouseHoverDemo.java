package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utitlities.BrowserHelper;
/*
 * Selenium provides Actions class to perform mouse related events 
 * we can perform multiple or single action on an element using Actions class object
 * to combine multiple actions we have to use build() of Actions class
 * to perform any action we have to use perform()
 */

public class MouseHoverDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.firstcry.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		// create Actions class object by passing WebDriver reference
		Actions actions = new Actions(driver);
		
		
		WebElement babyClothes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='menu1']/preceding-sibling::a")));
		// mouse hover to the baby clothes using moveToElement()
		actions.moveToElement(babyClothes).build().perform();
		
		sleep(3000);
		
		
		// locate baby girl link
		WebElement babyGirlLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title = 'Baby Girl']")));
		// mouse hover to the baby girl
		actions.moveToElement(babyGirlLink).build().perform();
		
		sleep(3000);
		
		// locate frocks and dresses
		WebElement frocksAndDresses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href *= 'babygirl_Frocks']")));
		// mouse hover to the frocks and dresses and click on that 
		actions.moveToElement(frocksAndDresses).click().build().perform();
		
		sleep(3000);
		
		closeBrowser();
	
	}

}
