package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//Launch URL "http://leaftaps.com/opentaps/control/login"		
driver.get("http://leaftaps.com/opentaps");

//Enter UserName and Password Using Id Locator
driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");

//Click on Login Button using Class Locator
driver.findElement(By.className("decorativeSubmit")).click();

//Click on CRM/SFA Link
driver.findElement(By.linkText("CRM/SFA")).click();

//Click on contacts Button
driver.findElement(By.linkText("Contacts")).click();

//Click on Create Contact
driver.findElement(By.linkText("Create Contact")).click();

//Enter FirstName Field
driver.findElement(By.id("firstNameField")).sendKeys("Karthikeyan");

//Enter LastName Field
driver.findElement(By.id("lastNameField")).sendKeys("C T");

//Enter FirstName(Local)
driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("firstName");

driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("lastName");
driver.findElement(By.id("createContactForm_personalTitle")).sendKeys("personalTitle");
driver.findElement(By.id("createContactForm_birthDate")).sendKeys("07/16/80");
driver.findElement(By.id("createContactForm_generalProfTitle")).sendKeys("generalProfTitle");
driver.findElement(By.id("createContactForm_departmentName")).sendKeys("departmentName");

WebElement curr = driver.findElement(By.id("createContactForm_preferredCurrencyUomId"));
Select cu = new Select(curr);
cu.selectByValue("USD");

driver.findElement(By.id("createContactForm_description")).sendKeys("Its my first contact");
driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("babu@testleaf.com");
driver.findElement(By.xpath("//option[@value='NY']")).click();
driver.findElement(By.name("submitButton")).click();
driver.findElement(By.linkText("Edit")).click();
driver.findElement(By.id("updateContactForm_description")).clear();
driver.findElement(By.name("importantNote")).sendKeys("Its very important");
driver.findElement(By.xpath("//input[@name='submitButton']")).click();

System.out.println("Title of Resulting Page is " +driver.getTitle());

driver.close();
	}

}
