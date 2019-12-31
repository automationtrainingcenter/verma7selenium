package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;

public class AutoSuggestions extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome", "http://google.com");
		 driver.findElement(By.name("q")).sendKeys("selenium");
		 sleep(2000);
		 WebElement suggestionBox = driver.findElement(By.className("erkvQe"));
		 List<WebElement> suggestions = suggestionBox.findElements(By.tagName("li"));
		 for(WebElement suggestion : suggestions) {
			 String text = suggestion.getText();
			 if(text.equalsIgnoreCase("selenium webdriver")) {
				 suggestion.click();
				 break;
			 }
		 }
		 closeBrowser();
	}

}
