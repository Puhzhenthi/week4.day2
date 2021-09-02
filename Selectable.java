package week4.day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement item1 = driver.findElement(By.xpath("//ol[@id='selectable']/li"));
		WebElement item6 =driver.findElement(By.xpath("//ol[@id='selectable']/li[6]"));
		Actions builder= new Actions(driver);
		builder.clickAndHold(item1).moveToElement(item6).release().perform();
		Thread.sleep(2000);
		
		
		
	}

}
