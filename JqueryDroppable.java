package week4.day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDroppable {

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement drg1 = driver.findElement(By.id("draggable"));
		WebElement drp1 = driver.findElement(By.id("droppable"));
		builder.dragAndDrop(drg1, drp1).perform();
		System.out.println(drp1.getText());

	}

}
