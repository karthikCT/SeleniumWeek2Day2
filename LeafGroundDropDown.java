package week2.day2;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropDown {

	public static void main(String[] args) {
		
//Setup
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leafground.com/pages/Dropdown.html");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//Select training program using Index
WebElement dropdown1 = driver.findElement(By.id("dropdown1"));
Select dd1 = new Select(dropdown1);
dd1.selectByIndex(1);

//Select training program using Text
WebElement dropdown2 = driver.findElement(By.name("dropdown2"));
Select dd2 = new Select(dropdown2);
dd2.selectByVisibleText("Appium");

//Select training program using Value
WebElement dropdown3 = driver.findElement(By.id("dropdown3"));
Select dd3 = new Select(dropdown3);
dd3.selectByValue("4");

//Get the number of dropdown options
int d = driver.findElements(By.xpath("//select[@class='dropdown']/option")).size();
System.out.println(d);

//SendKeys to Select
driver.findElement(By.xpath("(//div[@class='example']/select)[5]")).sendKeys(Keys.DOWN, Keys.DOWN);

//Multiple Select using SendKeys
driver.findElement(By.xpath("(//div[@class='example']/select)[6]")).sendKeys(Keys.DOWN, Keys.SHIFT, Keys.DOWN, Keys.DOWN);

driver.close();
	}

}
