package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingTechniques {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();

		/*
		 * To locate an elmenet or elements in a web page, WebDriver interface provides
		 * two methods.
		 * 
		 * findElement(By arg): returns a WebElement reference this method will locate
		 * an element in the current web page based on the locating technique we
		 * specified using 'By' class and stores in a WebElement reference. If no
		 * element is present in the page with locating technique then this method will
		 * throw NoSuchElementException
		 * 
		 * findElements(By arg) returns a java.util.List of WebElement type this method
		 * will locate either zero or more elements in the current web page based on the
		 * locating technique we specified using 'By' class and store in
		 * List<WebElement>. if no element is present in the page with locating
		 * technique then this method will return a List of size 0.
		 * 
		 * By class provides several methods to locate an element. All these methods
		 * accepts string argument and returns a By class reference
		 */

		// id(String arg) : is used to locate an element using id attribute
		By emailLoc = By.id("email");
		WebElement emailEle = driver.findElement(emailLoc);
//		WebElement emailEle = driver.findElement(By.id("email"));

		// name(String arg) : is used to locate an element using name attribute
		By firstNameLoc = By.name("firstname");
		WebElement firstNameEle = driver.findElement(firstNameLoc);

		// linkText(String arg) : is used to locate an element using link text
		// link text is an inner text of the <a> tag

		By termsLoc = By.linkText("Terms");
		WebElement termsLink = driver.findElement(termsLoc);

		// partialLinkText(String arg): is used to locate an element using part of the
		// link text
		By forgottenPwdLoc = By.partialLinkText("Forgotten");
		WebElement forgottenPwdLink = driver.findElement(forgottenPwdLoc);

		// cssSelector(String arg) : is used to locate an element using any attribute
		// value
		// syntax : tagName[att_name = 'att_value']
		By femaleRadioLoc = By.cssSelector("input[value='1']");
		WebElement femaleRadioEle = driver.findElement(femaleRadioLoc);

		// xpath(String arg): is used to locate an element using any attribute value
		// syntax: //tagName[@att_name = 'arr_value']
		By maleRadioLoc = By.xpath("//input[@value='2']");
		WebElement maleRadioEle = driver.findElement(maleRadioLoc);

		// className(String arg): is used to locate one or more elements with any one
		// class name
		// in general class attribute contains multiple class names, we have to use only
		// one class name in className()
		By textFieldsLoc = By.className("inputtext");
		List<WebElement> textFields = driver.findElements(textFieldsLoc);
		System.out.println("number of text fields = " + textFields.size());

		// tagName(String arg); is used to locate one or more elements with matching tag
		// name
		By linksLoc = By.tagName("a");
		List<WebElement> links = driver.findElements(linksLoc);
		System.out.println("number of links = " + links.size());

		driver.close();
	}

}
