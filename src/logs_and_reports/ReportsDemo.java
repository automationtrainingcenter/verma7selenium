package logs_and_reports;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utitlities.GenericHelper;
import utitlities.ScreenshotHelper;

public class ReportsDemo {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	// launch browser
	public void launchBrowser() {
		test = reports.createTest("launch browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		test.log(Status.INFO, "chrome browser launched");
		driver.get("http://primusbank.qedgetech.com/");
		test.log(Status.INFO, "navigated to " + driver.getCurrentUrl());
		driver.manage().window().maximize();
		test.log(Status.PASS, "test case passed");
	}

	// login
	public void login() {
		test = reports.createTest("login");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		test.log(Status.INFO, "username filled with Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		test.log(Status.INFO, "password filled with Admin");
		driver.findElement(By.id("login")).click();
		test.log(Status.INFO, "login button clicked");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.log(Status.PASS, "test case passed");}

	// role creation
	public void roleCreation() {
		test = reports.createTest("roleCreation");
		driver.findElement(By.cssSelector("a[href *= 'Roles']")).click();
		test.log(Status.INFO, "clicked on roles button");
		driver.findElement(By.id("btnRoles")).click();
		test.log(Status.INFO, "clicked on new role button");
		driver.findElement(By.id("txtRname")).sendKeys("bandarBranch");
		test.log(Status.INFO, "branch name filled with bandarBranch");
		Select roleTypeSelect = new Select(driver.findElement(By.id("lstRtypeN")));
		roleTypeSelect.selectByVisibleText("E");
		test.log(Status.INFO, "selected role type as E");
		driver.findElement(By.id("btninsert")).click();
		test.log(Status.INFO, "submit method clicked");
		Alert alert = driver.switchTo().alert();
		test.log(Status.INFO, alert.getText());
		test.log(Status.INFO, "alert accepted");
		alert.accept();
		
		try {
			test.log(Status.FAIL, "test case passed").addScreenCaptureFromPath(ScreenshotHelper.takeScreenshot(driver, "screenshots", "role"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	// logout
	public void logout() {
		test = reports.createTest("logout");
		driver.findElement(By.cssSelector("a[href*='primus']")).click();
		test.log(Status.INFO, "logout button clicked");
		test.log(Status.PASS, "test case passed");
	}

	// close browser
	public void closeBrowser() {
		test = reports.createTest("close browser");
		driver.close();
		test.log(Status.INFO, "browser closed");
		test.log(Status.PASS, "test case passed");
	}

	public static void main(String[] args) {
		ReportsDemo obj = new ReportsDemo();
		// create ExtentReports class object
		obj.reports = new ExtentReports();
		// create ExtentHtmlReporter class object
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(GenericHelper.getFilePath("reports", "report1.html"));
		obj.reports.attachReporter(reporter);
		obj.launchBrowser();
		obj.login();
		obj.roleCreation();
		obj.logout();
		obj.closeBrowser();
		// save the report using flush()
		obj.reports.flush();
	}

}
