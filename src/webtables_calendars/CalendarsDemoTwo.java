package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utitlities.BrowserHelper;

public class CalendarsDemoTwo extends BrowserHelper {
	
	private static void selectDate(WebElement tbody, String date) {
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		boolean flag = false;
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				if (cell.getText().equals(date)) {
					cell.findElement(By.tagName("a")).click();
					flag = true;
					break; // breaks cell loop
				}
			}
			if (flag) {
				break; // breaks rows loop
			}
		}
	}

	public static void main(String[] args) {
		openBrowser("chrome", "https://www.abhibus.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.id("datepicker1")).click();
		WebElement departureCal = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-datepicker-group-last tbody")));
		selectDate(departureCal, "25");
		sleep(3000);
		driver.findElement(By.id("datepicker2")).click();
		WebElement returnCal = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-datepicker-group-last tbody")));
		selectDate(returnCal, "2");
		
		sleep(3000);
		closeBrowser();
	}

}
