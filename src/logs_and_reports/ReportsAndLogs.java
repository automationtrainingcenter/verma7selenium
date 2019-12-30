package logs_and_reports;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utitlities.GenericHelper;

public class ReportsAndLogs extends BaseClass{
	WebDriver driver;
	Listener listener;
	EventFiringWebDriver edriver;
	
	// launch browser
	public void launchBrowser() {
		test = reports.createTest("launch browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		// create an object Listener class
		listener = new Listener();
		// create an object of EventFiringWebDriver
		edriver = new EventFiringWebDriver(driver);
		// register the Listener class object with EventFiringWebDriver object
		edriver.register(listener);
		driver = edriver;
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		System.out.println("*****************************************************");
	}
	
	
	// login
	public void login() {
		test = reports.createTest("login");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("*****************************************************");
	}
	
	
	// role creation
	public void roleCreation() {
		test = reports.createTest("role creation");
		driver.findElement(By.cssSelector("a[href *= 'Roles']")).click();
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys("bandarBranch");
		Select roleTypeSelect = new Select(driver.findElement(By.id("lstRtypeN")));
		roleTypeSelect.selectByVisibleText("E");
		driver.findElement(By.id("btninsert")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("*****************************************************");
	}
	
	
	// logout
	public void logout() {
		test = reports.createTest("logout");
		driver.findElement(By.cssSelector("a[href*='primus']")).click();
		System.out.println("*****************************************************");
	}
	
	
	// close browser
	public void closeBrowser() {
		test = reports.createTest("close browser");
		driver.close();
		System.out.println("*****************************************************");
	}
	
	public static void main(String[] args) {
		ReportsAndLogs obj = new ReportsAndLogs();
		obj.reports = new ExtentReports();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(GenericHelper.getFilePath("reports", "report2.html"));
		obj.reports.attachReporter(reporter);
		obj.launchBrowser();
		obj.login();
		obj.roleCreation();
		obj.logout();
		obj.closeBrowser();
		obj.reports.flush();
	}

}
