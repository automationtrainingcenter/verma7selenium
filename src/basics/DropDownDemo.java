package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate day drop down list element
		WebElement dayEle = driver.findElement(By.id("day"));
		
		// create a Select class object
		Select daySelect = new Select(dayEle);
		
		// get default date value and print on the console
		WebElement defaultDate = daySelect.getFirstSelectedOption();
		System.out.println("default date value is "+defaultDate.getText());
		
		// select an option from day select using selectByIndex()
		daySelect.selectByIndex(20);
		
		Thread.sleep(3000);
		
		
		// locate month drop down list element
		WebElement monthEle = driver.findElement(By.id("month"));
		
		// create Select class object for month
		Select monthSelect = new Select(monthEle);
		
		// get default month and print on the console
		WebElement defaultMonth = monthSelect.getFirstSelectedOption();
		System.out.println("default month value is "+defaultMonth.getText());
		
		// select an option from month select using selectByValue();
		monthSelect.selectByValue("8");
		
		Thread.sleep(3000);
		
		
		// locate year drop down list element
		WebElement yearEle = driver.findElement(By.id("year"));
		
		// create a Select class object for year
		Select yearSelect = new Select(yearEle);
		
		// get default year and print on the console
		WebElement defaultYear = yearSelect.getFirstSelectedOption();
		System.out.println("default year value is "+defaultYear.getText());
		
		// select an option from year select using selectByVisibleText()
		yearSelect.selectByVisibleText("2016");
		
		// get all the options of year drop down
		List<WebElement> yearOptions = yearSelect.getOptions();
		System.out.println(yearOptions.size());
		
		Thread.sleep(3000);
		
		
		driver.close();
	}

}
