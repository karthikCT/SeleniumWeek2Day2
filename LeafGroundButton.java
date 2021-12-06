package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {

	public static void main(String[] args) {
		
//Setup		
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leafground.com/pages/Button.html");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//Click button to travel home page
driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
driver.navigate().back();

//driver.findElement(By.xpath("//h5[text()='Button']")).click();

//Find position of button (x,y)
System.out.println(driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation());

//Find button color
System.out.println(driver.findElement(By.id("color")).getAttribute("style"));

//Find the height and width
System.out.println(driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize());

driver.close();

	}

}
