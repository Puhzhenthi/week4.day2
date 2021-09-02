package week4.day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {

	public static void main(String[] args) {
		
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dragg = driver.findElement(By.id("draggable"));
		System.out.println(dragg.getText());
		WebElement dropp = driver.findElement(By.id("droppable"));
		System.out.println(dropp.getText());
		Actions builder=new Actions(driver);
		builder.dragAndDrop(dragg, dropp).perform();
		System.out.println(dropp.getText());
		
		
		
		
		
		
		
		
		
		

	}

}
