package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;

public class WebTableOne extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		// locate table body
		WebElement tbody = driver.findElement(By.cssSelector("#product>tbody"));
		// locate all the rows inside the table body using tag name
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		// iterate over every row
		for(int i = 1; i < rows.size(); i++) {
			// locate all the columns or cells inside the ever row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			// iterate over each and every cell
			for(int j = 0; j < cells.size(); j++) {
				String text = cells.get(j).getText();
				System.out.print(text +"\t");
			}
			
			System.out.println();
		}
		closeBrowser();
		
	}

}
