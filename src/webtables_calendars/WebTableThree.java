package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utitlities.BrowserHelper;
import utitlities.JavascriptHelper;

public class WebTableThree extends BrowserHelper {

	public static void main(String[] args) {
		String companyCode = "GAIL";
		openBrowser("chrome",
				"https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement tbody = wait
				.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("#preOpenNiftyTab>tbody"))));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		for (int i = 2; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			if (cells.get(0).getText().contains(companyCode)) {
				// then click on that company code
				WebElement link = cells.get(0).findElement(By.tagName("a"));
				JavascriptHelper.bringElementToView(driver, link);
				link.click();
				break; // break rows loop
			}
		}
		sleep(5000);
		driver.close();

	}

}
