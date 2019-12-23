package sikuli;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utitlities.BrowserHelper;
/*
 * Sikuli is used to automate windows based screens using visual image match technology
 * whatever the elements we want to automate capture those elements as images with .png
 * Sikuli mainly contains only two classes
 * Pattern : is used to store elements as images with path of the image file
 * Screen: is used to perform actions on the elements
 */
public class SikiliDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://smallpdf.com/word-to-pdf");
		driver.findElement(By.xpath("//div[text()='Choose file']")).click();
		// create a pattern class object for every element image we captured
		Pattern fileName = new Pattern(getFilePath("images", "filename.PNG"));
		Pattern openButton = new Pattern(getFilePath("images", "open.PNG"));
		// create Screen class objects
		Screen screen = new Screen();
		try {
			screen.find(fileName);
			screen.type(fileName, "E:\\selenium\\extended selenium syllabus.doc");
			sleep(2000);
			screen.find(openButton);
			screen.click(openButton);
			sleep(2000);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeBrowser();
	}

}
