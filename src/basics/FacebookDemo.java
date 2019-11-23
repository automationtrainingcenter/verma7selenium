package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		// retrieve the title of the webpage
		String title = driver.getTitle();
		System.out.println(title);
		
		// locate email field
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("sunshine");
		// locate password field
		driver.findElement(By.id("pass")).sendKeys("password");
		
		Thread.sleep(3000);
		
		// locate login link and click on it
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
