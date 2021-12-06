package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {

	public static void main(String[] args) {

//Setup
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leafground.com/pages/Edit.html");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//Enter your email address
driver.findElement(By.id("email")).sendKeys("test@testleaf.com");

//Append a text and press keyboard tab
driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Test", Keys.TAB);

//Get default text entered
System.out.println(driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value"));

//Clear the text
driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();

//Confirm that edit field is disabled
System.out.println(driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input")).isEnabled());

driver.close();

	}

}
