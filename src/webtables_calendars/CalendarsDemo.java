package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;

public class CalendarsDemo extends BrowserHelper{
	public static void main(String[] args) {
		String date = "15";
		boolean flag = false;
		openBrowser("chrome", "https://www.redbus.in");
		driver.findElement(By.cssSelector("label[for = onward_cal]")).click();
		sleep(1000);
		// locate table body of the calendar in which we want to select a date
		WebElement tbody = driver.findElement(By.cssSelector("#rb-calendar_onward_cal>table>tbody"));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		for(int i = 2; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			for(WebElement cell : cells) {
				if(cell.getText().equals(date)) {
					cell.click();
					flag = true;
					break; // it breaks columns loop
				}
			}
			
			if(flag) {
				break; // it breaks rows loop
			}
		}
		sleep(3000);
		closeBrowser();
	}

}
