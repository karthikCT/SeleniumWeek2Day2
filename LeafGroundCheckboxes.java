package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckboxes {

	public static void main(String[] args) {
		
//Setup	
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leafground.com/pages/checkbox.html");

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//Select the languages that you know?
driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[1]")).click();
driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[2]")).click();

// Confirm Selenium is checked
boolean isEnabled = driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[6]")).isEnabled();
System.out.println("Confirm Selenium is checked " +isEnabled);

//DeSelect only checked
WebElement uncheck = driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[8]"));
uncheck.click();

//Select all below checkboxes
driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[9]")).click();
driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[10]")).click();
driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[11]")).click();
driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[12]")).click();
driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[13]")).click();
	
driver.close();
	}

}
