package week2.day2;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImages {

	public static void main(String[] args) {
		
//Setup
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leafground.com/pages/Image.html");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//Click on this image to go home page
driver.findElement(By.xpath("//label[text()='Click on this image to go home page']//following-sibling::img")).click();
System.out.println(driver.getTitle());
driver.navigate().back();

//Am I Broken Image?
WebElement image1 = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']//following-sibling::img"));
String l = image1.getAttribute("src");
driver.get(l);
if (driver.getTitle().contains("HTTP Status 404 – Not Found"))
{
	System.out.println("Image is Broken");
}
driver.close();
	}

}
