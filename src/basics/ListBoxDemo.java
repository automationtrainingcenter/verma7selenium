package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBoxDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate fruits list box
		WebElement fruitsEle = driver.findElement(By.id("multiple-select-example"));

		// create a Select class object
		Select fruitsSelect = new Select(fruitsEle);

		// verify fruits list box allows multiple selection or not
		if (fruitsSelect.isMultiple()) {
			// select an option based on index
			fruitsSelect.selectByIndex(1);
			Thread.sleep(2000);

			// select an option based on value
			fruitsSelect.selectByValue("peach");
			Thread.sleep(2000);

			// retrieve all the selected options using getAllSelectedOptions()
			List<WebElement> allSelectedOptions = fruitsSelect.getAllSelectedOptions();
			for (WebElement option : allSelectedOptions) {
				System.out.println(option.getText());
			}

			// select an option based on visible text i.e. inner text of option tag
			fruitsSelect.selectByVisibleText("Apple");
			Thread.sleep(2000);
			
			// deselect all the selected options
//			fruitsSelect.deselectAll();
//			Thread.sleep(2000);
			
			// deselect an option based on index number
			fruitsSelect.deselectByIndex(2); // Orange
			Thread.sleep(2000);

			
			// deselect an option based on value attribute value
			fruitsSelect.deselectByValue("apple");
			Thread.sleep(2000);
			
			// deselect an option based on visible text
			fruitsSelect.deselectByVisibleText("Orange");
			Thread.sleep(2000);
			
		} else {
			System.out.println("fruits select does not support multiple selection");
		}

		driver.close();
	}

}
