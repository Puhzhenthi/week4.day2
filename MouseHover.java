package week4.day2.Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		WebElement ele1= driver.findElementByLinkText("TestLeaf Courses");
		Actions builder = new Actions(driver);
		builder.moveToElement(ele1).perform();
		String t1 = driver.findElementByLinkText("Selenium").getText();
		String t2 = driver.findElementByLinkText("RPA").getText();
		String t3 = driver.findElementByLinkText("WebServices").getText();
		System.out.println("THE TEST LEAF COUSRES ARE");
		driver.findElementByLinkText("Selenium").click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	}

}
