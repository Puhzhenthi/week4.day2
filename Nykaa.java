package week4.day2.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// mouse over
		WebElement bnd = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(bnd).perform();
		WebElement plr = driver.findElement(By.xpath("//a[text()='Popular']"));
		builder.moveToElement(plr).perform();
// click L'oreal 
		driver.findElement(By.xpath("//div[@id='brandCont_Popular']//li[5]/a")).click();
//check title
		Set<String> handle1 = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(handle1);
		driver.switchTo().window(lst.get(1));
		String title1 = driver.getTitle();
		if (title1.contains("L'Oreal Paris")) {
			System.out.println("Title is L'Oreal Paris");
		} else {
			System.out.println("Title is Wrong");
		}
//sort by and top rated		
		JavascriptExecutor pg = (JavascriptExecutor) driver;
		pg.executeScript("window.scrollBy(0, 350)");
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		// driver.findElement(By.xpath("//span[text()='customer top rated'")).click();

		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		String fv = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
		if (fv.contains("Shampoo")) {
			System.out.println("Filterd is Shampoo");
		} else {
			System.out.println("Filtered is not a Shampoo");
		}
		
		driver.findElement(By.xpath("//div[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(5000);
		JavascriptExecutor pk1 = (JavascriptExecutor) driver;
		pk1.executeScript("window.scrollBy(0, 350)");
		WebElement addbag = driver.findElement(By.xpath(
				"//button[@class='primary-btn nk-btn combo-add-to-btn  atc-simple m-content__product-list__cart-btn  ']"));
		WebElement obj = driver.findElement(By.xpath("//div[@class='product-list-box card desktop-cart']"));

		Actions builder1 = new Actions(driver);
		builder1.moveToElement(obj).perform();
		addbag.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(2000);

	}

}
