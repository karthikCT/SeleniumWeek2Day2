package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignUp {

	public static void main(String[] args) {
		
		//Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("https://en-gb.facebook.com");
		
		//Maximise the window
		driver.manage().window().maximize();
		
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
		
		//Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Karthikeyan");
		
		//Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("C T");
		
		//Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9876543210");
		
		//Enterthe password
		driver.findElement(By.id("password_step_input")).sendKeys("godgod");
		
		//Handle all the three drop downs
		WebElement day = driver.findElement(By.id("day"));
		Select d = new Select(day);
		d.selectByIndex(15);
		
		WebElement month = driver.findElement(By.id("month"));
		Select m = new Select(month);
		m.selectByIndex(6);
		
		WebElement year = driver.findElement(By.id("year"));
		Select y = new Select(year);
		y.selectByValue("1980");
		
		//Select the radio button "Female" 
		driver.findElement(By.xpath("//label[text() = 'Female']")).click();		
		
		driver.close();

	}

}
