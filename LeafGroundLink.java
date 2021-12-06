package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLink {

	public static void main(String[] args) {
		
//Setup		
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leafground.com/pages/Link.html");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//Go to Home Page
driver.findElement(By.linkText("Go to Home Page")).click();

//Find where am supposed to go without clicking me?
driver.findElement(By.linkText("HyperLink")).click();
System.out.println(driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href"));

//Verify am I broken?
driver.findElement(By.linkText("Verify am I broken?")).click();
String title = driver.getTitle();
if  (title.contains("HTTP Status 404 – Not Found"))
{ System.out.println("The Link is Broken");
}
else 
	System.out.println("The link is working");

driver.navigate().back();

//Go to Home Page (Interact with same link name)
driver.findElement(By.linkText("Go to Home Page")).click();
driver.navigate().back();

//How many links are available in this page?
System.out.println(driver.findElements(By.tagName("a")).size());

driver.close();

	}

}
