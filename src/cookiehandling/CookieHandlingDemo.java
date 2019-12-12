package cookiehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			String name = cookie.getName();
			String value = cookie.getValue();
			String domain  = cookie.getDomain();
			String path = cookie.getPath();
			Date date = cookie.getExpiry();
			FileWriter fw;
			try {
				fw = new FileWriter(file);
				BufferedWriter writer = new BufferedWriter(fw);
				writer.write(name+";"+value+";"+domain+";"+path+";"+date+"\n");
				writer.flush();
				writer.close();
				fw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	
	// load the cookie data into the browser
	public void loadCookies(String folderName, String fileName) {
		File file = new File(getFilePath(folderName, fileName));
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			while(line != null) {
				String[] cvalues = line.split(";");
				String name = cvalues[0];
				String value = cvalues[1];
				String domain  = cvalues[2];
				String path = cvalues[3];
				//Fri Dec 13 08:19:47 IST 2019 E MMM dd HH:mm:ss z yyyy
				String dt = cvalues[4];
				SimpleDateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
				Date date = df.parse(dt);
				Cookie cookie = new Cookie(name, value, domain, path, date);
				driver.manage().addCookie(cookie);
				line = reader.readLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
//		obj.login();
		obj.loadCookies("cookieData", "login_cookie.data");
		sleep(3000);
		driver.get("http://automationpractice.com/index.php?controller=my-account");
		sleep(3000);
//		obj.tearDown();
	}

}
