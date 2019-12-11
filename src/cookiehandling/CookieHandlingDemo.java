package cookiehandling;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utitlities.BrowserHelper;

public class CookieHandlingDemo extends BrowserHelper {
	WebDriverWait wait;
	
	// store cookie details
	public void storeCookieDetails(String folderName, String fileName) {
		File file = new File(getFilePath(folderName, fileName));
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getPath());
			System.out.println(cookie.getExpiry());
			System.out.println(cookie.isSecure());
		}
	}

	// launch browser
	public void launchBrowser() {
		openBrowser("chrome", "http://automationpractice.com");
		wait = new WebDriverWait(driver, 30);
	}

	// login
	public void login() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("test@sunshine.com");
		driver.findElement(By.id("passwd")).sendKeys("selenium");
		driver.findElement(By.id("SubmitLogin")).click();
		storeCookieDetails("cookieData", "login_cookie.data");
	}

	// close browser
	public void tearDown() {
		closeBrowser();
	}

	public static void main(String[] args) {
		CookieHandlingDemo obj = new CookieHandlingDemo();
		obj.launchBrowser();
		obj.login();
		obj.tearDown();
	}

}
