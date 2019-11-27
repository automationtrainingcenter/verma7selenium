package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate firstName field
		By firstNameLoc = By.name("firstname");
		WebElement firstName = driver.findElement(firstNameLoc);
		
		// sendKeys(String arg) is used to send key strokes to the text field or text area
		firstName.sendKeys("sunshine");
//		driver.findElement(By.name("firstname")).sendKeys("sunshine");
		Thread.sleep(3000);
		
		// clear() is used to remove existing value in a text filed or text area
		firstName.clear();
		Thread.sleep(3000);
		
		// click() is used to click on an element
		WebElement signupBtn = driver.findElement(By.name("websubmit"));
		signupBtn.click();
		Thread.sleep(2000);
		
		// submit() is used to submit a form to the server
		WebElement email = driver.findElement(By.id("email"));
//		email.submit();
//		Thread.sleep(2000);
		
		// getText() returns the inner text of an element if it contains any
		String signupText = signupBtn.getText();
		System.out.println("inner text of the sign up element is "+signupText);
		
		// getAttribute(String att_name) returns a String value which is value of the given attribute name
		String emailTypeAttValue = email.getAttribute("type");
		System.out.println("type attribute value of the email element is "+emailTypeAttValue);
		
		String signupClassAttValue = signupBtn.getAttribute("class");
		System.out.println("class attribute value of the sing up button is "+signupClassAttValue);
		
		
		// getCssValue(String prop_name) returns a String value which is value of given css property name
		String emailFontSize = email.getCssValue("font-size");
		System.out.println("font size of email text field is "+emailFontSize);
		
		String signBtnFontColor = signupBtn.getCssValue("color");
		System.out.println("text font color of the sign up button is "+signBtnFontColor);
		
		// getSize(): returns Dimension class object i.e. width and height of the given element
		Dimension size = signupBtn.getSize();
		System.out.println("sign button width is "+size.getWidth()+" and height is "+size.getHeight());
		
		// getLocation() returns Point class object i.e. x and y coordinate values of the given element
		Point location = signupBtn.getLocation();
		System.out.println("sign up button is at x = "+location.getX()+" and at y = "+location.getY());
		
		// getTagName() returns tag name of the given element
		String emailTagName = email.getTagName();
		System.out.println("tag name of the email text field is "+emailTagName);
		
		// isDispalyed() returns true if given element is visible on the web page
		boolean reenterEmailIsDisplayed = driver.findElement(By.name("reg_email_confirmation__")).isDisplayed();
		System.out.println("reenter email address field is displayed "+reenterEmailIsDisplayed);
		
		// isEnabled() return true if given element is in enable state
		boolean firstNameIsEnabled = firstName.isEnabled();
		System.out.println("first name element is enabled "+firstNameIsEnabled);
		
		// isSelected() returns true if a given radio button, check box is selected
		boolean femaleRadioBtnSelected = driver.findElement(By.cssSelector("input[value = '1']")).isSelected();
		System.out.println("female radio button is selected "+femaleRadioBtnSelected );
		
		driver.close();
		
		
	}

}
