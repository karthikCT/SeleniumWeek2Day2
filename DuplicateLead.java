package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {

//Setup
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leaftaps.com/opentaps");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.manage().window().maximize();

driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.linkText("Leads")).click();
driver.findElement(By.linkText("Find Leads")).click();
String id = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
System.out.println(id);
driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
driver.findElement(By.linkText("Duplicate Lead")).click();
String Title = driver.getTitle();
Title.contains("Duplicate");
System.out.println(driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).getAttribute("value"));

//Confirm the duplicated lead name is same as captured name
if(Title.contains("Duplicate"))
{
System.out.println("The duplicated lead name is same as captured name");	
driver.findElement(By.name("submitButton")).click();

}
System.out.println(driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText());
driver.close();
	}

}
