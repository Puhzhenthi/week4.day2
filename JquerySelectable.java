package week4.day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySelectable {

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement im1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement im5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		builder.clickAndHold(im1).moveToElement(im5).release().perform();
		driver.switchTo().defaultContent();

	}

}
