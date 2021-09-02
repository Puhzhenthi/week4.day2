package week4.day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop {

	public static void main(String[] args) {

		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement one = driver.findElement(By.xpath("//div[@id='content']"));
		Point P = one.getLocation();
		int x = (P.getX());
		int y = (P.getY());
		Actions builder = new Actions(driver);
		WebElement drag1 = driver.findElement(By.id("draggable"));
		builder.dragAndDropBy(drag1, x, y).perform();

	}

}
