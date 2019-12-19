package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utitlities.BrowserHelper;

public class WebTableTwo extends BrowserHelper{
	
	public static void main(String[] args) {
		String companyCode = "TATAMOTORS";
		openBrowser("firefox", "https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// locate table body
		WebElement tbody = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#preOpenNiftyTab>tbody")));
		// locate all the rows inside the table body
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		// iterate over every row
		for(int i = 2; i < rows.size(); i++) {
			// locate all the cells inside every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			if(cells.get(0).getText().contains(companyCode)) {
				System.out.println("share price of "+companyCode+" === "+cells.get(3).getText());
				break; // rows loop
			}
		}
		closeBrowser();
	}

}
