package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// locate enter your name text field
		WebElement enterYourNameField = driver.findElement(By.id("name"));
		
		// type some data into the element
		enterYourNameField.sendKeys("sunshine");
		
		Thread.sleep(2000);
		
		// locate alert button and click on it.
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		
		// the above click will open an alert in the web page
		// so get the text of alert
//		TargetLocator tl = driver.switchTo();
//		Alert alert = tl.alert();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("alert text is "+text);
		
		
		// accept the alert
		alert.accept();
		Thread.sleep(2000);
		
		
		// enter some data in the enter your name text field
		enterYourNameField.sendKeys("python");
		
		Thread.sleep(2000);
		
		// locate confirm button and click on it
		driver.findElement(By.id("confirmbtn")).click();
		
		Thread.sleep(2000);
		
		// switch the driver focus to the alert
		Alert confirmAlert = driver.switchTo().alert();
		
		// get the alert text and print on the console
		String confirmAlertText = confirmAlert.getText();
		System.out.println("confirm alert text is "+confirmAlertText);
		
		// cancel the confirm alert
		confirmAlert.dismiss();
		Thread.sleep(2000);
		
		
		driver.close();
		
	}

}
